package com.allmycoins.balance.cosmosjs;

import java.util.List;

public final class CosmosJsProviders {

	private static final List<CosmosJsProvider> PROVIDERS = List.of(
			new CosmosJsProvider("OSMOSIS_ADDRESS", "osmosis", "uosmo", "OSMO"),
			new CosmosJsProvider("AKASH_ADDRESS", "akash", "uakt", "AKT"),
			new CosmosJsProvider("IRISNET_ADDRESS", "iris", "uiris", "IRIS"),
			new CosmosJsProvider("JUNO_ADDRESS", "juno", "ujuno", "JUNO"),
			new CosmosJsProvider("COMDEX_ADDRESS", "comdex", "ucmdx", "CMDX"),
			new CosmosJsProvider("CHIHUAHUA_ADDRESS", "chihuahua", "uhuahua", "HUAHUA"),
			new CosmosJsProvider("STARGAZE_ADDRESS", "stargaze", "ustars", "STARS"),
			new CosmosJsProvider("REGEN_ADDRESS", "regen", "uregen", "REGEN"),
			new CosmosJsProvider("EMONEY_ADDRESS", "emoney", "ungm", "NGM"),
			new CosmosJsProvider("LUM_ADDRESS", "lum", "ulum", "LUM"),
			new CosmosJsProvider("DESMOS_ADDRESS", "desmos", "udsm", "DSM"));

	public static final List<CosmosJsProvider> providers() {
		return PROVIDERS;
	}

}
