package com.example.emotionku

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.emotionku.databinding.ActivityAddThingsWantToHearBinding


class AddThingsWantToHearActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddThingsWantToHearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddThingsWantToHearBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        binding.addDoneButton.setOnClickListener {
            val data = getSharedPreferences("data", Context.MODE_PRIVATE)
            var hearText = binding.addTypeText.text.toString()
            Log.d("HEAR", hearText)
            val count = data.getString("count", "")
            Log.d("COUNT", count.toString())
            val editor = data.edit()
            if (!hearText.equals("")) {
                if (count.equals("")) {
                    editor.putString("text1", hearText)
                    editor.putString("count", "1")
                } else if (count.equals("1") ) {
                    editor.putString("text2", hearText)
                    editor.putString("count", "2")
                } else if (count.equals("2")) {
                    editor.putString("text3", hearText)
                    editor.putString("count", "3")
                } else if (count.equals("3")) {
                    editor.putString("text4", hearText)
                    editor.putString("count", "4")
                } else if (count.equals("4")) {
                    editor.putString("text5", hearText)
                    editor.putString("count", "5")
                }
                editor.commit()
            }

            var Intent = Intent(this, ThingsWantToHearActivity::class.java)
            binding.addTypeText.text.clear()
            startActivity(Intent)
        }
    }
}