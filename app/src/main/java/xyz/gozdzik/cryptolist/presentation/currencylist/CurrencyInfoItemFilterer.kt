package xyz.gozdzik.cryptolist.presentation.currencylist

import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItem
import xyz.gozdzik.cryptolist.presentation.model.FilterParameters
import xyz.gozdzik.cryptolist.presentation.model.SortParameter

class CurrencyInfoItemFilterer {

    fun applyFilterParameters(
        filterParameter: FilterParameters,
        currenciesInfoItems: List<CurrencyInfoItem>
    ): List<CurrencyInfoItem> = when (filterParameter.sortParameter) {
        SortParameter.DEFAULT -> currenciesInfoItems
        SortParameter.BY_NAME_ASC -> currenciesInfoItems
            .sortedBy { currencyInfoItem ->
                currencyInfoItem.name
            }
        SortParameter.BY_NAME_DESC -> currenciesInfoItems
            .sortedByDescending { currencyInfoItem ->
                currencyInfoItem.id
            }
    }.filter { currencyInfoItem ->
        filterParameter.searchQuery?.let { searchQuery ->
            currencyInfoItem.name.lowercase().contains(searchQuery.lowercase())
        } ?: true
    }

}