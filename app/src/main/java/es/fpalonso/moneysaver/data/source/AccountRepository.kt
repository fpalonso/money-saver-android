package es.fpalonso.moneysaver.data.source

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Account
import es.fpalonso.moneysaver.data.source.local.AccountLocalDataSource
import java.util.concurrent.Executor
import javax.inject.Inject

class AccountRepository @Inject constructor(
    val localDataSource: AccountLocalDataSource,
    val taskExecutor: Executor
) {
    fun getAll(): LiveData<List<Account>> {
        return localDataSource.getAll()
    }

    fun insert(account: Account) {
        taskExecutor.execute {
            localDataSource.insert(account)
        }
    }
}
