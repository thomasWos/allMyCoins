package com.allmycoins.request.harmony;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class HarmonyBodyRequest {

	private final int id = 1;
	private final String jsonrpc = "2.0";
	private String method;
	private String[] params;

}
