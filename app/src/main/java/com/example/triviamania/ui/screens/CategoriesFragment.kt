package com.example.triviamania.ui.screens

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            sciImg.setOnClickListener {
                findNavController().navigate(R.id.scienceLevelFragment)
            }

            androidImg.setOnClickListener {
                findNavController().navigate(R.id.android_levelsFragment)
            }

            mathImg.setOnClickListener {
                findNavController().navigate(R.id.mathsFragment)

            }

            compImg.setOnClickListener {
                findNavController().navigate(R.id.computerScienceFragment)

            }

            entertainmentImg.setOnClickListener {
                findNavController().navigate(R.id.entertainmentFragment)

            }

            historyImg.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }

          //  geographyImg.setOnClickListener {  }
           // sportImg.setOnClickListener {  }

        }
    }

}