package com.example.klab2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.ForgetPasswordActivity
import com.example.klab2.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

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

        val database = Firebase.database
        val user = database.getReference("users")
        user.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                resetButton.setOnClickListener {
                    // 获取用户输入的新密码和确认密码
                    val newPassword = newPasswordEditText.text.toString()
                    val confirmPassword = confirmPasswordEditText.text.toString()

                    // 在这里执行密码重置操作
                    if (newPassword == confirmPassword) {
                        // 密码重置成功
                        val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
                        val savedUsername = sharedPreferences.getString("user", "")
                        if(savedUsername != null){
                            user.child(savedUsername).child("private").child("password").setValue(newPassword)
                            Toast.makeText(this@ResetPasswordActivity, "비밀번호 재설정 완료", Toast.LENGTH_SHORT).show()
                            var Intent = Intent(this@ResetPasswordActivity, LoginActivity::class.java)
                            startActivity(Intent)
                        }else{
                            Toast.makeText(this@ResetPasswordActivity, "사용자 이름 찾을 수 없음", Toast.LENGTH_SHORT).show()
                        }
                        // 在这里可以执行其他操作，如返回登录界面
                    } else {
                        // 密码重置失败
                        Toast.makeText(this@ResetPasswordActivity, "비밀번호가 일치하지 않음", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

        backToLoginButton.setOnClickListener {
            // 创建一个 Intent 以返回到登录界面
            val intent = Intent(this@ResetPasswordActivity, ForgetPasswordActivity::class.java)
            startActivity(intent)
            finish() // 结束当前的忘记密码界面
        }
    }
}