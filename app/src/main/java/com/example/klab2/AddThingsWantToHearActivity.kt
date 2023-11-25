package com.example.klab2

import android.content.Intent
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
        setContentView(binding.root)
        init()
    }

    fun init() {
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        val database = Firebase.database
        val word = database.getReference("users").child(userid!!).child("word")
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
                    if (hearText != "" && count != 5) {
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
                TODO("Not yet implemented")
            }
        })


    }
}