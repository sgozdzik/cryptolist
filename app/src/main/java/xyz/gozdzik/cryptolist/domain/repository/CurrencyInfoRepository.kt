package xyz.gozdzik.cryptolist.domain.repository

import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo

interface CurrencyInfoRepository {

    suspend fun insertAll(currencies: List<CurrencyInfo>)

    suspend fun getAll(): List<CurrencyInfo>

}