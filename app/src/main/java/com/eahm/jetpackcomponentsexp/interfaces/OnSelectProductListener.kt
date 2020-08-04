package com.eahm.jetpackcomponentsexp.interfaces

import android.widget.RadioGroup
import com.eahm.jetpackcomponentsexp.models.Product

interface OnSelectProductListener {
    fun onColorSelected(colors : RadioGroup, product : Product)
    fun onIncrement()
    fun onDecrement()
    fun onAddToCart(product : Product)
}