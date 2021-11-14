package com.allmycoins.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

final class TableConsoleTest {

	@Test
	void testToString() {
		TableConsole tableConsole = new TableConsole(List.of("Asset", "Qty", "Balance", "From"));
		tableConsole.addRow(List.of("BTC", "1.32", "24460.57 USD", "Binance, Trust wallet"));
		tableConsole.addRow(List.of("ETH", "40.41", "20458.96 USD", "ETH, Binance, Coinspot, Defi"));
		tableConsole.addRow(List.of("AVAX", "5376.11", "20321.71 USD", "Binance, Avalanche"));

		StringBuilder strExpectation = new StringBuilder();
		strExpectation.append(System.lineSeparator());
		strExpectation.append("Asset |     Qty |      Balance |                         From");
		strExpectation.append(System.lineSeparator());
		strExpectation.append("-------------------------------------------------------------");
		strExpectation.append(System.lineSeparator());
		strExpectation.append("  BTC |    1.32 | 24460.57 USD |        Binance, Trust wallet");
		strExpectation.append(System.lineSeparator());
		strExpectation.append("  ETH |   40.41 | 20458.96 USD | ETH, Binance, Coinspot, Defi");
		strExpectation.append(System.lineSeparator());
		strExpectation.append(" AVAX | 5376.11 | 20321.71 USD |           Binance, Avalanche");
		strExpectation.append(System.lineSeparator());

		assertEquals(strExpectation.toString(), tableConsole.toString());
	}

}
