package com.example.android_notes.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_vibrate.*

class VibrateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibrate)

        // BUTTON 클릭 시 vibration 메서드 실행 인수로는 1000L(1초)
        vibrateBtn.setOnClickListener { vibration(1000L) }
    }

    fun vibration(len: Long) {
        // VIBRATOR_SERVICE 를 사용하기 위해서 AndroidManifest 에 android.permission.VIBRATE을 추가해야함
        var vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(len)
    }
}