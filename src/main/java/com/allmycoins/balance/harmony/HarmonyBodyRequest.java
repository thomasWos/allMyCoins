package com.allmycoins.balance.harmony;

public final class HarmonyBodyRequest {

	private final int id = 1;
	private final String jsonrpc = "2.0";
	private String method;
	private String[] params;

	public HarmonyBodyRequest(String method, String[] params) {
		this.method = method;
		this.params = params;
	}

	public int getId() {
		return id;
	}

	public String getJsonrpc() {
		return jsonrpc;
	}

	public String getMethod() {
		return method;
	}

	public String[] getParams() {
		return params;
	}

}
