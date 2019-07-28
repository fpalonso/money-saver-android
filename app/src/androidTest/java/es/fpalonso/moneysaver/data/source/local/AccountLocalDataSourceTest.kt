package es.fpalonso.moneysaver.data.source.local

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import es.fpalonso.moneysaver.data.Account
import es.fpalonso.moneysaver.observeOnce
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigDecimal

@RunWith(AndroidJUnit4::class)
class AccountLocalDataSourceTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var dataSource: AccountLocalDataSource
    private lateinit var db: AppDatabase

    @Before
    fun openDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dataSource = AccountLocalDataSource(db.accountDao())
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadAccount() {
        dataSource.insert(Account(name = "My first account", initialAmount = BigDecimal("12.83")))
        dataSource.getAll().observeOnce { accounts ->
            assertEquals(1, accounts.size)
            assertEquals("My first account", accounts[0].name)
            assertEquals(BigDecimal("12.83"), accounts[0].initialAmount)
        }
    }
}
