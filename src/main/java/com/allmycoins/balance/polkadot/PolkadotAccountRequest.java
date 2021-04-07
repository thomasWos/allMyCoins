package com.allmycoins.balance.polkadot;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class PolkadotAccountRequest implements GetRequest<PolkadotAccountJson> {

	private final String publicAddress;

	public PolkadotAccountRequest(String pPublicAddress) {
		publicAddress = pPublicAddress;
	}

	@Override
	public String baseUrl() {
		return "https://explorer-32.polkascan.io";
	}

	@Override
	public String endPoint() {
		return "/api/v1/polkadot/account/" + publicAddress;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<PolkadotAccountJson> jsonResponseClass() {
		return PolkadotAccountJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
