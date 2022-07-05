package com.example.android_notes.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SharedPreferencesActivity :
    AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)

        // putBoolean, PutFloat, PutLong, PutInt 등 다 사용 가능
        pref.edit().putString("키", "값").apply() // 저장
        val value = pref.getString("키", "저장안됨") //불러오기
        println(value) // "값" 출력 -> 대신 저장할 시 키에 값이 없을 경우 "저장안됨" 출력
        pref.edit().remove("키").apply() // 키 제거
        pref.edit().clear().apply() // 전체 제거
    }
}