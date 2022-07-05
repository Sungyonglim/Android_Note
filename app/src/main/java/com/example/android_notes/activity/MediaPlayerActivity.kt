package com.example.android_notes.activity

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_media_player.*

class MediaPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        startMediaBtn.setOnClickListener { clickMediaPlayer(startMediaBtn) }
    }

    private fun clickMediaPlayer(v: View) {
/*
        val mediaPlayer = MediaPlayer.create(this, R.raw.national_anthem)

        mediaPlayer.start() // 음악 재생
        // mediaPlayer.stop() // 음악 중지

        // setOnCompletionListener는 음악이 재생되면 메모리에 올라가는데 음악이 종료되면 메모리에서 빼내게 하기 위함
        // release 를 해야 겹치지 않음
        mediaPlayer.setOnCompletionListener { mediaPlayer.release() }

        */
    }
}