package com.allmycoins.balance.swyftx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class SwyftxMarketAssetJson {

	private int id;
	private String code;

	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
	}
}
