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
            var intent = Intent(this@ChangeThemeActivity, ThingsWantToHearActivity::class.java)
            startActivity(intent)
        }

        var user = "userid1"
//        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
//        val user = sharedPreferences.getString("user", "")
        Log.d("POINT SHOP USER", user!!)
        if (user.isNullOrEmpty()) {
            Toast.makeText(this@ChangeThemeActivity, "유저를 찾을 수 없음", Toast.LENGTH_SHORT).show()
        }
        val database = Firebase.database
        var items = database.getReference("users").child(user).child("get_items")
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
                        } else if (key == "blue_shirt") {
                            binding.blueShirtRadioButton.isGone = true
                        } else if (key == "fluff_hat") {
                            binding.fluffHatRadioButton.isGone = true
                        } else if (key == "green_pants") {
                            binding.greenPantsRadioButton.isGone = true
                        } else if (key == "disco_theme") {
                            binding.discoThemeRadioButton.isGone = true
                        } else if (key == "sea_theme") {
                            binding.seaThemeRadioButton.isGone = true
                        } else if (key == "forest_theme") {
                            binding.forestThemeRadioButton.isGone = true
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
            items.child("blue_shirt/chose").setValue(0)
            items.child("fluff_hat/chose").setValue(0)
            items.child("green_pants/chose").setValue(0)
            if(isChecked == binding.blueShirtRadioButton.id){
                items.child("blue_shirt/chose").setValue(1)
            }else if(isChecked == binding.fluffHatRadioButton.id){
                items.child("fluff_hat/chose").setValue(1)
            }else if(isChecked == binding.greenPantsRadioButton.id){
                items.child("green_pants/chose").setValue(1)
            }
        }

        binding.themeRadioGroup.setOnCheckedChangeListener { buttonView, isChecked ->
            items.child("disco_theme/chose").setValue(0)
            items.child("sea_theme/chose").setValue(0)
            items.child("forest_theme/chose").setValue(0)
            if(isChecked == binding.discoThemeRadioButton.id){
                items.child("disco_theme/chose").setValue(1)
            }else if(isChecked == binding.seaThemeRadioButton.id){
                items.child("sea_theme/chose").setValue(1)
            }else if(isChecked == binding.forestThemeRadioButton.id){
                items.child("forest_theme/chose").setValue(1)
            }
        }

    }





}