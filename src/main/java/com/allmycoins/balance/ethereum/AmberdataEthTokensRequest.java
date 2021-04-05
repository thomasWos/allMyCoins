package com.allmycoins.balance.ethereum;

import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class AmberdataEthTokensRequest implements GetRequest<AmberdataEthTokensJson> {

	private final String ethAddress;

	public AmberdataEthTokensRequest(String pEthAddress) {
		ethAddress = pEthAddress;
	}

	@Override
	public String baseUrl() {
		return "https://web3api.io";
	}

	@Override
	public String endPoint() {
		return "/api/v2/addresses/" + ethAddress + "/token-balances/latest";
	}

	@Override
	public Map<String, String> headers() {
		return Map.of("x-api-key", "UAKcaf21697061776a575228db2a55e4990");
	}

	@Override
	public Class<AmberdataEthTokensJson> jsonResponseClass() {
		return AmberdataEthTokensJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
