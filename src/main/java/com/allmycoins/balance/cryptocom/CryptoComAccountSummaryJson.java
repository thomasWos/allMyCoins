package com.allmycoins.balance.cryptocom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class CryptoComAccountSummaryJson {

	private CryptoComResultJson result;

	public CryptoComResultJson getResult() {
		return result;
	}

}
