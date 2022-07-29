package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.android_notes.R
import com.example.android_notes.adapter.ListViewAdapter
import com.example.android_notes.adapter.ListViewItem
import kotlinx.android.synthetic.main.activity_list_view2.*


class ListViewActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view2)

        var items = mutableListOf<ListViewItem>()

        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.dice_1)!!, "첫번째 다이스", "다이스 1번"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.dice_2)!!, "두번째 다이스", "다이스 2번"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.dice_3)!!, "세번째 다이스", "다이스 3번"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.dice_4)!!, "네번째 다이스", "다이스 4번"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.dice_5)!!, "다섯번째 다이스", "다이스 5번"))
        items.add(ListViewItem(ContextCompat.getDrawable(this, R.drawable.dice_6)!!, "여섯번째 다이스", "다이스 6번"))


        list_view.adapter = ListViewAdapter(items)
        list_view.setOnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as ListViewItem
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }
    }
}