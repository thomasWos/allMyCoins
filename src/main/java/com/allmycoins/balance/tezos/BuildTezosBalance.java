package com.allmycoins.balance.tezos;

import com.allmycoins.json.BalanceJson;

public final class BuildTezosBalance {

	public static BalanceJson build(TezosBalanceJson tezosBalanceJson) {
		float qty = tezosBalanceJson.getSpendable_balance().floatValue();
		return new BalanceJson("XTZ", qty, "Tezos wallet");
	}

}
