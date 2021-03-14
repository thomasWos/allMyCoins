package com.allmycoins.pc;

import java.math.BigDecimal;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.elrond.ElrondBalanceRequestJson;
import com.allmycoins.json.elrond.ElrondDelegationJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildElrondBalance {

	public static BalanceJson build(ElrondBalanceRequestJson elrondBalanceRequestJson,
			ElrondDelegationJson elrondDelegationJson) {

		BigDecimal allElronds = elrondBalanceRequestJson.getData().getBalance()
				.add(elrondDelegationJson.getClaimableRewards()).add(elrondDelegationJson.getUserActiveStake())
				.add(elrondDelegationJson.getUserWaitingStake())
				.add(elrondDelegationJson.getUserDeferredPaymentStake());
		float qty = BigDecimalUtils.decimal18(allElronds);

		return new BalanceJson("EGLD", qty, "Elrond wallet");
	}

}
