package xyz.gozdzik.cryptolist.core

import kotlinx.coroutines.*

abstract class UseCase<out TYPE, in PARAMETERS>(
    private val taskScheduler: CoroutineDispatcher = Dispatchers.IO,
    private val resultScheduler: CoroutineDispatcher = Dispatchers.Main
) {

    abstract suspend fun getData(parameters: PARAMETERS? = null): Result<TYPE>

    fun launch(parameters: PARAMETERS? = null, onFinish: (Result<TYPE>) -> Unit) {
        CoroutineScope(taskScheduler).launch {
            val result = getData(parameters)
            withContext(resultScheduler) {
                onFinish(result)
            }
        }
    }

}