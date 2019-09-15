@file:Suppress("unused")

package es.fpalonso.moneysaver.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import es.fpalonso.moneysaver.data.source.AppDatabase
import es.fpalonso.moneysaver.data.source.TransactionDataSource
import es.fpalonso.moneysaver.data.source.DefaultTransactionRepository
import es.fpalonso.moneysaver.data.source.TransactionRepository
import es.fpalonso.moneysaver.data.source.local.TransactionLocalDataSource
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module(includes = [AppModuleBinds::class])
object AppModule {

    @JvmStatic
    private val TASK_EXECUTOR_THREAD_POOL_SIZE = 4

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
    fun provideDataTaskExecutor(): Executor {
        return Executors.newFixedThreadPool(TASK_EXECUTOR_THREAD_POOL_SIZE)
    }

    @JvmStatic
    @Provides
    @Singleton
    @LocalDataSource
    fun provideTransactionLocalDataSource(db: AppDatabase, taskExecutor: Executor): TransactionDataSource {
        return TransactionLocalDataSource(db.transactionDao(), taskExecutor)
    }
}

@Module
abstract class AppModuleBinds {

    @Binds
    @Singleton
    abstract fun bindTransactionRepository(transactionRepository: DefaultTransactionRepository): TransactionRepository
}
