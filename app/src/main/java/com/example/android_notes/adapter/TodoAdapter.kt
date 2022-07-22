package com.example.android_notes.adapter

import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_notes.data.Todo
import com.example.android_notes.databinding.ItemTodoBinding
import timber.log.Timber
import java.util.*


// RecyclerView.Adapter<RecyclerView.ViewHolder> => Adapter 의 RecyclerView 기본 형식
// TodoAdapter => 데이터를 그려주는 역할
class TodoAdapter(private val todos: List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    fun clearAll() {
        todos.forEach { it.completed = true }
        notifyDataSetChanged() // 데이터 셋이 변경되어서 onBindViewHolder 를 다시 호출
    }

    inner class TodoViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(todo: Todo) {
                binding.todoTitleText.text = todo.title
                binding.completedCheckBox.isChecked = todo.completed
            }

    }

    // onCreateViewHolder 메서드는 호출되는 횟수가 정해져 있음
    // parent => RecyclerView 자체임, RecyclerView 도 결국 ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        Timber.d("onCreateViewHolder")
        val binding = ItemTodoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false )
        return TodoViewHolder(binding).also { holder ->
            binding.completedCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                todos.getOrNull(holder.adapterPosition)?.completed = isChecked
            }
        }


    }

    // onBindViewHolder 메서더는 스크롤을 많이 할 수록 호출되는 메서드
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        //holder.adapterPosition // 매개변수 position 과 동일함
        Timber.d("onBindViewHolder")
        holder.bind(todos[position])

    }

    // 그려야줘야 할 항목이 몇개인지 알려주는 것
    override fun getItemCount() = todos.size // Todo data class 에 사이즈를 반환하면됨
}