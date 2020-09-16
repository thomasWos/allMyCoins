package com.allmycoins.request.etherscan;

import java.util.Collections;
import java.util.Map;

import com.allmycoins.json.etherscan.EtherscanBalanceJson;
import com.allmycoins.request.GetRequest;
import com.allmycoins.utils.RequestUtils;

public final class EtherscanBalanceRequest implements GetRequest<EtherscanBalanceJson> {

	private final String ethAddress;

	public EtherscanBalanceRequest(String pEthAddress) {
		ethAddress = pEthAddress;
	}

	@Override
	public String baseUrl() {
		return "https://api.etherscan.io/api";
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
	public Class<EtherscanBalanceJson> jsonResponseClass() {
		return EtherscanBalanceJson.class;
	}

	@Override
	public String parameters() {
		return RequestUtils.buildParameters(Map.of("module", "account", "action", "balance", "address", ethAddress,
				"tag", "latest", "apikey", "HEK77EVVKYTZD35MQXG2XVX3IAU3TV3XGS"));
	}

}
