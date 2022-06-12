package xyz.gozdzik.cryptolist.data.local.model.mappers

import xyz.gozdzik.cryptolist.core.DataDomainMapper
import xyz.gozdzik.cryptolist.data.local.model.CurrencyInfoDatabaseDto
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo
import javax.inject.Inject

class CurrencyInfoDataDomainMapper @Inject constructor() :
    DataDomainMapper<CurrencyInfo, CurrencyInfoDatabaseDto> {

    override fun mapToDomain(data: CurrencyInfoDatabaseDto): CurrencyInfo =
        CurrencyInfo(
            data.id,
            data.name,
            data.symbol
        )

    override fun mapToData(domain: CurrencyInfo): CurrencyInfoDatabaseDto =
        CurrencyInfoDatabaseDto(
            domain.id,
            domain.name,
            domain.symbol
        )
}
