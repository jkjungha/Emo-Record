package com.example.klab2

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
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

class ChangeThemeActivity : AppCompatActivity() {
    lateinit var binding: ChangeThemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChangeThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init(){
        var user = "userid1"
//        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
//        val user = sharedPreferences.getString("user", "")
        Log.d("POINT SHOP USER", user!!)
        if (user.isNullOrEmpty()) {
            Toast.makeText(this@ChangeThemeActivity, "유저를 찾을 수 없음", Toast.LENGTH_SHORT).show()
        }
        val database = Firebase.database
        var db = database.reference
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var get_items = dataSnapshot.child("users").child(user).child("get_items")
                for(child in get_items.children){
                    var key = child.key
                    var value = child.child("chose").getValue(Int::class.java)
                    if(key == "exciting_bgm" && value == 0){
                        binding.excitingBgmRadioButton.isGone = true
                    }else if(key == "sea_bgm"){
                        binding.seaBgmRadioButton.isGone = true
                    }else if(key == "soft_bgm"){
                        binding.softBgmRadioButton.isGone = true
                    }else if(key == "blue_shirt"){
                        binding.blueShirtRadioButton.isGone = true
                    }else if(key == "fluff_hat"){
                        binding.fluffHatRadioButton.isGone = true
                    }else if(key == "green_pants"){
                        binding.greenPantsRadioButton.isGone = true
                    }else if(key == "disco_theme"){
                        binding.discoThemeRadioButton.isGone = true
                    }else if(key == "sea_theme"){
                        binding.seaThemeRadioButton.isGone = true
                    }else if(key == "forest_theme"){
                        binding.forestThemeRadioButton.isGone = true
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }

}