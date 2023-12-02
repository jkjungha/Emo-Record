package com.example.klab2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper

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
            // 在这里处理保存密码的逻辑，并在保存前显示加载动画
            showLoading()

            // 模拟延时，然后隐藏加载动画
            Handler().postDelayed({
                hideLoading()

                // 这里添加保存密码的实际逻辑
            }, 2000) // 调整延时时间
        }

        // 添加返回按钮的点击事件处理逻辑
        backToLoginButton.setOnClickListener {
            // 在返回之前显示加载动画
            showLoading()

            // 模拟延时，然后返回到设置界面
            Handler().postDelayed({
                hideLoading()

                // 创建一个 Intent 以返回到设置界面
                val intent = Intent(this@ChangePasswordActivity, SettingActivity::class.java)
                startActivity(intent)
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
