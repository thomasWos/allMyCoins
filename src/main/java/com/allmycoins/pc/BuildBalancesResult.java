package com.allmycoins.pc;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalanceMerge;
import com.allmycoins.datatype.BalancesResult;
import com.allmycoins.json.BalanceJson;

public final class BuildBalancesResult {

	public static BalancesResult build(List<BalanceJson> allMyCoins, Map<String, Float> pricesMap) {
		Map<String, BalanceMerge> mergeMap2 = allMyCoins.stream().map(BuildBalancesResult::toBalanceMerge)
				.collect(Collectors.toMap(BalanceMerge::getAsset, f -> f, BuildBalancesResult::mergeBalances2));

		List<BalanceMerge> mergedBalancesJson = mergeMap2.values().stream().collect(Collectors.toList());
		List<Balance> balances = mergedBalancesJson.stream().map(bj -> toBalance(bj, pricesMap))
				.collect(Collectors.toList());

		float total = balances.stream().map(Balance::getCurrencyValue).reduce(0.0f, (a, b) -> a + b);
		return BalancesResult.builder().balances(balances).totalCurrency(total).build();
	}

	private static BalanceMerge mergeBalances2(BalanceMerge b1, BalanceMerge b2) {
		HashSet<String> srcMerged = new HashSet<>(b1.getSources());
		srcMerged.addAll(b2.getSources());
		return new BalanceMerge(b1.getAsset(), b1.getQty() + b2.getQty(), srcMerged);
	}

	private static Balance toBalance(BalanceMerge balanceJson, Map<String, Float> pricesMap) {
		float usd = pricesMap.getOrDefault(balanceJson.getAsset(), 0.0f) * balanceJson.getQty();
		String src = balanceJson.getSources().stream().collect(Collectors.joining(", "));
		return new Balance(balanceJson.getAsset(), balanceJson.getQty(), usd, src);
	}

	private static BalanceMerge toBalanceMerge(BalanceJson pBalanceJson) {
		return new BalanceMerge(pBalanceJson.getAsset(), pBalanceJson.getQty(), Set.of(pBalanceJson.getSrc()));
	}
}
