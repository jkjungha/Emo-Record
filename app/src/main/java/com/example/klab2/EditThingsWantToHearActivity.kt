package com.example.klab2

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.klab2.databinding.ActivityEditThingsWantToHearBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class EditThingsWantToHearActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditThingsWantToHearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditThingsWantToHearBinding.inflate(layoutInflater)

        if(MainActivity.season == "forest") {
            binding.back.setBackgroundResource(R.drawable.bg_forest)
            binding.editWantHer.setBackgroundResource(R.drawable.title5)
            binding.editDoneButton.setBackgroundResource(R.drawable.leave2)
            binding.editBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#04B486")))
        }
        else if(MainActivity.season == "autumn"){
            binding.back.setBackgroundResource(R.drawable.bg_autumn)
            binding.editWantHer.setBackgroundResource(R.drawable.title_beach2)
            binding.editDoneButton.setBackgroundResource(R.drawable.autumn2)
            binding.editBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#DF013A")))
        }
        else if(MainActivity.season == "summer"){
            binding.back.setBackgroundResource(R.drawable.bg_beach)
            binding.editWantHer.setBackgroundResource(R.drawable.title_beach2)
            binding.editDoneButton.setBackgroundResource(R.drawable.shell3)
            binding.editBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2E9AFE")))
        }
        else if(MainActivity.season == "spring"){
            binding.back.setBackgroundResource(R.drawable.bg_spring)
            binding.editWantHer.setBackgroundResource(R.drawable.title_spring3)
            binding.editDoneButton.setBackgroundResource(R.drawable.flower3)
            binding.editBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F781D8")))
        }
        else if(MainActivity.season == "winter"){
            binding.back.setBackgroundResource(R.drawable.bg_winter)
            binding.editWantHer.setBackgroundResource(R.drawable.title_winter2)
            binding.editDoneButton.setBackgroundResource(R.drawable.snow2)
            binding.editBackArrow.backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#F2F2F2")))
        }

        setContentView(binding.root)
        init()
    }

    fun init() {
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        val database = Firebase.database
        val word = database.getReference("users").child(LoginActivity.username).child("word")
        word.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //TODO: 정리
                var text1 = dataSnapshot.child("word1").getValue(String::class.java).toString()
                var text2 = dataSnapshot.child("word2").getValue(String::class.java).toString()
                var text3 = dataSnapshot.child("word3").getValue(String::class.java).toString()
                var text4 = dataSnapshot.child("word4").getValue(String::class.java).toString()
                var text5 = dataSnapshot.child("word5").getValue(String::class.java).toString()
                var count = dataSnapshot.child("full").getValue(Int::class.java)
                binding.textView1.text = text1
                binding.textView2.text = text2
                binding.textView3.text = text3
                binding.textView4.text = text4
                binding.textView5.text = text5

                binding.editBackArrow.setOnClickListener {
                    var Intent =Intent(this@EditThingsWantToHearActivity, ThingsWantToHearActivity::class.java)
                    startActivity(Intent)
                }

                if (binding.textView1.text != "") {
                    binding.imageButton1.visibility = View.VISIBLE
                }else{
                    binding.imageButton1.visibility = View.INVISIBLE
                }
                if (binding.textView2.text != "") {
                    binding.imageButton2.visibility = View.VISIBLE
                }else{
                    binding.imageButton2.visibility = View.INVISIBLE
                }
                if (binding.textView3.text != "") {
                    binding.imageButton3.visibility = View.VISIBLE
                }else{
                    binding.imageButton3.visibility = View.INVISIBLE
                }
                if (binding.textView4.text != "") {
                    binding.imageButton4.visibility = View.VISIBLE
                }else{
                    binding.imageButton4.visibility = View.INVISIBLE
                }
                if (binding.textView5.text != "") {
                    binding.imageButton5.visibility = View.VISIBLE
                }else{
                    binding.imageButton5.visibility = View.INVISIBLE
                }

                binding.imageButton1.setOnClickListener{
                    word.child("word1").setValue("")
                    if(binding.textView2.text != ""){
                        word.child("word1").setValue(binding.textView2.text)
                        word.child("word2").setValue("")
                    }
                    if(binding.textView3.text != ""){
                        word.child("word2").setValue(binding.textView3.text)
                        word.child("word3").setValue("")
                    }
                    if(binding.textView4.text != ""){
                        word.child("word3").setValue(binding.textView4.text)
                        word.child("word4").setValue("")
                    }
                    if(binding.textView5.text != ""){
                        word.child("word4").setValue(binding.textView5.text)
                        word.child("word5").setValue("")
                    }
                    if (count != null) {
                        count = count!! - 1
                    }

                    word.child("full").setValue(count)
                }
                binding.imageButton2.setOnClickListener{
                    word.child("word2").setValue("")
                    if(binding.textView3.text != ""){
                        word.child("word2").setValue(binding.textView3.text)
                        word.child("word3").setValue("")
                    }
                    if(binding.textView4.text != ""){
                        word.child("word3").setValue(binding.textView4.text)
                        word.child("word4").setValue("")
                    }
                    if(binding.textView5.text != ""){
                        word.child("word4").setValue(binding.textView5.text)
                        word.child("word5").setValue("")
                    }
                    if (count != null) {
                        count = count!! - 1
                    }
                    word.child("full").setValue(count)
                }
                binding.imageButton3.setOnClickListener{
                    word.child("word3").setValue("")
                    if(binding.textView4.text != ""){
                        word.child("word3").setValue(binding.textView4.text)
                        word.child("word4").setValue("")
                    }
                    if(binding.textView5.text != ""){
                        word.child("word4").setValue(binding.textView5.text)
                        word.child("word5").setValue("")
                    }
                    if (count != null) {
                        count = count!! - 1
                    }
                    word.child("full").setValue(count)
                }
                binding.imageButton4.setOnClickListener{
                    word.child("word4").setValue("")
                    if(binding.textView5.text != ""){
                        word.child("word4").setValue(binding.textView5.text)
                        word.child("word5").setValue("")
                    }
                    if (count != null) {
                        count = count!! - 1
                    }
                    word.child("full").setValue(count)
                }
                binding.imageButton5.setOnClickListener{
                    word.child("word5").setValue("")
                    if (count != null) {
                        count = count!! - 1
                    }
                    word.child("full").setValue(count)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

        binding.editDoneButton.setOnClickListener {
            var Intent = Intent(this, ThingsWantToHearActivity::class.java)
            startActivity(Intent)
        }
    }

}