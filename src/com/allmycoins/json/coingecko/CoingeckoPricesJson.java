package com.allmycoins.json.coingecko;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Getter;

@Getter
public final class CoingeckoPricesJson {

	public Map<String, CoingeckoSimplePriceJson> prices = new HashMap<>();

	@JsonAnySetter
	public void setPrice(String name, CoingeckoSimplePriceJson coingeckoSimplePriceJson) {
		prices.put(name, coingeckoSimplePriceJson);
	}

}
