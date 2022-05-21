package xyz.gozdzik.cryptolist.domain.model

import java.math.BigDecimal

class CurrencyDetailedInfo(
    id: String,
    name: String,
    symbol: String,
    val currentPrice: Double,
    val priceChange24: Double,
    val marketCap: BigDecimal
) : CurrencyInfo(
    id, name, symbol
)