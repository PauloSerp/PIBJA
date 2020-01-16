package com.example.pibja.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.example.pibja.R


class SplashActivity : AppCompatActivity() {

    var SPLASH_TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animation = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom_in)
        val animationBounce = AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)
        val textView = findViewById<TextView>(R.id.text_pibja_splash)

        textView.startAnimation(animationBounce)


        Handler().postDelayed({
            textView.startAnimation(animation)
            Handler().postDelayed({
                startActivity(Intent(this,
                        MainActivity::class.java ))
                finish()
            },970)
        },SPLASH_TIME_OUT)
    }
}
