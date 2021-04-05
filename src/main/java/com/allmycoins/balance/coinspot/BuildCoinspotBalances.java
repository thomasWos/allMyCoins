package com.allmycoins.balance.coinspot;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.allmycoins.json.BalanceJson;

public final class BuildCoinspotBalances {

	public static final List<BalanceJson> build(CoinspotBalancesJson coinspotBalancesJson) {

		return coinspotBalancesJson.getBalances().stream().map(m -> m.entrySet().iterator().next())
				.filter(e -> !e.getKey().equals("AUD")).map(e -> balance(e.getKey(), e.getValue())).collect(toList());
	}

	private static BalanceJson balance(String symbol, CoinspotBalanceJson coinspotBalanceJson) {
		return new BalanceJson(symbol, coinspotBalanceJson.getBalance(), "Coinspot");
	}
}
