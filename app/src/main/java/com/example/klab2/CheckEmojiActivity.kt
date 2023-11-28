package com.example.klab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.klab2.databinding.ActivityCheckEmojiBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class CheckEmojiActivity : AppCompatActivity() {
    lateinit var binding: ActivityCheckEmojiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckEmojiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun init(){
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        val database = Firebase.database
        val user = database.getReference("users").child(LoginActivity.username)
        val day = user.child("calender").child(CalendarFragment.year1.toString())
            .child((CalendarFragment.month1+1).toString()).child(CalendarFragment.day1.toString())
        day.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                binding.expression1.setOnClickListener{
                    day.child("dairy_emotion").setValue(1)
                    var Intent = Intent(this@CheckEmojiActivity, WriteDairyActivity::class.java)
                    startActivity(Intent)
                }
                binding.expression2.setOnClickListener{
                    day.child("dairy_emotion").setValue(2)
                    var Intent = Intent(this@CheckEmojiActivity, WriteDairyActivity::class.java)
                    startActivity(Intent)
                }
                binding.expression3.setOnClickListener{
                    day.child("dairy_emotion").setValue(3)
                    var Intent = Intent(this@CheckEmojiActivity, WriteDairyActivity::class.java)
                    startActivity(Intent)
                }
                binding.expression4.setOnClickListener{
                    day.child("dairy_emotion").setValue(4)
                    var Intent = Intent(this@CheckEmojiActivity, WriteDairyActivity::class.java)
                    startActivity(Intent)
                }
                binding.expression5.setOnClickListener{
                    day.child("dairy_emotion").setValue(5)
                    var Intent = Intent(this@CheckEmojiActivity, WriteDairyActivity::class.java)
                    startActivity(Intent)
                }
                binding.chkBackArrow.setOnClickListener {
                    var Intent = Intent(this@CheckEmojiActivity, MainActivity::class.java)
                    MainActivity.select = 2
                    startActivity(Intent)
                }

            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

}