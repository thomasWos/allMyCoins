package com.allmycoins.json.coingecko;

import com.allmycoins.datatype.Currency;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;

@JsonInclude(value = Include.NON_NULL)
@Getter
public final class CoingeckoSimplePriceJson {

	private float usd;
	private float aud;
	private float eur;

	public final float getValue(final Currency currency) {
		switch (currency) {
		case AUD:
			return aud;
		case EUR:
			return eur;
		case USD:
		default:
			return usd;
		}
	}
}
