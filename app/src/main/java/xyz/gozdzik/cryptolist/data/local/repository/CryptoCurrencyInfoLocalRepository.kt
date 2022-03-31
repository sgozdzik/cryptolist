package xyz.gozdzik.cryptolist.data.local.repository

import xyz.gozdzik.cryptolist.core.DataMapper
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO
import xyz.gozdzik.cryptolist.domain.model.CryptoCurrencyInfo
import javax.inject.Inject

class CryptoCurrencyInfoLocalRepository @Inject constructor(
    private val cryptoCurrencyInfoDao: CryptoCurrencyInfoDao,
    private val mapper: DataMapper<CryptoCurrencyInfo, CryptoCurrencyInfoDTO>
) : CryptoCurrencyInfoRepository {

    override suspend fun insertAll(cryptoCurrencies: List<CryptoCurrencyInfo>) =
        cryptoCurrencyInfoDao.insertAll(cryptoCurrencies.map {
            mapper.mapToData(it)
        })

    override suspend fun getAll(): List<CryptoCurrencyInfo> =
        cryptoCurrencyInfoDao.getAll()
            .map {
                mapper.mapToDomain(it)
            }

}