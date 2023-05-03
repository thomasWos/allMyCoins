package com.allmycoins.balance.osmosis;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.request.GetRequest;

final class OsmosisLockedCoinsRequest implements GetRequest<OsmosisLockedCoinsJson> {

	private final String address;

	OsmosisLockedCoinsRequest(String pAddress) {
		address = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://lcd.osmosis.zone";
	}

	@Override
	public String endPoint() {
		return "/osmosis/lockup/v1beta1/account_locked_coins/" + address;
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<OsmosisLockedCoinsJson> jsonResponseClass() {
		return OsmosisLockedCoinsJson.class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
