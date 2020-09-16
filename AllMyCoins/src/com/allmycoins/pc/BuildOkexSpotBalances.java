package com.allmycoins.pc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.okex.OkexSpotAccountJson;

public class BuildOkexSpotBalances {

	private static final Predicate<OkexSpotAccountJson> VALID_CURRENCY = s -> !s.getCurrency()
			.equalsIgnoreCase("DOTOLD");

	public static List<BalanceJson> build(OkexSpotAccountJson[] okexSpotAccountsJson) {
		return Arrays.stream(okexSpotAccountsJson).filter(VALID_CURRENCY).map(BuildOkexSpotBalances::build)
				.collect(Collectors.toList());
	}

	private static BalanceJson build(OkexSpotAccountJson okexSpotAccountJson) {
		String currency = okexSpotAccountJson.getCurrency();
		float qty = okexSpotAccountJson.getBalance();
		return new BalanceJson(currency, qty, "OKEX");
	}

}
