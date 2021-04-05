package com.allmycoins.balance.harmony;

import java.util.Map;

import com.allmycoins.request.PostRequest;
import com.allmycoins.utils.JacksonUtils;
import com.allmycoins.utils.RequestUtils;

public final class HarmonyBalanceRequest implements PostRequest<HarmonyBalanceJson> {

	private final String bodyStr;

	public HarmonyBalanceRequest(String harmonyAdd) {
		HarmonyBodyRequest body = new HarmonyBodyRequest("hmyv2_getBalance", new String[] { harmonyAdd });
		bodyStr = JacksonUtils.serializeToJson(body);
	}

	@Override
	public String baseUrl() {
		return "https://api.s0.t.hmny.io";
	}

	@Override
	public String body() {
		return bodyStr;
	}

	@Override
	public String endPoint() {
		return "";
	}

	@Override
	public Map<String, String> headers() {
		return RequestUtils.DEFAULT_JSON_HEADER;
	}

	@Override
	public Class<HarmonyBalanceJson> jsonResponseClass() {
		return HarmonyBalanceJson.class;
	}

}
