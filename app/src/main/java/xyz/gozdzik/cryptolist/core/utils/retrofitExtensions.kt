package xyz.gozdzik.cryptolist.core.utils

import retrofit2.Response

//TODO: Handle better exception
fun <T>Response<T>.getOrThrow() = if(isSuccessful) body() else throw Exception("")