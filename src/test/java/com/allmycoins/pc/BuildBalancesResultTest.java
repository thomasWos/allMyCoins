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
	void testBuild() {

		List<BalanceJson> balancesJson = List.of(new BalanceJson("LUNA", 2.3f, "Terra"),
				new BalanceJson("LUNA", 3.2f, "Terra"), new BalanceJson("LUNA", 23f, "Terra"));
		Map<String, Float> pricesMap = Map.of("LUNA", 0.36f);
		BalancesResult balancesResult = BuildBalancesResult.build(balancesJson, pricesMap);

		assertEquals(1, balancesResult.getBalances().size());

		Balance balance = balancesResult.getBalances().get(0);
		assertEquals("LUNA", balance.getAsset());
		assertEquals(10.26f, balance.getCurrencyValue());
		assertEquals(28.5f, balance.getQuantity());
		assertEquals("Terra", balance.getSource());

		assertEquals(10.26f, balancesResult.getTotalCurrency());
	}

}
