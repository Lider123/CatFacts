package ru.babaets.catfacts.common

import android.content.Context
import android.text.format.DateFormat
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

internal const val API_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

fun String.formatApiDateTime(context: Context): String {
    val apiFormat = SimpleDateFormat(API_DATETIME_FORMAT, Locale.getDefault())
    val date: Date = try {
        apiFormat.parse(this)
    } catch (e: ParseException) {
        return this
    }

    val dateFormat = DateFormat.getDateFormat(context)
    return dateFormat.format(date)
}

fun Fragment.color(@ColorRes colorRes: Int): Int =
    ContextCompat.getColor(requireContext(), colorRes)
