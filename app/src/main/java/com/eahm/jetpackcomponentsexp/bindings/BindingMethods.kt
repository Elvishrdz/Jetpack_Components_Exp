package com.eahm.jetpackcomponentsexp.bindings

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import com.bumptech.glide.Glide


@BindingMethods(
    BindingMethod(
        type = ImageView::class,
        attribute = "srcCompat",
        method = "setImageResource"
    )
)
class BindingMethods