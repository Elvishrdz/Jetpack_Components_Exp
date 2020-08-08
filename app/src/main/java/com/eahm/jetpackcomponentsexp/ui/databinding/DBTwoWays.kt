package com.eahm.jetpackcomponentsexp.ui.databinding

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.databinding.ActivityTwoWayBinding
import com.eahm.jetpackcomponentsexp.enums.Gender
import com.eahm.jetpackcomponentsexp.viewmodels.CustomerViewModel


class DBTwoWays : AppCompatActivity() {

    private lateinit var viewModel : CustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflating the layout with DataBinding
        val binding : ActivityTwoWayBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way)

        /**
         * Getting Started
         *
         * 1. Create the layout desing (See activity_two_way.xml)
         * 2. To implement two-way data binding is necessary to use the = in the expression e.g. @={ expression_here }
         *  2.1 Declare a variable for the viewModel in the layout
         *   2.1.1 Extend the class with "BaseObservable()" (See CustomerViewModel.kt)
         *   2.1.2 We will use the @Bindable for the get methods of the properties that are going to use two-day data binding
         *         e.g. the editText use the attribute text, we will create a method that handle de assignation of the values
         *         in both direction: Getting and Setting (See CustomerViewModel.kt -> @Bindable methods get and set)
         *   2.1.3 Assign the value for the editTexts to the corresponding variable in the viewModel e.g. Name -> @={viewModel.name}
         *   2.1.4 In the editText the value is always a String that's why we implement @bindable
         *
         * 3. To assign a value to a widget that receive a different value type, we need to create a custom method and
         *    "parse" the data to the corresponding widget value type (See BindingConverter.kt)
         *    3.1 To provide a way to the widget to send us a correct type value we need to use the @InverseMethod (See BindingConverter.kt)
         *        Custom binding methods are implemented in activity_two_way.xml:
         *               sTwGender (Spinner)
         *               rgTwEdition (RadioButton)
         *               cbTwSubscribePodcast (Checkbox)
         *
         * 4. Assign the corresponding variables to the layout (viewModel and handler)
         * 5. Test the app
         */

        viewModel = CustomerViewModel(
            "",
            "",
            "",
            Gender.MALE,
            false,
            false
        )

        binding.viewModel = viewModel
        binding.handler = this
    }

    fun saveCustomer(v: View) {
        val currentData = """
            ${resources.getString(R.string.current_customer)}
            ${resources.getString(R.string.name)}: ${viewModel.getName()}
            ${resources.getString(R.string.phone)}: ${viewModel.getPhone()}
            ${resources.getString(R.string.address)}: ${viewModel.getAddress()}
            ${resources.getString(R.string.gender)}: ${viewModel.getGender()}
            ${resources.getString(R.string.edition)}: ${if (viewModel.isEnterpriseEdition()) resources.getString(R.string.edition_enterprise) else resources.getString(R.string.edition_free)}
            ${resources.getString(R.string.subscribe_to_our_podcast)}: ${if (viewModel.isSubscriber()) resources.getString(R.string.yes) else resources.getString(R.string.no)}
            """.trimIndent()
        Toast.makeText(this, currentData, Toast.LENGTH_LONG).show()
    }
}