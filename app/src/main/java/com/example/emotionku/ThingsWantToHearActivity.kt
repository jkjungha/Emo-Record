package com.example.emotionku

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.emotionku.databinding.ActivityThingsWantToHearBinding


class ThingsWantToHearActivity : AppCompatActivity() {
    lateinit var binding: ActivityThingsWantToHearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThingsWantToHearBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        setTextList()

        binding.oriAddButton.setOnClickListener {
            var Intent = Intent(this, AddThingsWantToHearActivity::class.java)
            startActivity(Intent)
        }
        binding.oriEditButton.setOnClickListener {
            var Intent = Intent(this, EditThingsWantToHearActivity::class.java)
            startActivity(Intent)
        }
//        binding.oriSettingsButton.setOnClickListener{
//            var Intent = Intent(this, SettingsActivity::class.java)
//            startActivity(Intent)
//        }
    }
    fun setTextList(){
        val data = getSharedPreferences("data", Context.MODE_PRIVATE)

        val text1 = data.getString("text1", "")
        val text2 = data.getString("text2", "")
        val text3 = data.getString("text3", "")
        val text4 = data.getString("text4", "")
        val text5 = data.getString("text5", "")

        Log.d("MAIN PAGE", "PRINT")
        Log.d("text1", text1.toString())
        Log.d("text2", text2.toString())
        Log.d("text3", text3.toString())
        Log.d("text4", text4.toString())
        Log.d("text5", text5.toString())

        binding.textView1.text = text1
        binding.textView2.text = text2
        binding.textView3.text = text3
        binding.textView4.text = text4
        binding.textView5.text = text5
    }
}

