package com.example.klab2

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MediaPlayerService : Service() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val resourceId = intent?.getIntExtra("bgmResource", 0) ?: 0

        if (resourceId != 0) {
            mediaPlayer.release()
            mediaPlayer = MediaPlayer.create(applicationContext, resourceId)
            mediaPlayer.isLooping = true
            mediaPlayer.start()
        }

        return START_STICKY
    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}