package xyz.gozdzik.cryptolist.core

import android.content.res.AssetManager

class JsonAssetReader(private val assetManager: AssetManager) {

    fun getJsonStringFromAsset(fileName: String): String? {
        return runCatching {
            assetManager.open(fileName).bufferedReader().use {
                it.readText()
            }
        }.getOrNull()
    }

}