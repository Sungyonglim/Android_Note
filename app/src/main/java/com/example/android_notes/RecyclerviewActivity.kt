package com.example.android_notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_notes.adapter.CustomRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerViewAdapter(DataList, this)
    }
}