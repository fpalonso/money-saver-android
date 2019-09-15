package es.fpalonso.moneysaver.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import es.fpalonso.moneysaver.MoneySaverApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class
    ]
)
interface AppComponent : AndroidInjector<MoneySaverApp> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<MoneySaverApp>
}
