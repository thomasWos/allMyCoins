package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.json.BalanceJson;

final class BitcoinProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		BitcoinProvider bitcoinProvider = new BitcoinProvider();
		List<BalanceJson> balance = bitcoinProvider.balances();
		assertEquals(1, balance.size());
		BalanceJson balanceJson = balance.get(0);

		assertEquals("BTC", balanceJson.getAsset());
		assertEquals("BTC wallet", balanceJson.getSrc());
		assertTrue(balanceJson.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();
		BitcoinProvider bitcoinProvider = new BitcoinProvider();
		List<BalanceJson> balance = bitcoinProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
