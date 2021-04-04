package com.allmycoins.pc;

import java.math.BigDecimal;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.cardano.CardanoBalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public class BuildCardanoBalance {

	public static BalanceJson build(CardanoBalanceJson balanceJson) {
		String balance = balanceJson.getInfo()[2];
		BigDecimal balanceDecimal = new BigDecimal(balance);
		float qty = BigDecimalUtils.decimal(balanceDecimal, 6);
		return new BalanceJson("ADA", qty, "Cardano wallet");
	}

}
