package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class SettingThemeActivity : AppCompatActivity() {

    private lateinit var themeRadioGroup: RadioGroup
    private lateinit var lightThemeRadioButton: RadioButton
    private lateinit var darkThemeRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 初始界面为白色主题
        setTheme(R.style.AppTheme_Light)

        setContentView(R.layout.change_theme)

        themeRadioGroup = findViewById(R.id.themeRadioGroup)
        lightThemeRadioButton = findViewById(R.id.lightThemeRadioButton)
        darkThemeRadioButton = findViewById(R.id.darkThemeRadioButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)

        themeRadioGroup.check(R.id.lightThemeRadioButton)

        themeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.lightThemeRadioButton -> setTheme(R.style.AppTheme_Light)
                R.id.darkThemeRadioButton -> setTheme(R.style.AppTheme_Dark)
            }

            recreate()
        }

        backToLoginButton.setOnClickListener {
            // 创建一个 Intent 以返回到设置界面
            val intent = Intent(this@SettingThemeActivity, SettingActivity::class.java)
            startActivity(intent)
            finish() // 结束当前的修改个人信息界面
        }
    }
}
