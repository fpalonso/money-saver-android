package es.fpalonso.moneysaver.data.source

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Transaction
import es.fpalonso.moneysaver.di.LocalDataSource
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    @LocalDataSource private val localDataSource: TransactionDataSource
) {
    fun getAll(): LiveData<List<Transaction>> {
        return localDataSource.getAll()
    }

    fun insert(transaction: Transaction) {
        localDataSource.insert(transaction)
    }
}
