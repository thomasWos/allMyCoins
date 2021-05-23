package com.allmycoins.balance.cryptocom;

import static com.allmycoins.utils.RequestUtils.DEFAULT_JSON_HEADER;

import java.util.Map;
import java.util.Random;

import com.allmycoins.request.PostRequest;
import com.allmycoins.utils.JacksonUtils;
import com.allmycoins.utils.SignUtils;
import com.allmycoins.utils.SignatureAlgo;

public final class CryptoComAccountSummaryRequest implements PostRequest<CryptoComAccountSummaryJson> {

	private final String bodyStr;

	public CryptoComAccountSummaryRequest(String pApiKey, String pSecretKey) {
		long id = new Random().nextLong();
		String method = "private/get-account-summary";
		long nonce = System.currentTimeMillis();

		String sigPayload = method + id + pApiKey + nonce;
		String sig = SignUtils.signHex(SignatureAlgo.HMAC_SHA256, pSecretKey, sigPayload);

		AccountSummaryBody accountSummaryBody = new AccountSummaryBody(id, method, pApiKey, sig, nonce);

		bodyStr = JacksonUtils.serializeToJson(accountSummaryBody);
	}

	@Override
	public String baseUrl() {
		return "https://api.crypto.com/v2";
	}

	@Override
	public String body() {
		return bodyStr;
	}

	@Override
	public String endPoint() {
		return "/private/get-account-summary";
	}

	@Override
	public Map<String, String> headers() {
		return DEFAULT_JSON_HEADER;
	}

	@Override
	public Class<CryptoComAccountSummaryJson> jsonResponseClass() {
		return CryptoComAccountSummaryJson.class;
	}

}
