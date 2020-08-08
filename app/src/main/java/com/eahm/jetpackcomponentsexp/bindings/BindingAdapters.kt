package com.eahm.jetpackcomponentsexp.bindings

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.eahm.jetpackcomponentsexp.R

/**
 * Here you can find the custom adapters to use in the xml attributes
 *
 * Reminder: Use the @JvmStatic when you declare the BindingAdapters (in Kotlin)
 */
object BindingAdapters {

    @BindingAdapter("drawable")
    @JvmStatic
    fun loadLogo(imageView: ImageView, drawable : Drawable){
        // Implementation: app:drawable="@{@drawable/drawable_name_here}"
        Glide.with(imageView)
            .load(drawable)
            .into(imageView)
    }

    @BindingAdapter("drawable")
    @JvmStatic
    fun loadLogo(imageView: ImageView, isRemote : Boolean){
        // Implementation: app:drawable="@{boolean_here}" (See activity_register.xml -> id: ivRegisterImage)
        if(isRemote) {
            Glide.with(imageView)
                .load("https://cdn.dribbble.com/users/1568450/screenshots/5709863/teamwork_white_1_dribbble-01-01_2x.png")
                .into(imageView)
        }
    }

    @BindingAdapter("srcCompat")
    @JvmStatic
    fun setDayOrNight(imageView: ImageView, isDay : Boolean){
        // Implementation: app:srcCompat="@{boolean_here}" (See activity_register.xml -> id: ivRegisterIcon)
        // TODO return a different drawable for each resolution
        if (isDay){
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, android.R.drawable.ic_menu_edit))
        }
        else{
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, android.R.drawable.ic_dialog_email))
        }

    }

    @BindingAdapter("tint")
    @JvmStatic
    fun setTintColor(imageView: ImageView, isDay: Boolean){
        // Implementation: app:tint="@{boolean_here}" (See activity_register.xml -> id: ivRegisterIcon)
        if(isDay){
            imageView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(imageView.context, R.color.colorAccent))
        }
        else {
            imageView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(imageView.context, R.color.colorPrimary))
        }
    }

    @BindingAdapter("android:entries")
    @JvmStatic
    fun setEntries(spinner : Spinner, entries :List<String>){
        // Implementation: android:entries="@{industryOptions}" (See activity_register.xml -> id: sRegisterIndustryMenu)
        val spinnerAdapter : ArrayAdapter<String> = ArrayAdapter(
            spinner.context,
            android.R.layout.simple_spinner_item,
            entries
        )

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = spinnerAdapter
    }
}