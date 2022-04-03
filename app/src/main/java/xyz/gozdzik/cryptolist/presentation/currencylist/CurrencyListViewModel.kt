package xyz.gozdzik.cryptolist.presentation.currencylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItem
import xyz.gozdzik.cryptolist.presentation.model.SortParameter
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor() : ViewModel() {

    private val currenciesInfoItems = MutableStateFlow<List<CurrencyInfoItem>>(emptyList())
    private val sortCurrenciesBy = MutableStateFlow(SortParameter.DEFAULT)
    val currenciesInfoItemsObservable: StateFlow<List<CurrencyInfoItem>>
        get() = currenciesInfoItems.combine(
            sortCurrenciesBy
        ) { currenciesInfoItems, sortParameter ->
            when (sortParameter) {
                SortParameter.DEFAULT -> currenciesInfoItems
                SortParameter.BY_NAME_ASC -> currenciesInfoItems
                    .sortedBy { currencyInfoItem ->
                        currencyInfoItem.name
                    }
                SortParameter.BY_NAME_DESC -> currenciesInfoItems
                    .sortedByDescending { currencyInfoItem ->
                        currencyInfoItem.id
                    }
            }
        }.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun initViewModel(currencyInfoItems: List<CurrencyInfoItem>) {
        this.currenciesInfoItems.update {
            currencyInfoItems
        }
    }


}