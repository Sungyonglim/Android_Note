package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.android_notes.R
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_navigation_view.*
import kotlinx.android.synthetic.main.activity_navigation_view.navView
import kotlinx.android.synthetic.main.activity_sample.*
import kotlinx.android.synthetic.main.activity_sample.layout_drawer

class NavigationViewActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_view)

        // 버튼 클릭 시 drawerLayout 화면에 표시 -> GravityCompat이 START이기 때문에 왼쪽에서 시작
        navBtn.setOnClickListener { layout_drawer.openDrawer(GravityCompat.START) }
        navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.email -> Toast.makeText(this, "이메일 선택", Toast.LENGTH_SHORT).show()
            R.id.send -> Toast.makeText(this, "전송 선택", Toast.LENGTH_SHORT).show()
            R.id.access -> Toast.makeText(this, "접근성 선택", Toast.LENGTH_SHORT).show()
        }

        //drawerLayout(navigationView 바깥) 클릭 시 navigationView 닫아짐
        layout_drawer.closeDrawers()
        return false
    }

    // navigationView가 열러 있을 때 뒤로 가기 버튼 클릭 시 애플리케이션이 닫아지는 문제 해결 코드
    override fun onBackPressed() {
        if(layout_drawer.isDrawerOpen(GravityCompat.START)) layout_drawer.closeDrawers()
        else super.onBackPressed()
    }


}