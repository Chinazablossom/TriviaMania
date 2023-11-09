package com.example.triviamania

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.triviamania.databinding.FragmentResultsBinding


class ResultsFragment : Fragment() {
    lateinit var binding: FragmentResultsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {


            val totalScore = arguments?.getInt("total",0)
            val correctAnswers = arguments?.getInt("result",0)
            val wrong =  correctAnswers?.let { totalScore?.minus(it) }
            //totalScore?.minus(correctAnswers!!)

            totalQuestions.text = totalScore.toString()
            rightAnswers.text = correctAnswers.toString()
            wrongAnswers.text = wrong.toString()

            retrybtn.setOnClickListener{
                findNavController().navigate(R.id.android_levelsFragment)
            }
            binding.quitbtn.setOnClickListener{
                findNavController().popBackStack(R.id.categoriesFragment,false)
            }
        }

    }


}