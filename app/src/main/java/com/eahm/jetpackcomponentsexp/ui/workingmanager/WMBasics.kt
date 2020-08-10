package com.eahm.jetpackcomponentsexp.ui.workingmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.eahm.jetpackcomponentsexp.R
import com.eahm.jetpackcomponentsexp.utils.KEY_BASIC_WORKER_DURATION
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_wm_basics.*

class WMBasics : AppCompatActivity() {

    private lateinit var workManager : WorkManager
    private var seconds = 3
    private val maxSeconds = 30000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wm_basics)

        /**
         * Getting Started
         * 1. Add the Jetpack Working Manager dependencies in the build.gradle file
         * 2. Now you can create some workers to execute background tasks
         *  2.1 See BasicWorker.kt
         *      - Here you extend the Worker() class
         *      - You need 2 parameters a Context and a WorkerParameters
         *      - You pass those parameters as parameters of the Worker class
         *
         *  3. To Execute the workers check runWorker(...) method below.
         *   3.1 you need to cal the instance of WorkManager.
         *      - You always need to provide a Context
         *   3.2 Check the runWorker() method below for more information in passing
         *       variables to the workers.
         *  4. That's it!
         *
         *  This is just a basic example, there's still a lot of configurations and
         *  good practices that you can learn for your background tasks.
         */

        workManager = WorkManager.getInstance(application)

        btnWMBlur.setOnClickListener{

            if(seconds > 1){
                runWorker(seconds)
                Snackbar.make(it, "Current duration: $seconds seconds", Snackbar.LENGTH_SHORT).show()
            }
            else {
                Snackbar.make(it, "You need more that 1 seconds!", Snackbar.LENGTH_SHORT).show()
            }
        }

        btnWMAdd.setOnClickListener{
            // In big projects use databinding instead.
            if(seconds<maxSeconds){
                seconds++
                tvWMSeconds.text = seconds.toString()
            }
        }

        btnWMSubstract.setOnClickListener{
            // In big projects use databinding instead.
            if(seconds > 0){
                seconds--
                tvWMSeconds.text = seconds.toString()
            }
        }

    }

    private fun runWorker(seconds: Int){
        /* Make a WorkRequest and tell WorkManager to run it. There are two types of WorkRequests:

        OneTimeWorkRequest: A WorkRequest that will only execute once.
        PeriodicWorkRequest: A WorkRequest that will repeat on a cycle.*/

        // Executing the Worker without extra data
        // workManager.enqueue(OneTimeWorkRequest.from(BasicWorker::class.java))

        // Executing the Worker with extra data : Pass the 'seconds' to the WorkRequest
        val basicDataBuilder =  Data.Builder()
            .putInt(KEY_BASIC_WORKER_DURATION, seconds)
            .build()

        // To use the OneTimeWorkRequestBuilder<> we need to include the JavaVersion 1.8 (See build.gradle kotlinOptions)
        val basicWorkerRequest = OneTimeWorkRequestBuilder<BasicWorker>()
            .setInputData(basicDataBuilder)
            .build()

        // Execute the worker
        workManager.enqueue(basicWorkerRequest)

    }

}