package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_time_picker.*

class TimePickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        // hour와 minute를 가져올려면 minSdk 버전이 최소 23은 되야함 -> 사용하려면 minSdk 버전을 변경 후 사용
        timePicker.hour
        timePicker.minute

        // timePicker의 시간이 변경될 때 마다 호출되는 메서드
        // i = hour, i2 = minute
        timePicker.setOnTimeChangedListener { timePicker, i, i2 ->
            // i와 i2가 기본이 string이기 때문에 toString으로 형변환을 안시켜도됨
            // println(i.toString() + ":" + i2.toString()) //아래 코드와 동일
            println("$i : $i2")
        }
    }
}