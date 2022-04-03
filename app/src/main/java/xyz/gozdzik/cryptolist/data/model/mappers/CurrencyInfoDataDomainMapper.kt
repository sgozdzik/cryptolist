package xyz.gozdzik.cryptolist.data.model.mappers

import xyz.gozdzik.cryptolist.core.DataDomainMapper
import xyz.gozdzik.cryptolist.data.model.CurrencyInfoDto
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo

class CurrencyInfoDataDomainMapper : DataDomainMapper<CurrencyInfo, CurrencyInfoDto> {

    override fun mapToDomain(data: CurrencyInfoDto): CurrencyInfo =
        CurrencyInfo(
            data.id,
            data.name,
            data.symbol
        )

    override fun mapToData(domain: CurrencyInfo): CurrencyInfoDto =
        CurrencyInfoDto(
            domain.id,
            domain.name,
            domain.symbol
        )

}