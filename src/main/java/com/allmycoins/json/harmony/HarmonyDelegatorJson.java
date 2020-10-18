package com.allmycoins.json.harmony;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public final class HarmonyDelegatorJson {

//    {
//    "Undelegations": [],
//    "amount": 117240000000000000000000,
//    "delegator_address": "one14xl659xzvhwn7yj0s9pfjulm8l226zvdzcq8hm",
//    "reward": 706649695282891497213,
//    "validator_address": "one1qk7mp94ydftmq4ag8xn6y80876vc28q7s9kpp7"
//  }

	private BigDecimal amount;
	private BigDecimal reward;
}
