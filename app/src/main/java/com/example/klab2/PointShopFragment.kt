package com.example.klab2

import android.app.AlertDialog
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.klab2.databinding.FragmentPointShopAutumnBinding
import com.example.klab2.databinding.FragmentPointShopBeachBinding
import com.example.klab2.databinding.FragmentPointShopBinding
import com.example.klab2.databinding.FragmentPointShopSpringBinding
import com.example.klab2.databinding.FragmentPointShopWinterBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class PointShopFragment : Fragment() {
    private var _binding: FragmentPointShopBinding? = null
    private val binding get() = _binding!!

    private var _binding2: FragmentPointShopAutumnBinding? = null
    private val binding2 get() = _binding2!!

    private var _binding3: FragmentPointShopBeachBinding? = null
    private val binding3 get() = _binding3!!

    private var _binding4: FragmentPointShopSpringBinding? = null
    private val binding4 get() = _binding4!!

    private var _binding5: FragmentPointShopWinterBinding? = null
    private val binding5 get() = _binding5!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fun a(): LinearLayout {
            if(MainActivity.season == "forest"){
                _binding = FragmentPointShopBinding.inflate(inflater, container, false)
                init()
                imageCheck()
                return binding.root
            }
            else if(MainActivity.season == "autumn"){
                _binding2 = FragmentPointShopAutumnBinding.inflate(inflater, container, false)
                init()
                imageCheck()
                return binding2.root
            }
            else if(MainActivity.season == "summer"){
                _binding3 = FragmentPointShopBeachBinding.inflate(inflater, container, false)
                init()
                imageCheck()
                return binding3.root
            }
            else if(MainActivity.season == "spring"){
                _binding4 = FragmentPointShopSpringBinding.inflate(inflater, container, false)
                init()
                imageCheck()
                return binding4.root
            }
            else if(MainActivity.season == "winter"){
                _binding5 = FragmentPointShopWinterBinding.inflate(inflater, container, false)
                init()
                imageCheck()
                return binding5.root
            }
            return binding4.root
        }

        super.onCreate(savedInstanceState)

        return a()

    }


    fun init() {
        val database = Firebase.database
        var db = database.reference
        if(MainActivity.season == "forest"){
            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var get_items = dataSnapshot.child("users").child(LoginActivity.username).child("get_items")
                    for(child in get_items.children){
                        var key = child.key
                        var value = child.child("bought").getValue(Int::class.java)
                        if(key == "exciting_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.excitingBgmImg.setColorFilter(filter)
                                binding.excitingBgmImg.isEnabled = false
                            }
                        }else if(key == "sea_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.seaBgmImg.setColorFilter(filter)
                                binding.seaBgmImg.isEnabled = false
                            }
                        }else if(key == "soft_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.softBgmImg.setColorFilter(filter)
                                binding.softBgmImg.isEnabled = false
                            }
                        }else if(key == "crown_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.crownSetImg.setColorFilter(filter)
                                binding.crownSetImg.isEnabled = false
                            }
                        }else if(key == "hanbok_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.hanbokSetImg.setColorFilter(filter)
                                binding.hanbokSetImg.isEnabled = false
                            }
                        }else if(key == "swim_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.swimSetImg.setColorFilter(filter)
                                binding.swimSetImg.isEnabled = false
                            }
                        }else if(key == "spring_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.springThemeImg.setColorFilter(filter)
                                binding.springThemeImg.isEnabled = false
                            }
                        }else if(key == "summer_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.summerThemeImg.setColorFilter(filter)
                                binding.summerThemeImg.isEnabled = false
                            }
                        }else if(key == "autumn_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding.autumnThemeImg.setColorFilter(filter)
                                binding.autumnThemeImg.isEnabled = false
                            }
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })
        }
        else if(MainActivity.season == "autumn"){
            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var get_items = dataSnapshot.child("users").child(LoginActivity.username).child("get_items")
                    for(child in get_items.children){
                        var key = child.key
                        var value = child.child("bought").getValue(Int::class.java)
                        if(key == "exciting_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.excitingBgmImg.setColorFilter(filter)
                                binding2.excitingBgmImg.isEnabled = false
                            }
                        }else if(key == "sea_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.seaBgmImg.setColorFilter(filter)
                                binding2.seaBgmImg.isEnabled = false
                            }
                        }else if(key == "soft_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.softBgmImg.setColorFilter(filter)
                                binding2.softBgmImg.isEnabled = false
                            }
                        }else if(key == "crown_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.crownSetImg.setColorFilter(filter)
                                binding2.crownSetImg.isEnabled = false
                            }
                        }else if(key == "hanbok_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.hanbokSetImg.setColorFilter(filter)
                                binding2.hanbokSetImg.isEnabled = false
                            }
                        }else if(key == "swim_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.swimSetImg.setColorFilter(filter)
                                binding2.swimSetImg.isEnabled = false
                            }
                        }else if(key == "spring_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.springThemeImg.setColorFilter(filter)
                                binding2.springThemeImg.isEnabled = false
                            }
                        }else if(key == "summer_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.summerThemeImg.setColorFilter(filter)
                                binding2.summerThemeImg.isEnabled = false
                            }
                        }else if(key == "autumn_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding2.autumnThemeImg.setColorFilter(filter)
                                binding2.autumnThemeImg.isEnabled = false
                            }
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })


        }
        else if(MainActivity.season == "summer")
        {
            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var get_items = dataSnapshot.child("users").child(LoginActivity.username).child("get_items")
                    for(child in get_items.children){
                        var key = child.key
                        var value = child.child("bought").getValue(Int::class.java)
                        if(key == "exciting_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.excitingBgmImg.setColorFilter(filter)
                                binding3.excitingBgmImg.isEnabled = false
                            }
                        }else if(key == "sea_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.seaBgmImg.setColorFilter(filter)
                                binding3.seaBgmImg.isEnabled = false
                            }
                        }else if(key == "soft_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.softBgmImg.setColorFilter(filter)
                                binding3.softBgmImg.isEnabled = false
                            }
                        }else if(key == "crown_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.crownSetImg.setColorFilter(filter)
                                binding3.crownSetImg.isEnabled = false
                            }
                        }else if(key == "hanbok_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.hanbokSetImg.setColorFilter(filter)
                                binding3.hanbokSetImg.isEnabled = false
                            }
                        }else if(key == "swim_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.swimSetImg.setColorFilter(filter)
                                binding3.swimSetImg.isEnabled = false
                            }
                        }else if(key == "spring_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.springThemeImg.setColorFilter(filter)
                                binding3.springThemeImg.isEnabled = false
                            }
                        }else if(key == "summer_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.summerThemeImg.setColorFilter(filter)
                                binding3.summerThemeImg.isEnabled = false
                            }
                        }else if(key == "autumn_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding3.autumnThemeImg.setColorFilter(filter)
                                binding3.autumnThemeImg.isEnabled = false
                            }
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })


        }
        else if(MainActivity.season == "spring")
        {
            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var get_items = dataSnapshot.child("users").child(LoginActivity.username).child("get_items")
                    for(child in get_items.children){
                        var key = child.key
                        var value = child.child("bought").getValue(Int::class.java)
                        if(key == "exciting_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.excitingBgmImg.setColorFilter(filter)
                                binding4.excitingBgmImg.isEnabled = false
                            }
                        }else if(key == "sea_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.seaBgmImg.setColorFilter(filter)
                                binding4.seaBgmImg.isEnabled = false
                            }
                        }else if(key == "soft_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.softBgmImg.setColorFilter(filter)
                                binding4.softBgmImg.isEnabled = false
                            }
                        }else if(key == "crown_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.crownSetImg.setColorFilter(filter)
                                binding4.crownSetImg.isEnabled = false
                            }
                        }else if(key == "hanbok_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.hanbokSetImg.setColorFilter(filter)
                                binding4.hanbokSetImg.isEnabled = false
                            }
                        }else if(key == "swim_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.swimSetImg.setColorFilter(filter)
                                binding4.swimSetImg.isEnabled = false
                            }
                        }else if(key == "spring_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.springThemeImg.setColorFilter(filter)
                                binding4.springThemeImg.isEnabled = false
                            }
                        }else if(key == "summer_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.summerThemeImg.setColorFilter(filter)
                                binding4.summerThemeImg.isEnabled = false
                            }
                        }else if(key == "autumn_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding4.autumnThemeImg.setColorFilter(filter)
                                binding4.autumnThemeImg.isEnabled = false
                            }
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })


        }
        else if(MainActivity.season == "winter")
        {
            db.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var get_items = dataSnapshot.child("users").child(LoginActivity.username).child("get_items")
                    for(child in get_items.children){
                        var key = child.key
                        var value = child.child("bought").getValue(Int::class.java)
                        if(key == "exciting_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.excitingBgmImg.setColorFilter(filter)
                                binding5.excitingBgmImg.isEnabled = false
                            }
                        }else if(key == "sea_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.seaBgmImg.setColorFilter(filter)
                                binding5.seaBgmImg.isEnabled = false
                            }
                        }else if(key == "soft_bgm"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.softBgmImg.setColorFilter(filter)
                                binding5.softBgmImg.isEnabled = false
                            }
                        }else if(key == "crown_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.crownSetImg.setColorFilter(filter)
                                binding5.crownSetImg.isEnabled = false
                            }
                        }else if(key == "hanbok_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.hanbokSetImg.setColorFilter(filter)
                                binding5.hanbokSetImg.isEnabled = false
                            }
                        }else if(key == "swim_set"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.swimSetImg.setColorFilter(filter)
                                binding5.swimSetImg.isEnabled = false
                            }
                        }else if(key == "spring_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.springThemeImg.setColorFilter(filter)
                                binding5.springThemeImg.isEnabled = false
                            }
                        }else if(key == "summer_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.summerThemeImg.setColorFilter(filter)
                                binding5.summerThemeImg.isEnabled = false
                            }
                        }else if(key == "autumn_theme"){
                            if(value == 1){
                                val matrix = ColorMatrix()
                                matrix.setSaturation(0f)
                                val filter = ColorMatrixColorFilter(matrix)
                                binding5.autumnThemeImg.setColorFilter(filter)
                                binding5.autumnThemeImg.isEnabled = false
                            }
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            })


        }

    }

    fun imageCheck() {


//        binding.backButton.setOnClickListener {
//            val intent = Intent(context, MainActivity::class.java);
//            startActivity(intent)
//        }

        var user = LoginActivity.username

        val database = Firebase.database
        var db = database.reference
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if(MainActivity.season == "forest" && binding!=null){
                    binding.totalPoint.text = "Total Point : "+dataSnapshot.child("users").child(user).child("total_point").getValue(Int::class.java).toString() + " points"
                    binding.excitingBgmImg.setOnClickListener {
                        if (binding.excitingBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/exciting_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.excitingBgmImg.setColorFilter(filter)
                                        binding.excitingBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/exciting_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(),  "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(),  "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.seaBgmImg.setOnClickListener {
                        if (binding.seaBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/sea_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.seaBgmImg.setColorFilter(filter)
                                        binding.seaBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/sea_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.softBgmImg.setOnClickListener {
                        if (binding.softBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/soft_bgm")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.softBgmImg.setColorFilter(filter)
                                        binding.softBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/soft_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.crownSetImg.setOnClickListener {
                        if (binding.crownSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/crown_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.crownSetImg.setColorFilter(filter)
                                        binding.crownSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/crown_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.hanbokSetImg.setOnClickListener {
                        if (binding.hanbokSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/hanbok_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.hanbokSetImg.setColorFilter(filter)
                                        binding.hanbokSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/hanbok_set/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.swimSetImg.setOnClickListener {
                        if (binding.swimSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/swim_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.swimSetImg.setColorFilter(filter)
                                        binding.swimSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/swim_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.springThemeImg.setOnClickListener {
                        if (binding.springThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/spring_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.springThemeImg.setColorFilter(filter)
                                        binding.springThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/spring_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.summerThemeImg.setOnClickListener {
                        if (binding.summerThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/summer_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.summerThemeImg.setColorFilter(filter)
                                        binding.summerThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/summer_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding.autumnThemeImg.setOnClickListener {
                        if (binding.autumnThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/autumn_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding.autumnThemeImg.setColorFilter(filter)
                                        binding.autumnThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/autumn_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                }
                else if(MainActivity.season == "autumn" && binding2!=null){
                    binding2.totalPoint.text = "Total Point : "+dataSnapshot.child("users").child(user).child("total_point").getValue(Int::class.java).toString() + " points"
                    binding2.excitingBgmImg.setOnClickListener {
                        if (binding2.excitingBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/exciting_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.excitingBgmImg.setColorFilter(filter)
                                        binding2.excitingBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/exciting_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(),  "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(),  "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.seaBgmImg.setOnClickListener {
                        if (binding2.seaBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/sea_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.seaBgmImg.setColorFilter(filter)
                                        binding2.seaBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/sea_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.softBgmImg.setOnClickListener {
                        if (binding2.softBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/soft_bgm")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.softBgmImg.setColorFilter(filter)
                                        binding2.softBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/soft_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.crownSetImg.setOnClickListener {
                        if (binding2.crownSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/crown_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.crownSetImg.setColorFilter(filter)
                                        binding2.crownSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/crown_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.hanbokSetImg.setOnClickListener {
                        if (binding2.hanbokSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/hanbok_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.hanbokSetImg.setColorFilter(filter)
                                        binding2.hanbokSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/hanbok_set/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.swimSetImg.setOnClickListener {
                        if (binding2.swimSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/swim_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.swimSetImg.setColorFilter(filter)
                                        binding2.swimSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/swim_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.springThemeImg.setOnClickListener {
                        if (binding2.springThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/spring_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.springThemeImg.setColorFilter(filter)
                                        binding2.springThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/spring_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.summerThemeImg.setOnClickListener {
                        if (binding2.summerThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/summer_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.summerThemeImg.setColorFilter(filter)
                                        binding2.summerThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/summer_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding2.autumnThemeImg.setOnClickListener {
                        if (binding2.autumnThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/autumn_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding2.autumnThemeImg.setColorFilter(filter)
                                        binding2.autumnThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/autumn_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                }
                else if(MainActivity.season == "summer" && binding3!=null){
                    binding3.totalPoint.text = "Total Point : "+dataSnapshot.child("users").child(user).child("total_point").getValue(Int::class.java).toString() + " points"
                    binding3.excitingBgmImg.setOnClickListener {
                        if (binding3.excitingBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/exciting_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.excitingBgmImg.setColorFilter(filter)
                                        binding3.excitingBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/exciting_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(),  "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(),  "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.seaBgmImg.setOnClickListener {
                        if (binding3.seaBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/sea_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.seaBgmImg.setColorFilter(filter)
                                        binding3.seaBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/sea_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.softBgmImg.setOnClickListener {
                        if (binding3.softBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/soft_bgm")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.softBgmImg.setColorFilter(filter)
                                        binding3.softBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/soft_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.crownSetImg.setOnClickListener {
                        if (binding3.crownSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/crown_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.crownSetImg.setColorFilter(filter)
                                        binding3.crownSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/crown_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.hanbokSetImg.setOnClickListener {
                        if (binding3.hanbokSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/hanbok_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.hanbokSetImg.setColorFilter(filter)
                                        binding3.hanbokSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/hanbok_set/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.swimSetImg.setOnClickListener {
                        if (binding3.swimSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/swim_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.swimSetImg.setColorFilter(filter)
                                        binding3.swimSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/swim_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.springThemeImg.setOnClickListener {
                        if (binding3.springThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/spring_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.springThemeImg.setColorFilter(filter)
                                        binding3.springThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/spring_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.summerThemeImg.setOnClickListener {
                        if (binding3.summerThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/summer_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.summerThemeImg.setColorFilter(filter)
                                        binding3.summerThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/summer_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding3.autumnThemeImg.setOnClickListener {
                        if (binding3.autumnThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/autumn_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding3.autumnThemeImg.setColorFilter(filter)
                                        binding3.autumnThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/autumn_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }


                }
                else if(MainActivity.season == "spring"&& binding4!=null){
                    binding4.totalPoint.text = "Total Point : "+dataSnapshot.child("users").child(user).child("total_point").getValue(Int::class.java).toString() + " points"
                    binding4.excitingBgmImg.setOnClickListener {
                        if (binding4.excitingBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/exciting_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.excitingBgmImg.setColorFilter(filter)
                                        binding4.excitingBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/exciting_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(),  "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(),  "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.seaBgmImg.setOnClickListener {
                        if (binding4.seaBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/sea_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.seaBgmImg.setColorFilter(filter)
                                        binding4.seaBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/sea_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.softBgmImg.setOnClickListener {
                        if (binding4.softBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/soft_bgm")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.softBgmImg.setColorFilter(filter)
                                        binding4.softBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/soft_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.crownSetImg.setOnClickListener {
                        if (binding4.crownSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/crown_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.crownSetImg.setColorFilter(filter)
                                        binding4.crownSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/crown_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.hanbokSetImg.setOnClickListener {
                        if (binding4.hanbokSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/hanbok_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.hanbokSetImg.setColorFilter(filter)
                                        binding4.hanbokSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/hanbok_set/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.swimSetImg.setOnClickListener {
                        if (binding4.swimSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/swim_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.swimSetImg.setColorFilter(filter)
                                        binding4.swimSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/swim_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.springThemeImg.setOnClickListener {
                        if (binding4.springThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/spring_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.springThemeImg.setColorFilter(filter)
                                        binding4.springThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/spring_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.summerThemeImg.setOnClickListener {
                        if (binding4.summerThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/summer_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.summerThemeImg.setColorFilter(filter)
                                        binding4.summerThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/summer_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding4.autumnThemeImg.setOnClickListener {
                        if (binding4.autumnThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/autumn_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding4.autumnThemeImg.setColorFilter(filter)
                                        binding4.autumnThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/autumn_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }


                }
                else if(MainActivity.season == "winter"&& binding5!=null)
                {
                    binding5.totalPoint.text = "Total Point : "+dataSnapshot.child("users").child(user).child("total_point").getValue(Int::class.java).toString() + " points"
                    binding5.excitingBgmImg.setOnClickListener {
                        if (binding5.excitingBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/exciting_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.excitingBgmImg.setColorFilter(filter)
                                        binding5.excitingBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/exciting_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(),  "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(),  "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.seaBgmImg.setOnClickListener {
                        if (binding5.seaBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/sea_bgm")
                                .getValue(Int::class.java)
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.seaBgmImg.setColorFilter(filter)
                                        binding5.seaBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/sea_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.softBgmImg.setOnClickListener {
                        if (binding5.softBgmImg.isEnabled) {
                            var point = dataSnapshot.child("items/soft_bgm")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.softBgmImg.setColorFilter(filter)
                                        binding5.softBgmImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/soft_bgm/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.crownSetImg.setOnClickListener {
                        if (binding5.crownSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/crown_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.crownSetImg.setColorFilter(filter)
                                        binding5.crownSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/crown_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.hanbokSetImg.setOnClickListener {
                        if (binding5.hanbokSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/hanbok_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.hanbokSetImg.setColorFilter(filter)
                                        binding5.hanbokSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/hanbok_set/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.swimSetImg.setOnClickListener {
                        if (binding5.swimSetImg.isEnabled) {
                            var point = dataSnapshot.child("items/swim_set")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.swimSetImg.setColorFilter(filter)
                                        binding5.swimSetImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/swim_set/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.springThemeImg.setOnClickListener {
                        if (binding5.springThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/spring_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.springThemeImg.setColorFilter(filter)
                                        binding5.springThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/spring_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(),"구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.summerThemeImg.setOnClickListener {
                        if (binding5.summerThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/summer_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.summerThemeImg.setColorFilter(filter)
                                        binding5.summerThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/summer_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }
                    binding5.autumnThemeImg.setOnClickListener {
                        if (binding5.autumnThemeImg.isEnabled) {
                            var point = dataSnapshot.child("items/autumn_theme")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP POINT", point.toString())
                            var total_point = dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                            Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                            val builder = AlertDialog.Builder(requireContext())
                            builder.setTitle("구매").setMessage("아이템을 구매하시겠습니까?")
                                .setPositiveButton("확인") { _, _ ->
                                    if (total_point!! >= point!!) {
                                        total_point -= point
                                        db.child("users").child(user!!).child("total_point").setValue(total_point)
                                        Log.d("POINT SHOP ADD", total_point.toString())
                                        val matrix = ColorMatrix()
                                        matrix.setSaturation(0f)
                                        val filter = ColorMatrixColorFilter(matrix)
                                        binding5.autumnThemeImg.setColorFilter(filter)
                                        binding5.autumnThemeImg.isEnabled = false
                                        db.child("users").child(user!!).child("get_items/autumn_theme/bought").setValue(1)
                                        Toast.makeText(requireContext(), "구매 완료", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(requireContext(), "구매할 수 없음", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                .setNegativeButton("취소") { _, _ ->

                                }

                            builder.show()
                        }
                    }


                }

            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }
}