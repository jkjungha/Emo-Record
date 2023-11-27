package com.example.klab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.klab2.databinding.ChangeThemeBinding

class ChangeThemeActivity : AppCompatActivity() {
    lateinit var binding: ChangeThemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ChangeThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init(){
    }

}