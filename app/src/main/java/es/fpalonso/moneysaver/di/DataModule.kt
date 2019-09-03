package es.fpalonso.moneysaver.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import es.fpalonso.moneysaver.data.source.AppDatabase
import es.fpalonso.moneysaver.data.source.TransactionRepository
import es.fpalonso.moneysaver.data.source.local.TransactionDao
import es.fpalonso.moneysaver.data.source.local.TransactionLocalDataSource
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Provides
    @Singleton
    fun provideDb(appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "MoneySaver.db").build()
    }

    @Provides
    @Singleton
    fun provideTransactionDao(db: AppDatabase): TransactionDao {
        return db.transactionDao()
    }

    @Provides
    @Singleton
    fun provideDataTaskExecutor(): Executor {
        return Executors.newFixedThreadPool(TASK_EXECUTOR_THREAD_POOL_SIZE)
    }

    @Provides
    @Singleton
    fun provideTransactionLocalDataSource(
        transactionDao: TransactionDao,
        taskExecutor: Executor
    ): TransactionLocalDataSource {
        return TransactionLocalDataSource(transactionDao, taskExecutor)
    }

    @Provides
    @Singleton
    fun transactionRepository(
        localDataSource: TransactionLocalDataSource
    ): TransactionRepository {
        return TransactionRepository(localDataSource)
    }

    companion object {

        @JvmStatic
        val TASK_EXECUTOR_THREAD_POOL_SIZE = 4
    }
}
