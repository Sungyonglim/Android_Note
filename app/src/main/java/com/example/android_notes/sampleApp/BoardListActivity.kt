package com.example.android_notes.sampleApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import com.example.android_notes.R
import com.example.android_notes.databinding.ActivityBoardListBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_board_list.*

class BoardListActivity : AppCompatActivity() {

    // Adapter 선언
    private lateinit var lVAdapter : ListViewAdapter
    private  var list =  mutableListOf<Model>()// 데이터를 담을 리스트 변수 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_list)

        val writeBtn = findViewById<Button>(R.id.writeBtn)

        writeBtn.setOnClickListener {
            startActivity(Intent(this, BoardWriteActivity::class.java))
        }

        val lv = findViewById<ListView>(R.id.lv)

        lVAdapter = ListViewAdapter(list)
        lv.adapter = lVAdapter

        getData()

    }

    private fun getData() {
        val database = Firebase.database
        val myRef = database.getReference("board")
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(dataModel in dataSnapshot.children) {
                    val item = dataModel.getValue(Model::class.java) // 만들어 둔 data class Model 형태로 데이터를 가져옴
                    list.add(item!!)

//                    Log.d("로그", item.toString()) // key, value 하나 씩 출력
                }
                // 만약 notifyDataSetChanged() 메서드를 사용하지 않으면 위에서 먼저 adapter 가 만들어지기 때문에 원하지 않은 결과를 얻게됨 
                // 그래서 반복문(데이터를 다 받아오는 구문)이 끝나고 다시 Adapter 와 동기화를 시켜주는 일을 해줘야함
                lVAdapter.notifyDataSetChanged() // 위에 for 문이 끝난 후 다시 동기화 시킴 
                
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        myRef.addValueEventListener(postListener)
    }
}

/*
/** 어댑터 연결 방법 **/
// 1. 데이터를 담을 리스트를 만든다
val list = mutableListOf<Model>()
list.add(Model("a"))
list.add(Model("b"))
list.add(Model("c"))
list.add(Model("d"))

// 2. 어댑터에 데이터를 추가한다
lVAdapter = ListViewAdapter(list)

// 3. 리스트 뷰에 어댑터를 연결한다.
val lv = findViewById<ListView>(R.id.lv)
lv.adapter = lVAdapter
 */