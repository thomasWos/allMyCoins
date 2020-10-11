package com.allmycoins.request.elrond;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.elrond.ElrondBalanceRequestJson;
import com.allmycoins.request.GetRequest;

public final class ElrondAddressBalanceRequest implements GetRequest<ElrondBalanceRequestJson> {

	private final String elrondAddress;

	public ElrondAddressBalanceRequest(String pElrondAddress) {
		elrondAddress = pElrondAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.elrond.com";
	}

	@Override
	public String endPoint() {
		return "/address/" + elrondAddress + "/balance";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<ElrondBalanceRequestJson> jsonResponseClass() {
		return ElrondBalanceRequestJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
