package com.example.klab2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.LoginActivity
import com.example.klab2.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var emailOrPhoneEditText: EditText
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        emailOrPhoneEditText = findViewById(R.id.emailOrPhoneEditText)
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val verifyButton: Button = findViewById(R.id.verifyButton)
        val registerButton: Button = findViewById(R.id.registerButton)
        val backButton: Button = findViewById(R.id.backButton)

        verifyButton.setOnClickListener {
            val emailOrPhone = emailOrPhoneEditText.text.toString()
            // 在这里执行验证操作
            if (isValidEmailOrPhone(emailOrPhone)) {
                // 保存验证成功的手机号或邮箱
                val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("validatedEmailOrPhone", emailOrPhone)
                editor.apply()

                Toast.makeText(this@RegisterActivity, "확인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@RegisterActivity, "확인 실패", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {
            val emailOrPhone = emailOrPhoneEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // 验证手机号或邮箱格式
            if (!isValidEmailOrPhone(emailOrPhone)) {
                Toast.makeText(this@RegisterActivity, "유효하지 않은 이메일 또는 전화번호", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // 验证失败，不执行注册
            }

            // 验证其他注册信息
            if (isValidInput(username, password)) {
                // 执行注册操作

                // 保存用户名和密码到SharedPreferences
                val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this@RegisterActivity, "등록 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
                // 后续注册逻辑
            } else {
                Toast.makeText(this@RegisterActivity, "유효하지 않은 사용자 이름 또는 비밀번호", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            // 返回到登录界面
            finish()
        }
    }

    // 添加输入验证逻辑
    private fun isValidEmailOrPhone(emailOrPhone: String): Boolean {
        // 验证邮箱或手机号格式
        return android.util.Patterns.EMAIL_ADDRESS.matcher(emailOrPhone).matches() || emailOrPhone.matches("\\d{11}".toRegex())
    }

    private fun isValidUsername(username: String): Boolean {
        // 使用正则表达式验证用户名
        // 允许用户名由字母和数字组成，或者是纯字母
        val regex = "^[a-zA-Z0-9]+$".toRegex() // 此正则表达式匹配字母和数字的组合
        val alphaRegex = "^[a-zA-Z]+$".toRegex() // 此正则表达式匹配纯字母

        return username.matches(regex) || username.matches(alphaRegex)
    }

    private fun isValidInput(username: String, password: String): Boolean {
        // 验证用户名和密码格式
        return username.length in 6 until 10 && password.length in 8 until 10 && username != password
    }
}
