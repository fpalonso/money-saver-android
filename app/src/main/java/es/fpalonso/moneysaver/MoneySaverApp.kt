package es.fpalonso.moneysaver

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import es.fpalonso.moneysaver.di.DaggerAppComponent
import javax.inject.Inject

class MoneySaverApp : Application(), HasAndroidInjector {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}