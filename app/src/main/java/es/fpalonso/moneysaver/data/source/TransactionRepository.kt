package es.fpalonso.moneysaver.data.source

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Transaction
import es.fpalonso.moneysaver.data.source.local.TransactionLocalDataSource
import es.fpalonso.moneysaver.di.AppModuleBinds
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    @AppModuleBinds.LocalDataSource private val localDataSource: TransactionLocalDataSource
) {
    fun getAll(): LiveData<List<Transaction>> {
        return localDataSource.getAll()
    }

    fun insert(transaction: Transaction) {
        localDataSource.insert(transaction)
    }
}
