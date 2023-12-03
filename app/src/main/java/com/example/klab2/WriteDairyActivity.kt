package com.example.klab2

import android.content.DialogInterface
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.klab2.databinding.ActivityWriteDairyBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class WriteDairyActivity : AppCompatActivity() {
    lateinit var binding: ActivityWriteDairyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteDairyBinding.inflate(layoutInflater)

        if(MainActivity.season == "forest") {
            binding.back.setBackgroundResource(R.drawable.bg_forest)
            binding.viewDairyTitle.setBackgroundResource(R.drawable.title5)
            binding.dairyTitle.setBackgroundResource(R.drawable.bg_2)
            binding.dairyContent.setBackgroundResource(R.drawable.bg_2)
            binding.dairySaveButton.setBackgroundResource(R.drawable.leave2)
            binding.wrtBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#04B486")))
        }
        else if(MainActivity.season == "autumn"){
            binding.back.setBackgroundResource(R.drawable.bg_autumn)
            binding.viewDairyTitle.setBackgroundResource(R.drawable.title_beach2)
            binding.dairyTitle.setBackgroundResource(R.drawable.bg_2_autumn)
            binding.dairyContent.setBackgroundResource(R.drawable.bg_2_autumn)
            binding.dairySaveButton.setBackgroundResource(R.drawable.leave2)
            binding.wrtBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#DF013A")))
        }
        else if(MainActivity.season == "summer"){
            binding.back.setBackgroundResource(R.drawable.bg_beach)
            binding.viewDairyTitle.setBackgroundResource(R.drawable.title_beach2)
            binding.dairyTitle.setBackgroundResource(R.drawable.bg_2_beach)
            binding.dairyContent.setBackgroundResource(R.drawable.bg_2_beach)
            binding.dairySaveButton.setBackgroundResource(R.drawable.leave2)
            binding.wrtBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2E9AFE")))
        }
        else if(MainActivity.season == "spring"){
            binding.back.setBackgroundResource(R.drawable.bg_spring)
            binding.viewDairyTitle.setBackgroundResource(R.drawable.title_spring3)
            binding.dairyTitle.setBackgroundResource(R.drawable.bg_2_spring)
            binding.dairyContent.setBackgroundResource(R.drawable.bg_2_spring)
            binding.dairySaveButton.setBackgroundResource(R.drawable.leave2)
            binding.wrtBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F781D8")))
        }
        else if(MainActivity.season == "winter"){
            binding.back.setBackgroundResource(R.drawable.bg_winter)
            binding.viewDairyTitle.setBackgroundResource(R.drawable.title_winter2)
            binding.dairyTitle.setBackgroundResource(R.drawable.bg_2_winter)
            binding.dairyContent.setBackgroundResource(R.drawable.bg_2_winter)
            binding.dairySaveButton.setBackgroundResource(R.drawable.leave2)
            binding.wrtBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F2F2F2")))
        }

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
        var pointResult = 0

        binding.wrtBackArrow.setOnClickListener {
            var Intent = Intent(this@WriteDairyActivity, CheckEmojiActivity::class.java)
            startActivity(Intent)
        }

        val point = database.getReference("users").child(LoginActivity.username).child("total_point")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    pointResult = snapshot.value.toString().toInt()
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })

        day.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                binding.dairySaveButton.setOnClickListener {
                    var title = binding.dairyTitle.text.toString()
                    var content = binding.dairyContent.text.toString()
                    day.child("dairy_title").setValue(title)
                    day.child("dairy_content").setValue(content)

                    database.getReference("Activity").
                    addValueEventListener(object: ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            val count = snapshot.childrenCount.toInt()

                            if (count >= 1) {
                                val activities: MutableList<String> = snapshot.children.map { it.key.orEmpty() }.toMutableList()
                                activities.shuffle()
                                Log.i("ac",activities[0])

                                database.getReference("users").child(LoginActivity.username)
                                    .child("activity").child(activities[0]).setValue(1)

                            } else {

                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                        }

                    })

                    val point2 = pointResult + 5
                    database.getReference("users").child(LoginActivity.username).child("total_point").setValue(point2)

                    val builder = AlertDialog.Builder(this@WriteDairyActivity)
                    builder.setTitle("Complete!")
                        .setMessage("Your wrote dairy is written, your activity is uploaded")
                        .setPositiveButton("Save", DialogInterface.OnClickListener { dialog, id ->
                            var Intent = Intent(this@WriteDairyActivity, MainActivity::class.java)
                            MainActivity.select = 2
                            startActivity(Intent)
                        })
                    builder.show()
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

}