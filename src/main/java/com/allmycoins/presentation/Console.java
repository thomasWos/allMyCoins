package com.allmycoins.presentation;

import static java.util.Comparator.reverseOrder;

import java.util.Comparator;
import java.util.List;

import com.allmycoins.datatype.Asset;
import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalancesResult;

public final class Console {

	private static final Comparator<Asset> ASSET_COMP = Comparator.comparing(a -> a.getBalance().getCurrencyValue(),
			reverseOrder());

	public static void display(final BalancesResult balancesResult, final String pCurrency) {
		String currency = pCurrency.toUpperCase();

		TableConsole tableConsole = new TableConsole(List.of("Asset", "Qty", "Balance", "%", "From"));
		balancesResult.getAssets().stream().sorted(ASSET_COMP).forEach(b -> addTableRow(b, currency, tableConsole));

		System.out.println(tableConsole.toString());
		System.out.println("Total: " + String.format("%.2f", balancesResult.getTotalCurrency()) + " " + currency);
	}

	private static void addTableRow(final Asset asset, final String currency, TableConsole tableConsole) {
		Balance balance = asset.getBalance();
		String qty = String.format("%.2f", balance.getQuantity());
		String balanceFormated = String.format("%1$.2f %2$s", balance.getCurrencyValue(), currency);
		String ratio = String.format("%.2f", asset.getRatio() * 100);
		tableConsole.addRow(List.of(balance.getAsset(), qty, balanceFormated, ratio, balance.getSource()));
	}
}
