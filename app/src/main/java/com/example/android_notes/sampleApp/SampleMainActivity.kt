package com.example.android_notes.sampleApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android_notes.R
import com.example.android_notes.databinding.ActivitySampleMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SampleMainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySampleMainBinding
    private lateinit var email: EditText
    private lateinit var pwd: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sample_main)

        auth = Firebase.auth

        email = binding.emailArea
        pwd = binding.pwdArea

        // 회원가입
        binding.signBtn.setOnClickListener {

            // email, password 매개변수로 받아오는 방법 1
            // EditText id 를 찾고 매개변수에 형변화해서 할당
            // val email = findViewById<EditText>(R.id.emailArea)
            // val pwd = findViewById<EditText>(R.id.pwdArea)

            // 방법 2
            // DataBinding


            auth.createUserWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this,"No", Toast.LENGTH_SHORT).show()

                    }
                }
        }

        // 로그인
        binding.loginBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(email.text.toString(), pwd.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(this, "${user?.email.toString()}님 로그인 성공", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        // 로그아웃
        binding.logoutBtn.setOnClickListener {
            auth.signOut()
            Toast.makeText(this, auth.currentUser?.uid.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}