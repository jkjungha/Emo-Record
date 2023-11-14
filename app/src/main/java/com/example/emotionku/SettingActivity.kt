package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // 设置对应的 XML 布局文件
    }

    // 重写 onCreateOptionsMenu 方法以创建菜单项
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return true
    }

    // 处理菜单项点击事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_profile -> {
                // 处理更改个人信息
                val intent = Intent(this, ChangeProfileActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.change_password -> {
                // 处理更改密码
                val intent = Intent(this, ChangePasswordActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.change_theme -> {
                // 处理设置主题
                val intent = Intent(this, SettingThemeActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
