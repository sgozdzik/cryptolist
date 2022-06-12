package xyz.gozdzik.cryptolist.data.remote.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.gozdzik.cryptolist.data.remote.model.CurrencyInfoRemoteDto

interface CoinGeckoService {

    @GET("coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&sparkline=false")
    suspend fun getAllCoins(
        @Query("page") page: Int
    ): Response<List<CurrencyInfoRemoteDto>>
}
