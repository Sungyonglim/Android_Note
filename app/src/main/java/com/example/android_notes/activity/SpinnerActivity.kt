package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_spinner.*

class SpinnerActivity : AppCompatActivity() {

    // spinner에 추가할 데이터
    var items = arrayOf("1번째","2번째","3번째","4번째","5번째","6번째","7번째","8번째","9번째","10번째")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        var myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        mySpinner.adapter = myAdapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            // 아무것도 선택되지 않을 경우 호출되는 메서드
            override fun onNothingSelected(p0: AdapterView<*>?) {
                println("아무것도 선택안함")
            }

            // 선택될 경우 호출되는 메서드
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                println("index -> $p2")
                println(items[p2])
            }
        }
    }
}