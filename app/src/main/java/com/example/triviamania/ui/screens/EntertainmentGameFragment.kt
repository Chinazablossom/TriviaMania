package com.example.triviamania.ui.screens

import android.animation.Animator
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentEntertainmentGameBinding
import com.example.triviamania.viewModels.GameSoundViewModel
import com.example.triviamania.viewModels.GamesViewModel
import com.example.triviamania.viewModels.SoundViewModel

class EntertainmentGameFragment : Fragment() {
    private val entertainmentGameViewModel: GamesViewModel by viewModels()
    private val soundViewModel: SoundViewModel by activityViewModels()
    private val gameSoundViewModel: GameSoundViewModel by activityViewModels()
    private var mediaPlayer: MediaPlayer? = null
    private var mediaPlayerClick: MediaPlayer? = null
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
            soundViewModel.setSoundOn(false)
            gameSoundViewModel.setSoundOn(true)

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

            skipBtn.setOnClickListener {
                mediaPlayerClick =
                    MediaPlayer.create(requireContext(), R.raw.mouse_click_sound_effect)
                mediaPlayerClick?.start()

                entertainmentGameViewModel.skipQuestion()

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


                if (currentPosition >= entertainmentGameViewModel.questionsList.size) {
                    gameSoundViewModel.setSoundOn(false)
                    soundViewModel.setSoundOn(true)

                    findNavController().navigate(
                        R.id.resultsFragment,
                        bundleOf(
                            "result" to entertainmentGameViewModel.score.value,
                            "total" to entertainmentGameViewModel.questionsList.size,
                            "skipped" to entertainmentGameViewModel.skipped.value,
                            "goto" to R.id.entertainmentFragment


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



            btnNext.setOnClickListener {
                mediaPlayerClick =
                    MediaPlayer.create(requireContext(), R.raw.mouse_click_sound_effect)
                mediaPlayerClick?.start()

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
                    gameSoundViewModel.setSoundOn(false)
                    soundViewModel.setSoundOn(true)

                    findNavController().navigate(
                        R.id.resultsFragment,
                        bundleOf(
                            "result" to entertainmentGameViewModel.score.value,
                            "total" to entertainmentGameViewModel.questionsList.size,
                            "skipped" to entertainmentGameViewModel.skipped.value
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
            mediaPlayerClick = MediaPlayer.create(requireContext(), R.raw.mouse_click_sound_effect)
            mediaPlayerClick?.start()
            gameSoundViewModel.setSoundOn(false)
            soundViewModel.setSoundOn(true)

            findNavController().popBackStack(R.id.entertainmentFragment, false)
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun showQuitDialog() {
        entertainmentGameViewModel.stopTimer()
        view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()

        val dialog = Dialog(requireContext())
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.quit_dialogue)

        dialog.findViewById<View>(R.id.yesbtn).setOnClickListener {
            mediaPlayerClick = MediaPlayer.create(requireContext(), R.raw.mouse_click_sound_effect)
            mediaPlayerClick?.start()

            findNavController().popBackStack(R.id.entertainmentFragment, false)
            gameSoundViewModel.setSoundOn(false)
            soundViewModel.setSoundOn(true)
            dialog.dismiss()
        }

        dialog.findViewById<View>(R.id.nobtn).setOnClickListener {
            mediaPlayerClick = MediaPlayer.create(requireContext(), R.raw.mouse_click_sound_effect)
            mediaPlayerClick?.start()

            dialog.dismiss()
            entertainmentGameViewModel.playTimer()
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
                    } else if (value == 1 && view is Button) {
                        val options = mutableListOf<Button>()
                        for (i in 0 until binding.optContainer.childCount) {
                            val optionButton = binding.optContainer.getChildAt(i) as Button
                            options.add(optionButton)
                        }
                        options.shuffle()
                        binding.optContainer.removeAllViews()
                        for (optionButton in options) {
                            binding.optContainer.addView(optionButton)
                        }
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
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.correct_answer_sound_effects)
            mediaPlayer?.start()

            selectedOption.setBackgroundResource(R.drawable.correct)
        } else {
            mediaPlayer = MediaPlayer.create(requireContext(), R.raw.wrong_answer_sound)
            mediaPlayer?.start()

            selectedOption.setBackgroundResource(R.drawable.wrong)
            val correctOption =
                binding.optContainer.findViewWithTag(entertainmentGameViewModel.questionsList[currentPosition].correctAnswer) as Button
            correctOption.setBackgroundResource(R.drawable.correct)
        }

    }

    override fun onResume() {
        super.onResume()

        if (gameSoundViewModel.isSoundOn.value == true) {
            gameSoundViewModel.mediaPlayer?.start()
        }

    }

}