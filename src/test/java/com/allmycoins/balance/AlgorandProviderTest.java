package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.algorand.AlgorandProvider;
import com.allmycoins.json.BalanceJson;

final class AlgorandProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		AlgorandProvider algorandProvider = new AlgorandProvider();
		List<BalanceJson> balance = algorandProvider.balances();
		assertEquals(1, balance.size());
		BalanceJson algoBalanceJson = balance.get(0);

		assertEquals("ALGO", algoBalanceJson.getAsset());
		assertEquals("Algorand wallet", algoBalanceJson.getSrc());
		assertTrue(algoBalanceJson.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		AlgorandProvider algorandProvider = new AlgorandProvider();
		List<BalanceJson> balance = algorandProvider.balances();
		assertTrue(balance.isEmpty());
	}
}
