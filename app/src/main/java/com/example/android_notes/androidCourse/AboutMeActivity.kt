package com.example.android_notes.androidCourse

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import com.example.android_notes.R
import com.example.android_notes.databinding.ActivityAboutMeBinding

class AboutMeActivity : AppCompatActivity() {

    // 바인딩 개체에 대한 변수 생성
    private lateinit var binding: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_about_me)
        // DataBindingUtil 클래스의 setContentView() 함수를 사용하여 "activity_about_me"와 연결
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_me)

        onClick(binding.doneButton)
        onClick(binding.nicknameText)

    }

    // 클릭 이벤트 메서드
    private fun onClick(v: View) {
        when(v.id) {
            R.id.done_button -> binding.doneButton.setOnClickListener { addNickName(it) }
            R.id.nickname_text -> binding.nicknameText.setOnClickListener { updateNickname(it) }
        }
    }

    // 버튼 클릭 시 입력된 닉네임을 텍스트뷰에 보이게 하는 메서드
    private fun addNickName(v: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


            if(binding.nicknameEdit.text.toString().isEmpty()) {
                Toast.makeText(this ,"닉네임을 입력해주세요.ㅁㄴ", Toast.LENGTH_SHORT).show()
            } else {
                binding.apply {
                    nicknameText.text = nicknameEdit.text.toString() // 입력한 editText text 를 textView text 에 할당

                    nicknameEdit.visibility = View.GONE // editText 숨김
                    v.visibility = View.GONE // button 숨김
                    nicknameText.visibility = View.VISIBLE // TextView 보이게 설정


                    inputMethodManager.hideSoftInputFromWindow(
                        v.windowToken,
                        0
                    ) // 키보드 숨기기기
                }
            }



    }

    // 텍스트 뷰 클릭 시 닉네임을 다시 입력할 수 있게 하는 메서드
    private fun updateNickname(v: View) {

        binding.apply {
            nicknameText.visibility = View.GONE
            nicknameEdit.apply {
                visibility = View.VISIBLE
                requestFocus()// editText 로 포커스 변경
            }
            doneButton.visibility = View.VISIBLE
            nicknameEdit.requestFocus()
        }


        // 키보드를 다시 보이게 설정
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)

    }
}
