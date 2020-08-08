package com.eahm.jetpackcomponentsexp.bindings

import android.view.View
import androidx.databinding.BindingConversion
import androidx.databinding.InverseMethod
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.enums.Gender

object BindingConverter {

    @BindingConversion
    @JvmStatic
    fun booleanToVisibility(show: Boolean) : Int{
        return if (show) View.VISIBLE else View.GONE
    }

    // Implemented in activity_two_way.xml -> sTwGender (Spinner)
    @InverseMethod("intToGender")
    @JvmStatic
    fun genderToInt(gender: Gender): Int {
        return if (gender === Gender.MALE) 0 else 1
    }

    @JvmStatic
    fun intToGender(gender: Int): Gender? {
        return if (gender == 0) Gender.MALE else Gender.FEMALE
    }

    // Implemented in activity_two_way.xml -> rgTwEdition (RadioGroup)
    @InverseMethod("intToBoolean")
    @JvmStatic
    fun booleanToInt(isEnterpriseEdition: Boolean): Int {
        return if (isEnterpriseEdition) R.id.rbTw01 else R.id.rbTw02
    }

    @JvmStatic
    fun intToBoolean(radioId: Int): Boolean {
        return radioId == R.id.rbTw01
    }

}