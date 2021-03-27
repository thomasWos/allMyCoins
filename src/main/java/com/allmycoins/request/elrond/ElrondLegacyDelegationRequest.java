package com.allmycoins.request.elrond;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.elrond.ElrondLegacyDelegationJson;
import com.allmycoins.request.GetRequest;

public final class ElrondLegacyDelegationRequest implements GetRequest<ElrondLegacyDelegationJson> {

	private final String elrondAddress;

	public ElrondLegacyDelegationRequest(String pElrondAddress) {
		elrondAddress = pElrondAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.elrond.com";
	}

	@Override
	public String endPoint() {
		return "/accounts/" + elrondAddress + "/delegation";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<ElrondLegacyDelegationJson> jsonResponseClass() {
		return ElrondLegacyDelegationJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
