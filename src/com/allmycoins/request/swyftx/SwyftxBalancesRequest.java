package com.allmycoins.request.swyftx;

import static com.allmycoins.request.swyftx.SwyftxRefreshRequest.SWYFTX_URL;
import static com.allmycoins.utils.RequestUtils.APP_JSON;
import static com.allmycoins.utils.RequestUtils.CONTENT_TYPE;

import java.util.Map;

import com.allmycoins.json.swyftx.SwyftxBalanceJson;
import com.allmycoins.request.GetRequest;

public final class SwyftxBalancesRequest implements GetRequest<SwyftxBalanceJson[]> {

	static final String BEARER = "Bearer ";
	static final String AUTHORIZATION = "Authorization";
	private final String token;

	public SwyftxBalancesRequest(String pToken) {
		token = pToken;
	}

	@Override
	public String baseUrl() {
		return SWYFTX_URL;
	}

	@Override
	public String endPoint() {
		return "/user/balance/";
	}

	@Override
	public Map<String, String> headers() {
		return Map.of(CONTENT_TYPE, APP_JSON, AUTHORIZATION, BEARER + token);
	}

	@Override
	public Class<SwyftxBalanceJson[]> jsonResponseClass() {
		return SwyftxBalanceJson[].class;
	}

	@Override
	public String parameters() {
		return "";
	}
}
