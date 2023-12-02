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
import com.example.klab2.ForgetPasswordActivity
import com.example.klab2.R
import com.example.klab2.RegisterActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    companion object{
        var username:String = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val loginButton: Button = findViewById(R.id.loginButton)
        val registerButton: Button = findViewById(R.id.registerButton)
        val forgotPasswordButton: Button = findViewById(R.id.forgotPasswordButton)

        registerButton.setOnClickListener {
            // 创建一个 Intent 以跳转到注册界面
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        forgotPasswordButton.setOnClickListener {
            // 创建一个 Intent 以跳转到忘记密码界面
            val intent = Intent(this@LoginActivity, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        // 从 Shared Preferences 中获取已保存的用户名和密码
//            val sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE)
//            val savedUsername = sharedPreferences.getString("username", "")
//            val savedPassword = sharedPreferences.getString("password", "")

        val database = Firebase.database
        val user = database.getReference("users")
        user.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                loginButton.setOnClickListener {
                    // 获取用户输入的用户名和密码
                    val enteredUsername = usernameEditText.text.toString()
                    val enteredPassword = passwordEditText.text.toString()
                    // 检查用户名和密码是否匹配
                    if(!dataSnapshot.hasChild(enteredUsername)){
                        Toast.makeText(this@LoginActivity, "아이디 없음", Toast.LENGTH_SHORT).show()
                    }else{
                        val savedPassword =
                            dataSnapshot.child(enteredUsername).child("private").child("password").getValue(String::class.java).toString()
                        if (enteredPassword == savedPassword) {
                            // 登录成功s
                            Toast.makeText(this@LoginActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                            val sharedPreferences = getSharedPreferences("live", MODE_PRIVATE)
                            val editor: SharedPreferences.Editor = sharedPreferences.edit()
                            editor.putString("user", enteredUsername)
                            LoginActivity.username = enteredUsername
                            editor.apply()
                            Log.d("GOT YOU", "LOGIN")

                            var Intent =
                                Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(Intent)
                            // 在这里可以进行登录后的操作，如跳转到主界面
                        } else {
                            // 登录失败
                            Toast.makeText(
                                this@LoginActivity,
                                "비밀번호가 잘못되었습니다",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })

    }
}