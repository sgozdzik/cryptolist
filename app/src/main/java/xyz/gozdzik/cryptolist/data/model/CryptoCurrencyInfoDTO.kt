package xyz.gozdzik.cryptolist.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val CRYPTO_CURRENCY_INFO_COLUMN_ID = "id"
private const val CRYPTO_CURRENCY_INFO_COLUMN_NAME = "name"
private const val CRYPTO_CURRENCY_INFO_COLUMN_SYMBOL = "symbol"

@Entity
data class CryptoCurrencyInfoDTO(
    @PrimaryKey
    @ColumnInfo(name = CRYPTO_CURRENCY_INFO_COLUMN_ID)
    val id: String,
    @ColumnInfo(name = CRYPTO_CURRENCY_INFO_COLUMN_NAME)
    val name: String,
    @ColumnInfo(name = CRYPTO_CURRENCY_INFO_COLUMN_SYMBOL)
    val symbol: String
)