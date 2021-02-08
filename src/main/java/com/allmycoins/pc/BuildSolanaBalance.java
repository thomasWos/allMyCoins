package com.allmycoins.pc;

import java.math.BigDecimal;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.solana.SolanaBalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildSolanaBalance {

	public static BalanceJson build(SolanaBalanceJson solanaBalanceJson) {

//		BigDecimal allElronds = elrondBalanceRequestJson.getData().getBalance()
//				.add(elrondDelegationJson.getClaimableRewards()).add(elrondDelegationJson.getUserActiveStake())
//				.add(elrondDelegationJson.getUserWaitingStake());
		float qty = BigDecimalUtils.decimal18(BigDecimal.ONE);

		return new BalanceJson("SOL", qty, "Solana wallet");
	}

}
