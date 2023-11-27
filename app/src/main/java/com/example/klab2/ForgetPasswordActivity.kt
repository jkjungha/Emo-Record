package com.example.klab2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.klab2.LoginActivity
import com.example.klab2.ResetPasswordActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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
        setContentView(R.layout.activity_forget_password)

        resetEmailOrPhoneEditText = findViewById(R.id.resetEmailOrPhoneEditText)

        val resetPasswordButton: Button = findViewById(R.id.resetButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        val database = Firebase.database
        val user = database.getReference("users")
        user.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                resetPasswordButton.setOnClickListener {
                    val emailOrPhone = resetEmailOrPhoneEditText.text.toString()
                    var bool = false

                    for (child in dataSnapshot.children) {
                        var validatedEmailOrPhone = child.child("private").child("emailorphone")
                            .getValue(String::class.java)
                        if (emailOrPhone == validatedEmailOrPhone) {
                            // 用户提供的手机号或邮箱与验证成功的匹配
                            // 执行密码重置逻辑
                            bool = true
                            val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
                            val editor: SharedPreferences.Editor = sharedPreferences.edit()
                            editor.putString("user", child.key)
                            editor.apply()
                            Toast.makeText(this@ForgetPasswordActivity, "인증 완료", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(
                                this@ForgetPasswordActivity,
                                ResetPasswordActivity::class.java
                            )
                            startActivity(intent)
                        }
                    }
                    if (!bool) {
                        Toast.makeText(
                            this@ForgetPasswordActivity,
                            "전화번호 또는 이메일 불일치",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        backToLoginButton.setOnClickListener {
            // 创建一个 Intent 以返回到登录界面
            val intent = Intent(this@ForgetPasswordActivity, LoginActivity::class.java)
            startActivity(intent)
            finish() // 结束当前的忘记密码界面
        }
    }
}