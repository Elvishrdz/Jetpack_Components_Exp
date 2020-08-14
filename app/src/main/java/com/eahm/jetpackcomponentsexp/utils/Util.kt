@file:JvmName("Utils")

package com.eahm.jetpackcomponentsexp.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.eahm.jetpackcomponentsexp.R

/**
 * Create a Notification that is shown as a heads-up notification if possible.
 *
 * @param message Message shown on the notification as content
 * @param title Message shown on the notification as title
 * @param context Context needed to create Toast
 */
fun makeStatusNotification(message: String, title : String, context: Context) {

    // Make a channel if necessary
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        val name =
            VERBOSE_NOTIFICATION_CHANNEL_NAME
        val description =
            VERBOSE_NOTIFICATION_CHANNEL_DESCRIPTION
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(CHANNEL_ID, name, importance)
        channel.description = description

        // Add the channel
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        notificationManager?.createNotificationChannel(channel)
    }

    // Create the notification
    val builder = NotificationCompat.Builder(context,
        CHANNEL_ID
    )
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle(title)
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVibrate(LongArray(0))

    // Show the notification
    NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
}

/**
 * Method for sleeping for a fixed about of time
 *
 * @param duration time in milliseconds
 */
fun sleep(duration : Long = 3000) {
    try {
        Thread.sleep(duration, 0)
    }
    catch (e: InterruptedException) {
        Log.e(TAG, e.message ?: "unexpected error")
        throw e
    }
}