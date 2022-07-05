package com.example.android_notes.activity

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_network_check.*

class NetworkCheckActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_check)

        netBtn.setOnClickListener { networkCheck(netBtn) }
    }

    // WIFI 및 Network 연결 체크 메서드
    private fun networkCheck(v: View) {

        // CONNECTIVITY_SERVICE 를 ConnectivityManager로 가지고옴
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // AndroidManifest에서 INTERNET과 ACCESS_NETWORK_STATE를 허용해줘야함
        println(connectivityManager.activeNetworkInfo?.isConnected)
    }
}