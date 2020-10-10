package com.allmycoins.datatype;

public enum Currency {
	USD("usd"), EUR("eur"), AUD("aud");

	private String symbol;

	public final String getSymbol() {
		return symbol;
	}

	private Currency(final String pSymbol) {
		symbol = pSymbol;
	}
}
