package com.allmycoins.request.bitcoin;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.bitcoin.BitcoinBalanceJson;
import com.allmycoins.request.GetRequest;

public final class BitcoinBalanceRequest implements GetRequest<BitcoinBalanceJson> {

	private final String address;

	public BitcoinBalanceRequest(String btcAddress) {
		address = btcAddress;
	}

	@Override
	public String baseUrl() {
		return "https://chain.api.btc.com";
	}

	@Override
	public String endPoint() {
		return "/v3/address/" + address;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<BitcoinBalanceJson> jsonResponseClass() {
		return BitcoinBalanceJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
