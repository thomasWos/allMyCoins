package com.allmycoins.pc;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Arrays;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.json.elrond.ElrondBalanceRequestJson;
import com.allmycoins.json.elrond.ElrondDelegationJson;
import com.allmycoins.json.elrond.ElrondLegacyDelegationJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildElrondBalance {

	public static BalanceJson build(ElrondBalanceRequestJson elrondBalanceRequestJson,
			ElrondLegacyDelegationJson elrondDelegationJson, ElrondDelegationJson[] elrondDelegationsJson) {

		BigDecimal legacyDelegation = elrondDelegationJson.getClaimableRewards()
				.add(elrondDelegationJson.getUserActiveStake()).add(elrondDelegationJson.getUserWaitingStake())
				.add(elrondDelegationJson.getUserDeferredPaymentStake());

		BigDecimal delegation = Arrays.stream(elrondDelegationsJson)
				.map(d -> d.getUserActiveStake().add(d.getClaimableRewards())).reduce(ZERO, (d1, d2) -> d1.add(d2));

		BigDecimal allElronds = elrondBalanceRequestJson.getData().getBalance().add(legacyDelegation).add(delegation);
		float qty = BigDecimalUtils.decimal18(allElronds);

		return new BalanceJson("EGLD", qty, "Elrond wallet");
	}

}
