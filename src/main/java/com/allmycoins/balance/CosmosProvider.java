package com.allmycoins.balance;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.cosmos.CosmosBalanceJson;
import com.allmycoins.pc.BuildCosmosBalance;
import com.allmycoins.request.cosmos.CosmosBalanceRequest;
import com.allmycoins.utils.RequestUtils;

public final class CosmosProvider implements PublicAddressBalanceProvider {

	@Override
	public BalanceJson balance(String publicAddress) {
		CosmosBalanceJson algoBalanceJson = RequestUtils.sendRequest(new CosmosBalanceRequest(publicAddress));
		return BuildCosmosBalance.build(algoBalanceJson);
	}

	@Override
	public String privateConfigKey() {
		return "COSMOS_ADDRESS";
	}

}
