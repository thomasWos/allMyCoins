package com.allmycoins.request.harmony;

import java.util.Map;

import com.allmycoins.json.harmony.HarmonyDelegationsJson;
import com.allmycoins.request.PostRequest;
import com.allmycoins.utils.JacksonUtils;
import com.allmycoins.utils.RequestUtils;

public class HarmonyDelegationsRequest implements PostRequest<HarmonyDelegationsJson> {

	private final String bodyStr;

	public HarmonyDelegationsRequest(String harmonyAdd) {
		HarmonyBodyRequest body = new HarmonyBodyRequest("hmy_getDelegationsByDelegator", new String[] { harmonyAdd });
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
	public Class<HarmonyDelegationsJson> jsonResponseClass() {
		return HarmonyDelegationsJson.class;
	}

}
