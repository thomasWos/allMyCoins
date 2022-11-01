package com.allmycoins.balance.algorand;

import java.math.BigDecimal;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

final class BuildAlgorandBalance {

	static final BalanceJson build(AlgorandBalanceJson algorandBalanceJson) {
		float qty = BigDecimalUtils.decimal(BigDecimal.valueOf(algorandBalanceJson.getAmount()), 6);
		return new BalanceJson("ALGO", qty, "Algorand wallet");
	}
}
