package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;

final class CosmosProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		CosmosProvider cosmosProvider = new CosmosProvider();
		List<BalanceJson> balance = cosmosProvider.balances();
		assertEquals(1, balance.size());

		BalanceJson cosmosBalance = balance.get(0);

		assertEquals("ATOM", cosmosBalance.getAsset());
		assertEquals("Cosmos wallet", cosmosBalance.getSrc());
		assertTrue(cosmosBalance.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		CosmosProvider cosmosProvider = new CosmosProvider();
		List<BalanceJson> balance = cosmosProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
