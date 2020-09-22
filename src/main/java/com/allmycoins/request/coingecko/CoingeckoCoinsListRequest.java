package com.allmycoins.request.coingecko;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.coingecko.CoingeckoCoinListJson;
import com.allmycoins.request.GetRequest;

public final class CoingeckoCoinsListRequest implements GetRequest<CoingeckoCoinListJson[]> {

	@Override
	public String baseUrl() {
		return CoingeckoConst.BASE_URL;
	}

	@Override
	public String endPoint() {
		return "/coins/list";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<CoingeckoCoinListJson[]> jsonResponseClass() {
		return CoingeckoCoinListJson[].class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
