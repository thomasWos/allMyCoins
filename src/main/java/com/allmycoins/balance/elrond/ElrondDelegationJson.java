package com.allmycoins.balance.elrond;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ElrondDelegationJson {

	private String address;
	private String contract;
	private BigDecimal userUnBondable;
	private BigDecimal userActiveStake;
	private BigDecimal claimableRewards;

	public BigDecimal getClaimableRewards() {
		return claimableRewards;
	}

	public BigDecimal getUserActiveStake() {
		return userActiveStake;
	}
}
