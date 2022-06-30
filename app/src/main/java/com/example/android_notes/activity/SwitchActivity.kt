package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_switch.*

class SwitchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch)
/*
        // switch Change Event
        switch1.setOnCheckedChangeListener { compoundButton, b ->
            println(b)
        }*/

/*
        // switch  초기값 지정
        switch1.isChecked  = true
*/
    }
}