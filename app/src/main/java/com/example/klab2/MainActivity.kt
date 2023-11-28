package com.example.klab2

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.klab2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG_CALENDER = "calendar_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_POINT = "point_fragment"
private const val TAG_SETTING = "setting_fragment"
private const val TAG_WORD = "word_fragment"
private const val TAG_ADD= "add_fragment"
private const val TAG_EDIT= "edit_fragment"

class MainActivity : AppCompatActivity() {
    companion object{
        var select = 0
    }

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
        Log.d("GOT YOU", "MAIN")

        if(select==0)
            setFragment(TAG_HOME, HomeFragment())
        else if(select==1){
            setFragment(TAG_WORD, WordFragment())
            binding.navigationView.selectedItemId = R.id.wordFragment
        }
        else if(select==2){
            setFragment(TAG_WORD, CalendarFragment())
            binding.navigationView.selectedItemId = R.id.calenderFragment
        }

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.wordFragment-> setFragment(TAG_WORD, WordFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val calender = manager.findFragmentByTag(TAG_CALENDER)
        val home = manager.findFragmentByTag(TAG_HOME)
        val word = manager.findFragmentByTag(TAG_WORD)

        if (calender != null){
            fragTransaction.hide(calender)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (word != null) {
            fragTransaction.hide(word)
        }
        if (tag == TAG_CALENDER) {
            if (calender!=null){
                fragTransaction.show(calender)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_WORD){
            if (word != null){
                fragTransaction.show(word)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}