package com.example.android_notes.recyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_notes.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val rv: RecyclerView = findViewById(R.id.rv)

        val item = ArrayList<String>()
        item.add("a")
        item.add("b")
        item.add("c")
        item.add("d")
        item.add("e")
        item.add("f")
        val content = RVAdapter(item)

        rv.adapter = content

        rv.layoutManager = GridLayoutManager(this, 3)
    }
}