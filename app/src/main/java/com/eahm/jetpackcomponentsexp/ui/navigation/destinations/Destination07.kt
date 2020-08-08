package com.eahm.jetpackcomponentsexp.ui.navigation.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eahm.jetpackcomponentsexp.R
import kotlinx.android.synthetic.main.fragment_destination07.*

class Destination07 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination07, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvD07Welcome.text = resources.getString(R.string.welcome_to, "Destination 07")

        btnD07Next.visibility = View.INVISIBLE
        btnD07Next.isEnabled = false

        btnD07Next.setOnClickListener{
            // Check the IDs defined in the navigation_graph.xml for each destination.
            /*Navigation.findNavController(it)
                .navigate(R.id.destination...)*/
        }
    }

}