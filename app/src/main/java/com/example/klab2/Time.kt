package com.example.klab2

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.klab2.databinding.ActivityTimeBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Timer
import java.util.TimerTask


@Suppress("UNCHECKED_CAST")
class Time : AppCompatActivity() {
    companion object {
        private const val USE_ALARM_PERMISSION = 100
        private const val SCHEDULE_ALARM_PERMISSION = 101
        private const val POST_NOTIFICATIONS_PERMISSION = 102
    }
    private lateinit var binding : ActivityTimeBinding
    private lateinit var dbRef: DatabaseReference

    lateinit var receiver : AlarmReceiver
    private lateinit var picker : MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    private lateinit var timer: Timer
    var eventListener: ValueEventListener? = null
    lateinit var wordList: ArrayList<String>

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        createNotiChannel()
        receiver = AlarmReceiver()
//        alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        dbRef = FirebaseDatabase.getInstance().getReference("users/$userid/word")
        wordList = mutableListOf<String>() as ArrayList<String>

        checkPermission(android.Manifest.permission.USE_EXACT_ALARM, USE_ALARM_PERMISSION)
        checkPermission(android.Manifest.permission.SCHEDULE_EXACT_ALARM, SCHEDULE_ALARM_PERMISSION)
        checkPermission(android.Manifest.permission.POST_NOTIFICATIONS, POST_NOTIFICATIONS_PERMISSION)

        eventListener = dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                wordList.clear()
                var i = 0
                var j = 0
                if (snapshot.exists()){
                    for (item in snapshot.children){
                        val wordData = item.value
                        if (wordData != null) {
                            println(wordData)
                            println(i)
                            println(j)
                            if (j < 1) {
                                if (wordData is Long)
                                    i = wordData.toInt() + 1
                                j += 1
                            } else if (wordData is String && i > 0)
                                wordList.add(wordData)
                            i -= 1

                        }

                    }
                    print("snapshot exists")
                    print(wordList)

                } else {
                    print("snapshot does not exist")
                    print(wordList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                print("Database Error")
            }
        })

        binding.btnTime.setOnClickListener {
            showTimePicker()
        }
        binding.btnCancel.setOnClickListener {
            cancel()
        }

        binding.btnSave.setOnClickListener {
            save()
        }

    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            println("Permission Already Granted")
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == USE_ALARM_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "USE_ALARM permission granted", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "USE_ALARM permission denied", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode == SCHEDULE_ALARM_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "SCHEDULE_ALARM permission granted", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "SCHEDULE_ALARM permission denied", Toast.LENGTH_SHORT).show()
            }

        } else if (requestCode == POST_NOTIFICATIONS_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "NOTIFICATION permission granted", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "NOTIFICATION permission denied", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun cancel() {
//        val intent = Intent(this, AlarmReceiver::class.java)
//
//        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
//
//        alarmManager.cancel(pendingIntent)
        if (this::timer.isInitialized) {
            timer.cancel()
        }
        Toast.makeText(this, "Message automation cancelled", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12).setMinute(0).setTitleText("Select Message Time").build()

        picker.show(supportFragmentManager, "test")

        picker.addOnPositiveButtonClickListener {
            val minute = String.format("%02d", picker.minute)
            if (picker.hour in 12..23){
                val hour = String.format("%02d",picker.hour - 12)
                binding.timeText.text = "$hour : $minute PM"
            }
            else {
                val hour = String.format("%02d",picker.hour)
                binding.timeText.text = "$hour : $minute AM"
            }
            onTimeSet(picker.hour, picker.minute)
        }

    }
    private fun onTimeSet(hour: Int, minute: Int) {
        calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, picker.hour)
        calendar.set(Calendar.MINUTE, picker.minute)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
    }

    @SuppressLint("SimpleDateFormat")
    private fun save() {
        println(calendar.get(Calendar.HOUR_OF_DAY))
        println(calendar.get(Calendar.MINUTE))

//        val intent2 = Intent(this, MessageActivity::class.java)
//        val intent = Intent(this, AlarmReceiver::class.java)

        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        timer = Timer()

        class MyTimeTask : TimerTask() {
            override fun run() {
                println("Running Task")
                println("Current Time: " + df.format(Date()))
                sendNoti()
                timer.cancel()
            }
        }

        println("Current Time: " + df.format(Date()))

        //Date and time at which you want to execute
        val date: Date = calendar.time
        timer.schedule(MyTimeTask(), date)
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show()
    }

    fun sendNoti() {
        val intent = Intent(this, AlarmReceiver::class.java)
        intent.putStringArrayListExtra("word", wordList)
        this.sendBroadcast(intent)
    }

    private fun createNotiChannel() {

        val name = "testReminderChannel"
        val desc = "Channel For Emotion App Notifications"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel("klab", name, importance)
        channel.description = desc

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)

    }
}

