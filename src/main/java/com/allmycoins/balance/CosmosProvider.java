package com.allmycoins.balance;

import java.util.Collections;
import java.util.List;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.cosmos.CosmosBalanceJson;
import com.allmycoins.pc.BuildCosmosBalance;
import com.allmycoins.request.cosmos.CosmosBalanceRequest;
import com.allmycoins.utils.RequestUtils;

public class CosmosProvider implements BalanceProvider {

	@Override
	public List<BalanceJson> balances() {
		return PrivateConfig.get("COSMOS_ADDRESS").map(this::cosmosBalance).map(List::of)
				.orElseGet(Collections::emptyList);
	}

	private BalanceJson cosmosBalance(String cosmosAddress) {
		CosmosBalanceJson algoBalanceJson = RequestUtils.sendRequest(new CosmosBalanceRequest(cosmosAddress));
		return BuildCosmosBalance.build(algoBalanceJson);
	}

}
