package es.fpalonso.moneysaver.di

import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AppModule {

    @Binds
    @Singleton
    fun bindAppContext(appContext: Context): Context
}