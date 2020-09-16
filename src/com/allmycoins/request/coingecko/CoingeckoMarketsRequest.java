package com.allmycoins.request.coingecko;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.coingecko.CoingeckoMarketJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class CoingeckoMarketsRequest implements GetRequest<CoingeckoMarketJson[]> {

	@Override
	public String baseUrl() {
		return CoingeckoConst.BASE_URL;
	}

	@Override
	public String endPoint() {
		return "/coins/markets";
	}

	@Override
	public Map<String, String> headers() {
		// return Map.of("accept", "application/json");
		return Collections.emptyMap();
	}

	@Override
	public Class<CoingeckoMarketJson[]> jsonResponseClass() {
		return CoingeckoMarketJson[].class;
	}

	@Override
	public String parameters() {
		return RequestUtils.buildParameters(Map.of("vs_currency", "usd", "per_page", "250", "page", "1"));
	}

}
