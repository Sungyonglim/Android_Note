package com.example.android_notes.activity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R

// Sensor를 사용하기 위해서 SensorEventListener 사용
class SensorActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // 화면 바깥에서 돌아오면 실행되는 메서드
    override fun onResume() {
        // Sensor 서비스를 가져옴
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // getDefaultSensor = 센서 종류 선택
        // SENSOR_DELAY_NORMAL = 센서 딜레이 속도  -> 얼마나 정밀하게 가져올지 선택
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL)
        super.onResume()
    }

    // 화면 바깥으로 나갈때 실행되는 메서드
    override fun onPause() {
        // 화면 바깥으로 나가면 센서를 종료함 그래서 발열을 최소화함
        sensorManager.unregisterListener(this)
        super.onPause()
    }

    // 센서 값이 변경되면 호출되는 메서드
    // p0(event) = 센서의 값이 바뀔때 마다 값을 가져오는 매개변수
    override fun onSensorChanged(event: SensorEvent?) {
        val x = event?.values?.get(0) as Float
        val y = event?.values?.get(1) as Float
        val z = event?.values?.get(2) as Float

        println("x : $x, y : $y, z : $z")
    }

    // 센서의 정확도가 변경되었을 때 호출되는 메서드
    // p0 = 센서 종류,  p1 = 개수
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}