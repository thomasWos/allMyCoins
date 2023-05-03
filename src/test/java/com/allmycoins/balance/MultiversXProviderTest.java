package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.multiversx.MultiversXProvider;
import com.allmycoins.json.BalanceJson;

final class MultiversXProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		MultiversXProvider provider = new MultiversXProvider();
		List<BalanceJson> balance = provider.balances();
		assertEquals(1, balance.size());
		BalanceJson balanceJson = balance.get(0);

		assertEquals("EGLD", balanceJson.getAsset());
		assertEquals("MultiversX wallet", balanceJson.getSrc());
		assertTrue(balanceJson.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		MultiversXProvider provider = new MultiversXProvider();
		List<BalanceJson> balance = provider.balances();
		assertTrue(balance.isEmpty());
	}
}
