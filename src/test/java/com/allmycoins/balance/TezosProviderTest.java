package com.allmycoins.balance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.allmycoins.PrivateConfig;
import com.allmycoins.balance.tezos.TezosProvider;
import com.allmycoins.json.BalanceJson;

final class TezosProviderTest {

	@Test
	void testBalances() {
		PrivateConfig.loadConfigurationFromClassLoader();

		TezosProvider tezosProvider = new TezosProvider();
		List<BalanceJson> balance = tezosProvider.balances();
		assertEquals(1, balance.size());
		BalanceJson tezosBalanceJson = balance.get(0);

		assertEquals("XTZ", tezosBalanceJson.getAsset());
		assertEquals("Tezos wallet", tezosBalanceJson.getSrc());
		assertTrue(tezosBalanceJson.getQty() >= 0.0f);
	}

	@Test
	void testNoBalances() {
		PrivateConfig.clearConfiguration();

		TezosProvider tezosProvider = new TezosProvider();
		List<BalanceJson> balance = tezosProvider.balances();
		assertTrue(balance.isEmpty());
	}

}
