@file:Suppress("unused")

package es.fpalonso.moneysaver.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import es.fpalonso.moneysaver.data.source.AppDatabase
import es.fpalonso.moneysaver.data.source.DefaultTransactionRepository
import es.fpalonso.moneysaver.data.source.TransactionDataSource
import es.fpalonso.moneysaver.data.source.TransactionRepository
import es.fpalonso.moneysaver.data.source.local.TransactionLocalDataSource
import javax.inject.Singleton

@Module(includes = [AppModuleBinds::class])
object AppModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideDb(context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "MoneySaver.db")
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    @LocalDataSource
    fun provideTransactionLocalDataSource(db: AppDatabase): TransactionDataSource {
        return TransactionLocalDataSource(db.transactionDao())
    }
}

@Module
abstract class AppModuleBinds {

    @Binds
    @Singleton
    abstract fun bindTransactionRepository(transactionRepository: DefaultTransactionRepository): TransactionRepository
}
