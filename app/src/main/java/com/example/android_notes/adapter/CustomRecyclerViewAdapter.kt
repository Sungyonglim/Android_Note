package com.example.android_notes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android_notes.Data
import com.example.android_notes.R
import kotlinx.android.synthetic.main.custom_listview.view.*

class Data(val profile: Int, val name: String)

class CustomViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val profile = v.iv_custom
    val name = v.tv_custom
}

class CustomRecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<CustomViewHolder>() {
    val DataList = arrayListOf(
        Data(R.drawable.android_icon, "1번"),
        Data(R.drawable.android_icon, "2번"),
        Data(R.drawable.android_icon, "3번"),
        Data(R.drawable.android_icon, "4번"),
        Data(R.drawable.android_icon, "5번"),
        Data(R.drawable.android_icon, "6번"),
        Data(R.drawable.android_icon, "7번"),
        Data(R.drawable.android_icon, "8번"),
        Data(R.drawable.android_icon, "9번"),
        Data(R.drawable.android_icon, "10번"),
        Data(R.drawable.android_icon, "11번"),
        Data(R.drawable.android_icon, "12번"),
        Data(R.drawable.android_icon, "13번"),
        Data(R.drawable.android_icon, "14번"),
        Data(R.drawable.android_icon, "15번"),
        Data(R.drawable.android_icon, "16번"),
        Data(R.drawable.android_icon, "17번"),
    )

    // 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val cellForRow = LayoutInflater.from(context).inflate(
            R.layout.custom_listview, parent, false)
        return CustomViewHolder(cellForRow)

    }

    // 사이즈
    override fun getItemCount() = DataList.size

    // 수정
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val curData = DataList[position]
        holder.profile.setImageResource(curData.profile)
        holder.name.text = curData.name

        holder.itemView.setOnClickListener{
            Toast.makeText(context, curData.name, Toast.LENGTH_SHORT).show()
        }
    }
}