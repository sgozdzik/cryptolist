package xyz.gozdzik.cryptolist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.gozdzik.cryptolist.data.local.database.AppDatabase
import xyz.gozdzik.cryptolist.data.local.repository.CryptoCurrencyInfoLocalRepository
import xyz.gozdzik.cryptolist.data.local.repository.CryptoCurrencyInfoRepository
import xyz.gozdzik.cryptolist.data.model.mappers.CryptoCurrencyMapper

@Module
@InstallIn(SingletonComponent::class)
class CryptoCurrencyInfoModule {

    @Provides
    fun provideCryptoCurrencyInfoRepository(appDatabase: AppDatabase,
    mapper: CryptoCurrencyMapper
    ): CryptoCurrencyInfoRepository =
        CryptoCurrencyInfoLocalRepository(appDatabase.cryptoCurrencyInfoDao(),
        mapper)

    @Provides
    fun provideCryptoCurrencyMapper(): CryptoCurrencyMapper =
        CryptoCurrencyMapper()
}