package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.cosmosjs.CosmosJsProvider;
import com.allmycoins.json.BalanceJson;

final class AkashProviderTest {

	private static final Supplier<CosmosJsProvider> GET_PROVIDER = () -> new CosmosJsProvider("AKASH_ADDRESS", "akash",
			"uakt", "AKT");

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		CosmosJsProvider provider = GET_PROVIDER.get();
		List<BalanceJson> balances = provider.balances();
		assertEquals(1, balances.size());

		BalanceJson balance = balances.get(0);

		assertEquals("AKT", balance.getAsset());
		assertEquals("akash wallet", balance.getSrc());
		assertTrue(balance.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		CosmosJsProvider provider = GET_PROVIDER.get();
		List<BalanceJson> balances = provider.balances();
		assertTrue(balances.isEmpty());
	}
}
