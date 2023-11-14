package com.example.klab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R
import com.example.klab2.ForgetPasswordActivity

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var newPasswordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        newPasswordEditText = findViewById(R.id.newPasswordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)

        val resetButton: Button = findViewById(R.id.resetButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        resetButton.setOnClickListener {
            // 获取用户输入的新密码和确认密码
            val newPassword = newPasswordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            // 在这里执行密码重置操作
            if (newPassword == confirmPassword) {
                // 密码重置成功
                Toast.makeText(this@ResetPasswordActivity, "비밀번호 재설정 완료", Toast.LENGTH_SHORT).show()
                // 在这里可以执行其他操作，如返回登录界面
            } else {
                // 密码重置失败
                Toast.makeText(this@ResetPasswordActivity, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            }
        }

        backToLoginButton.setOnClickListener {
            // 创建一个 Intent 以返回到登录界面
            val intent = Intent(this@ResetPasswordActivity, ForgetPasswordActivity::class.java)
            startActivity(intent)
            finish() // 结束当前的忘记密码界面
        }
    }
}
