package xyz.gozdzik.cryptolist.data.remote.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class CurrencyInfoRemoteDto(
    val id: String,
    val symbol: String,
    val name: String,
    @SerializedName("current_price")
    val currentPrice: Double,
    @SerializedName("price_change_percentage_24h")
    val priceChange24: Double,
    @SerializedName("market_cap")
    val marketCap: BigDecimal
)