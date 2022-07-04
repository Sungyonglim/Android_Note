package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_sample.*
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timer

class ProgressBarActivity : AppCompatActivity() {

    var timer : Timer? = null
    var timer2 : TimerTask? = null
    var deltaTime = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)

        startBtn.setOnClickListener { timeFun() }
        stopBtn.setOnClickListener { timer?.cancel() } // timer가 전역변수이기 때문에 사용 가능

        // Delay
        Timer().schedule(2000) { println("2초 Delay")} // 2초후 실행
        Handler().postDelayed({ println("5초 Delay")}, 5000) //5초후 실행

        // Delay 무한반복
        Timer().schedule(2000,100) { println("2초후 0.1초마다 무한반복")} // Timer.schedule는 무한반복 가능
        // Handler는 무한반복 불가능

        // Timer, Handler UI 변경
        Timer().schedule(2000) { runOnUiThread{ startBtn.text = "2초" }} // runOnUiThread 사용해서 변경
        Handler().postDelayed({startBtn.text = "5초"}, 5000) // Handler는 바로 사용가능
    }

    fun timeFun() {
        // period => 반복하는 시간 100이면 0.1초마다 진행
        // initialDelay => 시작 시간을 지연 시작 -> 2000이면 2초 후 시작

        timer = timer(period = 100, initialDelay = 2000) {
            if(deltaTime > 100) cancel() // delatime이 100보다 크면 종료
            progressBar.progress = ++deltaTime // 진행상황 저장
            println(progressBar.progress)

            // runOnUiThread
            // timer처럼 반복되는 곳에 UI를 변경할때 사용
            // UI들이 안전하게 작동하도록 해줌
            runOnUiThread{
                startBtn.text = "시작됨"
            }
        }
    }

    // 동작은 timeFun과 일치
    fun timeFun2() {
        timer2 = Timer().schedule(1000,100) {
            if(deltaTime > 100) cancel()
            progressBar.progress = ++deltaTime
        }
    }
}