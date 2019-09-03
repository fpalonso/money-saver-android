package es.fpalonso.moneysaver.viewmodel

import androidx.lifecycle.ViewModel
import es.fpalonso.moneysaver.data.Transaction
import es.fpalonso.moneysaver.data.source.TransactionRepository
import javax.inject.Inject

class TransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    fun insertTransaction(transaction: Transaction) {
        repository.insert(transaction)
    }
}
