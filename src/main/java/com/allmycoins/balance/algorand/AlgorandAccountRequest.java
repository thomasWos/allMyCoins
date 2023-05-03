package com.allmycoins.balance.algorand;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class AlgorandAccountRequest implements GetRequest<AlgorandBalanceJson> {

	private final String algorandAddress;

	public AlgorandAccountRequest(String pAlgorandAddress) {
		algorandAddress = pAlgorandAddress;
	}

	@Override
	public String baseUrl() {
		return "https://node.algoexplorerapi.io";
	}

	@Override
	public String endPoint() {
		return "/v2/accounts/" + algorandAddress;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<AlgorandBalanceJson> jsonResponseClass() {
		return AlgorandBalanceJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
