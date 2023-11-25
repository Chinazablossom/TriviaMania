package com.example.triviamania.ui.screens

import android.animation.Animator
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentEntertainmentGameBinding
import com.example.triviamania.viewModels.GamesViewModel

class EntertainmentGameFragment : Fragment() {
    private val entertainmentGameViewModel: GamesViewModel by viewModels()

    private lateinit var binding: FragmentEntertainmentGameBinding
    private var count = 0
    private var currentPosition = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEntertainmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            entertainmentGameViewModel.position.observe(viewLifecycleOwner) {
                currentPosition = it
            }

            entertainmentGameViewModel.currentTimeLeft.observe(viewLifecycleOwner) {
                counterTv.text = requireContext().getString(R.string.timer, it)
                if (it == 10L) counterTv.setTextColor(Color.RED)
            }

            entertainmentGameViewModel.isGameOver.observe(viewLifecycleOwner) {
                if (it) {
                    showTimeUpDialog()
                }
            }
            if (savedInstanceState == null) {
                entertainmentGameViewModel.resetTimer()
                counterTv.setTextColor(Color.BLACK)
            }

            if (savedInstanceState != null) {
                currentPosition = savedInstanceState.getInt("position", 0)
            }


            when (arguments?.getString("Key")) {
                "Stage 1" -> {
                    entertainmentGameViewModel.entertainmentStageOne()
                }

                "Stage 2" -> {
                    entertainmentGameViewModel.entertainmentStageTwo()
                }

                "Stage 3" -> {
                    entertainmentGameViewModel.entertainmentStageThree()
                }

                "Stage 4" -> {
                    entertainmentGameViewModel.entertainmentStageFour()
                }

                "Stage 5" -> {
                    entertainmentGameViewModel.entertainmentStageFive()
                }

                "Stage 6" -> {
                    entertainmentGameViewModel.entertainmentStageSix()
                }

                "Stage 7" -> {
                    entertainmentGameViewModel.entertainmentStageSeven()
                }

                "Stage 8" -> {
                    entertainmentGameViewModel.entertainmentStageEight()
                }

                "Stage 9" -> {
                    entertainmentGameViewModel.entertainmentStageNine()
                }

                "Stage 10" -> {
                    entertainmentGameViewModel.entertainmentStageTen()
                }

                "Stage 11" -> {
                    entertainmentGameViewModel.entertainmentStageEleven()
                }

                "Stage 12" -> {
                    entertainmentGameViewModel.entertainmentStageTwelve()
                }

                "Stage 13" -> {
                    entertainmentGameViewModel.entertainmentStageThirteen()
                }

                "Stage 14" -> {
                    entertainmentGameViewModel.entertainmentStageFourteen()
                }

            }

            for (i in 0..3) {
                optContainer.getChildAt(i).setOnClickListener {
                    checkAnswer(it as Button)
                }
            }
            playAnimation(
                QuestionTv,
                0,
                entertainmentGameViewModel.questionsList[currentPosition].question
            )
            btnNext.setOnClickListener {
                if (savedInstanceState == null) {
                    entertainmentGameViewModel.resetTimer()
                    view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)
                        ?.pauseAnimation()

                }

                entertainmentGameViewModel.resetTimer()
                counterTv.setTextColor(Color.BLACK)
                view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.playAnimation()

                btnNext.isEnabled = false
                btnNext.alpha = 0.3f
                enableOption(true)
                entertainmentGameViewModel.increasePosition()

                if (currentPosition == entertainmentGameViewModel.questionsList.size) {
                    findNavController().navigate(
                        R.id.resultsFragment,
                        bundleOf(
                            "result" to entertainmentGameViewModel.score.value,
                            "total" to entertainmentGameViewModel.questionsList.size,
                            "anim" to R.raw.entertainment_result
                        )
                    )

                    return@setOnClickListener
                }
                count = 0
                playAnimation(
                    QuestionTv,
                    0,
                    entertainmentGameViewModel.questionsList[currentPosition].question
                )
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("position", currentPosition)
    }

    private fun enableOption(b: Boolean) {
        for (i in 0..3) {
            binding.optContainer.getChildAt(i).isEnabled = b
            if (b) {
                binding.optContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opts)
            }
        }
    }

    private fun showTimeUpDialog() {
        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.timeup_dialogue)

        dialog.findViewById<View>(R.id.tryAgainbtn).setOnClickListener {
            findNavController().popBackStack(R.id.android_levelsFragment, false)
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun playAnimation(view: View, value: Int, data: String) {
        view.animate().alpha(value.toFloat()).scaleX(value.toFloat()).scaleY(value.toFloat())
            .setDuration(500).setStartDelay(100)
            .setInterpolator(DecelerateInterpolator())
            .setListener(object : Animator.AnimatorListener {

                override fun onAnimationStart(animation: Animator) {
                    if (value == 0 && count < 4) {
                        val option: String = when (count) {
                            0 -> entertainmentGameViewModel.questionsList[currentPosition].option1
                            1 -> entertainmentGameViewModel.questionsList[currentPosition].option2
                            2 -> entertainmentGameViewModel.questionsList[currentPosition].option3
                            3 -> entertainmentGameViewModel.questionsList[currentPosition].options4
                            else -> ""
                        }
                        playAnimation(binding.optContainer.getChildAt(count), 0, option)
                        count++
                    }
                }

                override fun onAnimationEnd(animation: Animator) {
                    if (value == 0) {
                        try {
                            (view as TextView).text = data
                            binding.numOfqTv.text = getString(
                                R.string.amountOfQuestions,
                                currentPosition + 1,
                                entertainmentGameViewModel.questionsList.size
                            )
                        } catch (e: Exception) {
                            (view as Button).text = data
                        }
                        view.tag = data
                        playAnimation(view, 1, data)
                    }
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
    }

    private fun checkAnswer(selectedOption: Button) {
        entertainmentGameViewModel.stopTimer()
        view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()

        binding.btnNext.isEnabled = true
        binding.btnNext.alpha = 1f
        if (entertainmentGameViewModel.checkAnswer(selectedOption.text.toString())) {
            selectedOption.setBackgroundResource(R.drawable.correct)
        } else {
            selectedOption.setBackgroundResource(R.drawable.wrong)
            val correctOption =
                binding.optContainer.findViewWithTag(entertainmentGameViewModel.questionsList[currentPosition].correctAnswer) as Button
            correctOption.setBackgroundResource(R.drawable.correct)
        }

    }


}