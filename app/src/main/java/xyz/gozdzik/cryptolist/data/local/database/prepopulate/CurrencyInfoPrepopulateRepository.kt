package xyz.gozdzik.cryptolist.data.local.database.prepopulate

import xyz.gozdzik.cryptolist.core.utils.JsonAssetReader
import xyz.gozdzik.cryptolist.data.model.CurrencyInfoDto
import xyz.gozdzik.cryptolist.data.model.parsers.CurrencyInfoJsonParser

private const val JSON_PREPOPULATED_DATA_FILE_NAME = "prepopulatedDatabaseData.json"

class CurrencyInfoPrepopulateRepository(
    private val jsonAssetReader: JsonAssetReader,
    private val parser: CurrencyInfoJsonParser
) {

    fun getAll(): List<CurrencyInfoDto> =
        jsonAssetReader.getJsonStringFromAsset(JSON_PREPOPULATED_DATA_FILE_NAME)?.let { json ->
            parser.parseJson(json)
        } ?: emptyList()

}