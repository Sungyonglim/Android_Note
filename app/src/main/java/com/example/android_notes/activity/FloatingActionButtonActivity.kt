package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_notes.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_floating_action_button.*

class FloatingActionButtonActivity :
    AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_action_button)

        // 기본 snackBar 사용
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "SnackBar", Snackbar.LENGTH_SHORT).show()
//        }

        // 스낵바 클릭 Action
        fab.setOnClickListener { view ->
            Snackbar.make(view, "할말", Snackbar.LENGTH_SHORT).setAction("클릭") {
                Toast.makeText(this, "SnackBar Click", Toast.LENGTH_SHORT).show()
            }.show()
        }
    }
}