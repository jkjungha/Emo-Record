package com.example.emotionku

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.emotionku.databinding.ActivityWriteDairyBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
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
        val database = Firebase.database
        val day = database.getReference("user/calender/year/month/day")
        day.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                binding.dariySaveButton.setOnClickListener {
                    var title = binding.dairyTitle.text.toString()
                    var content = binding.dairyContent.text.toString()
                    day.child("dairy_title").setValue(title)
                    day.child("dairy_content").setValue(content)

                    val builder = AlertDialog.Builder(this@WriteDairyActivity)
                    builder.setTitle("Complete!")
                        .setMessage("Your wrote dairy is written, your activity is uploaded")
                        .setPositiveButton("Save", DialogInterface.OnClickListener { dialog, id ->
                            var Intent = Intent(this@WriteDairyActivity, ThingsWantToHearActivity::class.java)
                            startActivity(Intent)
                        })
                    builder.show()

//                    var Intent = Intent(this@WriteDairyActivity, AfterWriteDairyPopUpActivity::class.java)
//                    startActivityForResult(Intent, 1)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == 1){
//            if(resultCode == RESULT_OK){
//                Toast.makeText(this, "Got Activity!", Toast.LENGTH_SHORT)
//            }
//        }
//    }
}