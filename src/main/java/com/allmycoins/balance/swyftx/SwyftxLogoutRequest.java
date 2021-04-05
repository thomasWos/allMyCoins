package com.allmycoins.balance.swyftx;

import static com.allmycoins.balance.swyftx.SwyftxBalancesRequest.AUTHORIZATION;
import static com.allmycoins.balance.swyftx.SwyftxBalancesRequest.BEARER;
import static com.allmycoins.balance.swyftx.SwyftxRefreshRequest.SWYFTX_URL;
import static com.allmycoins.utils.RequestUtils.APP_JSON;
import static com.allmycoins.utils.RequestUtils.CONTENT_TYPE;

import java.util.Map;

import com.allmycoins.request.PostRequest;

public final class SwyftxLogoutRequest implements PostRequest<SwyftxLogoutJson> {

	private final String token;

	public SwyftxLogoutRequest(String pToken) {
		token = pToken;
	}

	@Override
	public String baseUrl() {
		return SWYFTX_URL;
	}

	@Override
	public String endPoint() {
		return "/auth/logout/";
	}

	@Override
	public Map<String, String> headers() {
		return Map.of(CONTENT_TYPE, APP_JSON, AUTHORIZATION, BEARER + token);
	}

	@Override
	public Class<SwyftxLogoutJson> jsonResponseClass() {
		return SwyftxLogoutJson.class;
	}

	@Override
	public String body() {
		return "";
	}
}
