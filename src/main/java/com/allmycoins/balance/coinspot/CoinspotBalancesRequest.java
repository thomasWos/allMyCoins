package com.allmycoins.balance.coinspot;

import java.util.Map;

import com.allmycoins.request.PostRequest;
import com.allmycoins.utils.JacksonUtils;
import com.allmycoins.utils.SignUtils;
import com.allmycoins.utils.SignatureAlgo;

public final class CoinspotBalancesRequest implements PostRequest<CoinspotBalancesJson> {

	private final String apiKey;
	private final String secretKey;
	private final String bodyStr;

	public CoinspotBalancesRequest(String pApiKey, String pSecretKey) {
		apiKey = pApiKey;
		secretKey = pSecretKey;

		CoinspotBalancesBody body = CoinspotBalancesBody.builder().nonce(System.currentTimeMillis()).build();
		bodyStr = JacksonUtils.serializeToJson(body);
	}

	@Override
	public String baseUrl() {
		// Read only !
		return "https://www.coinspot.com.au/api/ro";
	}

	@Override
	public String body() {
		return bodyStr;
	}

	@Override
	public String endPoint() {
		return "/my/balances";
	}

	@Override
	public Map<String, String> headers() {
		String signature = SignUtils.signHex(SignatureAlgo.HMAC_SHA512, secretKey, bodyStr);
		return Map.of("key", apiKey, "sign", signature, "Content-Type", "application/json");
	}

	@Override
	public Class<CoinspotBalancesJson> jsonResponseClass() {
		return CoinspotBalancesJson.class;
	}
}
