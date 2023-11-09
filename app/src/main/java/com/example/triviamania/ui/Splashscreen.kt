package com.example.triviamania.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.triviamania.databinding.ActivitySplashScreenBinding

class Splashscreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this@Splashscreen, MainActivity::class.java))
                finish()
            }, 4000)

        }
    }
}