package xyz.gozdzik.cryptolist.core

sealed class StateEvent<T> {

    class Initial<T> : StateEvent<T>()
    class Event<T>(val data: T) : StateEvent<T>()

}