package xyz.gozdzik.cryptolist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.gozdzik.cryptolist.data.local.database.AppDatabase
import xyz.gozdzik.cryptolist.data.local.repository.CurrencyInfoLocalRepository
import xyz.gozdzik.cryptolist.domain.repository.CurrencyInfoRepository
import xyz.gozdzik.cryptolist.data.local.model.mappers.CurrencyInfoDataDomainMapper
import xyz.gozdzik.cryptolist.data.remote.repository.CurrencyInfoRemoteRepository
import xyz.gozdzik.cryptolist.domain.usecase.GetCurrenciesFromDatabaseUseCase
import xyz.gozdzik.cryptolist.domain.usecase.GetCurrenciesFromRemoteUseCase
import xyz.gozdzik.cryptolist.presentation.currencylist.CurrencyInfoItemFilterer
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItemMapper

//TODO: Split this to database module
@Module
@InstallIn(SingletonComponent::class)
class CurrencyInfoModule {

    @Provides
    fun provideCurrencyInfoLocalRepository(
        appDatabase: AppDatabase,
        mapper: CurrencyInfoDataDomainMapper
    ): CurrencyInfoLocalRepository =
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

    @Provides
    fun provideGetCurrenciesFromDatabaseUseCase(currencyInfoRepository: CurrencyInfoLocalRepository)
            : GetCurrenciesFromDatabaseUseCase =
        GetCurrenciesFromDatabaseUseCase(currencyInfoRepository)

    @Provides
    fun provideGetCurrenciesFromRemoteUseCase(currencyInfoRepository: CurrencyInfoRemoteRepository)
            : GetCurrenciesFromRemoteUseCase =
        GetCurrenciesFromRemoteUseCase(currencyInfoRepository)
}