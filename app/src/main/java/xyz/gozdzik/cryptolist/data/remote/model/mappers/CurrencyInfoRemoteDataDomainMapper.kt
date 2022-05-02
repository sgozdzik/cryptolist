package xyz.gozdzik.cryptolist.data.remote.model.mappers

import xyz.gozdzik.cryptolist.core.DataDomainMapper
import xyz.gozdzik.cryptolist.data.remote.model.CurrencyInfoRemoteDto
import xyz.gozdzik.cryptolist.domain.model.CurrencyDetailedInfo

class CurrencyInfoRemoteDataDomainMapper : DataDomainMapper<CurrencyDetailedInfo,
        CurrencyInfoRemoteDto> {

    override fun mapToDomain(data: CurrencyInfoRemoteDto): CurrencyDetailedInfo =
        CurrencyDetailedInfo(
            data.id,
            data.name,
            data.symbol,
            data.currentPrice,
            data.priceChange24,
            data.marketCap
        )

    override fun mapToData(domain: CurrencyDetailedInfo): CurrencyInfoRemoteDto =
        CurrencyInfoRemoteDto(
            domain.id,
            domain.name,
            domain.symbol,
            domain.currentPrice,
            domain.priceChange24,
            domain.marketCap
        )

}