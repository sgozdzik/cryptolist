package xyz.gozdzik.cryptolist.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENCY_INFO_TABLE_NAME = "CurrencyInfoDatabaseDto"
private const val CURRENCY_INFO_COLUMN_ID = "id"
private const val CURRENCY_INFO_COLUMN_NAME = "name"
private const val CURRENCY_INFO_COLUMN_SYMBOL = "symbol"

@Entity(tableName = CURRENCY_INFO_TABLE_NAME)
data class CurrencyInfoDatabaseDto(
    @PrimaryKey
    @ColumnInfo(name = CURRENCY_INFO_COLUMN_ID)
    @SerializedName(CURRENCY_INFO_COLUMN_ID)
    val id: String,
    @ColumnInfo(name = CURRENCY_INFO_COLUMN_NAME)
    @SerializedName(CURRENCY_INFO_COLUMN_NAME)
    val name: String,
    @ColumnInfo(name = CURRENCY_INFO_COLUMN_SYMBOL)
    @SerializedName(CURRENCY_INFO_COLUMN_SYMBOL)
    val symbol: String
)
