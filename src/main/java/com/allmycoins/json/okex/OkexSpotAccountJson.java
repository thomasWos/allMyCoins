package com.allmycoins.json.okex;

import lombok.Getter;

@Getter
public final class OkexSpotAccountJson {

	private float frozen;
	private float hold;
	private String id;
	private String currency;
	private float balance;
	private float available;
	private float holds;

}
