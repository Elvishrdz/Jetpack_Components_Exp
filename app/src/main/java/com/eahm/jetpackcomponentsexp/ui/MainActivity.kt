package com.eahm.jetpackcomponentsexp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.adapters.MainAdapter
import com.eahm.jetpackcomponentsexp.models.Example
import com.eahm.jetpackcomponentsexp.ui.workingmanager.WMBasics
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
            "Basic Worker",
            "Working Manager",
            "Here we 'mock' a heavy task to showcase the capabilities of the Jetpack Working Manager with a simple example",
            WMBasics::class.java
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