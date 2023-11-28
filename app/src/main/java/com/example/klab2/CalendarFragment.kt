package com.example.klab2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.util.*

class CalendarFragment : Fragment() {
    private lateinit var calendarView: CalendarView
    private lateinit var cha_Btn: Button
    private lateinit var del_Btn: Button
    private lateinit var diaryTextView: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var contextEditText: TextView
    private lateinit var imageVIEW: ImageView
    private lateinit var title: TextView
    private var onItemClickListener: AdapterView.OnItemClickListener? = null

    private val db = FirebaseDatabase.getInstance("https://emotion-3bf81-default-rtdb.firebaseio.com/")

    private var check: Int = 0
    private var str: String? = null
    private var str2: String? = null

    companion object{
        var year1 = 0
        var month1 = 0
        var day1 = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        calendarView = view.findViewById(R.id.calendarView)
        diaryTextView = view.findViewById(R.id.diaryTextView)
        del_Btn = view.findViewById(R.id.del_Btn)
        cha_Btn = view.findViewById(R.id.cha_Btn)
        textView2 = view.findViewById(R.id.textView2)
        textView3 = view.findViewById(R.id.textView3)
        title = view.findViewById(R.id.title)
        contextEditText = view.findViewById(R.id.contextEditText)
        imageVIEW = view.findViewById(R.id.emo)

        cha_Btn.visibility = View.INVISIBLE
        del_Btn.visibility = View.INVISIBLE
        imageVIEW.visibility = View.INVISIBLE
        contextEditText.visibility = View.INVISIBLE
        textView2.visibility = View.INVISIBLE
        title.visibility = View.INVISIBLE

        textView3.text = "Diary"

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            diaryTextView.text = String.format("%d / %d / %d", year, month + 1, dayOfMonth)
            contextEditText.setText("")

            check = 0
            val cal = Calendar.getInstance()
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, 1)
            val week = cal.get(Calendar.DAY_OF_WEEK)

            cha_Btn.visibility = View.INVISIBLE
            del_Btn.visibility = View.INVISIBLE
            imageVIEW.visibility = View.INVISIBLE
            contextEditText.visibility = View.INVISIBLE
            textView2.visibility = View.INVISIBLE
            title.visibility = View.INVISIBLE

            cha_Btn.setOnClickListener {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("수정").setMessage("일기를 수정하시겠습니까?")
                    .setPositiveButton("확인") { _, _ ->
                        CalendarFragment.year1 = year
                        CalendarFragment.month1 = month
                        CalendarFragment.day1 = dayOfMonth
                        var Intent = Intent(context, CheckEmojiActivity::class.java)
                        startActivity(Intent)
                    }
                    .setNegativeButton("취소") { _, _ ->

                    }

                builder.show()
            }

            del_Btn.setOnClickListener {
                check = 1
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("삭제").setMessage("일기를 삭제하시겠습니까?")
                    .setPositiveButton("확인") { _, _ ->
                        db.getReference("users").child(LoginActivity.username).child("calendar").child(year.toString())
                            .child((month + 1).toString()).child(dayOfMonth.toString())
                            .removeValue()
                    }
                    .setNegativeButton("취소") { _, _ ->

                    }

                builder.show()
            }

            val ff = db.getReference("users").child(LoginActivity.username).child("calender").child(year.toString())
                .child((month + 1).toString()).child(dayOfMonth.toString())
            ff.addValueEventListener(object : ValueEventListener {
                @SuppressLint("ResourceType")
                override fun onDataChange(snapshot: DataSnapshot) {
                    val ff = snapshot.child("dairy_title").value
                    if (ff == null && check == 0) {
                        cha_Btn.visibility = View.INVISIBLE
                        del_Btn.visibility = View.INVISIBLE
                        imageVIEW.visibility = View.INVISIBLE
                        contextEditText.visibility = View.INVISIBLE
                        textView2.visibility = View.INVISIBLE
                        title.visibility = View.INVISIBLE

                        val builder = AlertDialog.Builder(requireContext())
                        builder.setTitle("일기").setMessage("일기를 작성하시겠습니까?")
                            .setPositiveButton("확인",
                                DialogInterface.OnClickListener { _, _ ->
                                    activity?.let{
                                        CalendarFragment.year1 = year
                                        CalendarFragment.month1 = month
                                        CalendarFragment.day1 = dayOfMonth
                                        var Intent = Intent(context, CheckEmojiActivity::class.java)
                                        startActivity(Intent)
                                    }
                                })
                            .setNegativeButton("취소",
                                DialogInterface.OnClickListener { _, _ ->

                                })

                        builder.show()
                    } else {

                        if(snapshot.child("dairy_emotion").value.toString()=="1"){
                            imageVIEW.setImageResource(R.drawable.expression_1)
                            imageVIEW.setColorFilter(Color.parseColor("#6A0888"))
                        }
                        else if(snapshot.child("dairy_emotion").value.toString()=="2"){
                            imageVIEW.setImageResource(R.drawable.expression_2)
                            imageVIEW.setColorFilter(Color.parseColor("#0174DF"))
                        }
                        else if(snapshot.child("dairy_emotion").value.toString()=="3"){
                            imageVIEW.setImageResource(R.drawable.expression_3)
                            imageVIEW.setColorFilter(Color.parseColor("#31B404"))
                        }
                        else if(snapshot.child("dairy_emotion").value.toString()=="4"){
                            imageVIEW.setImageResource(R.drawable.expression_4)
                            imageVIEW.setColorFilter(Color.parseColor("#FFBF00"))
                        }
                        else if(snapshot.child("dairy_emotion").value.toString()=="5"){
                            imageVIEW.setImageResource(R.drawable.expression_5)
                            imageVIEW.setColorFilter(Color.parseColor("#DF0101"))
                        }
                        str = snapshot.child("dairy_content").value.toString()
                        str2 = snapshot.child("dairy_title").value.toString()
                        textView2.text = str
                        title.text = str2
                        cha_Btn.visibility = View.VISIBLE
                        del_Btn.visibility = View.VISIBLE
                        imageVIEW.visibility = View.VISIBLE
                        contextEditText.visibility = View.INVISIBLE
                        textView2.visibility = View.VISIBLE
                        title.visibility = View.VISIBLE
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error
                }
            })


        }

        return view
    }
}