package com.allmycoins.request.solana;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.solana.SolanaBalanceJson;
import com.allmycoins.request.GetRequest;

public final class SolanaBalanceRequest implements GetRequest<SolanaBalanceJson> {

	private final String solanaAddress;

	public SolanaBalanceRequest(String pSolanaAddress) {
		solanaAddress = pSolanaAddress;
	}

	@Override
	public String baseUrl() {
		return "https://explorer.solana.com";
	}

	@Override
	public String endPoint() {
		return "/address/" + solanaAddress;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<SolanaBalanceJson> jsonResponseClass() {
		return SolanaBalanceJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
