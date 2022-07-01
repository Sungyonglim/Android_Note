package com.example.android_notes.activity

import android.media.session.MediaController
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_video_view.*

class VideoViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        // video 경로
        val videoPath = "android.resource://" + packageName + "/" + R.raw.test
        // videoView에 video 경로를 주면 해당 경로에 있는 video 실행됨
        // videoPath만 주고 실행하면 재생현황을 controller로 없음
        videoView.setVideoPath(videoPath)

        // MediaController -> 비디어 재생현황을 나타내는 바
        val mediaController = android.widget.MediaController(this)
        //videoView에 MediaController 달아줌
        videoView.setMediaController(mediaController)
//        mediaController.setAnchorView(videoView)
        // 비디오가 실행되는 동안 화면이 켜져있음
        videoView.keepScreenOn = true
    }
}