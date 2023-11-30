package com.example.triviamania.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.triviamania.R
import com.example.triviamania.viewModels.GameSoundViewModel
import com.example.triviamania.viewModels.SoundViewModel

class MainActivity : AppCompatActivity() {
    private val soundViewModel: SoundViewModel by viewModels()
    private val gameSoundViewModel: GameSoundViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

    }


    override fun onStop() {
        super.onStop()
        soundViewModel.mediaPlayer?.pause()
        gameSoundViewModel.mediaPlayer?.pause()

    }

    override fun onResume() {
        super.onResume()
        if (soundViewModel.isSoundOn.value == true) {
            soundViewModel.mediaPlayer?.start()
        }
    }
}