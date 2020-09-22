package com.allmycoins.request.binance;

import java.util.Map;

import com.allmycoins.json.binance.BinanceAccountJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;
import com.allmycoins.utils.SignUtils;
import com.allmycoins.utils.SignatureAlgo;

public final class BinanceAccountRequest implements GetRequest<BinanceAccountJson> {

	private final String apiKey;
	private final String secretKey;

	public BinanceAccountRequest(String pApiKey, String pSecretKey) {
		apiKey = pApiKey;
		secretKey = pSecretKey;
	}

	@Override
	public String baseUrl() {
		return "https://api.binance.com";
	}

	@Override
	public String endPoint() {
		return "/api/v3/account";
	}

	@Override
	public Map<String, String> headers() {
		return Map.of("X-MBX-APIKEY", apiKey);
	}

	@Override
	public Class<BinanceAccountJson> jsonResponseClass() {
		return BinanceAccountJson.class;
	}

	@Override
	public String parameters() {
		String params = RequestUtils.buildParameters(Map.of("timestamp", Long.toString(System.currentTimeMillis())));
		params += "&signature=" + SignUtils.signHex(SignatureAlgo.HMAC_SHA256, secretKey, params);
		return params;
	}

}
