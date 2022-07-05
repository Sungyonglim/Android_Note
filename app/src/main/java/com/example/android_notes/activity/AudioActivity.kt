package com.example.android_notes.activity

import android.content.Context
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_audio.*

class AudioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)

        audioBtn.setOnClickListener { v: View ->
            audio(v)
        }
    }

    private fun audio(v: View) {
        var audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        // 해당하는 오디오 볼륨 조절을 불러옴
        audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL)
        audioManager.getStreamVolume(AudioManager.STREAM_RING)
        audioManager.getStreamVolume(AudioManager.STREAM_ALARM)

        // AudioManager Attribute => ADJUST
        audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_MUTE, 0)
        audioManager.adjustStreamVolume(AudioManager.STREAM_VOICE_CALL, AudioManager.ADJUST_UNMUTE, 0)
        audioManager.adjustStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_RAISE, 0)
        audioManager.adjustStreamVolume(AudioManager.STREAM_ALARM, AudioManager.ADJUST_LOWER, 0)

    }
}