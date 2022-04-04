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
import xyz.gozdzik.cryptolist.core.utils.JsonAssetReader
import xyz.gozdzik.cryptolist.data.local.database.prepopulate.CurrencyInfoPrepopulateRepository
import xyz.gozdzik.cryptolist.data.model.parsers.CurrencyInfoJsonParser
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context,
        currencyInfoDaoProvider: Provider<CurrencyInfoDao>,
        currencyInfoPrepopulateRepository: CurrencyInfoPrepopulateRepository
    ) =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            APP_DATABASE_NAME
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    CoroutineScope(Dispatchers.Default).launch {
                        currencyInfoDaoProvider.get().insertAll(
                            currencyInfoPrepopulateRepository.getAll()
                        )
                    }
                }
            })
            .build().initializeDatabaseAfterBuild()

    @Provides
    fun provideCurrencyInfoDao(appDatabase: AppDatabase) =
        appDatabase.currencyInfoDao()

    @Provides
    fun provideCurrencyInfoPrepopulateRepository(
        jsonAssetReader: JsonAssetReader,
        parser: CurrencyInfoJsonParser
    ) = CurrencyInfoPrepopulateRepository(
        jsonAssetReader, parser
    )

    @Provides
    fun provideJsonAssetReader(assetManager: AssetManager) = JsonAssetReader(assetManager)

    @Provides
    fun provideAssetManager(@ApplicationContext appContext: Context): AssetManager =
        appContext.assets

    @Provides
    fun provideCurrencyInfoJsonParser() = CurrencyInfoJsonParser(Gson())

}