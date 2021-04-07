package com.allmycoins.balance.polkadot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PolkadotAccountJson {

	PolkadotAccountDataJson data;

}
