package xyz.gozdzik.cryptolist.data.local.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import xyz.gozdzik.cryptolist.data.local.database.APP_DATABASE_NAME
import xyz.gozdzik.cryptolist.data.model.CRYPTO_CURRENCY_INFO_TABLE_NAME
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO

@Dao
interface CryptoCurrencyInfoDao {

    @Query("SELECT * FROM $CRYPTO_CURRENCY_INFO_TABLE_NAME")
    suspend fun getAll(): List<CryptoCurrencyInfoDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoCurrencies: List<CryptoCurrencyInfoDTO>)

}