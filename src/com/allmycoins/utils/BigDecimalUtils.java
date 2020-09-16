package com.allmycoins.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

	public static float decimal18(BigDecimal bigDecimal) {
		return bigDecimal.divide(BigDecimal.valueOf(10).pow(18)).floatValue();
	}

}
