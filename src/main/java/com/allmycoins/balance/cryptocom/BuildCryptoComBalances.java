package com.allmycoins.balance.cryptocom;

import java.util.List;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;

public class BuildCryptoComBalances {

	public static final List<BalanceJson> build(CryptoComAccountSummaryJson accountSummaryJson) {
		return accountSummaryJson.getResult().getAccounts().stream().filter(a -> a.getBalance() > 0)
				.map(BuildCryptoComBalances::balance).collect(Collectors.toList());
	}

	private static BalanceJson balance(CryptoComAccountJson accountJson) {
		return new BalanceJson(accountJson.getCurrency(), accountJson.getBalance(), "Crypto.com");

	}

}
