package xyz.gozdzik.cryptolist.core

/**
 * Used for handling initial state in StateFlow, Flow should emit Initial class when
 * we dont want to handle first event
 */
sealed class StateEvent<T> {

    class Initial<T> : StateEvent<T>()
    class Event<T>(val data: T) : StateEvent<T>()

}