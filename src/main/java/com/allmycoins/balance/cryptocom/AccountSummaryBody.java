package com.allmycoins.balance.cryptocom;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class AccountSummaryBody {

	private final long id;
	private final String method;
	private final String api_key;
	private final String sig;
	private final long nonce;

}
