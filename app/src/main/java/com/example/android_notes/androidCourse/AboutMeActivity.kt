package com.example.android_notes.androidCourse

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android_notes.R
import com.example.android_notes.databinding.ActivityAboutMeBinding

/** 뷰를 데이터에 바인딩하는 단계**/
/*
    1. 데이터에 대한 데이터 클래스를 만듬
    2. <layout> 태그 안에 <data> 블록을 추가
    3. <variable> 태그 안에 데이터 클래스의 유형을 정의함 
    4. Activity 에서 데이터 클래스의 인스턴스로 변수를 만듬 
    5. 바인딩 개체에서 방금 만든 변수로 변수를 설정
    6. XML 에서 보기의 내용을 <data> 블록에 정의한 변수로 설정.
       점 표기법을 사용하여 데이터 클래스 내부의 데이터에 액세스함 (android: text = "@={myName.name}")
* */

class AboutMeActivity : AppCompatActivity() {

    // 바인딩 개체에 대한 변수 생성
    private lateinit var binding: ActivityAboutMeBinding
    // 4번 
    private val myName: MyName = MyName("Sungyong Lim")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_about_me)
        // DataBindingUtil 클래스의 setContentView() 함수를 사용하여 "activity_about_me"와 연결
        binding = DataBindingUtil.setContentView(this, R.layout.activity_about_me)
        
        // 5번
        binding.myName = myName
        
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
                    myName?.nickName = nicknameEdit.text.toString() // 입력한 editText text 를 textView text 에 할당
                    invalidateAll() // 닉네임이 설정된 후 코드에서 새 데이터로 ui를 새로 고쳐야 하기 때문에 올바른 데이터로 다시 생성되도록 모든 바이딩 식을 무효화
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
