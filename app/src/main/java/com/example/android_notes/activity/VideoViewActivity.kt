package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_video_view.*

class VideoViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_view)

        // 공개된 비디오의 주소를 통해 가져오는 방법
//        videoView.setVideoURI((Uri.parse("경로 입력"))

        // video를 경로를 통해 받아오는 방법
        val videoPath = "android.resource://" + packageName + "/"
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

        // 추가 가능
        videoView.start() // 비디오 시작
        videoView.pause() // 비디오 일시정지
        videoView.seekTo(10000) // 비디오 재생시간 앞으로 10초 이동
    }
}