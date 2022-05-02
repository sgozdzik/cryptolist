package xyz.gozdzik.cryptolist.presentation.currencylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import xyz.gozdzik.cryptolist.domain.usecase.GetCurrenciesFromRemoteUseCase
import xyz.gozdzik.cryptolist.presentation.model.CurrencyDetailedInfoItem
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItemMapper
import xyz.gozdzik.cryptolist.presentation.model.FilterParameters
import xyz.gozdzik.cryptolist.presentation.model.SortParameter
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val currencyInfoItemFilterer: CurrencyInfoItemFilterer,
    private val getCurrenciesFromRemoteUseCase: GetCurrenciesFromRemoteUseCase
) : ViewModel() {

    private val currencyInfoItemMapper = CurrencyInfoItemMapper()
    private val currenciesInfoItems = MutableStateFlow<List<CurrencyDetailedInfoItem>>(emptyList())
    private val filterParameters = MutableStateFlow(FilterParameters())
    val currenciesInfoItemsObservable: StateFlow<List<CurrencyDetailedInfoItem>>
        get() = currenciesInfoItems.combine(
            filterParameters
        ) { currenciesInfoItems, filterParameter ->
            currencyInfoItemFilterer.applyFilterParameters(filterParameter, currenciesInfoItems)
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun initViewModel() {
        getCurrenciesFromRemoteUseCase.launch { result ->
            result.onSuccess { list ->
                currenciesInfoItems.update {
                    list.map {
                        currencyInfoItemMapper.mapToPresentationItem(it)
                    }
                }
            }
                .onFailure {
                    //TODO: Handle error
                }
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