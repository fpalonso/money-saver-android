package es.fpalonso.moneysaver.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import es.fpalonso.moneysaver.di.viewmodel.ViewModelKey
import es.fpalonso.moneysaver.di.viewmodel.ViewModelModule
import es.fpalonso.moneysaver.transaction.details.TransactionDetailsFragment
import es.fpalonso.moneysaver.transaction.details.TransactionDetailsViewModel

@Module
abstract class TransactionDetailsModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun transactionDetailsFragment(): TransactionDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(TransactionDetailsViewModel::class)
    abstract fun bindTransactionDetailsViewModel(transactionDetailsViewModel: TransactionDetailsViewModel): ViewModel
}