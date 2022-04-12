package xyz.gozdzik.cryptolist.presentation.model

import xyz.gozdzik.cryptolist.core.PresentationDomainMapper
import xyz.gozdzik.cryptolist.domain.model.CurrencyInfo

class CurrencyInfoItemMapper : PresentationDomainMapper<CurrencyInfo, CurrencyInfoItem> {

    override fun mapToDomain(item: CurrencyInfoItem): CurrencyInfo =
        CurrencyInfo(item.id, item.name, item.symbol)

    override fun mapToPresentationItem(domain: CurrencyInfo): CurrencyInfoItem =
        CurrencyInfoItem(
            domain.id,
            domain.name.first().toString(),
            domain.name,
            domain.symbol.uppercase()
        )
}