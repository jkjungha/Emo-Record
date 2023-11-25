package com.example.klab2

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
