package xyz.gozdzik.cryptolist.data.local.repository

import xyz.gozdzik.cryptolist.domain.model.CryptoCurrencyInfo

interface CryptoCurrencyInfoRepository {

    suspend fun insertAll(cryptoCurrencies: List<CryptoCurrencyInfo>)

    suspend fun getAll(): List<CryptoCurrencyInfo>

}