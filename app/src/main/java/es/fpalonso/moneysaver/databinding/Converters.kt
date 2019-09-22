/*
 * Money Saver for Android - Know where your money is
 * Copyright (C) 2019 Fer P. A.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

@file:JvmName("BindingConverters")
@file:Suppress("unused")

package es.fpalonso.moneysaver.databinding

import androidx.databinding.InverseMethod
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

@InverseMethod("stringToCurrency")
fun currencyToString(bigDecimal: BigDecimal?): String? {
    return NumberFormat.getCurrencyInstance().format(bigDecimal ?: BigDecimal.ZERO)
}

fun stringToCurrency(string: String?): BigDecimal? {
    return if (string?.isNotEmpty() == true) {
        NumberFormat.getCurrencyInstance().parse(string)?.let {
            BigDecimal(it.toString()).apply {
                setScale(2, RoundingMode.HALF_UP)
            }
        }
    } else {
        BigDecimal.ZERO
    }
}

@InverseMethod("stringToDate")
fun dateToString(date: Date?): String? {
    return if (date != null) {
        SimpleDateFormat.getInstance().format(date)
    } else {
        null
    }
}

fun stringToDate(string: String?): Date? {
    return if (string != null) {
        SimpleDateFormat.getInstance().parse(string)
    } else {
        null
    }
}
