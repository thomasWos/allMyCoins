package com.allmycoins.pc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.allmycoins.datatype.Balance;
import com.allmycoins.datatype.BalancesResult;
import com.allmycoins.json.BalanceJson;

class BuildBalancesResultTest {

	@Test
	void testBuildAllSame() {

		List<BalanceJson> balancesJson = List.of(new BalanceJson("LUNA", 2.3f, "Terra"),
				new BalanceJson("LUNA", 3.2f, "Terra"), new BalanceJson("LUNA", 23f, "Terra"));
		Map<String, Float> pricesMap = Map.of("LUNA", 0.36f);
		BalancesResult balancesResult = BuildBalancesResult.build(balancesJson, pricesMap);

		assertEquals(1, balancesResult.getAssets().size());

		Balance balance = balancesResult.getAssets().get(0).getBalance();
		assertEquals("LUNA", balance.getAsset());
		assertEquals(10.26f, balance.getCurrencyValue());
		assertEquals(28.5f, balance.getQuantity());
		assertEquals("Terra", balance.getSource());

		assertEquals(10.26f, balancesResult.getTotalCurrency());
	}

	@Test
	void testBuildDiff() {
		List<BalanceJson> balancesJson = List.of(new BalanceJson("XTZ", 2f, "Binance"),
				new BalanceJson("XTZ", 3f, "Tezos wallet"), new BalanceJson("XTZ", 20f, "Binance"));
		Map<String, Float> pricesMap = Map.of("XTZ", 2f);
		BalancesResult balancesResult = BuildBalancesResult.build(balancesJson, pricesMap);

		assertEquals(1, balancesResult.getAssets().size());

		Balance balance = balancesResult.getAssets().get(0).getBalance();
		assertEquals("XTZ", balance.getAsset());
		assertEquals(50f, balance.getCurrencyValue());
		assertEquals(25f, balance.getQuantity());
		assertEquals("Binance, Tezos wallet", balance.getSource());
		assertEquals(50f, balancesResult.getTotalCurrency());
	}

}
