package xyz.gozdzik.cryptolist.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO

@Dao
interface CryptoCurrencyInfoDao {

    //TODO: Add here query
    suspend fun getAll(): List<CryptoCurrencyInfoDTO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cryptoCurrencies: List<CryptoCurrencyInfoDTO>)

}