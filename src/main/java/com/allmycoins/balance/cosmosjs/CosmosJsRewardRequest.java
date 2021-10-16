package com.allmycoins.balance.cosmosjs;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class CosmosJsRewardRequest implements GetRequest<CosmosJsRewardJson> {

	private final String network;
	private final String address;

	CosmosJsRewardRequest(String pNetwork, String pAddress) {
		network = pNetwork;
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://lcd-" + network + ".cosmostation.io";
	}

	@Override
	public String endPoint() {
		return "/cosmos/distribution/v1beta1/delegators/" + address + "/rewards";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<CosmosJsRewardJson> jsonResponseClass() {
		return CosmosJsRewardJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
