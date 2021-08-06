package com.allmycoins.balance.osmosis;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class OsmosisBankRequest implements GetRequest<OsmosisBankJson> {

	private final String address;

	OsmosisBankRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://lcd-osmosis.cosmostation.io";
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
	public Class<OsmosisBankJson> jsonResponseClass() {
		return OsmosisBankJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
