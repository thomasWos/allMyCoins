package com.allmycoins.pc;

import java.util.List;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.cryptocom.CryptoComAccountJson;
import com.allmycoins.json.cryptocom.CryptoComAccountSummaryJson;

public class BuildCryptoComBalances {

	public static final List<BalanceJson> build(CryptoComAccountSummaryJson accountSummaryJson) {
		return accountSummaryJson.getResult().getAccounts().stream().filter(a -> a.getBalance() > 0)
				.map(BuildCryptoComBalances::balance).collect(Collectors.toList());
	}

	private static BalanceJson balance(CryptoComAccountJson accountJson) {
		return new BalanceJson(accountJson.getCurrency(), accountJson.getBalance(), "Crypto.com");

	}

}
