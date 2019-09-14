package es.fpalonso.moneysaver.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import es.fpalonso.moneysaver.data.Account
import es.fpalonso.moneysaver.data.Transaction
import es.fpalonso.moneysaver.data.source.local.AccountDao
import es.fpalonso.moneysaver.data.source.local.TransactionDao

@Database(
    entities = [
        Account::class,
        Transaction::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    abstract fun transactionDao(): TransactionDao
}
