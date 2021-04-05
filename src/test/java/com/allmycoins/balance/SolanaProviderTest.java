package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.solana.SolanaProvider;
import com.allmycoins.json.BalanceJson;

class SolanaProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		SolanaProvider solanaProvider = new SolanaProvider();
		List<BalanceJson> balance = solanaProvider.balances();
		assertEquals(1, balance.size());
		BalanceJson solanaBalanceJson = balance.get(0);

		assertEquals("SOL", solanaBalanceJson.getAsset());
		assertEquals("Solana wallet", solanaBalanceJson.getSrc());
		assertTrue(solanaBalanceJson.getQty() >= 1f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		SolanaProvider solanaProvider = new SolanaProvider();
		List<BalanceJson> balance = solanaProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
