package xyz.gozdzik.cryptolist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.gozdzik.cryptolist.data.local.database.AppDatabase
import xyz.gozdzik.cryptolist.data.local.repository.CurrencyInfoLocalRepository
import xyz.gozdzik.cryptolist.data.local.repository.CurrencyInfoRepository
import xyz.gozdzik.cryptolist.data.model.mappers.CurrencyInfoDataDomainMapper
import xyz.gozdzik.cryptolist.presentation.currencylist.CurrencyInfoItemFilterer
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItemMapper

@Module
@InstallIn(SingletonComponent::class)
class CurrencyInfoModule {

    @Provides
    fun provideCurrencyInfoRepository(
        appDatabase: AppDatabase,
        mapper: CurrencyInfoDataDomainMapper
    ): CurrencyInfoRepository =
        CurrencyInfoLocalRepository(
            appDatabase.currencyInfoDao(),
            mapper
        )

    @Provides
    fun provideCurrencyInfoDataDomainMapper(): CurrencyInfoDataDomainMapper =
        CurrencyInfoDataDomainMapper()

    @Provides
    fun provideCurrencyInfoItemMapper(): CurrencyInfoItemMapper =
        CurrencyInfoItemMapper()

    @Provides
    fun provideCurrencyInfoItemFilterer(): CurrencyInfoItemFilterer =
        CurrencyInfoItemFilterer()
}