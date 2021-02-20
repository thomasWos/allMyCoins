package com.allmycoins.pc;

import static java.util.stream.Collectors.toList;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.allmycoins.datatype.Asset;
import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalanceMerge;
import com.allmycoins.datatype.BalancesResult;
import com.allmycoins.datatype.CoingeckoMarket;
import com.allmycoins.json.BalanceJson;

public final class BuildBalancesResult {

	public static BalancesResult build(List<BalanceJson> allMyCoins, Map<String, CoingeckoMarket> marketMap) {
		Map<String, BalanceMerge> mergeMap = allMyCoins.stream().map(BuildBalancesResult::toBalanceMerge)
				.collect(Collectors.toMap(BalanceMerge::getAsset, f -> f, BuildBalancesResult::mergeBalances));

		List<BalanceMerge> mergedBalances = mergeMap.values().stream().collect(toList());
		List<Balance> balances = mergedBalances.stream().map(bj -> toBalance(bj, marketMap)).collect(toList());

		float total = balances.stream().map(Balance::getCurrencyValue).reduce(0.0f, (a, b) -> a + b);

		List<Asset> assets = balances.stream().map(b -> toAsset(b, total, marketMap)).collect(toList());
		return BalancesResult.builder().assets(assets).totalCurrency(total).build();
	}

	private static BalanceMerge mergeBalances(BalanceMerge b1, BalanceMerge b2) {
		HashSet<String> srcMerged = new HashSet<>(b1.getSources());
		srcMerged.addAll(b2.getSources());
		return new BalanceMerge(b1.getAsset(), b1.getQty() + b2.getQty(), srcMerged);
	}

	private static Asset toAsset(Balance balance, float total, Map<String, CoingeckoMarket> marketMap) {
		float ratio = balance.getCurrencyValue() / total;
		int marketCapRank = Optional.ofNullable(marketMap.get(balance.getAsset()))
				.map(CoingeckoMarket::getMarketCapRank).orElseGet(() -> -1);
		return new Asset(balance, ratio, marketCapRank);
	}

	private static Balance toBalance(BalanceMerge balanceJson, Map<String, CoingeckoMarket> marketMap) {
		float price = Optional.ofNullable(marketMap.get(balanceJson.getAsset())).map(CoingeckoMarket::getCurrentPrice)
				.orElseGet(() -> 0.0f);
		float usd = price * balanceJson.getQty();
		String src = balanceJson.getSources().stream().collect(Collectors.joining(", "));
		return new Balance(balanceJson.getAsset(), balanceJson.getQty(), usd, src);
	}

	private static BalanceMerge toBalanceMerge(BalanceJson pBalanceJson) {
		return new BalanceMerge(pBalanceJson.getAsset(), pBalanceJson.getQty(), Set.of(pBalanceJson.getSrc()));
	}
}
