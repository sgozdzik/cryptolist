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
    val currentPrice: Double,
    val priceChange24: Double,
    val marketCap: BigDecimal
) : Parcelable