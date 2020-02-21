package com.example.notifications_through_notificationchannel_importance

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App : Application() {
    companion object{
        var id1 = "channel1"
        var id2 = "channel2"
    }

    override fun onCreate() {
        super.onCreate()

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            var nch1 = NotificationChannel(id1, "Channel1", NotificationManager.IMPORTANCE_HIGH)
            nch1.description = "this is channel 1"

            var nch2 = NotificationChannel(id2, "Channel2", NotificationManager.IMPORTANCE_LOW)
            nch2.description = "this is channel 2"


            var nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(nch1)
            nm.createNotificationChannel(nch2)

        }


    }

}