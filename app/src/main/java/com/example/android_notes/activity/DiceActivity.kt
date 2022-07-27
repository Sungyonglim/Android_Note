package com.example.android_notes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.android_notes.R

class DiceActivity : AppCompatActivity() {

    private lateinit var diceFirst: ImageView
    private lateinit var diceSecond: ImageView
    private lateinit var startBtn: Button
    private lateinit var clearBtn: Button
    private lateinit var aboutText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        // 주사위 아이디
        diceFirst = findViewById(R.id.dice_image)
        diceSecond = findViewById(R.id.dice_image2)

        // 버튼 아이디
        startBtn = findViewById(R.id.start_btn)
        clearBtn = findViewById(R.id.clear_btn)

        // 텍스트뷰 아이디
        aboutText = findViewById(R.id.about_text)

        onClick(startBtn)
        onClick(clearBtn)
        onClick(aboutText)



    }

    private fun onClick(v: View) {
        when(v.id) {
            R.id.start_btn -> startBtn.setOnClickListener {
                rollDice()
            }
            R.id.clear_btn -> clearBtn.setOnClickListener {
                diceFirst.setImageResource(R.drawable.empty_dice)
                diceSecond.setImageResource(R.drawable.empty_dice)
            }

            R.id.about_text -> aboutText.setOnClickListener {
                val intent = Intent(Intent(this, AboutMeActivity::class.java))
                startActivity(intent)
            }
        }
    }



    // 주사위 이미지 변경 메서드
    private fun rollDice() {
        diceFirst.setImageResource(getRandomDiceImage()) // getRandomDiceImage 에서 받아온 이미지 설정
        diceSecond.setImageResource(getRandomDiceImage())
    }

    // 랜덤 주사위 추출 메서드
    private fun getRandomDiceImage(): Int {

        return when((1..6).random()) { // 1 ~ 6 사이의 랜덤한 숫자에 따라 이미지 부여
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    }


}

