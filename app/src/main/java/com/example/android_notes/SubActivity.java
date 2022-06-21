package com.example.android_notes;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 클릭 시 log 값 출력 코드
        Button Btn2 = findViewById(R.id.Btn2);
        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("로그", "값");
            }
        });

        // 버튼 클릭 시 지정한 Activity로 이동하면서 데이터 넘겨주는 코드
        findViewById(R.id.Btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SubActivity.this, TestActivity.class);
                intent.putExtra("키","벨류");
                startActivity(intent);
            }
        });
    }

    // Onclick method 를 활용해서 Toast Message 출력
    public void Btn1Click(View v) {
        Toast toast = Toast.makeText(this, "ㅋㅋㅋㅋㅋ", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.END | Gravity.BOTTOM, 10, 10);
        toast.show();
    }
}
