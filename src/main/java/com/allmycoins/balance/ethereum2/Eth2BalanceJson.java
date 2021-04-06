package com.allmycoins.balance.ethereum2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Eth2BalanceJson {

	private Eth2BalanceDataJson data;

}
