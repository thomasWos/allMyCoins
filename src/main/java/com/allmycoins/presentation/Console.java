package com.allmycoins.presentation;

import java.util.Comparator;

import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalancesResult;

public final class Console {

	private static final Comparator<Balance> BALANCE_COMP = Comparator.comparing(Balance::getCurrencyValue).reversed();

	public static void display(final BalancesResult balancesResult, final String currency) {

		System.out.println();
		System.out.println(String.format("%1$6s | %2$9s | %3$13s | %4$35s", "Asset", "Qty", "Balance", "From"));
		System.out.println("-".repeat(72));

		balancesResult.getBalances().stream().sorted(BALANCE_COMP).map(b -> displayBalanceLine(b, currency))
				.forEach(System.out::println);
		System.out.println();

		System.out.println("Total: " + String.format("%.2f", balancesResult.getTotalCurrency()) + " " + currency);

	}

	private static String displayBalanceLine(final Balance balance, final String currency) {
		return String.format("%1$6s | %2$ 9.2f | %3$ 9.2f %4$s | %5$35s", balance.getAsset(), balance.getQuantity(),
				balance.getCurrencyValue(), currency, balance.getSource());
	}
}
