package com.example.klab2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.klab2.databinding.WordmainBinding

class WordFragment : Fragment() {
    private lateinit var binding: WordmainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WordmainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.wthbut.setOnClickListener {
            activity?.let {
                var Intent = Intent(context, PointShopFragment::class.java)
                startActivity(Intent)
            }
        }
    }
}


