package com.example.android_notes.permissions

import android.Manifest
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.android_notes.R
import kotlin.concurrent.thread

class PermissionsActivity : AppCompatActivity() {
    private val TAG = PermissionsActivity::class.java.simpleName
    private var isReady = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        thread(true) {
            for (i in 1..3) {
                Log.d(TAG, "sleep")
                Thread.sleep(1000)
            }
            isReady = true
        }

        // 위치 권한 요청
        val locationPermissionsRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                when {
                    permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                        Toast.makeText(this, "Fine OK", Toast.LENGTH_SHORT).show()
                    }
                    permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                        Toast.makeText(this, "Coarse OK", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (isReady) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        locationPermissionsRequest.launch(
                            arrayOf(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                        )

                        true
                    } else {
                        false
                    }
                }
            }
        )
    }
}