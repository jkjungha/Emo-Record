package com.example.klab2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.MainActivity.Companion.select
import com.google.firebase.database.FirebaseDatabase

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper

    private val db = FirebaseDatabase.getInstance("https://emotion-3bf81-default-rtdb.firebaseio.com/")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_password)

        loadingHelper = LoadingHelper(this)

        // 找到UI组件
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)
        val confirmPasswordEditText: EditText = findViewById(R.id.editTextConfirmPassword)
        val savePasswordButton: Button = findViewById(R.id.savePasswordButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        // 添加保存密码按钮的点击事件处理逻辑
        savePasswordButton.setOnClickListener {
            val password1 = passwordEditText.text.toString()
            val password2 = confirmPasswordEditText.text.toString()
            // 在这里处理保存密码的逻辑，并在保存前显示加载动画
            if(password1.equals(password2)){
                showLoading()
                db.getReference("users").child(LoginActivity.username).child("private").child("password").setValue(confirmPasswordEditText.text.toString())
                Toast.makeText(this,"비밀번호 수정이 완료되었습니다.",Toast.LENGTH_SHORT)
                passwordEditText.text.clear()
                confirmPasswordEditText.text.clear()
                // 模拟延时，然后隐藏加载动画
                Handler().postDelayed({
                    hideLoading()

                    // 这里添加保存密码的实际逻辑
                }, 2000) // 调整延时时间
            }
            else{
                Toast.makeText(this,"비밀번호 입력이 잘못되었습니다.",Toast.LENGTH_SHORT)
            }
        }

        // 添加返回按钮的点击事件处理逻辑
        backToLoginButton.setOnClickListener {
            // 在返回之前显示加载动画
            showLoading()

            // 模拟延时，然后返回到设置界面
            Handler().postDelayed({
                hideLoading()

                // 创建一个 Intent 以返回到设置界面
//                val intent = Intent(this@ChangePasswordActivity, MainActivity::class.java)
                MainActivity.select = 0
//                startActivity(intent)
                finish() // 结束当前的修改密码界面
            }, 2000) // 调整延时时间
        }
    }

    private fun showLoading() {
        loadingHelper.showLoading()
    }

    private fun hideLoading() {
        loadingHelper.hideLoading()
    }
}
