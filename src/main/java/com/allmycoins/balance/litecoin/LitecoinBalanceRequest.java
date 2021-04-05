package com.allmycoins.balance.litecoin;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class LitecoinBalanceRequest implements GetRequest<LitecoinBalanceJson> {

	private final String address;

	public LitecoinBalanceRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://ltc.tokenview.com";
	}

	@Override
	public String endPoint() {
		return "/api/address/balancetrend/ltc/" + address;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<LitecoinBalanceJson> jsonResponseClass() {
		return LitecoinBalanceJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
