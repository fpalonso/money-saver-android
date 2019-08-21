package es.fpalonso.moneysaver.di

import dagger.Component
import es.fpalonso.moneysaver.ui.AccountDetailsFragment

@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(accountDetailsFragment: AccountDetailsFragment)
}
