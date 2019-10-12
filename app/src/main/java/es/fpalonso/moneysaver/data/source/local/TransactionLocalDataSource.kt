package es.fpalonso.moneysaver.data.source.local

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Transaction
import es.fpalonso.moneysaver.data.source.TransactionDataSource
import javax.inject.Inject

class TransactionLocalDataSource @Inject constructor(
    private val dao: TransactionDao
) : TransactionDataSource {

    override fun getAll(): LiveData<List<Transaction>> {
        return dao.getAll()
    }

    override fun insert(transaction: Transaction) {
        dao.insert(transaction)
    }
}
