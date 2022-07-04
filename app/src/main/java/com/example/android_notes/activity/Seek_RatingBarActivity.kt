package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_seek_rating_bar.*

class Seek_RatingBarActivity :
    AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_rating_bar)

        // SeekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                println(p1) // 변경될때 마다 변경된  seekBar 값 출력
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                println("Start SeekBar") // 시작될때 호출되는 메서드
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                println("Stop SeekBar") // 종료될 때 호출되는 메서드
            }
        })

        // RatingBar
        ratingBar.setOnRatingBarChangeListener { ratingBar, fl, b ->
            println(fl) // 레이팅바가 변경될때 호출되는 메서드 -> 값 나옴
        }

        // ratingBar 초기값 설정 -> xml에서도 가능
        ratingBar.rating = 2.5f
    }
}