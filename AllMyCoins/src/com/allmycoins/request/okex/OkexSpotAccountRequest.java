package com.allmycoins.request.okex;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import com.allmycoins.json.okex.OkexSpotAccountJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.SignUtils;
import com.allmycoins.utils.SignatureAlgo;

public final class OkexSpotAccountRequest implements GetRequest<OkexSpotAccountJson[]> {

	private final String apiKey;
	private final String secretKey;
	private final String passphrase;

	public OkexSpotAccountRequest(String pApiKey, String pSecretKey, String pPassphrase) {
		apiKey = pApiKey;
		secretKey = pSecretKey;
		passphrase = pPassphrase;
	}

	// GET/api/spot/v3/accounts

	@Override
	public String baseUrl() {
		return "https://www.okex.com";
	}

	@Override
	public String endPoint() {
		return "/api/spot/v3/accounts";
	}

	@Override
	public Map<String, String> headers() {
		// ISO8601 standard time format. needs to be accurate to milliseconds.
		String timestamp = Instant.now().truncatedTo(ChronoUnit.MILLIS).toString();
		// timestamp + method + requestPath + body
		String prehash = timestamp + "GET" + endPoint();
		String signature = SignUtils.signBase64(SignatureAlgo.HMAC_SHA256, secretKey, prehash);
		return Map.of("OK-ACCESS-KEY", apiKey, "OK-ACCESS-SIGN", signature, "OK-ACCESS-TIMESTAMP", timestamp,
				"OK-ACCESS-PASSPHRASE", passphrase);
	}

	@Override
	public Class<OkexSpotAccountJson[]> jsonResponseClass() {
		return OkexSpotAccountJson[].class;
	}

	@Override
	public String parameters() {
		return "";
	}

}
