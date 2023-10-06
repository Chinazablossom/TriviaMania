package com.example.triviamania.Screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.triviamania.R
import com.example.triviamania.databinding.FragmentAndroidgameBinding

class AndroidGame_Fragment : Fragment() {

    private lateinit var binding: FragmentAndroidgameBinding

    data class Question(
        val text: String,
        val answers: List<String>)

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")),
        Question(
            text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")),
        Question(
            text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")),
        Question(
            text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")),
        Question(text = "Inflate layout in fragments?",
            answers = listOf("onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout")),

        Question(text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")),

        Question(text = "Android vector format?",
            answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")),

        Question(text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")),

        Question(text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")),

        Question(text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")),

        Question(text ="What does \"APK\" stand for in Android app development?" ,
            answers = listOf( "Android Package Kit", "Application Programming Kernel", "App Play Store Kit", "Android Programming Language")),

        Question(text = "Which version of Android introduced the \"Material Design\" visual language?",
            answers = listOf("Android Lollipop","Android Jelly Bean","Android KitKat","Android Ice Cream Sandwich")),

        Question(text = "What is the Android operating system's mascot?", answers = listOf("Bugdroid","Droid","Green Alien","RoboBot")),

        Question(text = "Which component of Android is responsible for managing app lifecycles and user interfaces?",
            answers = listOf("Activity", "Service", "BroadcastReceiver" ,"ContentProvider")),

        Question(text = "What is the primary purpose of an \"IMEI\" number on an Android device?",
            answers = listOf( "Identifying the device's unique hardware","Identifying the device manufacturer" ,"Identifying the device's operating system" ,"Identifying the device's owner")),

        Question(text = "Which Google service is used for backing up and synchronizing Android device data?",
            answers = listOf("Google Drive","Google Maps","Google Photos","Google Translate")),

        Question(text = "In Android, what does \"ADB\" stand for?",
            answers = listOf("Android Debug Bridge","Android Development Bundle","Android Device Backup","Android Data Backup")),

        Question(text = "Which Android version was codenamed \"Marshmallow\"?",
            answers = listOf("Android 6.0","Android 5.0","Android 7.0","Android 8.0")),

        Question(text = "What is the name of the Android runtime that allows apps to run in a sandboxed environment for security?",
            answers = listOf( "Dalvik Virtual Machine (DVM)","Java Runtime Environment (JRE)","Android Sandbox Environment (ASE)","Android Application Environment (AAE)")
        )





    )


    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentAndroidgameBinding.inflate(inflater,container,false)
        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()
        // Set the onClickListener for the submitButton
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }


}
