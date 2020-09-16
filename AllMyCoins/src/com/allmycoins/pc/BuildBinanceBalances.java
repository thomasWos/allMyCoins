package com.allmycoins.pc;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.binance.BinanceAccountJson;
import com.allmycoins.json.binance.BinanceBalanceJson;

public final class BuildBinanceBalances {

	public static List<BalanceJson> build(BinanceAccountJson accountJson) {
		return accountJson.getBalances().stream().filter(BinanceBalanceJson::isPositive)
				.map(BuildBinanceBalances::buildBalance).collect(toList());
	}

	private static BalanceJson buildBalance(BinanceBalanceJson balanceJson) {
		return new BalanceJson(balanceJson.getAsset(), balanceJson.getFree(), "Binance");
	}

}
