package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_more_button.*

class MoreButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_button)
/*
        // 체크박스
        // checked이면 b가 true, 아니면 false
        checkBox.setOnCheckedChangeListener { compoundButton, b ->
            println("b: $b")
            Toast.makeText(this,"$b",Toast.LENGTH_SHORT).show()
        }

        // checkbox 기본값 설정 -> true이면 최초 실행 시 checkbox가 check 되어 있음
        checkBox.isChecked = true
 */


    }
}