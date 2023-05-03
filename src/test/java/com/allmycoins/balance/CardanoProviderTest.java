package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.cardano.CardanoProvider;
import com.allmycoins.json.BalanceJson;

class CardanoProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		CardanoProvider cardanoProvider = new CardanoProvider();
		List<BalanceJson> balance = cardanoProvider.balances();
		assertTrue(balance.size() > 0);
		BalanceJson bscBalance = balance.get(0);

		assertEquals("ADA", bscBalance.getAsset());
		assertEquals("Cardano wallet", bscBalance.getSrc());
		assertTrue(bscBalance.getQty() >= 0.001f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		CardanoProvider cardanoProvider = new CardanoProvider();
		List<BalanceJson> balance = cardanoProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
