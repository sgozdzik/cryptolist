package xyz.gozdzik.cryptolist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.gozdzik.cryptolist.data.local.database.AppDatabase
import xyz.gozdzik.cryptolist.data.local.repository.CurrencyInfoLocalRepository
import xyz.gozdzik.cryptolist.data.local.repository.CurrencyInfoRepository
import xyz.gozdzik.cryptolist.data.model.mappers.CurrencyInfoMapper

@Module
@InstallIn(SingletonComponent::class)
class CurrencyInfoModule {

    @Provides
    fun provideCurrencyInfoRepository(appDatabase: AppDatabase,
    mapper: CurrencyInfoMapper
    ): CurrencyInfoRepository =
        CurrencyInfoLocalRepository(appDatabase.currencyInfoDao(),
        mapper)

    @Provides
    fun provideCurrencyMapper(): CurrencyInfoMapper =
        CurrencyInfoMapper()
}