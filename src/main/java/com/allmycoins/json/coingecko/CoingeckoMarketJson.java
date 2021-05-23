package com.allmycoins.json.coingecko;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CoingeckoMarketJson {

	private String symbol;
	private float current_price;
	private int market_cap_rank;

	public float getCurrent_price() {
		return current_price;
	}

	public int getMarket_cap_rank() {
		return market_cap_rank;
	}

	public String getSymbol() {
		return symbol;
	}
}
