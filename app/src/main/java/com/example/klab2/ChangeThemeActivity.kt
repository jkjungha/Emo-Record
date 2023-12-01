package com.example.klab2

import android.content.ComponentName
import android.content.Intent
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isGone
import com.example.klab2.databinding.ChangeThemeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChangeThemeActivity : AppCompatActivity(){
    internal lateinit var player: MediaPlayer
    lateinit var binding: ChangeThemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChangeThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() {
        binding.backButton.setOnClickListener {
            var intent = Intent(this@ChangeThemeActivity, MainActivity::class.java)
            startActivity(intent)
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

        binding.bgmRadioGroup.setOnCheckedChangeListener { buttonView, isChecked ->
            items.child("exciting_bgm/chose").setValue(0)
            items.child("sea_bgm/chose").setValue(0)
            items.child("soft_bgm/chose").setValue(0)
            if(isChecked == binding.excitingBgmRadioButton.id){
                player = MediaPlayer.create(applicationContext, R.raw.bgm1)
                player.isLooping = true
                player.start()
                items.child("exciting_bgm/chose").setValue(1)
            }else if(isChecked == binding.seaBgmRadioButton.id){
                player = MediaPlayer.create(applicationContext, R.raw.bgm2)
                player.isLooping = true
                player.start()
                items.child("sea_bgm/chose").setValue(1)
            }else if(isChecked == binding.softBgmRadioButton.id){
                player = MediaPlayer.create(applicationContext, R.raw.bgm3)
                player.isLooping = true
                player.start()
                items.child("soft_bgm/chose").setValue(1)
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
        binding.themeRadioGroup.setOnCheckedChangeListener { buttonView, isChecked ->
            items.child("spring_theme/chose").setValue(0)
            items.child("summer_theme/chose").setValue(0)
            items.child("autumn_theme/chose").setValue(0)
//            items.child("winter_theme/chose").setValue(0)
            if(isChecked == binding.springThemeRadioButton.id){
                items.child("spring_theme/chose").setValue(1)
            }else if(isChecked == binding.summerThemeRadioButton.id){
                items.child("summer_theme/chose").setValue(1)
            }else if(isChecked == binding.autumnThemeRadioButton.id){
                items.child("autumn_theme/chose").setValue(1)}
//            }else if(isChecked == binding.winterThemeRadioButton.id){
//                items.child("winter_theme/chose").setValue(1)
//            }
        }
        binding.doneButton.setOnClickListener {
            var intent = Intent(this@ChangeThemeActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }





}