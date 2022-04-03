package xyz.gozdzik.cryptolist.data.local.database

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is workaround for launching database after building it in Hilt
 * Without this database won't prepopulate before launching any function on it
 */
fun AppDatabase.initializeDatabaseAfterBuild() = apply {
    CoroutineScope(Dispatchers.Default).launch {
        this@apply.runInTransaction { }
    }
}