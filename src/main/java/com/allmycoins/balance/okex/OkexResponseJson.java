package com.allmycoins.balance.okex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OkexResponseJson {

	private OkexDataJson[] data;

	public OkexDataJson[] getData() {
		return data;
	}
}
