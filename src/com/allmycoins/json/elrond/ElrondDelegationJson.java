package com.allmycoins.json.elrond;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public final class ElrondDelegationJson {

	private BigDecimal claimableRewards;
	private BigDecimal userStake;

}
