package com.example.emotionku

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.emotionku.databinding.ActivityEditThingsWantToHearBinding

class EditThingsWantToHearActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditThingsWantToHearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditThingsWantToHearBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        setDataAll()
        val data = getSharedPreferences("data", Context.MODE_PRIVATE)
        val editor = data.edit()

        binding.editDoneButton.setOnClickListener {
            var Intent = Intent(this, ThingsWantToHearActivity::class.java)
            startActivity(Intent)
        }

        binding.imageButton1.setOnClickListener {
            var text1 = data.getString("text1", "")
            var text2 = data.getString("text2", "")
            var text3 = data.getString("text3", "")
            var text4 = data.getString("text4", "")
            var text5 = data.getString("text5", "")
            editor.putString("text1", "")
            editor.putString("count", "")
            if (text2 != "") {
                editor.putString("text1", text2)
                editor.putString("text2", "")
                editor.putString("count", "1")
            }
            if (text3 != "") {
                editor.putString("text2", text3)
                editor.putString("text3", "")
                editor.putString("count", "2")
            }
            if (text4 != "") {
                editor.putString("text3", text4)
                editor.putString("text4", "")
                editor.putString("count", "3")
            }
            if (text5 != "") {
                editor.putString("text4", text5)
                editor.putString("text5", "")
                editor.putString("count", "4")
            }

            editor.commit()
            setDataAll()
        }
        binding.imageButton2.setOnClickListener {
            var text1 = data.getString("text1", "")
            var text2 = data.getString("text2", "")
            var text3 = data.getString("text3", "")
            var text4 = data.getString("text4", "")
            var text5 = data.getString("text5", "")
            editor.putString("text2", "")
            editor.putString("count", "1")
            if (text3 != "") {
                editor.putString("text2", text3)
                editor.putString("text3", "")
                editor.putString("count", "2")
            }
            if (text4 != "") {
                editor.putString("text3", text4)
                editor.putString("text4", "")
                editor.putString("count", "3")
            }
            if (text5 != "") {
                editor.putString("text4", text5)
                editor.putString("text5", "")
                editor.putString("count", "4")
            }
            editor.commit()
            setDataAll()
        }
        binding.imageButton3.setOnClickListener {
            var text1 = data.getString("text1", "")
            var text2 = data.getString("text2", "")
            var text3 = data.getString("text3", "")
            var text4 = data.getString("text4", "")
            var text5 = data.getString("text5", "")
            editor.putString("text3", "")
            editor.putString("count", "2")
            if (text4 != "") {
                editor.putString("text3", text4)
                editor.putString("text4", "")
                editor.putString("count", "3")
            }
            if (text5 != "") {
                editor.putString("text4", text5)
                editor.putString("text5", "")
                editor.putString("count", "4")
            }
            editor.commit()
            setDataAll()
        }
        binding.imageButton4.setOnClickListener {
            var text1 = data.getString("text1", "")
            var text2 = data.getString("text2", "")
            var text3 = data.getString("text3", "")
            var text4 = data.getString("text4", "")
            var text5 = data.getString("text5", "")
            editor.putString("text4", "")
            editor.putString("count", "3")
            if (text5 != "") {
                editor.putString("text4", text5)
                editor.putString("text5", "")
                editor.putString("count", "4")
            }
            editor.commit()
            setDataAll()

        }
        binding.imageButton5.setOnClickListener {
            var text1 = data.getString("text1", "")
            var text2 = data.getString("text2", "")
            var text3 = data.getString("text3", "")
            var text4 = data.getString("text4", "")
            var text5 = data.getString("text5", "")
            editor.putString("text5", "")
            editor.putString("count", "4")
            editor.commit()
            setDataAll()
        }

    }
    fun setDataAll(){
        val data = getSharedPreferences("data", Context.MODE_PRIVATE)
        val text1 = data.getString("text1", "")
        val text2 = data.getString("text2", "")
        val text3 = data.getString("text3", "")
        val text4 = data.getString("text4", "")
        val text5 = data.getString("text5", "")

        Log.d("EDIT PAGE", "PRINT")
        Log.d("text1", text1.toString())
        Log.d("text2", text2.toString())
        Log.d("text3", text3.toString())
        Log.d("text4", text4.toString())
        Log.d("text5", text5.toString())

        binding.imageButton1.visibility = View.INVISIBLE
        binding.imageButton2.visibility = View.INVISIBLE
        binding.imageButton3.visibility = View.INVISIBLE
        binding.imageButton4.visibility = View.INVISIBLE
        binding.imageButton5.visibility = View.INVISIBLE
        binding.textView1.text = text1
        binding.textView2.text = text2
        binding.textView3.text = text3
        binding.textView4.text = text4
        binding.textView5.text = text5
        if (text1 != "") {
            binding.imageButton1.visibility = View.VISIBLE
        }
        if (text2 != "") {
            binding.imageButton2.visibility = View.VISIBLE
        }
        if (text3 != "") {
            binding.imageButton3.visibility = View.VISIBLE
        }
        if (text4 != "") {
            binding.imageButton4.visibility = View.VISIBLE
        }
        if (text5 != "") {
            binding.imageButton5.visibility = View.VISIBLE
        }
    }

}