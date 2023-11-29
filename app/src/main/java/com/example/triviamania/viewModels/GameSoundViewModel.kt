package com.example.triviamania.viewModels

import android.app.Application
import android.media.MediaPlayer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.triviamania.R

class GameSoundViewModel (application: Application) : AndroidViewModel(application) {
    private val _isSoundOn = MutableLiveData(true)
    val isSoundOn: LiveData<Boolean> get() = _isSoundOn

    private var _mediaPlayer: MediaPlayer? = null
    val mediaPlayer: MediaPlayer? get() = _mediaPlayer


    init {
        if (_mediaPlayer == null) {
            _mediaPlayer = MediaPlayer.create(getApplication(), R.raw.quiz_background_game)
            _mediaPlayer?.isLooping = true
            if (isSoundOn.value == true) {
                _mediaPlayer?.start()
            } else {
                _mediaPlayer?.pause()
            }
        }
    }

    fun setSoundOn(isOn: Boolean) {
        _isSoundOn.value = true
        if (isOn) {
            if (_mediaPlayer == null) {
                _mediaPlayer?.isLooping = true
               _mediaPlayer?.setOnPreparedListener {
                    _mediaPlayer?.start()
                }
                _mediaPlayer?.prepareAsync()
            } else {
                _mediaPlayer?.start()
            }
        } else {
            _mediaPlayer?.pause()
        }
    }


}