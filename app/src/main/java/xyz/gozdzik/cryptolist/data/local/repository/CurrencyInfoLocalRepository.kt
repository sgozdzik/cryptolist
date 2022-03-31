package xyz.gozdzik.cryptolist.data.local.repository

import xyz.gozdzik.cryptolist.core.DataMapper
import xyz.gozdzik.cryptolist.data.model.CurrencyInfoDto
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo
import javax.inject.Inject

class CurrencyInfoLocalRepository @Inject constructor(
    private val currencyInfoDao: CurrencyInfoDao,
    private val mapper: DataMapper<CurrencyInfo, CurrencyInfoDto>
) : CurrencyInfoRepository {

    override suspend fun insertAll(currencies: List<CurrencyInfo>) =
        currencyInfoDao.insertAll(currencies.map {
            mapper.mapToData(it)
        })

    override suspend fun getAll(): List<CurrencyInfo> =
        currencyInfoDao.getAll()
            .map {
                mapper.mapToDomain(it)
            }

}