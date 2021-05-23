package com.allmycoins.balance.cryptocom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CryptoComAccountJson {

	private float balance;
	private String currency;

	public float getBalance() {
		return balance;
	}

	public String getCurrency() {
		return currency;
	}
}
