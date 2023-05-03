package com.allmycoins.balance.multiversx;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class MultiversXDelegationsRequest implements GetRequest<MultiversXDelegationJson[]> {

	private final String address;

	public MultiversXDelegationsRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://delegation-api.multiversx.com";
	}

	@Override
	public String endPoint() {
		return "/accounts/" + address + "/delegations";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<MultiversXDelegationJson[]> jsonResponseClass() {
		return MultiversXDelegationJson[].class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
