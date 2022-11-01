package com.allmycoins.presentation;

import java.util.List;

import com.allmycoins.datatype.Asset;
import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalancesResult;

public final class Console {

	public static void display(final BalancesResult balancesResult, final String pCurrency) {
		String currency = pCurrency.toUpperCase();

		TableConsole tableConsole = new TableConsole(List.of("Asset", "Qty", "Balance", "%", "Rank", "From"));
		balancesResult.getAssets().stream().sorted(Asset.ASSET_COMP).filter(Asset.ASSET_NOT_WORTH_ZERO)
				.forEach(b -> addTableRow(b, currency, tableConsole));

		System.out.println(tableConsole.toString());
		System.out.println("Total: " + String.format("%.2f", balancesResult.getTotalCurrency()) + " " + currency);
	}

	private static void addTableRow(final Asset asset, final String currency, TableConsole tableConsole) {
		Balance balance = asset.getBalance();
		String qty = String.format("%.3f", balance.getQuantity());
		String balanceFormated = String.format("%1$.2f %2$s", balance.getCurrencyValue(), currency);
		String ratio = String.format("%.2f", asset.getRatio() * 100);
		String marketCapRank = asset.getMarketCapRank() > 0 ? String.valueOf(asset.getMarketCapRank()) : "-";
		tableConsole
				.addRow(List.of(balance.getAsset(), qty, balanceFormated, ratio, marketCapRank, balance.getSource()));
	}
}
