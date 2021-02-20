package com.allmycoins.datatype;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class CoingeckoMarket {

	private final String symbol;
	private final float currentPrice;
	private final int marketCapRank;

}
