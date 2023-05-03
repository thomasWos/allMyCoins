package com.allmycoins.balance.cardano;

import java.util.Map;

import com.allmycoins.request.GetRequest;

public class CardanoAccountRequest implements GetRequest<CardanoBalanceJson> {

	private final String stakeKey;

	public CardanoAccountRequest(String pStakeKey) {
		stakeKey = pStakeKey;
	}

	@Override
	public String baseUrl() {
		return "https://cardano-mainnet.blockfrost.io";
	}

	@Override
	public String endPoint() {
		return "/api/v0/accounts/" + stakeKey;
	}

	@Override
	public Map<String, String> headers() {
		return Map.of("project_id", "mainnetO5Scj0VnBmzmARDmNbbFWT9LKljABDM3");
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
