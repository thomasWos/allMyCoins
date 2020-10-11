package com.allmycoins.utils;

public enum SignatureAlgo {

	HMAC_SHA256("HmacSHA256"), HMAC_SHA512("HmacSHA512");

	private final String algoName;

	private SignatureAlgo(String algorithmName) {
		algoName = algorithmName;
	}

	public final String algoName() {
		return algoName;
	}

}
