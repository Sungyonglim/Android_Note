package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_notes.databinding.ActivityTodoRecyclerViewBinding

class TodoRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeViews()
    }

    private fun initializeViews() {
        // layoutManager => 아이템을 어떻게 배열할지 결정 
        // LinearLayoutManager => 세로로 배열한다는 의미
        // GridLayoutManager => 판 형식으로 배열한다는 의미
        binding.todoList.layoutManager = LinearLayoutManager(this)
        // Adapter => item_todo.xml 을 실제로 만들어서 값 같은 것을 넣어주는 역할
        binding.todoList.adapter


    }
}