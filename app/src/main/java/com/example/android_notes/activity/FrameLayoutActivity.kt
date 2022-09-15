package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_frame_layout.*

class FrameLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout)

        btn1.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.frameLayout, OneFragment()).commit() }
        btn2.setOnClickListener { supportFragmentManager.beginTransaction().replace(R.id.frameLayout, TwoFragment()).commit() }
    }
}

// Fragment를 View로 활용
class OneFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    // inflater.inflate로 하면 fragment를 View 형식으로 변환
    = inflater.inflate(R.layout.frag1, container, false)
}

class TwoFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    = inflater.inflate(R.layout.frag2, container, false)
}