package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.osmosis.OsmosisProvider;
import com.allmycoins.json.BalanceJson;

final class OsmosisProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		OsmosisProvider provider = new OsmosisProvider();
		List<BalanceJson> balances = provider.balances();
		assertTrue(balances.size() >= 1);

		BalanceJson balance = balances.get(0);

		assertEquals("OSMO", balance.getAsset());
		assertEquals("Osmosis wallet", balance.getSrc());
		assertTrue(balance.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		OsmosisProvider provider = new OsmosisProvider();
		List<BalanceJson> balances = provider.balances();
		assertTrue(balances.isEmpty());
	}
}
