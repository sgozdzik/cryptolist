package xyz.gozdzik.cryptolist.data.model.parsers

import com.google.gson.Gson
import org.junit.Test
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO
import xyz.gozdzik.cryptolist.mockeddata.cryptoCurrencyInfoJson

class CryptoCurrencyInfoJsonParserTest {

    private val cryptoCurrencyInfoJsonParser = CryptoCurrencyInfoJsonParser(Gson())

    @Test
    fun `test parsing crypto currency from json`() {
        val parsedList = cryptoCurrencyInfoJsonParser.parseJson(cryptoCurrencyInfoJson)
        assert(parsedList.size == 2)
        assert(parsedList.first() == CryptoCurrencyInfoDTO(
            "BTC",
            "Bitcoin",
            "BTC"
        ))
        assert(parsedList[1] == CryptoCurrencyInfoDTO(
            "ETH",
            "Ethereum",
            "ETH"
        ))
    }

}