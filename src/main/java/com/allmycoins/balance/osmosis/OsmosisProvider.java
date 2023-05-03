package com.allmycoins.balance.osmosis;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.allmycoins.balance.PublicAddressBalanceProvider;
import com.allmycoins.balance.cosmosjs.CosmosJsBalanceJson;
import com.allmycoins.balance.cosmosjs.CosmosJsProvider;
import com.allmycoins.json.BalanceJson;
import com.allmycoins.utils.RequestUtils;

public final class OsmosisProvider implements PublicAddressBalanceProvider {

	private static final String TOKEN = "OSMO";

	/* From https://docs.osmosis.zone/osmosis-core/asset-info/. */
	private static final Map<String, String> IBC_DENOM_TO_SYMBOL_MAP = new HashMap<>();

	static {
		IBC_DENOM_TO_SYMBOL_MAP.put("uosmo", "OSMO");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/27394FB092D2ECCD56123C74F36E4C1F926001CEADA9CA97EA622B25F41E5EB2", "ATOM");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/0EF15DF2F02480ADE0BB6E85D9EBB5DAEA2836D3860E9F97F9AADE4F57A31AA0", "LUNC");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/E6931F78057F7CC5DA0FD6CEF82FF39373A6E0452BF1FD76910B93292CF356C1", "CRO");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/BE1BB42D4BE3C30D50B68D7C41DB4DFCE9678E8EF8C539F6E6A9345048894FCC", "UST");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/0954E1C28EB7AF5B72D24F3BC2B47BBB2FDF91BDDFD57B74B99E133AED40972A", "SCRT");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/46B44899322F3CD854D2D46DEEF881958467CDD4B3B10086DA49296BBED94BED", "JUNO");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/A0CC0CF735BFB30E730C70019D4218A1244FF383503FF7579C9201AB93CA9293", "XPRT");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/204A582244FC241613DBB50B04D1D454116C58C4AF7866C186AA0D6EEAD42780", "KRT");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/1480B8FD20AD5FCAE81EA87584D269547DD4D436843C1D20F15E00EB64743EF4", "AKT");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/1DCC8A6CB5689018431323953344A9F6CC4D0BFB261E88C9F7777372C10CD076", "REGEN");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/9712DBB13B9631EDFA9BF61B55F1B2D290B2ADB67E3A4EB3A875F3B6081B3B84", "DVPN");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/7C4D60AA95E5A7558B0A364860979CA34B7FF8AAF255B87AF9E879374470CEC0", "IRIS");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/52B1AA623B34EB78FD767CEA69E8D7FA6C9CFE1FBF49C5406268FD325E2CC2AC", "IOV");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/1DC495FCEFDA068A3820F903EDBD78B942FBD204D7E93D3BA2B432E9669D1A59", "NGM");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/5973C068568365FFF40DEDCF1A1CB7582B6116B731CD31A12231AE25E20B871F", "EEUR");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/655BCEF3CDEBE32863FF281DBBE3B06160339E9897DC9C9C9821932A5F8BA6F8", "TICK");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/9989AD6CCA39D1131523DB0617B50F6442081162294B4795E26746292467B525", "LIKE");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/F3FF7A84A73B62921538642F9797C423D2B4C4ACB3C7FCFFCE7F12AA69909C4B", "IXO");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/D805F1DA50D31B96E4282C1D4181EDDFB1A44A598BFF5666F4B43E4B8BEA95A5", "BCNA");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/4E5444C35610CC76FC94E7F7886B93121175C28262DDFDDE6F84E82BF2425452", "BTSG");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/B547DC9B897E7C3AA5B824696110B8E3D2C31E3ED3F02FF363DCBAD82457E07E", "XKI");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/3BCCC93AD5DF58D11A6F8A05FA8BC801CBA0BA61A981F57E91B8B598BF8061CB", "MED");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/E6931F78057F7CC5DA0FD6CEF82FF39373A6E0452BF1FD76910B93292CF356C1", "BOOT");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/EA3E1640F9B1532AB129A571203A0B9F789A7F14BB66E350DCBFA18E1A1931F0", "CMDX");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/7A08C6F11EF0F59EB841B9F788A87EC9F2361C7D9703157EC13D940DC53031FA", "CHEQ");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/987C17B11ABC2B20019178ACE62929FE9840202CE79498E29FE8E5CB02B7C0A4", "STARS");
		IBC_DENOM_TO_SYMBOL_MAP.put("ibc/B9E0A1A524E98BB407D3CED8720EFEFD186002F90C1B1B7964811DD0CCC12228", "HUAHUA");
	}

	private static final String PRIVATE_CONFIG_KEY = "OSMOSIS_ADDRESS";

	/*
	 * Tokens representing share in a LP pool are named gamm/pool/X where X is the
	 * pool index.
	 */
	private static final String POOL_LP_DENOM = "gamm/pool/";

	private static final Predicate<CosmosJsBalanceJson> LP_TOKEN_PREDICATE = b -> b.getDenom().contains(POOL_LP_DENOM);

	private static final Function<CosmosJsBalanceJson, Integer> TO_POOL_INDEX = b -> Integer
			.valueOf(b.getDenom().substring(POOL_LP_DENOM.length()));

	@Override
	public final List<BalanceJson> balance(String publicAddress) {
		/*
		 * The CosmosJs provider retrieves OSMO balance on the account, as well as the
		 * delegation and rewards.
		 */
		CosmosJsProvider osmosisBalanceProvider = new CosmosJsProvider(PRIVATE_CONFIG_KEY, "Osmosis", "uosmo", TOKEN);
		List<BalanceJson> balances = osmosisBalanceProvider.balances();

		/*
		 * Contains the full answer from the balances request - also contains all the
		 * other coins held on that OSMO address - either simple coins, or LP coins.
		 */
		CosmosJsBalanceJson[] cosmosJsBalances = osmosisBalanceProvider.getCosmosJsBalances();

		Map<String, BigDecimal> coinDenomToAmountMap = Arrays.stream(cosmosJsBalances)
				.filter(osmosisBalanceProvider.BALANCE_TOKEN_PREDICATE.negate())
				.collect(Collectors.toMap(CosmosJsBalanceJson::getDenom, CosmosJsBalanceJson::getAmount));

		List<BalanceJson> otherCoinsBalances = coinDenomToAmountMap.entrySet().stream()
				.filter(e -> IBC_DENOM_TO_SYMBOL_MAP.containsKey(e.getKey()))
				.map(e -> new BalanceJson(IBC_DENOM_TO_SYMBOL_MAP.get(e.getKey()), CosmosJsProvider.toQty(e.getValue()),
						TOKEN + " wallet"))
				.collect(Collectors.toList());
		balances.addAll(otherCoinsBalances);

		/* Map containing the liquid LP tokens of the account, per pool index. */
		Map<Integer, BigDecimal> poolIndexToLpAmountMap = Arrays.stream(cosmosJsBalances).filter(LP_TOKEN_PREDICATE)
				.collect(Collectors.toMap(TO_POOL_INDEX, CosmosJsBalanceJson::getAmount));

		Map<Integer, BigDecimal> poolIndexToLockedLpAmountMap = requestLockedCoins(publicAddress);

		poolIndexToLockedLpAmountMap.forEach((index, amount) -> {
			if (poolIndexToLpAmountMap.containsKey(index)) {
				poolIndexToLpAmountMap.merge(index, amount, BigDecimal::add);
			} else {
				poolIndexToLpAmountMap.put(index, amount);
			}
		});

		poolIndexToLpAmountMap.entrySet().forEach(e -> balances.addAll(requestPoolInfo(e)));

		return balances;
	}

	@Override
	public final String privateConfigKey() {
		return PRIVATE_CONFIG_KEY;
	}

	private Map<Integer, BigDecimal> requestLockedCoins(String publicAddress) {
		var lockedCoinsJson = RequestUtils.sendRequest(new OsmosisLockedCoinsRequest(publicAddress));
		return Arrays.stream(lockedCoinsJson.getCoins())
				.collect(Collectors.toMap(TO_POOL_INDEX, CosmosJsBalanceJson::getAmount));
	}

	private List<BalanceJson> requestPoolInfo(Entry<Integer, BigDecimal> pool) {
		Float poolAmount = CosmosJsProvider.toQty(pool.getValue());

		OsmosisPoolInfoJson poolInfoJson = RequestUtils
				.sendRequest(new OsmosisPoolInfoRequest(Integer.toString(pool.getKey())));

		Float poolTotalAmount = CosmosJsProvider.toQty(poolInfoJson.getPool().getTotalShares().getAmount());

		Float poolShare = poolAmount / poolTotalAmount;
		return Arrays.asList(poolInfoJson.getPool().getPoolAssets()).stream().map(PoolAssetJson::getToken)
				.map(poolAsset -> {
					String coinSymbol = IBC_DENOM_TO_SYMBOL_MAP.get(poolAsset.getDenom());
					Float coinAmount = CosmosJsProvider.toQty(poolAsset.getAmount()) * poolShare;
					return new BalanceJson(coinSymbol, coinAmount, "OSMO LP");
				}).collect(Collectors.toList());
	}
}
