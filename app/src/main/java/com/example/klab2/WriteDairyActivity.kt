package com.example.klab2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.klab2.databinding.ActivityWriteDairyBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.values
import com.google.firebase.ktx.Firebase

class WriteDairyActivity : AppCompatActivity() {
    lateinit var binding: ActivityWriteDairyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteDairyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun init(){
        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
        val userid = sharedPreferences.getString("user", "")
        val database = Firebase.database
        val user = database.getReference("users").child(LoginActivity.username)
        val day = user.child("calender").child(CalendarFragment.year1.toString())
            .child((CalendarFragment.month1+1).toString()).child(CalendarFragment.day1.toString())
        var pointResult: Int = 0

        binding.wrtBackArrow.setOnClickListener {
            var Intent = Intent(this@WriteDairyActivity, CheckEmojiActivity::class.java)
            startActivity(Intent)
        }

        val point = user.child("total_point")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    pointResult = snapshot.value.toString().toInt()
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })

        day.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                binding.dairySaveButton.setOnClickListener {
                    var title = binding.dairyTitle.text.toString()
                    var content = binding.dairyContent.text.toString()
                    day.child("dairy_title").setValue(title)
                    day.child("dairy_content").setValue(content)

                    val builder = AlertDialog.Builder(this@WriteDairyActivity)
                    builder.setTitle("Complete!")
                        .setMessage("Your wrote dairy is written, your activity is uploaded")
                        .setPositiveButton("Save", DialogInterface.OnClickListener { dialog, id ->
                            var Intent = Intent(this@WriteDairyActivity, MainActivity::class.java)
                            MainActivity.select = 2
                            Toast.makeText(this@WriteDairyActivity, "5포인트가 적립되었습니다.", Toast.LENGTH_SHORT).show()
                            val point2 = pointResult + 5
                            user.child("total_point").setValue(point2)
                            startActivity(Intent)
                        })
                    builder.show()
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

}