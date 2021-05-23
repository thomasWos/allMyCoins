package com.allmycoins.balance.ethereum;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class EthTokenPayloadJson {

	private List<EthTokenRecordJson> records;

	public List<EthTokenRecordJson> getRecords() {
		return records;
	}
}
