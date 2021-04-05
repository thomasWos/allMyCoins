package com.allmycoins.balance.cosmos;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class CosmosBalanceRequest implements GetRequest<CosmosBalanceJson> {

	private final String cosmosAddress;

	public CosmosBalanceRequest(String pCosmosAddress) {
		cosmosAddress = pCosmosAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.cosmostation.io";
	}

	@Override
	public String endPoint() {
		return "/v1/account/total/balance/" + cosmosAddress;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<CosmosBalanceJson> jsonResponseClass() {
		return CosmosBalanceJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
