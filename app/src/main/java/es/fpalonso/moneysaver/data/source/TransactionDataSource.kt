package es.fpalonso.moneysaver.data.source

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Transaction

interface TransactionDataSource {

    fun getAll(): LiveData<List<Transaction>>

    fun insert(transaction: Transaction)
}