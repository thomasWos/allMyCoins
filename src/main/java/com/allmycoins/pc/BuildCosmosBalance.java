package com.allmycoins.pc;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.cosmos.CosmosBalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public class BuildCosmosBalance {

	public static BalanceJson build(CosmosBalanceJson cosmosBalanceJson) {
		float qty = BigDecimalUtils.decimal(cosmosBalanceJson.getTotal().getAmount(), 6);
		return new BalanceJson("ATOM", qty, "Cosmos wallet");
	}

}
