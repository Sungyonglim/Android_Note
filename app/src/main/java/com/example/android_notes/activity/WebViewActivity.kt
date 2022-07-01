package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    // 마지막 누른 시간 변수
    var lastTimeBackPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        //ImageView 이미지 변경
        imageView.setOnClickListener {
            imageView.setImageResource(R.drawable.ic_baseline_person_pin_24)
        }


        // WebViewClient -> 새로운 창을 방지
        webView.webViewClient = WebViewClient()

        //naver 같은 url은 모바일에서 동작하기 때문에 www가 아닌 m으로 시작
        webView.loadUrl("https://m.naver.com")

        // 초기 WebView
        load(googleBtn)


    }

    // WebView에서 뒤로가면 애뮬레이터 꺼지는 현상 방지
    override fun onBackPressed() {
        // webview 뒤로 간다면 뒤로감
        if(webView.canGoBack()) webView.goBack()
        else {
            // currentTimeMillis -> 현재 시간을 Long 형식으로 변환
            // 1500 -> 1.5초 / 1000이 1초
            // 1.5초 보다 빠르게 누르면
            if(System.currentTimeMillis() - lastTimeBackPressed < 1500) {
                finish()
                return
            }

            // 1.5초 보다 느리게 누를 시 실행
            // 현재시간을 대입
            lastTimeBackPressed = System.currentTimeMillis()
            Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }

    // Button 클릭 시 해당 url WebView 띄우기
    fun load(v: View) {
        when (v.id) {
            R.id.googleBtn -> webView.loadUrl("https://www.google.com")
            R.id.naverBtn -> webView.loadUrl("https://m.naver.com")
        }
    }
}