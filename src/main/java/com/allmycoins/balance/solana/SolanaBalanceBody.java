package com.allmycoins.balance.solana;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class SolanaBalanceBody {

	private final int id = 1;
	private final String jsonrpc = "2.0";
	private String method;
	private String[] params;

}
