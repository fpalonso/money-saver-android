package es.fpalonso.moneysaver.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import es.fpalonso.moneysaver.R
//import es.fpalonso.moneysaver.di.DaggerAppComponent

class AccountDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.account_details_fragment, container, false)
    }
}