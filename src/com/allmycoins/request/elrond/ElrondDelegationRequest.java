package com.allmycoins.request.elrond;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.elrond.ElrondDelegationJson;
import com.allmycoins.request.GetRequest;

public final class ElrondDelegationRequest implements GetRequest<ElrondDelegationJson> {

	private final String elrondAddress;

	public ElrondDelegationRequest(String pElrondAddress) {
		elrondAddress = pElrondAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.elrond.com";
	}

	@Override
	public String endPoint() {
		return "/addresses/" + elrondAddress + "/delegation";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<ElrondDelegationJson> jsonResponseClass() {
		return ElrondDelegationJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
