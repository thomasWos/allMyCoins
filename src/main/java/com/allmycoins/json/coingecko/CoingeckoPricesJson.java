package com.allmycoins.json.coingecko;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public final class CoingeckoPricesJson {

	private Map<String, CoingeckoSimplePriceJson> prices = new HashMap<>();

	public Map<String, CoingeckoSimplePriceJson> getPrices() {
		return prices;
	}

	@JsonAnySetter
	public void setPrice(String name, CoingeckoSimplePriceJson coingeckoSimplePriceJson) {
		prices.put(name, coingeckoSimplePriceJson);
	}

}
