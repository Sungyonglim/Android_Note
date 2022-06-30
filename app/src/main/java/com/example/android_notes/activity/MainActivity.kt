package com.example.android_notes.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sub.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // move function
        iv_move.setOnClickListener{
            startActivity(Intent(this, CardViewActivity::class.java))
        }
        // 마지막 EditText(et_pw) 완료버튼은 Login 호출
        et_pw.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE){
                login(v)
                true
            } else false
        }

        //불러오기
        var pref = this.getPreferences(0)
        et_email.setText(pref.getString("이메일", ""))
        et_name.setText(pref.getString("이름", ""))
        et_age.setText(pref.getString("나이", ""))
        et_pw.setText(pref.getString("비밀번호", ""))
    }

    // Login Method
    fun login(v: View) {
        // 키보드 숨기기
        var imm =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)

        //입력 정보 비교
        if(et_email.text.toString() == "asd@asd.com" && et_name.text.toString() == "lim" && et_age.text.toString() == "26" && et_pw.text.toString() == "asdasd") {
            Toast.makeText(this,"${et_name.text.toString()} Login Success", Toast.LENGTH_SHORT).show()

            // 로그인 성공이면 SubActivity로 이동
            // 1. 화면전환 애니메이션 있음
//            startActivity(Intent(this,SubActivity::class.java))

            // 2. 화면전환 애니메이션 없음
            setContentView(R.layout.activity_sub)
            tv_result.text = "Welcome"

            // 저장
            var editor = this.getPreferences(0).edit()
            editor.putString("이메일","asd@asd.com").apply()
            editor.putString("이름","lim").apply()
            editor.putString("나이","26").apply()
            editor.putString("비밀번호","asdasd").apply()

        } else {
            Toast.makeText(this, "Login Fail", Toast.LENGTH_SHORT).show()

        }
    }
}