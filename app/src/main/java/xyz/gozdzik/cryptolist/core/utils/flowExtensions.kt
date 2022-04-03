package xyz.gozdzik.cryptolist.core.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import xyz.gozdzik.cryptolist.core.StateEvent

suspend inline fun <T> Flow<StateEvent<T>>.collectEvent(crossinline action: suspend (value: T) -> Unit) =
    this.collectLatest { stateEvent ->
        when (stateEvent) {
            is StateEvent.Initial -> {
                return@collectLatest
            }
            is StateEvent.Event -> {
                action(stateEvent.data)
            }
        }
    }
