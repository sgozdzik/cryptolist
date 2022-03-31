package xyz.gozdzik.cryptolist.data.local.repository

import xyz.gozdzik.cryptolist.core.JsonAssetReader
import xyz.gozdzik.cryptolist.data.model.CryptoCurrencyInfoDTO
import xyz.gozdzik.cryptolist.data.model.parsers.CryptoCurrencyInfoJsonParser


private const val JSON_PREPOPULATED_DATA_FILE_NAME = "prepopulatedDatabaseData.json"

class CryptoCurrencyInfoPrepopulateRepository(
    private val jsonAssetReader: JsonAssetReader,
    private val parser: CryptoCurrencyInfoJsonParser
) {

    fun getAll(): List<CryptoCurrencyInfoDTO> =
        jsonAssetReader.getJsonStringFromAsset(JSON_PREPOPULATED_DATA_FILE_NAME)?.let { json ->
            parser.parseJson(json)
        } ?: emptyList()

}