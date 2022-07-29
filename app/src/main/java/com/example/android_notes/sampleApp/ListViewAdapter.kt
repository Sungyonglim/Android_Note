package com.example.android_notes.sampleApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.android_notes.R
import kotlinx.android.synthetic.main.listview_item.view.*

class ListViewAdapter(private val List: MutableList<Model>):BaseAdapter() {
    override fun getCount() : Int =  List.count()

    override fun getItem(position: Int): Model = List[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView

        if(view == null)
           view =  LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)

        // 첫번째 방법
//        val title: Model = List[position]
//        view!!.itemTextId.text = title.title

        // 두번째 방법
        val title = view?.findViewById<TextView>(R.id.itemTextId)
        title!!.text = List[position].title
        return view!!
    }
}