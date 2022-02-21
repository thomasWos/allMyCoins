package com.allmycoins.balance.avalanche;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.balance.etherscan.SingleBalanceJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class AvalancheBalanceRequest implements GetRequest<SingleBalanceJson> {

	private final String address;

	public AvalancheBalanceRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.snowtrace.io/api";
	}

	@Override
	public String endPoint() {
		return "";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<SingleBalanceJson> jsonResponseClass() {
		return SingleBalanceJson.class;
	}

	@Override
	public String parameters() {
		return RequestUtils.buildParameters(Map.of("module", "account", "action", "balance", "address", address));
	}

}
