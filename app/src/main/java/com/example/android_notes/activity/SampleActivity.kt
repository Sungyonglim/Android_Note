package com.example.android_notes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.android_notes.R
import com.example.android_notes.databinding.ActivitySampleBinding


class SampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySampleBinding


    // 액티비티가 생성되었을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 설정 
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sample)

        binding.btn.setOnClickListener { startActivity(
            Intent(this@SampleActivity, com.example.android_notes.sampleSingleApp.MainActivity::class.java)
        ) }

    }


}

/** Layout **/
/*
    - LinearLayout => 수평, 수직으로 나열할 때 유용, 가중치 
    - RelativeLayout => 뷰끼리 관계를 설정할 때 유용, 겹칠 수 있음
    - ConstraintLayout => 위치를 강제로 고정시킬 때 유용
*/

