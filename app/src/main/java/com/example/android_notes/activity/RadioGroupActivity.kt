package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_radio_group.*

class RadioGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_group)

        // 라디오 그룹 안에 라디오 버튼 존재
        // 라디오 버튼은 중복 선택 불가
        // i -> 라디오버튼에 id 값
        // 라디오 버튼이 바뀔때 마다 체크
        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when(i) {
                R.id.radioBtn1 -> println("1")
                R.id.radioBtn2 -> println("2")
                R.id.radioBtn3 -> println("3")
            }
        }

        // 최초 실행 시 해당 아이디의 라디오버튼 체크되어 있음
        radioGroup.check(R.id.radioBtn1)

        // 모든 라디오 버튼 체크 해제
        radioGroup.clearCheck()


        // 언제든지 체크 가능
        when(radioGroup.checkedRadioButtonId) {
            R.id.radioBtn1 -> println("1번")
            R.id.radioBtn2 -> println("2번")
            R.id.radioBtn3 -> println("3번")
        }
    }
}