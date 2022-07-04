package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_search_view.*

class SearchViewActivity : AppCompatActivity() {

    var myList = arrayOf("apple", "Banana", "abc")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            // 완료 버튼을 누르면 실행되는 메서드
            override fun onQueryTextSubmit(p0: String?): Boolean {
                println("$p0 완료")
                return true
            }

            // Text가 변경될 때 마다 실행되는 메서드
            override fun onQueryTextChange(p0: String?): Boolean {
                if(p0 != "") {
                    var curList = myList.filter { x -> x.toLowerCase().contains(p0?.toLowerCase().toString()) }
                    for (i in curList) println(i)
                    println("=======================")
                }
                return true
            }
        })
    }
}