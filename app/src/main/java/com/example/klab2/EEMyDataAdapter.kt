package com.example.klab2

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.klab2.databinding.EeWriteListBinding

class EEMyDataAdapter(val items:ArrayList<EEMyData>)
    :RecyclerView.Adapter<EEMyDataAdapter.ViewHolder>(){


    interface OnItemClickListener{
        fun OnItemClick(data: EEMyData, position: Int)
    }

    var itemClickListener:OnItemClickListener?=null

    inner class ViewHolder(val binding: EeWriteListBinding): RecyclerView.ViewHolder(binding.root){
        init {

            if(MainActivity.season == "forest") {
                binding.back.setBackgroundResource(R.drawable.back_round)
                binding.Act.backgroundTintList =
                    ColorStateList.valueOf((Color.parseColor("#04B486")))
                binding.ActBut.backgroundTintList =
                    ColorStateList.valueOf((Color.parseColor("#04B486")))
            }
            else if(MainActivity.season == "autumn"){
                binding.back.setBackgroundResource(R.drawable.back_round_autumn)
                binding.ActBut.backgroundTintList =
                    ColorStateList.valueOf((Color.parseColor("#c35817")))
            }
            else if(MainActivity.season == "summer"){
                binding.back.setBackgroundResource(R.drawable.back_round_beach)
                binding.ActBut.backgroundTintList =
                    ColorStateList.valueOf((Color.parseColor("#2e5984")))
            }
            else if(MainActivity.season == "spring"){
                binding.back.setBackgroundResource(R.drawable.back_round_spring)
                binding.ActBut.backgroundTintList =
                    ColorStateList.valueOf((Color.parseColor("#fff06292")))
            }
            else if(MainActivity.season == "winter"){
                binding.back.setBackgroundResource(R.drawable.back_round_winter)
                binding.ActBut.backgroundTintList =
                    ColorStateList.valueOf((Color.parseColor("#1e3f66")))
            }

            binding.ActBut.setOnClickListener {
                itemClickListener?.OnItemClick(items[adapterPosition],adapterPosition)
            }
        }
    }

    fun addItem(a:EEMyData){
        items.add((a))
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        if(position>-1){
            items.removeAt(position)
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EEMyDataAdapter.ViewHolder {
        val view = EeWriteListBinding.inflate(
        LayoutInflater.from(parent.context),
        parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: EEMyDataAdapter.ViewHolder, position: Int) {
        holder.binding.Act.text = items[position].act
    }

    override fun getItemCount(): Int {
        return items.size
    }


}
