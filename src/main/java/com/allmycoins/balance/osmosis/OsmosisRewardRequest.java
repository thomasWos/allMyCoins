package com.allmycoins.balance.osmosis;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class OsmosisRewardRequest implements GetRequest<OsmosisRewardJson> {

	private final String address;

	OsmosisRewardRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://lcd-osmosis.cosmostation.io";
	}

	@Override
	public String endPoint() {
		return "/cosmos/distribution/v1beta1/delegators/" + address + "/rewards";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<OsmosisRewardJson> jsonResponseClass() {
		return OsmosisRewardJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
