package com.allmycoins.balance.ethereum;

import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class CovalentBalancesRequest implements GetRequest<CovalentBalancesJson> {

	private final String ethAddress;

	public CovalentBalancesRequest(String pEthAddress) {
		ethAddress = pEthAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.covalenthq.com";
	}

	@Override
	public String endPoint() {
		return "/v1/eth-mainnet/address/" + ethAddress + "/balances_v2/";
	}

	@Override
	public Map<String, String> headers() {
		return Map.of("Authorization", "Bearer cqt_rQrX3Gh3wypBj9JYQDmKHcf6YrQ9");
	}

	@Override
	public Class<CovalentBalancesJson> jsonResponseClass() {
		return CovalentBalancesJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}
}
