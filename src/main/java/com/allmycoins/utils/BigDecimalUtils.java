package com.allmycoins.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

	public static float decimal(BigDecimal bigDecimal, int n) {
		return bigDecimal.divide(BigDecimal.valueOf(10).pow(n)).floatValue();
	}

	public static float decimal18(BigDecimal bigDecimal) {
		return decimal(bigDecimal, 18);
	}

}