package es.fpalonso.moneysaver.data.source.local

import androidx.room.TypeConverter
import java.math.BigDecimal

class Converters {
    @TypeConverter
    fun stringToBigDecimal(number: String) = BigDecimal(number)

    @TypeConverter
    fun bigDecimalToString(bigDecimal: BigDecimal) = bigDecimal.toString()
}
