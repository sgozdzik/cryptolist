package xyz.gozdzik.cryptolist.data.local.repository

import xyz.gozdzik.cryptolist.core.DataDomainMapper
import xyz.gozdzik.cryptolist.data.local.database.CurrencyInfoDao
import xyz.gozdzik.cryptolist.data.local.model.CurrencyInfoDatabaseDto
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo
import xyz.gozdzik.cryptolist.domain.repository.CurrencyInfoRepository
import javax.inject.Inject

class CurrencyInfoLocalRepository @Inject constructor(
    private val currencyInfoDao: CurrencyInfoDao,
    private val mapper: DataDomainMapper<CurrencyInfo, CurrencyInfoDatabaseDto>
) : CurrencyInfoRepository {

    override suspend fun insertAll(currencies: List<CurrencyInfo>) =
        currencyInfoDao.insertAll(
            currencies.map {
                mapper.mapToData(it)
            }
        )

    override suspend fun getAll(): List<CurrencyInfo> =
        currencyInfoDao.getAll()
            .map {
                mapper.mapToDomain(it)
            }
}
