package com.example.android_notes.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_share_sheet.*

class ShareSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_sheet)

        shareBtn.setOnClickListener {
            val intent = Intent() // Intent = 데이터를 전달하는 역할
            intent.action = Intent.ACTION_SEND // action_send = ShareSheet 나오게 하는 메서드
            intent.type = "text/plain" // 텍스트 콘텐츠 보내는 것
            intent.putExtra(Intent.EXTRA_SUBJECT, title)
            intent.putExtra(Intent.EXTRA_TEXT, "내용") // 이메일이나 문자 전송 시 hint로 value(내용)가 찍힒
            startActivity(Intent.createChooser(intent, "공유")) // ShareSheet title
        }
    }
}