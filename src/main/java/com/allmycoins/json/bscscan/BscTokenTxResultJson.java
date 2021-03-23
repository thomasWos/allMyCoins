package com.allmycoins.json.bscscan;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class BscTokenTxResultJson {

	private int status;
	private String message;
	private List<BscTokenTxJson> result;

}
