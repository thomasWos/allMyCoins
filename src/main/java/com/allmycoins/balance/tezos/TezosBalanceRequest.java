package com.allmycoins.balance.tezos;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public class TezosBalanceRequest implements GetRequest<TezosBalanceJson> {
	private final String address;

	/* API key created with a personal account on tzpro.com. */
	private static final String MY_API_KEY = "FW05FXESQ3P1TLJOSIJM6T58CWYADX5";

	public TezosBalanceRequest(String pTezosAddress) {
		address = pTezosAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.tzpro.io";
	}

	@Override
	public String endPoint() {
		return "/explorer/account/" + address;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<TezosBalanceJson> jsonResponseClass() {
		return TezosBalanceJson.class;
	}

	@Override
	public String parameters() {
		return "api_key=" + MY_API_KEY;
	}

}
