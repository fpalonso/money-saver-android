package es.fpalonso.moneysaver.data.source

import es.fpalonso.moneysaver.di.LocalDataSource
import javax.inject.Inject

class DefaultTransactionRepository @Inject constructor(
    @LocalDataSource private val localDataSource: TransactionDataSource
) : TransactionRepository