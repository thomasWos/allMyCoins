package com.allmycoins.datatype;

import java.util.List;

public final class BalancesResult {

	private List<Asset> assets;
	private float totalCurrency;

	public BalancesResult(List<Asset> assets, float totalCurrency) {
		this.assets = assets;
		this.totalCurrency = totalCurrency;
	}

	public List<Asset> getAssets() {
		return assets;
	}

	public float getTotalCurrency() {
		return totalCurrency;
	}

}
