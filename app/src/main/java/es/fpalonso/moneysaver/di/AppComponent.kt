package es.fpalonso.moneysaver.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import es.fpalonso.moneysaver.MoneySaverApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidInjectionModule::class
    ]
)
interface AppComponent {

    fun inject(app: MoneySaverApp)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance appContext: Context): AppComponent
    }
}
