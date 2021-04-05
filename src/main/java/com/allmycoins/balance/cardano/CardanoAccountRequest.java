package com.allmycoins.balance.cardano;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

public class CardanoAccountRequest implements GetRequest<CardanoBalanceJson> {

	private final String stakeKey;

	public CardanoAccountRequest(String pStakeKey) {
		stakeKey = pStakeKey;
	}

	@Override
	public String baseUrl() {
		return "https://adastat.net";
	}

	@Override
	public String endPoint() {
		return "/rest/v0/account/" + stakeKey + ".json";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<CardanoBalanceJson> jsonResponseClass() {
		return CardanoBalanceJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
