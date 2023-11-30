package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.klab2.R

class HomeActivity : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadingHelper = LoadingHelper(this)

        val recommendButton: Button = findViewById(R.id.recommendButton)

        recommendButton.setOnClickListener {
            // 在点击推荐按钮时显示加载动画
            showLoading()

            // 模拟延时，然后隐藏加载动画并启动活动推荐界面
            Handler().postDelayed({
                hideLoading()

                // 启动活动推荐界面
                val intent = Intent(this@HomeActivity, RecommendationActivity::class.java)
                startActivity(intent)
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
