package com.example.klab2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.databinding.ActivityMsgBinding

class MessageActivity : AppCompatActivity() {
    lateinit var binding : ActivityMsgBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMsgBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        val word = intent?.getStringExtra("word")

        binding.textMsg.text = word
    }
}