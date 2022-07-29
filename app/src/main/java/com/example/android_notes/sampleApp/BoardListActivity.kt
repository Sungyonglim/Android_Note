package com.example.android_notes.sampleApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.android_notes.R
import com.example.android_notes.databinding.ActivityBoardListBinding
import kotlinx.android.synthetic.main.activity_board_list.*

class BoardListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_list)

        val writeBtn = findViewById<Button>(R.id.writeBtn)

        writeBtn.setOnClickListener {
            startActivity(Intent(this, BoardWriteActivity::class.java))
        }

    }
}