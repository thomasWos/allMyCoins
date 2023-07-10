package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.ethereum.EthProvider;
import com.allmycoins.json.BalanceJson;

class EthereumProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		EthProvider ethereumProvider = new EthProvider();
		List<BalanceJson> balance = ethereumProvider.balances();
		assertTrue(balance.size() >= 1);
		BalanceJson ethereumBalanceJson = balance.get(0);

		assertEquals("ETH", ethereumBalanceJson.getAsset());
		assertEquals("ETH wallet", ethereumBalanceJson.getSrc());
		assertTrue(ethereumBalanceJson.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		EthProvider ethereumProvider = new EthProvider();
		List<BalanceJson> balance = ethereumProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
