package es.fpalonso.moneysaver.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import es.fpalonso.moneysaver.MoneySaverApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class,
        TransactionDetailsModule::class
    ]
)
interface AppComponent : AndroidInjector<MoneySaverApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }
}
