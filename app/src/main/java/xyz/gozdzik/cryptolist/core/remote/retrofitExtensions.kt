package xyz.gozdzik.cryptolist.core.remote

import retrofit2.Response

fun <T>Response<T>.getOrThrow() = if(isSuccessful) body() else throw ApiException()