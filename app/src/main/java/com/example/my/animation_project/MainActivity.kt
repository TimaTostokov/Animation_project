package com.example.my.animation_project

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var fon_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet

    var isFont = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scale = applicationContext.resources.displayMetrics.density
        val cardF = findViewById<LinearLayout>(R.id.card_fon)
        cardF.cameraDistance = 8000 * scale
        val cardB = findViewById<LinearLayout>(R.id.card_back)
        cardB.cameraDistance = 8000 * scale

        fon_anim = AnimatorInflater.loadAnimator(
            applicationContext,
            R.animator.fon_animator
        ) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(
            applicationContext,
            R.animator.back_animator
        ) as AnimatorSet

        cardF.setOnClickListener {
            if (isFont) {
                fon_anim.setTarget(cardF)
                fon_anim.setTarget(cardB)
                back_anim.start()
                fon_anim.start()
                isFont = false
            } else {
                fon_anim.setTarget(cardB)
                fon_anim.setTarget(cardF)
                back_anim.start()
                fon_anim.start()
                isFont = true
            }
        }
    }

}