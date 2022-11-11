package com.allmycoins.balance;

final class JunoProviderTest {

	// Temporarilly disabled
//	private static final Supplier<CosmosJsProvider> GET_PROVIDER = () -> CosmosJsProviders.JUNO_PROVIDER;
//
//	@Test
//	void testBalances() {
//		PrivateConfig.loadConfigurationFromClassLoader();
//
//		CosmosJsProvider provider = GET_PROVIDER.get();
//		List<BalanceJson> balances = provider.balances();
//		assertEquals(1, balances.size());
//
//		BalanceJson balance = balances.get(0);
//
//		assertEquals("JUNO", balance.getAsset());
//		assertEquals("Juno wallet", balance.getSrc());
//		assertTrue(balance.getQty() >= 0.0f);
//	}
//
//	@Test
//	void testNoBalances() {
//		PrivateConfig.clearConfiguration();
//
//		CosmosJsProvider provider = GET_PROVIDER.get();
//		List<BalanceJson> balance = provider.balances();
//		assertTrue(balance.isEmpty());
//	}
}
