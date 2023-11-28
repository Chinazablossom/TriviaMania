package com.example.triviamania.ui.screens

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesBinding
    var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            sciImg.setOnClickListener {
                mediaPlayer = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayer?.start()
                findNavController().navigate(R.id.scienceLevelFragment)
            }

            androidImg.setOnClickListener {
                mediaPlayer = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayer?.start()
                findNavController().navigate(R.id.android_levelsFragment)
            }

            mathImg.setOnClickListener {
                mediaPlayer = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayer?.start()
                findNavController().navigate(R.id.mathsFragment)

            }

            compImg.setOnClickListener {
                mediaPlayer = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayer?.start()
                findNavController().navigate(R.id.computerScienceFragment)

            }

            entertainmentImg.setOnClickListener {
                mediaPlayer = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayer?.start()
                findNavController().navigate(R.id.entertainmentFragment)

            }

            historyImg.setOnClickListener {
                mediaPlayer = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayer?.start()
                mediaPlayer?.stop()
                findNavController().navigate(R.id.historyFragment)
            }

          //  geographyImg.setOnClickListener {  }
           // sportImg.setOnClickListener {  }

        }
    }

}