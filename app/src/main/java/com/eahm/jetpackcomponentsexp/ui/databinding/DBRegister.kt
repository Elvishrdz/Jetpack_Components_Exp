package com.eahm.jetpackcomponentsexp.ui.databinding

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*

class DBRegister : AppCompatActivity() {

    lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate with DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        /**
         * 2. Create the binding method class (See BindingMethods.kt)
         *  2.1 To use some annotation you need to apply the kotlin-kapt plugin in build.gradle
         * 3. Create the binding adapter (See BindingAdapters.kt)
         */

        // 4. Assign the value of day or night (See BindingAdapters.kt -> setDayOrNight(...) method)
        // 5. Asigning the dayOrNight variable, we also define the tint color (See BindingAdapters.kt -> setTintColor(...) method)
        binding.dayOrNight = isDayOrNight()

        // 6. Dinamically assign the value of the spinner (See BindingAdapters.kt -> setEntries(...) method)
        binding.industryOptions = listOf("IT", "Economy", "Marketing", "Medicine")

        // 7. Providing this class to invoke the signUp() in the register button (See BindingConverter.kt -> booleanToVisibility(...) : Int method)
        binding.handler = this
        // 7.1 Setting the show value. True to see the loading progress.
        binding.show = false
    }

    private fun isDayOrNight(): Boolean {
        val c: Calendar = Calendar.getInstance()
        val hourOfDay: Int = c.get(Calendar.HOUR_OF_DAY)
        return hourOfDay in 1..17 // hourOfDay > 0 && hourOfDay < 18
    }

    fun signUp(button: View) {
        binding.show = true
        Toast.makeText(this,"We'll be back in 3 seconds...", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({
            binding.show = false
            Snackbar.make(button,"Done!", Snackbar.LENGTH_SHORT).show()
        }, 3000)
    }
}