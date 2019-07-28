package es.fpalonso.moneysaver.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.fpalonso.moneysaver.data.Account

@Dao
interface AccountDao {
    @Query("SELECT * FROM Account")
    fun getAll(): LiveData<List<Account>>

    @Insert
    fun insert(account: Account)
}
