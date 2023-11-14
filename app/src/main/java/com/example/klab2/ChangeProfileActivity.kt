package com.example.klab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.klab2.SettingActivity

// ChangeProfileActivity.kt
class ChangeProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_profile)

        // 找到UI组件
        val nameEditText: EditText = findViewById(R.id.editTextName)
        val saveButton: Button = findViewById(R.id.saveButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        // 添加保存按钮的点击事件处理逻辑
        saveButton.setOnClickListener {
            // 在这里处理保存个人信息的逻辑
        }

        // 添加返回按钮的点击事件处理逻辑
        backToLoginButton.setOnClickListener {
            // 创建一个 Intent 以返回到设置界面
            val intent = Intent(this@ChangeProfileActivity, SettingActivity::class.java)
            startActivity(intent)
            finish() // 结束当前的修改个人信息界面
        }
    }
}
