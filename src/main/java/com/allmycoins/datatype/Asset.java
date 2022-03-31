package com.allmycoins.datatype;

import static java.util.Comparator.reverseOrder;

import java.util.Comparator;
import java.util.function.Predicate;

public final class Asset {

	public static final Comparator<Asset> ASSET_COMP = Comparator.comparing(a -> a.getBalance().getCurrencyValue(),
			reverseOrder());

	public static final Predicate<Asset> ASSET_NOT_WORTH_ZERO = a -> a.getBalance().getCurrencyValue() >= 0.01f
			|| a.getBalance().getCurrencyValue() <= -0.01f;

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
