package xyz.gozdzik.cryptolist.data.remote.repository

import xyz.gozdzik.cryptolist.core.DataDomainMapper
import xyz.gozdzik.cryptolist.core.remote.getOrThrow
import xyz.gozdzik.cryptolist.data.remote.model.CurrencyInfoRemoteDto
import xyz.gozdzik.cryptolist.data.remote.service.CoinGeckoService
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo
import xyz.gozdzik.cryptolist.domain.repository.CurrencyInfoRepository
import javax.inject.Inject

class CurrencyInfoRemoteRepository @Inject constructor(
    private val service: CoinGeckoService,
    private val mapper: DataDomainMapper<CurrencyInfo, CurrencyInfoRemoteDto>
) : CurrencyInfoRepository {

    override suspend fun insertAll(currencies: List<CurrencyInfo>) {
        throw Exception("Inserting not supported by remote repository")
    }

    override suspend fun getAll(): List<CurrencyInfo> =
        service.getAllCoins(1).getOrThrow()?.map {
            mapper.mapToDomain(it)
        } ?: emptyList()

}