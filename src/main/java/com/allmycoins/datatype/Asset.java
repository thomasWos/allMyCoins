package com.allmycoins.datatype;

public final class Asset {
	private final Balance balance;
	private final float ratio;
	private final int marketCapRank;

	public Asset(Balance balance, float ratio, int marketCapRank) {
		this.balance = balance;
		this.ratio = ratio;
		this.marketCapRank = marketCapRank;
	}

	public Balance getBalance() {
		return balance;
	}

	public int getMarketCapRank() {
		return marketCapRank;
	}

	public float getRatio() {
		return ratio;
	}

}
