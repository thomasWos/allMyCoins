package com.allmycoins.datatype;

public final class Balance {

	private final String asset;
	private final float quantity;
	private final float currencyValue;
	private final String source;

	public Balance(String asset, float quantity, float currencyValue, String source) {
		this.asset = asset;
		this.quantity = quantity;
		this.currencyValue = currencyValue;
		this.source = source;
	}

	public String getAsset() {
		return asset;
	}

	public float getCurrencyValue() {
		return currencyValue;
	}

	public float getQuantity() {
		return quantity;
	}

	public String getSource() {
		return source;
	}

}
