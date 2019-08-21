package es.fpalonso.moneysaver.di

import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun accountViewModelFactory(creators: ViewModelFactory): ViewModelFactory
}
