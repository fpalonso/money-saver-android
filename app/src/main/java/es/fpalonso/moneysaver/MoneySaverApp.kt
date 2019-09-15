package es.fpalonso.moneysaver

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import es.fpalonso.moneysaver.di.DaggerAppComponent

class MoneySaverApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}