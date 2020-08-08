package com.eahm.jetpackcomponentsexp.models

import android.graphics.Color
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.eahm.jetpackcomponentsexp.observable.CounterObservableInt


class Item {
    val id = "3507"
    val name = "Mens Real Madrid Home Shirt 20/21 White"
    val vendorName = "Tienda La 80"
    val discount = 0.7f
    val price = 104.95f
    val description = "Camiseta blanca con cuello redondo muy confortable. Productos 100% garantizados"
    val rating = 4.7f
    val reviewsNumber = 1283
    val sizes: ArrayList<String> = ArrayList()
    val colors: ArrayList<Int> = ArrayList()
    val imageUrl = "https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/202007/22/00132435214435____1__640x640.jpg"

    // Observable fields:
    val unitsToBuy: CounterObservableInt? = CounterObservableInt()
    val selectedSize = ObservableField<String>()
    val selectedColor = ObservableInt(1)

    init {
        sizes.add("S")
        sizes.add("M")
        sizes.add("L")
        sizes.add("XL")
        colors.add(Color.parseColor("#ffcdd2"))
        colors.add(Color.parseColor("#bbdefb"))
        colors.add(Color.parseColor("#ffe0b2"))
        colors.add(Color.parseColor("#fafafa"))

        selectedSize.set(sizes[0]);
        selectedColor.set(colors[0]);
    }
}