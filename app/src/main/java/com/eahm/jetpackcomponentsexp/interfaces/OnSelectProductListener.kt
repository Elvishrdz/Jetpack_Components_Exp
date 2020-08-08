package com.eahm.jetpackcomponentsexp.interfaces

import android.widget.RadioGroup
import com.eahm.jetpackcomponentsexp.models.Item

interface OnSelectProductListener {
    fun onColorSelected(colors : RadioGroup, item : Item)
    fun onIncrement()
    fun onDecrement()
    fun onAddToCart(item : Item)
}