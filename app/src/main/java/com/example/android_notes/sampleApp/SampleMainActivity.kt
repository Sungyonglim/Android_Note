package com.example.android_notes.sampleApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.android_notes.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SampleMainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_main)

        auth = Firebase.auth

        val signBtnClicked = findViewById<Button>(R.id.signBtn)
        signBtnClicked.setOnClickListener {
            auth.createUserWithEmailAndPassword("abc@abc.com", "123123")
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this,"No", Toast.LENGTH_SHORT).show()

                    }
                }

        }
    }
}