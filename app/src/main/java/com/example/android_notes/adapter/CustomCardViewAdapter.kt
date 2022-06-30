package com.example.android_notes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_notes.R
import com.example.android_notes.activity.CardViewActivity
import kotlinx.android.synthetic.main.custom_listview.view.*

class Cv_Data(val profile: Int, val name: String)

class CustomCardViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val profile = v.iv_custom
    val name = v.tv_custom
}

class CustomCardViewAdapter(val context: Context) : RecyclerView.Adapter<CustomCardViewHolder>() {
    val DataList = arrayListOf(
        Cv_Data(R.drawable.android_icon, "1번"),
        Cv_Data(R.drawable.android_icon, "2번"),
        Cv_Data(R.drawable.android_icon, "3번"),
        Cv_Data(R.drawable.android_icon, "4번"),
        Cv_Data(R.drawable.android_icon, "5번"),
        Cv_Data(R.drawable.android_icon, "6번"),
        Cv_Data(R.drawable.android_icon, "7번"),
        Cv_Data(R.drawable.android_icon, "8번"),
        Cv_Data(R.drawable.android_icon, "9번"),
        Cv_Data(R.drawable.android_icon, "10번"),
        Cv_Data(R.drawable.android_icon, "11번"),
        Cv_Data(R.drawable.android_icon, "12번"),
        Cv_Data(R.drawable.android_icon, "13번"),
        Cv_Data(R.drawable.android_icon, "14번"),
        Cv_Data(R.drawable.android_icon, "15번"),
        Cv_Data(R.drawable.android_icon, "16번")
    )

    // 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomCardViewHolder {
        val cellForRow = LayoutInflater.from(context).inflate(
            R.layout.custom_listview, parent, false)
        return CustomCardViewHolder(cellForRow)

    }

    // 사이즈
    override fun getItemCount() = DataList.size

    // 수정
    override fun onBindViewHolder(holder: CustomCardViewHolder, position: Int) {
        val curData = DataList[position]
        holder.profile.setImageResource(curData.profile)
        holder.name.text = curData.name

        holder.itemView.setOnClickListener{
            (context as CardViewActivity).recyclerClick(curData)
        }
    }
}