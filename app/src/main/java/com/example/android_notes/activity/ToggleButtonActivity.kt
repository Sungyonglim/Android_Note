package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_toggle_button.*

class ToggleButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_button)

        // b가 checked 이면 true 아니면 false
        toggleButton.setOnCheckedChangeListener { compoundButton, b ->
            println(b)
        }

        toggleButton.isChecked = true
    }
}