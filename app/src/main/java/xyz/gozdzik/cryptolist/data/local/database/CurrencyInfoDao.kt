package xyz.gozdzik.cryptolist.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import xyz.gozdzik.cryptolist.data.local.model.CURRENCY_INFO_TABLE_NAME
import xyz.gozdzik.cryptolist.data.local.model.CurrencyInfoDto

@Dao
interface CurrencyInfoDao {

    @Query("SELECT * FROM $CURRENCY_INFO_TABLE_NAME")
    suspend fun getAll(): List<CurrencyInfoDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(currencies: List<CurrencyInfoDto>)

}