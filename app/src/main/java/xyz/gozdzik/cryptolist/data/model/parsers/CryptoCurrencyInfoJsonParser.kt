package xyz.gozdzik.cryptolist.data.model.parsers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO

class CryptoCurrencyInfoJsonParser(private val gson: Gson) {

    fun parseJson(json: String): List<CryptoCurrencyInfoDTO> {
        val listType = object : TypeToken<ArrayList<CryptoCurrencyInfoDTO>>() {}.type
        return gson.fromJson(json, listType)
    }

}