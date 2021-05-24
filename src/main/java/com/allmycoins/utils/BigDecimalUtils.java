package com.allmycoins.utils;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public final class BigDecimalUtils {

	public static final BinaryOperator<BigDecimal> BIG_DECIMAL_SUM = (d1, d2) -> d1.add(d2);

	public static float decimal(BigDecimal bigDecimal, int n) {
		return bigDecimal.divide(BigDecimal.valueOf(10).pow(n)).floatValue();
	}

	public static float decimal18(BigDecimal bigDecimal) {
		return decimal(bigDecimal, 18);
	}

	private BigDecimalUtils() {
	}

}
