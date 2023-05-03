package com.allmycoins.balance.multiversx;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class MultiversXBalanceRequestJson {

	private MultiversXAddressBalanceJson data;

	public MultiversXAddressBalanceJson getData() {
		return data;
	}
}
