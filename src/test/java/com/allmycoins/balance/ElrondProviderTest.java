package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.elrond.ElrondProvider;
import com.allmycoins.json.BalanceJson;

final class ElrondProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		ElrondProvider elrondProvider = new ElrondProvider();
		List<BalanceJson> balance = elrondProvider.balances();
		assertEquals(1, balance.size());
		BalanceJson elrondBalanceJson = balance.get(0);

		assertEquals("EGLD", elrondBalanceJson.getAsset());
		assertEquals("Elrond wallet", elrondBalanceJson.getSrc());
		assertTrue(elrondBalanceJson.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		ElrondProvider elrondProvider = new ElrondProvider();
		List<BalanceJson> balance = elrondProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
