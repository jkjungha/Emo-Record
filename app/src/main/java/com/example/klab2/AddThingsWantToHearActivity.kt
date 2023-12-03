package com.example.klab2

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.databinding.ActivityAddThingsWantToHearBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class AddThingsWantToHearActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddThingsWantToHearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddThingsWantToHearBinding.inflate(layoutInflater)

        if(MainActivity.season == "forest") {
            binding.back.setBackgroundResource(R.drawable.bg_forest)
            binding.addWantHear.setBackgroundResource(R.drawable.title5)
            binding.addTypeText.setBackgroundResource(R.drawable.bg_2)
            binding.addDoneButton.setBackgroundResource(R.drawable.leave2)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#04B486")))
        }
        else if(MainActivity.season == "autumn"){
            binding.back.setBackgroundResource(R.drawable.bg_autumn)
            binding.addWantHear.setBackgroundResource(R.drawable.title_beach2)
            binding.addDoneButton.setBackgroundResource(R.drawable.autumn2)
            binding.addTypeText.setBackgroundResource(R.drawable.bg_2_autumn)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#DF013A")))
        }
        else if(MainActivity.season == "summer"){
            binding.back.setBackgroundResource(R.drawable.bg_beach)
            binding.addWantHear.setBackgroundResource(R.drawable.title_beach2)
            binding.addDoneButton.setBackgroundResource(R.drawable.shell3)
            binding.addTypeText.setBackgroundResource(R.drawable.bg_2_beach)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2E9AFE")))
        }
        else if(MainActivity.season == "spring"){
            binding.back.setBackgroundResource(R.drawable.bg_spring)
            binding.addWantHear.setBackgroundResource(R.drawable.title_spring3)
            binding.addDoneButton.setBackgroundResource(R.drawable.flower3)
            binding.addTypeText.setBackgroundResource(R.drawable.bg_2_spring)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F781D8")))
        }
        else if(MainActivity.season == "winter"){
            binding.back.setBackgroundResource(R.drawable.bg_winter)
            binding.addWantHear.setBackgroundResource(R.drawable.title_winter2)
            binding.addDoneButton.setBackgroundResource(R.drawable.snow2)
            binding.addTypeText.setBackgroundResource(R.drawable.bg_2_winter)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F2F2F2")))
        }

        setContentView(binding.root)
        init()
    }

    fun init() {
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        val database = Firebase.database
        val word = database.getReference("users").child(LoginActivity.username).child("word")
        word.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                binding.addBackArrow.setOnClickListener {
                    var Intent =Intent(this@AddThingsWantToHearActivity, ThingsWantToHearActivity::class.java)
                    binding.addTypeText.text.clear()
                    startActivity(Intent)
                }

                binding.addDoneButton.setOnClickListener {
                    var hearText = binding.addTypeText.text.toString()
                    var count = dataSnapshot.child("full").getValue(Int::class.java)
                    if (hearText != "" && count!! < 5) {
                        if (count != null) {
                            count = count!! + 1
                        }
                        if (count == 1) {
                            word.child("word1").setValue(hearText)
                        } else if (count == 2) {
                            word.child("word2").setValue(hearText)
                        } else if (count == 3) {
                            word.child("word3").setValue(hearText)
                        } else if (count == 4) {
                            word.child("word4").setValue(hearText)
                        } else if (count == 5) {
                            word.child("word5").setValue(hearText)
                        }
                        Log.d("GOT", count.toString())
                        word.child("full").setValue(count)
                    }

                    var Intent =Intent(this@AddThingsWantToHearActivity, ThingsWantToHearActivity::class.java)
                    binding.addTypeText.text.clear()
                    startActivity(Intent)
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })


    }
}