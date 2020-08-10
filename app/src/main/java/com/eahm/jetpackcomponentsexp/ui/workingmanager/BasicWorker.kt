package com.eahm.jetpackcomponentsexp.ui.workingmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.hasKeyWithValueOfType
import com.eahm.jetpackcomponentsexp.utils.*
import java.lang.Exception

class BasicWorker(
    context : Context,
    parameters : WorkerParameters
) : Worker(context, parameters){

    private val TAG = "BlurWorker"

    override fun doWork(): Result {
        val appContext = applicationContext

        var duration = 3 // in seconds

        // Receive data calling the getInputData() method
        if(inputData.hasKeyWithValueOfType<Int>(KEY_BASIC_WORKER_DURATION)){
            duration = inputData.getInt(KEY_BASIC_WORKER_DURATION, 3)
        }

        // Make a Notification displaying the URI by calling the static makeStatusNotification method from WorkerUtils.
        makeStatusNotification(
            "Background task in process. $duration seconds",
            "WorkRequest Starting",
            appContext
        )

        return try {
            sleep(duration.toLong() * 1000)
            makeStatusNotification(
                "duration: $duration seconds!",
                "WorkRequest Completed",
                appContext
            )

            // Notify the worker operation was successful
            Result.success()

        } catch (e : Exception) {
            Log.e(TAG, "Error applying blur ", e)

            makeStatusNotification(
                "$duration seconds: Error encountered",
                "WorkRequest Failed",
                appContext
            )

            // Notify the worker operation failed
            Result.failure()
        }

    }

}