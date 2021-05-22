package com.allmycoins.balance.okex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class OkexBalanceJson {

	private String ccy;
	private float availBal;

	public float getAvailBal() {
		return availBal;
	}

	public String getCcy() {
		return ccy;
	}
}
