package com.example.pibja.Activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.pibja.R


class SplashActivity : AppCompatActivity() {

    var SPLASH_TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            startActivity(Intent(this,
                AnunciosDaSemana::class.java ))
            finish()
        },SPLASH_TIME_OUT)
    }
}
