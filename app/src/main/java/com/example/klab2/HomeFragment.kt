package com.example.klab2

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.klab2.databinding.FragmentHomeBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db.getReference("users").child(LoginActivity.username).child("activity").child("예시1").setValue(1)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시2").setValue(2)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시3").setValue(3)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시4").setValue(4)
        db.getReference("users").child(LoginActivity.username).child("activity").child("예시5").setValue(5)

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


        // 나머지 Firebase 데이터 로딩 및 설정 등의 코드는 이곳에 추가할 수 있습니다.
    }
}