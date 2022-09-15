package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_notes.Data
import com.example.android_notes.R
import com.example.android_notes.adapter.CustomCardViewAdapter
import com.example.android_notes.adapter.CustomRecyclerViewAdapter
import com.example.android_notes.adapter.Cv_Data
import kotlinx.android.synthetic.main.activity_card_view.*
import kotlinx.android.synthetic.main.activity_recycler_view2.*

class CardViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view)


        cardView.layoutManager = LinearLayoutManager(this)
        cardView.adapter = CustomCardViewAdapter( this)
    }

    fun recyclerClick(curData: Cv_Data) {
        Toast.makeText(this, curData.name, Toast.LENGTH_SHORT).show()
    }
}