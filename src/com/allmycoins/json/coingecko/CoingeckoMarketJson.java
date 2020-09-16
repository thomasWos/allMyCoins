package com.allmycoins.json.coingecko;

import lombok.Getter;

@Getter
public final class CoingeckoMarketJson {

//	[
//	  {
//	    "id": "bitcoin",
//	    "symbol": "btc",
//	    "name": "Bitcoin",
//	    "image": "https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1547033579",
//	    "current_price": 10524.82,
//	    "market_cap": 194491782135,
//	    "market_cap_rank": 1,
//	    "fully_diluted_valuation": 221021318288,
//	    "total_volume": 53267989894,
//	    "high_24h": 11299.59,
//	    "low_24h": 10024.74,
//	    "price_change_24h": -758.80727792,
//	    "price_change_percentage_24h": -6.72485,
//	    "market_cap_change_24h": -14012314527.045532,
//	    "market_cap_change_percentage_24h": -6.7204,
//	    "circulating_supply": 18479337,
//	    "total_supply": 21000000,
//	    "max_supply": 21000000,
//	    "ath": 19665.39,
//	    "ath_change_percentage": -46.47635,
//	    "ath_date": "2017-12-16T00:00:00.000Z",
//	    "atl": 67.81,
//	    "atl_change_percentage": 15422.47835,
//	    "atl_date": "2013-07-06T00:00:00.000Z",
//	    "roi": null,
//	    "last_updated": "2020-09-04T10:49:00.686Z"
//	  },
//	  {
//	    "id": "ethereum",
//	    "symbol": "eth",
//	    "name": "Ethereum",
//	    "image": "https://assets.coingecko.com/coins/images/279/large/ethereum.png?1595348880",
//	    "current_price": 397.86,
//	    "market_cap": 44750283095,
//	    "market_cap_rank": 2,
//	    "fully_diluted_valuation": null,
//	    "total_volume": 18483061019,
//	    "high_24h": 428.27,
//	    "low_24h": 372.5,
//	    "price_change_24h": -27.36348082,
//	    "price_change_percentage_24h": -6.43507,
//	    "market_cap_change_24h": -3220777296.959045,
//	    "market_cap_change_percentage_24h": -6.714,
//	    "circulating_supply": 112461243.6865,
//	    "total_supply": null,
//	    "max_supply": null,
//	    "ath": 1448.18,
//	    "ath_change_percentage": -72.4575,
//	    "ath_date": "2018-01-13T00:00:00.000Z",
//	    "atl": 0.432979,
//	    "atl_change_percentage": 92021.17584,
//	    "atl_date": "2015-10-20T00:00:00.000Z",
//	    "roi": {
//	      "times": 49.55019036197984,
//	      "currency": "btc",
//	      "percentage": 4955.019036197984
//	    },
//	    "last_updated": "2020-09-04T10:50:27.573Z"
//	  },
//    ....

	public String id;
	public String symbol;
	public String name;
	public String image;
	public float current_price;
	public long market_cap;
	public int market_cap_rank;
	public long fully_diluted_valuation;
	public long total_volume;
	public float high_24h;
	public float low_24h;
	public float price_change_24h;
	public float price_change_percentage_24h;
	public float market_cap_change_24h;
	public float market_cap_change_percentage_24h;
	public long circulating_supply;
	public long total_supply;
	public long max_supply;
	public float ath;
	public float ath_change_percentage;
	public String ath_date;
	public float atl;
	public float atl_change_percentage;
	public String atl_date;
	public Object roi;
	public String last_updated;
}
