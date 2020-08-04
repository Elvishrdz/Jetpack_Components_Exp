package com.eahm.jetpackcomponentsexp.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_data_binding.*
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