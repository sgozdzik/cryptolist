package xyz.gozdzik.cryptolist.presentation.currencylist

import xyz.gozdzik.cryptolist.presentation.model.CurrencyDetailedInfoItem
import xyz.gozdzik.cryptolist.presentation.model.FilterParameters
import xyz.gozdzik.cryptolist.presentation.model.SortParameter

class CurrencyInfoItemFilterer {

    fun applyFilterParameters(
        filterParameter: FilterParameters,
        currenciesInfoItems: List<CurrencyDetailedInfoItem>
    ): List<CurrencyDetailedInfoItem> = when (filterParameter.sortParameter) {
        SortParameter.BY_NAME_ASC -> currenciesInfoItems
            .sortedBy { currencyInfoItem ->
                currencyInfoItem.name.lowercase()
            }
        SortParameter.BY_NAME_DESC -> currenciesInfoItems
            .sortedByDescending { currencyInfoItem ->
                currencyInfoItem.name.lowercase()
            }
        SortParameter.BY_MARKET_CAP -> currenciesInfoItems
            .sortedByDescending { currencyInfoItem ->
                currencyInfoItem.marketCap
            }
    }.filter { currencyInfoItem ->
        filterParameter.searchQuery?.let { searchQuery ->
            currencyInfoItem.name.lowercase().contains(searchQuery.lowercase())
        } ?: true
    }

}