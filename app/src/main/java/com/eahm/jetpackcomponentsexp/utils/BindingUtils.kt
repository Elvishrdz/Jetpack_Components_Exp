package com.eahm.jetpackcomponentsexp.utils

import java.util.*

object BindingUtils {
    fun formatPrice(price: Float): String {
        return if (price % 1 == 0f) {
            java.lang.String.format(Locale.getDefault(), "%d€", price.toInt())
        } else {
            java.lang.String.format(Locale.getDefault(), "%.2f€", price)
        }
    }

}