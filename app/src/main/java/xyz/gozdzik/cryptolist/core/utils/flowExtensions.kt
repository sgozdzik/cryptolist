package xyz.gozdzik.cryptolist.core.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.drop

public fun <T> Flow<T>.ignoreInitialValue(): Flow<T> = this.drop(1)
