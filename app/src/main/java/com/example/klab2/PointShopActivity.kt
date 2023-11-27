package com.example.klab2

import android.R
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.databinding.ActivityPointShopBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class PointShopActivity : AppCompatActivity() {
    lateinit var binding: ActivityPointShopBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPointShopBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        imageCheck()
    }

    fun init() {
        var user = "userid1"
//        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
//        val user = sharedPreferences.getString("user", "")
        Log.d("POINT SHOP USER", user!!)
        if (user.isNullOrEmpty()) {
            Toast.makeText(this@PointShopActivity, "유저를 찾을 수 없음", Toast.LENGTH_SHORT).show()
        }
        val database = Firebase.database
        var db = database.reference
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var get_items = dataSnapshot.child("users").child(user).child("get_items")
                for(child in get_items.children){
                    var key = child.key
                    var value = child.child("bought").getValue(Int::class.java)
                    if(key == "exciting_bgm"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.excitingBgmImg.setColorFilter(filter)
                            binding.excitingBgmImg.isEnabled = false
                        }
                    }else if(key == "sea_bgm"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.seaBgmImg.setColorFilter(filter)
                            binding.seaBgmImg.isEnabled = false
                        }
                    }else if(key == "soft_bgm"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.softBgmImg.setColorFilter(filter)
                            binding.softBgmImg.isEnabled = false
                        }
                    }else if(key == "blue_shirt"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.blueShirtImg.setColorFilter(filter)
                            binding.blueShirtImg.isEnabled = false
                        }
                    }else if(key == "fluff_hat"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.fluffHatImg.setColorFilter(filter)
                            binding.fluffHatImg.isEnabled = false
                        }
                    }else if(key == "green_pants"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.greenPantsImg.setColorFilter(filter)
                            binding.greenPantsImg.isEnabled = false
                        }
                    }else if(key == "disco_theme"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.discoThemeImg.setColorFilter(filter)
                            binding.discoThemeImg.isEnabled = false
                        }
                    }else if(key == "sea_theme"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.seaThemeImg.setColorFilter(filter)
                            binding.seaThemeImg.isEnabled = false
                        }
                    }else if(key == "forest_theme"){
                        if(value == 1){
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.forestThemeImg.setColorFilter(filter)
                            binding.forestThemeImg.isEnabled = false
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun imageCheck() {

        binding.backButton.setOnClickListener {
            TODO("뒤로 가기 버튼")
//            val intent = Intent(this@PointShopActivity, );
//            startActivity(intent)
        }

        var user = "userid1"
//        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
//        val user = sharedPreferences.getString("user", "")
        Log.d("POINT SHOP USER", user!!)
        if (user.isNullOrEmpty()) {
            Toast.makeText(this@PointShopActivity, "유저를 찾을 수 없음", Toast.LENGTH_SHORT).show()
        }

        val database = Firebase.database
        var db = database.reference
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                binding.totalPoint.text = "Total Point : "+dataSnapshot.child("users").child(user).child("total_point").getValue(Int::class.java).toString() + " points"
                binding.excitingBgmImg.setOnClickListener {
                    if (binding.excitingBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items/exciting_bgm")
                            .getValue(Int::class.java)
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.excitingBgmImg.setColorFilter(filter)
                            binding.excitingBgmImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/exciting_bgm/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.seaBgmImg.setOnClickListener {
                    if (binding.seaBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items/sea_bgm")
                            .getValue(Int::class.java)
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.seaBgmImg.setColorFilter(filter)
                            binding.seaBgmImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/sea_bgm/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.softBgmImg.setOnClickListener {
                    if (binding.softBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items/soft_bgm")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            Log.d("POINT SHOP ADD", total_point.toString())
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.softBgmImg.setColorFilter(filter)
                            binding.softBgmImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/soft_bgm/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.blueShirtImg.setOnClickListener {
                    if (binding.blueShirtImg.isEnabled) {
                        var point = dataSnapshot.child("items/blue_shirt")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            Log.d("POINT SHOP ADD", total_point.toString())
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.blueShirtImg.setColorFilter(filter)
                            binding.blueShirtImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/blue_shirt/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.fluffHatImg.setOnClickListener {
                    if (binding.fluffHatImg.isEnabled) {
                        var point = dataSnapshot.child("items/fluff_hat")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            Log.d("POINT SHOP ADD", total_point.toString())
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.fluffHatImg.setColorFilter(filter)
                            binding.fluffHatImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/fluff_hat/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.greenPantsImg.setOnClickListener {
                    if (binding.greenPantsImg.isEnabled) {
                        var point = dataSnapshot.child("items/green_pants")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            Log.d("POINT SHOP ADD", total_point.toString())
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.greenPantsImg.setColorFilter(filter)
                            binding.greenPantsImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/green_pants/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.discoThemeImg.setOnClickListener {
                    if (binding.discoThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items/disco_theme")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            Log.d("POINT SHOP ADD", total_point.toString())
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.discoThemeImg.setColorFilter(filter)
                            binding.discoThemeImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/disco_theme/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.seaThemeImg.setOnClickListener {
                    if (binding.seaThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items/sea_theme")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            Log.d("POINT SHOP ADD", total_point.toString())
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.seaThemeImg.setColorFilter(filter)
                            binding.seaThemeImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/sea_theme/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }

                binding.forestThemeImg.setOnClickListener {
                    if (binding.forestThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items/forest_theme")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point = dataSnapshot.child("users").child(user).child("total_point")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())
                        if (total_point!! >= point!!) {
                            total_point -= point
                            db.child("users").child(user!!).child("total_point").setValue(total_point)
                            Log.d("POINT SHOP ADD", total_point.toString())
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.forestThemeImg.setColorFilter(filter)
                            binding.forestThemeImg.isEnabled = false
                            db.child("users").child(user!!).child("get_items/forest_theme/bought").setValue(1)
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }
}