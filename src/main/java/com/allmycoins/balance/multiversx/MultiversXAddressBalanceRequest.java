package com.allmycoins.balance.multiversx;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class MultiversXAddressBalanceRequest implements GetRequest<MultiversXBalanceRequestJson> {

	private final String address;

	public MultiversXAddressBalanceRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.multiversx.com";
	}

	@Override
	public String endPoint() {
		return "/address/" + address + "/balance";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<MultiversXBalanceRequestJson> jsonResponseClass() {
		return MultiversXBalanceRequestJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
