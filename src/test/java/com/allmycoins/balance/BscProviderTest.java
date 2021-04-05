package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.bsc.BscProvider;
import com.allmycoins.json.BalanceJson;

class BscProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		BscProvider bscProvider = new BscProvider();
		List<BalanceJson> balance = bscProvider.balances();
		assertTrue(balance.size() > 0);
		BalanceJson bscBalance = balance.get(0);

		assertEquals("BNB", bscBalance.getAsset());
		assertEquals("BSC wallet", bscBalance.getSrc());
		assertTrue(bscBalance.getQty() >= 0.001f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		BscProvider bscProvider = new BscProvider();
		List<BalanceJson> balance = bscProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
