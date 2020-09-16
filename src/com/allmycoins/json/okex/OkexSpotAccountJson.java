package com.allmycoins.json.okex;

import lombok.Getter;

@Getter
public final class OkexSpotAccountJson {

	public float frozen;
	public float hold;
	public String id;
	public String currency;
	public float balance;
	public float available;
	public float holds;

}
