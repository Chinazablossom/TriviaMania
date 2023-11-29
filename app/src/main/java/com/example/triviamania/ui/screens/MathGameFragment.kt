package com.example.triviamania.ui.screens

import android.animation.Animator
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentMathGameBinding
import com.example.triviamania.viewModels.GameSoundViewModel
import com.example.triviamania.viewModels.GameViewModel
import com.example.triviamania.viewModels.SoundViewModel

class MathGameFragment : Fragment() {
    private val mathGameViewModel: GameViewModel by viewModels()
    private val soundViewModel: SoundViewModel by activityViewModels()
    private val gameSoundViewModel: GameSoundViewModel by activityViewModels()
    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayerClick: MediaPlayer? = null
    private lateinit var binding: FragmentMathGameBinding
    private var count = 0
    private var currentPosition = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMathGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            soundViewModel.setSoundOn(false)
            gameSoundViewModel.setSoundOn(true)

            mathGameViewModel.position.observe(viewLifecycleOwner) {
                currentPosition = it
            }

            mathGameViewModel.currentTimeLeft.observe(viewLifecycleOwner) {
                counterTv.text = requireContext().getString(R.string.timer, it)
                if (it == 10L) counterTv.setTextColor(Color.RED)
            }

            mathGameViewModel.isGameOver.observe(viewLifecycleOwner) {
                if (it) {
                    showTimeUpDialog()
                }
            }
            if (savedInstanceState == null) {
                mathGameViewModel.resetTimer()
                counterTv.setTextColor(Color.BLACK)
            }

            if (savedInstanceState != null) {
                currentPosition = savedInstanceState.getInt("position", 0)
            }


            when (arguments?.getString("Key")) {
                "Stage 1" -> {
                    mathGameViewModel.mathStageOne()

                }
            "Stage 2" -> {
                mathGameViewModel.mathStageTwo()
            }

            "Stage 3" -> {
                mathGameViewModel.mathStageThree()
            }

            "Stage 4" -> {
                mathGameViewModel.mathStageFour()
            }

            "Stage 5" -> {
                mathGameViewModel.mathStageFive()
            }

            "Stage 6" -> {
                mathGameViewModel.mathStageSix()
            }

            "Stage 7" -> {
                mathGameViewModel.mathStageSeven()
            }

            "Stage 8" -> {
                mathGameViewModel.mathStageEight()
            }

            "Stage 9" -> {
                mathGameViewModel.mathStageNine()
            }

            "Stage 10" -> {
                mathGameViewModel.mathStageTen()
            }

            "Stage 11" -> {
                mathGameViewModel.mathStageEleven()
            }

            "Stage 12" -> {
                mathGameViewModel.mathStageTwelve()
            }

            "Stage 13" -> {
                mathGameViewModel.mathStageThirteen()
            }

            "Stage 14" -> {
                mathGameViewModel.mathStageFourteen()
            }

            }

            for (i in 0..3) {
                optContainer.getChildAt(i).setOnClickListener {
                    checkAnswer(it as Button)
                }
            }
            playAnimation(QuestionTv, 0, mathGameViewModel.questionsList[currentPosition].question)

            skipBtn.setOnClickListener {
                mediaPlayerClick = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayerClick?.start()

                mathGameViewModel.skipQuestion()

                if (savedInstanceState == null) {
                    mathGameViewModel.resetTimer()
                    view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()

                }

                mathGameViewModel.resetTimer()
                counterTv.setTextColor(Color.BLACK)
                view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.playAnimation()

                btnNext.isEnabled = false
                btnNext.alpha = 0.3f
                enableOption(true)



                if (currentPosition >= mathGameViewModel.questionsList.size) {
                    gameSoundViewModel.setSoundOn(false)
                    soundViewModel.setSoundOn(true)

                    findNavController().navigate(
                        R.id.resultsFragment,
                        bundleOf(
                            "result" to mathGameViewModel.score.value,
                            "total" to mathGameViewModel.questionsList.size,
                            "skipped" to mathGameViewModel.skipped.value,
                            "goto" to R.id.mathsFragment


                        )
                    )
                    return@setOnClickListener
                }
                count = 0
                playAnimation(QuestionTv, 0, mathGameViewModel.questionsList[currentPosition].question)

            }

            btnNext.setOnClickListener {
                mediaPlayerClick = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
                mediaPlayerClick?.start()

                if (savedInstanceState == null) {
                    mathGameViewModel.resetTimer()
                    view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)
                        ?.pauseAnimation()

                }

                mathGameViewModel.resetTimer()
                counterTv.setTextColor(Color.BLACK)
                view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.playAnimation()

                btnNext.isEnabled = false
                btnNext.alpha = 0.3f
                enableOption(true)
                mathGameViewModel.increasePosition()

                if (currentPosition == mathGameViewModel.questionsList.size) {
                    gameSoundViewModel.setSoundOn(false)
                    soundViewModel.setSoundOn(true)

                    findNavController().navigate(
                        R.id.resultsFragment,
                        bundleOf(
                            "result" to mathGameViewModel.score.value,
                            "total" to mathGameViewModel.questionsList.size,
                            "skipped" to mathGameViewModel.skipped.value                        )
                    )

                    return@setOnClickListener
                }
                count = 0
                playAnimation(
                    QuestionTv,
                    0,
                    mathGameViewModel.questionsList[currentPosition].question
                )
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            showQuitDialog()
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
                binding.optContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt)
            }
        }
    }
    private fun showTimeUpDialog() {
        view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()

        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.timeup_dialogue)

        dialog.findViewById<View>(R.id.tryAgainbtn).setOnClickListener {
            mediaPlayerClick = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
            mediaPlayerClick?.start()
            gameSoundViewModel.setSoundOn(false)
            soundViewModel.setSoundOn(true)
            findNavController().popBackStack(R.id.mathsFragment, false)
            dialog.dismiss()
        }
        dialog.show()
    }
    private fun showQuitDialog() {
        mathGameViewModel.stopTimer()
        view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()

        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.quit_dialogue)

        dialog.findViewById<View>(R.id.yesbtn).setOnClickListener {
            mediaPlayerClick = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
            mediaPlayerClick?.start()
            findNavController().popBackStack(R.id.mathsFragment, false)
            gameSoundViewModel.setSoundOn(false)
            soundViewModel.setSoundOn(true)
            dialog.dismiss()
        }

        dialog.findViewById<View>(R.id.nobtn).setOnClickListener{
            mediaPlayerClick = MediaPlayer.create(requireContext(),R.raw.mouse_click_sound_effect)
            mediaPlayerClick?.start()
            dialog.dismiss()
            mathGameViewModel.playTimer()
            view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.playAnimation()

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
                            0 -> mathGameViewModel.questionsList[currentPosition].option1
                            1 -> mathGameViewModel.questionsList[currentPosition].option2
                            2 -> mathGameViewModel.questionsList[currentPosition].option3
                            3 -> mathGameViewModel.questionsList[currentPosition].options4
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
                                mathGameViewModel.questionsList.size
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
        mathGameViewModel.stopTimer()
        view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()

        binding.btnNext.isEnabled = true
        binding.btnNext.alpha = 1f
        if (mathGameViewModel.checkAnswer(selectedOption.text.toString())) {
            mediaPlayer = MediaPlayer.create(requireContext(),R.raw.correct_answer_sound_effects)
            mediaPlayer?.start()

            selectedOption.setBackgroundResource(R.drawable.correct)
        } else {
            mediaPlayer = MediaPlayer.create(requireContext(),R.raw.wrong_answer_sound)
            mediaPlayer?.start()

            selectedOption.setBackgroundResource(R.drawable.wrong)
            val correctOption =
                binding.optContainer.findViewWithTag(mathGameViewModel.questionsList[currentPosition].correctAnswer) as Button
            correctOption.setBackgroundResource(R.drawable.correct)
        }

    }


    override fun onResume() {
        super.onResume()

        if (gameSoundViewModel.isSoundOn.value == true){
            gameSoundViewModel.mediaPlayer?.start()
        }

    }

}