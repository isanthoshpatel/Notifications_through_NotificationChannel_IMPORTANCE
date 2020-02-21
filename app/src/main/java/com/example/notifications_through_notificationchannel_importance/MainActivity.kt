package com.example.notifications_through_notificationchannel_importance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var nm: NotificationManagerCompat
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nm = NotificationManagerCompat.from(this)

        bt1.setOnClickListener {
            var n1 = NotificationCompat.Builder(this, App.id1)
                .setSmallIcon(R.drawable.love)
                .setContentTitle(et1.text.toString())
                .setContentText(et2.text.toString())
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build()
            nm.notify(i++, n1)

        }
        bt2.setOnClickListener {
            var n2 = NotificationCompat.Builder(this, App.id2)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentTitle(et1.text.toString())
                .setContentText(et2.text.toString())
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build()
            nm.notify(i++, n2)

        }


    }


    override fun onPause() {
        super.onPause()
        var n1 = NotificationCompat.Builder(this, App.id1)
            .setSmallIcon(R.drawable.love)
            .setContentTitle("hello")
            .setContentText("when app in background")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)
            .build()
        nm.notify(1, n1)
    }

}
