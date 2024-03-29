package com.allmycoins.balance.cosmosjs;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class CosmosJsBankRequest implements GetRequest<CosmosJsBankJson> {

	private final String baseUrl;
	private final String address;

	CosmosJsBankRequest(String pBaseUrl, String pAddress) {
		baseUrl = pBaseUrl;
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return baseUrl;
	}

	@Override
	public String endPoint() {
		return "/cosmos/bank/v1beta1/balances/" + address;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<CosmosJsBankJson> jsonResponseClass() {
		return CosmosJsBankJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
