package xyz.gozdzik.cryptolist.data.remote.model.mappers

import xyz.gozdzik.cryptolist.core.DataDomainMapper
import xyz.gozdzik.cryptolist.data.remote.model.CurrencyInfoRemoteDto
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo

class CurrencyInfoRemoteDataDomainMapper : DataDomainMapper<CurrencyInfo, CurrencyInfoRemoteDto> {

    override fun mapToDomain(data: CurrencyInfoRemoteDto): CurrencyInfo =
        CurrencyInfo(
            data.id,
            data.name,
            data.symbol
        )

    override fun mapToData(domain: CurrencyInfo): CurrencyInfoRemoteDto =
        CurrencyInfoRemoteDto(
            domain.id,
            domain.name,
            domain.symbol
        )

}