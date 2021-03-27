package com.allmycoins.json.elrond;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ElrondDelegationJson {

	private String address;
	private String contract;
	private BigDecimal userUnBondable;
	private BigDecimal userActiveStake;
	private BigDecimal claimableRewards;

}
