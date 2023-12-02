package com.example.klab2

import android.app.AlertDialog
import android.content.Intent
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