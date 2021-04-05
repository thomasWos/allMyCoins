package com.allmycoins.balance.ethereum;

import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;

public final class BuildEtherscanBalance {

	public static BalanceJson build(EtherscanBalanceJson etherscanBalanceJson) {
		float qty = BigDecimalUtils.decimal18(etherscanBalanceJson.getResult());
		return new BalanceJson("ETH", qty, "ETH wallet");
	}
}
