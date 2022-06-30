package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_notes.R
import com.example.android_notes.adapter.CustomRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerViewAdapter( this)
    }
}