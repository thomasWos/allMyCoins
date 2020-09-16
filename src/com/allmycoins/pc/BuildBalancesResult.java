package com.allmycoins.pc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalancesResult;
import com.allmycoins.json.BalanceJson;

public final class BuildBalancesResult {

	public static BalancesResult build(List<BalanceJson> allMyCoins, Map<String, Float> pricesMap) {

		Map<String, BalanceJson> mergeMap = allMyCoins.stream()
				.collect(Collectors.toMap(BalanceJson::getAsset, f -> f, BuildBalancesResult::mergeBalances));

		List<BalanceJson> mergedBalancesJson = mergeMap.values().stream().collect(Collectors.toList());
		List<Balance> balances = mergedBalancesJson.stream().map(bj -> toBalance(bj, pricesMap))
				.collect(Collectors.toList());

		float total = balances.stream().map(Balance::getUsd).reduce(0.0f, (a, b) -> a + b);

		return BalancesResult.builder().balances(balances).totalUsd(total).build();
	}

	private static BalanceJson mergeBalances(BalanceJson b1, BalanceJson b2) {
		return new BalanceJson(b1.getAsset(), b1.getQty() + b2.getQty(), b1.getSrc() + ", " + b2.getSrc());
	}

	private static Balance toBalance(BalanceJson balanceJson, Map<String, Float> pricesMap) {
		float usd = pricesMap.getOrDefault(balanceJson.getAsset(), 0.0f) * balanceJson.getQty();
		return new Balance(balanceJson.getAsset(), balanceJson.getQty(), usd, balanceJson.getSrc());
	}

}
