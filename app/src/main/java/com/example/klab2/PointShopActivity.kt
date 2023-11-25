package com.example.klab2

import android.R
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
//        init()
        imageCheck()
    }

    fun init() {
    }

    fun imageCheck() {

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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.seaBgmImg.setOnClickListener {
                    if (binding.seaBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("sea_bgm")
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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.softBgmImg.setOnClickListener {
                    if (binding.softBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("soft_bgm")
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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.blueShirtImg.setOnClickListener {
                    if (binding.blueShirtImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("blue_shirt")
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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.fluffHatImg.setOnClickListener {
                    if (binding.fluffHatImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("fluff_hat")
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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.greenPantsImg.setOnClickListener {
                    if (binding.greenPantsImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("green_pants")
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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.discoThemeImg.setOnClickListener {
                    if (binding.discoThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("disco_theme")
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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.seaThemeImg.setOnClickListener {
                    if (binding.seaThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("sea_theme")
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
                            Toast.makeText(this@PointShopActivity, "구매 완료", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this@PointShopActivity, "구매할 수 없음", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.forestThemeImg.setOnClickListener {
                    if (binding.forestThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items").child("forest_theme")
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