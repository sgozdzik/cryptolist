package xyz.gozdzik.cryptolist.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigDecimal

@Parcelize
data class CurrencyDetailedInfoItem(
    val id: String,
    val initialLetter: String,
    val name: String,
    val symbol: String,
    val currentPrice: String = "0.00",
    val priceChange24: String = "0.00%",
    val marketCap: BigDecimal = BigDecimal.ZERO
) : Parcelable