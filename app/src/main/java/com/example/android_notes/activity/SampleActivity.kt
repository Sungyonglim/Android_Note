package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.android_notes.R
import com.example.android_notes.adapter.ListViewAdapter
import com.example.android_notes.adapter.ListViewItem
import kotlinx.android.synthetic.main.activity_list_view2.*
import kotlinx.android.synthetic.main.activity_sample.*


class SampleActivity : AppCompatActivity() {


    // 액티비티가 생성되었을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 설정 
        setContentView(R.layout.activity_sample)

    }


}

/** Layout **/
/*
    - LinearLayout => 수평, 수직으로 나열할 때 유용, 가중치 
    - RelativeLayout => 뷰끼리 관계를 설정할 때 유용, 겹칠 수 있음
    - ConstraintLayout => 위치를 강제로 고정시킬 때 유용
*/

