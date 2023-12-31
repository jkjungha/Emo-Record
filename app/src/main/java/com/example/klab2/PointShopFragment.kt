package com.example.klab2

import android.annotation.SuppressLint
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
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
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
import org.w3c.dom.Text


class PointShopFragment : Fragment() {
    private var _binding: FragmentPointShopBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPointShopBinding.inflate(inflater, container, false)
        if (MainActivity.season == "forest") {
            binding.backg.setBackgroundResource(R.drawable.bg_forest)
        } else if (MainActivity.season == "autumn") {
            binding.backg.setBackgroundResource(R.drawable.bg_autumn)
        } else if (MainActivity.season == "summer") {
            binding.backg.setBackgroundResource(R.drawable.bg_beach)
        } else if (MainActivity.season == "spring") {
            binding.backg.setBackgroundResource(R.drawable.bg_spring)
        } else if (MainActivity.season == "winter") {
            binding.backg.setBackgroundResource(R.drawable.bg_winter)
        }

        init()
        imageCheck()
        super.onCreate(savedInstanceState)

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SuspiciousIndentation")
    fun init() {
        val database = Firebase.database
        var db = database.reference
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var get_items =
                    dataSnapshot.child("users").child(LoginActivity.username).child("get_items")
                for (child in get_items.children) {
                    var key = child.key
                    var value = child.child("bought").getValue(Int::class.java)
                    if (key == "exciting_bgm") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.excitingBgmImg.setColorFilter(filter)
                            binding.excitingBgmImg.isEnabled = false
                        }
                    } else if (key == "sea_bgm") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.seaBgmImg.setColorFilter(filter)
                            binding.seaBgmImg.isEnabled = false
                        }
                    } else if (key == "soft_bgm") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.softBgmImg.setColorFilter(filter)
                            binding.softBgmImg.isEnabled = false
                        }
                    } else if (key == "crown_set") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.crownSetImg.setColorFilter(filter)
                            binding.crownSetImg.isEnabled = false
                        }
                    } else if (key == "hanbok_set") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.hanbokSetImg.setColorFilter(filter)
                            binding.hanbokSetImg.isEnabled = false
                        }
                    } else if (key == "swim_set") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.swimSetImg.setColorFilter(filter)
                            binding.swimSetImg.isEnabled = false
                        }
                    } else if (key == "spring_theme") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.springThemeImg.setColorFilter(filter)
                            binding.springThemeImg.isEnabled = false
                        }
                    } else if (key == "summer_theme") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.summerThemeImg.setColorFilter(filter)
                            binding.summerThemeImg.isEnabled = false
                        }
                    } else if (key == "autumn_theme") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.autumnThemeImg.setColorFilter(filter)
                            binding.autumnThemeImg.isEnabled = false
                        }
                    } else if (key == "winter_theme") {
                        if (value == 1) {
                            val matrix = ColorMatrix()
                            matrix.setSaturation(0f)
                            val filter = ColorMatrixColorFilter(matrix)
                            binding.winterThemeImg.setColorFilter(filter)
                            binding.winterThemeImg.isEnabled = false
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
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

                binding.totalPoint.text =
                    "Total Point : " + dataSnapshot.child("users").child(user).child("total_point")
                        .getValue(Int::class.java).toString() + " points"
                binding.excitingBgmImg.setOnClickListener {
                    if (binding.excitingBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items/exciting_bgm")
                            .getValue(Int::class.java)
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.excitingBgmImg.setColorFilter(filter)
                                    binding.excitingBgmImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/exciting_bgm/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.seaBgmImg.setOnClickListener {
                    if (binding.seaBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items/sea_bgm")
                            .getValue(Int::class.java)
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.seaBgmImg.setColorFilter(filter)
                                    binding.seaBgmImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/sea_bgm/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.softBgmImg.setOnClickListener {
                    if (binding.softBgmImg.isEnabled) {
                        var point = dataSnapshot.child("items/soft_bgm")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.softBgmImg.setColorFilter(filter)
                                    binding.softBgmImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/soft_bgm/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.crownSetImg.setOnClickListener {
                    if (binding.crownSetImg.isEnabled) {
                        var point = dataSnapshot.child("items/crown_set")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.crownSetImg.setColorFilter(filter)
                                    binding.crownSetImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/crown_set/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.hanbokSetImg.setOnClickListener {
                    if (binding.hanbokSetImg.isEnabled) {
                        var point = dataSnapshot.child("items/hanbok_set")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.hanbokSetImg.setColorFilter(filter)
                                    binding.hanbokSetImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/hanbok_set/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.swimSetImg.setOnClickListener {
                    if (binding.swimSetImg.isEnabled) {
                        var point = dataSnapshot.child("items/swim_set")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.swimSetImg.setColorFilter(filter)
                                    binding.swimSetImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/swim_set/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.springThemeImg.setOnClickListener {
                    if (binding.springThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items/spring_theme")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.springThemeImg.setColorFilter(filter)
                                    binding.springThemeImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/spring_theme/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.summerThemeImg.setOnClickListener {
                    if (binding.summerThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items/summer_theme")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.summerThemeImg.setColorFilter(filter)
                                    binding.summerThemeImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/summer_theme/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
                binding.autumnThemeImg.setOnClickListener {
                    if (binding.autumnThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items/autumn_theme")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.autumnThemeImg.setColorFilter(filter)
                                    binding.autumnThemeImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/autumn_theme/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }

                }
                binding.winterThemeImg.setOnClickListener {
                    if (binding.winterThemeImg.isEnabled) {
                        var point = dataSnapshot.child("items/winter_theme")
                            .getValue(Int::class.java)
                        Log.d("POINT SHOP POINT", point.toString())
                        var total_point =
                            dataSnapshot.child("users").child(user).child("total_point")
                                .getValue(Int::class.java)
                        Log.d("POINT SHOP TOTAL POINT", total_point.toString())

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("Purchase").setMessage("Would you like to purchase the item?")
                            .setPositiveButton("Ok") { _, _ ->
                                if (total_point!! >= point!!) {
                                    total_point -= point
                                    db.child("users").child(user!!).child("total_point")
                                        .setValue(total_point)
                                    Log.d("POINT SHOP ADD", total_point.toString())
                                    val matrix = ColorMatrix()
                                    matrix.setSaturation(0f)
                                    val filter = ColorMatrixColorFilter(matrix)
                                    binding.winterThemeImg.setColorFilter(filter)
                                    binding.winterThemeImg.isEnabled = false
                                    db.child("users").child(user!!)
                                        .child("get_items/winter_theme/bought").setValue(1)
                                    Toast.makeText(requireContext(), "Purchase completed", Toast.LENGTH_SHORT)
                                        .show()
                                } else {
                                    Toast.makeText(requireContext(), "Unable to purchase", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                            .setNegativeButton("Cancel") { _, _ ->

                            }

                        builder.show()
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

}