package com.example.klab2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klab2.databinding.FragmentHomeBinding
import com.google.firebase.database.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: EEMyDataAdapter
    private val data: ArrayList<EEMyData> = ArrayList()
    private val db = FirebaseDatabase.getInstance("https://emotion-3bf81-default-rtdb.firebaseio.com/")
    private var pointResult: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }
    companion object{
        var panda:Int = R.drawable.panda
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imageView.setImageResource(panda)

        db.getReference("users").child(LoginActivity.username).child("activity").child("예시1").setValue(1)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시2").setValue(1)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시3").setValue(1)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시4").setValue(1)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시5").setValue(1)

        val word = db.getReference("users").child(LoginActivity.username).child("word")

        word.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val count = snapshot.child("full").value.toString()
                var text = "안녕! 오늘 하루는 어땠어?"
                if(count=="1"){
                    text = snapshot.child("word1").value.toString()
                    binding.wordHear.text = text
                }
                else if(count=="2"){
                    val range = (1..2).random()
                    if(range==1){
                        text = snapshot.child("word1").value.toString()
                        binding.wordHear.text = text
                    }
                    else{
                        text = snapshot.child("word2").value.toString()
                        binding.wordHear.text = text
                    }
                }
                else if(count=="3"){
                    val range = (1..3).random()
                    if(range==1){
                        text = snapshot.child("word1").value.toString()
                        binding.wordHear.text = text
                    }
                    else if(range==2){
                        text = snapshot.child("word2").value.toString()
                        binding.wordHear.text = text
                    }
                    else
                    {
                        text = snapshot.child("word3").value.toString()
                        binding.wordHear.text = text
                    }
                }
                else if(count=="4"){
                    val range = (1..4).random()
                    if(range==1){
                        text = snapshot.child("word1").value.toString()
                        binding.wordHear.text = text
                    }
                    else if(range==2){
                        text = snapshot.child("word2").value.toString()
                        binding.wordHear.text = text
                    }
                    else if(range==3)
                    {
                        text = snapshot.child("word3").value.toString()
                        binding.wordHear.text = text
                    }
                    else
                    {
                        text = snapshot.child("word4").value.toString()
                        binding.wordHear.text = text
                    }
                }
                else if(count=="5"){
                    val range = (1..5).random()
                    if(range==1){
                        text = snapshot.child("word1").value.toString()
                        binding.wordHear.text = text
                    }
                    else if(range==2){
                        text = snapshot.child("word2").value.toString()
                        binding.wordHear.text = text
                    }
                    else if(range==3)
                    {
                        text = snapshot.child("word3").value.toString()
                        binding.wordHear.text = text
                    }
                    else if(range==4)
                    {
                        text = snapshot.child("word4").value.toString()
                        binding.wordHear.text = text
                    }
                    else{
                        text = snapshot.child("word5").value.toString()
                        binding.wordHear.text = text
                    }
                }
                else
                    binding.wordHear.text = text
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        binding.addActivity.setOnClickListener {
            var Intent = Intent(context, SelectAcitivity::class.java)
            startActivity(Intent)
        }

        binding.imageView5.setOnClickListener {
            var Intent = Intent(context, ThingsWantToHearActivity::class.java)
            startActivity(Intent)
        }

        val point = db.getReference("users").child(LoginActivity.username).child("total_point")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    pointResult = snapshot.value.toString().toInt()
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })

        val adb = db.getReference("users").child(LoginActivity.username).child("activity")
        adb.get().addOnSuccessListener {
            if(it.exists()){
                for(i in it.children)
                    adapter.addItem(EEMyData(i.key.toString()))
            }
        }

        initRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )
        adapter = EEMyDataAdapter(data)
        adapter.itemClickListener = object : EEMyDataAdapter.OnItemClickListener {
            override fun OnItemClick(data: EEMyData, position: Int) {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("액티비티").setMessage("액티비티를 완료하시겠습니까?")
                    .setPositiveButton("완료",
                        DialogInterface.OnClickListener { dialogInterface, i ->
                            adapter.removeItem(position)
                            db.getReference("users").child(LoginActivity.username).child("activity")
                                .child(data.act).removeValue()
                            Toast.makeText(requireContext(), "5포인트가 적립되었습니다.", Toast.LENGTH_SHORT).show()
                            val point2 = pointResult + 5
                            db.getReference("users").child(LoginActivity.username).child("total_point").setValue(point2)
                        })
                    .setNegativeButton("돌아가기",
                        DialogInterface.OnClickListener { dialogInterface, i ->

                        })

                builder.show()
            }
        }
        binding.recyclerview.adapter = adapter
    }

    fun updateImageResource(resourceId: Int) {
        binding.imageView.setImageResource(resourceId)
    }
}