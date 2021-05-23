package com.allmycoins.balance.coinspot;

public final class CoinspotBalancesBody {

	private final long nonce;

	public CoinspotBalancesBody(long pNonce) {
		nonce = pNonce;
	}

	public long getNonce() {
		return nonce;
	}

}
