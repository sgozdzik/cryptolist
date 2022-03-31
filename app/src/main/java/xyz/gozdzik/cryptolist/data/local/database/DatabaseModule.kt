package xyz.gozdzik.cryptolist.data.local.database

import android.content.Context
import android.content.res.AssetManager
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import xyz.gozdzik.cryptolist.core.JsonAssetReader
import xyz.gozdzik.cryptolist.data.local.repository.CryptoCurrencyInfoDao
import xyz.gozdzik.cryptolist.data.local.repository.CryptoCurrencyInfoPrepopulateRepository
import xyz.gozdzik.cryptolist.data.model.parsers.CryptoCurrencyInfoJsonParser
import java.util.concurrent.Executors
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context,
        cryptoCurrencyInfoDaoProvider: Provider<CryptoCurrencyInfoDao>,
        cryptoCurrencyInfoPrepopulateRepository: CryptoCurrencyInfoPrepopulateRepository
    ) =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            APP_DATABASE_NAME
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.IO).launch {
                        cryptoCurrencyInfoDaoProvider.get().insertAll(
                            cryptoCurrencyInfoPrepopulateRepository.getAll()
                        )
                    }
                }
            })
            .build()

    @Provides
    fun provideCryptoCurrencyInfoDao(appDatabase: AppDatabase) =
        appDatabase.cryptoCurrencyInfoDao()

    @Provides
    fun provideCryptoCurrencyInfoPrepopulateRepository(
        jsonAssetReader: JsonAssetReader,
        parser: CryptoCurrencyInfoJsonParser
    ) = CryptoCurrencyInfoPrepopulateRepository(
        jsonAssetReader, parser
    )

    @Provides
    fun provideJsonAssetReader(assetManager: AssetManager) = JsonAssetReader(assetManager)

    @Provides
    fun provideAssetManager(@ApplicationContext appContext: Context): AssetManager =
        appContext.assets

    @Provides
    fun provideCryptoCurrencyInfoJsonParser() = CryptoCurrencyInfoJsonParser(Gson())

}