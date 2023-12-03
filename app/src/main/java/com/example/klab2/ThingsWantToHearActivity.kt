package com.example.klab2

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.klab2.databinding.ActivityThingsWantToHearBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ThingsWantToHearActivity : AppCompatActivity() {
    lateinit var binding: ActivityThingsWantToHearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThingsWantToHearBinding.inflate(layoutInflater)

        if(MainActivity.season == "forest") {
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.forest_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.forest_bar     )
            }
            binding.back.setBackgroundResource(R.drawable.bg_forest)
            binding.oriWantHear.setBackgroundResource(R.drawable.title5)
            binding.oriAddButton.setBackgroundResource(R.drawable.leave2)
            binding.oriEditButton.setBackgroundResource(R.drawable.leave2)
            binding.oriTimeButton.setBackgroundResource(R.drawable.leave2)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#04B486")))
        }
        else if(MainActivity.season == "autumn"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.autumn_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.autumn_bar      )
            }
            binding.back.setBackgroundResource(R.drawable.bg_autumn)
            binding.oriWantHear.setBackgroundResource(R.drawable.title_beach2)
            binding.oriAddButton.setBackgroundResource(R.drawable.autumn2)
            binding.oriEditButton.setBackgroundResource(R.drawable.autumn2)
            binding.oriTimeButton.setBackgroundResource(R.drawable.autumn2)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#DF013A")))
        }
        else if(MainActivity.season == "summer"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.summer_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.summer_bar)
            }
            binding.back.setBackgroundResource(R.drawable.bg_beach)
            binding.oriWantHear.setBackgroundResource(R.drawable.title_beach2)
            binding.oriAddButton.setBackgroundResource(R.drawable.shell3)
            binding.oriEditButton.setBackgroundResource(R.drawable.shell3)
            binding.oriTimeButton.setBackgroundResource(R.drawable.shell3)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2E9AFE")))
        }
        else if(MainActivity.season == "spring"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.spring_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.spring_bar     )
            }
            binding.back.setBackgroundResource(R.drawable.bg_spring)
            binding.oriWantHear.setBackgroundResource(R.drawable.title_spring3)
            binding.oriAddButton.setBackgroundResource(R.drawable.flower3)
            binding.oriEditButton.setBackgroundResource(R.drawable.flower3)
            binding.oriTimeButton.setBackgroundResource(R.drawable.flower3)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F781D8")))
        }
        else if(MainActivity.season == "winter"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.winter_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.winter_bar)
            }
            binding.back.setBackgroundResource(R.drawable.bg_winter)
            binding.oriWantHear.setBackgroundResource(R.drawable.title_winter2)
            binding.oriAddButton.setBackgroundResource(R.drawable.snow2)
            binding.oriEditButton.setBackgroundResource(R.drawable.snow2)
            binding.oriTimeButton.setBackgroundResource(R.drawable.snow2)
            binding.addBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F2F2F2")))
        }

        setContentView(binding.root)
        setDataAll()
        init()
    }

    fun init() {
        binding.addBackArrow.setOnClickListener {
            var Intent = Intent(this, MainActivity::class.java)
            MainActivity.select = 0
            startActivity(Intent)
        }
        binding.oriAddButton.setOnClickListener{
            var Intent = Intent(this, AddThingsWantToHearActivity::class.java)
            startActivity(Intent)
        }
        binding.oriEditButton.setOnClickListener{
            var Intent = Intent(this, EditThingsWantToHearActivity::class.java)
            startActivity(Intent)
        }
        binding.oriTimeButton.setOnClickListener{
            var Intent = Intent(this, Time::class.java)
            startActivity(Intent)
        }
    }
    fun setDataAll(){
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        val database = Firebase.database
        val word = database.getReference("users").child(LoginActivity.username).child("word")
        word.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                binding.textView1.text = dataSnapshot.child("word1").getValue(String::class.java).toString()
                binding.textView2.text = dataSnapshot.child("word2").getValue(String::class.java).toString()
                binding.textView3.text = dataSnapshot.child("word3").getValue(String::class.java).toString()
                binding.textView4.text = dataSnapshot.child("word4").getValue(String::class.java).toString()
                binding.textView5.text = dataSnapshot.child("word5").getValue(String::class.java).toString()

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }
}