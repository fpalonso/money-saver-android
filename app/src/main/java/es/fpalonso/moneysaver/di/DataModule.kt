package es.fpalonso.moneysaver.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import es.fpalonso.moneysaver.data.source.AccountRepository
import es.fpalonso.moneysaver.data.source.local.AccountDao
import es.fpalonso.moneysaver.data.source.local.AccountLocalDataSource
import es.fpalonso.moneysaver.data.source.local.AppDatabase
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Suppress("unused")
@Module
@Singleton
abstract class DataModule(private val application: Application) {
    @Provides
    fun database(): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "MoneySaver.db").build()
    }

    @Provides
    fun accountDao(db: AppDatabase): AccountDao {
        return db.accountDao()
    }

    @Provides
    fun accountLocalDataSource(dao: AccountDao): AccountLocalDataSource {
        return AccountLocalDataSource(dao)
    }

    @Provides
    fun accountRepositoryTaskExecutor(): Executor = Executors.newSingleThreadExecutor()

    @Provides
    fun accountRepository(localDataSource: AccountLocalDataSource, taskExecutor: Executor): AccountRepository {
        return AccountRepository(localDataSource, taskExecutor)
    }
}
