package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R

class ListViewActivity : AppCompatActivity() {

/*
    // ListView 데이터 생성
    val dataList = arrayListOf(
        Data(R.drawable.android_icon, "0번"),
        Data(R.drawable.android_icon, "1번"),
        Data(R.drawable.android_icon, "2번"),
        Data(R.drawable.android_icon, "3번")
    )
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

/*      // ListView, Adapter 데이터 전송 및 Toast msg 띄우기
        listView.adapter = CustomAdapter(this, dataList)


        listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as Data
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }
*/


    /*
        //listView item 채우기
        val items = arrayOf("0번","1번","2번","3번","4번","5번","6번","7번","8번","9번","10번","11번","12번","13번","14번","15번")
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        listView.onItemClickListener = AdapterView.OnItemClickListener{parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position)
            Toast.makeText(this, selectItem.toString(), Toast.LENGTH_SHORT).show()
        }

*/
    }
}