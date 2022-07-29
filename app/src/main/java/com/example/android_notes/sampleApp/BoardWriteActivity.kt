package com.example.android_notes.sampleApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.android_notes.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BoardWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)

        val writeBtn = findViewById<Button>(R.id.writeUploadBtn)
        val writeText = findViewById<EditText>(R.id.writeTextArea)
        writeBtn.setOnClickListener {
            // Write a message to the database
            val database = Firebase.database
            val myRef = database.getReference("board")

             // myRef.setValue(writeText.text.toString()) // 계속 수정만 됨
            //myRef.push().setValue(writeText.text.toString()) // 계속 해서 입력한 데이터가 추가됨

            //data class 활용
            myRef.push().setValue(
                Model(writeText.text.toString())
            )
        }
    }
}