package com.allmycoins.json.coingecko;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Getter;

@Getter
public final class CoingeckoSimplePriceJson {

	private Map<String, Float> prices = new HashMap<>();

	@JsonAnySetter
	public void setPrice(String currency, float price) {
		prices.put(currency, price);
	}
}
