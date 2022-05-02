package xyz.gozdzik.cryptolist.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.gozdzik.cryptolist.data.local.model.CurrencyInfoDto


const val APP_DATABASE_NAME = "CurrencyDatabase"
private const val APP_DATABASE_VERSION = 1

@Database(entities = [CurrencyInfoDto::class], version = APP_DATABASE_VERSION)
abstract class AppDatabase: RoomDatabase() {

    abstract fun currencyInfoDao(): CurrencyInfoDao

}