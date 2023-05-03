package com.allmycoins.balance.cosmosjs;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class CosmosJsDelegationsRequest implements GetRequest<CosmosJsDelegationsJson> {

	private final String baseUrl;
	private final String address;

	CosmosJsDelegationsRequest(String pBaseUrl, String pAddress) {
		baseUrl = pBaseUrl;
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return baseUrl;
	}

	@Override
	public String endPoint() {
		return "/cosmos/staking/v1beta1/delegations/" + address;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<CosmosJsDelegationsJson> jsonResponseClass() {
		return CosmosJsDelegationsJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
