package com.allmycoins;

import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.allmycoins.balance.BinanceProvider;
import com.allmycoins.balance.CoinspotProvider;
import com.allmycoins.balance.CryptocomProvider;
import com.allmycoins.balance.ElrondProvider;
import com.allmycoins.balance.EthProvider;
import com.allmycoins.balance.OkexProvider;
import com.allmycoins.balance.SwyftxProvider;
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
import com.allmycoins.utils.JacksonUtils;
import com.allmycoins.utils.RequestUtils;

public class Main {

	public static void main(String[] args) {

		PrivateConfig.loadConfiguration();

		// Coingecko
		CoingeckoMarketJson[] coingeckoMarketsJson = RequestUtils.sendRequest(new CoingeckoMarketsRequest());
		Map<String, Float> pricesMap = Arrays.stream(coingeckoMarketsJson)
				.collect(toMap(cm -> cm.getSymbol().toUpperCase(), CoingeckoMarketJson::getCurrent_price));

		// Ethereum
		List<BalanceJson> ethTokensBalances = new EthProvider().balances();

		// Binance
		List<BalanceJson> binanceBalances = new BinanceProvider().balances();

		// Coinspot
		List<BalanceJson> coinspotBalances = new CoinspotProvider().balances();

		// crypto.com - Exchanger only
		List<BalanceJson> cryptoComBalances = new CryptocomProvider().balances();

		// Elrond
		List<BalanceJson> elrondBalance = new ElrondProvider().balances();

		// OKEX
		List<BalanceJson> okexSpotBalances = new OkexProvider().balances();

		// Swyftx
		List<BalanceJson> swyftxSpotBalances = new SwyftxProvider().balances();

		List<BalanceJson> allMyCoins = new ArrayList<>();
		allMyCoins.addAll(binanceBalances);
		allMyCoins.addAll(ethTokensBalances);
		allMyCoins.addAll(coinspotBalances);
		allMyCoins.addAll(cryptoComBalances);
		allMyCoins.addAll(elrondBalance);
		allMyCoins.addAll(okexSpotBalances);
		allMyCoins.addAll(swyftxSpotBalances);

		File file = new File("myCoinsManu.json");
		if (file.exists()) {
			BalanceManuJson[] balancesManuTab = JacksonUtils.deserialize(file, BalanceManuJson[].class);
			List<BalanceJson> balancesManuList = Arrays.stream(balancesManuTab)
					.map(b -> new BalanceJson(b.getAsset(), b.getQty(), b.getSrc())).collect(Collectors.toList());
			allMyCoins.addAll(balancesManuList);
		}

		Set<String> myAssets = allMyCoins.stream().map(BalanceJson::getAsset).collect(Collectors.toSet());
		Set<String> missingCoins = myAssets.stream().filter(asset -> !pricesMap.containsKey(asset))
				.collect(Collectors.toSet());
		if (!missingCoins.isEmpty()) {

			CoingeckoCoinListJson[] coinslist = RequestUtils.sendRequest(new CoingeckoCoinsListRequest());
			// Some coins have the same symbol, override with the last inserted.
			Map<String, String> symbolToIdMap = Arrays.stream(coinslist)
					.collect(toMap(c -> c.getSymbol().toUpperCase(), CoingeckoCoinListJson::getId, (s1, s2) -> s2));

			Map<String, String> idToSymbolMap = symbolToIdMap.entrySet().stream()
					.collect(Collectors.toMap(Entry::getValue, Entry::getKey));

			Set<String> missingIds = missingCoins.stream().filter(symbolToIdMap::containsKey).map(symbolToIdMap::get)
					.collect(Collectors.toSet());

			CoingeckoPricesJson coingeckoPricesJson = RequestUtils
					.sendRequest(new CoingeckoSimplePriceRequest(missingIds));

			Map<String, Float> missingPrices = coingeckoPricesJson.getPrices().entrySet().stream()
					.collect(Collectors.toMap(e -> idToSymbolMap.get(e.getKey()), e -> e.getValue().getUsd()));

			pricesMap.putAll(missingPrices);
		}

		BalancesResult balancesResult = BuildBalancesResult.build(allMyCoins, pricesMap);

		Console.display(balancesResult);
	}
}
