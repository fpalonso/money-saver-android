package es.fpalonso.moneysaver.transaction.details

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.fpalonso.moneysaver.data.source.TransactionRepository
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class TransactionDetailsViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    companion object {
        val TAG = TransactionDetailsViewModel::class.java.name
    }

    val amount = MutableLiveData<BigDecimal>()
    val date = MutableLiveData<Date>()
    val description = MutableLiveData<String>()

    fun onSave() {
        Log.d(TAG, "Saving ${amount.value} on ${date.value}: ${description.value}")
    }
}
