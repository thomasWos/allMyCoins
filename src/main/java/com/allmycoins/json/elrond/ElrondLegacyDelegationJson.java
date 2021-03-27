package com.allmycoins.json.elrond;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public final class ElrondLegacyDelegationJson {

	private BigDecimal userWithdrawOnlyStake;
	private BigDecimal userWaitingStake;
	private BigDecimal userActiveStake;
	private BigDecimal userUnstakedStake;
	private BigDecimal userDeferredPaymentStake;
	private BigDecimal claimableRewards;

}
