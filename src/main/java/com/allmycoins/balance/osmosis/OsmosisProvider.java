package com.allmycoins.balance.osmosis;

import static com.allmycoins.utils.BigDecimalUtils.BIG_DECIMAL_SUM;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Predicate;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class OsmosisProvider implements PublicAddressSingleBalanceProvider {

	private static final Predicate<OsmosisBalanceJson> OSMO_PREDICATE = b -> b.getDenom().equals("uosmo");

	@Override
	public String privateConfigKey() {
		return "OSMOSIS_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		float qty = requestBalance(publicAddress);
		float delegationQty = requestDelegation(publicAddress);
		float rewardQty = requestReward(publicAddress);

		return new BalanceJson("OSMO", qty + delegationQty + rewardQty, "Osmosis wallet");
	}

	private float requestBalance(String publicAddress) {
		var osmosisBankJson = RequestUtils.sendRequest(new OsmosisBankRequest(publicAddress));
		OsmosisBalanceJson[] balances = osmosisBankJson.getBalances();
		BigDecimal osmoAmount = Arrays.stream(balances).filter(OSMO_PREDICATE).map(OsmosisBalanceJson::getAmount)
				.reduce(ZERO, BIG_DECIMAL_SUM);
		return toQty(osmoAmount);
	}

	private float requestDelegation(String publicAddress) {
		var osmosisDelegationsJson = RequestUtils.sendRequest(new OsmosisDelegationsRequest(publicAddress));
		BigDecimal delegationBalance = Arrays.stream(osmosisDelegationsJson.getDelegation_responses())
				.map(r -> r.getBalance().getAmount()).reduce(ZERO, BIG_DECIMAL_SUM);
		return toQty(delegationBalance);
	}

	private float requestReward(String publicAddress) {
		var osmosisRewardJson = RequestUtils.sendRequest(new OsmosisRewardRequest(publicAddress));
		BigDecimal osmoReward = Arrays.stream(osmosisRewardJson.getTotal()).filter(OSMO_PREDICATE)
				.map(OsmosisBalanceJson::getAmount).reduce(ZERO, BIG_DECIMAL_SUM);
		return toQty(osmoReward);
	}

	private float toQty(BigDecimal bigDecimal) {
		return BigDecimalUtils.decimal(bigDecimal, 6);
	}
}
