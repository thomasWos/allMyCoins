package com.allmycoins.json.coingecko;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public final class CoingeckoSimplePriceJson {

	private Map<String, Float> prices = new HashMap<>();

	public Map<String, Float> getPrices() {
		return prices;
	}

	@JsonAnySetter
	public void setPrice(String currency, float price) {
		prices.put(currency, price);
	}

}
