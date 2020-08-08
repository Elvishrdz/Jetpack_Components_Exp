package com.eahm.jetpackcomponentsexp.ui.navigation.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.eahm.jetpackcomponentsexp.R
import kotlinx.android.synthetic.main.fragment_destination05.*

class Destination05 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination05, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvD05Welcome.text = resources.getString(R.string.welcome_to, "Destination 05")

        btnD05Next.setOnClickListener{
            // Check the IDs defined in the navigation_graph.xml for each destination.
            Navigation.findNavController(it)
                .navigate(R.id.destination06)
        }
    }

}