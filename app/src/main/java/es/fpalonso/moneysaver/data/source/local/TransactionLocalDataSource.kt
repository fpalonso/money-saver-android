package es.fpalonso.moneysaver.data.source.local

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Transaction
import es.fpalonso.moneysaver.data.source.TransactionDataSource
import java.util.concurrent.Executor
import javax.inject.Inject

class TransactionLocalDataSource @Inject constructor(
    private val dao: TransactionDao,
    private val taskExecutor: Executor
) : TransactionDataSource {

    override fun getAll(): LiveData<List<Transaction>> {
        return dao.getAll()
    }

    override fun insert(transaction: Transaction) {
        taskExecutor.execute {
            dao.insert(transaction)
        }
    }
}
