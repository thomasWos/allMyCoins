package com.allmycoins.balance.covalent;

import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class CovalentBalancesRequest implements GetRequest<CovalentBalancesJson> {

	private final String network;
	private final String publicAddress;

	public CovalentBalancesRequest(final String pNetwork, final String pPublicAddress) {
		network = pNetwork;
		publicAddress = pPublicAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.covalenthq.com";
	}

	@Override
	public String endPoint() {
		return "/v1/" + network + "/address/" + publicAddress + "/balances_v2/";
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
