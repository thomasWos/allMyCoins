package com.allmycoins.balance.multiversx;

enum ESDT {
	/* BTC. */
	ASH("ASH", "ASH-a642d1"),
	/* BHAT. */
	BHAT("BHAT", "BHAT-c1fde3"),
	/* BTC. */
	BTC("BTC", "WBTC", "WBTC-5349b3"),
	/* BUSD. */
	BUSD("BUSD", "BUSD-40b57e"),
	/* CRT. */
	CRT("CRT", "CRT-52decf"),
	/* ETH. */
	ETH("ETH", "WETH", "WETH-b4ca29"),
	/* HSEGLD - Deposited Hatom Staked EGLD. */
	HSEGLD("EGLD", "HSEGLD", "HSEGLD-c13a4e", "HSEGLD"),
	/* HTM. */
	HTM("HTM", "HTM-f51d55"),
	/* ITHEUM. */
	ITHEUM("ITHEUM", "ITHEUM-df6f26"),
	/* MEX. */
	MEX("MEX", "MEX-455c57"),
	/* SUTK. */
	RIDE("RIDE", "RIDE-7d18e9"),
	/* SBHAT. */
	SBHAT("BHAT", "SBHAT", "SBHAT-89efd3", "Staked BHAT"),
	/* SCRT. */
	SCRT("CRT", "SCRT", "SCRT-acbd64", "Staked CRT"),
	/* SHTM. */
	SHTM("HTM", "SHTM", "SHTM-b8b430", "Staked HTM"),
	/* SEGLD - Hatom Staked EGLD. */
	SEGLD("EGLD", "SEGLD", "SEGLD-3ad2d0", "SEGLD"),
	/* SITHEUM. */
	SITHEUM("ITHEUM", "SITHEUM", "SITHEUM-e05083"),
	/* SRIDE. */
	SRIDE("RIDE", "SRIDE", "SRIDE-4ab1d4", "Staked RIDE"),
	/* SUTK. */
	SUTK("UTK", "SUTK", "SUTK-ba35f3", "Staked UTK"),
	/* SZPAY. */
	SZPAY("ZPAY", "SZPAY", "SZPAY-9f1b39", "Staked ZPAY"),
	/* USDT. */
	USDC("USDC", "USDC-c76f1f"),
	/* USDT. */
	USDT("USDT", "USDT-f8c08c"),
	/* UTK. */
	UTK("UTK", "UTK-2f80e9"),
	/* WEGLD. */
	WEGLD("EGLD", "WEGLD", "WEGLD-bd4d79"),
	/* XMEX. */
	XMEX("MEX", "XMEX", "XMEX-fda355"),
	/* SZPAY. */
	ZPAY("ZPAY", "ZPAY-247875");

	/*
	 * Multiple ESDTs can be different version of the same coin. For simplicity,
	 * they are gathered under the reference token.
	 */
	private String referenceSymbol;

	private String ticker;

	private String identifier;

	private String source;

	ESDT(String aTicker, String aIdentifier) {
		referenceSymbol = null;
		ticker = aTicker;
		identifier = aIdentifier;
		source = null;
	}

	ESDT(String aReferenceSymbol, String aTicker, String aIdentifier) {
		referenceSymbol = aReferenceSymbol;
		ticker = aTicker;
		identifier = aIdentifier;
		source = null;
	}

	ESDT(String aReferenceSymbol, String aTicker, String aIdentifier, String aSource) {
		referenceSymbol = aReferenceSymbol;
		ticker = aTicker;
		identifier = aIdentifier;
		source = aSource;
	}

	public String getTicker() {
		return ticker;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getReferenceSymbol() {
		return referenceSymbol != null ? referenceSymbol : ticker;
	}

	public String getSource() {
		return source == null ? "MVX W" : source;
	}
}
