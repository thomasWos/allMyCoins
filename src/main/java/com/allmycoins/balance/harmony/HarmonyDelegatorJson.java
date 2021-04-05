package com.allmycoins.balance.harmony;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class HarmonyDelegatorJson {

	private BigDecimal amount;
	private BigDecimal reward;
}
