package com.allmycoins.balance.swyftx;

public final class SwyftxRefreshBody {

	private final String apiKey;

	public SwyftxRefreshBody(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiKey() {
		return apiKey;
	}

}
