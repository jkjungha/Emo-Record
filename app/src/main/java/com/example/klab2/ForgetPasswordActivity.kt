package com.example.klab2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.klab2.LoginActivity
import com.example.klab2.ResetPasswordActivity

// ForgetPasswordActivity.kt
class ForgetPasswordActivity : AppCompatActivity() {
    private lateinit var resetEmailOrPhoneEditText: EditText

    private fun isEmailValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return email.matches(emailPattern)
    }

    private fun isPhoneNumberValid(phoneNumber: String): Boolean {
        val phonePattern = "^[0-9]{11}$".toRegex()
        return phoneNumber.matches(phonePattern)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_password)

        resetEmailOrPhoneEditText = findViewById(R.id.resetEmailOrPhoneEditText)

        val resetPasswordButton: Button = findViewById(R.id.resetButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        resetPasswordButton.setOnClickListener {
            val emailOrPhone = resetEmailOrPhoneEditText.text.toString()

            // 检查是否匹配
            val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
            val validatedEmailOrPhone = sharedPreferences.getString("validatedEmailOrPhone", "")

            if (emailOrPhone == validatedEmailOrPhone) {
                // 用户提供的手机号或邮箱与验证成功的匹配
                // 执行密码重置逻辑
                val intent = Intent(this@ForgetPasswordActivity, ResetPasswordActivity::class.java)
                startActivity(intent)
            } else {
                // 用户提供的手机号或邮箱与验证成功的不匹配
                Toast.makeText(this@ForgetPasswordActivity, "전화번호 또는 이메일 불일치", Toast.LENGTH_SHORT).show()
            }
        }

        backToLoginButton.setOnClickListener {
            // 创建一个 Intent 以返回到登录界面
            val intent = Intent(this@ForgetPasswordActivity, LoginActivity::class.java)
            startActivity(intent)
            finish() // 结束当前的忘记密码界面
        }
    }
}
