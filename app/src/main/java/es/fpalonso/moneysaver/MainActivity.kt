package es.fpalonso.moneysaver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import es.fpalonso.moneysaver.di.DaggerAppComponent
import es.fpalonso.moneysaver.viewmodel.AccountViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
