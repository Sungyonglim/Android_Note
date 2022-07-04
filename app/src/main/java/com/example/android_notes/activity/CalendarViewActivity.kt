package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_calendar_view.*
import java.util.*

class CalendarViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_view)

        // Calendar View 선택 시 TextView가 선택된 날짜로 변경
        calendarView.setOnDateChangeListener { calendarView, year, month, day ->
            var ct = "$year/$month/$day"
            println(ct) // month는 인덱스 번호가 0부터 시작 => 1월은 0, 2월은 1 .... 12월은 11
            calendarText.text = ct
        }

        // 지정한 날짜로 calendar View에 표시
        val calendar = Calendar.getInstance()
        calendar.set(2022,6,5)
        calendarView.date = calendar.timeInMillis // 1970년 기준

        // 현재 날짜 출력
        /*
        val calendar = Calendar.getInstance()
        println(calendar[Calendar.YEAR])
        println(calendar[Calendar.MONTH]) // month는 인덱스 번호가 0부터 시작 => 1월은 0, 2월은 1 .... 12월은 11
        println(calendar[Calendar.DAY_OF_MONTH])
        */


    }
}