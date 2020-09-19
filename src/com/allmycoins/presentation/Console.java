package com.allmycoins.presentation;

import java.util.Comparator;

import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalancesResult;

public final class Console {

	private static final Comparator<Balance> BALANCE_COMP = Comparator.comparing(Balance::getUsd).reversed();

	public static void display(BalancesResult balancesResult) {

		System.out.println();
		System.out.println(String.format("%1$6s | %2$9s | %3$13s | %4$35s", "Asset", "Qty", "Balance", "From"));
		System.out.println("-".repeat(72));

		balancesResult.getBalances().stream().sorted(BALANCE_COMP).map(Console::displayBalanceLine)
				.forEach(System.out::println);
		System.out.println();

		System.out.println("Total: " + String.format("%.2f", balancesResult.getTotalUsd()) + " USD");

	}

	private static String displayBalanceLine(Balance balance) {
		return String.format("%1$6s | %2$ 9.2f | %3$ 9.2f USD | %4$35s", balance.getAsset(), balance.getQty(),
				balance.getUsd(), balance.getSrc());
	}
}
