package com.allmycoins.datatype;

import java.util.Set;

public final class BalanceMerge {

	private final String asset;
	private final float qty;
	private final Set<String> sources;

	public BalanceMerge(String asset, float qty, Set<String> sources) {
		this.asset = asset;
		this.qty = qty;
		this.sources = sources;
	}

	public String getAsset() {
		return asset;
	}

	public float getQty() {
		return qty;
	}

	public Set<String> getSources() {
		return sources;
	}
}
