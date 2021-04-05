package com.allmycoins.balance.solana;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolanaBalanceJson {

	private SolanaResult result;

}
