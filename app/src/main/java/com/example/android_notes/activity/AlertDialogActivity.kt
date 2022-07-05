package com.example.android_notes.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_alert_dialog.*

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        dialogBtn.setOnClickListener {
            val ad = AlertDialog.Builder(this)  // button 클릭 시 dialog 창 띄움
            ad.setIcon(R.mipmap.ic_launcher) // 아이콘
            ad.setTitle("Title") //제목
            ad.setMessage("Content") // 내영
            // View 나머지도 사용 가능
            // 여러개 사용 기능
            ad.setView(EditText(this))// view 추가 -> EditText
//            ad.setView(TimePicker(this)) // view 추가 -> TimePicker

            // 긍정, 부정 버튼 둘다 text만 다를 뿐 같은 원리
            // 긍정적인 버튼
            /* 기본형태
            ad.setPositiveButton("Yes", object:DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    println("Click Yes")
                    p0?.dismiss()
                }
            })*/

            // 람다식 변환 위와 동일한 기능
            ad.setPositiveButton("Yes") {p0, p1 ->
                println("Click Yes")
                p0?.dismiss()
            }
            
            // 부정적인 버튼
            /*  기본형태
            ad.setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }
            })*/

            // 람다식 변환 위와 동일한 기능
            ad.setNegativeButton("No") { p0, p1 ->
                println("Click No")
                p0?.dismiss()
            }

            ad.show()
        }

    }
}