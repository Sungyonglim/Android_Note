package com.example.android_notes.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_notes.R

class RVAdapter(private val items: ArrayList<String>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.contest_rv_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder : RVAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position])

    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(item: String) {

        }
    }
}