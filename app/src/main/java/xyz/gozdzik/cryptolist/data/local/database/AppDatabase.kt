package xyz.gozdzik.cryptolist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO
import xyz.gozdzik.cryptolist.data.local.repository.CryptoCurrencyInfoDao


const val APP_DATABASE_NAME = "CryptoCurrencyDatabase"
private const val APP_DATABASE_VERSION = 1

@Database(entities = [CryptoCurrencyInfoDTO::class], version = APP_DATABASE_VERSION)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cryptoCurrencyInfoDao(): CryptoCurrencyInfoDao

}