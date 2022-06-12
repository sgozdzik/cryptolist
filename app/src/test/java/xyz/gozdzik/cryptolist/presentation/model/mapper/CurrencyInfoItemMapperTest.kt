package xyz.gozdzik.cryptolist.presentation.model.mapper

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test
import xyz.gozdzik.cryptolist.domain.model.CurrencyDetailedInfo
import xyz.gozdzik.cryptolist.presentation.model.CurrencyDetailedInfoItem
import java.math.BigDecimal

class CurrencyInfoItemMapperTest {

    private val currencyInfoItemMapper = CurrencyInfoItemMapper()

    @Test
    fun `detailed currency info should be properly mapped to presentation item`() {
        val currencyDetailedInfo = CurrencyDetailedInfo(
            "testId",
            "Bitcoin",
            "BTC",
            123.456,
            12.34,
            BigDecimal.TEN
        )
        val expected = CurrencyDetailedInfoItem(
            "testId",
            "B",
            "Bitcoin",
            "BTC",
            "123.456 USD",
            "12.34%",
            BigDecimal.TEN
        )
        val mapped = currencyInfoItemMapper.mapToPresentationItem(currencyDetailedInfo)
        Assert.assertEquals(expected, mapped)
    }
}