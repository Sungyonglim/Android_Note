package com.example.android_notes.androidCourse

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_about_me.*

class AboutMeActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var nicknameTextView: TextView
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        editText = findViewById(R.id.nickname_edit)
        nicknameTextView = findViewById(R.id.nickname_text)
        doneButton = findViewById(R.id.done_button)

        onClick(doneButton)
        onClick(nicknameTextView)

    }

    // 클릭 이벤트 메서드
    private fun onClick(v: View) {
        when(v.id) {
            R.id.done_button -> done_button.setOnClickListener { addNickName(it) }
            R.id.nickname_text -> nicknameTextView.setOnClickListener { updateNickname(it) }
        }
    }

    // 버튼 클릭 시 입력된 닉네임을 텍스트뷰에 보이게 하는 메서드
    private fun addNickName(v: View) {
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        nicknameTextView.text = editText.text // 입력한 editText text 를 textView text 에 할당

        editText.visibility = View.GONE // editText 숨김
        v.visibility = View.GONE // button 숨김
        nicknameTextView.visibility = View.VISIBLE // TextView 보이게 설정

        inputMethodManager.hideSoftInputFromWindow(
            v.windowToken,
            0
        ) // 키보드 숨기기기


    }

    // 텍스트 뷰 클릭 시 닉네임을 다시 입력할 수 있게 하는 메서드
    private fun updateNickname(v: View) {
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        nicknameTextView.visibility = View.GONE

        editText.requestFocus() // editText 로 포커스 변경

        // 키보드를 다시 보이게 설정
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.showSoftInput(editText, 0)

    }
}
