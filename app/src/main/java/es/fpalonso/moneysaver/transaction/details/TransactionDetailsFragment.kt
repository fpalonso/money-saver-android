package es.fpalonso.moneysaver.transaction.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import es.fpalonso.moneysaver.R
import es.fpalonso.moneysaver.databinding.TransactionDetailsFragmentBinding
import javax.inject.Inject

class TransactionDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var viewModel: TransactionDetailsViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.transaction_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(
            activity!!,
            viewModelFactory
        )[TransactionDetailsViewModel::class.java]
        val binding = TransactionDetailsFragmentBinding.bind(view!!).apply {
            this.viewmodel = viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
    }
}
