package xyz.gozdzik.cryptolist.presentation.currencylist

import org.junit.Test
import xyz.gozdzik.cryptolist.presentation.model.CurrencyDetailedInfoItem
import xyz.gozdzik.cryptolist.presentation.model.FilterParameters
import xyz.gozdzik.cryptolist.presentation.model.SortParameter
import java.math.BigDecimal

class CurrencyInfoItemFiltererTest {

    private val filterer = CurrencyInfoItemFilterer()
    private val testItems = listOf(
        CurrencyDetailedInfoItem("CRO", "C", "Crypto Coin", "CRO", marketCap = BigDecimal.ONE),
        CurrencyDetailedInfoItem("XRP", "X", "Xrp", "XRP"),
        CurrencyDetailedInfoItem("ADA", "A", "Ada", "ADA"),
        CurrencyDetailedInfoItem("ETH", "E", "Ethereum", "ETH", marketCap = BigDecimal(2)),
        CurrencyDetailedInfoItem("BTC", "B", "Bitcoin", "BTC", marketCap = BigDecimal.TEN),
    )

    @Test
    fun `return only items containing search query`() {
        val filteredItems = filterer.applyFilterParameters(
            FilterParameters("Bit"),
            testItems
        )
        assert(filteredItems.size == 1)
        assert(filteredItems.first().id == "BTC")
    }

    @Test
    fun `return items sorted by name ascending`() {
        val filteredItems = filterer.applyFilterParameters(
            FilterParameters(sortParameter = SortParameter.BY_NAME_ASC),
            testItems
        )
        assert(filteredItems.first().id == "ADA")
        assert(filteredItems.last().id == "XRP")
    }

    @Test
    fun `return items sorted by name descending`() {
        val filteredItems = filterer.applyFilterParameters(
            FilterParameters(sortParameter = SortParameter.BY_NAME_DESC),
            testItems
        )
        assert(filteredItems.last().id == "ADA")
        assert(filteredItems.first().id == "XRP")
    }

    @Test
    fun `return items sorted by name market value`() {
        val filteredItems = filterer.applyFilterParameters(
            FilterParameters(sortParameter = SortParameter.BY_MARKET_CAP),
            testItems
        )
        assert(filteredItems.first().id == "BTC")
        assert(filteredItems[1].id == "ETH")
        assert(filteredItems[2].id == "CRO")
    }
}