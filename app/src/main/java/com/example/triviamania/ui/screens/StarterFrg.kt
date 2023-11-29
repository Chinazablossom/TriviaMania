package com.example.triviamania.ui.screens

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentStarterFrgBinding

class StarterFrg : Fragment() {

    private lateinit var binding: FragmentStarterFrgBinding
    private var mediaPlayerClick: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStarterFrgBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            settingsImg.setOnClickListener {
                mediaPlayerClick =
                    MediaPlayer.create(requireContext(), R.raw.mouse_click_sound_effect)
                mediaPlayerClick?.start()

                findNavController().navigate(R.id.settingsFragment)
            }

            btnPlay.setOnClickListener {
                mediaPlayerClick = MediaPlayer.create(requireContext(), R.raw.game_click)
                mediaPlayerClick?.start()

                findNavController().navigate(R.id.categoriesFragment)
            }

        }
    }


}