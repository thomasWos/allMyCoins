package com.allmycoins.balance.polkadot;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class PolkadotAttributesJson {

	private BigDecimal balance_total;

}
