package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_notes.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_app_bar_layout.*

class AppBarLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bar_layout)

        // Floating Action Button 동작
        fab.setOnClickListener {
            Toast.makeText(this, "Select FAB", Toast.LENGTH_SHORT).show()
        }

        // tab 활용 
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            // tab이 선택될 시 실행되는 메서드
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position // 해당 tab에 인덱스 값 반환
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}