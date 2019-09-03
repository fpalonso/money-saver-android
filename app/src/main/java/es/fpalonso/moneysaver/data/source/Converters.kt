package es.fpalonso.moneysaver.data.source

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.util.*

class Converters {
    @TypeConverter
    fun stringToBigDecimal(number: String): BigDecimal = BigDecimal(number)

    @TypeConverter
    fun bigDecimalToString(bigDecimal: BigDecimal): String = bigDecimal.toString()

    @TypeConverter
    fun timestampToDate(timestamp: Long): Date = Date(timestamp)

    @TypeConverter
    fun dateToTimestamp(date: Date): Long = date.time
}
