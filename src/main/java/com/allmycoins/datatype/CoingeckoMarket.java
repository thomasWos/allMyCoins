package com.allmycoins.datatype;

public final class CoingeckoMarket {

	private final String symbol;
	private final float currentPrice;
	private final int marketCapRank;

	public CoingeckoMarket(String symbol, float currentPrice, int marketCapRank) {
		this.symbol = symbol;
		this.currentPrice = currentPrice;
		this.marketCapRank = marketCapRank;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public int getMarketCapRank() {
		return marketCapRank;
	}

	public String getSymbol() {
		return symbol;
	}

}
