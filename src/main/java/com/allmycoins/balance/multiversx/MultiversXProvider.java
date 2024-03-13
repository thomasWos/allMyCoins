package com.allmycoins.balance.multiversx;

import static com.allmycoins.utils.BigDecimalUtils.BIG_DECIMAL_SUM;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class MultiversXProvider implements PublicAddressBalanceProvider {

	@Override
	public String privateConfigKey() {
		return "MULTIVERSX_ADDRESS";
	}

	private BalanceJson getEgldBalance(String publicAddress) {
		BigDecimal egldWalletBalance = getEgldWalletBalance(publicAddress);
		BigDecimal delegationBalance = getEgldDelegationBalance(publicAddress);

		BigDecimal allEGLDs = egldWalletBalance.add(delegationBalance);
		float qty = BigDecimalUtils.decimal18(allEGLDs);

		return new BalanceJson("EGLD", qty, "MVX W");
	}

	private List<BalanceJson> getEgldWalletEsdtBalances(String publicAddress) {
		MultiversXEsdtBalanceJson[] esdtBalanceJsons = RequestUtils
				.sendRequest(new MultiversXEsdtBalancesRequest(publicAddress));

		return List.of(esdtBalanceJsons).stream().map(this::toBalanceJson).collect(Collectors.toList());
	}

	private BalanceJson toBalanceJson(MultiversXEsdtBalanceJson balance) {
		ESDT esdt = ESDTs.getEsdt(balance.getTicker());
		return new BalanceJson(esdt.getReferenceSymbol(),
				BigDecimalUtils.decimal(balance.getBalance(), balance.getDecimals().intValue()), esdt.getSource());
	}

	private BigDecimal getEgldWalletBalance(String publicAddress) {
		return RequestUtils.sendRequest(new MultiversXAddressBalanceRequest(publicAddress)).getData().getBalance();
	}

	private BigDecimal getEgldDelegationBalance(String publicAddress) {
		MultiversXDelegationJson[] multiversXDelegationsJson = RequestUtils
				.sendRequest(new MultiversXDelegationsRequest(publicAddress));
		return Arrays.stream(multiversXDelegationsJson).map(this::sumBalances).reduce(ZERO, BIG_DECIMAL_SUM);

	}

	private BigDecimal sumBalances(MultiversXDelegationJson delegation) {
		BigDecimal undelegated = Arrays.stream(delegation.getUserUndelegatedList()).map(UserUndelegatedJson::getAmount)
				.reduce(ZERO, BIG_DECIMAL_SUM);
		return delegation.getUserActiveStake().add(delegation.getClaimableRewards()).add(undelegated);
	}

	@Override
	public List<BalanceJson> balance(String publicAddress) {
		List<BalanceJson> esdtBalances = getEgldWalletEsdtBalances(publicAddress);
		BalanceJson egldBalance = getEgldBalance(publicAddress);
		esdtBalances.add(0, egldBalance);
		return esdtBalances;
	}
}
