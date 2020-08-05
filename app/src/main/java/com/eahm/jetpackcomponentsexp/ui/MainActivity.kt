package com.eahm.jetpackcomponentsexp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.adapters.MainAdapter
import com.eahm.jetpackcomponentsexp.models.Example
import com.eahm.jetpackcomponentsexp.ui.databinding.DBProductDetail
import com.eahm.jetpackcomponentsexp.ui.databinding.DBRegister
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val appSections = listOf(
        Example(
            "The app menu is ready!",
            "Goes to MainActivity",
            "This is a basic example of the app menu for each new activity where a new functionality will be tested.",
            MainActivity::class.java
        ),
        Example(
            "DataBinding",
            "Connecting the view directly to the data source",
            "This example is implemented with an Activity",
            DBProductDetail::class.java
        ),
        Example(
            "Binding Adapter, Methods and Converters",
            "@BindingAdapter @BindingConversion @BindingMethods",
            "Providing custom values to the attributes in the xml layout in this simple example of a register form. In this example we implement the data binding annotations.",
            DBRegister::class.java
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setBackgroundDrawableResource(R.color.white)
        setContentView(R.layout.activity_main)

        rvMainSections.apply {
            adapter = MainAdapter(appSections.asReversed())
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)
        }
    }
}