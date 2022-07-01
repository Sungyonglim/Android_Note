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
        // 라디오 그룹 -> 라디오 버튼
        // 중복 선택 안됨
        // i는 radioButton ID
        // 라디오 버튼이 바뀔때 마다 체크
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i) {
                R.id.radioButton -> println("1번")
                R.id.radioButton2 -> println("2번")
                R.id.radioButton3 -> println("3번")
            }
        }

        // 최초 실행 시 해당 아이디의 라디오버튼 체크되어 있음
        radioGroup.check(R.id.radioButton2)
        // 모든 라디오 버튼 체크 해제
        radioGroup.clearCheck()

        // 언제든지 체크 가능
        when(radioGroup.checkedRadioButtonId) {
            R.id.radioButton -> println("1번")
            R.id.radioButton2 -> println("2번")
            R.id.radioButton3 -> println("3번")
        }
 */

    }
}