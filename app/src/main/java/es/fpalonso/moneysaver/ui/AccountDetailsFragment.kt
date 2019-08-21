package es.fpalonso.moneysaver.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import es.fpalonso.moneysaver.di.DaggerAppComponent
import es.fpalonso.moneysaver.di.ViewModelFactory
import es.fpalonso.moneysaver.viewmodel.AccountViewModel
import javax.inject.Inject

class AccountDetailsFragment : Fragment() {
    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private var viewModel: AccountViewModel

    init {
        DaggerAppComponent.create().inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[AccountViewModel::class.java]
    }
}
