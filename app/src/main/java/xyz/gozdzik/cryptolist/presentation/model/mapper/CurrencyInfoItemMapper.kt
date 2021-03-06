package xyz.gozdzik.cryptolist.presentation.model.mapper

import xyz.gozdzik.cryptolist.core.PresentationDomainMapper
import xyz.gozdzik.cryptolist.core.utils.toPercentageValue
import xyz.gozdzik.cryptolist.core.utils.toUsdCurrency
import xyz.gozdzik.cryptolist.domain.model.CurrencyDetailedInfo
import xyz.gozdzik.cryptolist.presentation.model.CurrencyDetailedInfoItem
import javax.inject.Inject

class CurrencyInfoItemMapper @Inject constructor() :
    PresentationDomainMapper<CurrencyDetailedInfo, CurrencyDetailedInfoItem> {

    override fun mapToDomain(item: CurrencyDetailedInfoItem): CurrencyDetailedInfo =
        throw Exception("Not supported yet")

    override fun mapToPresentationItem(domain: CurrencyDetailedInfo): CurrencyDetailedInfoItem =
        CurrencyDetailedInfoItem(
            domain.id,
            domain.name.first().toString(),
            domain.name,
            domain.symbol.uppercase(),
            domain.currentPrice.toUsdCurrency(),
            domain.priceChange24.toPercentageValue(),
            domain.marketCap
        )
}
