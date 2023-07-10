package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.avalanche.AvalancheProvider;
import com.allmycoins.json.BalanceJson;

class AvalancheProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		AvalancheProvider avalancheProvider = new AvalancheProvider();
		List<BalanceJson> balance = avalancheProvider.balances();
		assertTrue(balance.size() >= 1);
		BalanceJson balanceJson = balance.get(0);

		assertEquals("AVAX", balanceJson.getAsset());
		assertEquals("Avalanche C wallet", balanceJson.getSrc());
		assertTrue(balanceJson.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		AvalancheProvider avalancheProvider = new AvalancheProvider();
		List<BalanceJson> balance = avalancheProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
