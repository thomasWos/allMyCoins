package com.allmycoins.balance.avalanche;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.balance.etherscan.TokenTxResultJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class AvalancheTokenTxRequest implements GetRequest<TokenTxResultJson> {

	private final String address;

	public AvalancheTokenTxRequest(String pAddress) {
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
	public Class<TokenTxResultJson> jsonResponseClass() {
		return TokenTxResultJson.class;
	}

	@Override
	public String parameters() {
		return RequestUtils.buildParameters(Map.of("module", "account", "action", "tokentx", "address", address));
	}

}
