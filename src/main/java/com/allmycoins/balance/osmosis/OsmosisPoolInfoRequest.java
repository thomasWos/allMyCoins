package com.allmycoins.balance.osmosis;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class OsmosisPoolInfoRequest implements GetRequest<OsmosisPoolInfoJson> {

	private final String index;

	OsmosisPoolInfoRequest(String pIndex) {
		index = pIndex;
	}

	@Override
	public String baseUrl() {
		return "https://lcd-osmosis.keplr.app";
	}

	@Override
	public String endPoint() {
		return "/osmosis/gamm/v1beta1/pools/" + index;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<OsmosisPoolInfoJson> jsonResponseClass() {
		return OsmosisPoolInfoJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
