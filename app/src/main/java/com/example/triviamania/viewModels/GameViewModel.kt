package com.example.triviamania.viewModels

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triviamania.Models.QuestionsModel

class GameViewModel:ViewModel() {
    val androidQuestionsList = ArrayList<QuestionsModel>()
    private var _score = MutableLiveData(0)
    val score: LiveData<Int> get() = _score
    private var _position = MutableLiveData(0)
    val position:LiveData<Int>  get() = _position
    private val _currentTimeLeft = MutableLiveData(30L)
    val currentTimeLeft: LiveData<Long> get() = _currentTimeLeft
    private var timer: CountDownTimer? = null
    private val _isGameOver = MutableLiveData(false)
    val isGameOver: LiveData<Boolean> get() = _isGameOver


     private fun startTimer() {
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _currentTimeLeft.value = millisUntilFinished / 1000
            }

            override fun onFinish() {
                _isGameOver.value = true
            }
        }
        timer?.start()
    }
    fun stopTimer() {
        timer?.cancel()
        _isGameOver.value = false
    }
    fun resetTimer() {
        timer?.cancel()
        _currentTimeLeft.value = 30L
        _isGameOver.value = false
        startTimer()
    }
    fun increasePosition() {
        _position.value = (_position.value)?.plus(1)
    }
     private fun increaseScore() {
        _score.value = (_score.value)?.plus(1)
    }
    fun checkAnswer(selectedOption: String): Boolean {
        val currentPosition = _position.value ?: 0

        if (selectedOption == androidQuestionsList[currentPosition].correctAnswer) {
            increaseScore()
            return true
        }
        return false
    }











    fun androidStageOne() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What does XML stand for in Android development?",
                "Extensible Markup Language",
                "Extra Modern Language",
                "Extended Mobile Language",
                "Extreme Makeup Language",
                "Extensible Markup Language"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the main purpose of an Android Intent?",
                "To perform a background task",
                "To start a new activity or service",
                "To define the layout of an activity",
                "To manage database operations",
                "To start a new activity or service"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which component is responsible for handling user interface interactions in Android?",
                "Activity",
                "Service",
                "BroadcastReceiver",
                "ContentProvider",
                "Activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android emulator?",
                "To make phone calls",
                "To test Android apps on different devices",
                "To play games",
                "To browse the web",
                "To test Android apps on different devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which layout is used to arrange elements in a row or column, one after another, vertically or horizontally?",
                "ConstraintLayout",
                "LinearLayout",
                "RelativeLayout",
                "FrameLayout",
                "LinearLayout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an APK in Android?",
                "Android Packaging Kit",
                "Application Package Kit",
                "Android Program Kit",
                "Application Programming Kit",
                "Application Package Kit"
            )
        )
/*        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "In Android, what is the purpose of an Activity?",
                "To perform background tasks",
                "To manage data storage",
                "To define the user interface and handle user interactions",
                "To send SMS messages",
                "To define the user interface and handle user interactions"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which XML file is used to declare the user interface layout for an Android Activity?",
                "AndroidManifest.xml",
                "activity_main.xml",
                "layout.xml",
                "interface.xml",
                "activity_main.xml"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the entry point of an Android application?",
                "MainActivity.java",
                "Application.java",
                "AndroidManifest.xml",
                "LauncherActivity.java",
                "AndroidManifest.xml"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the primary function of the AndroidManifest.xml file?",
                "To define the layout of the app's user interface",
                "To specify the app's icon",
                "To declare the app's components and their attributes",
                "To store user data",
                "To declare the app's components and their attributes"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which class is the base class for all Android activities?",
                "Activity",
                "AppCompatActivity",
                "FragmentActivity",
                "BaseActivity",
                "Activity"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the purpose of the 'res' folder in an Android project?",
                "To store Java source code",
                "To store binary files",
                "To store resources like layouts, images, and XML files",
                "To store database files",
                "To store resources like layouts, images, and XML files"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the primary purpose of the 'gradle' folder in an Android project?",
                "To store Java source code",
                "To store binary files",
                "To store Gradle build scripts and configuration files",
                "To store resources like layouts and images",
                "To store Gradle build scripts and configuration files"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which programming language is primarily used for Android app development?",
                "Java Script",
                "C++",
                "Python",
                "Kotlin",
                "Kotlin"
            )
        )*/
       /* this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the Android operating system based on?",
                "Linux",
                "Windows",
                "iOS",
                "macOS",
                "Linux"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the name of the Android development tool provided by Google?",
                "Xcode",
                "Android Studio",
                "Eclipse",
                "Visual Studio",
                "Android Studio"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which file extension is used for Android layout files?",
                ".xml",
                ".layout",
                ".java",
                ".apk",
                ".xml"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What does ADB stand for in Android development?",
                "Android Debug Bridge",
                "Android Data Backup",
                "Android Development Box",
                "Android Database",
                "Android Debug Bridge"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which tool is used to create a new Android project in Android Studio?",
                "AVD Manager",
                "Gradle Build Tool",
                "SDK Manager",
                "New Project Wizard",
                "New Project Wizard"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which Android component is responsible for long-running background tasks?",
                "Activity",
                "Service",
                "BroadcastReceiver",
                "ContentProvider",
                "Service"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the purpose of the 'R' class in Android?",
                "To define the app's resources",
                "To define the app's permissions",
                "To define the app's activities",
                "To define the app's layouts",
                "To define the app's resources"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is an APK in Android?",
                "Android Packaging Kit",
                "Application Package Kit",
                "Android Program Kit",
                "Application Programming Kit",
                "Application Package Kit"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which Android component is responsible for managing data storage and retrieval?",
                "Activity",
                "Service",
                "BroadcastReceiver",
                "ContentProvider",
                "ContentProvider"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the name of the Android Virtual Device manager?",
                "AVD Manager",
                "SDK Manager",
                "Android Emulator",
                "Android Debug Bridge",
                "AVD Manager"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which programming language was introduced as an official language for Android app development in 2017?",
                "Java",
                "C++",
                "Python",
                "Kotlin",
                "Kotlin"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the minimum Android API level required for Android app development?",
                "API level 10 (Android 2.3.3)",
                "API level 16 (Android 4.1)",
                "API level 21 (Android 5.0)",
                "API level 28 (Android 9)",
                "API level 16 (Android 4.1)"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the Android framework responsible for managing UI components?",
                "Activity Manager",
                "View System",
                "Resource Manager",
                "Package Manager",
                "View System"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the Android framework component that manages the application's database?",
                "Activity",
                "Service",
                "BroadcastReceiver",
                "ContentProvider",
                "ContentProvider"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is an Intent in Android?",
                "A layout file", "A user interface component",
                "A database table",
                "A message passing mechanism",
                "A message passing mechanism"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is a Fragment in Android?",
                "A layout file", "A user interface component",
                "A database table",
                "A modular section of an activity",
                "A modular section of an activity"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is Android's official integrated development environment (IDE)?",
                "Android Studio",
                "Eclipse",
                "IntelliJ IDEA",
                "Visual Studio",
                "Android Studio"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the name of the Android package manager?",
                "Android Package Manager (APM)",
                "Android App Installer",
                "Package Manager for Android (PMA)",
                "Google Play",
                "Android Package Manager (APM)"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the main purpose of an Android Fragment?",
                "To manage background services",
                "To represent a portion of a user interface or behavior in an Activity",
                "To handle broadcast events",
                "To provide content to ContentProviders",
                "To represent a portion of a user interface or behavior in an Activity"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which Android component is used for inter-process communication (IPC)?",
                "Activity",
                "Service",
                "BroadcastReceiver",
                "ContentProvider",
                "ContentProvider"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which layout manager can be used to create a scrollable list of items in Android?",
                "LinearLayout",
                "RelativeLayout",
                "RecyclerView",
                "FrameLayout",
                "RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the term for a pre-defined set of styles and themes that can be applied to an Android app?",
                "Design pattern",
                "App framework",
                "Material Design",
                "AppCompat",
                "Material Design"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which Android component is used to display a pop-up message to the user?",
                "AlertDialog",
                "Toast",
                "Snackbar",
                "Notification",
                "Toast"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the Android Support Library (AndroidX) used for?",
                "Managing device hardware",
                "Providing backward compatibility for new Android features",
                "Creating user interfaces",
                "Debugging Android apps",
                "Providing backward compatibility for new Android features"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "Which tool is used to build user interfaces for Android apps using a drag-and-drop interface?",
                "Android Studio",
                "Android XML Editor",
                "Android Layout Designer",
                "Android UI Builder",
                "Android Layout Designer"
            )
        )
        this.androidQuestionsList.add(
            AndroidQuestionsModel(
                "What is the term for a reusable Android user interface component that can be included within layouts?",
                "Fragment",
                "Module",
                "Widget",
                "Library",
                "Widget"
            )
        )*/

        androidQuestionsList.shuffle()


    }
    fun stageTwo() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "Which folder is used to store image and media files in an Android project?",
                "res/drawable",
                "res/values",
                "res/layout",
                "res/raw",
                "res/raw"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which class is used to create a database in Android?",
                "DatabaseHelper",
                "DatabaseManager",
                "DatabaseFactory",
                "DatabaseCreator",
                "DatabaseHelper"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SharedPreferences class?",
                "To store and retrieve key-value pairs of primitive data types",
                "To store and retrieve images",
                "To store and retrieve database records",
                "To store and retrieve app layouts",
                "To store and retrieve key-value pairs of primitive data types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SQLite database?",
                "To display ads in the app",
                "To store structured data in a private database",
                "To store app icons",
                "To create user interfaces",
                "To store structured data in a private database"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android resource directory 'values' used for?",
                "To store app layouts",
                "To store text strings, colors, and dimensions",
                "To store image resources",
                "To store audio files",
                "To store text strings, colors, and dimensions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android layout inflater used for?",
                "To blow up balloons for a party",
                "To create a new Android app",
                "To parse XML layout files and create View objects",
                "To install new apps on a device",
                "To parse XML layout files and create View objects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android OnClickListener interface?",
                "To listen to music in the app",
                "To define app permissions",
                "To handle user interactions with UI elements",
                "To draw images on the screen",
                "To handle user interactions with UI elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Toast?",
                "A type of bread",
                "A small notification message displayed briefly on the screen",
                "A music player app",
                "A type of layout",
                "A small notification message displayed briefly on the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ActionBar?",
                "To build the Android operating system",
                "To manage app resources",
                "To provide an app bar for navigation and actions",
                "To create database tables",
                "To provide an app bar for navigation and actions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android AsyncTask?",
                "To make phone calls",
                "To perform background tasks on a separate thread",
                "To display ads in the app",
                "To manage app permissions",
                "To perform background tasks on a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Gradle?",
                "A type of Android phone",
                "A build tool used for Android app development",
                "A file format for Android layouts",
                "An Android emulator",
                "A build tool used for Android app development"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Resource Qualifiers?",
                "To qualify for app development",
                "To define app layouts",
                "To specify alternative resources for different device configurations",
                "To determine app permissions",
                "To specify alternative resources for different device configurations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Fragment?",
                "A fragment of a song",
                "A reusable portion of an activity's user interface",
                "A type of app icon",
                "A type of layout file",
                "A reusable portion of an activity's user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android View?",
                "A beautiful scene in nature",
                "A graphical user interface component",
                "A type of Android device",
                "A type of music player",
                "A graphical user interface component"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Manifest Merger tool?",
                "To merge app layout files",
                "To merge Android app packages",
                "To merge AndroidManifest.xml files from libraries and the main app module",
                "To merge Android resource files",
                "To merge AndroidManifest.xml files from libraries and the main app module"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SDK Manager used for?",
                "To manage the app database",
                "To manage device settings",
                "To manage Android SDK components and updates",
                "To manage app layouts",
                "To manage Android SDK components and updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Intent Filter?",
                "To filter incoming phone calls",
                "To filter incoming messages",
                "To specify which components can respond to an intent",
                "To filter app resources",
                "To specify which components can respond to an intent"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android UI thread?",
                "A physical thread in an Android device",
                "A thread for performing background tasks",
                "The main thread responsible for UI interactions",
                "A type of UI component",
                "The main thread responsible for UI interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewGroup?",
                "A type of Android app",
                "A class used to create background threads",
                "A view that can contain other views",
                "A type of Android layout",
                "A view that can contain other views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Canvas class?",
                "To store app data",
                "To provide an app's user interface",
                "To draw graphics on a View",
                "To create database tables",
                "To draw graphics on a View"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Drawable resource?",
                "An image resource used for backgrounds and other UI elements",
                "A background music file",
                "A database resource",
                "A layout resource",
                "An image resource used for backgrounds and other UI elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Application class used for?",
                "To make phone calls",
                "To create a new app",
                "To maintain global application state",
                "To manage app layouts",
                "To maintain global application state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android PackageManager class?",
                "To manage device settings",
                "To manage app resources",
                "To manage app installations and updates",
                "To create database tables",
                "To manage app installations and updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Gradle wrapper?",
                "A tool for wrapping Android devices",
                "A software tool for managing app resources",
                "A script that allows building Android projects without installing Gradle",
                "A software tool for testing apps",
                "A script that allows building Android projects without installing Gradle"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Toolbar?",
                "A physical tool used for Android development",
                "A graphical user interface component",
                "A music player app",
                "A hardware device for testing apps",
                "A graphical user interface component"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Shared Preferences?",
                "To share photos on social media",
                "To store and retrieve key-value pairs of primitive data types",
                "To manage device resources",
                "To create app layouts",
                "To store and retrieve key-value pairs of primitive data types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android RecyclerView used for?",
                "To play videos",
                "To display a list of items with dynamic data",
                "To manage app permissions",
                "To draw custom shapes on the screen",
                "To display a list of items with dynamic data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android CardView?",
                "To make phone calls",
                "To create custom cards for UI design",
                "To manage app resources",
                "To build the Android operating system",
                "To create custom cards for UI design"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android Broadcast Receiver?",
                "To broadcast messages to other apps",
                "To send text messages",
                "To create a new activity",
                "To handle UI interactions",
                "To broadcast messages to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Handler used for?",
                "To handle incoming phone calls",
                "To send and process messages and run code on a different thread",
                "To play music in the background",
                "To manage app layouts",
                "To send and process messages and run code on a different thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Logcat?",
                "To view app advertisements",
                "To display app icons",
                "To view and record logs generated by an app",
                "To create database tables",
                "To view and record logs generated by an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Gradle script?",
                "A script for making coffee",
                "A script for building and configuring Android app projects",
                "A script for playing music",
                "A script for creating database records",
                "A script for building and configuring Android app projects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is a ContentResolver in Android?",
                "A tool for resolving user disputes",
                "A component for managing device resources",
                "A class for accessing and modifying data from content providers",
                "A layout file for resolving UI issues",
                "A class for accessing and modifying data from content providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AsyncTaskLoader used for?",
                "To load images",
                "To load data on a separate thread and deliver results to the UI thread",
                "To create animations",
                "To play audio files",
                "To load data on a separate thread and deliver results to the UI thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is a FragmentTransaction in Android?",
                "A transaction involving money",
                "A transaction for managing app resources",
                "A transaction for adding, replacing, or removing fragments in an activity",
                "A transaction for creating new activities",
                "A transaction for adding, replacing, or removing fragments in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of an Android PreferenceFragment?",
                "To display user preferences in an activity",
                "To perform background tasks",
                "To manage app layouts",
                "To play music in the background",
                "To display user preferences in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the role of the Android ContentProvider?",
                "To play videos",
                "To store and retrieve structured data and share it with other apps",
                "To design app layouts",
                "To draw custom shapes on the screen",
                "To store and retrieve structured data and share it with other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android Context?",
                "To manage app permissions",
                "To provide access to application-specific resources and components",
                "To make phone calls",
                "To build the Android operating system",
                "To provide access to application-specific resources and components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationManager?",
                "To manage app resources",
                "To display notifications to the user",
                "To control the device's notifications",
                "To store app data",
                "To display notifications to the user"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BroadcastReceiver used for?",
                "To broadcast a message to other apps",
                "To send text messages",
                "To create a new activity",
                "To play music in the background",
                "To broadcast a message to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Material Design?",
                "A design concept for material objects",
                "A design language for creating a consistent, visually appealing user interface",
                "A design for manufacturing physical products",
                "A design for managing app permissions",
                "A design language for creating a consistent, visually appealing user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AdapterView?",
                "To view and edit databases",
                "To manage app layouts",
                "To provide a view for displaying items in a scrollable list",
                "To display app advertisements",
                "To provide a view for displaying items in a scrollable list"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentResolver used for?",
                "To resolve user disputes",
                "To manage device resources",
                "To query, insert, update, and delete data through a content provider",
                "To create app layouts",
                "To query, insert, update, and delete data through a content provider"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android HandlerThread?",
                "A thread for handling phone calls",
                "A thread for handling app layouts",
                "A thread for handling messages on a separate thread",
                "A type of layout in Android",
                "A thread for handling messages on a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Loader class?",
                "To load apps into memory",
                "To load data from a content provider asynchronously",
                "To create app advertisements",
                "To create new activities",
                "To load data from a content provider asynchronously"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android FrameLayout used for?",
                "To frame photos",
                "To create animation frames",
                "To contain a single item or fragment",
                "To manage app permissions",
                "To contain a single item or fragment"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SQLiteOpenHelper used for?",
                "To help with SQLite database operations",
                "To create animations",
                "To design app layouts",
                "To play music in the background",
                "To help with SQLite database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ActionBarDrawerToggle?",
                "A toggle switch for the app bar",
                "A drawer toggle for app navigation",
                "A switch for turning off advertisements",
                "A tool for managing app resources",
                "A drawer toggle for app navigation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android AutoCompleteTextView used for?",
                "To view the auto complete list",
                "To send text messages",
                "To provide auto-completion suggestions as the user types",
                "To create animations",
                "To provide auto-completion suggestions as the user types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of an Android DatePicker?",
                "To pick dates for a calendar app",
                "To select app layouts",
                "To display images",
                "To manage app permissions",
                "To pick dates for a calendar app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ContentObserver?",
                "A type of app icon",
                "An observer for content changes in a content provider",
                "An observer for device settings",
                "A tool for content creation",
                "An observer for content changes in a content provider"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Spinner?",
                "A physical spinning device",
                "A graphical user interface component for selecting items from a list",
                "A music player app",
                "A hardware testing tool",
                "A graphical user interface component for selecting items from a list"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ScrollView?",
                "To display app icons",
                "To create animations",
                "To scroll through a single view that is too large for the screen",
                "To send and receive messages",
                "To scroll through a single view that is too large for the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Support Library used for?",
                "To support library books",
                "To provide backward compatibility for new features on older Android versions",
                "To play music in the background",
                "To create database tables",
                "To provide backward compatibility for new features on older Android versions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android FileProvider used for?",
                "To provide file storage services",
                "To play videos",
                "To generate QR codes",
                "To share files with other apps",
                "To share files with other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ContentResolver?",
                "To manage app layouts",
                "To resolve user disputes",
                "To interact with a content provider to access and manipulate data",
                "To control device notifications",
                "To interact with a content provider to access and manipulate data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android TextToSpeech class used for?",
                "To send text messages",
                "To generate speech from text",
                "To display advertisements",
                "To play music in the background",
                "To generate speech from text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android AppWidget?",
                "A widget for arranging apps",
                "A component for playing games",
                "A small, interactive component displayed on the home screen",
                "A tool for managing app resources",
                "A small, interactive component displayed on the home screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SearchView used for?",
                "To create search queries",
                "To send and receive messages",
                "To provide a search interface in the app bar",
                "To display images",
                "To provide a search interface in the app bar"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Canvas used for?",
                "To create a drawing canvas for artists",
                "To store app data",
                "To draw graphics on a Bitmap or View",
                "To create database tables",
                "To draw graphics on a Bitmap or View"
            )
        )

        androidQuestionsList.shuffle()

    }
    fun stageThree() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What is ProGuard in Android development used for?",
                "To guard against software piracy",
                "To encrypt app data",
                "To minimize and obfuscate code for security and size optimization",
                "To develop app UI",
                "To minimize and obfuscate code for security and size optimization"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of an Android FragmentTransaction?",
                "To display ads in an app",
                "To add, replace, or remove fragments in an activity",
                "To create app layouts",
                "To broadcast messages to other apps",
                "To add, replace, or remove fragments in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android LoaderManager?",
                "A manager for loading Android apps",
                "A component for managing app permissions",
                "A system for managing loaders that load data asynchronously",
                "A layout manager for UI design",
                "A system for managing loaders that load data asynchronously"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Service?",
                "A background task that requires user interaction",
                "A long-running operation without a user interface",
                "A user interface component",
                "A type of Android device",
                "A long-running operation without a user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of an Android BroadcastReceiver?",
                "To handle UI interactions",
                "To send text messages",
                "To listen for and react to system-wide broadcast intents",
                "To create app layouts",
                "To listen for and react to system-wide broadcast intents"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobScheduler used for?",
                "To schedule app updates",
                "To schedule background tasks based on various conditions",
                "To schedule alarm clock events",
                "To play music in the background",
                "To schedule background tasks based on various conditions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android HandlerThread used for?",
                "A type of thread for background tasks",
                "A user interface thread",
                "A thread for handling user interactions",
                "A type of layout in Android",
                "A type of thread for background tasks"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of an Android Intent Filter?",
                "To filter incoming phone calls",
                "To specify which components can respond to an intent",
                "To create new activities",
                "To display advertisements",
                "To specify which components can respond to an intent"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ActionBar used for?",
                "To manage app layouts",
                "To provide an app bar for navigation and actions",
                "To manage device resources",
                "To create database tables",
                "To provide an app bar for navigation and actions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaPlayer used for?",
                "To manage media files",
                "To create animations",
                "To manage device settings",
                "To design app layouts",
                "To manage media files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SQLiteDatabase class used for?",
                "To access and manage shared preferences",
                "To interact with an SQLite database",
                "To create app layouts",
                "To play music in the background",
                "To interact with an SQLite database"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android LocationManager used for?",
                "To manage device resources",
                "To manage app layouts",
                "To retrieve location data from GPS or network providers",
                "To display app icons",
                "To retrieve location data from GPS or network providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ContentProvider used for?",
                "To play videos",
                "To provide content to other apps and share data",
                "To manage app permissions",
                "To create database records",
                "To provide content to other apps and share data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SharedPreferences class used for?",
                "To store app layouts",
                "To store and retrieve key-value pairs of primitive data types",
                "To display ads in the app",
                "To create animations",
                "To store and retrieve key-value pairs of primitive data types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Handler class?",
                "To handle UI interactions",
                "To perform background tasks",
                "To send and process messages on the UI thread",
                "To create new layouts",
                "To send and process messages on the UI thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WebView used for?",
                "To view app layouts",
                "To create database tables",
                "To display web content within an app",
                "To play music in the background",
                "To display web content within an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewStub used for?",
                "To draw custom shapes on the screen",
                "To perform background tasks",
                "To define a placeholder in a layout for loading another view",
                "To create app advertisements",
                "To define a placeholder in a layout for loading another view"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationCompat class?",
                "To create app icons",
                "To handle device notifications with backward compatibility",
                "To play videos",
                "To design app layouts",
                "To handle device notifications with backward compatibility"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SQLiteOpenHelper used for?",
                "To create animations",
                "To help with SQLite database operations, including creating and upgrading the database",
                "To manage app resources",
                "To display advertisements",
                "To help with SQLite database operations, including creating and upgrading the database"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android CursorLoader used for?",
                "To load app resources",
                "To load data from a content provider into a cursor asynchronously",
                "To load images from the internet",
                "To manage app permissions",
                "To load data from a content provider into a cursor asynchronously"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of an Android CursorAdapter?",
                "To display a cursor on the screen",
                "To manage device resources",
                "To bind data from a cursor to views in a ListView",
                "To create app layouts",
                "To bind data from a cursor to views in a ListView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android DialogFragment used for?",
                "To create dialog boxes",
                "To play music in the background",
                "To create database records",
                "To manage app permissions",
                "To create dialog boxes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaCodec used for?",
                "To display video ads",
                "To encode and decode media data, such as audio and video",
                "To manage device settings",
                "To design app layouts",
                "To encode and decode media data, such as audio and video"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AlarmManager used for?",
                "To manage device alarms",
                "To create new layouts",
                "To schedule tasks or events to happen at specific times",
                "To display app icons",
                "To schedule tasks or events to happen at specific times"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android GridLayout used for?",
                "To create app layouts",
                "To manage device resources",
                "To design grid-based layouts with rows and columns",
                "To play music in the background",
                "To design grid-based layouts with rows and columns"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WindowManager used for?",
                "To manage window cleaning",
                "To manage app layouts",
                "To add and control views within the window of an Android application",
                "To send and receive text messages",
                "To add and control views within the window of an Android application"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Adapter used for?",
                "To adapt to new devices",
                "To send messages between apps",
                "To connect data with user interface elements like ListView or GridView",
                "To create database tables",
                "To connect data with user interface elements like ListView or GridView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Application class used for?",
                "To create new apps",
                "To make phone calls",
                "To maintain global application state",
                "To manage app layouts",
                "To maintain global application state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android PendingIntent?",
                "A type of intent for sending text messages",
                "A description of a future event to be executed at a later time",
                "A special type of view",
                "A tool for drawing on the screen",
                "A description of a future event to be executed at a later time"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ProgressBar used for?",
                "To display progress in installing apps",
                "To show progress of an ongoing operation",
                "To create animations",
                "To display app icons",
                "To show progress of an ongoing operation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WebViewClient used for?",
                "To view web pages in an app",
                "To manage app resources",
                "To display advertisements",
                "To play music in the background",
                "To view web pages in an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Handler.Callback interface used for?",
                "To handle callback requests from the server",
                "To define app layouts",
                "To implement message handling in a Handler",
                "To send and receive emails",
                "To implement message handling in a Handler"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WebView used for?",
                "To design web pages",
                "To display web content within an app",
                "To create new layouts",
                "To manage device settings",
                "To display web content within an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SurfaceView used for?",
                "To create database records",
                "To display video with custom drawing in a separate thread",
                "To manage app permissions",
                "To play music in the background",
                "To display video with custom drawing in a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android IntentService used for?",
                "To start an activity",
                "To perform background tasks with automatic intent handling",
                "To create app icons",
                "To design app layouts",
                "To perform background tasks with automatic intent handling"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentValues class used for?",
                "To manage content access permissions",
                "To manage app resources",
                "To store key-value pairs for database operations",
                "To create app layouts",
                "To store key-value pairs for database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ProgressDialog used for?",
                "To create a progress dialog",
                "To design app layouts",
                "To create animations",
                "To manage device resources",
                "To create a progress dialog"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SoundPool used for?",
                "To manage app layouts",
                "To create database tables",
                "To play a large number of short audio clips",
                "To display advertisements",
                "To play a large number of short audio clips"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AudioManager used for?",
                "To play videos",
                "To manage audio settings and control audio playback",
                "To send text messages",
                "To manage app permissions",
                "To manage audio settings and control audio playback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Parcelable used for?",
                "To display ads in an app",
                "To pass complex data between processes using serialization",
                "To manage app resources",
                "To create new activities",
                "To pass complex data between processes using serialization"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android AlarmReceiver used for?",
                "To receive alarms",
                "To create custom alarms",
                "To schedule periodic tasks and receive broadcast intents",
                "To design app layouts",
                "To schedule periodic tasks and receive broadcast intents"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ViewFlipper?",
                "To flip views in a 3D space",
                "To manage device resources",
                "To animate a series of views on the screen",
                "To play music in the background",
                "To animate a series of views on the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android VectorDrawable used for?",
                "To draw vector graphics",
                "To create database records",
                "To play videos",
                "To manage app permissions",
                "To draw vector graphics"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Canvas used for?",
                "To store app data",
                "To create animations",
                "To draw graphics on a View",
                "To create database tables",
                "To draw graphics on a View"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android TouchEvent used for?",
                "To touch the screen and interact with elements",
                "To create music playlists",
                "To manage app layouts",
                "To display advertisements",
                "To touch the screen and interact with elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android RecyclerView.Adapter used for?",
                "To display recycler views",
                "To adapt data to a RecyclerView",
                "To create app icons",
                "To design app layouts",
                "To adapt data to a RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AccessibilityService used for?",
                "To improve app accessibility for users with disabilities",
                "To create custom layouts",
                "To manage app resources",
                "To play music in the background",
                "To improve app accessibility for users with disabilities"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Toast notification used for?",
                "To toast bread",
                "To display a brief message to the user",
                "To schedule alarms",
                "To create app advertisements",
                "To display a brief message to the user"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SwipeRefreshLayout used for?",
                "To create swipe gestures",
                "To refresh a view with a swipe gesture",
                "To design app layouts",
                "To manage device settings",
                "To refresh a view with a swipe gesture"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BroadcastReceiver used for?",
                "To send broadcast messages to other apps",
                "To receive broadcasted messages and react to them",
                "To create a new activity",
                "To play music in the background",
                "To receive broadcasted messages and react to them"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ADB (Android Debug Bridge) used for?",
                "To debug Android apps",
                "To build Android apps",
                "To create app layouts",
                "To send and receive text messages",
                "To debug Android apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ViewBinder used for?",
                "To create database tables",
                "To bind data to views in a ListView",
                "To view images in an app",
                "To manage app permissions",
                "To bind data to views in a ListView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentProviderClient used for?",
                "To provide content to other apps",
                "To play videos",
                "To manage app resources",
                "To store app data",
                "To provide content to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android FrameLayout used for?",
                "To frame photos",
                "To create animations",
                "To contain a single item or fragment",
                "To manage app permissions",
                "To contain a single item or fragment"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android TimePicker used for?",
                "To select a time in a clock app",
                "To design app layouts",
                "To display app icons",
                "To manage device resources",
                "To select a time in a clock app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android LoaderCallback used for?",
                "To make phone calls",
                "To load data into a loader",
                "To handle user interactions",
                "To create new layouts",
                "To load data into a loader"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ExpandableListView used for?",
                "To create expandable lists for contacts",
                "To send and receive emails",
                "To manage app layouts",
                "To display advertisements",
                "To create expandable lists for contacts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android GestureDetector used for?",
                "To detect device gestures",
                "To create custom layouts",
                "To manage app resources",
                "To play music in the background",
                "To detect device gestures"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android HandlerThread used for?",
                "A thread for handling phone calls",
                "A thread for handling app layouts",
                "A thread for handling messages on a separate thread",
                "A type of layout in Android",
                "A thread for handling messages on a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Menu used for?",
                "To view restaurant menus",
                "To provide a user interface for selecting actions or options",
                "To manage device resources",
                "To create database tables",
                "To provide a user interface for selecting actions or options"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android PackageManager used for?",
                "To manage device settings",
                "To manage app resources",
                "To manage app installations and updates",
                "To create database tables",
                "To manage app installations and updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Gradle wrapper?",
                "A tool for wrapping Android devices",
                "A software tool for managing app resources",
                "A script that allows building Android projects without installing Gradle",
                "A software tool for testing apps",
                "A script that allows building Android projects without installing Gradle"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Toolbar?",
                "A physical tool used for Android development",
                "A graphical user interface component",
                "A music player app",
                "A hardware device for testing apps",
                "A graphical user interface component"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Shared Preferences?",
                "To share photos on social media",
                "To store and retrieve key-value pairs of primitive data types",
                "To manage device resources",
                "To create app layouts",
                "To store and retrieve key-value pairs of primitive data types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BroadcastReceiver used for?",
                "To broadcast a message to other apps",
                "To send text messages",
                "To create a new activity",
                "To play music in the background",
                "To broadcast a message to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BroadcastReceiver used for?",
                "To broadcast a message to other apps",
                "To send text messages",
                "To create a new activity",
                "To play music in the background",
                "To broadcast a message to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ContentResolver used for?",
                "To resolve user disputes",
                "To manage device resources",
                "To interact with a content provider to access and manipulate data",
                "To control device notifications",
                "To interact with a content provider to access and manipulate data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android BroadcastReceiver used for?",
                "To send broadcast messages to other apps",
                "To receive broadcasted messages and react to them",
                "To create a new activity",
                "To play music in the background",
                "To receive broadcasted messages and react to them"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android DialogFragment used for?",
                "To create dialog boxes",
                "To play music in the background",
                "To create database records",
                "To manage app permissions",
                "To create dialog boxes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Intent used for?",
                "To create music playlists",
                "To provide an abstract description of an operation to be performed",
                "To send text messages",
                "To design app layouts",
                "To provide an abstract description of an operation to be performed"
            )
        )

        androidQuestionsList.shuffle()

    }
    fun stageFour() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Gradle Sync in Android Studio?",
                "To sync music files with an Android device",
                "To synchronize code changes and dependencies in the project",
                "To update the Android operating system",
                "To schedule background tasks",
                "To synchronize code changes and dependencies in the project"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Application class used for?",
                "To manage app permissions",
                "To represent the entire app and maintain global application state",
                "To create database tables",
                "To display ads in the app",
                "To represent the entire app and maintain global application state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AssetManager used for?",
                "To manage app resources",
                "To access files and raw resources in the app's APK",
                "To create animations",
                "To synchronize Android devices",
                "To access files and raw resources in the app's APK"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ThreadPoolExecutor?",
                "To create UI components",
                "To manage app resources",
                "To execute tasks concurrently in a thread pool",
                "To handle user interactions",
                "To execute tasks concurrently in a thread pool"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewBinding feature used for?",
                "To create custom views in Android",
                "To bind views in the layout to variables in code",
                "To manage device settings",
                "To display advertisements",
                "To bind views in the layout to variables in code"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the role of the Android DataBinding library?",
                "To manage database connections",
                "To simplify UI components and minimize boilerplate code",
                "To play audio files",
                "To create custom animations",
                "To simplify UI components and minimize boilerplate code"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SharedPreferences.Editor used for?",
                "To create user preferences",
                "To create animations",
                "To edit and commit changes to SharedPreferences",
                "To play music in the background",
                "To edit and commit changes to SharedPreferences"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android LoaderManager used for?",
                "To manage images",
                "To load data from content providers asynchronously and manage the loaders",
                "To create a new activity",
                "To send text messages",
                "To load data from content providers asynchronously and manage the loaders"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android KeyStore used for?",
                "To store physical keys",
                "To securely store cryptographic keys and certificates",
                "To create database records",
                "To handle UI interactions",
                "To securely store cryptographic keys and certificates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Camera2 API?",
                "To manage app layouts",
                "To take pictures and record videos with fine-grained control over the camera hardware",
                "To create animations",
                "To display ads in the app",
                "To take pictures and record videos with fine-grained control over the camera hardware"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobScheduler used for?",
                "To schedule UI updates",
                "To schedule background tasks for deferred execution",
                "To update the Android operating system",
                "To play videos",
                "To schedule background tasks for deferred execution"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android IntentService?",
                "To start new activities",
                "To handle asynchronous requests in the background",
                "To create database tables",
                "To manage app permissions",
                "To handle asynchronous requests in the background"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WebView used for?",
                "To view web pages within an app",
                "To view databases",
                "To create custom animations",
                "To make phone calls",
                "To view web pages within an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ContentProvider used for?",
                "To play audio files",
                "To provide a consistent interface for sharing and accessing data",
                "To create layout files",
                "To manage app resources",
                "To provide a consistent interface for sharing and accessing data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WorkManager used for?",
                "To work on UI components",
                "To manage app layouts",
                "To schedule and execute deferrable background tasks",
                "To send and receive messages",
                "To schedule and execute deferrable background tasks"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NDK (Native Development Kit)?",
                "To create custom animations",
                "To develop Android apps using C and C++",
                "To update the Android operating system",
                "To manage device settings",
                "To develop Android apps using C and C++"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Service used for?",
                "To create user preferences",
                "To perform background tasks independently of an activity",
                "To display app advertisements",
                "To design app layouts",
                "To perform background tasks independently of an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Geocoder class used for?",
                "To create a geo map",
                "To convert between geographic coordinates and street addresses",
                "To manage app resources",
                "To synchronize Android devices",
                "To convert between geographic coordinates and street addresses"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android CursorLoader used for?",
                "To load and display images",
                "To perform database operations asynchronously and manage Cursors",
                "To create a new activity",
                "To handle phone calls",
                "To perform database operations asynchronously and manage Cursors"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Dialog used for?",
                "To play music in the background",
                "To create new layouts",
                "To display a small window with UI elements for user interaction",
                "To send and receive messages",
                "To display a small window with UI elements for user interaction"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Handler used for?",
                "To handle background tasks",
                "To create database records",
                "To communicate between the UI thread and background threads",
                "To manage app permissions",
                "To communicate between the UI thread and background threads"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Adapter used for?",
                "To connect devices to the Android operating system",
                "To provide data to UI components like ListView or RecyclerView",
                "To create animations",
                "To display app icons",
                "To provide data to UI components like ListView or RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Bundle used for?",
                "To create a bundle of sticks",
                "To bundle up UI elements",
                "To pass data between Android components, like activities and fragments",
                "To play videos",
                "To pass data between Android components, like activities and fragments"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android VectorDrawable used for?",
                "To create vector graphics",
                "To manage app layouts",
                "To create database tables",
                "To update the Android operating system",
                "To create vector graphics"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android LiveData used for?",
                "To create a live streaming app",
                "To observe changes in data and notify UI components",
                "To play music in the background",
                "To manage app resources",
                "To observe changes in data and notify UI components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationChannel?",
                "To organize notifications into channels for better user control",
                "To create notifications with custom animations",
                "To design app layouts",
                "To create database records",
                "To organize notifications into channels for better user control"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AccessibilityService used for?",
                "To create accessible user interfaces",
                "To manage device resources",
                "To develop Android games",
                "To synchronize Android devices",
                "To create accessible user interfaces"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Navigation Architecture Component used for?",
                "To navigate between different floors in a building",
                "To navigate between app screens and handle navigation logic",
                "To display app advertisements",
                "To create UI animations",
                "To navigate between app screens and handle navigation logic"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android AsyncTask used for?",
                "To play audio files",
                "To perform background tasks on a separate thread and update the UI",
                "To create layout files",
                "To create user preferences",
                "To perform background tasks on a separate thread and update the UI"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android JobIntentService?",
                "To handle phone calls",
                "To schedule background tasks with the benefits of a service",
                "To create database tables",
                "To design app layouts",
                "To schedule background tasks with the benefits of a service"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MultiDex used for?",
                "To add multiple decks of cards in a game",
                "To manage app permissions",
                "To enable an Android app to have more than 64k methods",
                "To create app advertisements",
                "To enable an Android app to have more than 64k methods"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Menu used for?",
                "To order food in a restaurant",
                "To create database records",
                "To define actions and options for an app's user interface",
                "To create animations",
                "To define actions and options for an app's user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewFlipper used for?",
                "To flip physical objects",
                "To create a flipbook animation",
                "To flip between child views with animations",
                "To send text messages",
                "To flip between child views with animations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ConstraintLayout?",
                "To constrain app layouts",
                "To manage app resources",
                "To display app icons",
                "To play music in the background",
                "To constrain app layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android AccessibilityNodeInfo used for?",
                "To access nodes in a tree structure",
                "To access database records",
                "To play videos",
                "To handle UI interactions",
                "To access nodes in a tree structure"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SeekBar used for?",
                "To seek and find missing items",
                "To create database tables",
                "To display a seekable bar for selecting values within a range",
                "To manage app layouts",
                "To display a seekable bar for selecting values within a range"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ViewStub?",
                "To view app advertisements",
                "To simplify the layout hierarchy and improve performance",
                "To create animations",
                "To display images",
                "To simplify the layout hierarchy and improve performance"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Parcelable interface used for?",
                "To play audio files",
                "To pass objects between Android components efficiently",
                "To create database records",
                "To manage device resources",
                "To pass objects between Android components efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ServiceConnection used for?",
                "To connect to a Wi-Fi network",
                "To bind to a service and communicate with it",
                "To handle phone calls",
                "To create UI animations",
                "To bind to a service and communicate with it"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewTreeObserver used for?",
                "To observe views in a tree structure",
                "To observe the Android operating system",
                "To manage app layouts",
                "To display app icons",
                "To observe views in a tree structure"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AccountManager?",
                "To manage user accounts and identities",
                "To manage device settings",
                "To schedule background tasks",
                "To play videos",
                "To manage user accounts and identities"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SQLiteDatabase used for?",
                "To play music in the background",
                "To create database tables and perform database operations",
                "To create animations",
                "To display advertisements",
                "To create database tables and perform database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android FileObserver used for?",
                "To observe files and directories for changes",
                "To observe user interactions with the UI",
                "To manage app permissions",
                "To create UI layouts",
                "To observe files and directories for changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AsyncTaskLoader?",
                "To load images and videos",
                "To load data from content providers asynchronously and manage the loaders",
                "To manage device resources",
                "To create layout files",
                "To load data from content providers asynchronously and manage the loaders"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BottomNavigationView used for?",
                "To view the bottom of a navigation hierarchy",
                "To display navigation items at the bottom of the screen",
                "To create database records",
                "To design app layouts",
                "To display navigation items at the bottom of the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AccessibilityEvent used for?",
                "To manage accessibility services",
                "To record and dispatch accessibility events",
                "To play audio files",
                "To synchronize Android devices",
                "To record and dispatch accessibility events"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AlarmManager?",
                "To manage alarms and timers for app reminders",
                "To manage device settings",
                "To create app animations",
                "To display app advertisements",
                "To manage alarms and timers for app reminders"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CoordinatorLayout used for?",
                "To coordinate activities between Android components",
                "To manage app layouts",
                "To create custom animations",
                "To display app icons",
                "To coordinate activities between Android components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android HandlerThread used for?",
                "To handle background tasks",
                "To manage device resources",
                "To communicate with background threads efficiently",
                "To send text messages",
                "To communicate with background threads efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SensorManager?",
                "To manage device sensors",
                "To play music in the background",
                "To create database tables",
                "To design app layouts",
                "To manage device sensors"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ScrollView used for?",
                "To display app icons",
                "To scroll through a single view that is too large for the screen",
                "To create animations",
                "To synchronize Android devices",
                "To scroll through a single view that is too large for the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AsyncTaskLoader used for?",
                "To load images and videos",
                "To load data from content providers asynchronously and manage the loaders",
                "To manage app resources",
                "To create UI layouts",
                "To load data from content providers asynchronously and manage the loaders"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Palette class?",
                "To create color palettes for painting",
                "To create database records",
                "To analyze and extract prominent colors from an image",
                "To manage app permissions",
                "To analyze and extract prominent colors from an image"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android WebView used for?",
                "To view databases",
                "To display web content within an app",
                "To create custom animations",
                "To display app advertisements",
                "To display web content within an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MenuItem used for?",
                "To create database tables",
                "To define actions and options in the app's user interface",
                "To manage app layouts",
                "To play music in the background",
                "To define actions and options in the app's user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android HandlerThread?",
                "To handle phone calls",
                "To communicate with a background thread efficiently",
                "To create animations",
                "To send and receive messages",
                "To communicate with a background thread efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Canvas used for?",
                "To create database records",
                "To draw graphics on a View or Bitmap",
                "To manage app resources",
                "To create layout files",
                "To draw graphics on a View or Bitmap"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaPlayer used for?",
                "To play audio and video files",
                "To manage device settings",
                "To create app animations",
                "To send text messages",
                "To play audio and video files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Handler used for?",
                "To create user preferences",
                "To post and process messages and run code on the UI thread",
                "To create animations",
                "To display app icons",
                "To post and process messages and run code on the UI thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android VectorDrawableCompat?",
                "To play music in the background",
                "To display vector graphics on older Android versions",
                "To manage app layouts",
                "To create database tables",
                "To display vector graphics on older Android versions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ContentObserver used for?",
                "To observe and respond to changes in content",
                "To play videos",
                "To manage device resources",
                "To create animations",
                "To observe and respond to changes in content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Material Design?",
                "A design concept for physical materials",
                "A design language for creating a visually consistent and appealing user interface",
                "A design for managing device settings",
                "A design for making phone calls",
                "A design language for creating a visually consistent and appealing user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Storage Access Framework used for?",
                "To access physical storage devices",
                "To provide a standardized way to access documents and files across different apps",
                "To create layout files",
                "To play audio files",
                "To provide a standardized way to access documents and files across different apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SyncAdapter?",
                "To synchronize app data with other devices",
                "To manage app permissions",
                "To create custom animations",
                "To create app layouts",
                "To synchronize app data with other devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ViewPager used for?",
                "To view databases",
                "To swipe between multiple fragments or views in a horizontal manner",
                "To create database records",
                "To display advertisements",
                "To swipe between multiple fragments or views in a horizontal manner"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ProGuard tool used for?",
                "To protect Android devices from malware",
                "To shrink, optimize, and obfuscate code to improve app performance and security",
                "To manage app layouts",
                "To play videos",
                "To shrink, optimize, and obfuscate code to improve app performance and security"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Chip component?",
                "To create custom chips for snacking",
                "To represent a complex entity in a compact form, such as a contact or tag",
                "To manage device resources",
                "To display app icons",
                "To represent a complex entity in a compact form, such as a contact or tag"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android InputMethodManager used for?",
                "To manage app layouts",
                "To display advertisements",
                "To manage input methods, such as the on-screen keyboard",
                "To create database tables",
                "To manage input methods, such as the on-screen keyboard"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Lint tool?",
                "To perform linting on app layouts",
                "To analyze Android project source code for potential issues",
                "To synchronize Android devices",
                "To create app animations",
                "To analyze Android project source code for potential issues"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android DatePickerDialog used for?",
                "To pick dates in a date picker dialog",
                "To create animations",
                "To display app icons",
                "To manage app permissions",
                "To pick dates in a date picker dialog"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AnimatorSet used for?",
                "To set up animations in an app",
                "To manage app resources",
                "To play music in the background",
                "To create custom animations",
                "To set up animations in an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ViewTreeObserver.OnGlobalLayoutListener?",
                "To listen for phone calls",
                "To observe changes to the global layout of a view tree",
                "To create app advertisements",
                "To create database records",
                "To observe changes to the global layout of a view tree"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android RecyclerView.Adapter used for?",
                "To manage app layouts",
                "To provide data and create views for the RecyclerView",
                "To view databases",
                "To play videos",
                "To provide data and create views for the RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Transition animation framework used for?",
                "To create app animations",
                "To manage device settings",
                "To transition between scenes or UI states with animations",
                "To play audio files",
                "To transition between scenes or UI states with animations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android LocationManager?",
                "To create layout files",
                "To manage location services and retrieve device location information",
                "To create custom animations",
                "To display app icons",
                "To manage location services and retrieve device location information"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SurfaceView used for?",
                "To display app advertisements",
                "To provide a dedicated drawing surface for custom rendering",
                "To create database records",
                "To design app layouts",
                "To provide a dedicated drawing surface for custom rendering"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ConstraintSet used for?",
                "To manage app resources",
                "To define constraints for UI elements in a ConstraintLayout",
                "To create animations",
                "To create user preferences",
                "To define constraints for UI elements in a ConstraintLayout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Drawable class?",
                "To draw circles and squares",
                "To define images, shapes, and other graphic content that can be drawn on the screen",
                "To synchronize Android devices",
                "To create UI animations",
                "To define images, shapes, and other graphic content that can be drawn on the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android DialogFragment used for?",
                "To create new dialogs",
                "To create database records",
                "To manage app permissions",
                "To play music in the background",
                "To create new dialogs"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ViewFlipper?",
                "To flip views in a 3D space",
                "To manage device resources",
                "To animate a series of views on the screen",
                "To play music in the background",
                "To animate a series of views on the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ExifInterface used for?",
                "To create and manage interfaces",
                "To store images",
                "To extract metadata from image files",
                "To display advertisements",
                "To extract metadata from image files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Dialog class?",
                "To display app icons",
                "To manage app permissions",
                "To create a dialog window for user interactions",
                "To build the Android operating system",
                "To create a dialog window for user interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CoordinatorLayout used for?",
                "To coordinate app activities",
                "To coordinate layouts for multiple apps",
                "To coordinate the interaction of child views",
                "To coordinate app advertisements",
                "To coordinate the interaction of child views"
            )
        )

        androidQuestionsList.shuffle()
    }
    fun stageFive() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Service class?",
                "To create and manage user interfaces",
                "To perform background tasks without a user interface",
                "To display ads in the app",
                "To make phone calls",
                "To perform background tasks without a user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BroadcastReceiver used for?",
                "To broadcast messages to other apps",
                "To send text messages",
                "To create a new activity",
                "To handle UI interactions",
                "To broadcast messages to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ContentProvider used for?",
                "To create animations",
                "To provide a structured way to access data from other apps",
                "To design app layouts",
                "To manage app permissions",
                "To provide a structured way to access data from other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AsyncTask class used for?",
                "To create custom fonts",
                "To perform background tasks on a separate thread",
                "To play music in the background",
                "To manage app resources",
                "To perform background tasks on a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SQLiteOpenHelper class?",
                "To design app layouts",
                "To help with SQLite database operations",
                "To create database records",
                "To play videos",
                "To help with SQLite database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Fragment used for?",
                "To create database tables",
                "To represent a portion of a user interface or behavior",
                "To manage app permissions",
                "To display app advertisements",
                "To represent a portion of a user interface or behavior"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewStub used for?",
                "To manage app resources",
                "To hide a portion of the view until it's needed",
                "To play music in the background",
                "To create animations",
                "To hide a portion of the view until it's needed"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ListView used for?",
                "To display images",
                "To display a scrollable list of items",
                "To make phone calls",
                "To create new activities",
                "To display a scrollable list of items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android PreferenceFragment used for?",
                "To perform background tasks",
                "To display user preferences in an activity",
                "To manage app layouts",
                "To play music in the background",
                "To display user preferences in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android IntentService class?",
                "To provide content to other apps",
                "To perform background tasks on a separate thread",
                "To display ads in the app",
                "To create database records",
                "To perform background tasks on a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android NotificationCompat class used for?",
                "To create database tables",
                "To create backward-compatible notifications",
                "To manage device settings",
                "To design app layouts",
                "To create backward-compatible notifications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SeekBar used for?",
                "To play videos",
                "To manage app permissions",
                "To select a value from a range",
                "To create animations",
                "To select a value from a range"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ViewPager used for?",
                "To manage app resources",
                "To display images in a circular layout",
                "To swipe through a collection of views",
                "To send and receive messages",
                "To swipe through a collection of views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android FragmentTransaction class?",
                "To perform background tasks",
                "To add, replace, or remove fragments in an activity",
                "To create animations",
                "To manage app layouts",
                "To add, replace, or remove fragments in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android FileProvider used for?",
                "To provide file storage services",
                "To play videos",
                "To generate QR codes",
                "To share files with other apps",
                "To share files with other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of the Android AsyncTaskLoader?",
                "To load images",
                "To load data on a separate thread and deliver results to the UI thread",
                "To create animations",
                "To play audio files",
                "To load data on a separate thread and deliver results to the UI thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Handler used for?",
                "To create background threads",
                "To display ads in the app",
                "To send and process messages and run code on a different thread",
                "To design app layouts",
                "To send and process messages and run code on a different thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Bundle used for?",
                "To wrap and unwrap presents",
                "To store key-value pairs for passing data between components",
                "To manage app resources",
                "To create database tables",
                "To store key-value pairs for passing data between components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContextThemeWrapper used for?",
                "To wrap themes for UI components",
                "To wrap UI components for use in other apps",
                "To display images",
                "To manage app permissions",
                "To wrap themes for UI components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaRecorder used for?",
                "To create custom media players",
                "To record audio and video",
                "To design app layouts",
                "To perform background tasks",
                "To record audio and video"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentValues class used for?",
                "To create animations",
                "To store values for database operations",
                "To play music in the background",
                "To manage app layouts",
                "To store values for database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MenuInflater used for?",
                "To create animations",
                "To prepare food menus",
                "To inflate menu resources into a Menu object",
                "To manage app resources",
                "To inflate menu resources into a Menu object"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ExifInterface used for?",
                "To create and manage interfaces",
                "To store images",
                "To extract metadata from image files",
                "To display advertisements",
                "To extract metadata from image files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Dialog class?",
                "To display app icons",
                "To manage app permissions",
                "To create a dialog window for user interactions",
                "To build the Android operating system",
                "To create a dialog window for user interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CoordinatorLayout used for?",
                "To coordinate app activities",
                "To coordinate layouts for multiple apps",
                "To coordinate the interaction of child views",
                "To coordinate app advertisements",
                "To coordinate the interaction of child views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ContentValues class?",
                "To manage app layouts",
                "To store values for database operations",
                "To create app layouts",
                "To create database tables",
                "To store values for database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ActionMode used for?",
                "To perform database operations",
                "To play music in the background",
                "To manage app permissions",
                "To provide contextual actions for selected items",
                "To provide contextual actions for selected items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ImageLoader library used for?",
                "To create images for UI components",
                "To load and display images in Android apps efficiently",
                "To design app layouts",
                "To send and receive messages",
                "To load and display images in Android apps efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Resource Qualifiers used for?",
                "To specify alternative resources for different device configurations",
                "To specify resource directories for app icons",
                "To manage device settings",
                "To qualify for app development",
                "To specify alternative resources for different device configurations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationChannel?",
                "To create channels for notifications",
                "To play videos",
                "To manage app resources",
                "To design app layouts",
                "To create channels for notifications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SeekBar used for?",
                "To play videos",
                "To manage app permissions",
                "To select a value from a range",
                "To create animations",
                "To select a value from a range"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Intent.FLAG_ACTIVITY_CLEAR_TOP used for?",
                "To clear application data",
                "To clear all activities in the back stack up to the specified activity",
                "To clear notifications",
                "To play music in the background",
                "To clear all activities in the back stack up to the specified activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android PendingIntent used for?",
                "To design app layouts",
                "To create database records",
                "To perform a deferred action or service request",
                "To create animations",
                "To perform a deferred action or service request"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android BroadcastReceiver used for?",
                "To broadcast messages to other apps",
                "To send text messages",
                "To create a new activity",
                "To handle UI interactions",
                "To broadcast messages to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SharedPreferences class?",
                "To store and retrieve images",
                "To store and retrieve key-value pairs of primitive data types",
                "To manage device resources",
                "To create app layouts",
                "To store and retrieve key-value pairs of primitive data types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CoordinatorLayout used for?",
                "To coordinate app activities",
                "To coordinate layouts for multiple apps",
                "To coordinate the interaction of child views",
                "To coordinate app advertisements",
                "To coordinate the interaction of child views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AlertDialog used for?",
                "To alert users of incoming calls",
                "To create animations",
                "To display a dialog with buttons and messages",
                "To perform background tasks",
                "To display a dialog with buttons and messages"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobScheduler used for?",
                "To manage job applications",
                "To manage app layouts",
                "To schedule background tasks based on various conditions",
                "To send and receive messages",
                "To schedule background tasks based on various conditions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SurfaceView used for?",
                "To manage app permissions",
                "To create animations",
                "To create a transparent drawing surface for custom graphics",
                "To play music in the background",
                "To create a transparent drawing surface for custom graphics"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ActionMode used for?",
                "To perform database operations",
                "To play music in the background",
                "To manage app permissions",
                "To provide contextual actions for selected items",
                "To provide contextual actions for selected items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ImageLoader library used for?",
                "To create images for UI components",
                "To load and display images in Android apps efficiently",
                "To design app layouts",
                "To send and receive messages",
                "To load and display images in Android apps efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Resource Qualifiers used for?",
                "To specify alternative resources for different device configurations",
                "To specify resource directories for app icons",
                "To manage device settings",
                "To qualify for app development",
                "To specify alternative resources for different device configurations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationChannel?",
                "To create channels for notifications",
                "To play videos",
                "To manage app resources",
                "To design app layouts",
                "To create channels for notifications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SeekBar used for?",
                "To play videos",
                "To manage app permissions",
                "To select a value from a range",
                "To create animations",
                "To select a value from a range"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Intent.FLAG_ACTIVITY_CLEAR_TOP used for?",
                "To clear application data",
                "To clear all activities in the back stack up to the specified activity",
                "To clear notifications",
                "To play music in the background",
                "To clear all activities in the back stack up to the specified activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android PendingIntent used for?",
                "To design app layouts",
                "To create database records",
                "To perform a deferred action or service request",
                "To create animations",
                "To perform a deferred action or service request"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android BroadcastReceiver used for?",
                "To broadcast messages to other apps",
                "To send text messages",
                "To create a new activity",
                "To handle UI interactions",
                "To broadcast messages to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SharedPreferences class?",
                "To store and retrieve images",
                "To store and retrieve key-value pairs of primitive data types",
                "To manage device resources",
                "To create app layouts",
                "To store and retrieve key-value pairs of primitive data types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CoordinatorLayout used for?",
                "To coordinate app activities",
                "To coordinate layouts for multiple apps",
                "To coordinate the interaction of child views",
                "To coordinate app advertisements",
                "To coordinate the interaction of child views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AlertDialog used for?",
                "To alert users of incoming calls",
                "To create animations",
                "To display a dialog with buttons and messages",
                "To perform background tasks",
                "To display a dialog with buttons and messages"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobScheduler used for?",
                "To manage job applications",
                "To manage app layouts",
                "To schedule background tasks based on various conditions",
                "To send and receive messages",
                "To schedule background tasks based on various conditions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SurfaceView used for?",
                "To manage app permissions",
                "To create animations",
                "To create a transparent drawing surface for custom graphics",
                "To play music in the background",
                "To create a transparent drawing surface for custom graphics"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android RecyclerView used for?",
                "To play videos",
                "To display a list of items with dynamic data",
                "To manage app permissions",
                "To draw custom shapes on the screen",
                "To display a list of items with dynamic data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android CardView?",
                "To make phone calls",
                "To create custom cards for UI design",
                "To manage app resources",
                "To build the Android operating system",
                "To create custom cards for UI design"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android Broadcast Receiver?",
                "To broadcast messages to other apps",
                "To send text messages",
                "To create a new activity",
                "To handle UI interactions",
                "To broadcast messages to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Handler used for?",
                "To handle incoming phone calls",
                "To send and process messages and run code on a different thread",
                "To play music in the background",
                "To manage app layouts",
                "To send and process messages and run code on a different thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Logcat?",
                "To view app advertisements",
                "To display app icons",
                "To view and record logs generated by an app",
                "To create database tables",
                "To view and record logs generated by an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Gradle script?",
                "A script for making coffee",
                "A script for building and configuring Android app projects",
                "A script for playing music",
                "A script for creating database records",
                "A script for building and configuring Android app projects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is a ContentResolver in Android?",
                "A tool for resolving user disputes",
                "A component for managing device resources",
                "A class for accessing and modifying data from content providers",
                "A layout file for resolving UI issues",
                "A class for accessing and modifying data from content providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AsyncTaskLoader used for?",
                "To load images",
                "To load data on a separate thread and deliver results to the UI thread",
                "To create animations",
                "To play audio files",
                "To load data on a separate thread and deliver results to the UI thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is a FragmentTransaction in Android?",
                "A transaction involving money",
                "A transaction for managing app resources",
                "A transaction for adding, replacing, or removing fragments in an activity",
                "A transaction for creating new activities",
                "A transaction for adding, replacing, or removing fragments in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of an Android PreferenceFragment?",
                "To display user preferences in an activity",
                "To perform background tasks",
                "To manage app layouts",
                "To play music in the background",
                "To display user preferences in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the role of the Android ContentProvider?",
                "To play videos",
                "To store and retrieve structured data and share it with other apps",
                "To design app layouts",
                "To draw custom shapes on the screen",
                "To store and retrieve structured data and share it with other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android Context?",
                "To manage app permissions",
                "To provide access to application-specific resources and components",
                "To make phone calls",
                "To build the Android operating system",
                "To provide access to application-specific resources and components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationManager?",
                "To manage app resources",
                "To display notifications to the user",
                "To control the device's notifications",
                "To store app data",
                "To display notifications to the user"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BroadcastReceiver used for?",
                "To broadcast a message to other apps",
                "To send text messages",
                "To create a new activity",
                "To play music in the background",
                "To broadcast a message to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Material Design?",
                "A design concept for material objects",
                "A design language for creating a consistent, visually appealing user interface",
                "A design for manufacturing physical products",
                "A design for managing app permissions",
                "A design language for creating a consistent, visually appealing user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AdapterView?",
                "To view and edit databases",
                "To manage app layouts",
                "To provide a view for displaying items in a scrollable list",
                "To display app advertisements",
                "To provide a view for displaying items in a scrollable list"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentResolver used for?",
                "To resolve user disputes",
                "To manage device resources",
                "To query, insert, update, and delete data through a content provider",
                "To create app layouts",
                "To query, insert, update, and delete data through a content provider"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android HandlerThread?",
                "A thread for handling phone calls",
                "A thread for handling app layouts",
                "A thread for handling messages on a separate thread",
                "A type of layout in Android",
                "A thread for handling messages on a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Loader class?",
                "To load apps into memory",
                "To load data from a content provider asynchronously",
                "To create app advertisements",
                "To create new activities",
                "To load data from a content provider asynchronously"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android FrameLayout used for?",
                "To frame photos",
                "To create animation frames",
                "To contain a single item or fragment",
                "To manage app permissions",
                "To contain a single item or fragment"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SQLiteOpenHelper used for?",
                "To help with SQLite database operations",
                "To create animations",
                "To design app layouts",
                "To play music in the background",
                "To help with SQLite database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ActionBarDrawerToggle?",
                "A toggle switch for the app bar",
                "A drawer toggle for app navigation",
                "A switch for turning off advertisements",
                "A tool for managing app resources",
                "A drawer toggle for app navigation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android AutoCompleteTextView used for?",
                "To view the auto complete list",
                "To send text messages",
                "To provide auto-completion suggestions as the user types",
                "To create database records",
                "To provide auto-completion suggestions as the user types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaRecorder used for?",
                "To create custom media players",
                "To record audio and video",
                "To design app layouts",
                "To perform background tasks",
                "To record audio and video"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentValues class used for?",
                "To create animations",
                "To store values for database operations",
                "To play music in the background",
                "To manage app layouts",
                "To store values for database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MenuInflater used for?",
                "To create animations",
                "To prepare food menus",
                "To inflate menu resources into a Menu object",
                "To manage app resources",
                "To inflate menu resources into a Menu object"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ExifInterface used for?",
                "To create and manage interfaces",
                "To store images",
                "To extract metadata from image files",
                "To display advertisements",
                "To extract metadata from image files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Dialog class?",
                "To display app icons",
                "To manage app permissions",
                "To create a dialog window for user interactions",
                "To build the Android operating system",
                "To create a dialog window for user interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CoordinatorLayout used for?",
                "To coordinate app activities",
                "To coordinate layouts for multiple apps",
                "To coordinate the interaction of child views",
                "To coordinate app advertisements",
                "To coordinate the interaction of child views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentValues class used for?",
                "To manage app layouts",
                "To store values for database operations",
                "To create app layouts",
                "To create database tables",
                "To store values for database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ActionMode used for?",
                "To perform database operations",
                "To play music in the background",
                "To manage app permissions",
                "To provide contextual actions for selected items",
                "To provide contextual actions for selected items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ImageLoader library used for?",
                "To create images for UI components",
                "To load and display images in Android apps efficiently",
                "To design app layouts",
                "To send and receive messages",
                "To load and display images in Android apps efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Resource Qualifiers used for?",
                "To specify alternative resources for different device configurations",
                "To specify resource directories for app icons",
                "To manage device settings",
                "To qualify for app development",
                "To specify alternative resources for different device configurations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationChannel?",
                "To create channels for notifications",
                "To play videos",
                "To manage app resources",
                "To design app layouts",
                "To create channels for notifications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SeekBar used for?",
                "To play videos",
                "To manage app permissions",
                "To select a value from a range",
                "To create animations",
                "To select a value from a range"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Intent.FLAG_ACTIVITY_CLEAR_TOP used for?",
                "To clear application data",
                "To clear all activities in the back stack up to the specified activity",
                "To clear notifications",
                "To play music in the background",
                "To clear all activities in the back stack up to the specified activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android PendingIntent used for?",
                "To design app layouts",
                "To create database records",
                "To perform a deferred action or service request",
                "To create animations",
                "To perform a deferred action or service request"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android BroadcastReceiver used for?",
                "To broadcast messages to other apps",
                "To send text messages",
                "To create a new activity",
                "To handle UI interactions",
                "To broadcast messages to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SharedPreferences class?",
                "To store and retrieve images",
                "To store and retrieve key-value pairs of primitive data types",
                "To manage device resources",
                "To create app layouts",
                "To store and retrieve key-value pairs of primitive data types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CoordinatorLayout used for?",
                "To coordinate app activities",
                "To coordinate layouts for multiple apps",
                "To coordinate the interaction of child views",
                "To coordinate app advertisements",
                "To coordinate the interaction of child views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AlertDialog used for?",
                "To alert users of incoming calls",
                "To create animations",
                "To display a dialog with buttons and messages",
                "To perform background tasks",
                "To display a dialog with buttons and messages"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobScheduler used for?",
                "To manage job applications",
                "To manage app layouts",
                "To schedule background tasks based on various conditions",
                "To send and receive messages",
                "To schedule background tasks based on various conditions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SurfaceView used for?",
                "To manage app permissions",
                "To create animations",
                "To create a transparent drawing surface for custom graphics",
                "To play music in the background",
                "To create a transparent drawing surface for custom graphics"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android RecyclerView used for?",
                "To play videos",
                "To display a list of items with dynamic data",
                "To manage app permissions",
                "To draw custom shapes on the screen",
                "To display a list of items with dynamic data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android CardView?",
                "To make phone calls",
                "To create custom cards for UI design",
                "To manage app resources",
                "To build the Android operating system",
                "To create custom cards for UI design"
            )
        )

        androidQuestionsList.shuffle()

    }

    fun stageSix() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android RenderScript framework?",
                "To render 3D graphics",
                "To perform computationally intensive tasks in high-performance applications",
                "To create app advertisements",
                "To manage app resources",
                "To perform computationally intensive tasks in high-performance applications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android RenderScript Allocation used for?",
                "To allocate memory for database records",
                "To create custom animations",
                "To allocate and manage data for computation in RenderScript",
                "To design app layouts",
                "To allocate and manage data for computation in RenderScript"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Traceview tool?",
                "To view traces of system events",
                "To manage device settings",
                "To create layout files",
                "To display advertisements",
                "To view traces of system events"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobInfo.Builder used for?",
                "To build houses in the digital world",
                "To configure and build JobInfo instances for the JobScheduler",
                "To play music in the background",
                "To send text messages",
                "To configure and build JobInfo instances for the JobScheduler"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AIDL (Android Interface Definition Language)?",
                "To define interfaces for Android devices",
                "To manage app permissions",
                "To create animations",
                "To design app layouts",
                "To define interfaces for Android devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Handler.Callback interface used for?",
                "To handle device callbacks",
                "To provide a callback mechanism for processing messages in a Handler",
                "To create database records",
                "To play videos",
                "To provide a callback mechanism for processing messages in a Handler"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Geofencing API?",
                "To create database tables",
                "To create and monitor geofences for location-based triggers",
                "To manage device resources",
                "To synchronize Android devices",
                "To create and monitor geofences for location-based triggers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobIntentService used for?",
                "To schedule background tasks with JobScheduler",
                "To manage app layouts",
                "To create custom animations",
                "To create app advertisements",
                "To schedule background tasks with JobScheduler"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android NotificationListenerService used for?",
                "To listen to app notifications",
                "To create app layouts",
                "To display app icons",
                "To design app animations",
                "To listen to app notifications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android IntentFilter?",
                "To filter incoming calls",
                "To filter and specify the types of intents an app can receive",
                "To manage app resources",
                "To display app advertisements",
                "To filter and specify the types of intents an app can receive"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android CursorAdapter used for?",
                "To manage app permissions",
                "To bind data from a cursor to views in a ListView or RecyclerView",
                "To view databases",
                "To play music in the background",
                "To bind data from a cursor to views in a ListView or RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android DataBinding Observable class used for?",
                "To observe data for app bindings",
                "To manage device settings",
                "To create animations",
                "To send text messages",
                "To observe data for app bindings"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android CameraX library?",
                "To create database records",
                "To simplify camera development with consistent APIs across different Android devices",
                "To create custom animations",
                "To synchronize Android devices",
                "To simplify camera development with consistent APIs across different Android devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaCodec used for?",
                "To create app advertisements",
                "To create, configure, and process media data in low-level formats",
                "To manage app layouts",
                "To play videos",
                "To create, configure, and process media data in low-level formats"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android NDK (Native Development Kit) used for?",
                "To create custom animations",
                "To develop Android apps using native code such as C and C++",
                "To design app layouts",
                "To create user preferences",
                "To develop Android apps using native code such as C and C++"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android LiveData Transformation?",
                "To transform live streaming data",
                "To transform LiveData objects to produce new LiveData objects",
                "To manage device resources",
                "To create app layouts",
                "To transform LiveData objects to produce new LiveData objects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android CameraCaptureSession used for?",
                "To capture video game sessions",
                "To manage app permissions",
                "To create custom animations",
                "To configure capture requests and process captured image or video data",
                "To configure capture requests and process captured image or video data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ConstraintLayout Guideline?",
                "To create app advertisements",
                "To define layout guidelines for positioning views within a ConstraintLayout",
                "To display app icons",
                "To synchronize Android devices",
                "To define layout guidelines for positioning views within a ConstraintLayout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MotionEvent.PointerCoords class used for?",
                "To coordinate motion events",
                "To store information about the coordinates and properties of a pointer",
                "To play music in the background",
                "To design app layouts",
                "To store information about the coordinates and properties of a pointer"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android WindowManager.LayoutParams?",
                "To manage app layouts",
                "To set parameters and flags for windows and views",
                "To create database records",
                "To play videos",
                "To set parameters and flags for windows and views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AudioManager.OnAudioFocusChangeListener used for?",
                "To create layout files",
                "To listen for changes in audio focus and respond accordingly",
                "To provide audio focus to other apps",
                "To manage device settings",
                "To listen for changes in audio focus and respond accordingly"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Firebase Cloud Messaging (FCM)?",
                "To manage cloud data storage",
                "To send notifications and messages to Android devices from the cloud",
                "To create custom animations",
                "To create app advertisements",
                "To send notifications and messages to Android devices from the cloud"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaPlayer.OnErrorListener used for?",
                "To listen to device errors",
                "To handle errors that occur during media playback",
                "To view databases",
                "To synchronize Android devices",
                "To handle errors that occur during media playback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android CardView?",
                "To view card games",
                "To provide a flexible and customizable card-like container for displaying content",
                "To manage app permissions",
                "To display app icons",
                "To provide a flexible and customizable card-like container for displaying content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Snackbar used for?",
                "To serve snacks in the app",
                "To display brief messages to the user, often as a toast replacement",
                "To create database tables",
                "To design app layouts",
                "To display brief messages to the user, often as a toast replacement"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android WorkManager OneTimeWorkRequest?",
                "To perform one-time work in a background service",
                "To manage app layouts",
                "To create custom animations",
                "To create app advertisements",
                "To perform one-time work in a background service"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android TransitionManager used for?",
                "To manage device resources",
                "To create custom animations during layout changes",
                "To play music in the background",
                "To send text messages",
                "To create custom animations during layout changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ContentProviderOperation?",
                "To operate on content providers",
                "To create layout files",
                "To manage app permissions",
                "To display advertisements",
                "To operate on content providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ExoPlayer used for?",
                "To play music in the background",
                "To provide an open-source media player for playing audio and video",
                "To create database records",
                "To create UI animations",
                "To provide an open-source media player for playing audio and video"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WifiP2pManager used for?",
                "To manage Wi-Fi networks",
                "To manage app resources",
                "To discover and connect to nearby Wi-Fi Direct devices",
                "To synchronize Android devices",
                "To discover and connect to nearby Wi-Fi Direct devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android RenderScript ScriptIntrinsicBlur?",
                "To create blurred images for apps",
                "To apply Gaussian blur to images using RenderScript",
                "To design app layouts",
                "To create user preferences",
                "To apply Gaussian blur to images using RenderScript"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SearchView used for?",
                "To view search results",
                "To provide a search interface with suggestions and filtering",
                "To create custom animations",
                "To display app icons",
                "To provide a search interface with suggestions and filtering"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Firebase Realtime Database used for?",
                "To manage device settings",
                "To store and synchronize app data in real-time using a NoSQL database",
                "To create app advertisements",
                "To view databases",
                "To store and synchronize app data in real-time using a NoSQL database"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AdapterWrapper?",
                "To wrap adapters as gifts",
                "To wrap and decorate adapters with additional functionality",
                "To play videos",
                "To manage app layouts",
                "To wrap and decorate adapters with additional functionality"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SurfaceTexture used for?",
                "To create database tables",
                "To manage app permissions",
                "To manage textures that can be used as an OpenGL ES texture",
                "To play music in the background",
                "To manage textures that can be used as an OpenGL ES texture"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Retrofit library?",
                "To retrofit old Android devices",
                "To create database records",
                "To make HTTP requests and handle API responses",
                "To design app layouts",
                "To make HTTP requests and handle API responses"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Palette.Swatch class used for?",
                "To create app animations",
                "To represent a color swatch from a Palette",
                "To display app icons",
                "To synchronize Android devices",
                "To represent a color swatch from a Palette"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AudioRecord class?",
                "To record phone calls",
                "To record audio from the device's microphone",
                "To create layout files",
                "To create app advertisements",
                "To record audio from the device's microphone"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android HandlerThread used for?",
                "To handle background tasks",
                "To manage device resources",
                "To communicate with background threads efficiently",
                "To send text messages",
                "To communicate with background threads efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android TextToSpeech engine?",
                "To read and understand text",
                "To manage app layouts",
                "To create custom animations",
                "To create user preferences",
                "To read and understand text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android TextureView used for?",
                "To display app advertisements",
                "To display video content with a SurfaceTexture",
                "To create database tables",
                "To design app layouts",
                "To display video content with a SurfaceTexture"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Cipher class used for?",
                "To create database records",
                "To perform cryptographic operations, such as encryption and decryption",
                "To create UI animations",
                "To play videos",
                "To perform cryptographic operations, such as encryption and decryption"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android View.OnLayoutChangeListener?",
                "To create a new layout change",
                "To listen for layout changes in a view",
                "To manage app permissions",
                "To display app icons",
                "To listen for layout changes in a view"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android DownloadManager used for?",
                "To download Android apps",
                "To manage app resources",
                "To enqueue and manage downloads of files from the internet",
                "To synchronize Android devices",
                "To enqueue and manage downloads of files from the internet"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Data Binding Library?",
                "To bind data to user interfaces",
                "To create app animations",
                "To bind app layouts to data sources",
                "To play music in the background",
                "To bind app layouts to data sources"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android In-App Billing used for?",
                "To pay for in-app purchases",
                "To manage device settings",
                "To create custom animations",
                "To view databases",
                "To pay for in-app purchases"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android RemoteViews class?",
                "To create remote views of space",
                "To create and update app widgets from a remote process",
                "To design app layouts",
                "To create user preferences",
                "To create and update app widgets from a remote process"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android MediaMetadataCompat used for?",
                "To play music in the background",
                "To store metadata about media, such as title, artist, and album",
                "To create layout files",
                "To display app advertisements",
                "To store metadata about media, such as title, artist, and album"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android WebViewClient?",
                "To view web content in an app",
                "To manage app permissions",
                "To create animations",
                "To display app icons",
                "To view web content in an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaBrowserService used for?",
                "To browse media browsers",
                "To provide a service for connecting to media content, such as audio or video",
                "To synchronize Android devices",
                "To create database tables",
                "To provide a service for connecting to media content, such as audio or video"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SlidingPaneLayout?",
                "To slide panes in the app",
                "To create custom animations",
                "To manage app layouts",
                "To create user preferences",
                "To slide panes in the app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ContentProvider used for?",
                "To create app advertisements",
                "To provide a structured way to share data between apps",
                "To display app icons",
                "To play music in the background",
                "To provide a structured way to share data between apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WebView used for?",
                "To view databases",
                "To display web content within an app",
                "To create custom animations",
                "To synchronize Android devices",
                "To display web content within an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SharedPreferences.Editor?",
                "To create app animations",
                "To edit and commit changes to shared preferences",
                "To manage app resources",
                "To create layout files",
                "To edit and commit changes to shared preferences"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android VideoView used for?",
                "To display app advertisements",
                "To play video content",
                "To create database records",
                "To design app layouts",
                "To play video content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SQLiteDatabase.rawQuery() method used for?",
                "To query the Android operating system",
                "To execute raw SQL queries on a database",
                "To manage device resources",
                "To create app layouts",
                "To execute raw SQL queries on a database"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Snackbar.Callback?",
                "To provide snacks",
                "To listen for Snackbar events and perform actions in response",
                "To play videos",
                "To manage app permissions",
                "To listen for Snackbar events and perform actions in response"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentResolver used for?",
                "To resolve app content",
                "To manage app layouts",
                "To create custom animations",
                "To create app advertisements",
                "To resolve app content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android PreferenceScreen?",
                "To view user preferences",
                "To provide a screen for managing app settings and preferences",
                "To display app icons",
                "To synchronize Android devices",
                "To provide a screen for managing app settings and preferences"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ColorMatrix used for?",
                "To manage device settings",
                "To apply color transformations to images and drawables",
                "To create layout files",
                "To display advertisements",
                "To apply color transformations to images and drawables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AppCompat theme?",
                "To view compatible apps",
                "To provide a consistent look and feel across different Android versions",
                "To create database records",
                "To play music in the background",
                "To provide a consistent look and feel across different Android versions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android RemoteViewsFactory used for?",
                "To manage app advertisements",
                "To provide data to populate a RemoteViews object for a widget",
                "To manage app resources",
                "To display app icons",
                "To provide data to populate a RemoteViews object for a widget"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WebViewClient.onReceivedError() method used for?",
                "To create UI animations",
                "To handle web page loading errors in a WebView",
                "To design app layouts",
                "To create user preferences",
                "To handle web page loading errors in a WebView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android DevicePolicyManager?",
                "To manage device policies",
                "To create app animations",
                "To manage app layouts",
                "To display app icons",
                "To manage device policies"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android GestureDetectorCompat used for?",
                "To detect gestures incompatibly",
                "To detect gestures and provide compatibility with older Android versions",
                "To synchronize Android devices",
                "To create layout files",
                "To detect gestures and provide compatibility with older Android versions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ArrayAdapter used for?",
                "To create custom arrays",
                "To bind data to views in a ListView",
                "To play videos",
                "To manage app permissions",
                "To bind data to views in a ListView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Firebase Authentication?",
                "To authenticate Android devices",
                "To provide authentication services for users in Android apps",
                "To create database tables",
                "To create custom animations",
                "To provide authentication services for users in Android apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android TransitionSet used for?",
                "To create app advertisements",
                "To group multiple transitions and play them together",
                "To create UI animations",
                "To display app icons",
                "To group multiple transitions and play them together"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AccountManager.getAccountsByType() method?",
                "To manage device resources",
                "To retrieve accounts of a specific type on the device",
                "To create database records",
                "To create app layouts",
                "To retrieve accounts of a specific type on the device"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AlarmManager.OnAlarmListener used for?",
                "To listen to alarms",
                "To handle alarms triggered by the AlarmManager",
                "To play music in the background",
                "To send text messages",
                "To handle alarms triggered by the AlarmManager"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Parcelable.Creator?",
                "To create parcels for shipping",
                "To create and recreate Parcelable objects",
                "To design app layouts",
                "To create user preferences",
                "To create and recreate Parcelable objects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android DialogFragment.OnCancelListener used for?",
                "To cancel dialog fragments",
                "To listen for the cancellation of a DialogFragment",
                "To manage app permissions",
                "To display app advertisements",
                "To listen for the cancellation of a DialogFragment"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentProvider.getType() method used for?",
                "To type content providers",
                "To retrieve the MIME type of the data associated with a given URI",
                "To play videos",
                "To synchronize Android devices",
                "To retrieve the MIME type of the data associated with a given URI"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android MotionLayout?",
                "To create motion in layouts",
                "To create complex animations and transitions between layouts",
                "To create app animations",
                "To manage app layouts",
                "To create complex animations and transitions between layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SparseIntArray used for?",
                "To manage device settings",
                "To store pairs of integer values efficiently",
                "To create layout files",
                "To display advertisements",
                "To store pairs of integer values efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android MediaRecorder?",
                "To record phone conversations",
                "To capture audio and video content using the device's camera and microphone",
                "To create custom animations",
                "To create database records",
                "To capture audio and video content using the device's camera and microphone"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ExpandableListView used for?",
                "To manage app advertisements",
                "To display a two-level list that can be expanded to show child items",
                "To manage app resources",
                "To provide a drop-down menu",
                "To display a two-level list that can be expanded to show child items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android SQLiteOpenHelper?",
                "To help with SQL homework",
                "To manage app permissions",
                "To create and manage a database and its version",
                "To create UI animations",
                "To create and manage a database and its version"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaDrm used for?",
                "To manage DRM-protected media",
                "To play music in the background",
                "To design app layouts",
                "To create user preferences",
                "To manage DRM-protected media"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android TextureView.SurfaceTextureListener?",
                "To listen to surface textures",
                "To listen for events related to changes in the SurfaceTexture of a TextureView",
                "To create app advertisements",
                "To synchronize Android devices",
                "To listen for events related to changes in the SurfaceTexture of a TextureView"
            )
        )

        androidQuestionsList.shuffle()
    }
    fun stageSeven() {

        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android RenderScript framework?",
                "To create 3D games",
                "To perform computationally intensive tasks with high performance, such as image processing",
                "To develop Android apps using a scripting language",
                "To manage app permissions",
                "To perform computationally intensive tasks with high performance, such as image processing"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WindowManager used for?",
                "To manage window treatments",
                "To manage the appearance of app windows on the screen",
                "To create database records",
                "To play videos",
                "To manage the appearance of app windows on the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android AIDL (Android Interface Definition Language) used for?",
                "To define app interfaces for trading",
                "To define and create interprocess communication (IPC) interfaces",
                "To design app layouts",
                "To play music in the background",
                "To define and create interprocess communication (IPC) interfaces"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android PackageManager used for?",
                "To package Android apps for distribution",
                "To manage app layouts",
                "To create custom animations",
                "To display app icons",
                "To package Android apps for distribution"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Instrumentation framework used for?",
                "To play audio files",
                "To perform automated testing and monitoring of Android applications",
                "To create database tables",
                "To manage app permissions",
                "To perform automated testing and monitoring of Android applications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Cipher class?",
                "To encode text messages",
                "To perform encryption and decryption of data",
                "To create animations",
                "To display advertisements",
                "To perform encryption and decryption of data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android DEX (Dalvik Executable) format used for?",
                "To define device executables",
                "To package and distribute Android application code in an optimized format",
                "To develop Android apps using a scripting language",
                "To manage device resources",
                "To package and distribute Android application code in an optimized format"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Account Authenticator used for?",
                "To manage device accounts",
                "To synchronize Android devices",
                "To create app animations",
                "To design app layouts",
                "To manage device accounts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Traceview tool?",
                "To perform live music tracing",
                "To profile and trace application code for performance optimization",
                "To create custom animations",
                "To play videos",
                "To profile and trace application code for performance optimization"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android Spannable used for?",
                "To perform app-spanning operations",
                "To format and style text in a single TextView or EditText widget",
                "To create layout files",
                "To view databases",
                "To format and style text in a single TextView or EditText widget"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android WindowManager.LayoutParams class used for?",
                "To define window layouts",
                "To manage app resources",
                "To manage window treatments",
                "To play music in the background",
                "To define window layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Runtime Permissions system?",
                "To monitor the runtime performance of apps",
                "To handle device settings",
                "To request and manage app permissions at runtime",
                "To create database records",
                "To request and manage app permissions at runtime"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ProGuard tool used for?",
                "To protect Android devices from malware",
                "To shrink, optimize, and obfuscate code to improve app performance and security",
                "To manage app layouts",
                "To play videos",
                "To shrink, optimize, and obfuscate code to improve app performance and security"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Instant App feature?",
                "To instantly install Android apps",
                "To enable users to run apps without installation directly from search results",
                "To manage device resources",
                "To display app icons",
                "To enable users to run apps without installation directly from search results"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android IntentFilter used for?",
                "To filter incoming SMS messages",
                "To specify the types of intents that a component can respond to",
                "To create custom animations",
                "To display app advertisements",
                "To specify the types of intents that a component can respond to"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Recovery mode?",
                "To recover deleted files",
                "To allow users to update or recover the device's operating system",
                "To create database records",
                "To manage app permissions",
                "To allow users to update or recover the device's operating system"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android WebP format used for?",
                "To play web videos",
                "To provide efficient image compression and support transparency",
                "To create app layouts",
                "To manage device settings",
                "To provide efficient image compression and support transparency"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ConstraintSet used for?",
                "To manage app resources",
                "To define constraints for UI elements in a ConstraintLayout",
                "To create animations",
                "To create user preferences",
                "To define constraints for UI elements in a ConstraintLayout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Navigation Component used for?",
                "To navigate between different floors in a building",
                "To handle navigation and UI components within an Android app",
                "To display app advertisements",
                "To create UI animations",
                "To handle navigation and UI components within an Android app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewModel used for?",
                "To create virtual Android devices",
                "To store and manage UI-related data in a lifecycle-aware way",
                "To create custom animations",
                "To display app icons",
                "To store and manage UI-related data in a lifecycle-aware way"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ContentProviderClient?",
                "To provide content for content providers",
                "To access a content provider in a different process",
                "To manage device resources",
                "To create database records",
                "To access a content provider in a different process"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SQLiteOpenHelper used for?",
                "To play audio files",
                "To manage the creation and version management of an SQLite database",
                "To create app animations",
                "To manage app layouts",
                "To manage the creation and version management of an SQLite database"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AccessibilityNodeInfo?",
                "To create accessible user interfaces",
                "To manage accessibility services",
                "To develop Android games",
                "To synchronize Android devices",
                "To create accessible user interfaces"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android DataBinding Library used for?",
                "To bind data to app components",
                "To create database records",
                "To synchronize Android devices",
                "To design app layouts",
                "To bind data to app components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Lint tool?",
                "To perform linting on app layouts",
                "To analyze Android project source code for potential issues",
                "To synchronize Android devices",
                "To create app animations",
                "To analyze Android project source code for potential issues"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AccessibilityEvent used for?",
                "To manage accessibility services",
                "To record and dispatch accessibility events",
                "To play audio files",
                "To display app icons",
                "To record and dispatch accessibility events"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android HandlerThread?",
                "To handle phone calls",
                "To communicate with a background thread efficiently",
                "To create animations",
                "To send and receive messages",
                "To communicate with a background thread efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Canvas used for?",
                "To create database records",
                "To draw graphics on a View or Bitmap",
                "To manage app resources",
                "To create layout files",
                "To draw graphics on a View or Bitmap"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Material Design?",
                "A design concept for physical materials",
                "A design language for creating a visually consistent and appealing user interface",
                "A design for managing device settings",
                "A design for making phone calls",
                "A design language for creating a visually consistent and appealing user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobIntentService used for?",
                "To handle phone calls",
                "To schedule background tasks with the benefits of a service",
                "To create database tables",
                "To design app layouts",
                "To schedule background tasks with the benefits of a service"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SeekBar used for?",
                "To seek and find missing items",
                "To create database tables",
                "To display a seekable bar for selecting values within a range",
                "To manage app layouts",
                "To display a seekable bar for selecting values within a range"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android IntentService?",
                "To start new activities",
                "To handle asynchronous requests in the background",
                "To create database tables",
                "To manage app permissions",
                "To handle asynchronous requests in the background"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AccessibilityService used for?",
                "To create accessible user interfaces",
                "To manage device resources",
                "To develop Android games",
                "To synchronize Android devices",
                "To create accessible user interfaces"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Camera2 API used for?",
                "To manage app layouts",
                "To take pictures and record videos with fine-grained control over the camera hardware",
                "To create animations",
                "To display ads in the app",
                "To take pictures and record videos with fine-grained control over the camera hardware"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android JobScheduler used for?",
                "To schedule UI updates",
                "To schedule background tasks for deferred execution",
                "To update the Android operating system",
                "To play videos",
                "To schedule background tasks for deferred execution"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ServiceConnection used for?",
                "To connect to a Wi-Fi network",
                "To bind to a service and communicate with it",
                "To handle phone calls",
                "To create UI animations",
                "To bind to a service and communicate with it"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AccessibilityNodeInfo used for?",
                "To access nodes in a tree structure",
                "To access database records",
                "To play videos",
                "To handle UI interactions",
                "To access nodes in a tree structure"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SeekBar used for?",
                "To seek and find missing items",
                "To create database tables",
                "To display a seekable bar for selecting values within a range",
                "To manage app layouts",
                "To display a seekable bar for selecting values within a range"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android ViewStub?",
                "To view app advertisements",
                "To simplify the layout hierarchy and improve performance",
                "To create animations",
                "To display images",
                "To simplify the layout hierarchy and improve performance"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Parcelable interface used for?",
                "To play audio files",
                "To pass objects between Android components efficiently",
                "To create database records",
                "To manage device resources",
                "To pass objects between Android components efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android ServiceConnection used for?",
                "To connect to a Wi-Fi network",
                "To bind to a service and communicate with it",
                "To handle phone calls",
                "To create UI animations",
                "To bind to a service and communicate with it"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewTreeObserver.OnGlobalLayoutListener used for?",
                "To listen for phone calls",
                "To observe changes to the global layout of a view tree",
                "To create app advertisements",
                "To create database records",
                "To observe changes to the global layout of a view tree"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android RecyclerView.Adapter used for?",
                "To manage app layouts",
                "To provide data and create views for the RecyclerView",
                "To view databases",
                "To play videos",
                "To provide data and create views for the RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Transition animation framework used for?",
                "To create app animations",
                "To manage device settings",
                "To transition between scenes or UI states with animations",
                "To play audio files",
                "To transition between scenes or UI states with animations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android LocationManager?",
                "To create layout files",
                "To manage location services and retrieve device location information",
                "To create custom animations",
                "To display app icons",
                "To manage location services and retrieve device location information"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android SurfaceView used for?",
                "To display app advertisements",
                "To provide a dedicated drawing surface for custom rendering",
                "To create database records",
                "To design app layouts",
                "To provide a dedicated drawing surface for custom rendering"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ConstraintSet used for?",
                "To manage app resources",
                "To define constraints for UI elements in a ConstraintLayout",
                "To create animations",
                "To create user preferences",
                "To define constraints for UI elements in a ConstraintLayout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Drawable class?",
                "To draw circles and squares",
                "To define images, shapes, and other graphic content that can be drawn on the screen",
                "To synchronize Android devices",
                "To create UI animations",
                "To define images, shapes, and other graphic content that can be drawn on the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android DialogFragment used for?",
                "To create new dialogs",
                "To create database records",
                "To manage app permissions",
                "To play music in the background",
                "To create new dialogs"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewSwitcher used for?",
                "To switch between different views",
                "To manage device resources",
                "To create app layouts",
                "To display advertisements",
                "To switch between different views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android Broadcast Receiver?",
                "To broadcast messages to other apps",
                "To send text messages",
                "To create a new activity",
                "To handle UI interactions",
                "To broadcast messages to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Handler used for?",
                "To handle incoming phone calls",
                "To send and process messages and run code on a different thread",
                "To play music in the background",
                "To manage app layouts",
                "To send and process messages and run code on a different thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Logcat?",
                "To view app advertisements",
                "To display app icons",
                "To view and record logs generated by an app",
                "To create database tables",
                "To view and record logs generated by an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Gradle script?",
                "A script for making coffee",
                "A script for building and configuring Android app projects",
                "A script for playing music",
                "A script for creating database records",
                "A script for building and configuring Android app projects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is a ContentResolver in Android?",
                "A tool for resolving user disputes",
                "A component for managing device resources",
                "A class for accessing and modifying data from content providers",
                "A layout file for resolving UI issues",
                "A class for accessing and modifying data from content providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android AsyncTaskLoader used for?",
                "To load images",
                "To load data on a separate thread and deliver results to the UI thread",
                "To create animations",
                "To play audio files",
                "To load data on a separate thread and deliver results to the UI thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is a FragmentTransaction in Android?",
                "A transaction involving money",
                "A transaction for managing app resources",
                "A transaction for adding, replacing, or removing fragments in an activity",
                "A transaction for creating new activities",
                "A transaction for adding, replacing, or removing fragments in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of an Android PreferenceFragment?",
                "To display user preferences in an activity",
                "To perform background tasks",
                "To manage app layouts",
                "To play music in the background",
                "To display user preferences in an activity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the role of the Android ContentProvider?",
                "To play videos",
                "To store and retrieve structured data and share it with other apps",
                "To design app layouts",
                "To draw custom shapes on the screen",
                "To store and retrieve structured data and share it with other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of an Android Context?",
                "To manage app permissions",
                "To provide access to application-specific resources and components",
                "To make phone calls",
                "To build the Android operating system",
                "To provide access to application-specific resources and components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NotificationManager?",
                "To manage app resources",
                "To display notifications to the user",
                "To control the device's notifications",
                "To store app data",
                "To display notifications to the user"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android BroadcastReceiver used for?",
                "To broadcast a message to other apps",
                "To send text messages",
                "To create a new activity",
                "To play music in the background",
                "To broadcast a message to other apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Material Design?",
                "A design concept for material objects",
                "A design language for creating a consistent, visually appealing user interface",
                "A design for manufacturing physical products",
                "A design for managing app permissions",
                "A design language for creating a consistent, visually appealing user interface"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AdapterView?",
                "To view and edit databases",
                "To manage app layouts",
                "To provide a view for displaying items in a scrollable list",
                "To display app advertisements",
                "To provide a view for displaying items in a scrollable list"
            )
        )

        androidQuestionsList.shuffle()
    }
    fun stageEight() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Jetpack Compose?",
                "A layout design tool",
                "A modern, fully declarative UI toolkit for building native Android interfaces",
                "A feature of Android Studio",
                "A virtual reality development framework",
                "A modern, fully declarative UI toolkit for building native Android interfaces"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android NDK (Native Development Kit) in Android development?",
                "To create UI animations",
                "To develop parts of an Android app using native code, typically in C or C++",
                "To design app layouts",
                "To manage app permissions",
                "To develop parts of an Android app using native code, typically in C or C++"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ViewBinding used for?",
                "To bind data to views in a RecyclerView",
                "To create custom views in Android",
                "To simplify the process of accessing views in your layout files",
                "To create animations",
                "To simplify the process of accessing views in your layout files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Dependency Injection framework, Dagger 2?",
                "To create database records",
                "To generate code for Android layouts",
                "To simplify dependency injection and manage app resources",
                "To play music in the background",
                "To simplify dependency injection and manage app resources"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ViewPager2 used for?",
                "To create animations",
                "To bind data to views in a RecyclerView",
                "To swipe between different fragments or views with improved flexibility and functionality",
                "To manage app layouts",
                "To swipe between different fragments or views with improved flexibility and functionality"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ConstraintLayout used for?",
                "To create database tables",
                "To design complex and flexible layouts with flat view hierarchies",
                "To manage device settings",
                "To display app advertisements",
                "To design complex and flexible layouts with flat view hierarchies"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's LiveData in architecture components?",
                "To create a live streaming app",
                "To represent data that can be observed and notified of changes",
                "To play music in the background",
                "To manage app resources",
                "To represent data that can be observed and notified of changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Repository pattern used for?",
                "To manage app layouts",
                "To simplify data access and abstract the data source from the rest of the app",
                "To synchronize Android devices",
                "To create custom animations",
                "To simplify data access and abstract the data source from the rest of the app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Retrofit library used for?",
                "To create a UI animation library",
                "To make HTTP requests and handle API responses",
                "To create database records",
                "To manage app permissions",
                "To make HTTP requests and handle API responses"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's Room Persistence Library?",
                "To store and retrieve room decoration data",
                "To simplify database access in Android and provide an abstraction layer over SQLite",
                "To display app icons",
                "To create custom layouts",
                "To simplify database access in Android and provide an abstraction layer over SQLite"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Navigation Component used for?",
                "To create navigation bars",
                "To simplify navigation in Android apps and handle transitions between screens",
                "To play videos",
                "To design app layouts",
                "To simplify navigation in Android apps and handle transitions between screens"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Hilt used for?",
                "To perform dependency injection",
                "To create UI animations",
                "To manage device resources",
                "To play music in the background",
                "To perform dependency injection"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android JobScheduler?",
                "To create a job board",
                "To schedule and manage background tasks with various constraints",
                "To create app animations",
                "To display advertisements",
                "To schedule and manage background tasks with various constraints"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Data Binding library used for?",
                "To bind data to views using XML layouts",
                "To play audio files",
                "To create layout files",
                "To manage app permissions",
                "To bind data to views using XML layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's WorkManager used for?",
                "To manage worker ants",
                "To schedule and manage background tasks, including deferrable and guaranteed tasks",
                "To synchronize Android devices",
                "To create database records",
                "To schedule and manage background tasks, including deferrable and guaranteed tasks"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's Coroutines?",
                "To create visual effects",
                "To simplify asynchronous programming in Android using lightweight, structured concurrency",
                "To create app layouts",
                "To display app icons",
                "To simplify asynchronous programming in Android using lightweight, structured concurrency"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android HandlerThread used for?",
                "To manage handsets",
                "To create a dedicated background thread for handling messages",
                "To create animations",
                "To send and receive messages",
                "To create a dedicated background thread for handling messages"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ImageDecoder class used for?",
                "To decode ancient hieroglyphs",
                "To decode images from various sources, such as assets or network streams",
                "To manage app layouts",
                "To display app advertisements",
                "To decode images from various sources, such as assets or network streams"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ViewModel used for in the MVVM architectural pattern?",
                "To create 3D models",
                "To store and manage UI-related data, preserving data during configuration changes",
                "To play videos",
                "To manage app resources",
                "To store and manage UI-related data, preserving data during configuration changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ExoPlayer library?",
                "To create a music playlist",
                "To build high-performance media players for audio and video playback",
                "To create database tables",
                "To design app layouts",
                "To build high-performance media players for audio and video playback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android HandlerThread used for?",
                "To handle phone calls",
                "To create a dedicated background thread for handling messages",
                "To create animations",
                "To send and receive messages",
                "To create a dedicated background thread for handling messages"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android PendingIntent used for?",
                "To create an intent for pending tasks",
                "To schedule an operation to be performed in the future",
                "To manage app layouts",
                "To play music in the background",
                "To schedule an operation to be performed in the future"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Firebase Cloud Messaging (FCM) service?",
                "To manage cloud storage for Android apps",
                "To send messages and notifications to Android devices",
                "To create app animations",
                "To display app icons",
                "To send messages and notifications to Android devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Parcelable interface used for?",
                "To create custom parcels for shipping",
                "To enable objects to be flattened into a byte array for transport between processes",
                "To create database records",
                "To manage device resources",
                "To enable objects to be flattened into a byte array for transport between processes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's SpeechRecognizer?",
                "To manage voice calls",
                "To recognize and transcribe speech into text",
                "To synchronize Android devices",
                "To create UI animations",
                "To recognize and transcribe speech into text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Camera2 API used for?",
                "To take photos with vintage cameras",
                "To provide more advanced control over the device's camera hardware and features",
                "To create animations",
                "To display app advertisements",
                "To provide more advanced control over the device's camera hardware and features"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's BluetoothAdapter used for?",
                "To manage app layouts",
                "To interact with Bluetooth devices and manage Bluetooth connectivity",
                "To play videos",
                "To design app layouts",
                "To interact with Bluetooth devices and manage Bluetooth connectivity"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android JobScheduler?",
                "To create a job board for job seekers",
                "To schedule and manage background tasks with various constraints",
                "To create app animations",
                "To display advertisements",
                "To schedule and manage background tasks with various constraints"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ContentProvider used for?",
                "To create content for an app",
                "To allow apps to share data with other apps and expose data to the system",
                "To create database records",
                "To manage app permissions",
                "To allow apps to share data with other apps and expose data to the system"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ViewPropertyAnimator?",
                "To create property animations for views",
                "To manage device resources",
                "To create app layouts",
                "To play music in the background",
                "To create property animations for views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's CameraX library used for?",
                "To manage music libraries",
                "To simplify camera development on Android with consistent behavior across different devices",
                "To create custom animations",
                "To display app icons",
                "To simplify camera development on Android with consistent behavior across different devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaCodec used for?",
                "To create codec libraries",
                "To encode and decode media content, such as audio and video",
                "To manage app layouts",
                "To create database tables",
                "To encode and decode media content, such as audio and video"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android JobIntentService?",
                "To create job intentions",
                "To schedule background tasks with the benefits of a service",
                "To synchronize Android devices",
                "To create UI animations",
                "To schedule background tasks with the benefits of a service"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Camera API used for?",
                "To create custom cameras",
                "To access and control the device's camera hardware",
                "To create app advertisements",
                "To create animations",
                "To access and control the device's camera hardware"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AccessibilityNodeInfo?",
                "To create accessibility interfaces",
                "To interact with and provide information about UI elements for accessibility services",
                "To display app icons",
                "To manage app resources",
                "To interact with and provide information about UI elements for accessibility services"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's DownloadManager used for?",
                "To manage downloads of Android apps",
                "To initiate and control downloads from the internet",
                "To play videos",
                "To design app layouts",
                "To initiate and control downloads from the internet"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's NotificationCompat.Builder?",
                "To build complex notifications for Android apps",
                "To create animations",
                "To manage device settings",
                "To display app advertisements",
                "To build complex notifications for Android apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's MediaRecorder used for?",
                "To record podcasts",
                "To record audio and video from the device's microphone and camera",
                "To create database records",
                "To create custom animations",
                "To record audio and video from the device's microphone and camera"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android RecyclerView.LayoutManager?",
                "To manage app layouts in a grid pattern",
                "To control the arrangement of items in a RecyclerView",
                "To play music in the background",
                "To create UI animations",
                "To control the arrangement of items in a RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's View.OnTouchListener used for?",
                "To touch up UI layouts",
                "To handle touch events on views",
                "To create app icons",
                "To manage app permissions",
                "To handle touch events on views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android JobDispatcher library?",
                "To dispatch job offers to job seekers",
                "To schedule background tasks on Android, even for devices with API level 9 and higher",
                "To create custom animations",
                "To create app layouts",
                "To schedule background tasks on Android, even for devices with API level 9 and higher"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Lottie library used for?",
                "To create animations in Android apps",
                "To generate lottery numbers",
                "To manage device resources",
                "To synchronize Android devices",
                "To create animations in Android apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Security library?",
                "To enhance device security with biometric authentication",
                "To manage app layouts",
                "To display app icons",
                "To create database tables",
                "To enhance device security with biometric authentication"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Speech API used for?",
                "To analyze speeches",
                "To perform speech recognition and synthesis",
                "To play videos",
                "To design app layouts",
                "To perform speech recognition and synthesis"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ExifInterface?",
                "To create custom interfaces for Android",
                "To read and write Exif data in image files",
                "To create app advertisements",
                "To manage app permissions",
                "To read and write Exif data in image files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Room DAO (Data Access Object) used for?",
                "To design data access operations for database management",
                "To create database records",
                "To manage app resources",
                "To display app icons",
                "To design data access operations for database management"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ActivityResultLauncher?",
                "To launch activities in Android apps",
                "To handle activity results and permissions requests",
                "To synchronize Android devices",
                "To create UI animations",
                "To handle activity results and permissions requests"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's CMake used for?",
                "To create a makeup kit",
                "To build and compile C and C++ code in Android projects",
                "To create custom animations",
                "To create app layouts",
                "To build and compile C and C++ code in Android projects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android TransitionManager?",
                "To manage device transitions",
                "To create transitions and animations for changes in the layout of UI elements",
                "To create app advertisements",
                "To create database tables",
                "To create transitions and animations for changes in the layout of UI elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's BottomNavigationView used for?",
                "To navigate to the bottom of long lists",
                "To provide navigation between top-level views or destinations",
                "To play music in the background",
                "To create UI animations",
                "To provide navigation between top-level views or destinations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's CameraCaptureSession?",
                "To capture camera sessions for photography",
                "To create app layouts",
                "To manage app permissions",
                "To design app layouts",
                "To capture camera sessions for photography"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's DataStore used for?",
                "To store data in a warehouse",
                "To store data asynchronously using a type-safe and modern API",
                "To play videos",
                "To display app icons",
                "To store data asynchronously using a type-safe and modern API"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's SoundPool?",
                "To create soundscapes",
                "To play a large number of short audio clips with low latency",
                "To create animations",
                "To synchronize Android devices",
                "To play a large number of short audio clips with low latency"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's BluetoothGatt used for?",
                "To manage gattling guns",
                "To interact with Bluetooth Low Energy (BLE) devices",
                "To create custom animations",
                "To create database records",
                "To interact with Bluetooth Low Energy (BLE) devices"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ViewPager2.OnPageChangeCallback?",
                "To manage page changes in a book",
                "To listen for page change events in a ViewPager2",
                "To display app advertisements",
                "To manage app resources",
                "To listen for page change events in a ViewPager2"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's WebSocket used for?",
                "To create a web of spiders",
                "To establish real-time, full-duplex communication with a server",
                "To create app layouts",
                "To play music in the background",
                "To establish real-time, full-duplex communication with a server"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's Handler.Callback?",
                "To manage callbacks for phone calls",
                "To handle messages and run code on a background thread",
                "To create database tables",
                "To design app layouts",
                "To handle messages and run code on a background thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's RecyclerView.Adapter.ListAdapter used for?",
                "To create shopping lists",
                "To adapt lists with data to be displayed in a RecyclerView with efficient updates",
                "To create custom animations",
                "To manage device resources",
                "To adapt lists with data to be displayed in a RecyclerView with efficient updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's AudioRecord?",
                "To create custom audio recordings",
                "To record audio from the device's microphone",
                "To synchronize Android devices",
                "To create UI animations",
                "To record audio from the device's microphone"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's JobInfo.Builder used for?",
                "To build job boards for job seekers",
                "To create and configure job requirements for JobScheduler",
                "To create app advertisements",
                "To create animations",
                "To create and configure job requirements for JobScheduler"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's AudioManager.OnAudioFocusChangeListener?",
                "To focus on audio books",
                "To listen for changes in audio focus and handle audio playback accordingly",
                "To manage app layouts",
                "To display app icons",
                "To listen for changes in audio focus and handle audio playback accordingly"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's CameraX ImageAnalysis used for?",
                "To analyze historical images",
                "To perform real-time image analysis on camera frames",
                "To play videos",
                "To design app layouts",
                "To perform real-time image analysis on camera frames"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's MediaPlayer.OnErrorListener?",
                "To listen to audio errors",
                "To handle errors that occur during media playback with MediaPlayer",
                "To create custom animations",
                "To manage app permissions",
                "To handle errors that occur during media playback with MediaPlayer"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ContentResolver used for?",
                "To resolve content disputes",
                "To access and manipulate content from different content providers",
                "To create database records",
                "To create UI animations",
                "To access and manipulate content from different content providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AssetManager?",
                "To manage assets like jewelry",
                "To access application assets, such as files and fonts, in an Android app",
                "To synchronize Android devices",
                "To create app layouts",
                "To access application assets, such as files and fonts, in an Android app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's BottomSheetDialogFragment used for?",
                "To manage bottom sheets",
                "To display a modal bottom sheet dialog",
                "To create custom animations",
                "To display app icons",
                "To display a modal bottom sheet dialog"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentResolver used for?",
                "To resolve user disputes",
                "To manage device resources",
                "To query, insert, update, and delete data through a content provider",
                "To create app layouts",
                "To query, insert, update, and delete data through a content provider"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android HandlerThread?",
                "A thread for handling phone calls",
                "A thread for handling app layouts",
                "A thread for handling messages on a separate thread",
                "A type of layout in Android",
                "A thread for handling messages on a separate thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Loader class?",
                "To load apps into memory",
                "To load data from a content provider asynchronously",
                "To create app advertisements",
                "To create new activities",
                "To load data from a content provider asynchronously"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android FrameLayout used for?",
                "To frame photos",
                "To create animation frames",
                "To contain a single item or fragment",
                "To manage app permissions",
                "To contain a single item or fragment"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android SQLiteOpenHelper used for?",
                "To help with SQLite database operations",
                "To create animations",
                "To design app layouts",
                "To play music in the background",
                "To help with SQLite database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ActionBarDrawerToggle?",
                "A toggle switch for the app bar",
                "A drawer toggle for app navigation",
                "A switch for turning off advertisements",
                "A tool for managing app resources",
                "A drawer toggle for app navigation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android AutoCompleteTextView used for?",
                "To view the auto complete list",
                "To send text messages",
                "To provide auto-completion suggestions as the user types",
                "To create database records",
                "To provide auto-completion suggestions as the user types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MediaRecorder used for?",
                "To create custom media players",
                "To record audio and video",
                "To design app layouts",
                "To perform background tasks",
                "To record audio and video"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android ContentValues class used for?",
                "To create animations",
                "To store values for database operations",
                "To play music in the background",
                "To manage app layouts",
                "To store values for database operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android MenuInflater used for?",
                "To create animations",
                "To prepare food menus",
                "To inflate menu resources into a Menu object",
                "To manage app resources",
                "To inflate menu resources into a Menu object"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android VectorDrawable used for?",
                "To draw vector graphics",
                "To create database records",
                "To play videos",
                "To manage app permissions",
                "To draw vector graphics"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android Canvas used for?",
                "To store app data",
                "To create animations",
                "To draw graphics on a View",
                "To create database tables",
                "To draw graphics on a View"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is an Android MotionEvent used for?",
                "A type of event related to motion",
                "A device for measuring motion",
                "A type of music player",
                "A type of layout",
                "A type of event related to motion"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android GestureDetector used for?",
                "To detect device gestures",
                "To create custom layouts",
                "To manage app resources",
                "To play music in the background",
                "To detect device gestures"
            )
        )

        androidQuestionsList.shuffle()

    }
    fun stageNine() {
        androidQuestionsList.clear()

        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android PackageManager used for?",
                "To manage package delivery",
                "To retrieve information about installed apps and manage app installation and updates",
                "To create custom layouts",
                "To synchronize Android devices",
                "To retrieve information about installed apps and manage app installation and updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ViewModelProvider.Factory used for?",
                "To provide factories for creating ViewModels",
                "To manage factory production lines",
                "To play music in the background",
                "To create UI animations",
                "To provide factories for creating ViewModels"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's Gradle build system in app development?",
                "To grade app performance",
                "To automate the build process and manage dependencies in Android projects",
                "To create database records",
                "To design app layouts",
                "To automate the build process and manage dependencies in Android projects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's WebView used for?",
                "To view web content within an app",
                "To record web content",
                "To display app icons",
                "To manage app permissions",
                "To view web content within an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android Handler in multithreading?",
                "To handle threads",
                "To manage background tasks in the main (UI) thread",
                "To create app animations",
                "To create custom threads",
                "To manage background tasks in the main (UI) thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's DataBinding used for?",
                "To bind data to data cables",
                "To connect UI components in the layout with data sources",
                "To synchronize Android devices",
                "To create animations",
                "To connect UI components in the layout with data sources"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android HandlerThread?",
                "To thread handlers with needles",
                "To create a dedicated background thread for handling messages",
                "To manage device resources",
                "To create database tables",
                "To create a dedicated background thread for handling messages"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's JobScheduler used for?",
                "To schedule job interviews",
                "To schedule background tasks with various constraints",
                "To display app advertisements",
                "To create custom animations",
                "To schedule background tasks with various constraints"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ExoPlayer library?",
                "To play vintage music",
                "To build high-performance media players for audio and video playback",
                "To play videos",
                "To design app layouts",
                "To build high-performance media players for audio and video playback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Broadcast Receiver used for?",
                "To receive broadcasting signals",
                "To listen for and respond to system-wide broadcast announcements",
                "To manage app layouts",
                "To create app animations",
                "To listen for and respond to system-wide broadcast announcements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's AAC (Android Architecture Components) used for?",
                "To build architectural wonders",
                "To provide a set of libraries to help structure Android applications",
                "To create custom layouts",
                "To play music in the background",
                "To provide a set of libraries to help structure Android applications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's DownloadManager?",
                "To download wallpapers",
                "To initiate and control downloads from the internet",
                "To manage device settings",
                "To create animations",
                "To initiate and control downloads from the internet"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's CountDownTimer used for?",
                "To count down the days",
                "To create a timer that counts down to a specified time interval",
                "To create app icons",
                "To display app advertisements",
                "To create a timer that counts down to a specified time interval"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android DialogFragment?",
                "To create dialog boxes",
                "To create app preferences",
                "To play audio files",
                "To manage app permissions",
                "To create dialog boxes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's AudioTrack used for?",
                "To track audio recordings",
                "To play and record audio at a low level",
                "To create database records",
                "To synchronize Android devices",
                "To play and record audio at a low level"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's AppCompat library?",
                "To provide compatibility for app reviews",
                "To enable backward-compatible features and styling for Android apps",
                "To create UI animations",
                "To manage app resources",
                "To enable backward-compatible features and styling for Android apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Schedulers in RxJava used for?",
                "To schedule tasks for remote execution",
                "To specify the thread on which an Observable will operate",
                "To create custom animations",
                "To create app layouts",
                "To specify the thread on which an Observable will operate"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android DataBinding library?",
                "To create binding contracts",
                "To bind UI components in layouts to data sources in a declarative format",
                "To display app icons",
                "To create animations",
                "To bind UI components in layouts to data sources in a declarative format"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ViewBinding used for?",
                "To bind views with a strong handshake",
                "To simplify the process of accessing views in your layout files",
                "To manage device resources",
                "To play videos",
                "To simplify the process of accessing views in your layout files"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android DownloadManager.Request?",
                "To request permission for downloads",
                "To configure the parameters of a download request, such as the URL and destination",
                "To create custom layouts",
                "To manage app permissions",
                "To configure the parameters of a download request, such as the URL and destination"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Shared Element Transition used for?",
                "To share transition photos",
                "To create smooth transitions when navigating between activities or fragments",
                "To create app advertisements",
                "To create database tables",
                "To create smooth transitions when navigating between activities or fragments"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's Downloadable Fonts feature?",
                "To download font styles",
                "To download and use fonts in an app dynamically",
                "To create app animations",
                "To synchronize Android devices",
                "To download and use fonts in an app dynamically"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's LifecycleObserver used for?",
                "To observe life events",
                "To observe and react to lifecycle events of a component, such as an Activity or Fragment",
                "To play music in the background",
                "To manage app layouts",
                "To observe and react to lifecycle events of a component, such as an Activity or Fragment"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's LoaderManager?",
                "To load laundry",
                "To manage loaders that load data asynchronously in Android",
                "To create custom animations",
                "To display app icons",
                "To manage loaders that load data asynchronously in Android"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's MultiDex used for?",
                "To create a multi-dimensional array",
                "To enable apps to have more than 65,536 method references",
                "To create database records",
                "To design app layouts",
                "To enable apps to have more than 65,536 method references"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's Material Design Components (MDC) library?",
                "To design material components for a spacecraft",
                "To provide a wide range of pre-built, customizable UI components with a consistent material design",
                "To play videos",
                "To create animations",
                "To provide a wide range of pre-built, customizable UI components with a consistent material design"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's TextureView used for?",
                "To view textures on the wall",
                "To efficiently display video or camera preview streams",
                "To manage device settings",
                "To create animations",
                "To efficiently display video or camera preview streams"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ContentObserver?",
                "To observe content consumption",
                "To monitor changes to data in a content provider and react to them",
                "To display app advertisements",
                "To create app layouts",
                "To monitor changes to data in a content provider and react to them"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Chip component used for?",
                "To create potato chips",
                "To represent a compact, material design choice in the form of a chip",
                "To synchronize Android devices",
                "To create UI animations",
                "To represent a compact, material design choice in the form of a chip"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ViewModelProviders?",
                "To provide providers for view models",
                "To retrieve a ViewModel and associate it with the lifecycle of an activity or fragment",
                "To create database tables",
                "To create custom animations",
                "To retrieve a ViewModel and associate it with the lifecycle of an activity or fragment"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's AAC (Android Architecture Components) LiveData used for?",
                "To create a live data stream",
                "To hold and observe data changes, notifying observers when the data changes",
                "To create app layouts",
                "To display app icons",
                "To hold and observe data changes, notifying observers when the data changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's AAC (Android Architecture Components) Room?",
                "To create a room for architectural design",
                "To provide an abstraction layer over SQLite and enable database access",
                "To create animations",
                "To manage app permissions",
                "To provide an abstraction layer over SQLite and enable database access"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's NavigationUI used for?",
                "To create navigation interfaces",
                "To work with the Navigation component and easily set up app navigation with UI components",
                "To manage device resources",
                "To play music in the background",
                "To work with the Navigation component and easily set up app navigation with UI components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's DataBindingAdapter?",
                "To bind data with adapters",
                "To bind data to views in RecyclerViews using data binding",
                "To create custom layouts",
                "To create database records",
                "To bind data to views in RecyclerViews using data binding"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ConstraintLayout used for?",
                "To create constraint-based puzzles",
                "To design complex and flexible layouts with flat view hierarchies",
                "To display app advertisements",
                "To design app layouts",
                "To design complex and flexible layouts with flat view hierarchies"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's AccessibilityService?",
                "To create accessible services",
                "To provide accessibility enhancements for users with disabilities",
                "To synchronize Android devices",
                "To create UI animations",
                "To provide accessibility enhancements for users with disabilities"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's RemoteViews used for?",
                "To create remote controls",
                "To create and update app widgets with layouts that can be displayed on the home screen",
                "To play videos",
                "To create animations",
                "To create and update app widgets with layouts that can be displayed on the home screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's WorkInfo?",
                "To provide information about working conditions",
                "To represent the status and results of work requests scheduled with WorkManager",
                "To create app advertisements",
                "To manage app resources",
                "To represent the status and results of work requests scheduled with WorkManager"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Downloadable Fonts feature used for?",
                "To download font varieties",
                "To download and use fonts in an app on-demand",
                "To create database tables",
                "To display app icons",
                "To download and use fonts in an app on-demand"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's IntentService?",
                "To manage intents with a service",
                "To perform background tasks in response to Intents, with automatic queuing",
                "To create animations",
                "To manage device settings",
                "To perform background tasks in response to Intents, with automatic queuing"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Material Design used for?",
                "To design material for construction",
                "To provide a set of design guidelines for creating visually appealing Android apps",
                "To play music in the background",
                "To create UI animations",
                "To provide a set of design guidelines for creating visually appealing Android apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android AccessibilityNodeProvider?",
                "To provide accessibility nodes with providers",
                "To allow accessibility services to interact with and provide information about UI elements",
                "To create app layouts",
                "To display app icons",
                "To allow accessibility services to interact with and provide information about UI elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's LayerDrawable used for?",
                "To create layered drawings",
                "To manage drawables composed of multiple layers",
                "To manage app permissions",
                "To create custom animations",
                "To manage drawables composed of multiple layers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's WorkRequest?",
                "To request work permits",
                "To define and configure a unit of work to be performed by WorkManager",
                "To create app advertisements",
                "To create animations",
                "To define and configure a unit of work to be performed by WorkManager"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's BaseAdapter used for?",
                "To create base stations",
                "To create a simple adapter for populating views in an AdapterView",
                "To synchronize Android devices",
                "To create database records",
                "To create a simple adapter for populating views in an AdapterView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's WindowInsetsCompat?",
                "To manage window shades",
                "To access information about the window insets (system UI areas) in Android",
                "To create custom animations",
                "To display app icons",
                "To access information about the window insets (system UI areas) in Android"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ContentProviderOperation used for?",
                "To operate on content providers",
                "To encapsulate a set of content provider operations to be applied in a batch",
                "To create app layouts",
                "To manage device resources",
                "To encapsulate a set of content provider operations to be applied in a batch"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's FragmentTransaction?",
                "To make fragment transactions",
                "To perform a series of fragment transactions, such as add, replace, or remove",
                "To play videos",
                "To design app layouts",
                "To perform a series of fragment transactions, such as add, replace, or remove"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ExpandableListView used for?",
                "To create expandable lists",
                "To create a two-level, expandable list that displays groups and their child items",
                "To create app advertisements",
                "To create animations",
                "To create a two-level, expandable list that displays groups and their child items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the Android DialogPreference?",
                "To create dialog preferences",
                "To display a dialog for user interaction to set preferences in an app",
                "To create database tables",
                "To manage app permissions",
                "To display a dialog for user interaction to set preferences in an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Lint tool used for?",
                "To analyze lint in clothes",
                "To perform static code analysis on Android projects and identify issues and improvements",
                "To synchronize Android devices",
                "To create UI animations",
                "To perform static code analysis on Android projects and identify issues and improvements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's SaveState annotation?",
                "To save states of video games",
                "To indicate that a component's state can be automatically saved and restored",
                "To create custom animations",
                "To manage app layouts",
                "To indicate that a component's state can be automatically saved and restored"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's SeekBar used for?",
                "To seek bars of chocolate",
                "To allow users to select a value from a range by dragging a thumb",
                "To create app icons",
                "To display app icons",
                "To allow users to select a value from a range by dragging a thumb"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's SimpleCursorAdapter?",
                "To create simple cursor adaptations",
                "To adapt data from a Cursor to views for use in a ListView or other AdapterView",
                "To play music in the background",
                "To create animations",
                "To adapt data from a Cursor to views for use in a ListView or other AdapterView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's SlidingDrawer used for?",
                "To draw sliding doors",
                "To create a sliding drawer that can be pulled out from the bottom or the side of the screen",
                "To manage app layouts",
                "To create custom layouts",
                "To create a sliding drawer that can be pulled out from the bottom or the side of the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's NetworkOnMainThreadException?",
                "To warn about network threads",
                "To indicate when a network operation is being executed on the main (UI) thread",
                "To create animations",
                "To manage device resources",
                "To indicate when a network operation is being executed on the main (UI) thread"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's GestureDetector used for?",
                "To detect dancing gestures",
                "To simplify detecting common gestures, such as swipes and double-taps",
                "To create database records",
                "To display app advertisements",
                "To simplify detecting common gestures, such as swipes and double-taps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ExpandableListActivity?",
                "To list expandable activities",
                "To provide a pre-built activity for displaying expandable lists",
                "To create app advertisements",
                "To design app layouts",
                "To provide a pre-built activity for displaying expandable lists"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's SQLiteOpenHelper used for?",
                "To help with SQL dating",
                "To manage database creation and version management",
                "To manage app permissions",
                "To create custom animations",
                "To manage database creation and version management"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's SwipeRefreshLayout?",
                "To refresh swipe actions",
                "To provide a simple way to add swipe-to-refresh functionality to a view",
                "To play videos",
                "To synchronize Android devices",
                "To provide a simple way to add swipe-to-refresh functionality to a view"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's TextToSpeech used for?",
                "To convert text to Shakespearean speech",
                "To convert text into speech and provide spoken feedback",
                "To display app icons",
                "To create animations",
                "To convert text into speech and provide spoken feedback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's AutoCompleteTextView?",
                "To complete texts automatically",
                "To provide a text box that shows suggestions as the user types",
                "To create custom layouts",
                "To manage device resources",
                "To provide a text box that shows suggestions as the user types"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's DownloadProgressInfo used for?",
                "To track the progress of downloads",
                "To represent information about the progress of a download",
                "To create app layouts",
                "To display app advertisements",
                "To represent information about the progress of a download"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's NinePatchDrawable?",
                "To create nine-patch patches",
                "To define resizable bitmaps for UI elements in Android with stretchable regions",
                "To create database tables",
                "To manage app permissions",
                "To define resizable bitmaps for UI elements in Android with stretchable regions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ScrollView used for?",
                "To view scrolls",
                "To create a scrollable view that can display more content than the screen can hold",
                "To play music in the background",
                "To create animations",
                "To create a scrollable view that can display more content than the screen can hold"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's MediaMetadataRetriever?",
                "To retrieve media medals",
                "To extract metadata from media files, such as videos and audio",
                "To synchronize Android devices",
                "To design app layouts",
                "To extract metadata from media files, such as videos and audio"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's FragmentStatePagerAdapter used for?",
                "To create stateful fragment adapters",
                "To create an adapter for managing fragments within a ViewPager with state-saving capabilities",
                "To create custom animations",
                "To manage app resources",
                "To create an adapter for managing fragments within a ViewPager with state-saving capabilities"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's BottomAppBar?",
                "To create bars at the bottom",
                "To provide an alternative to the traditional app bar for placement at the bottom of the screen",
                "To create UI animations",
                "To display app icons",
                "To provide an alternative to the traditional app bar for placement at the bottom of the screen"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's NavHostFragment used for?",
                "To create navigation hosts for travel agencies",
                "To host the navigation graph and provide a container for destination fragments",
                "To play videos",
                "To design app layouts",
                "To host the navigation graph and provide a container for destination fragments"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's Camera2 API?",
                "To capture a pair of cameras",
                "To provide more control and flexibility for camera features and functions",
                "To create app advertisements",
                "To create custom animations",
                "To provide more control and flexibility for camera features and functions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ShareActionProvider used for?",
                "To share actions with providers",
                "To enable sharing actions and providing a sharing UI for an app",
                "To create database records",
                "To display app icons",
                "To enable sharing actions and providing a sharing UI for an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's TextureView.SurfaceTextureListener?",
                "To listen to surface textures",
                "To listen for changes to the underlying SurfaceTexture of a TextureView",
                "To create animations",
                "To manage app permissions",
                "To listen for changes to the underlying SurfaceTexture of a TextureView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's SlidingPaneLayout used for?",
                "To slide in and out of layouts",
                "To create a layout that consists of two views, with one sliding over the other",
                "To manage app layouts",
                "To synchronize Android devices",
                "To create a layout that consists of two views, with one sliding over the other"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ConstraintSet?",
                "To set constraints for imprisonment",
                "To define a set of constraints for a ConstraintLayout programmatically",
                "To create app advertisements",
                "To create custom layouts",
                "To define a set of constraints for a ConstraintLayout programmatically"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's ContextMenu used for?",
                "To create contextual menus",
                "To create floating menus that appear in response to a long-click or press-and-hold gesture",
                "To play music in the background",
                "To display app icons",
                "To create floating menus that appear in response to a long-click or press-and-hold gesture"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's TableRow?",
                "To create rows of tables",
                "To create a row within a TableLayout for organizing child views in a table",
                "To create animations",
                "To manage device resources",
                "To create a row within a TableLayout for organizing child views in a table"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's NotificationCompat.Builder used for?",
                "To build notifications with compatibility",
                "To create notifications with compatibility for different Android versions",
                "To display app advertisements",
                "To create animations",
                "To create notifications with compatibility for different Android versions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's AppLinkData?",
                "To link apps together",
                "To provide information about deep links into an app",
                "To manage app permissions",
                "To create UI animations",
                "To provide information about deep links into an app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's Path used for?",
                "To create paths in the wilderness",
                "To define a path in 2D space, which can be used for drawing vector graphics",
                "To create database tables",
                "To design app layouts",
                "To define a path in 2D space, which can be used for drawing vector graphics"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's WorkInfo.State?",
                "To indicate work states",
                "To represent the state of a work request, such as ENQUEUED, RUNNING, SUCCEEDED, or FAILED",
                "To create app layouts",
                "To synchronize Android devices",
                "To represent the state of a work request, such as ENQUEUED, RUNNING, SUCCEEDED, or FAILED"
            )
        )

        androidQuestionsList.shuffle()

    }
    fun stageTen() {
        androidQuestionsList.clear()
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which layout manager is most suitable for complex and responsive UI designs in Android?",
                "ConstraintLayout",
                "FrameLayout",
                "RelativeLayout",
                "TableLayout",
                "ConstraintLayout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the 'Data Binding' library in Android development?",
                "Binding data to UI components",
                "Creating data models",
                "Handling network requests",
                "Implementing Parcelable",
                "Binding data to UI components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android, what is the purpose of the 'dex' file?",
                "Compiled Dalvik Executable",
                "Debugging Extension",
                "Data Exchange Format",
                "Dalvik Export",
                "Compiled Dalvik Executable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the Android Architecture Components library primarily used for?",
                "Simplifying app architecture",
                "Creating user interfaces",
                "Managing resources",
                "Debugging applications",
                "Simplifying app architecture"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android, what is the purpose of 'Proximity Sensor'?",
                "Detecting nearby objects",
                "Measuring screen brightness",
                "Tracking GPS location",
                "Monitoring network traffic",
                "Detecting nearby objects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Android API level introduced support for the Android TV platform?",
                "API level 21 (Lollipop)",
                "API level 17 (Jelly Bean)",
                "API level 19 (KitKat)",
                "API level 23 (Marshmallow)",
                "API level 21 (Lollipop)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does the term 'AAPT' stand for in Android development?",
                "Android Asset Packaging Tool",
                "Android Application Package Tool",
                "Android Application Programming Toolkit",
                "Android Asset Preparation Tool",
                "Android Asset Packaging Tool"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which design pattern is typically used for managing the presentation layer in Android apps?",
                "MVP (Model-View-Presenter)",
                "MVC (Model-View-Controller)",
                "MVVM (Model-View-ViewModel)",
                "Singleton Pattern",
                "MVP (Model-View-Presenter)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android, what is the primary function of the 'PackageManager'?",
                "Managing installed applications",
                "Managing device hardware",
                "Handling user permissions",
                "Executing background services",
                "Managing installed applications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'Android Instant Apps'?",
                "Run apps without installation",
                "Access system settings",
                "Monitor battery usage",
                "Capture screenshots",
                "Run apps without installation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which API level introduced the Android Navigation Component?",
                "API level 28 (Pie)",
                "API level 26 (Oreo)",
                "API level 30 (Android 11)",
                "API level 24 (Nougat)",
                "API level 28 (Pie)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'App Widgets' in Android?",
                "Provide quick access to app features",
                "Run background services",
                "Create native libraries",
                "Implement gesture controls",
                "Provide quick access to app features"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the main advantage of using 'ContentProviders' for data access in Android?",
                "Enabling data sharing between apps",
                "Simplifying database design",
                "Improving UI performance",
                "Reducing app size",
                "Enabling data sharing between apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which component is responsible for handling push notifications in Android?",
                "Firebase Cloud Messaging (FCM)",
                "Google Play Services",
                "ContentResolver",
                "IntentService",
                "Firebase Cloud Messaging (FCM)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VectorDrawable' used for in Android?",
                "Scalable and resolution-independent images",
                "Audio playback",
                "3D rendering",
                "Hardware acceleration",
                "Scalable and resolution-independent images"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Android feature is used to enhance the security of WebView components?",
                "Safe Browsing",
                "Network Security Config",
                "ContentProvider",
                "TrustManager",
                "Safe Browsing"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'Android NDK' (Native Development Kit)?",
                "Developing native code in C/C++",
                "Designing user interfaces",
                "Managing app resources",
                "Building APK files",
                "Developing native code in C/C++"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android development, what does 'ANR' stand for?",
                "Application Not Responding",
                "Android Notification Receiver",
                "Asynchronous Network Request",
                "Android Naming Rule",
                "Application Not Responding"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'JobScheduler' in Android?",
                "Managing background tasks efficiently",
                "Handling UI events",
                "Controlling device power",
                "Scheduling app updates",
                "Managing background tasks efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which encryption algorithm is commonly used to secure data in Android's SharedPreferences?",
                "AES (Advanced Encryption Standard)",
                "DES (Data Encryption Standard)",
                "RSA (Rivest-Shamir-Adleman)",
                "MD5 (Message Digest Algorithm 5)",
                "AES (Advanced Encryption Standard)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does the 'WebP' format offer in Android development?",
                "Efficient image compression",
                "3D modeling",
                "Video playback",
                "XML parsing",
                "Efficient image compression"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Traceview' in Android development?",
                "Profiling app performance",
                "Layout design",
                "Network communication",
                "Database management",
                "Profiling app performance"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which version of Android introduced the 'Doze' mode for power-saving?",
                "Android 6.0 (Marshmallow)",
                "Android 4.4 (KitKat)",
                "Android 5.0 (Lollipop)",
                "Android 7.0 (Nougat)",
                "Android 6.0 (Marshmallow)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Bionic' in the context of Android?",
                "Android's C library",
                "Android's kernel",
                "Android's graphics engine",
                "Android's emulator",
                "Android's C library"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which XML file is used for specifying the theme and layout for the entire application in Android?",
                "AndroidManifest.xml",
                "strings.xml",
                "styles.xml",
                "layout.xml",
                "styles.xml"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the maximum size limit for an Android application's data folder?",
                "4 GB",
                "8 GB",
                "16 GB",
                "32 GB",
                "4 GB"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android, what is 'Looper' primarily used for?",
                "Managing message queues",
                "Displaying notifications",
                "Monitoring device sensors",
                "Enforcing app permissions",
                "Managing message queues"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'PackageManager' used for in Android development?",
                "Managing app installations and updates",
                "Creating user interfaces",
                "Optimizing database queries",
                "Handling network requests",
                "Managing app installations and updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which architectural pattern is commonly used in Android development to separate concerns and promote modularity?",
                "MVP (Model-View-Presenter)",
                "MVC (Model-View-Controller)",
                "MVVM (Model-View-ViewModel)",
                "Singleton Pattern",
                "MVVM (Model-View-ViewModel)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RenderScript' used for in Android?",
                "High-performance computation",
                "User interface design",
                "Audio playback",
                "Background services",
                "High-performance computation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android, what is 'Android Beam' primarily used for?",
                "NFC-based data transfer",
                "Screen mirroring",
                "App testing",
                "3D rendering",
                "NFC-based data transfer"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ContentResolver' in Android?",
                "Accessing content providers",
                "Managing layouts",
                "Creating custom views",
                "Handling notifications",
                "Accessing content providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does 'ANT' stand for in the context of Android development?",
                "Android Native Tools",
                "Android Network Tester",
                "Android Networking Toolkit",
                "Android Navigation Tool",
                "Android Native Tools"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which of the following is not a type of PendingIntent in Android?",
                "FLAG_UPDATE_CURRENT",
                "FLAG_ONE_SHOT",
                "FLAG_IMMUTABLE",
                "FLAG_NO_CREATE",
                "FLAG_IMMUTABLE"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Stripped Down Android' (SDA) used for?",
                "Creating lightweight Android variants",
                "Testing Android games",
                "Building Android emulators",
                "Developing Android widgets",
                "Creating lightweight Android variants"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Android API is used for capturing and analyzing user gestures, such as taps and swipes?",
                "Gesture API",
                "MotionLayout API",
                "TouchEvent API",
                "GestureDetector API",
                "GestureDetector API"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android, what is the primary function of 'ExoPlayer'?",
                "Media playback",
                "User authentication",
                "Location tracking",
                "Database management",
                "Media playback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'Trace' file used for in Android?",
                "Performance profiling",
                "Resource management",
                "Layout design",
                "Localization",
                "Performance profiling"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AIDL' (Android Interface Definition Language) used for?",
                "Defining inter-process communication interfaces",
                "Data serialization",
                "User authentication",
                "Application debugging",
                "Defining inter-process communication interfaces"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which API level introduced the Android Navigation Architecture Component?",
                "API level 28 (Pie)",
                "API level 26 (Oreo)",
                "API level 30 (Android 11)",
                "API level 24 (Nougat)",
                "API level 28 (Pie)"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'RenderScript' in Android development?",
                "High-performance computation",
                "User interface design",
                "Audio playback",
                "Background services",
                "High-performance computation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "In Android development, what does 'ANR' stand for?",
                "Application Not Responding",
                "Android Notification Receiver",
                "Asynchronous Network Request",
                "Android Naming Rule",
                "Application Not Responding"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of the 'Looper' in Android?",
                "Managing message queues",
                "Managing network connections",
                "Running background services",
                "Displaying system notifications",
                "Managing message queues"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does the 'WebP' image format offer in Android development?",
                "Efficient image compression",
                "Vector graphics support",
                "Audio playback capabilities",
                "Gesture recognition",
                "Efficient image compression"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Android Beam' in Android?",
                "NFC-based data transfer",
                "Screen mirroring",
                "Audio streaming",
                "2D barcode scanning",
                "NFC-based data transfer"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the maximum recommended heap size for a 32-bit Android app?",
                "512 MB",
                "1 GB",
                "2 GB",
                "4 GB",
                "512 MB"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Android API is used for background processing tasks that require no user interface?",
                "IntentService",
                "Service",
                "AsyncTask",
                "HandlerThread",
                "IntentService"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Fused Location Provider' used for in Android?",
                "Efficient location updates",
                "Audio processing",
                "Network security",
                "Layout design",
                "Efficient location updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'JNI' (Java Native Interface) used for in Android development?",
                "Integrating native code with Java",
                "Implementing user interfaces",
                "Handling JSON data",
                "Synchronizing data with a remote server",
                "Integrating native code with Java"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ContentResolver' used for in Android?",
                "Accessing content providers",
                "Handling user preferences",
                "Encrypting data",
                "Managing app permissions",
                "Accessing content providers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which class is used for handling animations in Android?",
                "AnimatorSet",
                "AnimationDrawable",
                "AnimatorInflater",
                "AnimationController",
                "AnimatorSet"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of the 'AccountManager' in Android?",
                "Managing user accounts",
                "Monitoring network traffic",
                "Controlling device power",
                "Handling notifications",
                "Managing user accounts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Dagger 2' used for in Android development?",
                "Dependency injection",
                "Database management",
                "Layout design",
                "Network communication",
                "Dependency injection"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Android component is used for managing app navigation and back stack?",
                "NavController",
                "FragmentManager",
                "ActivityManager",
                "AppCompatDelegate",
                "NavController"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ContentProvider' used for in Android?",
                "Sharing data between apps",
                "Creating user interfaces",
                "Managing app resources",
                "Displaying notifications",
                "Sharing data between apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SparseArray' used for in Android?",
                "Efficient data storage",
                "Multi-threading",
                "OpenGL rendering",
                "User authentication",
                "Efficient data storage"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'OkHttp' used for in Android development?",
                "HTTP requests",
                "User authentication",
                "SQLite database operations",
                "Location tracking",
                "HTTP requests"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'Jetpack Compose' in Android development?",
                "Modern UI toolkit",
                "Database management",
                "Thread synchronization",
                "Audio playback",
                "Modern UI toolkit"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'HandlerThread' in Android?",
                "Simplified background threading",
                "User authentication",
                "ContentProvider management",
                "OpenGL rendering",
                "Simplified background threading"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Room' used for in Android development?",
                "Database persistence library",
                "Audio playback library",
                "UI design library",
                "Network communication library",
                "Database persistence library"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'R8' used for in Android development?",
                "Code shrinking and obfuscation",
                "Database management",
                "UI design",
                "Audio playback",
                "Code shrinking and obfuscation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LeakCanary' used for in Android development?",
                "Memory leak detection",
                "Location tracking",
                "Database synchronization",
                "Gesture recognition",
                "Memory leak detection"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'Zygote' process in Android?",
                "Parent process for app launch",
                "Background service process",
                "Media playback process",
                "App resource management process",
                "Parent process for app launch"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which tool is used to inspect and profile CPU and memory usage in an Android app?",
                "Android Profiler",
                "APK Analyzer",
                "Lint",
                "Memory Monitor",
                "Android Profiler"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DataBinding' used for in Android development?",
                "Binding data to UI components",
                "Database management",
                "Audio playback",
                "Network communication",
                "Binding data to UI components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'JNI' (Java Native Interface) used for in Android development?",
                "Integrating native code with Java",
                "Handling JSON data",
                "Synchronizing data with a remote server",
                "Implementing user interfaces",
                "Integrating native code with Java"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'WebP' in Android development?",
                "Efficient image compression",
                "Audio playback",
                "Vector graphics rendering",
                "3D modeling",
                "Efficient image compression"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Android API is used for creating and managing notification channels?",
                "NotificationManager",
                "NotificationCompat",
                "NotificationChannelManager",
                "NotificationBuilder",
                "NotificationManager"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'LeakCanary' in Android development?",
                "Memory leak detection",
                "Network traffic monitoring",
                "Database management",
                "User interface design",
                "Memory leak detection"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does 'ART' stand for in the context of Android development?",
                "Android Runtime",
                "Advanced Resource Toolkit",
                "Application Response Time",
                "Android Resource Type",
                "Android Runtime"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Flutter' used for in the context of Android development?",
                "UI framework for building natively compiled applications",
                "Database management",
                "ContentProvider management",
                "Audio playback",
                "UI framework for building natively compiled applications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'Looper' used for in Android development?",
                "Managing message queues",
                "Audio playback",
                "Location tracking",
                "User authentication",
                "Managing message queues"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'OkHttp' in Android development?",
                "HTTP requests",
                "User authentication",
                "SQLite database operations",
                "Location tracking",
                "HTTP requests"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Android Studio Arctic Fox' in Android development?",
                "A version of Android Studio",
                "A gaming framework",
                "An app optimization tool",
                "A security feature",
                "A version of Android Studio"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of the 'Paging Library' in Android development?",
                "Loading large data sets efficiently",
                "Database synchronization",
                "Audio playback",
                "User authentication",
                "Loading large data sets efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does 'Safetynet API' provide in Android development?",
                "Security and integrity checks",
                "Database encryption",
                "Networking capabilities",
                "User authentication",
                "Security and integrity checks"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'Android NDK' (Native Development Kit)?",
                "Developing native code in C/C++",
                "Designing user interfaces",
                "Managing app resources",
                "Building APK files",
                "Developing native code in C/C++"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'Zygote' process in Android?",
                "Parent process for app launch",
                "Background service process",
                "Media playback process",
                "App resource management process",
                "Parent process for app launch"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'WorkManager' used for in Android development?",
                "Managing background tasks",
                "UI layout design",
                "Network communication",
                "Location tracking",
                "Managing background tasks"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which tool is used to inspect and profile CPU and memory usage in an Android app?",
                "Android Profiler",
                "APK Analyzer",
                "Lint",
                "Memory Monitor",
                "Android Profiler"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ExoPlayer' in Android?",
                "Media playback",
                "User authentication",
                "Location tracking",
                "Database management",
                "Media playback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RenderScript' used for in Android development?",
                "High-performance computation",
                "User interface design",
                "Audio playback",
                "Background services",
                "High-performance computation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Navigation Component' used for in Android development?",
                "Simplifying navigation and back stack management",
                "Creating user interfaces",
                "Database synchronization",
                "Security checks",
                "Simplifying navigation and back stack management"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'WorkManager' in Android development?",
                "Managing background tasks",
                "User interface design",
                "Network communication",
                "Location tracking",
                "Managing background tasks"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does 'ART' stand for in the context of Android development?",
                "Android Runtime",
                "Advanced Resource Toolkit",
                "Application Response Time",
                "Android Resource Type",
                "Android Runtime"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'ViewModel' class used for in Android development?",
                "Managing UI-related data",
                "Handling network requests",
                "Database management",
                "Location tracking",
                "Managing UI-related data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Dagger 2' in Android development?",
                "Dependency injection",
                "Database management",
                "Layout design",
                "Network communication",
                "Dependency injection"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VectorDrawable' used for in Android?",
                "Scalable and resolution-independent images",
                "Audio playback",
                "3D rendering",
                "Hardware acceleration",
                "Scalable and resolution-independent images"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Android feature is used to enhance the security of WebView components?",
                "Safe Browsing",
                "Network Security Config",
                "ContentProvider",
                "TrustManager",
                "Safe Browsing"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Fused Location Provider' used for in Android?",
                "Efficient location updates",
                "Audio processing",
                "Network security",
                "Layout design",
                "Efficient location updates"
            )
        )

        androidQuestionsList.shuffle()

    }
    fun stageEleven() {
        androidQuestionsList.clear()
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Jetpack Compose primarily used for in Android development?",
                "Declarative UI",
                "Database management",
                "Network communication",
                "Location tracking",
                "Declarative UI"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Jetpack Compose component is used to create a card with elevation and rounded corners?",
                "Card",
                "Surface",
                "Box",
                "Button",
                "Card"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'remember' functions in Jetpack Compose?",
                "Storing mutable state",
                "Defining layout structure",
                "Creating animations",
                "Managing back stack",
                "Storing mutable state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of Jetpack Compose's 'state management'?",
                "Immutable state objects",
                "Global variables",
                "Singleton patterns",
                "Shared preferences",
                "Immutable state objects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary advantage of using Jetpack Compose over traditional View-based UI development?",
                "Declarative UI construction",
                "Simplified XML layouts",
                "Faster network communication",
                "Improved device battery life",
                "Declarative UI construction"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Jetpack Compose layout is used for creating a scrolling list of items with lazy loading?",
                "LazyColumn",
                "Column",
                "Box",
                "Row",
                "LazyColumn"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'Navigation Compose' library used for in Android?",
                "Navigation and routing in Jetpack Compose apps",
                "UI layout design",
                "Database management",
                "Audio playback",
                "Navigation and routing in Jetpack Compose apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'State Hoisting' in Jetpack Compose?",
                "Lifting state to a higher level in the hierarchy",
                "Creating local state only",
                "Defining animations",
                "Handling deep links",
                "Lifting state to a higher level in the hierarchy"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "Which Compose component is used for displaying a dialog in an Android app?",
                "AlertDialog",
                "Popup",
                "DialogBox",
                "Toast",
                "AlertDialog"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MutableState' used for in Jetpack Compose?",
                "Storing mutable data that triggers recomposition",
                "Defining constant values",
                "Managing app themes",
                "Controlling animations",
                "Storing mutable data that triggers recomposition"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Key Composables' in Jetpack Compose?",
                "Efficient item updates in lists",
                "UI layout design",
                "Database management",
                "Audio playback",
                "Efficient item updates in lists"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'rememberUpdatedState' function used for in Jetpack Compose?",
                "Capturing the current value of a mutable state",
                "Tracking user gestures",
                "Managing navigation",
                "Storing persistent data",
                "Capturing the current value of a mutable state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ViewModel' used for in Jetpack Compose?",
                "Storing UI-related data across configuration changes",
                "Handling network requests",
                "Database management",
                "Creating custom views",
                "Storing UI-related data across configuration changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of the 'DrawModifier' in Jetpack Compose?",
                "Custom drawing on a canvas",
                "Styling text",
                "Managing database transactions",
                "Handling user input",
                "Custom drawing on a canvas"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AnimationVector' used for in Jetpack Compose?",
                "Storing animated vector data",
                "Handling audio playback",
                "Network communication",
                "Layout design",
                "Storing animated vector data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ConstraintLayout' used for in Jetpack Compose?",
                "Creating complex and responsive UIs",
                "Storing data",
                "Managing animations",
                "Handling background tasks",
                "Creating complex and responsive UIs"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'Transition' component used for in Jetpack Compose?",
                "Animating changes between states",
                "Storing data",
                "Managing navigation",
                "Defining custom fonts",
                "Animating changes between states"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Modifier.padding' used for in Jetpack Compose?",
                "Adding padding to a Composable",
                "Handling user input",
                "Network communication",
                "Audio playback",
                "Adding padding to a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'CompositionLocal' in Jetpack Compose?",
                "Sharing data across the composition hierarchy",
                "Creating custom shapes",
                "Managing animations",
                "Storing global state",
                "Sharing data across the composition hierarchy"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'BackdropScaffold' in Jetpack Compose?",
                "Creating complex UI structures with a backdrop",
                "Handling push notifications",
                "Network communication",
                "Audio playback",
                "Creating complex UI structures with a backdrop"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'IntrinsicSize' used for in Jetpack Compose?",
                "Defining the natural size of a Composable",
                "Handling animations",
                "Managing database transactions",
                "Creating custom shapes",
                "Defining the natural size of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Decoration' used for in Jetpack Compose?",
                "Customizing the appearance of a Composable",
                "Handling gestures",
                "Network communication",
                "Database management",
                "Customizing the appearance of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Modifier.clickable' in Jetpack Compose?",
                "Adding click interaction to a Composable",
                "Styling text",
                "Managing animations",
                "Storing app preferences",
                "Adding click interaction to a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Backdrop' used for in Jetpack Compose?",
                "Creating a backdrop panel in UIs",
                "Managing audio playback",
                "Network communication",
                "Layout design",
                "Creating a backdrop panel in UIs"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TextField' used for in Jetpack Compose?",
                "Accepting text input from users",
                "Drawing custom shapes",
                "Handling background tasks",
                "Network communication",
                "Accepting text input from users"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Modifier.drawWithContent' used for in Jetpack Compose?",
                "Custom drawing on a Composable with content",
                "Handling navigation",
                "Storing global state",
                "Managing database transactions",
                "Custom drawing on a Composable with content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FrameLayout' used for in Jetpack Compose?",
                "Creating a simple layout with stacked elements",
                "Managing database connections",
                "Audio playback",
                "Defining UI themes",
                "Creating a simple layout with stacked elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Ambient' used for in Jetpack Compose?",
                "Providing values to composables",
                "Database management",
                "Handling animations",
                "Storing app preferences",
                "Providing values to composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'LazyVerticalGrid' in Jetpack Compose?",
                "Creating a grid of items with lazy loading",
                "Network communication",
                "Storing app preferences",
                "Managing audio playback",
                "Creating a grid of items with lazy loading"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Canvas' used for in Jetpack Compose?",
                "Custom drawing and graphics operations",
                "Defining database schemas",
                "Handling gestures",
                "Storing app preferences",
                "Custom drawing and graphics operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'Modifier.offset' in Jetpack Compose?",
                "Changing the position of a Composable",
                "Handling user input",
                "Database management",
                "Audio playback",
                "Changing the position of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'RadioGroup' in Jetpack Compose?",
                "Grouping radio buttons to allow single selection",
                "Storing app preferences",
                "Managing animations",
                "Handling background tasks",
                "Grouping radio buttons to allow single selection"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Icon' used for in Jetpack Compose?",
                "Displaying icons and images",
                "Handling network requests",
                "Storing global state",
                "Creating custom shapes",
                "Displaying icons and images"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'State' in Jetpack Compose?",
                "Holding and observing immutable data",
                "Managing animations",
                "Network communication",
                "Storing app preferences",
                "Holding and observing immutable data"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VerticalScrollbar' used for in Jetpack Compose?",
                "Displaying a vertical scrollbar for scrolling content",
                "Creating complex layouts",
                "Storing global state",
                "Handling user authentication",
                "Displaying a vertical scrollbar for scrolling content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Snackbar' used for in Jetpack Compose?",
                "Displaying a brief message to the user",
                "Handling background tasks",
                "Audio playback",
                "Creating custom themes",
                "Displaying a brief message to the user"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'NavHost' in Jetpack Compose?",
                "Hosting navigation and routing logic",
                "Storing global state",
                "Managing animations",
                "Database synchronization",
                "Hosting navigation and routing logic"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Dialogs' used for in Jetpack Compose?",
                "Creating dialogs and pop-up windows",
                "Storing user preferences",
                "Handling audio playback",
                "Layout design",
                "Creating dialogs and pop-up windows"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'ViewMode' in Jetpack Compose?",
                "Handling UI state",
                "Defining custom fonts",
                "Creating animations",
                "Managing database transactions",
                "Handling UI state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Proguard' used for in Jetpack Compose?",
                "Code shrinking and obfuscation",
                "Handling audio playback",
                "Network communication",
                "Managing background tasks",
                "Code shrinking and obfuscation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'CollapsingToolbar' used for in Jetpack Compose?",
                "Creating a collapsing toolbar layout",
                "Managing app themes",
                "Database management",
                "Network communication",
                "Creating a collapsing toolbar layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Compose Navigation Rail' used for in Jetpack Compose?",
                "Creating a navigation rail for app navigation",
                "Storing user preferences",
                "Handling gestures",
                "Audio playback",
                "Creating a navigation rail for app navigation"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Painter' in Jetpack Compose?",
                "Custom drawing on a canvas",
                "Managing navigation",
                "Storing global state",
                "Managing database transactions",
                "Custom drawing on a canvas"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ListState' used for in Jetpack Compose?",
                "Managing the scroll position of a list",
                "Storing app preferences",
                "Handling network requests",
                "Defining UI themes",
                "Managing the scroll position of a list"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ViewBinding' used for in Jetpack Compose?",
                "Binding XML layout elements to code",
                "Database management",
                "Audio playback",
                "Network communication",
                "Binding XML layout elements to code"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Clip' in Jetpack Compose?",
                "Clipping the contents of a Composable",
                "Handling user input",
                "Storing global state",
                "Database synchronization",
                "Clipping the contents of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Compose Inspector' used for in Jetpack Compose?",
                "Debugging and inspecting the UI hierarchy",
                "Handling animations",
                "Network communication",
                "Audio playback",
                "Debugging and inspecting the UI hierarchy"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'Flow' in Jetpack Compose?",
                "Asynchronous data stream processing",
                "Storing user preferences",
                "Managing background tasks",
                "Creating custom themes",
                "Asynchronous data stream processing"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BottomAppBar' used for in Jetpack Compose?",
                "Creating a bottom app bar layout",
                "Database management",
                "Audio playback",
                "UI layout design",
                "Creating a bottom app bar layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Accessibility' in Jetpack Compose?",
                "Improving app accessibility for all users",
                "Handling gestures",
                "Network communication",
                "Layout design",
                "Improving app accessibility for all users"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Preview' used for in Jetpack Compose?",
                "Creating a preview of a Composable",
                "Storing app preferences",
                "Managing animations",
                "Database synchronization",
                "Creating a preview of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'ModalBottomSheet' used for in Jetpack Compose?",
                "Creating a modal bottom sheet dialog",
                "Storing global state",
                "Managing audio playback",
                "Layout design",
                "Creating a modal bottom sheet dialog"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ModalDrawer' used for in Jetpack Compose?",
                "Creating a modal side drawer layout",
                "Handling navigation",
                "Database management",
                "Audio playback",
                "Creating a modal side drawer layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ScrollableTabRow' in Jetpack Compose?",
                "Creating a scrollable tab bar",
                "Storing user preferences",
                "Managing background tasks",
                "Network communication",
                "Creating a scrollable tab bar"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AutoFill' used for in Jetpack Compose?",
                "Assisting users in form data input",
                "Styling text",
                "Managing database transactions",
                "Audio playback",
                "Assisting users in form data input"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FlingBehavior' used for in Jetpack Compose?",
                "Handling fling gestures for scrollable content",
                "Creating custom themes",
                "Network communication",
                "Managing animations",
                "Handling fling gestures for scrollable content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'CustomPainter' in Jetpack Compose?",
                "Custom drawing on a canvas",
                "Managing navigation",
                "Storing global state",
                "Managing database transactions",
                "Custom drawing on a canvas"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AppBar' used for in Jetpack Compose?",
                "Creating an app bar with title and actions",
                "Storing user preferences",
                "Handling audio playback",
                "Layout design",
                "Creating an app bar with title and actions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DialogQueue' used for in Jetpack Compose?",
                "Managing a queue of dialogs to display sequentially",
                "Handling user authentication",
                "Network communication",
                "Creating custom shapes",
                "Managing a queue of dialogs to display sequentially"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Path' in Jetpack Compose?",
                "Defining a path for custom shapes and drawing",
                "Managing animations",
                "Database synchronization",
                "Storing app preferences",
                "Defining a path for custom shapes and drawing"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Coil' used for in Jetpack Compose?",
                "Loading and caching images from the network",
                "Handling background tasks",
                "Audio playback",
                "UI layout design",
                "Loading and caching images from the network"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'Composition API' in Jetpack Compose?",
                "Building UI components declaratively",
                "Storing global state",
                "Managing animations",
                "Database synchronization",
                "Building UI components declaratively"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'DecorationBox' in Jetpack Compose?",
                "Adding custom decorations to a Composable",
                "Styling text",
                "Handling user input",
                "Audio playback",
                "Adding custom decorations to a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SizeModifier' used for in Jetpack Compose?",
                "Modifying the size of a Composable",
                "Defining app themes",
                "Network communication",
                "Managing database transactions",
                "Modifying the size of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'ScrollState' used for in Jetpack Compose?",
                "Managing the scroll state of a Composable",
                "Handling user authentication",
                "Audio playback",
                "Layout design",
                "Managing the scroll state of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Touchable' in Jetpack Compose?",
                "Handling touch input and gestures",
                "Storing app preferences",
                "Managing animations",
                "Network communication",
                "Handling touch input and gestures"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'GraphicsLayer' used for in Jetpack Compose?",
                "Custom graphics transformations on a Composable",
                "Creating custom shapes",
                "Database management",
                "Handling background tasks",
                "Custom graphics transformations on a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DialogState' used for in Jetpack Compose?",
                "Managing the state of dialogs in the app",
                "Managing navigation",
                "Storing global state",
                "Audio playback",
                "Managing the state of dialogs in the app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Screen' used for in Jetpack Compose?",
                "Defining the content of a screen or page",
                "Storing user preferences",
                "Network communication",
                "Layout design",
                "Defining the content of a screen or page"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Shimmer' in Jetpack Compose?",
                "Creating shimmering loading animations",
                "Styling text",
                "Handling gestures",
                "Database synchronization",
                "Creating shimmering loading animations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'GradientBrush' used for in Jetpack Compose?",
                "Applying gradient colors to shapes",
                "Handling animations",
                "Audio playback",
                "Managing database transactions",
                "Applying gradient colors to shapes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'LayoutManager' in Jetpack Compose?",
                "Arranging Composables in a layout",
                "Storing global state",
                "Handling background tasks",
                "Network communication",
                "Arranging Composables in a layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'BackgroundImage' in Jetpack Compose?",
                "Setting a background image for a Composable",
                "Handling user input",
                "Storing app preferences",
                "Layout design",
                "Setting a background image for a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TouchInteractionSource' used for in Jetpack Compose?",
                "Capturing and processing touch input",
                "Database management",
                "Handling audio playback",
                "Network communication",
                "Capturing and processing touch input"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VerticalDivider' used for in Jetpack Compose?",
                "Creating a vertical divider between Composables",
                "Creating custom themes",
                "Managing animations",
                "Styling text",
                "Creating a vertical divider between Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'WebView' used for in Jetpack Compose?",
                "Displaying web content in a Composable",
                "Storing global state",
                "Managing database transactions",
                "Handling gestures",
                "Displaying web content in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'InspectorInfo' in Jetpack Compose?",
                "Providing debug information for Composables",
                "Audio playback",
                "Network communication",
                "Layout design",
                "Providing debug information for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ErrorState' used for in Jetpack Compose?",
                "Managing and displaying error states",
                "Handling user authentication",
                "Styling text",
                "Database synchronization",
                "Managing and displaying error states"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SheetContent' used for in Jetpack Compose?",
                "Creating the content for a bottom sheet",
                "Network communication",
                "Managing animations",
                "Audio playback",
                "Creating the content for a bottom sheet"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DrawerValue' used for in Jetpack Compose?",
                "Managing the state of a drawer",
                "Defining app themes",
                "Layout design",
                "Handling background tasks",
                "Managing the state of a drawer"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'FormState' in Jetpack Compose?",
                "Managing the state of a form",
                "Creating custom shapes",
                "Audio playback",
                "Network communication",
                "Managing the state of a form"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RenderContext' used for in Jetpack Compose?",
                "Providing a context for rendering Composables",
                "Storing user preferences",
                "Managing background tasks",
                "Styling text",
                "Providing a context for rendering Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'LazyPagingItems' in Jetpack Compose?",
                "Managing paged data for lists",
                "Handling animations",
                "Database synchronization",
                "Storing global state",
                "Managing paged data for lists"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FlowRow' used for in Jetpack Compose?",
                "Creating a flow layout for items",
                "Handling gestures",
                "Audio playback",
                "Creating custom themes",
                "Creating a flow layout for items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'HorizontalDp' used for in Jetpack Compose?",
                "Specifying horizontal spacing in density-independent pixels",
                "Managing navigation",
                "Network communication",
                "Layout design",
                "Specifying horizontal spacing in density-independent pixels"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DecorationModifier' used for in Jetpack Compose?",
                "Adding custom decorations to a Composable",
                "Styling text",
                "Handling user input",
                "Audio playback",
                "Adding custom decorations to a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ListItem' used for in Jetpack Compose?",
                "Creating a list item with a specific layout",
                "Database management",
                "Storing global state",
                "Handling background tasks",
                "Creating a list item with a specific layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'TextInput' in Jetpack Compose?",
                "Accepting text input and handling keyboard events",
                "Managing animations",
                "Network communication",
                "Layout design",
                "Accepting text input and handling keyboard events"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DatePicker' used for in Jetpack Compose?",
                "Displaying and selecting dates",
                "Storing user preferences",
                "Managing audio playback",
                "Creating custom themes",
                "Displaying and selecting dates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'ComposeModalBottomSheetLayout' in Jetpack Compose?",
                "Creating a modal bottom sheet layout",
                "Storing app preferences",
                "Audio playback",
                "Database synchronization",
                "Creating a modal bottom sheet layout"
            )
        )

        androidQuestionsList.shuffle()

    }
    fun stageTwelve() {
        androidQuestionsList.clear()
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Spinner' used for in Jetpack Compose?",
                "Creating a drop-down spinner for selecting items",
                "Managing database transactions",
                "Handling background tasks",
                "Network communication",
                "Creating a drop-down spinner for selecting items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'TextFieldValue' in Jetpack Compose?",
                "Storing the value of a text field",
                "Handling user input",
                "Styling text",
                "Managing navigation",
                "Storing the value of a text field"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'SubcomposeLayout' in Jetpack Compose?",
                "Laying out the subcomposed children of a Composable",
                "Managing animations",
                "Network communication",
                "Audio playback",
                "Laying out the subcomposed children of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Popover' used for in Jetpack Compose?",
                "Creating a popover menu",
                "Storing app preferences",
                "Database management",
                "Handling gestures",
                "Creating a popover menu"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'BasicTextField' in Jetpack Compose?",
                "Creating a basic text input field",
                "Layout design",
                "Handling background tasks",
                "Audio playback",
                "Creating a basic text input field"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ComposeView' used for in Jetpack Compose?",
                "Integrating Compose into existing View-based UI",
                "Handling network requests",
                "Storing global state",
                "Creating custom shapes",
                "Integrating Compose into existing View-based UI"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'CustomLayout' in Jetpack Compose?",
                "Creating a custom layout for Composables",
                "Storing user preferences",
                "Managing animations",
                "Database synchronization",
                "Creating a custom layout for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ViewTransform' in Jetpack Compose?",
                "Transforming the drawing of a Composable",
                "Managing database transactions",
                "Audio playback",
                "Network communication",
                "Transforming the drawing of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SimpleFlowRow' used for in Jetpack Compose?",
                "Creating a flow layout for items",
                "Handling gestures",
                "Styling text",
                "Managing background tasks",
                "Creating a flow layout for items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BitmapFont' used for in Jetpack Compose?",
                "Customizing font styles and rendering",
                "Storing global state",
                "Layout design",
                "Handling user authentication",
                "Customizing font styles and rendering"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ParagraphStyle' used for in Jetpack Compose?",
                "Defining paragraph styles for text",
                "Handling animations",
                "Network communication",
                "Audio playback",
                "Defining paragraph styles for text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Overlay' in Jetpack Compose?",
                "Overlaying content on top of another Composable",
                "Storing app preferences",
                "Managing animations",
                "Database synchronization",
                "Overlaying content on top of another Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LottieAnimation' used for in Jetpack Compose?",
                "Displaying Lottie animations in a Composable",
                "Handling user input",
                "Handling navigation",
                "Layout design",
                "Displaying Lottie animations in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'ClickableText' in Jetpack Compose?",
                "Creating clickable text with links",
                "Storing global state",
                "Managing background tasks",
                "Network communication",
                "Creating clickable text with links"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Swatch' in Jetpack Compose?",
                "Extracting colors from images",
                "Styling text",
                "Managing database transactions",
                "Audio playback",
                "Extracting colors from images"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ClipPath' used for in Jetpack Compose?",
                "Clipping a Composable with a path",
                "Handling audio playback",
                "Database management",
                "Handling background tasks",
                "Clipping a Composable with a path"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'OffsetLayout' in Jetpack Compose?",
                "Laying out Composables at specific offsets",
                "Creating custom themes",
                "Handling gestures",
                "Storing app preferences",
                "Laying out Composables at specific offsets"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DirectGraphicsLayer' used for in Jetpack Compose?",
                "Applying custom graphics transformations",
                "Managing navigation",
                "Storing global state",
                "Managing database transactions",
                "Applying custom graphics transformations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'ScrollingTabRow' in Jetpack Compose?",
                "Creating a row of scrolling tabs",
                "Handling user input",
                "Audio playback",
                "Layout design",
                "Creating a row of scrolling tabs"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MediaRouteButton' used for in Jetpack Compose?",
                "Displaying a media route button for media playback",
                "Database management",
                "Network communication",
                "Handling animations",
                "Displaying a media route button for media playback"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'BackdropHeader' in Jetpack Compose?",
                "Creating a header for the backdrop layout",
                "Storing app preferences",
                "Managing database transactions",
                "Handling background tasks",
                "Creating a header for the backdrop layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DateRangePicker' used for in Jetpack Compose?",
                "Selecting date ranges in a Composable",
                "Managing animations",
                "Network communication",
                "Styling text",
                "Selecting date ranges in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'ImageLoader' in Jetpack Compose?",
                "Loading and caching images for Composables",
                "Handling user authentication",
                "Audio playback",
                "Layout design",
                "Loading and caching images for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Markable' used for in Jetpack Compose?",
                "Creating markable text in a Composable",
                "Storing global state",
                "Handling navigation",
                "Database synchronization",
                "Creating markable text in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'Cursor' in Jetpack Compose?",
                "Managing the position of a cursor in text",
                "Creating custom themes",
                "Handling gestures",
                "Audio playback",
                "Managing the position of a cursor in text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BezierPath' used for in Jetpack Compose?",
                "Defining paths for custom shapes",
                "Handling network requests",
                "Storing app preferences",
                "Managing animations",
                "Defining paths for custom shapes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VideoPlayer' used for in Jetpack Compose?",
                "Playing videos in a Composable",
                "Layout design",
                "Handling background tasks",
                "Storing global state",
                "Playing videos in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'FlexColumn' in Jetpack Compose?",
                "Creating a column with flexible space distribution",
                "Handling audio playback",
                "Network communication",
                "Database management",
                "Creating a column with flexible space distribution"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SnapModifier' used for in Jetpack Compose?",
                "Creating snapping behavior in scrollable Composables",
                "Managing database transactions",
                "Audio playback",
                "Handling user input",
                "Creating snapping behavior in scrollable Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'CustomTextInput' in Jetpack Compose?",
                "Creating a custom text input field",
                "Handling animations",
                "Storing app preferences",
                "Managing navigation",
                "Creating a custom text input field"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ConstraintScope' used for in Jetpack Compose?",
                "Defining constraints for layout Composables",
                "Handling background tasks",
                "Styling text",
                "Handling gestures",
                "Defining constraints for layout Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'VideoPlayerController' in Jetpack Compose?",
                "Controlling video playback in a Composable",
                "Storing global state",
                "Database management",
                "Network communication",
                "Controlling video playback in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Recycler' used for in Jetpack Compose?",
                "Creating a recycler for efficiently displaying lists",
                "Managing animations",
                "Audio playback",
                "Layout design",
                "Creating a recycler for efficiently displaying lists"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'FormRow' in Jetpack Compose?",
                "Creating rows for form elements",
                "Handling user authentication",
                "Network communication",
                "Managing database transactions",
                "Creating rows for form elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LetterSpacing' used for in Jetpack Compose?",
                "Defining letter spacing for text",
                "Creating custom themes",
                "Storing app preferences",
                "Handling background tasks",
                "Defining letter spacing for text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ComposeNavigator' used for in Jetpack Compose?",
                "Handling navigation and routing within Composables",
                "Handling gestures",
                "Database management",
                "Managing animations",
                "Handling navigation and routing within Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Ripple' in Jetpack Compose?",
                "Adding ripple effects to Composables",
                "Managing database transactions",
                "Audio playback",
                "Styling text",
                "Adding ripple effects to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FilePicker' used for in Jetpack Compose?",
                "Selecting files in a Composable",
                "Layout design",
                "Handling user input",
                "Storing global state",
                "Selecting files in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the 'ScrollbarAdapter' used for in Jetpack Compose?",
                "Customizing the appearance of a scrollbar",
                "Handling background tasks",
                "Network communication",
                "Managing animations",
                "Customizing the appearance of a scrollbar"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VerticalDp' used for in Jetpack Compose?",
                "Specifying vertical spacing in density-independent pixels",
                "Managing navigation",
                "Audio playback",
                "Styling text",
                "Specifying vertical spacing in density-independent pixels"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LocalDensity' used for in Jetpack Compose?",
                "Managing the density of a Composable",
                "Creating custom shapes",
                "Database management",
                "Handling user authentication",
                "Managing the density of a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TruncateAt' used for in Jetpack Compose?",
                "Defining text truncation behavior",
                "Network communication",
                "Storing app preferences",
                "Handling gestures",
                "Defining text truncation behavior"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of 'TreePainter' in Jetpack Compose?",
                "Custom painting on a tree structure",
                "Handling animations",
                "Audio playback",
                "Layout design",
                "Custom painting on a tree structure"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'EllipseModifier' used for in Jetpack Compose?",
                "Applying ellipsis effects to text",
                "Managing database transactions",
                "Handling background tasks",
                "Styling text",
                "Applying ellipsis effects to text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ScrollStateObserver' used for in Jetpack Compose?",
                "Observing the scroll state of Composables",
                "Managing animations",
                "Database synchronization",
                "Network communication",
                "Observing the scroll state of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ShaderBrush' used for in Jetpack Compose?",
                "Applying shader effects to shapes",
                "Storing user preferences",
                "Managing navigation",
                "Audio playback",
                "Applying shader effects to shapes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'RefreshState' in Jetpack Compose?",
                "Managing the state of a refreshable Composable",
                "Layout design",
                "Handling user authentication",
                "Storing global state",
                "Managing the state of a refreshable Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BackdropValue' used for in Jetpack Compose?",
                "Managing the value of a backdrop",
                "Handling background tasks",
                "Audio playback",
                "Network communication",
                "Managing the value of a backdrop"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TouchInteractionFilter' used for in Jetpack Compose?",
                "Filtering touch interactions in a Composable",
                "Database management",
                "Network communication",
                "Managing animations",
                "Filtering touch interactions in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Insets' used for in Jetpack Compose?",
                "Defining padding and insets for a Composable",
                "Handling gestures",
                "Styling text",
                "Managing database transactions",
                "Defining padding and insets for a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'SwipeToDismiss' in Jetpack Compose?",
                "Enabling swipe-to-dismiss behavior in lists",
                "Storing app preferences",
                "Layout design",
                "Handling animations",
                "Enabling swipe-to-dismiss behavior in lists"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VisualTransformation' used for in Jetpack Compose?",
                "Transforming the visual appearance of text",
                "Managing navigation",
                "Audio playback",
                "Handling background tasks",
                "Transforming the visual appearance of text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ClippingShape' used for in Jetpack Compose?",
                "Defining a shape for clipping content",
                "Network communication",
                "Storing global state",
                "Handling user input",
                "Defining a shape for clipping content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Fresco' in Android development?",
                "Image loading library",
                "Dependency injection framework",
                "UI design tool",
                "Video playback library",
                "Image loading library"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Paging Library' in Android development?",
                "Loading large data sets efficiently",
                "Database synchronization",
                "Audio playback",
                "User authentication",
                "Loading large data sets efficiently"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What does 'AIDL' stand for in Android development?",
                "Android Interface Definition Language",
                "Application Interaction Design Language",
                "Advanced Interface Development Layer",
                "Android Intent Data Language",
                "Android Interface Definition Language"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'ConstraintLayout' in Android?",
                "Creating complex and responsive UIs",
                "Managing network requests",
                "Handling database queries",
                "Audio playback",
                "Creating complex and responsive UIs"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Hilt' used for in Android development?",
                "Dependency injection framework",
                "UI design tool",
                "Background processing library",
                "Audio playback library",
                "Dependency injection framework"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Material Design' in the context of Android development?",
                "A design language for creating cohesive and visually pleasing apps",
                "A library for audio processing",
                "A framework for network security",
                "A database management system",
                "A design language for creating cohesive and visually pleasing apps"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Glide' used for in Android development?",
                "Image loading and caching library",
                "Audio processing library",
                "Network communication framework",
                "User interface design tool",
                "Image loading and caching library"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'Retrofit' in Android development?",
                "Network requests and REST API integration",
                "User authentication",
                "Database management",
                "UI design and layout",
                "Network requests and REST API integration"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DataBinding' used for in Android development?",
                "Binding data to UI components",
                "Database management",
                "Audio playback",
                "Network communication",
                "Binding data to UI components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Paging3' used for in Android development?",
                "Loading large data sets with RecyclerView",
                "Screen recording",
                "3D graphics rendering",
                "Battery optimization",
                "Loading large data sets with RecyclerView"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Kotlin' used for in Android development?",
                "A programming language for Android app development",
                "A database management system",
                "A hardware testing framework",
                "A design language for UI development",
                "A programming language for Android app development"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ViewBinding' used for in Android development?",
                "Binding XML layout elements to code",
                "Audio playback",
                "Network communication",
                "Database synchronization",
                "Binding XML layout elements to code"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AAC' in Android development?",
                "Android Architecture Components",
                "Advanced Audio Codec",
                "Android Animation Controller",
                "Android Activity Collection",
                "Android Architecture Components"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'HandlerThread' in Android development?",
                "Simplified background threading",
                "User authentication",
                "ContentProvider management",
                "OpenGL rendering",
                "Simplified background threading"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Android Testing Support Library' used for?",
                "Simplifying testing of Android applications",
                "Network communication",
                "Location tracking",
                "User interface design",
                "Simplifying testing of Android applications"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'Material Design' in Android development?",
                "A design language for consistent and attractive UIs",
                "Network security",
                "Audio processing",
                "Location tracking",
                "A design language for consistent and attractive UIs"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Zygote' in Android development?",
                "A process for launching app instances",
                "A memory management tool",
                "A UI design framework",
                "A database management system",
                "A process for launching app instances"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MotionLayout' used for in Android development?",
                "Creating complex animations and transitions",
                "Database management",
                "Audio processing",
                "Network communication",
                "Creating complex animations and transitions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Espresso' used for in Android development?",
                "UI testing framework",
                "Audio processing",
                "Network communication",
                "Layout design",
                "UI testing framework"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Gson' used for in Android development?",
                "JSON parsing library",
                "User authentication",
                "Audio playback",
                "Database synchronization",
                "JSON parsing library"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'LeakCanary' in Android?",
                "Memory leak detection",
                "Network traffic monitoring",
                "Database management",
                "User interface design",
                "Memory leak detection"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is Android's RemoteInput used for?",
                "To input remote commands",
                "To enable users to input text into a notification reply field from the notification shade",
                "To play videos",
                "To create custom animations",
                "To enable users to input text into a notification reply field from the notification shade"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the purpose of Android's ContentProviderResult?",
                "To provide content results",
                "To represent the result of a batch of ContentProvider operations",
                "To manage app resources",
                "To create animations",
                "To represent the result of a batch of ContentProvider operations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ComposeModifier' in Jetpack Compose?",
                "Applying custom modifiers to Composables",
                "Storing global state",
                "Managing animations",
                "Database synchronization",
                "Applying custom modifiers to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'NavigationRail' used for in Jetpack Compose?",
                "Creating a navigation rail layout",
                "Handling user input",
                "Audio playback",
                "Layout design",
                "Creating a navigation rail layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'Recomposition' in Jetpack Compose?",
                "Rebuilding Composables when data changes",
                "Storing user preferences",
                "Handling background tasks",
                "Network communication",
                "Rebuilding Composables when data changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AccessibilityValueInfo' used for in Jetpack Compose?",
                "Providing accessibility information for Composables",
                "Creating custom themes",
                "Managing navigation",
                "Styling text",
                "Providing accessibility information for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ClipPath' in Jetpack Compose?",
                "Clipping a Composable with a custom path",
                "Managing database transactions",
                "Audio playback",
                "Handling gestures",
                "Clipping a Composable with a custom path"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BackdropScaffold' used for in Jetpack Compose?",
                "Creating a backdrop layout with front and back layers",
                "Layout design",
                "Handling animations",
                "Storing app preferences",
                "Creating a backdrop layout with front and back layers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'ConstraintLayout' in Jetpack Compose?",
                "Defining complex UI layouts with constraints",
                "Managing global state",
                "Database management",
                "Network communication",
                "Defining complex UI layouts with constraints"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SwipeableState' used for in Jetpack Compose?",
                "Managing the state of swipeable Composables",
                "Handling audio playback",
                "Styling text",
                "Handling user authentication",
                "Managing the state of swipeable Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BottomDrawerValue' used for in Jetpack Compose?",
                "Managing the state of a bottom drawer",
                "Handling background tasks",
                "Network communication",
                "Layout design",
                "Managing the state of a bottom drawer"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'Shader' in Jetpack Compose?",
                "Applying custom shaders to Composables",
                "Creating custom shapes",
                "Audio playback",
                "Managing animations",
                "Applying custom shaders to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ContentScale' used for in Jetpack Compose?",
                "Scaling and fitting content within a Composable",
                "Handling navigation",
                "Storing global state",
                "Managing database transactions",
                "Scaling and fitting content within a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Navigator' used for in Jetpack Compose?",
                "Handling navigation and routing within Composables",
                "Handling gestures",
                "Database synchronization",
                "Audio playback",
                "Handling navigation and routing within Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ComposeModifier' in Jetpack Compose?",
                "Applying custom modifiers to Composables",
                "Storing global state",
                "Managing animations",
                "Database synchronization",
                "Applying custom modifiers to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'NavigationRail' used for in Jetpack Compose?",
                "Creating a navigation rail layout",
                "Handling user input",
                "Audio playback",
                "Layout design",
                "Creating a navigation rail layout"
            )
        )
        androidQuestionsList.shuffle()
    }
    fun stageThirteen() {
        androidQuestionsList.clear()
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ComposeModifier' in Jetpack Compose?",
                "Applying custom modifiers to Composables",
                "Storing global state",
                "Managing animations",
                "Database synchronization",
                "Applying custom modifiers to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'NavigationRail' used for in Jetpack Compose?",
                "Creating a navigation rail layout",
                "Handling user input",
                "Audio playback",
                "Layout design",
                "Creating a navigation rail layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'Recomposition' in Jetpack Compose?",
                "Rebuilding Composables when data changes",
                "Storing user preferences",
                "Handling background tasks",
                "Network communication",
                "Rebuilding Composables when data changes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AccessibilityValueInfo' used for in Jetpack Compose?",
                "Providing accessibility information for Composables",
                "Creating custom themes",
                "Managing navigation",
                "Styling text",
                "Providing accessibility information for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ClipPath' in Jetpack Compose?",
                "Clipping a Composable with a custom path",
                "Managing database transactions",
                "Audio playback",
                "Handling gestures",
                "Clipping a Composable with a custom path"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BackdropScaffold' used for in Jetpack Compose?",
                "Creating a backdrop layout with front and back layers",
                "Layout design",
                "Handling animations",
                "Storing app preferences",
                "Creating a backdrop layout with front and back layers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'ConstraintLayout' in Jetpack Compose?",
                "Defining complex UI layouts with constraints",
                "Managing global state",
                "Database management",
                "Network communication",
                "Defining complex UI layouts with constraints"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SwipeableState' used for in Jetpack Compose?",
                "Managing the state of swipeable Composables",
                "Handling audio playback",
                "Styling text",
                "Handling user authentication",
                "Managing the state of swipeable Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BottomDrawerValue' used for in Jetpack Compose?",
                "Managing the state of a bottom drawer",
                "Handling background tasks",
                "Network communication",
                "Layout design",
                "Managing the state of a bottom drawer"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary function of 'Shader' in Jetpack Compose?",
                "Applying custom shaders to Composables",
                "Creating custom shapes",
                "Audio playback",
                "Managing animations",
                "Applying custom shaders to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ContentScale' used for in Jetpack Compose?",
                "Scaling and fitting content within a Composable",
                "Handling navigation",
                "Storing global state",
                "Managing database transactions",
                "Scaling and fitting content within a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Navigator' used for in Jetpack Compose?",
                "Handling navigation and routing within Composables",
                "Handling gestures",
                "Database synchronization",
                "Audio playback",
                "Handling navigation and routing within Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'SpanStyle' in Jetpack Compose?",
                "Styling specific text spans within a Composable",
                "Network communication",
                "Layout design",
                "Storing app preferences",
                "Styling specific text spans within a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BackdropController' used for in Jetpack Compose?",
                "Controlling the state of a backdrop layout",
                "Handling user input",
                "Managing animations",
                "Database management",
                "Controlling the state of a backdrop layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ComposeSnapshot' used for in Jetpack Compose?",
                "Creating snapshots of Composables for testing",
                "Storing user preferences",
                "Audio playback",
                "Handling background tasks",
                "Creating snapshots of Composables for testing"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'ContentAlpha' in Jetpack Compose?",
                "Applying alpha transparency to Composable content",
                "Managing database transactions",
                "Styling text",
                "Handling user authentication",
                "Applying alpha transparency to Composable content"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'GridPlacement' used for in Jetpack Compose?",
                "Placing items within a grid layout",
                "Layout design",
                "Handling audio playback",
                "Network communication",
                "Placing items within a grid layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DialogButton' used for in Jetpack Compose?",
                "Creating buttons in dialog boxes",
                "Managing global state",
                "Handling background tasks",
                "Handling gestures",
                "Creating buttons in dialog boxes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ComposeTabRow' used for in Jetpack Compose?",
                "Creating a tab bar for navigating between sections",
                "Creating custom themes",
                "Database management",
                "Storing app preferences",
                "Creating a tab bar for navigating between sections"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'DecorationScope' in Jetpack Compose?",
                "Applying decorations to Composables",
                "Audio playback",
                "Network communication",
                "Handling animations",
                "Applying decorations to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VisualTransformationStyle' used for in Jetpack Compose?",
                "Applying visual transformations to text",
                "Handling animations",
                "Database synchronization",
                "Handling user input",
                "Applying visual transformations to text"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'KeyboardController' used for in Jetpack Compose?",
                "Controlling the virtual keyboard in Composables",
                "Managing navigation",
                "Storing global state",
                "Styling text",
                "Controlling the virtual keyboard in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'HorizontalPager' in Jetpack Compose?",
                "Creating horizontally paged layouts",
                "Handling gestures",
                "Audio playback",
                "Layout design",
                "Creating horizontally paged layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DynamicModifier' used for in Jetpack Compose?",
                "Applying dynamic modifications to Composables",
                "Managing global state",
                "Database management",
                "Network communication",
                "Applying dynamic modifications to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'GridLayoutManager' used for in Jetpack Compose?",
                "Arranging Composables in a grid layout",
                "Handling user input",
                "Audio playback",
                "Layout design",
                "Arranging Composables in a grid layout"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the primary purpose of 'DataBinding' in Jetpack Compose?",
                "Binding data to Composables for automatic updates",
                "Storing app preferences",
                "Managing animations",
                "Handling background tasks",
                "Binding data to Composables for automatic updates"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'PointerInputFilter' used for in Jetpack Compose?",
                "Filtering and processing pointer input in Composables",
                "Handling database transactions",
                "Styling text",
                "Handling user authentication",
                "Filtering and processing pointer input in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SelectableGroup' used for in Jetpack Compose?",
                "Creating a group of selectable items",
                "Handling animations",
                "Audio playback",
                "Managing navigation",
                "Creating a group of selectable items"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MultiSelection' used for in Jetpack Compose?",
                "Managing multiple selections in a Composable",
                "Layout design",
                "Handling audio playback",
                "Network communication",
                "Managing multiple selections in a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is the core concept of 'ContentScale' in Jetpack Compose?",
                "Scaling and fitting content within a Composable",
                "Storing user preferences",
                "Handling gestures",
                "Managing database transactions",
                "Scaling and fitting content within a Composable"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ComposeTransition' used for in Jetpack Compose?",
                "Creating animated transitions between Composables",
                "Handling user input",
                "Database synchronization",
                "Storing global state",
                "Creating animated transitions between Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TimeTransform' used for in Jetpack Compose?",
                "Transforming time-related properties in animations",
                "Creating custom shapes",
                "Audio playback",
                "Handling animations",
                "Transforming time-related properties in animations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'OnSizeChanged' used for in Jetpack Compose?",
                "Handling size changes of Composables",
                "Managing navigation",
                "Styling text",
                "Handling background tasks",
                "Handling size changes of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'HandleState' used for in Jetpack Compose?",
                "Managing the state of draggable handles",
                "Handling gestures",
                "Layout design",
                "Storing app preferences",
                "Managing the state of draggable handles"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FontFamily' used for in Jetpack Compose?",
                "Defining font families for text styling",
                "Database management",
                "Handling user authentication",
                "Network communication",
                "Defining font families for text styling"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ObjectMenu' used for in Jetpack Compose?",
                "Creating context menus for Composables",
                "Managing animations",
                "Audio playback",
                "Database synchronization",
                "Creating context menus for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ParentDataModifier' used for in Jetpack Compose?",
                "Modifying parent data for layout Composables",
                "Handling network requests",
                "Storing global state",
                "Creating custom themes",
                "Modifying parent data for layout Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SimpleTransform' used for in Jetpack Compose?",
                "Applying simple transformations to Composables",
                "Handling database transactions",
                "Storing app preferences",
                "Managing background tasks",
                "Applying simple transformations to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RenderImage' used for in Jetpack Compose?",
                "Rendering images in Composables",
                "Handling user input",
                "Layout design",
                "Handling animations",
                "Rendering images in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ExperimentalIntrinsics' used for in Jetpack Compose?",
                "Defining experimental intrinsic measurements",
                "Managing navigation",
                "Audio playback",
                "Styling text",
                "Defining experimental intrinsic measurements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ScreenNavigator' used for in Jetpack Compose?",
                "Managing navigation and routing between screens",
                "Creating custom themes",
                "Database management",
                "Network communication",
                "Managing navigation and routing between screens"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VerticalLayout' used for in Jetpack Compose?",
                "Creating a vertical layout of Composables",
                "Handling gestures",
                "Styling text",
                "Handling background tasks",
                "Creating a vertical layout of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'CachingStrategy' used for in Jetpack Compose?",
                "Defining caching strategies for Composables",
                "Managing database transactions",
                "Handling animations",
                "Audio playback",
                "Defining caching strategies for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AppFont' used for in Jetpack Compose?",
                "Defining custom fonts for the app",
                "Storing global state",
                "Network communication",
                "Handling user authentication",
                "Defining custom fonts for the app"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BackgroundMask' used for in Jetpack Compose?",
                "Masking background content in Composables",
                "Handling network communication",
                "Layout design",
                "Handling user input",
                "Masking background content in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AnchorPosition' used for in Jetpack Compose?",
                "Defining the position of an anchor point",
                "Database synchronization",
                "Managing animations",
                "Storing app preferences",
                "Defining the position of an anchor point"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ContentTemplate' used for in Jetpack Compose?",
                "Defining template structures for Composables",
                "Managing navigation",
                "Audio playback",
                "Handling background tasks",
                "Defining template structures for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RenderEffect' used for in Jetpack Compose?",
                "Applying custom visual effects to Composables",
                "Handling user input",
                "Styling text",
                "Managing database transactions",
                "Applying custom visual effects to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayoutPolicy' used for in Jetpack Compose?",
                "Defining layout policies for Composables",
                "Handling gestures",
                "Network communication",
                "Managing global state",
                "Defining layout policies for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransformedModifier' used for in Jetpack Compose?",
                "Applying transformations to Composables",
                "Handling audio playback",
                "Database management",
                "Handling animations",
                "Applying transformations to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'NavigationStack' used for in Jetpack Compose?",
                "Managing a stack of navigated Composables",
                "Layout design",
                "Storing user preferences",
                "Handling network requests",
                "Managing a stack of navigated Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'EventCallback' used for in Jetpack Compose?",
                "Handling event callbacks for Composables",
                "Handling user authentication",
                "Audio playback",
                "Creating custom shapes",
                "Handling event callbacks for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayerPainter' used for in Jetpack Compose?",
                "Creating custom painters for layers in Composables",
                "Managing animations",
                "Storing app preferences",
                "Database synchronization",
                "Creating custom painters for layers in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransitionSpec' used for in Jetpack Compose?",
                "Defining transition specifications for animations",
                "Network communication",
                "Handling background tasks",
                "Handling gestures",
                "Defining transition specifications for animations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Saver' used for in Jetpack Compose?",
                "Saving and restoring Composable state",
                "Handling database transactions",
                "Handling navigation",
                "Layout design",
                "Saving and restoring Composable state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransitionDefinition' used for in Jetpack Compose?",
                "Defining custom transition animations",
                "Storing global state",
                "Managing navigation",
                "Audio playback",
                "Defining custom transition animations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ScreenReaderValue' used for in Jetpack Compose?",
                "Providing screen reader information for accessibility",
                "Handling animations",
                "Handling user input",
                "Styling text",
                "Providing screen reader information for accessibility"
            )
        )
        androidQuestionsList.shuffle()

    }
    fun stageFourteen() {
        androidQuestionsList.clear()
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'StateSavePolicy' used for in Jetpack Compose?",
                "Defining policies for saving and restoring state",
                "Managing animations",
                "Handling user input",
                "Handling database transactions",
                "Defining policies for saving and restoring state"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'UIController' used for in Jetpack Compose?",
                "Controlling the Composable UI hierarchy",
                "Storing global state",
                "Audio playback",
                "Layout design",
                "Controlling the Composable UI hierarchy"
            )
        )

        this.androidQuestionsList.add(
            QuestionsModel("What is 'Edge' used for in Jetpack Compose?",
                "Defining edge constraints for layouts",
                "Handling network communication",
                "Handling navigation",
                "Handling gestures",
                "Defining edge constraints for layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ComposeResult' used for in Jetpack Compose?",
                "Representing the result of a composition",
                "Database synchronization",
                "Styling text",
                "Creating custom shapes",
                "Representing the result of a composition"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RippleModifier' used for in Jetpack Compose?",
                "Applying ripples to Composables",
                "Handling user authentication",
                "Network communication",
                "Storing app preferences",
                "Applying ripples to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayoutPlacer' used for in Jetpack Compose?",
                "Placing layout elements in Composables",
                "Handling background tasks",
                "Audio playback",
                "Handling user preferences",
                "Placing layout elements in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SemanticsNode' used for in Jetpack Compose?",
                "Representing semantic information for accessibility",
                "Handling navigation",
                "Handling animations",
                "Managing database transactions",
                "Representing semantic information for accessibility"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'GraphicsLayer' used for in Jetpack Compose?",
                "Creating graphics layers for Composables",
                "Managing views and view hierarchies",
                "Network communication",
                "Handling audio playback",
                "Creating graphics layers for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MutableTransitionState' used for in Jetpack Compose?",
                "Managing mutable transition states",
                "Database management",
                "Storing user input",
                "Managing global state",
                "Managing mutable transition states"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayoutAxis' used for in Jetpack Compose?",
                "Defining axis properties for layouts",
                "Handling user authentication",
                "Styling text",
                "Handling network requests",
                "Defining axis properties for layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InterceptedLayout' used for in Jetpack Compose?",
                "Intercepting the layout process of Composables",
                "Handling gestures",
                "Handling background tasks",
                "Layout design",
                "Intercepting the layout process of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InspectScope' used for in Jetpack Compose?",
                "Scope for inspecting Composables during composition",
                "Managing animations",
                "Handling user input",
                "Handling database transactions",
                "Scope for inspecting Composables during composition"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FlowModifier' used for in Jetpack Compose?",
                "Modifying the flow of Composables",
                "Storing app preferences",
                "Managing global state",
                "Creating custom themes",
                "Modifying the flow of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ModifierAlias' used for in Jetpack Compose?",
                "Creating aliases for Composable modifiers",
                "Handling database synchronization",
                "Handling navigation",
                "Handling animations",
                "Creating aliases for Composable modifiers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'UnitSize' used for in Jetpack Compose?",
                "Defining a size with unit dimensions",
                "Layout design",
                "Handling audio playback",
                "Handling gestures",
                "Defining a size with unit dimensions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InternalModifier' used for in Jetpack Compose?",
                "Applying internal modifiers to Composables",
                "Handling network requests",
                "Audio playback",
                "Managing database transactions",
                "Applying internal modifiers to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'CornerRadius' used for in Jetpack Compose?",
                "Defining corner radii for shapes",
                "Managing navigation",
                "Managing animations",
                "Database management",
                "Defining corner radii for shapes"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InteractionState' used for in Jetpack Compose?",
                "Managing the state of interactions in Composables",
                "Styling text",
                "Handling user preferences",
                "Handling background tasks",
                "Managing the state of interactions in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DensityModifier' used for in Jetpack Compose?",
                "Modifying density configurations for Composables",
                "Handling audio playback",
                "Handling gestures",
                "Network communication",
                "Modifying density configurations for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FontSize' used for in Jetpack Compose?",
                "Defining font sizes for text Composables",
                "Layout design",
                "Handling user input",
                "Handling database transactions",
                "Defining font sizes for text Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TagModifier' used for in Jetpack Compose?",
                "Applying tags to Composables",
                "Handling user authentication",
                "Storing app preferences",
                "Handling navigation",
                "Applying tags to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InspectorTable' used for in Jetpack Compose?",
                "Creating inspection tables for debugging",
                "Handling database synchronization",
                "Handling network communication",
                "Handling gestures",
                "Creating inspection tables for debugging"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'PressModifier' used for in Jetpack Compose?",
                "Modifying Composables with press interactions",
                "Audio playback",
                "Managing global state",
                "Layout design",
                "Modifying Composables with press interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ModifierCache' used for in Jetpack Compose?",
                "Caching Composable modifiers",
                "Handling user input",
                "Handling navigation",
                "Handling animations",
                "Caching Composable modifiers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ModalityModifier' used for in Jetpack Compose?",
                "Modifying Composables with modality",
                "Database management",
                "Styling text",
                "Handling user preferences",
                "Modifying Composables with modality"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RuntimeModifier' used for in Jetpack Compose?",
                "Applying runtime modifiers to Composables",
                "Handling network communication",
                "Handling background tasks",
                "Handling audio playback",
                "Applying runtime modifiers to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'CustomGestureFilter' used for in Jetpack Compose?",
                "Creating custom gesture filters",
                "Layout design",
                "Database synchronization",
                "Creating custom themes",
                "Creating custom gesture filters"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayerModifier' used for in Jetpack Compose?",
                "Modifying Composables with layers",
                "Storing app preferences",
                "Handling gestures",
                "Handling animations",
                "Modifying Composables with layers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayoutDsl' used for in Jetpack Compose?",
                "Defining domain-specific languages for layouts",
                "Handling database transactions",
                "Audio playback",
                "Handling user authentication",
                "Defining domain-specific languages for layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TextInputModifier' used for in Jetpack Compose?",
                "Modifying text input behavior in Composables",
                "Handling navigation",
                "Managing views and view hierarchies",
                "Network communication",
                "Modifying text input behavior in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TableRow' used for in Jetpack Compose?",
                "Defining rows in tabular layouts",
                "Managing animations",
                "Handling user input",
                "Handling background tasks",
                "Defining rows in tabular layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SemanticsNodeModifier' used for in Jetpack Compose?",
                "Modifying semantic nodes for accessibility",
                "Managing global state",
                "Handling gestures",
                "Handling database synchronization",
                "Modifying semantic nodes for accessibility"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FocusModifier' used for in Jetpack Compose?",
                "Modifying focus behavior in Composables",
                "Handling user preferences",
                "Handling network requests",
                "Styling text",
                "Modifying focus behavior in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'CompositionReference' used for in Jetpack Compose?",
                "Referencing compositions for Composables",
                "Handling animations",
                "Audio playback",
                "Layout design",
                "Referencing compositions for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ModifierInspector' used for in Jetpack Compose?",
                "Inspecting Composable modifiers",
                "Database management",
                "Handling navigation",
                "Handling user authentication",
                "Inspecting Composable modifiers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ModifierEvaluator' used for in Jetpack Compose?",
                "Evaluating Composable modifiers",
                "Handling gestures",
                "Handling background tasks",
                "Handling user input",
                "Evaluating Composable modifiers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransitionStateDefinition' used for in Jetpack Compose?",
                "Defining state definitions for transitions",
                "Handling database synchronization",
                "Storing app preferences",
                "Creating custom themes",
                "Defining state definitions for transitions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'GeometryModifier' used for in Jetpack Compose?",
                "Modifying Composables with geometry transformations",
                "Storing global state",
                "Handling audio playback",
                "Handling background tasks",
                "Modifying Composables with geometry transformations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DrawingModifier' used for in Jetpack Compose?",
                "Modifying Composables with custom drawings",
                "Handling network communication",
                "Layout design",
                "Handling navigation",
                "Modifying Composables with custom drawings"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SwipeModifier' used for in Jetpack Compose?",
                "Modifying Composables with swipe interactions",
                "Handling animations",
                "Handling user input",
                "Handling database transactions",
                "Modifying Composables with swipe interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ParagraphStyleModifier' used for in Jetpack Compose?",
                "Modifying paragraph styles in text Composables",
                "Managing animations",
                "Handling user authentication",
                "Handling audio playback",
                "Modifying paragraph styles in text Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'EffectModifier' used for in Jetpack Compose?",
                "Applying effects to Composables",
                "Layout design",
                "Handling network requests",
                "Creating custom shapes",
                "Applying effects to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RecordedTransform' used for in Jetpack Compose?",
                "Recording transformations of Composables",
                "Handling gestures",
                "Handling background tasks",
                "Styling text",
                "Recording transformations of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ScrollModifier' used for in Jetpack Compose?",
                "Modifying Composables with scroll behavior",
                "Database synchronization",
                "Storing user input",
                "Managing global state",
                "Modifying Composables with scroll behavior"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ConstraintLayout' used for in Jetpack Compose?",
                "Creating constraint-based layouts of Composables",
                "Handling navigation",
                "Audio playback",
                "Handling animations",
                "Creating constraint-based layouts of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'WaveformModifier' used for in Jetpack Compose?",
                "Modifying Composables with waveform visuals",
                "Handling user preferences",
                "Handling database transactions",
                "Handling gestures",
                "Modifying Composables with waveform visuals"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FocusTarget' used for in Jetpack Compose?",
                "Defining focus targets in Composables",
                "Handling user authentication",
                "Network communication",
                "Creating custom themes",
                "Defining focus targets in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransformOrigin' used for in Jetpack Compose?",
                "Defining the origin point for transformations",
                "Layout design",
                "Handling user input",
                "Handling navigation",
                "Defining the origin point for transformations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DisplayModifier' used for in Jetpack Compose?",
                "Modifying display properties of Composables",
                "Managing animations",
                "Handling database transactions",
                "Audio playback",
                "Modifying display properties of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ClickModifier' used for in Jetpack Compose?",
                "Modifying Composables with click interactions",
                "Styling text",
                "Handling user input",
                "Handling network requests",
                "Modifying Composables with click interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'CursorModifier' used for in Jetpack Compose?",
                "Modifying text cursor behavior in Composables",
                "Handling background tasks",
                "Handling navigation",
                "Handling audio playback",
                "Modifying text cursor behavior in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'OverlayModifier' used for in Jetpack Compose?",
                "Applying overlays to Composables",
                "Managing global state",
                "Network communication",
                "Layout design",
                "Applying overlays to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'PlatformModifier' used for in Jetpack Compose?",
                "Applying platform-specific modifiers",
                "Handling user preferences",
                "Handling gestures",
                "Handling animations",
                "Applying platform-specific modifiers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'IntrinsicSize' used for in Jetpack Compose?",
                "Defining intrinsic sizes for Composables",
                "Database management",
                "Audio playback",
                "Creating custom themes",
                "Defining intrinsic sizes for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransformModifier' used for in Jetpack Compose?",
                "Modifying Composables with custom transformations",
                "Handling network synchronization",
                "Handling user authentication",
                "Handling background tasks",
                "Modifying Composables with custom transformations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'Placement' used for in Jetpack Compose?",
                "Defining placement options for Composables",
                "Handling user input",
                "Creating custom shapes",
                "Handling database transactions",
                "Defining placement options for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'RichTextStyleModifier' used for in Jetpack Compose?",
                "Modifying rich text styles in Composables",
                "Layout design",
                "Handling navigation",
                "Managing global state",
                "Modifying rich text styles in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'PopupModifier' used for in Jetpack Compose?",
                "Modifying Composables with popup interactions",
                "Storing app preferences",
                "Handling animations",
                "Network communication",
                "Modifying Composables with popup interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InputModifier' used for in Jetpack Compose?",
                "Modifying input behavior in Composables",
                "Handling database transactions",
                "Handling user preferences",
                "Handling audio playback",
                "Modifying input behavior in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MultimodalModifier' used for in Jetpack Compose?",
                "Modifying Composables for multimodal interactions",
                "Handling gestures",
                "Handling background tasks",
                "Handling network requests",
                "Modifying Composables for multimodal interactions"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'AccessibilityAction' used for in Jetpack Compose?",
                "Defining accessibility actions for Composables",
                "Creating custom themes",
                "Managing navigation",
                "Styling text",
                "Defining accessibility actions for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'SwipeableState' used for in Jetpack Compose?",
                "Managing the state of swipeable Composables",
                "Handling user authentication",
                "Layout design",
                "Database synchronization",
                "Managing the state of swipeable Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ModifierPriority' used for in Jetpack Compose?",
                "Defining priority levels for Composable modifiers",
                "Handling background tasks",
                "Handling database transactions",
                "Audio playback",
                "Defining priority levels for Composable modifiers"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransitionStateInfo' used for in Jetpack Compose?",
                "Providing information about transition states",
                "Network communication",
                "Handling gestures",
                "Handling user input",
                "Providing information about transition states"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DraggableState' used for in Jetpack Compose?",
                "Managing the state of draggable Composables",
                "Handling animations",
                "Handling user preferences",
                "Creating custom shapes",
                "Managing the state of draggable Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InspectionInfo' used for in Jetpack Compose?",
                "Providing inspection information for debugging",
                "Handling navigation",
                "Audio playback",
                "Handling network synchronization",
                "Providing inspection information for debugging"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ScrollStateValue' used for in Jetpack Compose?",
                "Representing scroll state as a value",
                "Layout design",
                "Handling user input",
                "Handling background tasks",
                "Representing scroll state as a value"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayoutResult' used for in Jetpack Compose?",
                "Representing the result of layout calculations",
                "Storing app preferences",
                "Handling network requests",
                "Managing global state",
                "Representing the result of layout calculations"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ResolutionScope' used for in Jetpack Compose?",
                "Scope for resolving layout constraints",
                "Handling database management",
                "Handling animations",
                "Handling user authentication",
                "Scope for resolving layout constraints"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DraggableOrientation' used for in Jetpack Compose?",
                "Defining the orientation of draggable Composables",
                "Handling database synchronization",
                "Handling gestures",
                "Handling audio playback",
                "Defining the orientation of draggable Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FontFamilyModifier' used for in Jetpack Compose?",
                "Modifying font families in text Composables",
                "Creating custom themes",
                "Database management",
                "Managing navigation",
                "Modifying font families in text Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MarginSpacer' used for in Jetpack Compose?",
                "Inserting margin space in layouts",
                "Handling user input",
                "Styling text",
                "Handling database transactions",
                "Inserting margin space in layouts"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LineHeightModifier' used for in Jetpack Compose?",
                "Modifying line heights in text Composables",
                "Network communication",
                "Handling background tasks",
                "Audio playback",
                "Modifying line heights in text Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ViewGesturesModifier' used for in Jetpack Compose?",
                "Modifying gesture handling for views",
                "Handling global state",
                "Handling navigation",
                "Handling animations",
                "Modifying gesture handling for views"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DecorationImage' used for in Jetpack Compose?",
                "Defining decorative images for Composables",
                "Handling database synchronization",
                "Managing user preferences",
                "Managing animations",
                "Defining decorative images for Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'LayoutPaddingModifier' used for in Jetpack Compose?",
                "Modifying padding for layout elements",
                "Handling user authentication",
                "Creating custom shapes",
                "Handling background tasks",
                "Modifying padding for layout elements"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'BlockTransition' used for in Jetpack Compose?",
                "Managing block transitions in Composables",
                "Handling network requests",
                "Handling audio playback",
                "Layout design",
                "Managing block transitions in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'DisplayListModifier' used for in Jetpack Compose?",
                "Modifying Composables with display lists",
                "Storing global state",
                "Handling gestures",
                "Handling user input",
                "Modifying Composables with display lists"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'MergePolicy' used for in Jetpack Compose?",
                "Defining policies for merging Composables",
                "Handling navigation",
                "Handling animations",
                "Database management",
                "Defining policies for merging Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'StaticModifier' used for in Jetpack Compose?",
                "Applying static modifiers to Composables",
                "Managing database transactions",
                "Handling network communication",
                "Creating custom themes",
                "Applying static modifiers to Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VectorImageModifier' used for in Jetpack Compose?",
                "Modifying Composables with vector images",
                "Layout design",
                "Handling user preferences",
                "Handling user authentication",
                "Modifying Composables with vector images"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'InsetModifier' used for in Jetpack Compose?",
                "Modifying Composables with insets",
                "Handling gestures",
                "Handling background tasks",
                "Handling audio playback",
                "Modifying Composables with insets"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FramePaddingModifier' used for in Jetpack Compose?",
                "Modifying Composables with frame padding",
                "Styling text",
                "Handling database management",
                "Network synchronization",
                "Modifying Composables with frame padding"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TextGeometricModifier' used for in Jetpack Compose?",
                "Modifying text geometry in Composables",
                "Handling navigation",
                "Managing views and view hierarchies",
                "Handling user input",
                "Modifying text geometry in Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'CursorState' used for in Jetpack Compose?",
                "Managing the state of text cursors",
                "Creating custom themes",
                "Handling network requests",
                "Handling animations",
                "Managing the state of text cursors"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'FontLoaderModifier' used for in Jetpack Compose?",
                "Modifying font loading behavior in text Composables",
                "Database synchronization",
                "Audio playback",
                "Layout design",
                "Modifying font loading behavior in text Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'ShadowModifier' used for in Jetpack Compose?",
                "Modifying Composables with shadows",
                "Storing app preferences",
                "Handling user authentication",
                "Handling database transactions",
                "Modifying Composables with shadows"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'VibrantModifier' used for in Jetpack Compose?",
                "Modifying Composables with vibrant effects",
                "Handling background tasks",
                "Network communication",
                "Handling gestures",
                "Modifying Composables with vibrant effects"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'TransformAnimation' used for in Jetpack Compose?",
                "Animating transformations of Composables",
                "Handling animations",
                "Handling user input",
                "Handling database transactions",
                "Animating transformations of Composables"
            )
        )
        this.androidQuestionsList.add(
            QuestionsModel(
                "What is 'IntrinsicDimension' used for in Jetpack Compose?",
                "Defining intrinsic dimensions for Composables",
                "Handling user preferences",
                "Layout design",
                "Handling navigation",
                "Defining intrinsic dimensions for Composables"
            )
        )

        androidQuestionsList.shuffle()


    }

}