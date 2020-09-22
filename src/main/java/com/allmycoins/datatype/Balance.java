package com.allmycoins.datatype;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public final class Balance {
	private Long id;

	private String asset;
	private float quantity;
	private float currencyValue;
	private String source;

	/**
	 * Constructor (from code).
	 * 
	 * @param pAsset         asset
	 * @param pQuantity      quantity
	 * @param pCurrencyValue value
	 * @param pSource        source
	 */
	public Balance(final String pAsset, final float pQuantity, final float pCurrencyValue, final String pSource) {
		this.asset = pAsset;
		this.quantity = pQuantity;
		this.currencyValue = pCurrencyValue;
		this.source = pSource;
	}
}
