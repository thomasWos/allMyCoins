package com.allmycoins.balance.okex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.allmycoins.json.BalanceJson;

public class BuildOkexSpotBalances {

	private static final Predicate<OkexSpotAccountJson> VALID_CURRENCY = s -> !s.getCurrency()
			.equalsIgnoreCase("DOTOLD");

	private static final Predicate<OkexSpotAccountJson> QTY_PREDICATE = s -> s.getBalance() > 0.001;

	public static List<BalanceJson> build(OkexSpotAccountJson[] okexSpotAccountsJson) {
		return Arrays.stream(okexSpotAccountsJson).filter(VALID_CURRENCY.and(QTY_PREDICATE))
				.map(BuildOkexSpotBalances::build).collect(Collectors.toList());
	}

	private static BalanceJson build(OkexSpotAccountJson okexSpotAccountJson) {
		String currency = okexSpotAccountJson.getCurrency();
		float qty = okexSpotAccountJson.getBalance();
		return new BalanceJson(currency, qty, "OKEX");
	}

}
