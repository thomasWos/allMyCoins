package com.allmycoins.balance.solana;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildSolanaBalance {

	public static BalanceJson build(SolanaBalanceJson solanaBalanceJson) {
		float qty = BigDecimalUtils.decimal(solanaBalanceJson.getResult().getValue(), 9);
		return new BalanceJson("SOL", qty, "Solana wallet");
	}

}
