package com.allmycoins.balance.cosmosjs;

import java.util.List;

public final class CosmosJsProviders {

	private static final List<CosmosJsProvider> PROVIDERS = List.of(
			new CosmosJsProvider("OSMOSIS_ADDRESS", "osmosis", "uosmo", "OSMO"),
			new CosmosJsProvider("AKASH_ADDRESS", "akash", "uakt", "AKT"),
			new CosmosJsProvider("IRISNET_ADDRESS", "iris", "uiris", "IRIS"),
			new CosmosJsProvider("JUNO_ADDRESS", "juno", "ujuno", "JUNO"));

	public static final List<CosmosJsProvider> providers() {
		return PROVIDERS;
	}

}
