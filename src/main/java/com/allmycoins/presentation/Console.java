package com.allmycoins.presentation;

import java.util.Comparator;
import java.util.List;

import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalancesResult;

public final class Console {

	private static final Comparator<Balance> BALANCE_COMP = Comparator.comparing(Balance::getCurrencyValue).reversed();

	public static void display(final BalancesResult balancesResult, final String pCurrency) {
		String currency = pCurrency.toUpperCase();

		TableConsole tableConsole = new TableConsole(List.of("Asset", "Qty", "Balance", "From"));
		balancesResult.getBalances().stream().sorted(BALANCE_COMP).forEach(b -> addTableRow(b, currency, tableConsole));

		System.out.println(tableConsole.toString());
		System.out.println();
		System.out.println("Total: " + String.format("%.2f", balancesResult.getTotalCurrency()) + " " + currency);
	}

	private static void addTableRow(final Balance balance, final String currency, TableConsole tableConsole) {
		String qty = String.format("%.2f", balance.getQuantity());
		String balanceFormated = String.format("%1$.2f %2$s", balance.getCurrencyValue(), currency);
		tableConsole.addRow(List.of(balance.getAsset(), qty, balanceFormated, balance.getSource()));
	}
}
