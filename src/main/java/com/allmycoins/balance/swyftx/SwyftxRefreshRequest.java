package com.allmycoins.balance.swyftx;

import static com.allmycoins.utils.RequestUtils.DEFAULT_JSON_HEADER;

import java.util.Map;

import com.allmycoins.request.PostRequest;
import com.allmycoins.utils.JacksonUtils;

public final class SwyftxRefreshRequest implements PostRequest<SwyftxAccessTokenJson> {
	static final String SWYFTX_URL = "https://api.swyftx.com.au";
	private final String apiKey;

	public SwyftxRefreshRequest(String pApiKey) {
		apiKey = pApiKey;
	}

	@Override
	public String baseUrl() {
		return SWYFTX_URL;
	}

	@Override
	public String endPoint() {
		return "/auth/refresh/";
	}

	@Override
	public Map<String, String> headers() {
		return DEFAULT_JSON_HEADER;
	}

	@Override
	public Class<SwyftxAccessTokenJson> jsonResponseClass() {
		return SwyftxAccessTokenJson.class;
	}

	@Override
	public String body() {
		SwyftxRefreshBody body = SwyftxRefreshBody.builder().apiKey(apiKey).build();
		return JacksonUtils.serializeToJson(body);
	}
}
