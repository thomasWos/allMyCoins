package com.allmycoins;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.allmycoins.balance.AlgorandProvider;
import com.allmycoins.balance.BalanceProvider;
import com.allmycoins.balance.BinanceProvider;
import com.allmycoins.balance.BitcoinProvider;
import com.allmycoins.balance.BscProvider;
import com.allmycoins.balance.CoinspotProvider;
import com.allmycoins.balance.CosmosProvider;
import com.allmycoins.balance.CryptocomProvider;
import com.allmycoins.balance.ElrondProvider;
import com.allmycoins.balance.EthProvider;
import com.allmycoins.balance.HarmonyProvider;
import com.allmycoins.balance.OkexProvider;
import com.allmycoins.balance.SolanaProvider;
import com.allmycoins.balance.SwyftxProvider;
import com.allmycoins.balance.TezosProvider;
import com.allmycoins.datatype.BalancesResult;
import com.allmycoins.datatype.CoingeckoMarket;
import com.allmycoins.exception.AllMyCoinsException;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.coingecko.CoingeckoCoinListJson;
import com.allmycoins.json.coingecko.CoingeckoMarketJson;
import com.allmycoins.json.coingecko.CoingeckoPricesJson;
import com.allmycoins.json.manu.BalanceManuJson;
import com.allmycoins.pc.BuildBalancesResult;
import com.allmycoins.presentation.Console;
import com.allmycoins.request.coingecko.CoingeckoCoinsListRequest;
import com.allmycoins.request.coingecko.CoingeckoMarketsRequest;
import com.allmycoins.request.coingecko.CoingeckoSimplePriceRequest;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.JacksonUtils;
import com.allmycoins.utils.RequestUtils;

public class Main {

	static {
		final InputStream inputStream = Main.class.getResourceAsStream("/logging.properties");
		try {
			LogManager.getLogManager().readConfiguration(inputStream);
		} catch (final IOException e) {
			Logger.getAnonymousLogger().severe("Could not load default logging.properties file");
			Logger.getAnonymousLogger().severe(e.getMessage());
		}
	}

	public static void main(String[] args) {
		PrivateConfig.loadConfiguration();

		// Coingecko - Top 250 coins
		final String currency = PrivateConfig.get("CURRENCY").orElseGet(() -> "USD").toLowerCase();
		Future<CoingeckoMarketJson[]> coingeckoMarketJsonF = RequestUtils
				.sendRequestFuture(new CoingeckoMarketsRequest(currency));

		// All coins list
		Future<CoingeckoCoinListJson[]> coinslistJsonF = RequestUtils
				.sendRequestFuture(new CoingeckoCoinsListRequest());

		List<BalanceProvider> balanceProviders = List.of(new EthProvider(), new BinanceProvider(),
				new CoinspotProvider(), new CryptocomProvider(), new ElrondProvider(), new OkexProvider(),
				new SwyftxProvider(), new HarmonyProvider(), new AlgorandProvider(), new CosmosProvider(),
				new TezosProvider(), new BitcoinProvider(), new SolanaProvider(), new BscProvider());

		List<BalanceJson> allMyCoins = new ArrayList<>();
		List<AllMyCoinsException> errors = new ArrayList<>();

		handleProviderRequests(balanceProviders, allMyCoins, errors);

		allMyCoins.addAll(coinsFromFile("myCoinsManu.json"));

		Set<String> toIgnore = coinsFromFile("myCoinsIgnore.json").stream().map(b -> b.getAsset() + b.getSrc())
				.collect(toSet());
		allMyCoins.removeIf(b -> toIgnore.contains(b.getAsset() + b.getSrc()));

		Set<String> myAssets = allMyCoins.stream().map(BalanceJson::getAsset).collect(Collectors.toSet());

		CoingeckoMarketJson[] coingeckoMarketsJson = FutureUtils.futureResult(coingeckoMarketJsonF);

		List<CoingeckoMarket> marketList = Arrays.stream(coingeckoMarketsJson)
				.map(e -> new CoingeckoMarket(e.getSymbol(), e.getCurrent_price(), e.getMarket_cap_rank()))
				.collect(toList());

		Map<String, CoingeckoMarket> marketMap = marketList.stream()
				.collect(toMap(e -> e.getSymbol().toUpperCase(), Function.identity(), (e1, e2) -> e1));

		Set<String> missingCoins = myAssets.stream().filter(asset -> !marketMap.containsKey(asset)).collect(toSet());
		if (!missingCoins.isEmpty()) {
			// Some coins have the same symbol, override with the last inserted.
			Map<String, String> symbolToIdMap = Arrays.stream(FutureUtils.futureResult(coinslistJsonF))
					.collect(toMap(c -> c.getSymbol().toUpperCase(), CoingeckoCoinListJson::getId, (s1, s2) -> s2));

			Map<String, String> idToSymbolMap = symbolToIdMap.entrySet().stream()
					.collect(toMap(Entry::getValue, Entry::getKey));

			Set<String> missingIds = missingCoins.stream().filter(symbolToIdMap::containsKey).map(symbolToIdMap::get)
					.collect(toSet());

			CoingeckoPricesJson coingeckoPricesJson = RequestUtils
					.sendRequest(new CoingeckoSimplePriceRequest(missingIds, currency));

			Map<String, CoingeckoMarket> missingMarkets = coingeckoPricesJson.getPrices().entrySet().stream().collect(
					toMap(e -> idToSymbolMap.get(e.getKey()), e -> new CoingeckoMarket(idToSymbolMap.get(e.getKey()),
							e.getValue().getPrices().get(currency), -1)));

			marketMap.putAll(missingMarkets);
		}

		BalancesResult balancesResult = BuildBalancesResult.build(allMyCoins, marketMap);
		Console.display(balancesResult, currency);

		errors.forEach(e -> System.out.println(e.getMessage()));
	}

	private static List<BalanceJson> coinsFromFile(String fileName) {
		List<BalanceJson> balanceJsonList = Collections.emptyList();
		File file = new File(fileName);
		if (file.exists()) {
			BalanceManuJson[] balancesManuTab = JacksonUtils.deserialize(file, BalanceManuJson[].class);
			balanceJsonList = Arrays.stream(balancesManuTab)
					.map(b -> new BalanceJson(b.getAsset(), b.getQty(), b.getSrc())).collect(Collectors.toList());

		}
		return balanceJsonList;
	}

	private static void handleProviderRequests(List<BalanceProvider> balanceProviders, List<BalanceJson> allMyCoins,
			List<AllMyCoinsException> errProviders) {

		List<Future<List<BalanceJson>>> balanceFutures = FutureUtils.runAllCallables(balanceProviders);
		balanceFutures.forEach(f -> {
			try {
				List<BalanceJson> futureResult = FutureUtils.futureResult(f);
				allMyCoins.addAll(futureResult);
			} catch (AllMyCoinsException e) {
				errProviders.add(e);
			}
		});
	}
}
