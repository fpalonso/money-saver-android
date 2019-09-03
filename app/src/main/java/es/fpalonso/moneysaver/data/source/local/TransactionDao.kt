package es.fpalonso.moneysaver.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import es.fpalonso.moneysaver.data.Transaction

@Dao
interface TransactionDao {

    @Query("SELECT * FROM `Transaction`")
    fun getAll(): LiveData<List<Transaction>>

    @Insert
    fun insert(transaction: Transaction)
}
