package com.allmycoins.balance.cosmos;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class CosmosProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "COSMOS_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		CosmosBalanceJson cosmosBalanceJson = RequestUtils.sendRequest(new CosmosBalanceRequest(publicAddress));
		float qty = BigDecimalUtils.decimal(cosmosBalanceJson.getTotal().getAmount(), 6);
		return new BalanceJson("ATOM", qty, "Cosmos wallet");
	}

}
