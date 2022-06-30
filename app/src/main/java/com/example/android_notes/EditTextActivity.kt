package com.example.android_notes

import android.app.ProgressDialog.show
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.opengl.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)


/*
        // 실시간 EditText Input Watcher
        et.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                println("입력끝 : $p0")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("입력전 : $p0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                println("입력후 : $p0")
            }

        })
*/
       /*
        // 사진 색상 입히기 -> PorterDuff.Mode.--- => 색상 합치기
        iv_basic.setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.ADD)
        */

        click(btn_1)
    }
/*
    // 갤러리에서 사진 가져오기
    fun loadImage(v: View) {
        Toast.makeText(this,"사진 선택", Toast.LENGTH_SHORT).show()
        startActivityForResult(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( data != null) {
            iv_basic.setImageURI(data?.data)//null이 아니면 safe call 뒤 실행
            Toast.makeText(this, "사진 변경 완료", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "사진 변경  취소", Toast.LENGTH_SHORT).show()
        }
    }*/

    fun click(v: View) {
        iv_1.visibility = View.INVISIBLE
        iv_2.visibility = View.INVISIBLE
        iv_3.visibility = View.INVISIBLE

        when(v) {
            btn_1 -> {
                iv_1.visibility = View.VISIBLE
                Toast.makeText(this, "Select: btn_1", Toast.LENGTH_SHORT).show()
            }
            btn_2 -> {
                iv_2.visibility = View.VISIBLE
                Toast.makeText(this, "Select: btn_2", Toast.LENGTH_SHORT).show()
            }
            btn_3 -> {
                iv_3.visibility = View.VISIBLE
                Toast.makeText(this, "Select: btn_3", Toast.LENGTH_SHORT).show()
            }
        }
    }

}