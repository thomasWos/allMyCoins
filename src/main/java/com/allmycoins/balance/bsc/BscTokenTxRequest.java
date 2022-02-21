package com.allmycoins.balance.bsc;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.balance.etherscan.TokenTxResultJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class BscTokenTxRequest implements GetRequest<TokenTxResultJson> {

	private final String bscAddress;

	public BscTokenTxRequest(String pAddress) {
		bscAddress = pAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.bscscan.com/api";
	}

	@Override
	public String endPoint() {
		return "";
	}

	@Override
	public Map<String, String> headers() {
		return Collections.emptyMap();
	}

	@Override
	public Class<TokenTxResultJson> jsonResponseClass() {
		return TokenTxResultJson.class;
	}

	@Override
	public String parameters() {
		return RequestUtils.buildParameters(Map.of("module", "account", "action", "tokentx", "address", bscAddress,
				"apikey", "GTE25RTNXNTJM3EAVQTN5JUZS4FXTZXX24"));
	}

}
