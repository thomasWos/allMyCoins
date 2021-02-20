package com.allmycoins.json.coingecko;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class CoingeckoMarketJson {

	private String symbol;
	private float current_price;
	private int market_cap_rank;

}
