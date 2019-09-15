package es.fpalonso.moneysaver.transaction.details

import androidx.lifecycle.ViewModel
import es.fpalonso.moneysaver.data.source.DefaultTransactionRepository
import es.fpalonso.moneysaver.data.source.TransactionRepository
import javax.inject.Inject

class TransactionDetailsViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel()