package com.example.android_notes.androidCourse

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_color_my_views.*

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
//            R.id.box_three_text -> v.setBackgroundColor(Color.BLUE)
//            R.id.box_four_text-> v.setBackgroundColor(Color.MAGENTA)
//            R.id.box_five_text -> v.setBackgroundColor(Color.BLUE)
            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> box_four_text.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)
            else -> v.setBackgroundColor(Color.LTGRAY)

            /* 이미지로 변경
            R.id.box_one_text -> v.setBackgroundResource(R.drawable.ic_baseline_home_24)
            R.id.box_two_text -> v.setBackgroundResource(R.drawable.ic_baseline_person_pin_24)
            R.id.box_three_text -> v.setBackgroundResource(R.drawable.ic_baseline_email_24)
            R.id.box_four_text -> v.setBackgroundResource(R.drawable.ic_baseline_send_24)
            R.id.box_five_text -> v.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
            */

        }
    }

    private fun setListeners() {
        val boxOneText =findViewById<TextView>(R.id.box_one_text)
        val boxTwoText =findViewById<TextView>(R.id.box_two_text)
        val boxThreeText =findViewById<TextView>(R.id.box_three_text)
        val boxFourText =findViewById<TextView>(R.id.box_four_text)
        val boxFiveText =findViewById<TextView>(R.id.box_five_text)
        val redButton = findViewById<Button>(R.id.red_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)
        val greenButton = findViewById<Button>(R.id.green_button)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val clickableViews: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, redButton, yellowButton, greenButton)

        for(item in clickableViews) {
            item.setOnClickListener{ makeColored(it)}
        }
    }
}