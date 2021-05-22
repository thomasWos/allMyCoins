package com.allmycoins.balance.okex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OkexDataJson {

	private OkexBalanceJson[] details;

	public OkexBalanceJson[] getDetails() {
		return details;
	}
}
