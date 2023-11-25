package com.example.triviamania.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentStarterFrgBinding
import com.example.triviamania.viewModels.SoundViewModel

class StarterFrg : Fragment() {

    private lateinit var binding: FragmentStarterFrgBinding
    private val soundViewModel: SoundViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentStarterFrgBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnPlay.setOnClickListener {
                findNavController().navigate(R.id.categoriesFragment)
            }

        }
    }

}