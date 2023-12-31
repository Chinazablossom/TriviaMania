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
import com.example.triviamania.databinding.FragmentSettingsBinding
import com.example.triviamania.viewModels.SoundViewModel

class SettingsFragment : Fragment() {
    lateinit var binding: FragmentSettingsBinding
    private val soundViewModel: SoundViewModel by activityViewModels()
    var mediaPlayer: MediaPlayer? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            soundViewModel.isSoundOn.observe(viewLifecycleOwner) { isSoundOn ->
                if (isSoundOn) {
                    mediaPlayer?.start()
                    view.findViewById<ImageView>(R.id.imgsound)?.setImageResource(R.drawable.img_2)
                    view.findViewById<TextView>(R.id.txtSwitch)?.text = getString(R.string.on)
                } else {
                    mediaPlayer?.pause()
                    view.findViewById<ImageView>(R.id.imgsound)?.setImageResource(R.drawable.img_1)
                    view.findViewById<TextView>(R.id.txtSwitch)?.text = getString(R.string.off)
                }
            }


            about.setOnClickListener {
                findNavController().navigate(R.id.aboutFragment)
            }

            hwtoplay.setOnClickListener {
                findNavController().navigate(R.id.rulesFragment)
            }

            soundID.setOnClickListener {
                toggleSound()
            }

            exit.setOnClickListener {
                findNavController().popBackStack(R.id.starter_Frg2,false)
            }

        }


    }

    private fun toggleSound() {
        val isSoundOn = soundViewModel.isSoundOn.value ?: true
        soundViewModel.setSoundOn(!isSoundOn)
    }


}