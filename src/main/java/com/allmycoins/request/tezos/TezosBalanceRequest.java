package com.allmycoins.request.tezos;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.tezos.TezosBalanceJson;
import com.allmycoins.request.GetRequest;

public class TezosBalanceRequest implements GetRequest<TezosBalanceJson> {
	private final String address;

	public TezosBalanceRequest(String pTezosAddress) {
		address = pTezosAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.tzstats.com";
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
		return "";
	}

}
