package com.example.triviamania.ui.screens

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentResultsBinding


class ResultsFragment : Fragment() {
    lateinit var binding: FragmentResultsBinding
    private var mediaPlayer: MediaPlayer? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultsBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mediaPlayer = MediaPlayer.create(requireContext(),R.raw.yay)
        mediaPlayer?.start()





        binding.apply {


            val totalQuest = arguments?.getInt("total")
            val correctAnswers = arguments?.getInt("result")
            val skipped = arguments?.getInt("skipped")
            val wrong = skipped?.let { (correctAnswers?.let { totalQuest?.minus(it) })?.minus(it) }


            totalQuestions.text = totalQuest.toString()
            rightAnswers.text = correctAnswers.toString()
            wrongAnswers.text = wrong.toString()
            skippedTxt.text = skipped.toString()


            retrybtn.setOnClickListener{
                findNavController().navigate(R.id.android_levelsFragment)
            }

            quitbtn.setOnClickListener{
                findNavController().popBackStack(R.id.categoriesFragment,false)
            }

            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                findNavController().popBackStack(R.id.categoriesFragment,false)
            }


        }

    }


}