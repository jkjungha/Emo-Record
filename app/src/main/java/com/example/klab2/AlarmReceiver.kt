package com.example.klab2

import android.Manifest
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

@Suppress("DEPRECATION")
class AlarmReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent?) {
        lateinit var randomWord: String

        val wordList = intent?.getStringArrayListExtra("word")

        if (wordList is ArrayList<*>) {
            val randomIndex = Random.nextInt(wordList.size)
            if (wordList.size > 0) {
                randomWord = wordList[randomIndex]
                println(randomWord)
                val i = Intent(context, MessageActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                i.putExtra("word", randomWord)

                val pendingIntent = PendingIntent.getActivity(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

                val builder =  NotificationCompat.Builder(context, "klab")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("New Message")
                    .setContentText("Tap to see the message")
                    .setAutoCancel(true)
                    .setDefaults(NotificationCompat.DEFAULT_ALL)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent)

                val notificationManagerCompat = NotificationManagerCompat.from(context)
                if (ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    Toast.makeText(context, "Notification Permission Not Granted", Toast.LENGTH_SHORT).show()
                    return
                }
                notificationManagerCompat.notify(123, builder.build())
            } else {
                Toast.makeText(context, "WordList Empty", Toast.LENGTH_SHORT).show()
            }

        }
    }

}