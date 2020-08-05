package com.eahm.jetpackcomponentsexp.ui.databinding

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.databinding.ActivityProductDetailBinding
import com.eahm.jetpackcomponentsexp.interfaces.OnSelectProductListener
import com.eahm.jetpackcomponentsexp.models.Product
import kotlinx.android.synthetic.main.activity_product_detail.*


class DBProductDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Getting Started
         * 1. Add the configuration to use dataBinding in build.gradle.
         *      Remember that dataBinding{} is obsolete with gradle 4.0.0
         * 2. Prepare the layout. Add the layout as the root tag
         *  2.1 Add the data tag and add inside a variable tag
         *
         * 3. Compile project
         */

        //setContentView(R.layout.activity_product_detail)
        val binding : ActivityProductDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_product_detail)

        val product = Product()

        binding.product = product
        binding.listener = object : OnSelectProductListener{
            override fun onColorSelected(colors: RadioGroup, product: Product) {
                 /*for (i in 0 until colors.childCount) {
                    val rb = colors.getChildAt(i) as RadioButton
                    if (rb.isChecked) {
                        product.selectedColor.set((rb.tag as Int))
                        break
                    }
                }*/
            }

            override fun onIncrement() {
                product.unitsToBuy?.increment()
            }

            override fun onDecrement() {
                product.unitsToBuy?.decrement()
            }

            override fun onAddToCart(product : Product) {
                Toast.makeText(this@DBProductDetail, "${product.name} : ${product.selectedSize.get().toString()} - ${product.selectedColor.get().toString()} -> ${product.unitsToBuy?.get()}", Toast.LENGTH_SHORT).show()
            }

        }

        if(product.imageUrl.isNotEmpty()){
            ivDetailImage.visibility = View.VISIBLE
            Glide.with(this)
                .load(product.imageUrl)
                .into(ivDetailImage)
        }
        else {
            ivDetailImage.visibility = View.GONE
        }

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Real_Madrid_CF.svg/112px-Real_Madrid_CF.svg.png")
            .into(ivDetailToolbarLogo)

    }
}