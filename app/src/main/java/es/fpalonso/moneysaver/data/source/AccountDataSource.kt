package es.fpalonso.moneysaver.data.source

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Account

interface AccountDataSource {
    fun getAll(): LiveData<List<Account>>

    fun insert(account: Account)
}
