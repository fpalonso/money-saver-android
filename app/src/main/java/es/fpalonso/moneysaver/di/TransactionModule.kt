package es.fpalonso.moneysaver.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import es.fpalonso.moneysaver.viewmodel.TransactionViewModel
import javax.inject.Singleton

@Module
interface TransactionModule {

    @Binds
    @IntoMap
    @ViewModelKey(TransactionViewModel::class)
    fun bindTransactionViewModel(transactionViewModel: TransactionViewModel): ViewModel
}