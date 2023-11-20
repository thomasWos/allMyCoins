package com.allmycoins.balance.multiversx;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for ESDT tokens.
 */
final class ESDTs {

	private static final List<ESDT> ESDTS = List.of(ESDT.values());

	private ESDTs() {
		/* Empty. */
	}

	static final List<String> getIdentifiers() {
		return ESDTS.stream().map(ESDT::getIdentifier).collect(Collectors.toList());
	}

	static final ESDT getEsdt(final String ticker) {
		return ESDTS.stream().filter(esdt -> esdt.getTicker().equals(ticker)).findFirst().get();
	}
}
