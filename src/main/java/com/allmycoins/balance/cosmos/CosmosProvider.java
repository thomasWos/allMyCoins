package com.allmycoins.balance.cosmos;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class CosmosProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "COSMOS_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		CosmosBalanceJson algoBalanceJson = RequestUtils.sendRequest(new CosmosBalanceRequest(publicAddress));
		return BuildCosmosBalance.build(algoBalanceJson);
	}

}
