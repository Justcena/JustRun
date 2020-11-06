package ir.cena.justrun.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import ir.cena.justrun.MainActivity
import ir.cena.justrun.R
import ir.cena.justrun.other.Constants.ACTION_PAUSE_SERVICE
import ir.cena.justrun.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import ir.cena.justrun.other.Constants.ACTION_START_OR_RESUME_SERVICE
import ir.cena.justrun.other.Constants.ACTION_STOP_SERVICE
import ir.cena.justrun.other.Constants.NOTIFICATION_CHANNEL_ID
import ir.cena.justrun.other.Constants.NOTIFICATION_CHANNEL_NAME
import ir.cena.justrun.other.Constants.NOTIFICATION_ID
import timber.log.Timber

class TrackingService : LifecycleService() {

    var isFirstRun = true

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    Timber.d("STARTING_SERVICE")
                    if (isFirstRun) {
                        startForegroundService()
                        isFirstRun = false
                    } else {
                        Timber.d("RESUMING_SERVICE")
                    }

                }
                ACTION_PAUSE_SERVICE -> Timber.d("ACTION_PAUSE_SERVICE")
                ACTION_STOP_SERVICE -> Timber.d("ACTION_STOP_SERVICE")
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }

    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this, MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    private fun startForegroundService() {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            .setContentText("00:00:00")
            .setContentTitle("Run")
            .setSmallIcon(R.drawable.ic_directions_run_black)
            .setOngoing(true)
            .setAutoCancel(false)
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(NOTIFICATION_ID, notificationBuilder.build())

    }


}