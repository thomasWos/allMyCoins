package com.allmycoins.json.harmony;

import lombok.Getter;

@Getter
public final class HarmonyDelegationsJson {

//	{
//		  "jsonrpc": "2.0",
//		  "id": 1,
//		  "result": [
//		    {
//		      "Undelegations": [],
//		      "amount": 117240000000000000000000,
//		      "delegator_address": "one14xl659xzvhwn7yj0s9pfjulm8l226zvdzcq8hm",
//		      "reward": 706649695282891497213,
//		      "validator_address": "one1qk7mp94ydftmq4ag8xn6y80876vc28q7s9kpp7"
//		    },
//		    {
//		      "Undelegations": [],
//		      "amount": 16797000000000000000000,
//		      "delegator_address": "one14xl659xzvhwn7yj0s9pfjulm8l226zvdzcq8hm",
//		      "reward": 84298902104856717017,
//		      "validator_address": "one18hum2avunkz3u448lftwmk7wr88qswdlfvvrdm"
//		    },
//		    {
//		      "Undelegations": [],
//		      "amount": 30304000000000000000000,
//		      "delegator_address": "one14xl659xzvhwn7yj0s9pfjulm8l226zvdzcq8hm",
//		      "reward": 42923962072271062812,
//		      "validator_address": "one16knqzazp2kxra3zx4sw32capqt3esg55wjg7ff"
//		    }
//		  ]
//		}

	private String jsonrpc;
	private int id;
	private HarmonyDelegatorJson[] result;

}
