package com.eahm.jetpackcomponentsexp.bindings

import android.view.View
import androidx.databinding.BindingConversion


object BindingConverter {

    @BindingConversion
    @JvmStatic
    fun booleanToVisibility(show: Boolean) : Int{
        return if (show) View.VISIBLE else View.GONE
    }

}