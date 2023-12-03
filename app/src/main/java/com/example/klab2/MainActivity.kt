package com.example.klab2

import android.content.Intent
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.klab2.databinding.ActivityMainAutumnBinding
import com.example.klab2.databinding.ActivityMainBeachBinding
import com.example.klab2.databinding.ActivityMainBinding
import com.example.klab2.databinding.ActivityMainSpringBinding
import com.example.klab2.databinding.ActivityMainWinterBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.*

private const val TAG_CALENDER = "calendar_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_POINTSHOP = "pointshop_fragment"
private const val TAG_SETTING = "setting_fragment"
private const val TAG_WORD = "word_fragment"
private const val TAG_ADD= "add_fragment"
private const val TAG_EDIT= "edit_fragment"

class MainActivity : AppCompatActivity() {
    companion object{
        var layout:Int = R.layout.activity_main
        var select = 0
        var season = ""
    }

    private val db = FirebaseDatabase.getInstance("https://emotion-3bf81-default-rtdb.firebaseio.com/")

    private lateinit var binding : ActivityMainBinding
    private lateinit var binding2: ActivityMainSpringBinding
    private lateinit var binding3: ActivityMainAutumnBinding
    private lateinit var binding4: ActivityMainBeachBinding
    private lateinit var binding5: ActivityMainWinterBinding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.change_password ->{
                //showLoading()

                val intent = Intent(this, ChangePasswordActivity::class.java)
                startActivity(intent)

                //hideLoading()
            }

            R.id.change_profile -> {
                //showLoading()

                val intent = Intent(this, ChangeProfileActivity::class.java)
                startActivity(intent)

                //hideLoading()
            }
            R.id.change_theme -> {
                val intent = Intent(this, ChangeThemeActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val a = db.getReference("users").child(LoginActivity.username)
            .child("get_items").child("spring_theme").child("chose").get()
            .addOnSuccessListener {
                var value = it.value
                if(value.toString().toInt()==1){
                    season = "spring"
                    if(season=="spring"){
                        binding2 = ActivityMainSpringBinding.inflate(layoutInflater)
                        setContentView(binding2.root)
                        season = "spring"

                        supportActionBar?.setBackgroundDrawable(
                            ColorDrawable(
                                ContextCompat.getColor(
                                    this@MainActivity,
                                    R.color.spring_bar
                                )
                            )
                        )
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.spring_bar)
                        }

                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
                        Log.d("GOT YOU", "MAIN")

                        if(select==0)
                            setFragment(TAG_HOME, HomeFragment())
                        else if(select==1 || PointShopFragment.ch==1){
                            setFragment(TAG_POINTSHOP, PointShopFragment())
                            binding2.navigationView.selectedItemId = R.id.pointshopFragment
                        }
                        else if(select==2){
                            setFragment(TAG_POINTSHOP, CalendarFragment())
                            binding2.navigationView.selectedItemId = R.id.calenderFragment
                        }

                        binding2.navigationView.setOnItemSelectedListener { item ->
                            when(item.itemId) {
                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
                            }
                            true
                        }
                    }
                }

            }

        val b = db.getReference("users").child(LoginActivity.username)
            .child("get_items").child("summer_theme").child("chose").get()
            .addOnSuccessListener {
                var value = it.value
                if(value.toString().toInt()==1) {
                    Log.i("들어옴1","1")
                    season = "summer"
                    if(season=="summer"){
                        Log.i("들어옴2","2")
                        binding4 = ActivityMainBeachBinding.inflate(layoutInflater)
                        setContentView(binding4.root)
                        season = "summer"

                        supportActionBar?.setBackgroundDrawable(
                            ColorDrawable(
                                ContextCompat.getColor(
                                    this@MainActivity,
                                    R.color.summer_bar
                                )
                            )
                        )
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.summer_bar )
                        }

                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
                        Log.d("GOT YOU", "MAIN")
                        if(select==0){
                            setFragment(TAG_HOME, HomeFragment())
                        }
                        else if(select==1){
                            setFragment(TAG_POINTSHOP, PointShopFragment())
                            binding4.navigationView.selectedItemId = R.id.pointshopFragment
                        }
                        else if(select==2){
                            setFragment(TAG_CALENDER, CalendarFragment())
                            binding4.navigationView.selectedItemId = R.id.calenderFragment
                        }

                        binding4.navigationView.setOnItemSelectedListener { item ->
                            when (item.itemId) {
                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                                R.id.pointshopFragment -> setFragment(TAG_POINTSHOP, PointShopFragment())
                            }
                            true
                        }
                        Log.i("들어옴3","3")
                    }
                }
            }

        val c = db.getReference("users").child(LoginActivity.username)
            .child("get_items").child("autumn_theme").child("chose").get()
            .addOnSuccessListener {
                var value = it.value
                if(value.toString().toInt()==1) {
                    season = "autumn"
                    if(season=="autumn"){
                        binding3 = ActivityMainAutumnBinding.inflate(layoutInflater)
                        setContentView(binding3.root)
                        season = "autumn"

                        supportActionBar?.setBackgroundDrawable(
                            ColorDrawable(
                                ContextCompat.getColor(
                                    this@MainActivity,
                                    R.color.autumn_bar
                                )
                            )
                        )
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.autumn_bar  )
                        }

                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
                        Log.d("GOT YOU", "MAIN")

                        if(select==0)
                            setFragment(TAG_HOME, HomeFragment())
                        else if(select==1){
                            setFragment(TAG_POINTSHOP, PointShopFragment())
                            binding3.navigationView.selectedItemId = R.id.pointshopFragment
                        }
                        else if(select==2){
                            setFragment(TAG_POINTSHOP, CalendarFragment())
                            binding3.navigationView.selectedItemId = R.id.calenderFragment
                        }

                        binding3.navigationView.setOnItemSelectedListener { item ->
                            when(item.itemId) {
                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
                            }
                            true
                        }
                    }
                }
            }

        val d = db.getReference("users").child(LoginActivity.username)
            .child("get_items").child("winter_theme").child("chose").get()
            .addOnSuccessListener {
                var value = it.value
                if(value.toString().toInt()==1) {
                    season = "winter"
                    if(season=="winter"){
                        binding5 = ActivityMainWinterBinding.inflate(layoutInflater)
                        setContentView(binding5.root)
                        season = "winter"

                        supportActionBar?.setBackgroundDrawable(
                            ColorDrawable(
                                ContextCompat.getColor(
                                    this@MainActivity,
                                    R.color.winter_bar
                                )
                            )
                        )
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.winter_bar  )
                        }

                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
                        Log.d("GOT YOU", "MAIN")

                        if(select==0)
                            setFragment(TAG_HOME, HomeFragment())
                        else if(select==1){
                            setFragment(TAG_POINTSHOP, PointShopFragment())
                            binding5.navigationView.selectedItemId = R.id.pointshopFragment
                        }
                        else if(select==2){
                            setFragment(TAG_POINTSHOP, CalendarFragment())
                            binding5.navigationView.selectedItemId = R.id.calenderFragment
                        }

                        binding5.navigationView.setOnItemSelectedListener { item ->
                            when(item.itemId) {
                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
                            }
                            true
                        }
                    }
                }
            }

        val e = db.getReference("users").child(LoginActivity.username)
            .child("get_items").child("forest_theme").child("chose").get()
            .addOnSuccessListener {
                var value = it.value
                if(value.toString().toInt()==1) {
                    season = "forest"
                    if(season=="forest"){
                        binding = ActivityMainBinding.inflate(layoutInflater)
                        setContentView(binding.root)
                        season = "forest"

                        supportActionBar?.setBackgroundDrawable(
                            ColorDrawable(
                                ContextCompat.getColor(
                                    this@MainActivity,
                                    R.color.forest_bar
                                )
                            )
                        )
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.forest_bar  )
                        }

                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
                        Log.d("GOT YOU", "MAIN")

                        if(select==0)
                            setFragment(TAG_HOME, HomeFragment())
                        else if(select==1){
                            setFragment(TAG_POINTSHOP, PointShopFragment())
                            binding.navigationView.selectedItemId = R.id.pointshopFragment
                        }
                        else if(select==2){
                            setFragment(TAG_POINTSHOP, CalendarFragment())
                            binding.navigationView.selectedItemId = R.id.calenderFragment
                        }

                        binding.navigationView.setOnItemSelectedListener { item ->
                            when (item.itemId) {
                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                                R.id.pointshopFragment -> setFragment(TAG_POINTSHOP, PointShopFragment())
                            }
                            true
                        }
                    }
                }
            }

//        val theme = db.getReference("users").child(LoginActivity.username)
//            .child("get_items").addValueEventListener(object: ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    if(snapshot.child("spring_theme").child("chose").value.toString() == "1"){
//                        binding2 = ActivityMainSpringBinding.inflate(layoutInflater)
//                        setContentView(binding2.root)
//                        season = "spring"
//
//                        supportActionBar?.setBackgroundDrawable(
//                            ColorDrawable(
//                                ContextCompat.getColor(
//                                    this@MainActivity,
//                                    R.color.spring_bar
//                                )
//                            )
//                        )
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.spring_bar)
//                        }
//
//                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
//                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
//                        Log.d("GOT YOU", "MAIN")
//
//                        if(select==0)
//                            setFragment(TAG_HOME, HomeFragment())
//                        else if(select==1 || PointShopFragment.ch==1){
//                            setFragment(TAG_POINTSHOP, PointShopFragment())
//                            binding2.navigationView.selectedItemId = R.id.pointshopFragment
//                        }
//                        else if(select==2){
//                            setFragment(TAG_POINTSHOP, CalendarFragment())
//                            binding2.navigationView.selectedItemId = R.id.calenderFragment
//                        }
//
//                        binding2.navigationView.setOnItemSelectedListener { item ->
//                            when(item.itemId) {
//                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
//                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
//                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
//                            }
//                            true
//                        }
//                    }
//                    if(snapshot.child("summer_theme").child("chose").value.toString() == "1"){
//                        binding4 = ActivityMainBeachBinding.inflate(layoutInflater)
//                        setContentView(binding4.root)
//                        season = "summer"
//
//                        supportActionBar?.setBackgroundDrawable(
//                            ColorDrawable(
//                                ContextCompat.getColor(
//                                    this@MainActivity,
//                                    R.color.summer_bar
//                                )
//                            )
//                        )
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.summer_bar )
//                        }
//
//                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
//                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
//                        Log.d("GOT YOU", "MAIN")
//                        if(select==0){
//                            setFragment(TAG_HOME, HomeFragment())
//                        }
//                        else if(select==1){
//                            setFragment(TAG_POINTSHOP, PointShopFragment())
//                            binding4.navigationView.selectedItemId = R.id.pointshopFragment
//                        }
//                        else if(select==2){
//                            setFragment(TAG_CALENDER, CalendarFragment())
//                            binding4.navigationView.selectedItemId = R.id.calenderFragment
//                        }
//
//                        binding4.navigationView.setOnItemSelectedListener { item ->
//                            when(item.itemId) {
//                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
//                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
//                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
//                            }
//                            true
//                        }
//                    }
//                    if(snapshot.child("autumn_theme").child("chose").value.toString() == "1"){
//                        binding3 = ActivityMainAutumnBinding.inflate(layoutInflater)
//                        setContentView(binding3.root)
//                        season = "autumn"
//
//                        supportActionBar?.setBackgroundDrawable(
//                            ColorDrawable(
//                                ContextCompat.getColor(
//                                    this@MainActivity,
//                                    R.color.autumn_bar
//                                )
//                            )
//                        )
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.autumn_bar  )
//                        }
//
//                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
//                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
//                        Log.d("GOT YOU", "MAIN")
//
//                        if(select==0)
//                            setFragment(TAG_HOME, HomeFragment())
//                        else if(select==1){
//                            setFragment(TAG_POINTSHOP, PointShopFragment())
//                            binding3.navigationView.selectedItemId = R.id.pointshopFragment
//                        }
//                        else if(select==2){
//                            setFragment(TAG_POINTSHOP, CalendarFragment())
//                            binding3.navigationView.selectedItemId = R.id.calenderFragment
//                        }
//
//                        binding3.navigationView.setOnItemSelectedListener { item ->
//                            when(item.itemId) {
//                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
//                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
//                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
//                            }
//                            true
//                        }
//                    }
//                    if(snapshot.child("winter_theme").child("chose").value.toString() == "1"){
//                        binding5 = ActivityMainWinterBinding.inflate(layoutInflater)
//                        setContentView(binding5.root)
//                        season = "winter"
//
//                        supportActionBar?.setBackgroundDrawable(
//                            ColorDrawable(
//                                ContextCompat.getColor(
//                                    this@MainActivity,
//                                    R.color.winter_bar
//                                )
//                            )
//                        )
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.winter_bar  )
//                        }
//
//                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
//                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
//                        Log.d("GOT YOU", "MAIN")
//
//                        if(select==0)
//                            setFragment(TAG_HOME, HomeFragment())
//                        else if(select==1){
//                            setFragment(TAG_POINTSHOP, PointShopFragment())
//                            binding5.navigationView.selectedItemId = R.id.pointshopFragment
//                        }
//                        else if(select==2){
//                            setFragment(TAG_POINTSHOP, CalendarFragment())
//                            binding5.navigationView.selectedItemId = R.id.calenderFragment
//                        }
//
//                        binding5.navigationView.setOnItemSelectedListener { item ->
//                            when(item.itemId) {
//                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
//                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
//                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
//                            }
//                            true
//                        }
//                    }
//                    if(snapshot.child("forest_theme").child("chose").value.toString() == "1"){
//                        binding = ActivityMainBinding.inflate(layoutInflater)
//                        setContentView(binding.root)
//                        season = "forest"
//
//                        supportActionBar?.setBackgroundDrawable(
//                            ColorDrawable(
//                                ContextCompat.getColor(
//                                    this@MainActivity,
//                                    R.color.forest_bar
//                                )
//                            )
//                        )
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.forest_bar  )
//                        }
//
//                        val bottomNavigationViewZ:BottomNavigationView = findViewById(R.id.navigationView)
//                        bottomNavigationViewZ.selectedItemId = R.id.homeFragment
//                        Log.d("GOT YOU", "MAIN")
//
//                        if(select==0)
//                            setFragment(TAG_HOME, HomeFragment())
//                        else if(select==1){
//                            setFragment(TAG_POINTSHOP, PointShopFragment())
//                            binding.navigationView.selectedItemId = R.id.pointshopFragment
//                        }
//                        else if(select==2){
//                            setFragment(TAG_POINTSHOP, CalendarFragment())
//                            binding.navigationView.selectedItemId = R.id.calenderFragment
//                        }
//
//                        binding.navigationView.setOnItemSelectedListener { item ->
//                            when(item.itemId) {
//                                R.id.calenderFragment -> setFragment(TAG_CALENDER, CalendarFragment())
//                                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
//                                R.id.pointshopFragment-> setFragment(TAG_POINTSHOP, PointShopFragment())
//                            }
//                            true
//                        }
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                }
//
//            })

    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val calender = manager.findFragmentByTag(TAG_CALENDER)
        val home = manager.findFragmentByTag(TAG_HOME)
        val pointshop = manager.findFragmentByTag(TAG_POINTSHOP)

        if (calender != null){
            fragTransaction.hide(calender)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (pointshop != null) {
            fragTransaction.hide(pointshop)
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

        else if (tag == TAG_POINTSHOP){
            if (pointshop != null){
                fragTransaction.show(pointshop)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}