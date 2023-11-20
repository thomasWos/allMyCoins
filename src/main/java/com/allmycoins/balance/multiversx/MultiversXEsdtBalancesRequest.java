package com.allmycoins.balance.multiversx;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public final class MultiversXEsdtBalancesRequest implements GetRequest<MultiversXEsdtBalanceJson[]> {

	private final String address;

	public MultiversXEsdtBalancesRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.multiversx.com";
	}

	@Override
	public String endPoint() {
		return "/accounts/" + address + "/tokens";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<MultiversXEsdtBalanceJson[]> jsonResponseClass() {
		return MultiversXEsdtBalanceJson[].class;
	}

	@Override
	public String parameters() {
		String meta = "includeMetaESDT=true";
		String fields = "fields=ticker,decimals,balance";
		String identifiers = "identifiers=" + String.join(",", ESDTs.getIdentifiers());
		return String.join("&", List.of(meta, fields, identifiers));
	}
}
