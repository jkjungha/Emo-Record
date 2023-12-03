package com.example.klab2

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.example.klab2.databinding.ChangeThemeBinding
import com.example.klab2.databinding.FragmentPointShopBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChangeThemeActivity : AppCompatActivity(){
//    internal lateinit var player: MediaPlayer
    lateinit var binding: ChangeThemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChangeThemeBinding.inflate(layoutInflater)

        if(MainActivity.season == "forest"){
            binding.back.setBackgroundResource(R.drawable.bg_forest)
            binding.set.setBackgroundResource(R.drawable.bar_style)

            binding.bor1.setBackgroundResource(R.drawable.black_border)
            binding.bor2.setBackgroundResource(R.drawable.black_border)
            binding.bor3.setBackgroundResource(R.drawable.black_border)

            binding.bgmRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/green")))
            binding.clothRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/green")))
            binding.themeRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/green")))
            binding.doneButton.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/green")))
        }
        else if(MainActivity.season == "autumn"){
            binding.back.setBackgroundResource(R.drawable.bg_autumn)
            binding.set.setBackgroundResource(R.drawable.bar_style_autumn)
            binding.bor1.setBackgroundResource(R.drawable.black_border_autumn)
            binding.bor2.setBackgroundResource(R.drawable.black_border_autumn)
            binding.bor3.setBackgroundResource(R.drawable.black_border_autumn)

            binding.bgmRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/orange")))
            binding.clothRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/orange")))
            binding.themeRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/orange")))
            binding.doneButton.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("@color/orange")))

        }
        else if(MainActivity.season == "summer"){
            binding.back.setBackgroundResource(R.drawable.bg_beach)
            binding.set.setBackgroundResource(R.drawable.bar_style_beach)
            binding.bor1.setBackgroundResource(R.drawable.black_border_beach)
            binding.bor2.setBackgroundResource(R.drawable.black_border_beach)
            binding.bor3.setBackgroundResource(R.drawable.black_border_beach)

            binding.bgmRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#5fa3e1")))
            binding.clothRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#5fa3e1")))
            binding.themeRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#5fa3e1")))
            binding.doneButton.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#5fa3e1")))
        }
        else if(MainActivity.season == "spring"){
            binding.back.setBackgroundResource(R.drawable.bg_spring)
            binding.set.setBackgroundResource(R.drawable.bar_style_spring)
            binding.bor1.setBackgroundResource(R.drawable.black_border_spring)
            binding.bor2.setBackgroundResource(R.drawable.black_border_spring)
            binding.bor3.setBackgroundResource(R.drawable.black_border_spring)

            binding.bgmRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#fff06292")))
            binding.clothRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#fff06292")))
            binding.themeRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#fff06292")))
            binding.doneButton.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#fff06292")))
        }
        else if(MainActivity.season == "winter"){
            binding.back.setBackgroundResource(R.drawable.bg_winter)
            binding.set.setBackgroundResource(R.drawable.bar_style_winter)
            binding.bor1.setBackgroundResource(R.drawable.black_border_winter)
            binding.bor2.setBackgroundResource(R.drawable.black_border_winter)
            binding.bor3.setBackgroundResource(R.drawable.black_border_winter)

            binding.bgmRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2e5984")))
            binding.clothRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2e5984")))
            binding.themeRadioDefault.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2e5984")))
            binding.doneButton.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2e5984")))
        }

        setContentView(binding.root)


        init()
    }

    fun init() {
        binding.backButton.setOnClickListener {
//            var intent = Intent(this@ChangeThemeActivity, MainActivity::class.java)
//            startActivity(intent)
            finish()
        }

        val database = Firebase.database
        var items = database.getReference("users").child(LoginActivity.username).child("get_items")
        items.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (item in dataSnapshot.children) {
                    var key = item.key
                    var bought = item.child("bought").getValue(Int::class.java)
                    var chose = item.child("chose").getValue(Int::class.java)
                    if (bought == 0) {
                        if (key == "exciting_bgm") {
                            binding.excitingBgmRadioButton.isGone = true
                        } else if (key == "sea_bgm") {
                            binding.seaBgmRadioButton.isGone = true
                        } else if (key == "soft_bgm") {
                            binding.softBgmRadioButton.isGone = true
                        } else if (key == "crown_set") {
                            binding.crownSetRadioButton.isGone = true
                        } else if (key == "hanbok_set") {
                            binding.hanbokSetRadioButton.isGone = true
                        } else if (key == "swim_set") {
                            binding.swimSetRadioButton.isGone = true
                        } else if (key == "spring_theme") {
                            binding.springThemeRadioButton.isGone = true
                        } else if (key == "summer_theme") {
                            binding.summerThemeRadioButton.isGone = true
                        } else if (key == "autumn_theme") {
                            binding.autumnThemeRadioButton.isGone = true
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

        binding.bgmRadioGroup.setOnCheckedChangeListener { buttonView, checkedId ->
            items.child("exciting_bgm/chose").setValue(0)
            items.child("sea_bgm/chose").setValue(0)
            items.child("soft_bgm/chose").setValue(0)
            val resourceId = when (checkedId) {
                binding.excitingBgmRadioButton.id -> {
                    items.child("exciting_bgm/chose").setValue(1)
                    R.raw.bgm1
                }
                binding.seaBgmRadioButton.id -> {
                    items.child("sea_bgm/chose").setValue(1)
                    R.raw.bgm2
                }
                binding.softBgmRadioButton.id -> {
                    items.child("soft_bgm/chose").setValue(1)
                    R.raw.bgm3
                }
                else -> 0 // Return 0 or handle the default case accordingly
            }

            if (resourceId != 0) {
                val bgmIntent = Intent(this, MediaPlayerService::class.java)
                bgmIntent.putExtra("bgmResource", resourceId)
                startService(bgmIntent)
            }
        }
        binding.clothRadioGroup.setOnCheckedChangeListener { buttonView, isChecked ->
            items.child("crown_set/chose").setValue(0)
            items.child("hanbok_set/chose").setValue(0)
            items.child("swim_set/chose").setValue(0)
            if(isChecked == binding.crownSetRadioButton.id){
                items.child("crown_set/chose").setValue(1)
                HomeFragment.panda = R.drawable.panda2
            }else if(isChecked == binding.hanbokSetRadioButton.id){
                items.child("hanbok_set/chose").setValue(1)
                HomeFragment.panda = R.drawable.panda4
            }else if(isChecked == binding.swimSetRadioButton.id){
                items.child("swim_set/chose").setValue(1)
                HomeFragment.panda = R.drawable.panda3
            }
        }
        binding.themeRadioGroup.setOnCheckedChangeListener { buttonView, checkedId ->
            //items.child("spring_theme/chose").setValue(0)
            //items.child("summer_theme/chose").setValue(0)
            //items.child("autumn_theme/chose").setValue(0)
//            items.child("winter_theme/chose").setValue(0)
            val statusBarColor: Int = when (checkedId) {
                binding.springThemeRadioButton.id -> {
                    MainActivity.season = "spring"
                    items.child("summer_theme/chose").setValue(0)
                    items.child("autumn_theme/chose").setValue(0)
                    items.child("spring_theme/chose").setValue(1)
                    R.color.spring_bar
                }
                binding.summerThemeRadioButton.id -> {
                    MainActivity.season = "summer"
                    items.child("spring_theme/chose").setValue(0)
                    items.child("autumn_theme/chose").setValue(0)
                    items.child("summer_theme/chose").setValue(1)
                    R.color.summer_bar
                }
                binding.autumnThemeRadioButton.id -> {
                    MainActivity.season = "autumn"
                    items.child("spring_theme/chose").setValue(0)
                    items.child("summer_theme/chose").setValue(0)
                    items.child("autumn_theme/chose").setValue(1)
                    R.color.autumn_bar
                }

                else -> { R.color.forest_bar}
            }
//            }else if(isChecked == binding.winterThemeRadioButton.id){
//                items.child("winter_theme/chose").setValue(1)
//            }
            supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, statusBarColor)))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, statusBarColor)
            }
        }
        binding.doneButton.setOnClickListener {
            var intent = Intent(this@ChangeThemeActivity, MainActivity::class.java)
            startActivity(intent)
            //finish()
        }

        binding.bgmRadioDefault.setOnClickListener {


        }
        binding.clothRadioDefault.setOnClickListener {

        }
        binding.themeRadioDefault.setOnClickListener {

        }

    }





}