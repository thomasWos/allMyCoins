package com.allmycoins.balance.harmony;

import static com.allmycoins.utils.BigDecimalUtils.BIG_DECIMAL_SUM;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Arrays;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildHarmonyBalance {

	public static BalanceJson build(HarmonyBalanceJson harmonyBalance, HarmonyDelegationsJson delegationsJson) {
		BigDecimal totalDelegation = Arrays.stream(delegationsJson.getResult())
				.map(d -> d.getAmount().add(d.getReward())).reduce(ZERO, BIG_DECIMAL_SUM);
		BigDecimal totalHarmony = harmonyBalance.getResult().add(totalDelegation);
		return new BalanceJson("ONE", BigDecimalUtils.decimal18(totalHarmony), "Harmony wallet");
	}

}
