package com.eahm.jetpackcomponentsexp.ui.navigation.destinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.eahm.jetpackcomponentsexp.R
import kotlinx.android.synthetic.main.fragment_destination02.*

class Destination02 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_destination02, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvD02Welcome.text = resources.getString(R.string.welcome_to, "Destination 02")

        btnD02Next.setOnClickListener{
            // Check the IDs defined in the navigation_graph.xml for each destination.
            Navigation.findNavController(it)
                .navigate(R.id.destination03)
        }
    }

}