package com.example.klab2

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.Intent
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
import com.example.klab2.databinding.ChangeThemeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChangeThemeActivity : AppCompatActivity() {
    //    internal lateinit var player: MediaPlayer
    lateinit var binding: ChangeThemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChangeThemeBinding.inflate(layoutInflater)
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
                        } else if (key == "winter_theme") {
                            binding.winterThemeRadioButton.isGone = true
                        }
                    }
//                    var resourceId:Int = 0
//                    if (chose == 1) {
//                        if (key == "exciting_bgm") {
//                            binding.excitingBgmRadioButton.isChecked = true
//                            resourceId = R.raw.bgm1
//                        } else if (key == "sea_bgm") {
//                            binding.seaBgmRadioButton.isChecked = true
//                            resourceId = R.raw.bgm2
//                        } else if (key == "soft_bgm") {
//                            binding.softBgmRadioButton.isChecked = true
//                            resourceId = R.raw.bgm3
//                        } else if (key == "forest_bgm") {
//                            binding.softBgmRadioButton.isChecked = true
//                            resourceId = R.raw.bgm
//                        } else if (key == "crown_set") {
//                            binding.crownSetRadioButton.isChecked = true
//                        } else if (key == "hanbok_set") {
//                            binding.hanbokSetRadioButton.isChecked = true
//                        } else if (key == "swim_set") {
//                            binding.swimSetRadioButton.isChecked = true
//                        } else if (key == "spring_theme") {
//                            binding.springThemeRadioButton.isChecked = true
//                        } else if (key == "summer_theme") {
//                            binding.summerThemeRadioButton.isChecked = true
//                        } else if (key == "autumn_theme") {
//                            binding.autumnThemeRadioButton.isChecked = true
//                        } else if (key == "winter_theme") {
//                            binding.winterThemeRadioButton.isChecked = true
//                        }
//                    }
//                    if (resourceId != 0) {
//                        val bgmIntent =
//                            Intent(this@ChangeThemeActivity, MediaPlayerService::class.java)
//                        bgmIntent.putExtra("bgmResource", resourceId)
//                        startService(bgmIntent)
//                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

        binding.bgmRadioGroup.setOnCheckedChangeListener { buttonView, checkedId ->
            items.child("exciting_bgm/chose").setValue(0)
            items.child("sea_bgm/chose").setValue(0)
            items.child("soft_bgm/chose").setValue(0)
            items.child("forest_bgm/chose").setValue(0)

            when (checkedId) {
                binding.excitingBgmRadioButton.id -> {
                    items.child("exciting_bgm/chose").setValue(1)
                }

                binding.seaBgmRadioButton.id -> {
                    items.child("sea_bgm/chose").setValue(1)
                }

                binding.softBgmRadioButton.id -> {
                    items.child("soft_bgm/chose").setValue(1)
                }

            }
        }
        binding.clothRadioGroup.setOnCheckedChangeListener { buttonView, checkedId ->
            items.child("crown_set/chose").setValue(0)
            items.child("hanbok_set/chose").setValue(0)
            items.child("swim_set/chose").setValue(0)
            items.child("forest_set/chose").setValue(0)
            when (checkedId) {
                binding.crownSetRadioButton.id -> {
                    items.child("crown_set/chose").setValue(1)
                    HomeFragment.panda = R.drawable.panda2
                }

                binding.hanbokSetRadioButton.id -> {
                    items.child("hanbok_set/chose").setValue(1)
                    HomeFragment.panda = R.drawable.panda4
                }

                binding.swimSetRadioButton.id -> {
                    items.child("swim_set/chose").setValue(1)
                    HomeFragment.panda = R.drawable.panda3
                }
            }
        }
        binding.themeRadioGroup.setOnCheckedChangeListener { buttonView, checkedId ->
            items.child("spring_theme/chose").setValue(0)
            items.child("summer_theme/chose").setValue(0)
            items.child("autumn_theme/chose").setValue(0)
            items.child("winter_theme/chose").setValue(0)
            items.child("forest_theme/chose").setValue(0)
            val statusBarColor: Int = when (checkedId) {
                binding.springThemeRadioButton.id -> {
                    items.child("spring_theme/chose").setValue(1)
                    R.color.spring_bar
                }

                binding.summerThemeRadioButton.id -> {
                    items.child("summer_theme/chose").setValue(1)
                    R.color.summer_bar
                }

                binding.autumnThemeRadioButton.id -> {
                    items.child("autumn_theme/chose").setValue(1)
                    R.color.autumn_bar
                }

                binding.winterThemeRadioButton.id -> {
                    items.child("winter_theme/chose").setValue(1)
                    R.color.winter_bar
                    R.color.forest_bar
                }

                else -> {
                    0
                }

            }
            if (statusBarColor != 0) {
                supportActionBar?.setBackgroundDrawable(
                    ColorDrawable(
                        ContextCompat.getColor(
                            this,
                            statusBarColor
                        )
                    )
                )
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    window.statusBarColor = ContextCompat.getColor(this, statusBarColor)
                }
            }
        }
        binding.doneButton.setOnClickListener {
//            var intent = Intent(this@ChangeThemeActivity, MainActivity::class.java)
//            startActivity(intent)
            finish()
        }

        binding.bgmRadioDefault.setOnClickListener {
            items.child("exciting_bgm/chose").setValue(0)
            items.child("sea_bgm/chose").setValue(0)
            items.child("soft_bgm/chose").setValue(0)
            items.child("forest_bgm/chose").setValue(1)
            binding.excitingBgmRadioButton.isChecked = false
            binding.seaBgmRadioButton.isChecked = false
            binding.softBgmRadioButton.isChecked = false
        }
        binding.clothRadioDefault.setOnClickListener {
            items.child("crown_set/chose").setValue(0)
            items.child("hanbok_set/chose").setValue(0)
            items.child("swim_set/chose").setValue(0)
            items.child("forest_set/chose").setValue(1)
            binding.crownSetRadioButton.isChecked = false
            binding.hanbokSetRadioButton.isChecked = false
            binding.swimSetRadioButton.isChecked = false
        }
        binding.themeRadioDefault.setOnClickListener {
            items.child("spring_theme/chose").setValue(0)
            items.child("summer_theme/chose").setValue(0)
            items.child("autumn_theme/chose").setValue(0)
            items.child("winter_theme/chose").setValue(0)
            items.child("forest_theme/chose").setValue(1)
            binding.springThemeRadioButton.isChecked = false
            binding.summerThemeRadioButton.isChecked = false
            binding.autumnThemeRadioButton.isChecked = false
            binding.winterThemeRadioButton.isChecked = false
        }

    }


}