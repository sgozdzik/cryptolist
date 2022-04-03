package xyz.gozdzik.cryptolist.presentation.demo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import xyz.gozdzik.cryptolist.domain.usecase.GetCurrenciesFromDatabaseUseCase
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItem
import xyz.gozdzik.cryptolist.presentation.model.CurrencyInfoItemMapper
import javax.inject.Inject

@HiltViewModel
class DemoViewModel @Inject constructor(
    private val getCurrenciesFromDatabaseUseCase: GetCurrenciesFromDatabaseUseCase,
    private val currenciesItemMapper: CurrencyInfoItemMapper
) : ViewModel() {

    private val currenciesInfoItems = MutableStateFlow<List<CurrencyInfoItem>>(emptyList())
    val currenciesInfoItemsObservable: StateFlow<List<CurrencyInfoItem>>
        get() = currenciesInfoItems

    fun getCurrenciesFromDatabase() {
        getCurrenciesFromDatabaseUseCase.launch { result ->
            result.onSuccess { currenciesInfo ->
                currenciesInfoItems.update {
                    currenciesInfo.map { currencyInfo ->
                        currenciesItemMapper.mapToPresentationItem(currencyInfo)
                    }
                }
            }
                .onFailure {
                    //TODO: Handle errors
                }
        }
    }

}