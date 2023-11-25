package com.example.klab2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        setContentView(binding.root)
        setDataAll()
        init()
    }

    fun init() {
        binding.addBackArrow.setOnClickListener {
            var Intent = Intent(this, MainActivity::class.java)
            MainActivity.select = 1
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
        binding.oriSettingsButton.setOnClickListener{
            var Intent = Intent(this, Time::class.java)
            startActivity(Intent)
        }
    }
    fun setDataAll(){
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        val database = Firebase.database
        val word = database.getReference("users").child(userid!!).child("word")
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