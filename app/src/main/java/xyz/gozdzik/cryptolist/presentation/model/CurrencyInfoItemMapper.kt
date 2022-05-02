package xyz.gozdzik.cryptolist.presentation.model

import xyz.gozdzik.cryptolist.core.PresentationDomainMapper
import xyz.gozdzik.cryptolist.core.utils.toPercentageValue
import xyz.gozdzik.cryptolist.core.utils.toUsdCurrency
import xyz.gozdzik.cryptolist.domain.model.CurrencyDetailedInfo
import java.math.BigDecimal

class CurrencyInfoItemMapper :
    PresentationDomainMapper<CurrencyDetailedInfo, CurrencyDetailedInfoItem> {

    override fun mapToDomain(item: CurrencyDetailedInfoItem): CurrencyDetailedInfo =
        CurrencyDetailedInfo(
            item.id,
            item.name,
            item.symbol,
            //TODO: Think about it
            item.currentPrice.toDouble(),
            item.priceChange24.toDouble(),
            //TODOL Think about this also
            BigDecimal.ONE
        )

    override fun mapToPresentationItem(domain: CurrencyDetailedInfo): CurrencyDetailedInfoItem =
        CurrencyDetailedInfoItem(
            domain.id,
            domain.name.first().toString(),
            domain.name,
            domain.symbol.uppercase(),
            domain.currentPrice.toUsdCurrency(),
            domain.priceChange24.toPercentageValue(),
            domain.marketCap.toUsdCurrency()
        )
}