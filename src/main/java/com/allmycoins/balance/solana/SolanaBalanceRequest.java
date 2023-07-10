package com.allmycoins.balance.solana;

import static com.allmycoins.utils.RequestUtils.DEFAULT_JSON_HEADER;

import java.util.Map;

import com.allmycoins.request.PostRequest;
import com.allmycoins.utils.JacksonUtils;

public final class SolanaBalanceRequest implements PostRequest<SolanaBalanceJson> {

	private final String bodyStr;

	public SolanaBalanceRequest(String pSolanaAddress) {
		SolanaBalanceBody body = new SolanaBalanceBody("getBalance", new String[] { pSolanaAddress });
		bodyStr = JacksonUtils.serializeToJson(body);
	}

	@Override
	public String baseUrl() {
		return "https://api.mainnet-beta.solana.com";
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
		return DEFAULT_JSON_HEADER;
	}

	@Override
	public Class<SolanaBalanceJson> jsonResponseClass() {
		return SolanaBalanceJson.class;
	}

}
