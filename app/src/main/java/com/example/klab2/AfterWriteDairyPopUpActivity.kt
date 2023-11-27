package com.example.klab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import com.example.klab2.databinding.ActivityAfterWriteDiaryPopUpBinding

class AfterWriteDairyPopUpActivity : AppCompatActivity() {
    lateinit var binding: ActivityAfterWriteDiaryPopUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityAfterWriteDiaryPopUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun init(){
        binding.popupButton.setOnClickListener {
            var intent = Intent(this, WriteDairyActivity::class.java)
            setResult(RESULT_OK)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        if(event!!.action == MotionEvent.ACTION_OUTSIDE){
            return false
        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        return
    }
}