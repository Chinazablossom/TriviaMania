package com.example.triviamania.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentCategoriesBinding


class categoriesFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            sciImg.setOnClickListener {  }

            androidImg.setOnClickListener {
                findNavController().navigate(R.id.android_levelsFragment)
            }

            mathImg.setOnClickListener {  }
            compImg.setOnClickListener {  }
            entertainmentImg.setOnClickListener {  }
            historyImg.setOnClickListener {  }
            geographyImg.setOnClickListener {  }
            sportImg.setOnClickListener {  }



        }
    }

}