package com.allmycoins.json.manu;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class BalanceManuJson {

	private String asset;
	private float qty;
	private String src;

	public String getAsset() {
		return asset;
	}

	public float getQty() {
		return qty;
	}

	public String getSrc() {
		return src;
	}

}
