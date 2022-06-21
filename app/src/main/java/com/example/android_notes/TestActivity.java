package com.example.android_notes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // 데이터 받는 부분
        // SubActivity에서 넘겨준 데이터를 키 값으로 받는 코드
        Intent intent = getIntent();
        String str = intent.getExtras().getString("키");
        Log.d("로그", str);

        // Edit Text 에 넘겨준 데이터를 표시하는 코드
        // 방법 1.
        ((EditText)findViewById(R.id.edit_text)).setText(str);
        // 방법 2.
        // EditText editText = findViewById(R.id.edit_text);
        // editText.setText(str);



    }
}
