package com.allmycoins.balance.cryptocom;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CryptoComResultJson {

	private List<CryptoComAccountJson> accounts;

	public List<CryptoComAccountJson> getAccounts() {
		return accounts;
	}
}
