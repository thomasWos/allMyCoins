package com.allmycoins.balance.cosmosjs;

import java.util.List;
import java.util.function.Function;

public final class CosmosJsProviders {

	public static final Function<CosmosJsProvider, String> LCD_COSMOSSTATION_BUILDER = (cjp) -> "https://lcd-"
			+ cjp.network().toLowerCase() + ".cosmostation.io";

	public static final CosmosJsProvider COSMOS_PROVIDER = new CosmosJsProvider("COSMOS_ADDRESS", "Cosmos", "uatom",
			"ATOM", (cjp) -> "https://api.cosmos.network");

	public static final CosmosJsProvider AKASH_PROVIDER = new CosmosJsProvider("AKASH_ADDRESS", "Akash", "uakt", "AKT",
			LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider IRISNET_PROVIDER = new CosmosJsProvider("IRISNET_ADDRESS", "Iris", "uiris",
			"IRIS", LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider JUNO_PROVIDER = new CosmosJsProvider("JUNO_ADDRESS", "Juno", "ujuno", "JUNO",
			LCD_COSMOSSTATION_BUILDER);
	public static final CosmosJsProvider COMDEX_PROVIDER = new CosmosJsProvider("COMDEX_ADDRESS", "Comdex", "ucmdx",
			"CMDX", LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider CHIHUAHA_PROVIDER = new CosmosJsProvider("CHIHUAHUA_ADDRESS", "Chihuahua",
			"uhuahua", "HUAHUA", LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider STARGAZE_PROVIDER = new CosmosJsProvider("STARGAZE_ADDRESS", "Stargaze",
			"ustars", "STARS", LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider REGEN_PROVIDER = new CosmosJsProvider("REGEN_ADDRESS", "Regen", "uregen",
			"REGEN", LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider EMONEY_PROVIDER = new CosmosJsProvider("EMONEY_ADDRESS", "EMoney", "ungm",
			"NGM", LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider LUM_PROVIDER = new CosmosJsProvider("LUM_ADDRESS", "Lum", "ulum", "LUM",
			LCD_COSMOSSTATION_BUILDER);

	public static final CosmosJsProvider DESMOS_PROVIDER = new CosmosJsProvider("DESMOS_ADDRESS", "Desmos", "udsm",
			"DSM", LCD_COSMOSSTATION_BUILDER);

	private static final List<CosmosJsProvider> PROVIDERS = List.of(COSMOS_PROVIDER, AKASH_PROVIDER, IRISNET_PROVIDER,
			JUNO_PROVIDER, COMDEX_PROVIDER, CHIHUAHA_PROVIDER, STARGAZE_PROVIDER, REGEN_PROVIDER, EMONEY_PROVIDER,
			LUM_PROVIDER, DESMOS_PROVIDER);

	public static final List<CosmosJsProvider> providers() {
		return PROVIDERS;
	}

}
