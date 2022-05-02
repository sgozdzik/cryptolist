package xyz.gozdzik.cryptolist.presentation.model

import xyz.gozdzik.cryptolist.core.PresentationDomainMapper
import xyz.gozdzik.cryptolist.domain.model.CurrencyDetailedInfo

class CurrencyInfoItemMapper :
    PresentationDomainMapper<CurrencyDetailedInfo, CurrencyDetailedInfoItem> {

    override fun mapToDomain(item: CurrencyDetailedInfoItem): CurrencyDetailedInfo =
        CurrencyDetailedInfo(
            item.id,
            item.name,
            item.symbol,
            item.currentPrice,
            item.priceChange24,
            item.marketCap
        )

    override fun mapToPresentationItem(domain: CurrencyDetailedInfo): CurrencyDetailedInfoItem =
        CurrencyDetailedInfoItem(
            domain.id,
            domain.name.first().toString(),
            domain.name,
            domain.symbol.uppercase(),
            domain.currentPrice,
            domain.priceChange24,
            domain.marketCap
        )
}