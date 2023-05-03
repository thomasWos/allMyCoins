package com.allmycoins.balance.multiversx;

import static com.allmycoins.utils.BigDecimalUtils.BIG_DECIMAL_SUM;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.concurrent.Future;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.FutureUtils;
import com.allmycoins.utils.RequestUtils;

public final class MultiversXProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "MULTIVERSX_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		Future<MultiversXBalanceRequestJson> multiversXBalanceRequestJsonF = RequestUtils
				.sendRequestFuture(new MultiversXAddressBalanceRequest(publicAddress));

		Future<MultiversXDelegationJson[]> multiversXDelegationsJsonF = RequestUtils
				.sendRequestFuture(new MultiversXDelegationsRequest(publicAddress));

		var multiversXBalanceRequestJson = FutureUtils.futureResult(multiversXBalanceRequestJsonF);
		MultiversXDelegationJson[] multiversXDelegationsJson = FutureUtils.futureResult(multiversXDelegationsJsonF);

		BigDecimal delegation = Arrays.stream(multiversXDelegationsJson).map(this::sumBalances).reduce(ZERO,
				BIG_DECIMAL_SUM);

		BigDecimal allEGLDs = multiversXBalanceRequestJson.getData().getBalance().add(delegation);
		float qty = BigDecimalUtils.decimal18(allEGLDs);
		return new BalanceJson("EGLD", qty, "MultiversX wallet");
	}

	private BigDecimal sumBalances(MultiversXDelegationJson delegation) {
		BigDecimal undelegated = Arrays.stream(delegation.getUserUndelegatedList()).map(UserUndelegatedJson::getAmount)
				.reduce(ZERO, BIG_DECIMAL_SUM);
		return delegation.getUserActiveStake().add(delegation.getClaimableRewards()).add(undelegated);
	}
}
