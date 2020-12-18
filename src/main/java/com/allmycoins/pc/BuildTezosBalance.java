package com.allmycoins.pc;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.tezos.TezosBalanceJson;

public final class BuildTezosBalance {

	public static BalanceJson build(TezosBalanceJson tezosBalanceJson) {
		float qty = tezosBalanceJson.getTotal_balance().floatValue();
		return new BalanceJson("XTZ", qty, "Tezos wallet");
	}

}
