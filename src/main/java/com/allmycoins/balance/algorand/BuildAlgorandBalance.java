package com.allmycoins.balance.algorand;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildAlgorandBalance {

	public static BalanceJson build(AlgorandBalanceJson algorandBalanceJson) {
		float qty = BigDecimalUtils.decimal(algorandBalanceJson.getBalance(), 6);
		return new BalanceJson("ALGO", qty, "Algorand wallet");
	}

}
