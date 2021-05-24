package com.allmycoins.balance.elrond;

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

public final class ElrondProvider implements PublicAddressSingleBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "ELROND_ADDRESS";
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		Future<ElrondBalanceRequestJson> elrondBalanceRequestJsonF = RequestUtils
				.sendRequestFuture(new ElrondAddressBalanceRequest(publicAddress));

		Future<ElrondDelegationJson[]> elrondDelegationsJsonF = RequestUtils
				.sendRequestFuture(new ElrondDelegationsRequest(publicAddress));

		ElrondBalanceRequestJson elrondBalanceRequestJson = FutureUtils.futureResult(elrondBalanceRequestJsonF);
		ElrondDelegationJson[] elrondDelegationsJson = FutureUtils.futureResult(elrondDelegationsJsonF);

		BigDecimal delegation = Arrays.stream(elrondDelegationsJson).map(this::sumBalances).reduce(ZERO,
				BIG_DECIMAL_SUM);

		BigDecimal allElronds = elrondBalanceRequestJson.getData().getBalance().add(delegation);
		float qty = BigDecimalUtils.decimal18(allElronds);
		return new BalanceJson("EGLD", qty, "Elrond wallet");
	}

	private BigDecimal sumBalances(ElrondDelegationJson delegation) {
		BigDecimal undelegated = Arrays.stream(delegation.getUserUndelegatedList()).map(UserUndelegatedJson::getAmount)
				.reduce(ZERO, BIG_DECIMAL_SUM);
		return delegation.getUserActiveStake().add(delegation.getClaimableRewards()).add(undelegated)
				.add(delegation.getUserUnBondable());
	}

}
