package es.fpalonso.moneysaver.data.source.local

import androidx.lifecycle.LiveData
import es.fpalonso.moneysaver.data.Account
import es.fpalonso.moneysaver.data.source.AccountDataSource

class AccountLocalDataSource(
    val dao: AccountDao
) : AccountDataSource {

    override fun getAll(): LiveData<List<Account>> {
        return dao.getAll()
    }

    override fun insert(account: Account) {
        dao.insert(account)
    }
}
