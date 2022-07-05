package com.example.android_notes.activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_notification.*
import java.nio.file.attribute.AclEntry

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        
        notificationBtn.setOnClickListener { showNotification("제목", "내용") }
    }

    private fun showNotification(title: String, context: String) {
        // pending은 데이터를 전달할 때 필요한 것
        val pending = PendingIntent.getActivity(this, 0, Intent(this, SampleActivity::class.java), PendingIntent.FLAG_CANCEL_CURRENT)
        // builder는 알림을 설정할 수 있는 것
        val builder = NotificationCompat.Builder(this, "id")
        builder.setSmallIcon(R.drawable.ic_launcher_foreground) // 알림에 작은 아이콘 출력
            .setContentTitle(title)
            .setContentText(context)
            .setContentIntent(pending)
            .setAutoCancel(true) // 알림 클릭 시 알림 지워짐
            // DEFAULT_SOUND 는 알림이 올 경우 소리가 나는 것, DEFAULT_VIBRATE는 진동
            .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE)

        // getSystemService로 알림 서비스를 가져옴
        val nManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // 스마트폰 마다 버전이 다르기 때문에 해당 스마트폰 버전(Build.VERSION.SDK_INT)이
        // 시스템 버전(Build.VERSION_CODES.O)보다 높으면 채널을 만들어줌
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 채널 만드는 메서드
            nManager.createNotificationChannel(
                //IMPORTANCE_HIGH = 중요성이 높음, lOW = 낮음, DEFAULT = 평범
                NotificationChannel("id", "name",NotificationManager.IMPORTANCE_HIGH)
            )

            // 알림이 발동됨
            nManager.notify(0,builder.build())
        }
    }
}