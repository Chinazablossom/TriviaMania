package com.example.triviamania.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
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

        val animations = arrayOf(
            R.raw.android_winner, R.raw.science_result,
            R.raw.math_result, R.raw.cs_result, R.raw.entertainment_result, R.raw.history_result,
            R.raw.geography_result, R.raw.sport_result
            )


        binding.apply {


            val totalScore = arguments?.getInt("total")
            val correctAnswers = arguments?.getInt("result")
            val wrong =  correctAnswers?.let { totalScore?.minus(it) }
            val anim = arguments?.getInt("anim")

            if (anim != null) {
                lottieAnimationView4.setAnimation(anim)
                lottieAnimationView4.playAnimation()
                lottieAnimationView4.loop(true)
            }

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