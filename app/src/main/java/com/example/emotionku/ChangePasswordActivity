package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_password)

        // 找到UI组件
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)
        val confirmPasswordEditText: EditText = findViewById(R.id.editTextConfirmPassword)
        val savePasswordButton: Button = findViewById(R.id.savePasswordButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        // 添加保存密码按钮的点击事件处理逻辑
        savePasswordButton.setOnClickListener {
            // 在这里处理保存密码的逻辑
        }

        // 添加返回按钮的点击事件处理逻辑
        backToLoginButton.setOnClickListener {
            // 创建一个 Intent 以返回到设置界面
            val intent = Intent(this@ChangePasswordActivity, SettingActivity::class.java)
            startActivity(intent)
            finish() // 结束当前的修改密码界面
        }
    }
}
