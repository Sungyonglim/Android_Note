package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_notes.adapter.TodoAdapter
import com.example.android_notes.data.Todo
import com.example.android_notes.databinding.ActivityTodoRecyclerViewBinding

class TodoRecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoRecyclerViewBinding

    private val todos = listOf(
        Todo("#1. 코틀린 공부", false),
        Todo("#2. 안드로이드 공부", false),
        Todo("#3. 코딩테스트 공부", false),
        Todo("#4. 면접 공부", false),
        Todo("#5. 영어 공부", false),
        Todo("#6. 자소서 작성", false),
        Todo("#7. 코틀린 공부", false),
        Todo("#8. 안드로이드 공부", false),
        Todo("#9. 코딩테스트 공부", false),
        Todo("#10. 면접 공부", false),
        Todo("#11. 영어 공부", false),
        Todo("#12. 자소서 작성", false),
        Todo("#13. 코틀린 공부", false),
        Todo("#14. 안드로이드 공부", false),
        Todo("#15. 코딩테스트 공부", false),
        Todo("#16. 면접 공부", false),
        Todo("#17. 영어 공부", false),
        Todo("#18. 자소서 작성", false)
    )

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
        binding.todoList.adapter = TodoAdapter(todos)

        binding.clearButton.setOnClickListener {
            (binding.todoList.adapter as? TodoAdapter)?.clearAll()
        }


    }
}