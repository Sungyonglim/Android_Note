package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : AppCompatActivity() {
    val TAG: String = "log"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        Log.d(TAG, "LifeCycleActivity - onCreate() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "LifeCycleActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "LifeCycleActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        text_view.visibility = View.VISIBLE
        Log.d(TAG, "LifeCycleActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "LifeCycleActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "LifeCycleActivity - onDestroy() called")
    }

}