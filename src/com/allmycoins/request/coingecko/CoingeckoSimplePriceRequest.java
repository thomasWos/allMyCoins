package com.allmycoins.request.coingecko;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.allmycoins.json.coingecko.CoingeckoPricesJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class CoingeckoSimplePriceRequest implements GetRequest<CoingeckoPricesJson> {

	private final Set<String> ids;
	private final String currency;

	public CoingeckoSimplePriceRequest(Set<String> pIds, String pCurrency) {
		ids = pIds;
		currency = pCurrency;
	}

	@Override
	public String baseUrl() {
		return CoingeckoConst.BASE_URL;
	}

	@Override
	public String endPoint() {
		return "/simple/price";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<CoingeckoPricesJson> jsonResponseClass() {
		return CoingeckoPricesJson.class;
	}

	@Override
	public String parameters() {
		return RequestUtils.buildParameters(
				Map.of("ids", ids.stream().collect(Collectors.joining("%2C")), "vs_currencies", currency));
	}

}
