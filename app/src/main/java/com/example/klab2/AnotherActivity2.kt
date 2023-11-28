package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnotherActivity2 : AppCompatActivity() {
    private lateinit var loadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another2)

        loadingHelper = LoadingHelper(this)

        val recommendationTextView: TextView = findViewById(R.id.recommendationTextView)
        val backButton: Button = findViewById(R.id.backButton)

        // 获取 RecommendationActivity 传递过来的数据
        val selectedRecommendation = intent.getStringExtra("selectedRecommendation")

        // 显示推荐的活动信息
        recommendationTextView.text = "테마 선택：$selectedRecommendation"

        // 返回按钮点击事件处理
        backButton.setOnClickListener {
            // 在返回之前显示加载动画
            showLoading()

            // 模拟延时，然后返回
            Handler().postDelayed({
                // 隐藏加载动画
                hideLoading()

                // 返回到 RecommendationActivity
                finish()
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
