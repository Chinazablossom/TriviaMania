package com.example.triviamania.ui.screens

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentStarterFrgBinding
import com.example.triviamania.viewModels.SoundViewModel

class StarterFrg : Fragment() {

    private lateinit var binding: FragmentStarterFrgBinding
    private val soundViewModel: SoundViewModel by activityViewModels()
    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayerClick: MediaPlayer? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStarterFrgBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            soundViewModel.isSoundOn.observe(viewLifecycleOwner) { isSoundOn ->
                if (isSoundOn) {
                    mediaPlayer?.start()
                   /* view.findViewById<ImageView>(R.id.imgsound)?.setImageResource(R.drawable.img_2)
                    view.findViewById<TextView>(R.id.txtSwitch)?.text = "ON"
                    */
                } else {
                    mediaPlayer?.pause()
                  /*  view.findViewById<ImageView>(R.id.imgsound)?.setImageResource(R.drawable.img_1)
                    view.findViewById<TextView>(R.id.txtSwitch)?.text = "OFF"
                    */
                }
            }

            settingsImg.setOnClickListener {
                mediaPlayerClick = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayerClick?.start()

                findNavController().navigate(R.id.settingsFragment)
            }

            btnPlay.setOnClickListener {
                mediaPlayerClick = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayerClick?.start()

                findNavController().navigate(R.id.categoriesFragment)
            }

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
    }

}