package com.example.klab2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.klab2.R

class LoadingHelper(private val activity: Activity) {
    private lateinit var loadingView: View

    init {
        initLoadingView()
    }

    private fun initLoadingView() {
        val inflater: LayoutInflater = LayoutInflater.from(activity)
        loadingView = inflater.inflate(R.layout.loading_layout, null, false)
        loadingView.visibility = View.GONE
    }

    fun showLoading() {
        val contentView: ViewGroup = activity.findViewById(android.R.id.content)
        contentView.addView(loadingView)
        loadingView.visibility = View.VISIBLE
    }

    fun hideLoading() {
        val contentView: ViewGroup = activity.findViewById(android.R.id.content)
        contentView.removeView(loadingView)
        loadingView.visibility = View.GONE
    }
}
