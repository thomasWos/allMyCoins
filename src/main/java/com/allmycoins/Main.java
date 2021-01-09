package com.allmycoins;

import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.allmycoins.balance.AlgorandProvider;
import com.allmycoins.balance.BalanceProvider;
import com.allmycoins.balance.BinanceProvider;
import com.allmycoins.balance.BitcoinProvider;
import com.allmycoins.balance.CoinspotProvider;
import com.allmycoins.balance.CosmosProvider;
import com.allmycoins.balance.CryptocomProvider;
import com.allmycoins.balance.ElrondProvider;
import com.allmycoins.balance.EthProvider;
import com.allmycoins.balance.HarmonyProvider;
import com.allmycoins.balance.OkexProvider;
import com.allmycoins.balance.SwyftxProvider;
import com.allmycoins.balance.TezosProvider;
import com.allmycoins.datatype.BalancesResult;
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

		// Coingecko
		final String currency = PrivateConfig.get("CURRENCY").orElseGet(() -> "USD").toLowerCase();
		Future<CoingeckoMarketJson[]> coingeckoMarketJsonF = RequestUtils
				.sendRequestFuture(new CoingeckoMarketsRequest(currency));

		// All coins list
		Future<CoingeckoCoinListJson[]> coinslistJsonF = RequestUtils
				.sendRequestFuture(new CoingeckoCoinsListRequest());

		List<BalanceProvider> balanceProviders = List.of(new EthProvider(), new BinanceProvider(),
				new CoinspotProvider(), new CryptocomProvider(), new ElrondProvider(), new OkexProvider(),
				new SwyftxProvider(), new HarmonyProvider(), new AlgorandProvider(), new CosmosProvider(),
				new TezosProvider(), new BitcoinProvider());

		List<Future<List<BalanceJson>>> balanceFutures = FutureUtils.runAllCallables(balanceProviders);

		List<BalanceJson> allMyCoins = new ArrayList<>();
		balanceFutures.forEach(f -> allMyCoins.addAll(FutureUtils.futureResult(f)));

		File file = new File("myCoinsManu.json");
		if (file.exists()) {
			BalanceManuJson[] balancesManuTab = JacksonUtils.deserialize(file, BalanceManuJson[].class);
			List<BalanceJson> balancesManuList = Arrays.stream(balancesManuTab)
					.map(b -> new BalanceJson(b.getAsset(), b.getQty(), b.getSrc())).collect(Collectors.toList());
			allMyCoins.addAll(balancesManuList);
		}

		Set<String> myAssets = allMyCoins.stream().map(BalanceJson::getAsset).collect(Collectors.toSet());

		CoingeckoMarketJson[] coingeckoMarketsJson = FutureUtils.futureResult(coingeckoMarketJsonF);
		Map<String, Float> pricesMap = Arrays.stream(coingeckoMarketsJson)
				.collect(toMap(cm -> cm.getSymbol().toUpperCase(), CoingeckoMarketJson::getCurrent_price));

		Set<String> missingCoins = myAssets.stream().filter(asset -> !pricesMap.containsKey(asset))
				.collect(Collectors.toSet());
		if (!missingCoins.isEmpty()) {
			// Some coins have the same symbol, override with the last inserted.
			Map<String, String> symbolToIdMap = Arrays.stream(FutureUtils.futureResult(coinslistJsonF))
					.collect(toMap(c -> c.getSymbol().toUpperCase(), CoingeckoCoinListJson::getId, (s1, s2) -> s2));

			Map<String, String> idToSymbolMap = symbolToIdMap.entrySet().stream()
					.collect(Collectors.toMap(Entry::getValue, Entry::getKey));

			Set<String> missingIds = missingCoins.stream().filter(symbolToIdMap::containsKey).map(symbolToIdMap::get)
					.collect(Collectors.toSet());

			CoingeckoPricesJson coingeckoPricesJson = RequestUtils
					.sendRequest(new CoingeckoSimplePriceRequest(missingIds, currency));

			Map<String, Float> missingPrices = coingeckoPricesJson.getPrices().entrySet().stream().collect(
					Collectors.toMap(e -> idToSymbolMap.get(e.getKey()), e -> e.getValue().getPrices().get(currency)));

			pricesMap.putAll(missingPrices);
		}

		BalancesResult balancesResult = BuildBalancesResult.build(allMyCoins, pricesMap);
		Console.display(balancesResult, currency);
	}

}
