package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_toolbar.*

class ToolbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        // 해당 activity에 toolbar를 달아주는 메서드
        setSupportActionBar(toolbar)
    }

    // 클릭을 하면 메뉴를 호출하는 메서드
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // 메뉴를 View 형식으로 만들고 띄워줌
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // menu 아이템 클릭 시 호출되는 메서드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.tool_home -> println("Selected Home")
            R.id.tool_send -> println("Selected Send")
        }
        return super.onOptionsItemSelected(item)

    }
}