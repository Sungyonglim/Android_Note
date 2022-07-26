package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_dice.*

class DiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        iv_dice.setImageResource(R.drawable.ic_dice_bg)

        onClick(result_btn)
        onClick(clear_btn)

    }

    private fun randomValue(): Int {
        return (1..6).random()
    }

    private fun onClick(v: View) {
        when(v.id) {
            R.id.result_btn -> result_btn.setOnClickListener {

                when(randomValue()) {
                    1 -> {
                        iv_dice.setImageResource(R.drawable.ic_dice_one)
                        tv_text.text = "1"
                    }
                    2 -> {
                        iv_dice.setImageResource(R.drawable.ic_dice_two)
                        tv_text.text = "2"
                    }
                    3 -> {
                        iv_dice.setImageResource(R.drawable.ic_dice_three)
                        tv_text.text = "3"
                    }
                    4 -> {
                        iv_dice.setImageResource(R.drawable.ic_dice_four)
                        tv_text.text = "4"
                    }
                    5 -> {
                        iv_dice.setImageResource(R.drawable.ic_dice_five)
                        tv_text.text = "5"
                    }
                    6 -> {
                        iv_dice.setImageResource(R.drawable.ic_dice_six)
                        tv_text.text = "6"
                    }
                }
            }
            R.id.clear_btn -> clear_btn.setOnClickListener {
                tv_text.text = "0"
                iv_dice.setImageResource(R.drawable.ic_dice_bg)
            }
        }
    }

}