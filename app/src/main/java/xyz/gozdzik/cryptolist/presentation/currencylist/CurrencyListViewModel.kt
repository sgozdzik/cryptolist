package xyz.gozdzik.cryptolist.presentation.currencylist

import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItem
import xyz.gozdzik.cryptolist.presentation.model.FilterParameters
import xyz.gozdzik.cryptolist.presentation.model.SortParameter
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val currencyInfoItemFilterer: CurrencyInfoItemFilterer
) : ViewModel() {

    private val currenciesInfoItems = MutableStateFlow<List<CurrencyInfoItem>>(emptyList())
    private val filterParameters = MutableStateFlow(FilterParameters())
    val currenciesInfoItemsObservable: StateFlow<List<CurrencyInfoItem>>
        get() = currenciesInfoItems.combine(
            filterParameters
        ) { currenciesInfoItems, filterParameter ->
            currencyInfoItemFilterer.applyFilterParameters(filterParameter, currenciesInfoItems)
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun initViewModel(currencyInfoItems: List<CurrencyInfoItem>) {
        this.currenciesInfoItems.update {
            currencyInfoItems
        }
    }

    fun sortCurrencies(sortParameter: SortParameter) {
        filterParameters.update {
            filterParameters.value.copy(sortParameter = sortParameter)
        }
    }

    fun search(searchQuery: String) {
        filterParameters.update {
            filterParameters.value.copy(searchQuery = searchQuery)
        }
    }

}