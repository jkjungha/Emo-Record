package com.example.klab2

import android.app.AlertDialog
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.klab2.databinding.ActivityAddThingsWantToHearBinding
import com.example.klab2.databinding.ActivitySelectAcitivityBinding
import com.google.firebase.database.*

class SelectAcitivity : AppCompatActivity() {
    lateinit var binding:ActivitySelectAcitivityBinding
    private val db = FirebaseDatabase.getInstance("https://emotion-3bf81-default-rtdb.firebaseio.com/")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(MainActivity.season == "forest"){
            binding.back.setBackgroundResource(R.drawable.bg_forest)
            binding.chkBackArrow.backgroundTintList = ColorStateList.valueOf((Color.parseColor("#04B486")))
            binding.userInput.setBackgroundResource(R.drawable.round)
            binding.ActBut.setBackgroundResource(R.drawable.round)
            binding.ActBut1.setBackgroundResource(R.drawable.round)
            binding.ActBut2.setBackgroundResource(R.drawable.round)
            binding.ActBut3.setBackgroundResource(R.drawable.round)
            binding.ActBut5.setBackgroundResource(R.drawable.round)
            binding.resetBtn.setBackgroundResource(R.drawable.round)
        }
        else if(MainActivity.season == "autumn"){
            binding.back.setBackgroundResource(R.drawable.bg_autumn)
            binding.chkBackArrow.backgroundTintList = ColorStateList.valueOf((Color.parseColor("#DF013A")))
            binding.userInput.setBackgroundResource(R.drawable.round_autumn)
            binding.ActBut.setBackgroundResource(R.drawable.round_autumn)
            binding.ActBut1.setBackgroundResource(R.drawable.round_autumn)
            binding.ActBut2.setBackgroundResource(R.drawable.round_autumn)
            binding.ActBut3.setBackgroundResource(R.drawable.round_autumn)
            binding.ActBut5.setBackgroundResource(R.drawable.round_autumn)
            binding.resetBtn.setBackgroundResource(R.drawable.round_autumn)
        }
        else if(MainActivity.season == "summer"){
            binding.back.setBackgroundResource(R.drawable.bg_beach)
            binding.chkBackArrow.backgroundTintList = ColorStateList.valueOf((Color.parseColor("#2E9AFE")))
            binding.userInput.setBackgroundResource(R.drawable.round_beach)
            binding.ActBut.setBackgroundResource(R.drawable.round_beach)
            binding.ActBut1.setBackgroundResource(R.drawable.round_beach)
            binding.ActBut2.setBackgroundResource(R.drawable.round_beach)
            binding.ActBut3.setBackgroundResource(R.drawable.round_beach)
            binding.ActBut5.setBackgroundResource(R.drawable.round_beach)
            binding.resetBtn.setBackgroundResource(R.drawable.round_beach)
        }
        else if(MainActivity.season == "spring"){
            binding.back.setBackgroundResource(R.drawable.bg_spring)
            binding.chkBackArrow.backgroundTintList = ColorStateList.valueOf((Color.parseColor("#F781D8")))
            binding.userInput.setBackgroundResource(R.drawable.round_spring)
            binding.ActBut.setBackgroundResource(R.drawable.round_spring)
            binding.ActBut1.setBackgroundResource(R.drawable.round_spring)
            binding.ActBut2.setBackgroundResource(R.drawable.round_spring)
            binding.ActBut3.setBackgroundResource(R.drawable.round_spring)
            binding.ActBut5.setBackgroundResource(R.drawable.round_spring)
            binding.resetBtn.setBackgroundResource(R.drawable.round_spring)
        }
        else if(MainActivity.season == "winter"){
            binding.back.setBackgroundResource(R.drawable.bg_winter)
            binding.chkBackArrow.backgroundTintList = ColorStateList.valueOf((Color.parseColor("#F2F2F2")))
            binding.userInput.setBackgroundResource(R.drawable.round_winter)
            binding.ActBut.setBackgroundResource(R.drawable.round_winter)
            binding.ActBut1.setBackgroundResource(R.drawable.round_winter)
            binding.ActBut2.setBackgroundResource(R.drawable.round_winter)
            binding.ActBut3.setBackgroundResource(R.drawable.round_winter)
            binding.ActBut5.setBackgroundResource(R.drawable.round_winter)
            binding.resetBtn.setBackgroundResource(R.drawable.round_winter)
        }
        binding.chkBackArrow.setOnClickListener {
            var Intent = Intent(this, MainActivity::class.java)
            MainActivity.select = 0
            startActivity(Intent)
        }

        binding.userInput.setOnClickListener {
            val text = binding.editTextTextPersonName2.text
            val builder = AlertDialog.Builder(this)
            builder.setTitle("액티비티 추가").setMessage("액티비티를 추가하시겠습니까?")
                .setPositiveButton("확인") { _, _ ->
                    db.getReference("users").child(LoginActivity.username).child("activity").child(text.toString()).setValue(1)
                    db.getReference("Activity").child(text.toString()).setValue(1)
                    Toast.makeText(this, "액티비티 추가가 완료되었습니다.", Toast.LENGTH_SHORT)
                    binding.editTextTextPersonName2.text.clear()
                }
                .setNegativeButton("취소") { _, _ ->

                }

            builder.show()
        }
        
        //랜덤 지정
        db.getReference("Activity").
        addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val count = snapshot.childrenCount.toInt()

                if (count >= 5) {
                    val activities: MutableList<String> = snapshot.children.map { it.key.orEmpty() }.toMutableList()
                    activities.shuffle()

                    binding.Act.text = activities[0]
                    binding.Act1.text = activities[1]
                    binding.Act2.text = activities[2]
                    binding.Act3.text = activities[3]
                    binding.Act5.text = activities[4]
                } else {

                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })


        binding.resetBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("리셋").setMessage("액티비티를 리셋하시겠습니까?")
                .setPositiveButton("확인") { _, _ ->
                    db.getReference("Activity").
                    addValueEventListener(object: ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            val count = snapshot.childrenCount.toInt()

                            if (count >= 5) {
                                val activities: MutableList<String> = snapshot.children.map { it.key.orEmpty() }.toMutableList()
                                activities.shuffle()

                                binding.Act.text = activities[0]
                                binding.Act1.text = activities[1]
                                binding.Act2.text = activities[2]
                                binding.Act3.text = activities[3]
                                binding.Act5.text = activities[4]
                            } else {

                            }
                        }

                        override fun onCancelled(error: DatabaseError) {
                        }

                    })
                }
                .setNegativeButton("취소") { _, _ ->

                }

            builder.show()
        }

        binding.ActBut.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("액티비티 추가").setMessage("액티비티를 추가하시겠습니까?")
                .setPositiveButton("확인") { _, _ ->
                    val text = binding.Act.text
                    db.getReference("users").child(LoginActivity.username).child("activity").child(text.toString()).setValue(1)
                    Toast.makeText(this, "액티비티 추가가 완료되었습니다.", Toast.LENGTH_SHORT)
                }
                .setNegativeButton("취소") { _, _ ->

                }

            builder.show()
        }

        binding.ActBut1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("액티비티 추가").setMessage("액티비티를 추가하시겠습니까?")
                .setPositiveButton("확인") { _, _ ->
                    val text = binding.Act1.text
                    db.getReference("users").child(LoginActivity.username).child("activity").child(text.toString()).setValue(1)
                    Toast.makeText(this, "액티비티 추가가 완료되었습니다.", Toast.LENGTH_SHORT)
                }
                .setNegativeButton("취소") { _, _ ->

                }

            builder.show()
        }

        binding.ActBut2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("액티비티 추가").setMessage("액티비티를 추가하시겠습니까?")
                .setPositiveButton("확인") { _, _ ->
                    val text = binding.Act2.text
                    db.getReference("users").child(LoginActivity.username).child("activity").child(text.toString()).setValue(1)
                    Toast.makeText(this, "액티비티 추가가 완료되었습니다.", Toast.LENGTH_SHORT)
                }
                .setNegativeButton("취소") { _, _ ->

                }

            builder.show()
        }

        binding.ActBut3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("액티비티 추가").setMessage("액티비티를 추가하시겠습니까?")
                .setPositiveButton("확인") { _, _ ->
                    val text = binding.Act3.text
                    db.getReference("users").child(LoginActivity.username).child("activity").child(text.toString()).setValue(1)
                    Toast.makeText(this, "액티비티 추가가 완료되었습니다.", Toast.LENGTH_SHORT)
                }
                .setNegativeButton("취소") { _, _ ->

                }

            builder.show()
        }

        binding.ActBut5.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("액티비티 추가").setMessage("액티비티를 추가하시겠습니까?")
                .setPositiveButton("확인") { _, _ ->
                    val text = binding.Act5.text
                    db.getReference("users").child(LoginActivity.username).child("activity").child(text.toString()).setValue(1)
                    Toast.makeText(this, "액티비티 추가가 완료되었습니다.", Toast.LENGTH_SHORT)
                }
                .setNegativeButton("취소") { _, _ ->

                }

            builder.show()
        }

    }
}