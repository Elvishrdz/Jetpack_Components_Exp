package com.eahm.jetpackcomponentsexp.ui.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eahm.jetpackcomponentsexp.R

class NavBasics : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_basics)

        /**
         * Getting Started
         * 1. Include the Jetpack Navigation dependencies (See Build.gradle)
         * 2. Create the Navigation Graph in the res/navigation directory (See navigation_graph.xml)
         * 3. Declare the Navigation Host in the container of the navigation (in this case NavBasics activity)
         *    go to the layout (activity_nav_basics.xml) and add the widget "NavHostFragment"
         *  3.1 After that, you will see in the navigation_graph.xml that the default NavHost now is pointing
         *      to the activity_nav_basics.xml
         * 4. Add the navigation Destinations with fragments (See navigation -> destinations package with the testing
         *    destinations)
         *  4.1 In the navigation_graph.xml add the fragment destinations.
         *  4.2 Add the destination 1 and 2 to the navigation graph
         * 5. In the Destination01 on the Next button set the destination to the Destination02 Fragment ( See Destination01.kt)
         * 6. Compile and Test!
         */
    }
}