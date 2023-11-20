# AllMyCoins

AllMyCoins is a simple crypto portfolio manager.

- Ask your own API keys for exchangers (Read only is enough)
- Provide your public addresses
- Otherwise manually provide a list of tokens with quantities

## Features

- Automatically fetch your exchanger balances 
- Automatically fetch your balances and stacking rewards from blockchain addresses
- Support multiple currencies (USD, EUR, BTC, AUD...)

### Exchangers

- <img src="https://assets.coingecko.com/markets/images/52/small/binance.jpg" alt="Binance" width="15"/> Binance spot - https://www.binance.com
- <img src="https://assets.coingecko.com/markets/images/96/small/okEX.jpg" alt="OKEx" width="15"/> OKEx Unified - https://www.okex.com
- <img src="https://assets.coingecko.com/markets/images/589/small/crypto_com.jpg" alt="crypto.com" width="15"/> https://crypto.com/exchange
- Coinspot - https://coinspot.com.au
- Swyftx - https://swyftx.com.au

### Blockchain public addresses

- <img src="https://assets.coingecko.com/coins/images/1/thumb_2x/bitcoin.png" alt="BTC" width="15"/> Bitcoin
- <img src="https://assets.coingecko.com/coins/images/279/thumb_2x/ethereum.png" alt="ETH" width="15"/> Ethereum
- <img src="https://assets.coingecko.com/coins/images/279/thumb_2x/ethereum.png" alt="ETH" width="15"/> Ethereum2.0 validator
- <img src="https://assets.coingecko.com/coins/images/825/small/binance-coin-logo.png" alt="BNB" width="15"/> Binance Smart Chain
- <img src="https://assets.coingecko.com/coins/images/12171/small/aJGBjJFU_400x400.jpg" alt="DOT" width="15"/> Polkadot
- <img src="https://assets.coingecko.com/coins/images/975/small/cardano.png" alt="ADA" width="15"/> Cardano
- <img src="https://assets.coingecko.com/coins/images/2/small/litecoin.png?1547033580" alt="LTC" width="15"/> Litecoin
- <img src="https://assets.coingecko.com/coins/images/976/thumb_2x/Tezos-logo.png" alt="XTZ" width="15"/> Tezos
- <img src="https://assets.coingecko.com/coins/images/12335/thumb_2x/Elrond.png" alt="Elrond" width="15"/> MultiversX
- <img src="https://assets.coingecko.com/coins/images/4128/thumb_2x/RPU3hzmh_400x400.jpg" alt="Solana" width="15"/> Solana
- <img src="https://assets.coingecko.com/coins/images/4380/thumb_2x/download.png" alt="ALGO" width="15"/> Algorand
- <img src="https://assets.coingecko.com/coins/images/4344/thumb_2x/Y88JAze.png" alt="ONE" width="15"/> Harmony

##### Cosmos ecosystem
- <img src="https://assets.coingecko.com/coins/images/1481/thumb_2x/cosmos_hub.png" alt="ATOM" width="15"/> Cosmos
- <img src="https://assets.coingecko.com/coins/images/16724/small/osmosis.jpeg?1624849879" alt="OSMO" width="15"/> Osmosis
- <img src="https://assets.coingecko.com/coins/images/12785/small/akash-logo.png" alt="AKASH" width="15"/> Akash
- <img src="https://assets.coingecko.com/coins/images/5135/small/IRIS.png" alt="Iris" width="15"/> IRISnet
- <img src="https://assets.coingecko.com/coins/images/19249/small/2021-10-21_11.23.17.jpg" alt="Juno" width="15"/> Juno
- <img src="https://assets.coingecko.com/coins/images/21540/small/_ooQky6B_400x400.jpg?1639447618" alt="Comdex" width="15"/> Comdex
- <img src="https://assets.coingecko.com/coins/images/22485/small/logo_transparent_notext.png?1641901839" alt="Chihuahua" width="15"/> Chihuahua
- <img src="https://assets.coingecko.com/coins/images/22363/small/stargaze.png?1641571154" alt="Stargaze" width="15"/> Stargaze
- <img src="https://assets.coingecko.com/coins/images/16733/small/REGEN.png?1624861317" alt="Regen" width="15"/> Regen
- <img src="https://assets.coingecko.com/coins/images/13722/small/logo-200x200.jpg?1626095888" alt="E-Money" width="15"/> E-Money
- <img src="https://assets.coingecko.com/coins/images/22009/small/lum.png?1640590072" alt="Lum" width="15"/> Lum
- <img src="https://assets.coingecko.com/coins/images/22610/small/dsm.png?1643192656" alt="Desmos" width="15"/> Desmos

##### MultiversX ecosystem
* <img src="https://assets.coingecko.com/coins/images/12335/thumb_2x/Elrond.png" alt="Elrond" width="15"/> MultiversX
From the public address, retrieves:
* EGLD: wallet balance, staking delegation, WEGLD, SEGLD, HSEGLD (not deposited in collateral)
* EDSTs:
    - WBTC
    - WETH
    - USDC
    - BUSD
    - USDT
    - MEX, XMEX
    - UTK (+ staked on XExchange)
    - HTM (+ staked on XExchange)
    - ASH
    - RIDE (+ staked on XExchange)
    - ITHEUM (+ staked on XExchange)
    - CRT (+ staked on XExchange)
    - BHAT (+ staked on XExchange)
    - ZPAY (+ staked on XExchange)

## Display

<img src="doc/img/allMyCoinsWindow.png" alt="AllMyCoins Window" width="300"/>

## Use it

Download the latest [Release](https://github.com/thomasWos/AllMyCoins/releases).

## Prerequisites

- Java 11 or higher


