package com.allmycoins.balance.elrond;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ElrondBalanceRequestJson {

	private ElrondAddressBalanceJson data;

	public ElrondAddressBalanceJson getData() {
		return data;
	}
}
