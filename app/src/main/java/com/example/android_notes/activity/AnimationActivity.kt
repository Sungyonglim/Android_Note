package com.example.android_notes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_notes.R
import kotlinx.android.synthetic.main.activity_animation.*
import render.animations.*

// Use Gayanvoice repositories of android-animations-kotlin

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        aniBtn1.setOnClickListener { clickAnimation(aniBtn1) }
        aniBtn2.setOnClickListener { clickAnimation(aniBtn2) }
        aniBtn3.setOnClickListener { clickAnimation(aniBtn3) }
        aniBtn4.setOnClickListener { clickAnimation(aniBtn4) }
        aniBtn5.setOnClickListener { clickAnimation(aniBtn5) }
        aniBtn6.setOnClickListener { clickAnimation(aniBtn6) }
        aniBtn7.setOnClickListener { clickAnimation(aniBtn7) }
        aniBtn8.setOnClickListener { clickAnimation(aniBtn8) }
    }

    private fun clickAnimation(v: View) {
        val render = Render(this)
        when (v.id) {
            R.id.aniBtn1 -> render.setAnimation(Attention().Bounce(signUpLayout))
            R.id.aniBtn2 -> render.setAnimation(Bounce().InLeft(aniBtn2))
            R.id.aniBtn3 -> render.setAnimation(Fade().InUp(aniBtn3))
            R.id.aniBtn4 -> render.setAnimation(Flip().InY(aniBtn4))
            R.id.aniBtn5 -> render.setAnimation(Flip().InX(aniBtn5))
            R.id.aniBtn6 -> render.setAnimation(Rotate().InDownLeft(aniBtn6))
            R.id.aniBtn7 -> render.setAnimation(Slide().InDown(aniBtn7))
            R.id.aniBtn8 -> render.setAnimation(Zoom().InDown(aniBtn8))
        }
        render.start()
    }
}