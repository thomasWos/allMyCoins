package com.allmycoins.balance.coinspot;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class CoinspotBalancesBody {

	private final long nonce;

}
