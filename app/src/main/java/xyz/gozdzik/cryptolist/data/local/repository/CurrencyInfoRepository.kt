package xyz.gozdzik.cryptolist.data.local.repository

import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo

interface CurrencyInfoRepository {

    suspend fun insertAll(currencies: List<CurrencyInfo>)

    suspend fun getAll(): List<CurrencyInfo>

}