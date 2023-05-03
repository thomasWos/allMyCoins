package com.allmycoins.balance.cosmosjs;

import java.util.List;

public final class CosmosJsProviders {

	public static final CosmosJsProvider COSMOS_PROVIDER = new CosmosJsProvider("COSMOS_ADDRESS", "CosmosHub", "uatom",
			"ATOM");

	public static final CosmosJsProvider AKASH_PROVIDER = new CosmosJsProvider("AKASH_ADDRESS", "Akash", "uakt", "AKT");

	public static final CosmosJsProvider IRISNET_PROVIDER = new CosmosJsProvider("IRISNET_ADDRESS", "IrisNet", "uiris",
			"IRIS");

	public static final CosmosJsProvider JUNO_PROVIDER = new CosmosJsProvider("JUNO_ADDRESS", "Juno", "ujuno", "JUNO");

	public static final CosmosJsProvider COMDEX_PROVIDER = new CosmosJsProvider("COMDEX_ADDRESS", "Comdex", "ucmdx",
			"CMDX");

	public static final CosmosJsProvider CHIHUAHA_PROVIDER = new CosmosJsProvider("CHIHUAHUA_ADDRESS", "Chihuahua",
			"uhuahua", "HUAHUA");

	public static final CosmosJsProvider STARGAZE_PROVIDER = new CosmosJsProvider("STARGAZE_ADDRESS", "Stargaze",
			"ustars", "STARS");

	public static final CosmosJsProvider REGEN_PROVIDER = new CosmosJsProvider("REGEN_ADDRESS", "Regen", "uregen",
			"REGEN");

	public static final CosmosJsProvider EMONEY_PROVIDER = new CosmosJsProvider("EMONEY_ADDRESS", "EMoney", "ungm",
			"NGM");

	public static final CosmosJsProvider LUM_PROVIDER = new CosmosJsProvider("LUM_ADDRESS", "LumNetwork", "ulum",
			"LUM");

	public static final CosmosJsProvider DESMOS_PROVIDER = new CosmosJsProvider("DESMOS_ADDRESS", "Desmos", "udsm",
			"DSM");

	private static final List<CosmosJsProvider> PROVIDERS = List.of(COSMOS_PROVIDER, AKASH_PROVIDER, IRISNET_PROVIDER,
			COMDEX_PROVIDER, CHIHUAHA_PROVIDER, STARGAZE_PROVIDER, REGEN_PROVIDER, EMONEY_PROVIDER, LUM_PROVIDER,
			DESMOS_PROVIDER);

	public static final List<CosmosJsProvider> providers() {
		return PROVIDERS;
	}
}
