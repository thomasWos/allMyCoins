package com.allmycoins.balance.cosmosjs;

import static com.allmycoins.utils.BigDecimalUtils.BIG_DECIMAL_SUM;
import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.Predicate;

import com.allmycoins.balance.PublicAddressSingleBalanceProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.BigDecimalUtils;
import com.allmycoins.utils.RequestUtils;

public final class CosmosJsProvider implements PublicAddressSingleBalanceProvider {

	public static final String COSMOS_DIRECTORY_BASE_URL = "https://rest.cosmos.directory/";

	public final Predicate<CosmosJsBalanceJson> BALANCE_TOKEN_PREDICATE = b -> b.getDenom().equals(denom());

	private final String privateConfigKey;
	private final String network;
	private final String baseUrl;
	private final String denom;
	private final String token;
	private final boolean requestDelegation;

	private CosmosJsBalanceJson[] cosmosJsBalances;

	public CosmosJsProvider(String pPrivateConfigKey, String pNetwork, String pDenom, String pToken) {
		this(pPrivateConfigKey, pNetwork, pDenom, pToken, true);
	}

	CosmosJsProvider(String pPrivateConfigKey, String pNetwork, String pDenom, String pToken,
			boolean aRequestDelegation) {
		privateConfigKey = pPrivateConfigKey;
		network = pNetwork;
		denom = pDenom;
		token = pToken;
		cosmosJsBalances = null;
		baseUrl = COSMOS_DIRECTORY_BASE_URL + pNetwork.toLowerCase();
		requestDelegation = aRequestDelegation;
	}

	private String denom() {
		return denom;
	}

	String network() {
		return network;
	}

	@Override
	public String privateConfigKey() {
		return privateConfigKey;
	}

	@Override
	public BalanceJson singleBalance(String publicAddress) {
		float qty = requestBalance(publicAddress);
		float delegationQty = requestDelegation ? requestDelegation(publicAddress) : 0;
		float rewardQty = requestDelegation ? requestReward(publicAddress) : 0;

		return new BalanceJson(token, qty + delegationQty + rewardQty, network + " wallet");
	}

	public final CosmosJsBalanceJson[] getCosmosJsBalances() {
		return cosmosJsBalances;
	}

	private float requestBalance(String publicAddress) {
		var bankJson = RequestUtils.sendRequest(new CosmosJsBankRequest(baseUrl, publicAddress));
		cosmosJsBalances = bankJson.getBalances();
		BigDecimal amount = Arrays.stream(cosmosJsBalances).filter(BALANCE_TOKEN_PREDICATE)
				.map(CosmosJsBalanceJson::getAmount).reduce(ZERO, BIG_DECIMAL_SUM);
		return toQty(amount);
	}

	private float requestDelegation(String publicAddress) {
		var delegationsJson = RequestUtils.sendRequest(new CosmosJsDelegationsRequest(baseUrl, publicAddress));
		BigDecimal delegationBalance = Arrays.stream(delegationsJson.getDelegation_responses())
				.map(r -> r.getBalance().getAmount()).reduce(ZERO, BIG_DECIMAL_SUM);
		return toQty(delegationBalance);
	}

	private float requestReward(String publicAddress) {
		var rewardJson = RequestUtils.sendRequest(new CosmosJsRewardRequest(baseUrl, publicAddress));
		BigDecimal reward = Arrays.stream(rewardJson.getTotal()).filter(BALANCE_TOKEN_PREDICATE)
				.map(CosmosJsBalanceJson::getAmount).reduce(ZERO, BIG_DECIMAL_SUM);
		return toQty(reward);
	}

	public static final float toQty(BigDecimal bigDecimal) {
		return BigDecimalUtils.decimal(bigDecimal, 6);
	}
}
