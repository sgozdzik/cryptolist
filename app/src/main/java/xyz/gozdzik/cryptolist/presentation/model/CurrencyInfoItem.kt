package xyz.gozdzik.cryptolist.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyInfoItem(
    val id: String,
    val initialLetter: String,
    val name: String,
    val symbol: String
) : Parcelable