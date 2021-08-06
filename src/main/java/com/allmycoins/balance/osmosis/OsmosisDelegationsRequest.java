package com.allmycoins.balance.osmosis;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class OsmosisDelegationsRequest implements GetRequest<OsmosisDelegationsJson> {

	private final String address;

	OsmosisDelegationsRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://lcd-osmosis.cosmostation.io";
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
	public Class<OsmosisDelegationsJson> jsonResponseClass() {
		return OsmosisDelegationsJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
