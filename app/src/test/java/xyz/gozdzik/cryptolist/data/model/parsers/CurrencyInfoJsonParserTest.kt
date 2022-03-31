package xyz.gozdzik.cryptolist.data.model.parsers

import com.google.gson.Gson
import org.junit.Test
import xyz.gozdzik.cryptolist.data.model.CurrencyInfoDto
import xyz.gozdzik.cryptolist.mockeddata.cryptoCurrencyInfoJson

class CurrencyInfoJsonParserTest {

    private val currencyInfoJsonParser = CurrencyInfoJsonParser(Gson())

    @Test
    fun `test parsing crypto currency from json`() {
        val parsedList = currencyInfoJsonParser.parseJson(cryptoCurrencyInfoJson)
        assert(parsedList.size == 2)
        assert(parsedList.first() == CurrencyInfoDto(
            "BTC",
            "Bitcoin",
            "BTC"
        ))
        assert(parsedList[1] == CurrencyInfoDto(
            "ETH",
            "Ethereum",
            "ETH"
        ))
    }

}