package com.allmycoins.balance.binance;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.allmycoins.json.BalanceJson;

public final class BuildBinanceBalances {

	public static List<BalanceJson> build(BinanceAccountJson accountJson) {
		return accountJson.getBalances().stream().filter(BinanceBalanceJson::isPositive)
				.map(BuildBinanceBalances::buildBalance).collect(toList());
	}

	private static BalanceJson buildBalance(BinanceBalanceJson balanceJson) {
		return new BalanceJson(balanceJson.getAsset(), balanceJson.getFree() + balanceJson.getLocked(), "Binance");
	}

}
