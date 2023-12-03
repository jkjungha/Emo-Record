package com.example.klab2


import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.database.FirebaseDatabase

class ChangeProfileActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper

    private val db = FirebaseDatabase.getInstance("https://emotion-3bf81-default-rtdb.firebaseio.com/")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_profile)

        loadingHelper = LoadingHelper(this)

        if(MainActivity.season == "forest"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.forest_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.forest_bar  )
            }


            findViewById<Button>(R.id.saveButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#0B6623")))
            findViewById<Button>(R.id.backToLoginButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#607d3b")))
        }
        else if(MainActivity.season == "autumn"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.autumn_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.autumn_bar   )
            }

            findViewById<Button>(R.id.saveButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#c35817")))
            findViewById<Button>(R.id.backToLoginButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#fffbc02d")))
        }
        else if(MainActivity.season == "summer"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.summer_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.summer_bar  )
            }

            findViewById<Button>(R.id.saveButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#2e5984")))
            findViewById<Button>(R.id.backToLoginButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#5fa3e1")))
        }
        else if(MainActivity.season == "spring"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.spring_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.spring_bar   )
            }

            findViewById<Button>(R.id.saveButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#fff06292")))
            findViewById<Button>(R.id.backToLoginButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#fff48fb1")))
        }
        else if(MainActivity.season == "winter"){
            supportActionBar?.setBackgroundDrawable(
                ColorDrawable(
                    ContextCompat.getColor(
                        this,
                        R.color.winter_bar
                    )
                )
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(this, R.color.winter_bar  )
            }

            findViewById<Button>(R.id.saveButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#1e3f66e")))
            findViewById<Button>(R.id.backToLoginButton).backgroundTintList =
                ColorStateList.valueOf((Color.parseColor("#5fa3e1")))
        }

        // 找到UI组件
        val nameEditText: EditText = findViewById(R.id.editTextName)
        val saveButton: Button = findViewById(R.id.saveButton)
        val backToLoginButton: Button = findViewById(R.id.backToLoginButton)
        val name2:EditText = findViewById(R.id.editTextOtherInfo)

        // 添加保存按钮的点击事件处理逻辑
        saveButton.setOnClickListener {
            val name1 = nameEditText.text.toString()
            val name22 = name2.text.toString()
            // 在这里处理保存密码的逻辑，并在保存前显示加载动画
            if (name1.equals(name2)) {
                showLoading()
                db.getReference("users").child(LoginActivity.username).setValue(name22)
                Toast.makeText(this, "비밀번호 수정이 완료되었습니다.", Toast.LENGTH_SHORT)
                nameEditText.text.clear()
                name2.text.clear()
                // 模拟延时，然后隐藏加载动画
                Handler().postDelayed({
                    hideLoading()

                    // 这里添加保存密码的实际逻辑
                }, 2000) // 调整延时时间
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
//                val intent = Intent(this@ChangeProfileActivity, MainActivity::class.java)
                MainActivity.select = 0
                finish() // 结束当前的修改个人信息界面
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
