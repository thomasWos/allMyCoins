package com.allmycoins.request.bscscan;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.bscscan.BscTokenTxResultJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class BscTokenTxRequest implements GetRequest<BscTokenTxResultJson> {

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
	public Class<BscTokenTxResultJson> jsonResponseClass() {
		return BscTokenTxResultJson.class;
	}

	@Override
	public String parameters() {
		return RequestUtils.buildParameters(Map.of("module", "account", "action", "tokentx", "address", bscAddress));
	}

}
