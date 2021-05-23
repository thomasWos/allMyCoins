package com.allmycoins.balance.harmony;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class HarmonyDelegationsJson {

	private HarmonyDelegatorJson[] result;

	public HarmonyDelegatorJson[] getResult() {
		return result;
	}
}
