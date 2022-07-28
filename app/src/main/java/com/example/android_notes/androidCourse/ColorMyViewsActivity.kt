package com.example.android_notes.androidCourse

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.android_notes.R

class ColorMyViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_my_views)

        setListeners()
    }

    // 해당 요소 변경 메서드
    private fun makeColored(v: View) {
        when(v.id) {
            // 색상 변경
            R.id.box_one_text -> v.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> v.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> v.setBackgroundColor(Color.BLUE)
            R.id.box_four_text-> v.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> v.setBackgroundColor(Color.BLUE)
            else -> v.setBackgroundColor(Color.LTGRAY)

        }
    }

    private fun setListeners() {
        val boxOneText =findViewById<TextView>(R.id.box_one_text)
        val boxTwoText =findViewById<TextView>(R.id.box_two_text)
        val boxThreeText =findViewById<TextView>(R.id.box_three_text)
        val boxFourText =findViewById<TextView>(R.id.box_four_text)
        val boxFiveText =findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText)

        for(item in clickableViews) {
            item.setOnClickListener{ makeColored(it)}
        }
    }
}