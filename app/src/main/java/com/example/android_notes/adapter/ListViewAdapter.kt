package com.example.android_notes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.android_notes.R
import kotlinx.android.synthetic.main.custom_list_item.view.*

class ListViewAdapter(private val items: MutableList<ListViewItem>):BaseAdapter() {
    override fun getCount() = items.size

    override fun getItem(position: Int): ListViewItem = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convert = convertView
        if(convert == null)
            convert = LayoutInflater.from(parent?.context).inflate(
                R.layout.custom_list_item,parent, false)
        val item : ListViewItem = items[position]
        convert!!.image_title.setImageDrawable(item.icon)
        convert!!.text_title.text = item.title
        convert!!.text_sub_title.text = item.subTitle

        return convert
    }
}