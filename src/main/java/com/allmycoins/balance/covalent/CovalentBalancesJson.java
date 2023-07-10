package com.allmycoins.balance.covalent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CovalentBalancesJson {

	private CovalentBalancesDataJson data;

	public CovalentBalancesDataJson getData() {
		return data;
	}
}
