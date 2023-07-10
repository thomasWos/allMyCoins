package com.allmycoins.balance.ethereum2;

import static com.allmycoins.utils.RequestUtils.DEFAULT_JSON_HEADER;

import java.util.Map;

import com.allmycoins.request.GetRequest;

final class Eth2BalanceRequest implements GetRequest<Eth2BalanceJson> {

	final String publicKey;

	Eth2BalanceRequest(String pPublicKey) {
		publicKey = pPublicKey;
	}

	@Override
	public String baseUrl() {
		return "https://beaconcha.in";
	}

	@Override
	public String endPoint() {
		return "/api/v1/validator/" + publicKey + "/performance";
	}

	@Override
	public Map<String, String> headers() {
		return DEFAULT_JSON_HEADER;
	}

	@Override
	public Class<Eth2BalanceJson> jsonResponseClass() {
		return Eth2BalanceJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
