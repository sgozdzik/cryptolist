package xyz.gozdzik.cryptolist.data.model.parsers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import xyz.gozdzik.cryptolist.data.model.CurrencyInfoDto

class CurrencyInfoJsonParser(private val gson: Gson) {

    fun parseJson(json: String): List<CurrencyInfoDto> {
        val listType = object : TypeToken<ArrayList<CurrencyInfoDto>>() {}.type
        return gson.fromJson(json, listType)
    }

}