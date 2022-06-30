package com.example.android_notes

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Data(val profile: Int, val name: String)

class CustomAdapter(val context: Context, val DataList: ArrayList<Data>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.custom_listview, null)

        val profile = view.findViewById<ImageView>(R.id.iv_custom)
        val name = view.findViewById<TextView>(R.id.tv_custom)
        val data = DataList[position]

        profile.setImageResource(data.profile)
        name.text = data.name

        return view
    }

    override fun getCount() = DataList.size

    override fun getItem(position: Int) = DataList[position]

    override fun getItemId(position: Int) = 0L

}