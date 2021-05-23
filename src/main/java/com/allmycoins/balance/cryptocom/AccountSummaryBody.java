package com.allmycoins.balance.cryptocom;

public final class AccountSummaryBody {

	private final long id;
	private final String method;
	private final String api_key;
	private final String sig;
	private final long nonce;

	public AccountSummaryBody(long pId, String pMethod, String pApiKey, String pSig, long pNonce) {
		id = pId;
		method = pMethod;
		api_key = pApiKey;
		sig = pSig;
		nonce = pNonce;
	}

	public String getApi_key() {
		return api_key;
	}

	public long getId() {
		return id;
	}

	public String getMethod() {
		return method;
	}

	public long getNonce() {
		return nonce;
	}

	public String getSig() {
		return sig;
	}

}
