package es.fpalonso.moneysaver.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val amount: BigDecimal,
    val date: Date,
    val description: String?
)
