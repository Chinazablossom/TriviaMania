package com.example.triviamania.ui.Fragments

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
import com.example.triviamania.databinding.FragmentAndroidgameBinding
import com.example.triviamania.viewModels.GameViewModel

class AndroidGameFragment : Fragment() {
    private val androidGameViewModel: GameViewModel by viewModels()

    private lateinit var binding: FragmentAndroidgameBinding
    private var count = 0
    private var currentPosition = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAndroidgameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            androidGameViewModel.position.observe(viewLifecycleOwner) {
                currentPosition = it
            }

            androidGameViewModel.currentTimeLeft.observe(viewLifecycleOwner) {
                counterTv.text = requireContext().getString(R.string.timer, it)
                if (it == 10L) counterTv.setTextColor(Color.RED)
            }

            androidGameViewModel.isGameOver.observe(viewLifecycleOwner) {
                if (it) {
                    showTimeUpDialog()
                }
            }
            if (savedInstanceState == null) {
                androidGameViewModel.resetTimer()
                counterTv.setTextColor(Color.BLACK)
            }

            if (savedInstanceState != null) {
                currentPosition = savedInstanceState.getInt("position", 0)
            }


            when (arguments?.getString("Key")) {
                "Stage 1" -> {
                    androidGameViewModel.androidStageOne()

                }

                "Stage 2" -> {
                    androidGameViewModel.stageTwo()
                }

                "Stage 3" -> {
                    androidGameViewModel.stageThree()
                }

                "Stage 4" -> {
                    androidGameViewModel.stageFour()
                }

                "Stage 5" -> {
                    androidGameViewModel.stageFive()
                }

                "Stage 6" -> {
                    androidGameViewModel.stageSix()
                }

                "Stage 7" -> {
                    androidGameViewModel.stageSeven()
                }

                "Stage 8" -> {
                    androidGameViewModel.stageEight()
                }

                "Stage 9" -> {
                    androidGameViewModel.stageNine()
                }

                "Stage 10" -> {
                    androidGameViewModel.stageTen()
                }

                "Stage 11" -> {
                    androidGameViewModel.stageEleven()
                }

                "Stage 12" -> {
                    androidGameViewModel.stageTwelve()
                }

                "Stage 13" -> {
                    androidGameViewModel.stageThirteen()
                }

                "Stage 14" -> {
                    androidGameViewModel.stageFourteen()
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
                androidGameViewModel.androidQuestionsList[currentPosition].question
            )
            btnNext.setOnClickListener {
                if (savedInstanceState == null) {
                    androidGameViewModel.resetTimer()
                    view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)
                        ?.pauseAnimation()

                }

                androidGameViewModel.resetTimer()
                counterTv.setTextColor(Color.BLACK)
                view.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.playAnimation()

                btnNext.isEnabled = false
                btnNext.alpha = 0.3f
                enableOption(true)
                androidGameViewModel.increasePosition()

                if (currentPosition == androidGameViewModel.androidQuestionsList.size) {
                    findNavController().navigate(
                        R.id.resultsFragment,
                        bundleOf(
                            "result" to androidGameViewModel.score.value,
                            "total" to androidGameViewModel.androidQuestionsList.size
                        )
                    )

                    return@setOnClickListener
                }
                count = 0
                playAnimation(
                    QuestionTv,
                    0,
                    androidGameViewModel.androidQuestionsList[currentPosition].question
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
                binding.optContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt)
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
                            0 -> androidGameViewModel.androidQuestionsList[currentPosition].option1
                            1 -> androidGameViewModel.androidQuestionsList[currentPosition].option2
                            2 -> androidGameViewModel.androidQuestionsList[currentPosition].option3
                            3 -> androidGameViewModel.androidQuestionsList[currentPosition].options4
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
                                androidGameViewModel.androidQuestionsList.size
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
        androidGameViewModel.stopTimer()
        view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()

        binding.btnNext.isEnabled = true
        binding.btnNext.alpha = 1f
        if (androidGameViewModel.checkAnswer(selectedOption.text.toString())) {
            selectedOption.setBackgroundResource(R.drawable.correct)
        } else {
            selectedOption.setBackgroundResource(R.drawable.wrong)
            val correctOption =
                binding.optContainer.findViewWithTag(androidGameViewModel.androidQuestionsList[currentPosition].correctAnswer) as Button
            correctOption.setBackgroundResource(R.drawable.correct)
        }

    }


}

/*  private fun checkAnswer(selectedOption: Button) {
      if (timer != null) {
          timer!!.cancel()
          view?.findViewById<LottieAnimationView>(R.id.lottieAnimationView2)?.pauseAnimation()
      }


      binding.btnNext.isEnabled = true
      binding.btnNext.alpha = 1f


      if (selectedOption.text.toString() == androidGameViewModel.androidQuestionsList[position].correctAnswer) {
          score++
          selectedOption.setBackgroundResource(R.drawable.correct)
      } else {
          selectedOption.setBackgroundResource(R.drawable.wrong)
          val correctOption = binding.optContainer.findViewWithTag(androidGameViewModel.androidQuestionsList[position].correctAnswer) as Button
          correctOption.setBackgroundResource(R.drawable.correct)
      }
  }*/


/* private fun resetTimer() {

     timer = object : CountDownTimer(30000, 1000) {
         override fun onTick(millisUntilFinished: Long) {
             binding.counterTv.text =
                 requireContext().getString(R.string.timer, millisUntilFinished / 1000)
             if (binding.counterTv.text == "10") {
                 binding.counterTv.setTextColor(Color.RED)
             }
         }

         override fun onFinish() {
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


     }


 }*/
