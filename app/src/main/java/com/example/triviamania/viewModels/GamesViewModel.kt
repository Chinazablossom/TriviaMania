package com.example.triviamania.viewModels

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triviamania.Models.QuestionsModel

class GamesViewModel:ViewModel (){

    val questionsList = ArrayList<QuestionsModel>()

    private var _score = MutableLiveData(0)
    val score: LiveData<Int> get() = _score
    private var _position = MutableLiveData(0)
    val position: LiveData<Int> get() = _position
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

        if (selectedOption == questionsList[currentPosition].correctAnswer) {
            increaseScore()
            return true
        }
        return false
    }



    fun entertainmentStageOne(){
        questionsList.clear()

        questionsList.add(
            QuestionsModel(
                "Who directed the movie 'Inception'?",
                "Christopher Nolan",
                "Martin Scorsese",
                "Quentin Tarantino",
                "Steven Spielberg",
                "Christopher Nolan"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which actor played the character Tony Stark/Iron Man in the Marvel Cinematic Universe?",
                "Chris Hemsworth",
                "Chris Evans",
                "Robert Downey Jr.",
                "Mark Ruffalo",
                "Robert Downey Jr."
            )
        )

        questionsList.add(
            QuestionsModel(
                "In the TV series 'Friends,' what is the name of Ross Geller's second wife?",
                "Emily",
                "Carol",
                "Janice",
                "Rachel",
                "Emily"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who wrote the play 'Romeo and Juliet'?",
                "Charles Dickens",
                "William Shakespeare",
                "Jane Austen",
                "Emily Brontë",
                "William Shakespeare"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which film won the Academy Award for Best Picture in 2020?",
                "1917",
                "Joker",
                "Parasite",
                "Once Upon a Time in Hollywood",
                "Parasite"
            )
        )

        questionsList.add(
            QuestionsModel(
                "In the Harry Potter series, who is the headmaster of Hogwarts School of Witchcraft and Wizardry?",
                "Severus Snape",
                "Alastor Moody",
                "Sirius Black",
                "Albus Dumbledore",
                "Albus Dumbledore"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which animated film features a character named Simba?",
                "Shrek",
                "The Lion King",
                "Finding Nemo",
                "Toy Story",
                "The Lion King"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who played the role of Neo in 'The Matrix' trilogy?",
                "Keanu Reeves",
                "Brad Pitt",
                "Tom Cruise",
                "Will Smith",
                "Keanu Reeves"
            )
        )

        questionsList.add(
            QuestionsModel(
                "In the TV series 'Breaking Bad,' what is Walter White's alias?",
                "Heisenberg",
                "El Chapo",
                "The Godfather",
                "Scarface",
                "Heisenberg"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which actress starred as Katniss Everdeen in 'The Hunger Games' film series?",
                "Emma Watson",
                "Jennifer Aniston",
                "Jennifer Lawrence",
                "Scarlett Johansson",
                "Jennifer Lawrence"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who directed the movie 'The Dark Knight'?",
                "Christopher Nolan",
                "Martin Scorsese",
                "Quentin Tarantino",
                "Steven Spielberg",
                "Christopher Nolan"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which animated film tells the story of a rat named Remy who aspires to be a great chef?",
                "Finding Nemo",
                "Toy Story",
                "The Incredibles",
                "Ratatouille",
                "Ratatouille"
            )
        )

        questionsList.add(
            QuestionsModel(
                "In the TV series 'Stranger Things,' what is the name of the parallel dimension?",
                "The Underworld",
                "The Abyss",
                "The Netherworld",
                "The Upside Down",
                "The Upside Down"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who played the role of Jack Dawson in the film 'Titanic'?",
                "Brad Pitt",
                "Leonardo DiCaprio",
                "Tom Hanks",
                "Johnny Depp",
                "Leonardo DiCaprio"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which musical features the songs 'I Dreamed a Dream' and 'On My Own'?",
                "Mamma Mia!",
                "Les Misérables",
                "The Phantom of the Opera",
                "Cats",
                "Les Misérables"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who is the author of the 'Harry Potter' book series?",
                "J.K. Rowling",
                "George R.R. Martin",
                "Stephen King",
                "J.R.R. Tolkien",
                "J.K. Rowling"
            )
        )

        questionsList.add(
            QuestionsModel(
                "In the TV series 'The Simpsons,' what is the name of Homer's neighbor?",
                "Ned Flanders",
                "Barney Gumble",
                "Moe Szyslak",
                "Apu Nahasapeemapetilon",
                "Ned Flanders"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which actor starred as the character James Bond in the film 'Skyfall'?",
                "Daniel Craig",
                "Sean Connery",
                "Pierce Brosnan",
                "Roger Moore",
                "Daniel Craig"
            )
        )

        questionsList.add(
            QuestionsModel(
                "What is the fictional continent where most of the events in 'Game of Thrones' take place?",
                "Westeros",
                "Essos",
                "Sothoryos",
                "Ulthos",
                "Westeros"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which film won the first Academy Award for Best Picture?",
                "Gone with the Wind",
                "Casablanca",
                "The Godfather",
                "Wings",
                "Wings"
            )
        )


        questionsList.add(
            QuestionsModel(
                "Who is often referred to as the 'Queen of Pop'?",
                "Madonna",
                "Beyoncé",
                "Lady Gaga",
                "Taylor Swift",
                "Madonna"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which band released the iconic album 'The Dark Side of the Moon'?",
                "Led Zeppelin",
                "The Rolling Stones",
                "The Beatles",
                "Pink Floyd",
                "Pink Floyd"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who is known as the 'King of Rock and Roll'?",
                "Johnny Cash",
                "Chuck Berry",
                "Elvis Presley",
                "Buddy Holly",
                "Elvis Presley"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which female artist won the most Grammy Awards in a single night?",
                "Adele",
                "Beyoncé",
                "Taylor Swift",
                "Whitney Houston",
                "Beyoncé"
            )
        )

        questionsList.add(
            QuestionsModel(
                "In which year did Michael Jackson release his album 'Thriller'?",
                "1980",
                "1982",
                "1984",
                "1986",
                "1982"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who is the lead vocalist of the rock band Queen?",
                "Freddie Mercury",
                "Robert Plant",
                "Mick Jagger",
                "Axl Rose",
                "Freddie Mercury"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which rapper's real name is Marshall Mathers?",
                "Jay-Z",
                "Eminem",
                "Drake",
                "Kendrick Lamar",
                "Eminem"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who wrote the song 'Like a Rolling Stone'?",
                "Bob Dylan",
                "The Rolling Stones",
                "Bruce Springsteen",
                "Tom Petty",
                "Bob Dylan"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which British band released the album 'Abbey Road'?",
                "The Who",
                "The Beatles",
                "The Kinks",
                "The Rolling Stones",
                "The Beatles"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who is known as the 'Goddess of Pop'?",
                "Madonna",
                "Celine Dion",
                "Cher",
                "Whitney Houston",
                "Cher"
            )
        )

        questionsList.add(
            QuestionsModel(
                "What is the best-selling album of all time?",
                "Thriller by Michael Jackson",
                "The Dark Side of the Moon by Pink Floyd",
                "Back in Black by AC/DC",
                "Rumours by Fleetwood Mac",
                "Thriller by Michael Jackson"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who composed the famous classical piece 'Für Elise'?",
                "Johann Sebastian Bach",
                "Ludwig van Beethoven",
                "Wolfgang Amadeus Mozart",
                "Franz Schubert",
                "Ludwig van Beethoven"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which country is the origin of the flamenco music genre?",
                "Brazil",
                "Spain",
                "Argentina",
                "Cuba",
                "Spain"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who is known for his influential work in the genre of reggae music?",
                "Bob Marley",
                "Jimmy Cliff",
                "Peter Tosh",
                "Burning Spear",
                "Bob Marley"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which famous composer was deaf during the later part of his life?",
                "Wolfgang Amadeus Mozart",
                "Ludwig van Beethoven",
                "Johann Sebastian Bach",
                "Franz Schubert",
                "Ludwig van Beethoven"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who is known as the 'Prince of Motown'?",
                "Marvin Gaye",
                "Smokey Robinson",
                "Stevie Wonder",
                "Otis Redding",
                "Smokey Robinson"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Which female artist released the album 'Back to Black'?",
                "Adele",
                "Amy Winehouse",
                "Taylor Swift",
                "Rihanna",
                "Amy Winehouse"
            )
        )

        questionsList.add(
            QuestionsModel(
                "Who was known as the 'King of Pop'?",
                "Michael Jackson",
                "Prince",
                "Elvis Presley",
                "Frank Sinatra",
                "Michael Jackson"
            )
        )

        questionsList.add(
            QuestionsModel(
                "In which year did The Beatles release their album 'Sgt. Pepper's Lonely Hearts Club Band'?",
                "1965",
                "1967",
                "1969",
                "1971",
                "1967"
            )
        )
        questionsList.add(
            QuestionsModel(
                "Who is known as the 'King of Pop'?",
                "Elvis Presley",
                "Michael Jackson",
                "Frank Sinatra",
                "Prince",
                "Michael Jackson"
            )
        )

        questionsList.shuffle()
    }
    fun entertainmentStageTwo(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Which band released the hit song 'Bohemian Rhapsody'?",
            "The Beatles",
            "Queen",
            "Led Zeppelin",
            "ABBA",
            "Queen"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the lead vocalist of the band Nirvana?",
            "Kurt Cobain",
            "Eddie Vedder",
            "Chris Cornell",
            "Dave Grohl",
            "Kurt Cobain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which pop icon is known as the 'Material Girl'?",
            "Beyoncé",
            "Madonna",
            "Lady Gaga",
            "Britney Spears",
            "Madonna"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which year did The Beatles release their debut album 'Please Please Me'?",
            "1962",
            "1965",
            "1968",
            "1971",
            "1963"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who sang the hit song 'Rolling in the Deep'?",
            "Adele",
            "Taylor Swift",
            "Rihanna",
            "Katy Perry",
            "Adele"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which famous rapper's real name is Shawn Corey Carter?",
            "Kanye West",
            "Eminem",
            "Jay-Z",
            "Drake",
            "Jay-Z"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of Taylor Swift's first studio album?",
            "Fearless",
            "Speak Now",
            "Red",
            "Taylor Swift",
            "Taylor Swift"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was known as the 'King of Rock and Roll'?",
            "Johnny Cash",
            "Chuck Berry",
            "Elvis Presley",
            "Buddy Holly",
            "Elvis Presley"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which band is often associated with the song 'Stairway to Heaven'?",
            "The Rolling Stones",
            "Led Zeppelin",
            "The Who",
            "Pink Floyd",
            "Led Zeppelin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who won the first season of 'American Idol' in 2002?",
            "Kelly Clarkson",
            "Carrie Underwood",
            "Adam Lambert",
            "Jennifer Hudson",
            "Kelly Clarkson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What genre of music is characterized by its roots in African American and Hispanic cultures and features a strong, persistent beat?",
            "Country",
            "Jazz",
            "Hip-Hop",
            "Latin",
            "Hip-Hop"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which legendary musician is often referred to as 'The King of Blues'?",
            "Chuck Berry",
            "Muddy Waters",
            "B.B. King",
            "Jimi Hendrix",
            "B.B. King"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which female artist released the album '1989'?",
            "Adele",
            "Taylor Swift",
            "Beyoncé",
            "Rihanna",
            "Taylor Swift"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of The Beatles' animated film released in 1968?",
            "Yellow Submarine",
            "Help!",
            "A Hard Day's Night",
            "Let It Be",
            "Yellow Submarine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the lead singer of the band Queen?",
            "Freddie Mercury",
            "David Bowie",
            "Roger Daltrey",
            "Robert Plant",
            "Freddie Mercury"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional band in the film 'Almost Famous'?",
            "The Rolling Stones",
            "Stillwater",
            "The Beatles",
            "Led Zeppelin",
            "Stillwater"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which country is the origin of the musical genre 'Samba'?",
            "Mexico",
            "Brazil",
            "Argentina",
            "Cuba",
            "Brazil"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for his influential work in the genre of reggae music?",
            "Bob Marley",
            "Jimmy Cliff",
            "Peter Tosh",
            "Burning Spear",
            "Bob Marley"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which famous composer was a child prodigy and wrote his first symphony at the age of eight?",
            "Wolfgang Amadeus Mozart",
            "Ludwig van Beethoven",
            "Johann Sebastian Bach",
            "Franz Schubert",
            "Wolfgang Amadeus Mozart"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who played the character Jack Dawson in the film 'Titanic'?",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Tom Hanks",
            "Johnny Depp",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Jurassic Park,' what kind of creatures do the park's visitors come to see?",
            "Dinosaurs",
            "Aliens",
            "Robots",
            "Superheroes",
            "Dinosaurs"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'The Shawshank Redemption'?",
            "Steven Spielberg",
            "Christopher Nolan",
            "Frank Darabont",
            "Quentin Tarantino",
            "Frank Darabont"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Harry Potter?",
            "The Lord of the Rings",
            "The Matrix",
            "Star Wars",
            "Harry Potter",
            "Harry Potter"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What does the acronym 'CGI' stand for in the context of filmmaking?",
            "Computer Generated Imagery",
            "Creative Graphics Interface",
            "Cinematic Graphics Integration",
            "Central Graphics Infrastructure",
            "Computer Generated Imagery"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Simba?",
            "Shrek",
            "The Lion King",
            "Finding Nemo",
            "Toy Story",
            "The Lion King"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the film 'Forrest Gump'?",
            "Tom Hanks",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Johnny Depp",
            "Tom Hanks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Picture in 1994?",
            "Titanic",
            "The Silence of the Lambs",
            "Forrest Gump",
            "The Godfather",
            "Forrest Gump"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the magical land in the film 'The Wizard of Oz'?",
            "Neverland",
            "Narnia",
            "Middle-earth",
            "Oz",
            "Oz"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the role of James Bond in the film 'Skyfall'?",
            "Daniel Craig",
            "Sean Connery",
            "Pierce Brosnan",
            "Roger Moore",
            "Daniel Craig"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor portrayed Tony Stark/Iron Man in the Marvel Cinematic Universe?",
            "Chris Hemsworth",
            "Chris Evans",
            "Robert Downey Jr.",
            "Mark Ruffalo",
            "Robert Downey Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'The Matrix,' who is 'The One' prophesized to bring balance to the Matrix?",
            "Neo",
            "Morpheus",
            "Trinity",
            "Agent Smith",
            "Neo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional city where Batman operates in the DC Comics universe?",
            "Metropolis",
            "Gotham City",
            "Central City",
            "Star City",
            "Gotham City"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'E.T. the Extra-Terrestrial'?",
            "Steven Spielberg",
            "George Lucas",
            "Christopher Nolan",
            "Tim Burton",
            "Steven Spielberg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'The Godfather,' what is the name of the central character played by Marlon Brando?",
            "Tony Montana",
            "Michael Corleone",
            "Don Vito Corleone",
            "Sonny Corleone",
            "Don Vito Corleone"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the ice princess in Disney's 'Frozen'?",
            "Cinderella",
            "Ariel",
            "Elsa",
            "Belle",
            "Elsa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jack Sparrow?",
            "Pirates of the Caribbean: The Curse of the Black Pearl",
            "The Lord of the Rings: The Fellowship of the Ring",
            "Gladiator",
            "The Dark Knight",
            "Pirates of the Caribbean: The Curse of the Black Pearl"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the magical school in the 'Harry Potter' film series?",
            "Hogwarts School of Witchcraft and Wizardry",
            "Beauxbatons Academy of Magic",
            "Durmstrang Institute",
            "Ilvermorny School of Witchcraft and Wizardry",
            "Hogwarts School of Witchcraft and Wizardry"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Katniss Everdeen in 'The Hunger Games' film series?",
            "Jennifer Aniston",
            "Emma Watson",
            "Jennifer Lawrence",
            "Anne Hathaway",
            "Jennifer Lawrence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Disney animated film features a character named Simba?",
            "Aladdin",
            "The Little Mermaid",
            "Beauty and the Beast",
            "The Lion King",
            "The Lion King"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who played the character Jack Dawson in the film 'Titanic'?",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Tom Hanks",
            "Johnny Depp",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which year was the first episode of 'Friends' aired?",
            "1992",
            "1994",
            "1996",
            "1998",
            "1994"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which famous actor played the lead role in the 'Taken' film series?",
            "Liam Neeson",
            "Bruce Willis",
            "Arnold Schwarzenegger",
            "Harrison Ford",
            "Liam Neeson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional wizarding school in the 'Harry Potter' series?",
            "Hogwarts School of Witchcraft and Wizardry",
            "Ilvermorny School of Witchcraft and Wizardry",
            "Beauxbatons Academy of Magic",
            "Durmstrang Institute",
            "Hogwarts School of Witchcraft and Wizardry"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main antagonist in Disney's 'The Lion King'?",
            "Scar",
            "Jafar",
            "Ursula",
            "Maleficent",
            "Scar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jack Sparrow?",
            "Pirates of the Caribbean: The Curse of the Black Pearl",
            "The Lord of the Rings: The Fellowship of the Ring",
            "Gladiator",
            "The Dark Knight",
            "Pirates of the Caribbean: The Curse of the Black Pearl"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Katniss Everdeen in 'The Hunger Games' film series?",
            "Jennifer Aniston",
            "Emma Watson",
            "Jennifer Lawrence",
            "Anne Hathaway",
            "Jennifer Lawrence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Shrek?",
            "Finding Nemo",
            "Toy Story",
            "The Lion King",
            "Shrek",
            "Shrek"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Inception'?",
            "Steven Spielberg",
            "Christopher Nolan",
            "Quentin Tarantino",
            "Martin Scorsese",
            "Christopher Nolan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor played the role of Tony Stark/Iron Man in the Marvel Cinematic Universe?",
            "Chris Hemsworth",
            "Chris Evans",
            "Robert Downey Jr.",
            "Mark Ruffalo",
            "Robert Downey Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional city where Batman operates in the DC Comics universe?",
            "Metropolis",
            "Gotham City",
            "Central City",
            "Star City",
            "Gotham City"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Woody in the 'Toy Story' film series?",
            "Tom Hanks",
            "Tim Allen",
            "Will Smith",
            "Jim Carrey",
            "Tom Hanks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Picture in 1994?",
            "Titanic",
            "The Silence of the Lambs",
            "Forrest Gump",
            "The Godfather",
            "Forrest Gump"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the magical land in the film 'The Wizard of Oz'?",
            "Neverland",
            "Narnia",
            "Middle-earth",
            "Oz",
            "Oz"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the lead role in the film 'The Dark Knight'?",
            "Christian Bale",
            "Heath Ledger",
            "Tom Hardy",
            "Michael Caine",
            "Christian Bale"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Breaking Bad,' what is the main character's real name?",
            "Walter White",
            "Jesse Pinkman",
            "Saul Goodman",
            "Skyler White",
            "Walter White"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Ethan Hunt?",
            "Die Hard",
            "Mission: Impossible",
            "The Bourne Identity",
            "James Bond",
            "Mission: Impossible"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Jack in the film 'The Shining'?",
            "Jack Nicholson",
            "Robert De Niro",
            "Al Pacino",
            "Tom Cruise",
            "Jack Nicholson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Maximus Decimus Meridius?",
            "Gladiator",
            "Braveheart",
            "300",
            "Troy",
            "Gladiator"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Avatar'?",
            "Christopher Nolan",
            "James Cameron",
            "Steven Spielberg",
            "Peter Jackson",
            "James Cameron"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Stranger Things,' what is the name of the parallel dimension inhabited by the Demogorgon?",
            "Upside Down",
            "Otherworld",
            "Shadow Realm",
            "Netherworld",
            "Upside Down"
        )
    )


        questionsList.shuffle()

    }
    fun entertainmentStageThree(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Jurassic Park'?",
            "Steven Spielberg",
            "Christopher Nolan",
            "James Cameron",
            "Tim Burton",
            "Steven Spielberg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor played the character Hannibal Lecter in the film 'The Silence of the Lambs'?",
            "Anthony Hopkins",
            "Robert De Niro",
            "Morgan Freeman",
            "Jack Nicholson",
            "Anthony Hopkins"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'The Matrix,' what color is the pill that Neo takes to enter the Matrix?",
            "Red",
            "Blue",
            "Green",
            "Yellow",
            "Red"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the lead role in the film 'Inglourious Basterds' directed by Quentin Tarantino?",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Tom Hanks",
            "Johnny Depp",
            "Brad Pitt"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Breaking Bad,' what is the street name of the high-quality blue crystal meth produced by Walter White and Jesse Pinkman?",
            "Blue Ice",
            "Crystal Bliss",
            "Blue Sky",
            "Ice Queen",
            "Blue Sky"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Jack Dawson in the film 'Titanic'?",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Tom Hanks",
            "Johnny Depp",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Maximus Decimus Meridius?",
            "Gladiator",
            "Braveheart",
            "300",
            "Troy",
            "Gladiator"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the film 'The Dark Knight,' who is the main antagonist, also known as the Joker?",
            "Heath Ledger",
            "Jack Nicholson",
            "Cillian Murphy",
            "Tom Hardy",
            "Heath Ledger"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'The Shawshank Redemption'?",
            "Steven Spielberg",
            "Christopher Nolan",
            "Frank Darabont",
            "Quentin Tarantino",
            "Frank Darabont"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Animated Feature in 2003?",
            "Shrek",
            "Finding Nemo",
            "The Incredibles",
            "Toy Story 2",
            "Finding Nemo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Game of Thrones,' what is the name of Jon Snow's direwolf?",
            "Ghost",
            "Shadow",
            "Fang",
            "Storm",
            "Ghost"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Katniss Everdeen in 'The Hunger Games' film series?",
            "Jennifer Aniston",
            "Emma Watson",
            "Jennifer Lawrence",
            "Anne Hathaway",
            "Jennifer Lawrence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jack Sparrow?",
            "Pirates of the Caribbean: The Curse of the Black Pearl",
            "The Lord of the Rings: The Fellowship of the Ring",
            "Gladiator",
            "The Dark Knight",
            "Pirates of the Caribbean: The Curse of the Black Pearl"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'E.T. the Extra-Terrestrial'?",
            "Steven Spielberg",
            "George Lucas",
            "Christopher Nolan",
            "Tim Burton",
            "Steven Spielberg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor portrayed Tony Stark/Iron Man in the Marvel Cinematic Universe?",
            "Chris Hemsworth",
            "Chris Evans",
            "Robert Downey Jr.",
            "Mark Ruffalo",
            "Robert Downey Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the film 'The Matrix,' who is 'The One' prophesized to bring balance to the Matrix?",
            "Neo",
            "Morpheus",
            "Trinity",
            "Agent Smith",
            "Neo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Woody in the 'Toy Story' film series?",
            "Tom Hanks",
            "Tim Allen",
            "Will Smith",
            "Jim Carrey",
            "Tom Hanks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jason Bourne?",
            "Die Hard",
            "Mission: Impossible",
            "The Bourne Identity",
            "James Bond",
            "The Bourne Identity"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Ellen Ripley in the film 'Aliens'?",
            "Sigourney Weaver",
            "Meryl Streep",
            "Angelina Jolie",
            "Scarlett Johansson",
            "Sigourney Weaver"
        )
    )
    questionsList.add(
        QuestionsModel(
            "In the TV series 'Stranger Things,' what is the name of Eleven's supernatural ability?",
            "Telekinesis",
            "Telepathy",
            "Time Travel",
            "Invisibility",
            "Telekinesis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named John Wick, portrayed by Keanu Reeves?",
            "The Matrix",
            "Speed",
            "Point Break",
            "John Wick",
            "John Wick"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Forrest Gump'?",
            "Steven Spielberg",
            "Robert Zemeckis",
            "James Cameron",
            "Martin Scorsese",
            "Robert Zemeckis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Frozen,' what is the name of Elsa's magical snowman companion?",
            "Olaf",
            "Sven",
            "Kristoff",
            "Hans",
            "Olaf"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor played the role of Sherlock Holmes in the film 'Sherlock Holmes' (2009)?",
            "Benedict Cumberbatch",
            "Robert Downey Jr.",
            "Jude Law",
            "Martin Freeman",
            "Robert Downey Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'The Grand Budapest Hotel'?",
            "Christopher Nolan",
            "Wes Anderson",
            "Quentin Tarantino",
            "Coen Brothers",
            "Wes Anderson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Office' (US), who is the regional manager of Dunder Mifflin's Scranton branch?",
            "Jim Halpert",
            "Dwight Schrute",
            "Michael Scott",
            "Pam Beesly",
            "Michael Scott"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jules Winnfield and his famous 'Ezekiel 25:17' speech?",
            "Pulp Fiction",
            "The Shawshank Redemption",
            "Fight Club",
            "The Big Lebowski",
            "Pulp Fiction"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Jack in the film 'Titanic'?",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Tom Hanks",
            "Johnny Depp",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Friends,' what is the name of Ross Geller's second wife?",
            "Rachel Green",
            "Emily Waltham",
            "Janice Litman",
            "Carol Willick",
            "Emily Waltham"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the lead role in the film 'The Godfather'?",
            "Al Pacino",
            "Robert De Niro",
            "Marlon Brando",
            "Joe Pesci",
            "Marlon Brando"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the film 'The Princess Bride,' what is the name of the main character's true love?",
            "Buttercup",
            "Miranda",
            "Fiona",
            "Isabella",
            "Buttercup"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'The Dark Knight Rises'?",
            "Christopher Nolan",
            "Joss Whedon",
            "Zack Snyder",
            "Tim Burton",
            "Christopher Nolan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Simpsons,' what is the name of the bartender at Moe's Tavern?",
            "Ned Flanders",
            "Barney Gumble",
            "Apu Nahasapeemapetilon",
            "Moe Szyslak",
            "Moe Szyslak"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Forrest Gump in the film 'Forrest Gump'?",
            "Tom Hanks",
            "Matt Damon",
            "Brad Pitt",
            "Johnny Depp",
            "Tom Hanks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Breaking Bad,' what is the street name of the high-quality blue crystal meth produced by Walter White and Jesse Pinkman?",
            "Blue Ice",
            "Crystal Bliss",
            "Blue Sky",
            "Ice Queen",
            "Blue Sky"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Animated Feature in 2016?",
            "Zootopia",
            "Moana",
            "Kubo and the Two Strings",
            "Finding Dory",
            "Zootopia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Lara Croft in the film 'Lara Croft: Tomb Raider' (2001)?",
            "Angelina Jolie",
            "Jennifer Lawrence",
            "Scarlett Johansson",
            "Charlize Theron",
            "Angelina Jolie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jack Dawson?",
            "Titanic",
            "Inception",
            "Interstellar",
            "The Revenant",
            "Titanic"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the film 'The Matrix,' what is the real name of the character known as Trinity?",
            "Alice",
            "Maggie",
            "Sarah",
            "Katherine",
            "Katherine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Stranger Things,' what is the name of the parallel dimension inhabited by the Demogorgon?",
            "Upside Down",
            "Otherworld",
            "Shadow Realm",
            "Netherworld",
            "Upside Down"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Aragorn in 'The Lord of the Rings' film trilogy?",
            "Elijah Wood",
            "Orlando Bloom",
            "Viggo Mortensen",
            "Sean Bean",
            "Viggo Mortensen"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Maximus Decimus Meridius?",
            "Gladiator",
            "Braveheart",
            "300",
            "Troy",
            "Gladiator"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Shrek,' who voices the character Donkey?",
            "Eddie Murphy",
            "Mike Myers",
            "Cameron Diaz",
            "Antonio Banderas",
            "Eddie Murphy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'The Shawshank Redemption'?",
            "Steven Spielberg",
            "Christopher Nolan",
            "Frank Darabont",
            "Quentin Tarantino",
            "Frank Darabont"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Game of Thrones,' what is the name of Jon Snow's direwolf?",
            "Ghost",
            "Shadow",
            "Fang",
            "Storm",
            "Ghost"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jack Sparrow?",
            "Pirates of the Caribbean: The Curse of the Black Pearl",
            "The Lord of the Rings: The Fellowship of the Ring",
            "Gladiator",
            "The Dark Knight",
            "Pirates of the Caribbean: The Curse of the Black Pearl"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Friends,' what is the name of Ross Geller's second wife?",
            "Rachel Green",
            "Emily Waltham",
            "Janice Litman",
            "Carol Willick",
            "Emily Waltham"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Katniss Everdeen in 'The Hunger Games' film series?",
            "Jennifer Aniston",
            "Emma Watson",
            "Jennifer Lawrence",
            "Anne Hathaway",
            "Jennifer Lawrence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Animated Feature in 2008?",
            "Ratatouille",
            "WALL-E",
            "Kung Fu Panda",
            "Bolt",
            "WALL-E"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Office' (US), who is the regional manager of Dunder Mifflin's Scranton branch?",
            "Jim Halpert",
            "Dwight Schrute",
            "Michael Scott",
            "Pam Beesly",
            "Michael Scott"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Inception'?",
            "Christopher Nolan",
            "Quentin Tarantino",
            "Steven Spielberg",
            "James Cameron",
            "Christopher Nolan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Finding Nemo,' what is the name of Nemo's father?",
            "Marlin",
            "Dory",
            "Bruce",
            "Squirt",
            "Marlin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jack Dawson?",
            "Titanic",
            "Inception",
            "Interstellar",
            "The Revenant",
            "Titanic"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Jack in the film 'Titanic'?",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Tom Hanks",
            "Johnny Depp",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Stranger Things,' what is the name of Eleven's supernatural ability?",
            "Telekinesis",
            "Telepathy",
            "Time Travel",
            "Invisibility",
            "Telekinesis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Ferris Bueller in the film 'Ferris Bueller's Day Off'?",
            "Matthew Broderick",
            "Jon Cryer",
            "Judd Nelson",
            "Charlie Sheen",
            "Matthew Broderick"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Simpsons,' what is the name of Homer Simpson's neighbor?",
            "Ned Flanders",
            "Barney Gumble",
            "Apu Nahasapeemapetilon",
            "Moe Szyslak",
            "Ned Flanders"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who won the Academy Award for Best Actor for his role in the film 'The Revenant'?",
            "Matthew McConaughey",
            "Leonardo DiCaprio",
            "Joaquin Phoenix",
            "Brad Pitt",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jack Dawson?",
            "Titanic",
            "Inception",
            "Interstellar",
            "The Revenant",
            "Titanic"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'The Dark Knight Rises'?",
            "Christopher Nolan",
            "Joss Whedon",
            "Zack Snyder",
            "Tim Burton",
            "Christopher Nolan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Breaking Bad,' what is the street name of the high-quality blue crystal meth produced by Walter White and Jesse Pinkman?",
            "Blue Ice",
            "Crystal Bliss",
            "Blue Sky",
            "Ice Queen",
            "Blue Sky"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Jules Winnfield and his famous 'Ezekiel 25:17' speech?",
            "Pulp Fiction",
            "The Shawshank Redemption",
            "Fight Club",
            "The Big Lebowski",
            "Pulp Fiction"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Lara Croft in the film 'Lara Croft: Tomb Raider' (2001)?",
            "Angelina Jolie",
            "Jennifer Lawrence",
            "Scarlett Johansson",
            "Charlize Theron",
            "Angelina Jolie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Animated Feature in 2016?",
            "Zootopia",
            "Moana",
            "Kubo and the Two Strings",
            "Finding Dory",
            "Zootopia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Jack in the film 'Titanic'?",
            "Brad Pitt",
            "Leonardo DiCaprio",
            "Tom Hanks",
            "Johnny Depp",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Friends,' what is the name of Ross Geller's second wife?",
            "Rachel Green",
            "Emily Waltham",
            "Janice Litman",
            "Carol Willick",
            "Emily Waltham"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'The Grand Budapest Hotel'?",
            "Christopher Nolan",
            "Wes Anderson",
            "Quentin Tarantino",
            "Coen Brothers",
            "Wes Anderson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor played the role of Sherlock Holmes in the film 'Sherlock Holmes' (2009)?",
            "Benedict Cumberbatch",
            "Robert Downey Jr.",
            "Jude Law",
            "Martin Freeman",
            "Robert Downey Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Frozen,' what is the name of Elsa's magical snowman companion?",
            "Olaf",
            "Sven",
            "Kristoff",
            "Hans",
            "Olaf"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Forrest Gump'?",
            "Steven Spielberg",
            "Robert Zemeckis",
            "James Cameron",
            "Martin Scorsese",
            "Robert Zemeckis"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageFour(){
        questionsList.clear()

        questionsList.add(
      QuestionsModel(
          "Which film features a character named John Wick, portrayed by Keanu Reeves?",
          "The Matrix",
          "Speed",
          "Point Break",
          "John Wick",
          "John Wick"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What does XML stand for in Android development?",
          "Extensible Markup Language",
          "Extra Modern Language",
          "Extended Mobile Language",
          "Extreme Makeup Language",
          "Extensible Markup Language"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of Eleven's supernatural ability?",
          "Telekinesis",
          "Telepathy",
          "Time Travel",
          "Invisibility",
          "Telekinesis"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film won the Academy Award for Best Picture in 1994?",
          "Forrest Gump",
          "Pulp Fiction",
          "The Shawshank Redemption",
          "Titanic",
          "Forrest Gump"
      )
  )
  questionsList.add(
      QuestionsModel(
          "In the TV series 'Breaking Bad,' what is the alias used by Walter White in the drug trade?",
          "Heisenberg",
          "El Chapo",
          "Scarface",
          "The Chemist",
          "Heisenberg"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Tony Stark?",
          "Spider-Man: Homecoming",
          "The Dark Knight",
          "Iron Man",
          "Captain America: The Winter Soldier",
          "Iron Man"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character Maximus Decimus Meridius in the film 'Gladiator'?",
          "Russell Crowe",
          "Joaquin Phoenix",
          "Mel Gibson",
          "Christian Bale",
          "Russell Crowe"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the animated film 'Toy Story,' what is the name of Woody's owner?",
          "Andy",
          "Tommy",
          "Billy",
          "Jessie",
          "Andy"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who directed the film 'The Silence of the Lambs'?",
          "Steven Spielberg",
          "Quentin Tarantino",
          "Martin Scorsese",
          "Jonathan Demme",
          "Jonathan Demme"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'The Office' (US), what is the name of Jim and Pam's first child?",
          "Michael",
          "Cece",
          "David",
          "Andy",
          "Cece"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Neo and a simulated reality known as the Matrix?",
          "The Terminator",
          "Blade Runner",
          "The Matrix",
          "Inception",
          "The Matrix"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Friends,' what is the profession of Chandler Bing?",
          "Doctor",
          "Actor",
          "Chef",
          "Advertising Executive",
          "Advertising Executive"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character Jack Dawson in the film 'Titanic'?",
          "Brad Pitt",
          "Leonardo DiCaprio",
          "Tom Hanks",
          "Johnny Depp",
          "Leonardo DiCaprio"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film won the Academy Award for Best Animated Feature in 2018?",
          "Coco",
          "Zootopia",
          "Toy Story 4",
          "Spider-Man: Into the Spider-Verse",
          "Spider-Man: Into the Spider-Verse"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of the creature from the Upside Down that terrorizes Hawkins?",
          "Demogorgon",
          "Mind Flayer",
          "Demodogs",
          "Shadow Monster",
          "Demogorgon"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who directed the film 'Jurassic Park'?",
          "Steven Spielberg",
          "James Cameron",
          "Michael Bay",
          "Christopher Nolan",
          "Steven Spielberg"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'The Simpsons,' what is the name of the nuclear power plant where Homer Simpson works?",
          "Springfield Nuclear Power Plant",
          "Shelbyville Nuclear Power Plant",
          "Evergreen Nuclear Power Plant",
          "Burns Power Station",
          "Springfield Nuclear Power Plant"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which actor played the character Jack Sparrow in the 'Pirates of the Caribbean' film series?",
          "Orlando Bloom",
          "Johnny Depp",
          "Geoffrey Rush",
          "Javier Bardem",
          "Johnny Depp"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What is the name of the fictional African country featured in the film 'Black Panther'?",
          "Wakanda",
          "Zamunda",
          "Genovia",
          "Elbonia",
          "Wakanda"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of Eleven's best friend?",
          "Lucas Sinclair",
          "Mike Wheeler",
          "Dustin Henderson",
          "Max Mayfield",
          "Mike Wheeler"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character James Bond in the film 'Skyfall'?",
          "Pierce Brosnan",
          "Daniel Craig",
          "Sean Connery",
          "Roger Moore",
          "Daniel Craig"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Tyler Durden?",
          "Fight Club",
          "American Psycho",
          "The Big Lebowski",
          "Pulp Fiction",
          "Fight Club"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the animated film 'Finding Nemo,' what is the name of Marlin's forgetful friend?",
          "Dory",
          "Nemo",
          "Squirt",
          "Crush",
          "Dory"
      )
  )


  questionsList.add(
      QuestionsModel(
          "In the TV series 'Breaking Bad,' what is the alias used by Walter White in the drug trade?",
          "Heisenberg",
          "El Chapo",
          "Scarface",
          "The Chemist",
          "Heisenberg"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Tony Stark?",
          "Spider-Man: Homecoming",
          "The Dark Knight",
          "Iron Man",
          "Captain America: The Winter Soldier",
          "Iron Man"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character Maximus Decimus Meridius in the film 'Gladiator'?",
          "Russell Crowe",
          "Joaquin Phoenix",
          "Mel Gibson",
          "Christian Bale",
          "Russell Crowe"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the animated film 'Toy Story,' what is the name of Woody's owner?",
          "Andy",
          "Tommy",
          "Billy",
          "Jessie",
          "Andy"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who directed the film 'The Silence of the Lambs'?",
          "Steven Spielberg",
          "Quentin Tarantino",
          "Martin Scorsese",
          "Jonathan Demme",
          "Jonathan Demme"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'The Office' (US), what is the name of Jim and Pam's first child?",
          "Michael",
          "Cece",
          "David",
          "Andy",
          "Cece"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Neo and a simulated reality known as the Matrix?",
          "The Terminator",
          "Blade Runner",
          "The Matrix",
          "Inception",
          "The Matrix"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Friends,' what is the profession of Chandler Bing?",
          "Doctor",
          "Actor",
          "Chef",
          "Advertising Executive",
          "Advertising Executive"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character Jack Dawson in the film 'Titanic'?",
          "Brad Pitt",
          "Leonardo DiCaprio",
          "Tom Hanks",
          "Johnny Depp",
          "Leonardo DiCaprio"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film won the Academy Award for Best Animated Feature in 2018?",
          "Coco",
          "Zootopia",
          "Toy Story 4",
          "Spider-Man: Into the Spider-Verse",
          "Spider-Man: Into the Spider-Verse"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of the creature from the Upside Down that terrorizes Hawkins?",
          "Demogorgon",
          "Mind Flayer",
          "Demodogs",
          "Shadow Monster",
          "Demogorgon"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who directed the film 'Jurassic Park'?",
          "Steven Spielberg",
          "James Cameron",
          "Michael Bay",
          "Christopher Nolan",
          "Steven Spielberg"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'The Simpsons,' what is the name of the nuclear power plant where Homer Simpson works?",
          "Springfield Nuclear Power Plant",
          "Shelbyville Nuclear Power Plant",
          "Evergreen Nuclear Power Plant",
          "Burns Power Station",
          "Springfield Nuclear Power Plant"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which actor played the character Jack Sparrow in the 'Pirates of the Caribbean' film series?",
          "Orlando Bloom",
          "Johnny Depp",
          "Geoffrey Rush",
          "Javier Bardem",
          "Johnny Depp"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What is the name of the fictional African country featured in the film 'Black Panther'?",
          "Wakanda",
          "Zamunda",
          "Genovia",
          "Elbonia",
          "Wakanda"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of Eleven's best friend?",
          "Lucas Sinclair",
          "Mike Wheeler",
          "Dustin Henderson",
          "Max Mayfield",
          "Mike Wheeler"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character James Bond in the film 'Skyfall'?",
          "Pierce Brosnan",
          "Daniel Craig",
          "Sean Connery",
          "Roger Moore",
          "Daniel Craig"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Tyler Durden?",
          "Fight Club",
          "American Psycho",
          "The Big Lebowski",
          "Pulp Fiction",
          "Fight Club"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the animated film 'Finding Nemo,' what is the name of Marlin's forgetful friend?",
          "Dory",
          "Nemo",
          "Squirt",
          "Crush",
          "Dory"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of Eleven's supernatural ability?",
          "Telekinesis",
          "Telepathy",
          "Time Travel",
          "Invisibility",
          "Telekinesis"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character Lara Croft in the film 'Lara Croft: Tomb Raider' (2001)?",
          "Angelina Jolie",
          "Jennifer Lawrence",
          "Scarlett Johansson",
          "Charlize Theron",
          "Angelina Jolie"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film won the Academy Award for Best Picture in 1994?",
          "Forrest Gump",
          "Pulp Fiction",
          "The Shawshank Redemption",
          "Titanic",
          "Forrest Gump"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Breaking Bad,' what is the street name of the high-quality blue crystal meth produced by Walter White and Jesse Pinkman?",
          "Blue Ice",
          "Crystal Bliss",
          "Blue Sky",
          "Ice Queen",
          "Blue Sky"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who directed the film 'The Grand Budapest Hotel'?",
          "Christopher Nolan",
          "Wes Anderson",
          "Quentin Tarantino",
          "Coen Brothers",
          "Wes Anderson"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which actor played the character Jack in the film 'Titanic'?",
          "Brad Pitt",
          "Leonardo DiCaprio",
          "Tom Hanks",
          "Johnny Depp",
          "Leonardo DiCaprio"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the animated film 'Frozen,' what is the name of Elsa's magical snowman companion?",
          "Olaf",
          "Sven",
          "Kristoff",
          "Hans",
          "Olaf"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What does XML stand for in Android development?",
          "Extensible Markup Language",
          "Extra Modern Language",
          "Extended Mobile Language",
          "Extreme Makeup Language",
          "Extensible Markup Language"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Jules Winnfield and his famous 'Ezekiel 25:17' speech?",
          "Pulp Fiction",
          "The Shawshank Redemption",
          "Fight Club",
          "The Big Lebowski",
          "Pulp Fiction"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character Jack Sparrow in the 'Pirates of the Caribbean' film series?",
          "Orlando Bloom",
          "Johnny Depp",
          "Geoffrey Rush",
          "Javier Bardem",
          "Johnny Depp"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Friends,' what is the name of Ross Geller's second wife?",
          "Rachel Green",
          "Emily Waltham",
          "Janice Litman",
          "Carol Willick",
          "Emily Waltham"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named John Wick, portrayed by Keanu Reeves?",
          "The Matrix",
          "Speed",
          "Point Break",
          "John Wick",
          "John Wick"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who directed the film 'Forrest Gump'?",
          "Steven Spielberg",
          "Robert Zemeckis",
          "James Cameron",
          "Martin Scorsese",
          "Robert Zemeckis"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of Eleven's best friend?",
          "Lucas Sinclair",
          "Mike Wheeler",
          "Dustin Henderson",
          "Max Mayfield",
          "Mike Wheeler"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What is the name of the fictional African country featured in the film 'Black Panther'?",
          "Wakanda",
          "Zamunda",
          "Genovia",
          "Elbonia",
          "Wakanda"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which actor played the character James Bond in the film 'Skyfall'?",
          "Pierce Brosnan",
          "Daniel Craig",
          "Sean Connery",
          "Roger Moore",
          "Daniel Craig"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'The Simpsons,' what is the name of the nuclear power plant where Homer Simpson works?",
          "Springfield Nuclear Power Plant",
          "Shelbyville Nuclear Power Plant",
          "Evergreen Nuclear Power Plant",
          "Burns Power Station",
          "Springfield Nuclear Power Plant"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film won the Academy Award for Best Animated Feature in 2016?",
          "Zootopia",
          "Moana",
          "Kubo and the Two Strings",
          "Finding Dory",
          "Zootopia"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character James \"Logan\" Howlett in the X-Men film series?",
          "Chris Evans",
          "Ryan Reynolds",
          "Hugh Jackman",
          "Michael Fassbender",
          "Hugh Jackman"
      )
  )


  questionsList.add(
      QuestionsModel(
          "In the TV series 'Game of Thrones,' what is the name of Jon Snow's direwolf?",
          "Shadow",
          "Fang",
          "Ghost",
          "Blaze",
          "Ghost"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which actor portrayed the character Tony Stark/Iron Man in the Marvel Cinematic Universe?",
          "Chris Hemsworth",
          "Robert Downey Jr.",
          "Chris Evans",
          "Mark Ruffalo",
          "Robert Downey Jr."
      )
  )

  questionsList.add(
      QuestionsModel(
          "What is the name of Harry Potter's owl?",
          "Hedwig",
          "Crookshanks",
          "Fawkes",
          "Scabbers",
          "Hedwig"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the movie 'The Shawshank Redemption,' what is the name of Andy Dufresne's favorite Rita Hayworth film?",
          "Gilda",
          "Casablanca",
          "Double Indemnity",
          "Sunset Boulevard",
          "Gilda"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who played the character Katniss Everdeen in 'The Hunger Games' film series?",
          "Emma Watson",
          "Jennifer Lawrence",
          "Shailene Woodley",
          "Emma Stone",
          "Jennifer Lawrence"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'The Big Bang Theory,' what is Sheldon Cooper's catchphrase?",
          "Bazinga!",
          "Genius!",
          "Excelsior!",
          "Eureka!",
          "Bazinga!"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which film features a character named Maximus Decimus Meridius?",
          "Braveheart",
          "Gladiator",
          "Troy",
          "300",
          "Gladiator"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the movie 'Inception,' what is the term for the shared dream space where people can create and shape their dreams?",
          "The Nexus",
          "The Matrix",
          "The Dreamworld",
          "The Subconscious",
          "The Dreamworld"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who directed the film 'The Dark Knight'?",
          "Christopher Nolan",
          "Tim Burton",
          "Zack Snyder",
          "Joss Whedon",
          "Christopher Nolan"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In the TV series 'Stranger Things,' what is the name of the parallel dimension that is a dark mirror of the real world?",
          "The Netherworld",
          "The Shadow Realm",
          "The Underworld",
          "The Upside Down",
          "The Upside Down"
      )
  )


  questionsList.add(
      QuestionsModel(
          "Who was the first President of the United States?",
          "John Adams",
          "Thomas Jefferson",
          "George Washington",
          "James Madison",
          "George Washington"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In which year did Christopher Columbus first reach the Americas?",
          "1492",
          "1501",
          "1607",
          "1776",
          "1492"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What ancient civilization built the pyramids of Giza?",
          "Greek",
          "Roman",
          "Egyptian",
          "Babylonian",
          "Egyptian"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the famous nurse during the Crimean War and is considered the founder of modern nursing?",
          "Florence Nightingale",
          "Clara Barton",
          "Mary Seacole",
          "Dorothea Dix",
          "Florence Nightingale"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During which war did the Battle of Gettysburg take place?",
          "American Revolution",
          "Civil War",
          "World War I",
          "World War II",
          "Civil War"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What event marked the beginning of World War I?",
          "Assassination of Archduke Franz Ferdinand",
          "Attack on Pearl Harbor",
          "Signing of the Treaty of Versailles",
          "Battle of Stalingrad",
          "Assassination of Archduke Franz Ferdinand"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the leader of the Soviet Union during World War II?",
          "Joseph Stalin",
          "Vladimir Lenin",
          "Mikhail Gorbachev",
          "Nikita Khrushchev",
          "Joseph Stalin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "What document declared the American colonies' independence from Great Britain?",
          "Magna Carta",
          "Emancipation Proclamation",
          "Declaration of Independence",
          "Constitution",
          "Declaration of Independence"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the primary author of the Declaration of Independence?",
          "John Adams",
          "Thomas Jefferson",
          "Benjamin Franklin",
          "James Madison",
          "Thomas Jefferson"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which ancient civilization is known for its impressive city-state of Athens and the development of democracy?",
          "Roman Empire",
          "Persian Empire",
          "Greek Civilization",
          "Egyptian Empire",
          "Greek Civilization"
      )
  )


  questionsList.add(
      QuestionsModel(
          "What was the main cause of the Black Death in Europe during the 14th century?",
          "Famine",
          "War",
          "Bubonic Plague",
          "Influenza",
          "Bubonic Plague"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the first woman to win a Nobel Prize and remains the only person to win Nobel Prizes in two different scientific fields?",
          "Marie Curie",
          "Rosalind Franklin",
          "Dorothy Crowfoot Hodgkin",
          "Barbara McClintock",
          "Marie Curie"
      )
  )
        questionsList.shuffle()

    }
    fun entertainmentStageFive(){
        questionsList.clear()

        questionsList.add(
        QuestionsModel(
            "Which actor played the lead role in the movie 'Inception'?",
            "Leonardo DiCaprio",
            "Tom Hardy",
            "Joseph Gordon-Levitt",
            "Christian Bale",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV show 'Friends,' what is the name of Ross and Monica's dog when they were kids?",
            "Buddy",
            "Rover",
            "Fido",
            "Chi-Chi",
            "Chi-Chi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who won the Academy Award for Best Actor for their role in the movie 'The Revenant'?",
            "Matthew McConaughey",
            "Joaquin Phoenix",
            "Eddie Redmayne",
            "Leonardo DiCaprio",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Simba?",
            "Toy Story",
            "Finding Nemo",
            "The Lion King",
            "Shrek",
            "The Lion King"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the Harry Potter series, who is known as the 'Half-Blood Prince'?",
            "Draco Malfoy",
            "Severus Snape",
            "Tom Riddle",
            "Harry Potter",
            "Severus Snape"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional continent where most of the events of 'Game of Thrones' take place?",
            "Westeros",
            "Essos",
            "Sosaria",
            "Middle-earth",
            "Westeros"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the 1994 film 'Pulp Fiction'?",
            "Christopher Nolan",
            "Quentin Tarantino",
            "Martin Scorsese",
            "Steven Spielberg",
            "Quentin Tarantino"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actress starred as Katniss Everdeen in 'The Hunger Games' film series?",
            "Jennifer Aniston",
            "Emma Stone",
            "Anne Hathaway",
            "Jennifer Lawrence",
            "Jennifer Lawrence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'The Matrix,' what is the real name of the character played by Keanu Reeves?",
            "Neo",
            "Trinity",
            "Morpheus",
            "Agent Smith",
            "Neo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2017 horror film features a shape-shifting entity that often takes the form of a clown?",
            "Annabelle: Creation",
            "The Nun",
            "Get Out",
            "It",
            "It"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV show 'Breaking Bad,' what is the street name of Walter White's alter ego?",
            "Heisenberg",
            "The Cook",
            "Mr. Blue",
            "El Loco",
            "Heisenberg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character Jack Dawson in the film 'Titanic'?",
            "Matthew McConaughey",
            "Tom Cruise",
            "Johnny Depp",
            "Leonardo DiCaprio",
            "Leonardo DiCaprio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the magical land in C.S. Lewis's 'The Chronicles of Narnia' series?",
            "Neverland",
            "Middle-earth",
            "Narnia",
            "Hogwarts",
            "Narnia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Picture in 2018?",
            "La La Land",
            "Moonlight",
            "The Shape of Water",
            "Green Book",
            "The Shape of Water"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Stranger Things,' what is Eleven's real name?",
            "Elle",
            "Emma",
            "Eva",
            "Jane",
            "Jane"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the 1999 science fiction film 'The Matrix'?",
            "Steven Spielberg",
            "Christopher Nolan",
            "James Cameron",
            "The Wachowskis",
            "The Wachowskis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which character says the famous line 'May the Force be with you' in the Star Wars franchise?",
            "Han Solo",
            "Obi-Wan Kenobi",
            "Darth Vader",
            "Princess Leia",
            "Obi-Wan Kenobi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the role of Tony Stark/Iron Man in the Marvel Cinematic Universe?",
            "Chris Evans",
            "Chris Hemsworth",
            "Robert Downey Jr.",
            "Mark Ruffalo",
            "Robert Downey Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional African country in the Marvel film 'Black Panther'?",
            "Wakanda",
            "Zamunda",
            "Genovia",
            "Elbonia",
            "Wakanda"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 1994 animated film features the voices of Tom Hanks and Tim Allen?",
            "Toy Story",
            "The Lion King",
            "Aladdin",
            "Beauty and the Beast",
            "Toy Story"
        )
    )


    questionsList.add(
        QuestionsModel(
            "In which year did the Titanic sink after hitting an iceberg?",
            "1905",
            "1912",
            "1923",
            "1931",
            "1912"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first emperor of China and is best known for the Terracotta Army?",
            "Confucius",
            "Mao Zedong",
            "Sun Yat-sen",
            "Qin Shi Huang",
            "Qin Shi Huang"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What historical event marked the end of the medieval period and the beginning of the Renaissance in Europe?",
            "Fall of Rome",
            "Great Schism",
            "Black Death",
            "Fall of Constantinople",
            "Fall of Constantinople"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the civil rights movement in the United States and is best known for his role in the advancement of civil rights using nonviolent civil disobedience?",
            "Malcolm X",
            "Jesse Jackson",
            "Rosa Parks",
            "Martin Luther King Jr.",
            "Martin Luther King Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "What event marked the beginning of the Great Depression in the United States?",
            "Stock Market Crash of 1929",
            "Dust Bowl",
            "Prohibition",
            "World War I",
            "Stock Market Crash of 1929"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first woman to fly solo across the Atlantic Ocean?",
            "Bessie Coleman",
            "Amelia Earhart",
            "Katherine Johnson",
            "Jacqueline Cochran",
            "Amelia Earhart"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What famous speech did Abraham Lincoln deliver during the American Civil War?",
            "Gettysburg Address",
            "I Have a Dream",
            "Emancipation Proclamation",
            "Four Score and Seven Years Ago",
            "Gettysburg Address"
        )
    )


    questionsList.add(
        QuestionsModel(
            "In the film 'Forrest Gump,' what does Forrest say life is like?",
            "A box of chocolates",
            "A puzzle",
            "A rollercoaster",
            "A journey",
            "A box of chocolates"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character of Jules Winnfield in the movie 'Pulp Fiction'?",
            "Samuel L. Jackson",
            "John Travolta",
            "Bruce Willis",
            "Uma Thurman",
            "Samuel L. Jackson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named 'Hannibal Lecter'?",
            "The Silence of the Lambs",
            "Seven",
            "American Psycho",
            "The Shining",
            "The Silence of the Lambs"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the dragon in the animated film 'Mulan'?",
            "Mushu",
            "Puff",
            "Smaug",
            "Toothless",
            "Mushu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the role of the Joker in the film 'The Dark Knight'?",
            "Heath Ledger",
            "Jack Nicholson",
            "Joaquin Phoenix",
            "Cesar Romero",
            "Heath Ledger"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Office,' who is the regional manager of Dunder Mifflin's Scranton branch?",
            "Jim Halpert",
            "Dwight Schrute",
            "Michael Scott",
            "Pam Beesly",
            "Michael Scott"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which movie features the characters Maverick and Goose?",
            "Top Gun",
            "Platoon",
            "Apocalypse Now",
            "The Deer Hunter",
            "Top Gun"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Finding Nemo,' what type of fish is Nemo?",
            "Clownfish",
            "Angelfish",
            "Pufferfish",
            "Dolphinfish",
            "Clownfish"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who won the Academy Award for Best Actress for her role in 'Black Swan'?",
            "Natalie Portman",
            "Meryl Streep",
            "Cate Blanchett",
            "Jennifer Lawrence",
            "Natalie Portman"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor played the role of Captain Jack Sparrow in the 'Pirates of the Caribbean' film series?",
            "Orlando Bloom",
            "Johnny Depp",
            "Geoffrey Rush",
            "Javier Bardem",
            "Johnny Depp"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the film 'The Shawshank Redemption,' what is the name of the main character?",
            "Andy Dufresne",
            "Red",
            "Ellis Boyd 'Red' Redding",
            "Warden Norton",
            "Andy Dufresne"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor played the role of Tony Montana in the film 'Scarface'?",
            "Al Pacino",
            "Robert De Niro",
            "Joe Pesci",
            "Marlon Brando",
            "Al Pacino"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional city in which the Batman comics are set?",
            "Metropolis",
            "Gotham City",
            "Central City",
            "Star City",
            "Gotham City"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Jurassic Park'?",
            "George Lucas",
            "Steven Spielberg",
            "James Cameron",
            "Christopher Nolan",
            "Steven Spielberg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actress starred as Elle Woods in the film 'Legally Blonde'?",
            "Reese Witherspoon",
            "Cameron Diaz",
            "Julia Roberts",
            "Anne Hathaway",
            "Reese Witherspoon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the magical school in the Harry Potter series?",
            "Beauxbatons Academy of Magic",
            "Durmstrang Institute",
            "Hogwarts School of Witchcraft and Wizardry",
            "Ilvermorny School of Witchcraft and Wizardry",
            "Hogwarts School of Witchcraft and Wizardry"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film features a character named Vito Corleone?",
            "The Godfather",
            "Goodfellas",
            "Scarface",
            "Casino",
            "The Godfather"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV show 'Stranger Things,' what is the name of the parallel dimension?",
            "The Underworld",
            "The Beyond",
            "The Nether",
            "The Upside Down",
            "The Upside Down"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the role of Maximus in the film 'Gladiator'?",
            "Russell Crowe",
            "Joaquin Phoenix",
            "Heath Ledger",
            "Mel Gibson",
            "Russell Crowe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the film 'Inglourious Basterds'?",
            "Quentin Tarantino",
            "Christopher Nolan",
            "Martin Scorsese",
            "David Fincher",
            "Quentin Tarantino"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Friends,' which character is a paleontologist?",
            "Chandler Bing",
            "Ross Geller",
            "Joey Tribbiani",
            "Monica Geller",
            "Ross Geller"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor starred as Edward Scissorhands in the 1990 film of the same name?",
            "Johnny Depp",
            "Leonardo DiCaprio",
            "Tom Cruise",
            "Brad Pitt",
            "Johnny Depp"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the protagonist in the 'James Bond' film series?",
            "John Wick",
            "Jason Bourne",
            "Ethan Hunt",
            "James Bond",
            "James Bond"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'The Wizard of Oz,' what is the color of Dorothy's magical shoes?",
            "Silver",
            "Red",
            "Gold",
            "Blue",
            "Ruby Red"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the role of Katniss Everdeen's mentor, Haymitch Abernathy, in 'The Hunger Games'?",
            "Woody Harrelson",
            "Donald Sutherland",
            "Philip Seymour Hoffman",
            "Jeffrey Wright",
            "Woody Harrelson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which actor portrayed the character Tony Stark's father, Howard Stark, in the Marvel Cinematic Universe?",
            "John Slattery",
            "Robert Downey Jr.",
            "Jeff Bridges",
            "Samuel L. Jackson",
            "John Slattery"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Shrek,' who voices the character Shrek?",
            "Mike Myers",
            "Eddie Murphy",
            "Cameron Diaz",
            "Antonio Banderas",
            "Mike Myers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 1980s film features a high school student named Ferris Bueller skipping school?",
            "Pretty in Pink",
            "The Breakfast Club",
            "Ferris Bueller's Day Off",
            "Sixteen Candles",
            "Ferris Bueller's Day Off"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the role of Hermione Granger in the 'Harry Potter' film series?",
            "Emma Watson",
            "Emma Stone",
            "Emma Roberts",
            "Emma Thompson",
            "Emma Watson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the film 'The Dark Knight Rises,' who plays the character Selina Kyle?",
            "Anne Hathaway",
            "Scarlett Johansson",
            "Michelle Pfeiffer",
            "Halle Berry",
            "Anne Hathaway"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the alien in the film 'E.T. the Extra-Terrestrial'?",
            "Zog",
            "Eloise",
            "E.T.",
            "Xeno",
            "E.T."
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the science fiction film 'Blade Runner'?",
            "Ridley Scott",
            "George Lucas",
            "James Cameron",
            "Steven Spielberg",
            "Ridley Scott"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Breaking Bad,' what is the street name of the blue crystal meth?",
            "Blue Magic",
            "Blue Sky",
            "Blue Dream",
            "Blue Velvet",
            "Blue Sky"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a robot named WALL-E?",
            "Finding Nemo",
            "Toy Story",
            "Up",
            "WALL-E",
            "WALL-E"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the lead role of Maximus in the film 'Gladiator'?",
            "Joaquin Phoenix",
            "Russell Crowe",
            "Gerard Butler",
            "Heath Ledger",
            "Russell Crowe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the film 'The Shawshank Redemption,' what is the profession of Andy Dufresne before he was imprisoned?",
            "Lawyer",
            "Banker",
            "Architect",
            "Accountant",
            "Banker"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2008 film features a character named Harvey Dent?",
            "The Dark Knight",
            "Iron Man",
            "The Incredible Hulk",
            "Spider-Man 3",
            "The Dark Knight"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Dory in the animated film 'Finding Nemo'?",
            "Ellen DeGeneres",
            "Amy Poehler",
            "Tina Fey",
            "Kristen Wiig",
            "Ellen DeGeneres"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Stranger Things,' what is the name of the mysterious girl with psychokinetic abilities?",
            "Eleven",
            "Seven",
            "Nine",
            "Twelve",
            "Eleven"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who directed the 1995 animated film 'Toy Story'?",
            "John Lasseter",
            "Andrew Stanton",
            "Brad Bird",
            "Pete Docter",
            "John Lasseter"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which film won the Academy Award for Best Picture in 2019?",
            "Parasite",
            "Joker",
            "1917",
            "Once Upon a Time in Hollywood",
            "Parasite"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Simpsons,' what is the name of Homer Simpson's neighbor?",
            "Ned Flanders",
            "Moe Szyslak",
            "Barney Gumble",
            "Apu Nahasapeemapetilon",
            "Ned Flanders"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who played the character of Aragorn in 'The Lord of the Rings' film trilogy?",
            "Orlando Bloom",
            "Viggo Mortensen",
            "Sean Bean",
            "Ian McKellen",
            "Viggo Mortensen"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional African country in the Marvel film 'Black Panther'?",
            "Wakanda",
            "Zamunda",
            "Genovia",
            "Elbonia",
            "Wakanda"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Finding Nemo,' what type of fish is Marlin?",
            "Clownfish",
            "Angelfish",
            "Pufferfish",
            "Dolphinfish",
            "Clownfish"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Shrek in the 'Shrek' film series?",
            "Mike Myers",
            "Eddie Murphy",
            "Cameron Diaz",
            "Antonio Banderas",
            "Mike Myers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2003 animated film features a clownfish searching for his son in the ocean?",
            "Finding Nemo",
            "The Little Mermaid",
            "Shark Tale",
            "Up",
            "Finding Nemo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the director of the animated film 'The Incredibles'?",
            "Brad Bird",
            "John Lasseter",
            "Andrew Stanton",
            "Pete Docter",
            "Brad Bird"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of Simba's father in the animated film 'The Lion King'?",
            "Mufasa",
            "Scar",
            "Rafiki",
            "Zazu",
            "Mufasa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Zootopia,' what type of animal is the character Judy Hopps?",
            "Lion",
            "Rabbit",
            "Elephant",
            "Fox",
            "Rabbit"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the 2004 animated film 'The Polar Express'?",
            "Tim Burton",
            "Chris Columbus",
            "Steven Spielberg",
            "Peter Jackson",
            "Robert Zemeckis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2016 animated film features a young girl named Moana setting sail on a daring mission?",
            "Frozen",
            "Tangled",
            "Moana",
            "Brave",
            "Moana"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Toy Story,' what type of toy is Woody?",
            "Space Ranger",
            "Cowboy",
            "Dinosaur",
            "Action Figure",
            "Cowboy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Elsa in the animated film 'Frozen'?",
            "Kristen Bell",
            "Idina Menzel",
            "Emma Stone",
            "Demi Lovato",
            "Idina Menzel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the dragon in the animated film 'Mulan'?",
            "Mushu",
            "Puff",
            "Smaug",
            "Toothless",
            "Mushu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2012 animated film features a video game villain named Wreck-It Ralph?",
            "Toy Story 3",
            "Brave",
            "Zootopia",
            "Wreck-It Ralph",
            "Wreck-It Ralph"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'Ratatouille'?",
            "Brad Bird",
            "Andrew Stanton",
            "John Lasseter",
            "Pete Docter",
            "Brad Bird"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Simpsons,' what is the name of the family's pet dog?",
            "Spike",
            "Max",
            "Santa's Little Helper",
            "Buddy",
            "Santa's Little Helper"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2015 animated film revolves around emotions like Joy, Sadness, and Anger?",
            "Inside Out",
            "Coco",
            "Big Hero 6",
            "Zootopia",
            "Inside Out"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Shrek,' what type of creature is Donkey?",
            "Horse",
            "Dragon",
            "Ogre",
            "Mule",
            "Donkey"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'How to Train Your Dragon'?",
            "Chris Sanders",
            "Chris Buck",
            "Dean DeBlois",
            "Jennifer Lee",
            "Dean DeBlois"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the magical land in C.S. Lewis's 'The Chronicles of Narnia' series?",
            "Neverland",
            "Middle-earth",
            "Narnia",
            "Hogwarts",
            "Narnia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Aladdin,' who provides the voice for the Genie?",
            "Eddie Murphy",
            "Will Smith",
            "Robin Williams",
            "Jim Carrey",
            "Robin Williams"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2010 animated film features a character named Hiccup and his dragon, Toothless?",
            "Brave",
            "How to Train Your Dragon",
            "Tangled",
            "Kung Fu Panda",
            "How to Train Your Dragon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'The Little Mermaid,' what is the name of Ariel's crab friend?",
            "Flounder",
            "Sebastian",
            "Scuttle",
            "Ursula",
            "Sebastian"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character Buzz Lightyear in the 'Toy Story' film series?",
            "Tom Hanks",
            "Tim Allen",
            "Don Rickles",
            "Wallace Shawn",
            "Tim Allen"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Ratatouille,' what type of animal is Remy?",
            "Mouse",
            "Rat",
            "Hamster",
            "Ferret",
            "Rat"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 1998 animated film tells the story of a young Chinese woman who disguises herself as a man to take her father's place in the army?",
            "Pocahontas",
            "Mulan",
            "Tarzan",
            "The Hunchback of Notre Dame",
            "Mulan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'Frozen'?",
            "Chris Buck",
            "Jennifer Lee",
            "Peter Docter",
            "Rich Moore",
            "Chris Buck"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'SpongeBob SquarePants,' where does SpongeBob work?",
            "Krusty Krab",
            "Chum Bucket",
            "Jellyfish Fields",
            "Goo Lagoon",
            "Krusty Krab"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageSix(){
        questionsList.clear()

        questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Jack Skellington who discovers Christmas Town?",
            "Corpse Bride",
            "Frankenweenie",
            "The Nightmare Before Christmas",
            "Coraline",
            "The Nightmare Before Christmas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voices the character of Dug, the talking dog, in the animated film 'Up'?",
            "Edward Asner",
            "John Ratzenberger",
            "Bob Peterson",
            "Russell Brand",
            "Bob Peterson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the superhero family in the animated film 'The Incredibles'?",
            "The Invincibles",
            "The Unbeatables",
            "The Indomitables",
            "The Incredibles",
            "The Incredibles"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Shrek 2,' who is the Fairy Godmother's son?",
            "Prince Charming",
            "King Harold",
            "Puss in Boots",
            "Gingy",
            "Prince Charming"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named WALL-E?",
            "Finding Nemo",
            "Toy Story",
            "Up",
            "WALL-E",
            "WALL-E"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Megara in the animated film 'Hercules'?",
            "Jodi Benson",
            "Ming-Na Wen",
            "Susan Egan",
            "Idina Menzel",
            "Susan Egan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Rick and Morty,' what is the name of Rick's grandson?",
            "Morty",
            "Jerry",
            "Summer",
            "Beth",
            "Morty"
        )
    )

   questionsList.add(
       QuestionsModel(
           "Which 2005 animated film centers around a young robot searching for his true identity?",
           "WALL-E",
           "Cars",
           "The Incredibles",
           "Robots",
           "Robots"
       )
   )

   questionsList.add(
       QuestionsModel(
           "Who directed the animated film 'Shrek'?",
           "Andrew Adamson",
           "Chris Miller",
           "Mike Myers",
           "Chris Sanders",
           "Andrew Adamson"
       )
   )

   questionsList.add(
       QuestionsModel(
           "In the animated film 'Moana,' what is the name of the demigod who accompanies Moana on her journey?",
           "Maui",
           "Te Fiti",
           "Tamatoa",
           "Heihei",
           "Maui"
       )
   )

   questionsList.add(
       QuestionsModel(
           "Which 2012 animated film features a brave Scottish princess named Merida?",
           "Frozen",
           "Tangled",
           "Brave",
           "Coco",
           "Brave"
       )
   )

   questionsList.add(
    QuestionsModel(
           "Who directed the animated film 'Kung Fu Panda'?",
           "Andrew Stanton",
           "Peter Docter",
           "Chris Sanders",
           "Mark Osborne",
           "Mark Osborne"
       )
   )

   questionsList.add(
       QuestionsModel(
           "In the TV series 'Avatar: The Last Airbender,' what is the name of the main character who can bend all four elements?",
           "Sokka",
           "Katara",
           "Zuko",
           "Aang",
           "Aang"
       )
   )

   questionsList.add(
       QuestionsModel(
           "Which animated film features a character named Remy, a rat who aspires to be a chef?",
           "Ratatouille",
           "Cars",
           "The Incredibles",
           "Finding Nemo",
           "Ratatouille"
       )
   )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Beauty and the Beast,' what is the name of Belle's father?",
            "Maurice",
            "Gaston",
            "Lumière",
            "Chip",
            "Maurice"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Hiccup in the animated film 'How to Train Your Dragon'?",
            "Jay Baruchel",
            "Gerard Butler",
            "Craig Ferguson",
            "Kit Harington",
            "Jay Baruchel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Scooby-Doo, Where Are You!', what is Shaggy's real name?",
            "Norville Rogers",
            "Shane Roberts",
            "Sylvester Robinson",
            "Nigel Reynolds",
            "Norville Rogers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2001 animated film features a green ogre and a talkative donkey?",
            "Shrek",
            "Monsters, Inc.",
            "Ice Age",
            "Finding Nemo",
            "Shrek"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'Coco'?",
            "Lee Unkrich",
            "Brad Bird",
            "Andrew Stanton",
            "Peter Docter",
            "Lee Unkrich"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'The Jungle Book,' what type of animal is Baloo?",
            "Bear",
            "Tiger",
            "Elephant",
            "Panther",
            "Bear"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Toothless, a Night Fury dragon?",
            "How to Train Your Dragon",
            "Brave",
            "Frozen",
            "Moana",
            "How to Train Your Dragon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Nemo's father, Marlin, in the film 'Finding Nemo'?",
            "Albert Brooks",
            "Tom Hanks",
            "Robin Williams",
            "Billy Crystal",
            "Albert Brooks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Flintstones,' what is the name of Fred Flintstone's best friend?",
            "Barney Rubble",
            "Barney Rubinson",
            "Barney Rubblestone",
            "Barney Rockwell",
            "Barney Rubble"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film tells the story of a rat named Remy who dreams of becoming a chef?",
            "Ratatouille",
            "Finding Nemo",
            "Cars",
            "The Incredibles",
            "Ratatouille"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the 2016 animated film 'Zootopia'?",
            "Chris Buck",
            "Rich Moore",
            "Byron Howard",
            "Jennifer Lee",
            "Byron Howard"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Family Guy,' what is the name of the Griffins' talking dog?",
            "Brian",
            "Stewie",
            "Peter",
            "Chris",
            "Brian"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Buzz Lightyear?",
            "Toy Story",
            "Cars",
            "The Incredibles",
            "Finding Nemo",
            "Toy Story"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Genie in the animated film 'Aladdin'?",
            "Will Smith",
            "Robin Williams",
            "Jim Carrey",
            "Eddie Murphy",
            "Robin Williams"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Up,' what type of bird does Carl Fredricksen befriend?",
            "Parrot",
            "Eagle",
            "Hummingbird",
            "Kevin",
            "Kevin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Flik, an ant who wants to be a warrior?",
            "A Bug's Life",
            "Antz",
            "Bee Movie",
            "Happy Feet",
            "A Bug's Life"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Simpsons,' what is the name of Homer's wife?",
            "Marge",
            "Lisa",
            "Maggie",
            "Patty",
            "Marge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Sully in the animated film 'Monsters, Inc.'?",
            "Billy Crystal",
            "John Goodman",
            "Steve Buscemi",
            "Tom Hanks",
            "John Goodman"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the talking fish in the animated film 'Finding Nemo'?",
            "Marlin",
            "Dory",
            "Bruce",
            "Crush",
            "Dory"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Toy Story,' what is the name of the cowboy doll that belongs to Andy?",
            "Buzz Lightyear",
            "Slinky Dog",
            "Rex",
            "Woody",
            "Woody"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Donkey in the 'Shrek' film series?",
            "Mike Myers",
            "Eddie Murphy",
            "Cameron Diaz",
            "Antonio Banderas",
            "Eddie Murphy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Teen Titans Go!,' what is the name of the cyborg member?",
            "Cyborg",
            "Beast Boy",
            "Raven",
            "Starfire",
            "Cyborg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 1994 animated film tells the story of a young lion cub who becomes king of the Pride Lands?",
            "Aladdin",
            "The Lion King",
            "Beauty and the Beast",
            "Mulan",
            "The Lion King"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'Brave'?",
            "Andrew Stanton",
            "Pete Docter",
            "Chris Sanders",
            "Mark Andrews",
            "Mark Andrews"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Scooby-Doo, Where Are You!,' what is the name of the Great Dane?",
            "Max",
            "Spike",
            "Odie",
            "Scooby-Doo",
            "Scooby-Doo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Remy, a rat with a passion for cooking?",
            "Ratatouille",
            "Finding Nemo",
            "Up",
            "Toy Story",
            "Ratatouille"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Maui in the animated film 'Moana'?",
            "Dwayne Johnson",
            "Auli'i Cravalho",
            "Lin-Manuel Miranda",
            "Jemaine Clement",
            "Dwayne Johnson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Shrek,' who is the main antagonist and ruler of Duloc?",
            "Lord Farquaad",
            "Prince Charming",
            "Fairy Godmother",
            "Captain Hook",
            "Lord Farquaad"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Joy, who represents the emotion of happiness?",
            "Inside Out",
            "Zootopia",
            "Coco",
            "Big Hero 6",
            "Inside Out"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'Finding Nemo'?",
            "Andrew Stanton",
            "Brad Bird",
            "John Lasseter",
            "Lee Unkrich",
            "Andrew Stanton"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Rick and Morty,' what is the name of Rick's grandson?",
            "Morty",
            "Jerry",
            "Summer",
            "Beth",
            "Morty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2004 animated film revolves around a family of superheroes?",
            "Finding Nemo",
            "Cars",
            "Ratatouille",
            "The Incredibles",
            "The Incredibles"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Princess Fiona in the 'Shrek' film series?",
            "Cameron Diaz",
            "Julia Roberts",
            "Angelina Jolie",
            "Reese Witherspoon",
            "Cameron Diaz"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Up,' what is the name of the young boy who befriends Carl Fredricksen?",
            "Russell",
            "Kevin",
            "Dug",
            "Alpha",
            "Russell"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Dory, a regal blue tang fish with short-term memory loss?",
            "Finding Nemo",
            "The Little Mermaid",
            "Shark Tale",
            "Finding Dory",
            "Finding Nemo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Megamind in the animated film 'Megamind'?",
            "Will Ferrell",
            "Brad Pitt",
            "Ben Stiller",
            "Jack Black",
            "Will Ferrell"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Avatar: The Last Airbender,' what is the name of the flying bison that Aang befriends?",
            "Appa",
            "Momo",
            "Naga",
            "Hawky",
            "Appa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a robot named Baymax?",
            "WALL-E",
            "Big Hero 6",
            "The Iron Giant",
            "Astro Boy",
            "Big Hero 6"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the magical land in the 1988 animated film 'My Neighbor Totoro'?",
            "Wonderland",
            "Neverland",
            "Totoroland",
            "Ghibli",
            "Neverland"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Cars,' what is the name of the race car protagonist?",
            "Lightning McQueen",
            "Mater",
            "Cruz Ramirez",
            "Doc Hudson",
            "Lightning McQueen"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the 2010 animated film 'Tangled'?",
            "Chris Buck",
            "Rich Moore",
            "Byron Howard",
            "Jennifer Lee",
            "Byron Howard"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'The Simpsons,' what is the name of Bart Simpson's best friend?",
            "Ralph Wiggum",
            "Milhouse Van Houten",
            "Nelson Muntz",
            "Martin Prince",
            "Milhouse Van Houten"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2009 animated film tells the story of a young wilderness explorer named Carl Fredricksen?",
            "Toy Story 3",
            "Up",
            "WALL-E",
            "Ratatouille",
            "Up"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Rapunzel in the animated film 'Tangled'?",
            "Mandy Moore",
            "Idina Menzel",
            "Kristen Bell",
            "Emma Watson",
            "Mandy Moore"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Teen Titans Go!,' what is the name of the alien princess with a fascination for Earth culture?",
            "Raven",
            "Starfire",
            "Jinx",
            "Terra",
            "Starfire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Carl Fredricksen who ties thousands of balloons to his house and sets out on an adventure?",
            "The Incredibles",
            "Finding Nemo",
            "Toy Story",
            "Up",
            "Up"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'The Princess and the Frog'?",
            "Ron Clements",
            "John Musker",
            "Chris Sanders",
            "Andrew Stanton",
            "Ron Clements"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Madagascar,' what type of animal is Alex?",
            "Zebra",
            "Lion",
            "Giraffe",
            "Hippopotamus",
            "Lion"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a young Viking named Hiccup and his dragon, Toothless?",
            "Brave",
            "How to Train Your Dragon",
            "Tangled",
            "Kung Fu Panda",
            "How to Train Your Dragon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Judy Hopps in the animated film 'Zootopia'?",
            "Ginnifer Goodwin",
            "Jennifer Lawrence",
            "Amy Adams",
            "Emma Stone",
            "Ginnifer Goodwin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the TV series 'Bob's Burgers,' what is the name of Bob's wife?",
            "Linda",
            "Tina",
            "Louise",
            "Gene",
            "Linda"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 1991 animated film tells the story of a young woman who takes her father's place in the army?",
            "Mulan",
            "Pocahontas",
            "The Hunchback of Notre Dame",
            "Beauty and the Beast",
            "Mulan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'Shrek 2'?",
            "Andrew Adamson",
            "Chris Miller",
            "Mike Myers",
            "Chris Sanders",
            "Andrew Adamson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the movie 'Ratatouille,' what is the name of the restaurant where Remy the rat aspires to cook?",
            "Gusteau's",
            "Chez Anton",
            "Le Petit Chef",
            "Bistro Ratatouille",
            "Gusteau's"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a character named Jack Skellington, who discovers Christmas Town?",
            "Corpse Bride",
            "Frankenweenie",
            "The Nightmare Before Christmas",
            "Coraline",
            "The Nightmare Before Christmas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who voiced the character of Manny in the animated film 'Ice Age'?",
            "Ray Romano",
            "Denis Leary",
            "John Leguizamo",
            "Chris Wedge",
            "Ray Romano"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the animated film 'Monsters, Inc.,' what is the name of the little girl who enters the monster world?",
            "Boo",
            "Sally",
            "Celia",
            "Roz",
            "Boo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which 2006 animated film features a group of animals escaping from the Central Park Zoo?",
            "Madagascar",
            "Ice Age: The Meltdown",
            "Over the Hedge",
            "Open Season",
            "Madagascar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who directed the animated film 'Kung Fu Panda'?",
            "Andrew Stanton",
            "Peter Docter",
            "Chris Sanders",
            "Mark Osborne",
            "Mark Osborne"
        )
    )


    questionsList.add(
        QuestionsModel(
            "In which song do the lyrics 'I'm gonna swing from the chandelier, from the chandelier' appear?",
            "Chandelier",
            "Titanium",
            "Elastic Heart",
            "Cheap Thrills",
            "Chandelier"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which artist sings the lyrics 'I'm sorry, Ms. Jackson, I am for real'?",
            "Kanye West",
            "OutKast",
            "Jay-Z",
            "Eminem",
            "OutKast"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics: 'It's a beautiful night, we're looking for something dumb to do, hey baby, I think I wanna marry you' is from the song:",
            "Marry You",
            "Just the Way You Are",
            "Locked Out of Heaven",
            "Treasure",
            "Marry You"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which song do the lyrics 'Don't stop believin', hold on to that feelin'' appear?",
            "Livin' on a Prayer",
            "Sweet Child o' Mine",
            "Don't Stop Believin'",
            "Bohemian Rhapsody",
            "Don't Stop Believin'"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which artist sings the lyrics 'Cause baby now we got bad blood, you know it used to be mad love'?",
            "Taylor Swift",
            "Katy Perry",
            "Adele",
            "Rihanna",
            "Taylor Swift"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics: 'I will always love you' is from the song:",
            "Greatest Love of All",
            "I Wanna Dance with Somebody",
            "I Will Always Love You",
            "How Will I Know",
            "I Will Always Love You"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which song do the lyrics 'I'm a genie in a bottle, you gotta rub me the right way' appear?",
            "Genie in a Bottle",
            "Wannabe",
            "Say My Name",
            "Baby One More Time",
            "Genie in a Bottle"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageSeven(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Which artist sings the lyrics 'Cause you know that baby, I, I'm your biggest fan'?",
            "Ariana Grande",
            "Beyoncé",
            "Lady Gaga",
            "Justin Bieber",
            "Ariana Grande"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics: 'Somebody once told me the world is gonna roll me, I ain't the sharpest tool in the shed' is from the song:",
            "All Star",
            "Smooth",
            "I Want It That Way",
            "Wonderwall",
            "All Star"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which song do the lyrics 'I'm sorry, but I'm not sorry' appear?",
            "Sorry",
            "Irreplaceable",
            "No Scrubs",
            "Sorry Not Sorry",
            "Sorry Not Sorry"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which artist sings the lyrics 'Cause if you liked it, then you shoulda put a ring on it'?",
            "Rihanna",
            "Adele",
            "Beyoncé",
            "Katy Perry",
            "Beyoncé"
        )
    )



    questionsList.add(
        QuestionsModel(
            "Complete the lyrics: 'Now I'm four five seconds from wildin', and we got three more days 'til Friday' is from the song:",
            "Hotline Bling",
            "FourFiveSeconds",
            "Can't Stop the Feeling!",
            "Love Yourself",
            "FourFiveSeconds"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which song do the lyrics 'I can't feel my face when I'm with you, but I love it' appear?",
            "Starboy",
            "Can't Stop the Feeling!",
            "I Can't Feel My Face",
            "Blinding Lights",
            "I Can't Feel My Face"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which artist sings the lyrics 'Cause there'll be no sunlight if I lose you, baby'?",
            "Ed Sheeran",
            "Bruno Mars",
            "Sam Smith",
            "Alicia Keys",
            "Sam Smith"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics: 'And we danced all night to the best song ever, we knew every line, now I can't remember' is from the song:",
            "What Makes You Beautiful",
            "Best Song Ever",
            "Live While We're Young",
            "Story of My Life",
            "Best Song Ever"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which song do the lyrics 'I came in like a wrecking ball, I never hit so hard in love' appear?",
            "Wrecking Ball",
            "Party in the USA",
            "Can't Be Tamed",
            "The Climb",
            "Wrecking Ball"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which artist sings the lyrics 'I will survive, hey, hey'?",
            "Gloria Gaynor",
            "Cher",
            "Aretha Franklin",
            "Diana Ross",
            "Gloria Gaynor"
        )
    )



    questionsList.add(
        QuestionsModel(
            "Complete the lyrics: 'Is it too late now to say sorry?' is from the song:",
            "Sorry",
            "Love Yourself",
            "What Do You Mean?",
            "Where Are Ü Now",
            "Sorry"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which song do the lyrics 'Hello from the other side, I must've called a thousand times' appear?",
            "Someone Like You",
            "Rolling in the Deep",
            "Hello",
            "Set Fire to the Rain",
            "Hello"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which artist sings the lyrics 'I'm on the right track, baby, I was born this way'?",
            "Katy Perry",
            "Lady Gaga",
            "Adele",
            "Beyoncé",
            "Lady Gaga"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who is known as the 'King of Pop'?",
            "Prince",
            "Michael Jackson",
            "Elvis Presley",
            "Bruno Mars",
            "Michael Jackson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Beatles album includes the songs 'Lucy in the Sky with Diamonds' and 'A Day in the Life'?",
            "Abbey Road",
            "The White Album",
            "Sgt. Pepper's Lonely Hearts Club Band",
            "Revolver",
            "Sgt. Pepper's Lonely Hearts Club Band"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which year did Elvis Presley pass away?",
            "1973",
            "1977",
            "1980",
            "1983",
            "1977"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who won the 2020 Grammy Award for Album of the Year with 'When We All Fall Asleep, Where Do We Go?'?",
            "Ariana Grande",
            "Billie Eilish",
            "Lizzo",
            "Taylor Swift",
            "Billie Eilish"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which legendary guitarist is known for his work with the bands Cream and The Yardbirds?",
            "Eric Clapton",
            "Jimi Hendrix",
            "Jimmy Page",
            "Carlos Santana",
            "Eric Clapton"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the lead singer of the rock band U2?",
            "Bono",
            "Chris Martin",
            "Eddie Vedder",
            "Dave Grohl",
            "Bono"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Bohemian Rhapsody' by Queen, what line follows 'Scaramouche, Scaramouche, will you do the Fandango?'",
            "Thunderbolt and lightning, very, very frightening me",
            "So you think you can stone me and spit in my eye?",
            "Galileo, Galileo, Galileo, Galileo, Galileo Figaro - magnificoo",
            "I see a little silhouetto of a man",
            "Galileo, Galileo, Galileo, Galileo, Galileo Figaro - magnificoo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Stairway to Heaven' by Led Zeppelin, what is the next line after 'There's a lady who's sure all that glitters is gold'?",
            "And if you listen very hard, the tune will come to you at last",
            "In a tree by the brook, there's a songbird who sings",
            "If the stores are all closed, with a word she can get what she came for",
            "When she gets there, she knows if the stores are all closed",
            "And if you listen very hard, the tune will come to you at last"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Radiohead's 'Paranoid Android': 'When I am king, you will be first against the wall with your _______'",
            "Opinions",
            "Backs against the wall",
            "Mediocre music",
            "Desperation",
            "Opinions"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'A Day in the Life' by The Beatles, what follows the line 'I read the news today, oh boy'?",
            "About a lucky man who made the grade",
            "And though the news was rather sad",
            "Woke up, fell out of bed",
            "The English army had just won the war",
            "And though the news was rather sad"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'Is this the real life? Is this just fantasy?' in Queen's 'Bohemian Rhapsody'?",
            "Caught in a landslide, no escape from reality",
            "Open your eyes, look up to the skies and see",
            "I'm just a poor boy, I need no sympathy",
            "Easy come, easy go, will you let me go?",
            "Caught in a landslide, no escape from reality"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Hotel California' by Eagles, what follows the line 'On a dark desert highway, cool wind in my hair'?",
            "Rising up through the air",
            "Warm smell of colitas, rising up through the air",
            "Mirrors on the ceiling, the pink champagne on ice",
            "Up ahead in the distance, I saw a shimmering light",
            "Up ahead in the distance, I saw a shimmering light"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Bob Dylan's 'Like a Rolling Stone': 'How does it feel, to be on your _______?'",
            "Own",
            "Back",
            "Own now",
            "Feet",
            "Own now"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Hallelujah' by Leonard Cohen, what does the lyric 'The baffled king composing Hallelujah' refer to?",
            "King David",
            "King Solomon",
            "King Arthur",
            "King Lear",
            "King David"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Nirvana's 'Smells Like Teen Spirit': 'With the lights out, it's less dangerous. Here we are now, ________.'",
            "Entertain us",
            "In the dark",
            "Waiting for you",
            "Come as you are",
            "Entertain us"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'I bless the rains down in Africa' in Toto's 'Africa'?",
            "Gonna take some time to do the things we never had",
            "As sure as Kilimanjaro rises like Olympus above the Serengeti",
            "Hurry boy, she's waiting there for you",
            "I hear the drums echoing tonight",
            "As sure as Kilimanjaro rises like Olympus above the Serengeti"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Time' by Pink Floyd, what follows the line 'Tired of lying in the sunshine staying home to watch the rain'?",
            "You are young and life is long and there is time to kill today",
            "Hanging on in quiet desperation is the English way",
            "And then one day you find, ten years have got behind you",
            "Kicking around on a piece of ground in your hometown",
            "And then one day you find, ten years have got behind you"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from U2's 'With or Without You': 'See the stone set in your eyes. See the thorn twist in your ______.'",
            "Side",
            "Mind",
            "Palm",
            "Soul",
            "Side"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Bohemian Rhapsody' by Queen, what is the next line after 'Mama, just killed a man'?",
            "Put a gun against his head",
            "Life had just begun",
            "Pulled my trigger, now he's dead",
            "Scaramouche, Scaramouche, will you do the Fandango?",
            "Put a gun against his head"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from The Rolling Stones' 'Sympathy for the Devil': 'Please allow me to introduce myself, I'm a man of _______.'",
            "Wealth and taste",
            "Power and grace",
            "Fame and fortune",
            "High status",
            "Wealth and taste"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Space Oddity' by David Bowie, what follows the line 'Ground Control to Major Tom'?",
            "Take your protein pills and put your helmet on",
            "This is Major Tom to Ground Control",
            "Commencing countdown, engines on",
            "And may God's love be with you",
            "Take your protein pills and put your helmet on"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'I'm sorry, the old Taylor can't come to the phone right now' in Taylor Swift's 'Look What You Made Me Do'?",
            "'Cause she's dead",
            "Who dis?",
            "Leave a message at the beep",
            "She's in the club",
            "'Cause she's dead"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Black' by Pearl Jam, what follows the line 'Sheets of empty canvas, untouched sheets of clay'?",
            "Her legs spread out before me as her body once did",
            "Their colors were like my dreams, red, gold, and green",
            "Why'd you wanna erase me, darling?",
            "This peace on earth's not right",
            "Her legs spread out before me as her body once did"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Bob Marley's 'Redemption Song': 'Emancipate yourselves from mental slavery, none but ourselves can free our ______.'",
            "Minds",
            "Soul",
            "Body",
            "Hearts",
            "Minds"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Wish You Were Here' by Pink Floyd, what is the next line after 'How I wish, how I wish you were here'?",
            "We're just two lost souls swimming in a fishbowl",
            "Year after year, running over the same old ground",
            "So, you think you can tell heaven from hell?",
            "We're just two lost souls living in a fishbowl",
            "We're just two lost souls swimming in a fishbowl"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'In the end, the love you take is equal to the love you make' in The Beatles' 'The End'?",
            "And in the end, the love you take is greater than all",
            "And you'll never walk alone",
            "And you, my friend, will still be there",
            "And the world will be as one",
            "And in the end, the love you take is equal to the love you make"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Radiohead's 'Creep': 'You're just like an angel, your skin makes me ________.'",
            "Cry",
            "Fly",
            "Die",
            "Sigh",
            "Cry"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Hurt' by Nine Inch Nails, what follows the line 'I hurt myself today'?",
            "To see if I still feel",
            "To make the pain go away",
            "To prove that I'm alive",
            "To watch the blood flow",
            "To see if I still feel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Leonard Cohen's 'Hallelujah': 'But remember when I moved in you and the holy dove was moving too, and every breath we drew was ________.'",
            "Hallelujah",
            "True",
            "Sacred",
            "Divine",
            "Hallelujah"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Losing My Religion' by R.E.M., what follows the line 'That's me in the corner, that's me in the spotlight'?",
            "Losing my religion",
            "Choosing to be silent",
            "Blessing every occasion",
            "Crying in the moonlight",
            "Losing my religion"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'I'm standing on the edge of time' in Pink Floyd's 'Set the Controls for the Heart of the Sun'?",
            "I believe in the kindness of strangers",
            "I believe in what you do",
            "I believe in the magic of your mind",
            "Believe in love, love of mine",
            "I believe in what you do"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Bob Dylan's 'Blowin' in the Wind': 'The answer, my friend, is blowin' in the wind. The answer is blowin' in the ________.'",
            "Wind",
            "Breeze",
            "Sky",
            "Trees",
            "Wind"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'A Whiter Shade of Pale' by Procol Harum, what follows the line 'We skipped the light fandango'?",
            "Turned cartwheels 'cross the floor",
            "Danced through the night until the morning",
            "Sang songs with the angels",
            "Drifted through the cosmic ocean",
            "Turned cartwheels 'cross the floor"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'You can check out anytime you like, but you can never leave' in Eagles' 'Hotel California'?",
            "You're prisoners of your own device",
            "They stab it with their steely knives",
            "You're trapped in the twilight zone",
            "This could be heaven or this could be hell",
            "You're prisoners of your own device"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Radiohead's 'No Surprises': 'A hand grenade, no ____________.'",
            "Alarms and no surprises",
            "Worries",
            "Drama and no surprises",
            "Fear",
            "Alarms and no surprises"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Eleanor Rigby' by The Beatles, what is the next line after 'Ah, look at all the lonely people'?",
            "Where do they all come from?",
            "Living in a fantasy world",
            "Dying in the rain",
            "Picking up the rice in the church",
            "Where do they all come from?"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'The lunatic is on the grass' in Pink Floyd's 'Brain Damage'?",
            "The lunatic is in my head",
            "Remembering games and daisy chains and laughs",
            "The paper holds their folded faces to the floor",
            "The lunatic is in the hall",
            "The lunatic is in my head"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Nirvana's 'All Apologies': 'What else could I say? Everyone is gay. What else could I write? I don't have the ________.'",
            "Right",
            "Time",
            "Answers",
            "Appetite",
            "Right"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Strange Mercy' by St. Vincent, what follows the line 'If I ever meet the dirty policeman who roughed you up'?",
            "I'm sorry, I don't really give a fuck",
            "I'll be with you",
            "I'll make him pay for what he's done",
            "I'll cry with you",
            "I'm sorry, I don't really give a fuck"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'Love, love is a verb, love is a doing word' in Massive Attack's 'Teardrop'?",
            "Hold two hands and scatter your pearls",
            "Feel me, complement me",
            "Serenade the evening birds",
            "Feel me, trust me, show me you care",
            "Hold two hands and scatter your pearls"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Jeff Buckley's 'Hallelujah': 'It's not someone who's seen the light. It's a _______ who knows how to hide.'",
            "Cold and broken",
            "Blind and bold",
            "Joker",
            "Soldier",
            "Cold and broken"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'She's Always a Woman' by Billy Joel, what follows the line 'She can lead you to love'?",
            "And take you or leave you",
            "But she'll never deceive you",
            "But she's always a woman to me",
            "With her words, softly spoken",
            "But she's always a woman to me"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'If you choose not to decide, you still have made a choice' in Rush's 'Freewill'?",
            "You can choose from phantom fears and kindness that can kill",
            "There's no such thing as fate, our destiny's controlled by ourselves",
            "All you touch and all you see is all your life will ever be",
            "In the end, we will remember not the words of our enemies",
            "You can choose from phantom fears and kindness that can kill"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Joni Mitchell's 'A Case of You': 'I could drink a case of you, darling, and I would still be on my ________.'",
            "Feet",
            "Knees",
            "Toes",
            "Way",
            "Feet"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Wuthering Heights' by Kate Bush, what follows the line 'Heathcliff, it's me, I'm Cathy, I've come home'?",
            "So cold, let me in your window",
            "I'm so cold, let me in your window",
            "I'm here, let me in your window",
            "It's me, I'm Cathy, I'm home",
            "So cold, let me in your window"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'You can't always get what you want' in The Rolling Stones' 'You Can't Always Get What You Want'?",
            "But if you try sometimes, well, you might find",
            "And if you try real hard, you'll get what you need",
            "But you'll find sometimes you get what you need",
            "But you'll get what you deserve",
            "But if you try sometimes, well, you might find"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Radiohead's 'Karma Police': 'This is what you get when you mess with ________.'",
            "Us",
            "Karma",
            "Fate",
            "The police",
            "Us"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Imagine' by John Lennon, what follows the line 'Imagine there's no countries'?",
            "It isn't hard to do",
            "And the world will be as one",
            "Nothing to kill or die for",
            "And no religion too",
            "It isn't hard to do"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from David Bowie's 'Space Oddity': 'This is Major Tom to Ground Control, I'm stepping through the ________.'",
            "Door",
            "Sky",
            "Stars",
            "Window",
            "Door"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Tangled Up in Blue' by Bob Dylan, what follows the line 'Early one mornin' the sun was shinin''?",
            "I was layin' in bed",
            "She was layin' next to me",
            "Woke up and felt the daybreak on my mind",
            "I was feelin' so fine",
            "Woke up and felt the daybreak on my mind"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'I'm looking through you, where did you go' in The Beatles' 'I'm Looking Through You'?",
            "I thought I knew you, what did I know?",
            "Now you're gone, gone, gone away",
            "I thought I saw you, but it was a dream",
            "I'm looking at an empty room",
            "I thought I knew you, what did I know?"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Led Zeppelin's 'Whole Lotta Love': 'You need cooling, baby, I'm not fooling. I'm gonna send you back to ________.'",
            "School",
            "Mama",
            "Arkansas",
            "Your mama",
            "School"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Sweet Child o' Mine' by Guns N' Roses, what follows the line 'She got eyes of the bluest skies'?",
            "As if they thought of rain",
            "And if they thought of rain",
            "You know it's true",
            "You know it's true, oh",
            "And if they thought of rain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'What's your name? Who's your daddy?' in AC/DC's 'Thunderstruck'?",
            "Thunder",
            "Are you ready?",
            "Do you feel the thunder?",
            "You've been thunderstruck",
            "Are you ready?"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from The Rolling Stones' 'Paint It Black': 'I look inside myself and see my heart is ________.'",
            "Black",
            "Cold",
            "Lost",
            "Empty",
            "Black"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Purple Haze' by Jimi Hendrix, what follows the line 'Excuse me while I kiss the sky'?",
            "Purple haze all around",
            "Sorry, but I'm really not sure",
            "I'm just tryin' to find",
            "I'm gonna fly",
            "Purple haze all around"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'She loves you, yeah, yeah, yeah' in The Beatles' 'She Loves You'?",
            "And you know that can't be bad",
            "She said you hurt her so",
            "She's thinkin' of me, yeah, yeah, yeah",
            "She's waiting for you",
            "And you know that can't be bad"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Queen's 'Somebody to Love': 'I work hard every day of my life. I work till I ache my bones at the end ________.'",
            "Of the day",
            "Of the week",
            "Of the road",
            "Of the line",
            "Of the day"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Stairway to Heaven' by Led Zeppelin, what follows the line 'And as we wind on down the road'?",
            "Our shadows taller than our soul",
            "There walks a lady we all know",
            "Sometimes all of our thoughts are misgiven",
            "The tune will come to you at last",
            "Sometimes all of our thoughts are misgiven"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'You can go your own way' in Fleetwood Mac's 'Go Your Own Way'?",
            "Tell me why",
            "You can call it another lonely day",
            "You can call it another lonely night",
            "Tell me sweet lies",
            "Tell me why"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Nirvana's 'Lithium': 'I'm so happy 'cause today I've found my ________, she's true to me.'",
            "Friends",
            "Savior",
            "Placebo",
            "Sunshine",
            "Placebo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Rocket Man' by Elton John, what follows the line 'And I think it's gonna be a long, long time'?",
            "Till touchdown brings me 'round again to find",
            "I'm not the man they think I am at home",
            "And I think it's gonna be a long, long time",
            "Mars ain't the kind of place to raise your kids",
            "Till touchdown brings me 'round again to find"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'Don't let the sun go down on me' in Elton John's 'Don't Let the Sun Go Down on Me'?",
            "I'm losing everything, it's like the sun going down on me",
            "Although I search myself, it's always someone else I see",
            "Don't want to lose your love",
            "I took a chance and changed your way of life",
            "Although I search myself, it's always someone else I see"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Complete the lyrics from Pink Floyd's 'Wish You Were Here': 'How I wish, how I wish you were here. We're just two ________ swimming in a fishbowl, year after year.'",
            "Lost souls",
            "Strangers",
            "Pilgrims",
            "Wanderers",
            "Lost souls"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the song 'Bohemian Rhapsody' by Queen, what is the next line after 'So you think you can stone me and spit in my eye'?",
            "So you think you can love me and leave me to die",
            "So you think you can love me and leave me to cry",
            "So you think you can love me and hurt me to sigh",
            "So you think you can love me and make me comply",
            "So you think you can love me and leave me to die"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'I never meant to cause you any sorrow' in Prince's 'Purple Rain'?",
            "I never meant to cause you any pain",
            "I only wanted one time to see you laughing",
            "I only wanted to see you laughing in the purple rain",
            "I only wanted to see you dancing in the purple rain",
            "I never meant to cause you any pain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the next line after 'I never meant to cause you any sorrow' in Prince's 'Purple Rain'?",
            "I never meant to cause you any pain",
            "I only wanted one time to see you laughing",
            "I only wanted to see you laughing in the purple rain",
            "I only wanted to see you dancing in the purple rain",
            "I never meant to cause you any pain"
        )
    )


        questionsList.shuffle()

    }
    fun entertainmentStageEight(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "In the TV show 'Friends', what is the name of Ross and Monica's dog when they were kids?",
            "Fluffy",
            "Fido",
            "Rover",
            "Chi-Chi",
            "Chi-Chi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Stranger Things', what is Eleven's favorite snack?",
            "Waffles",
            "Popcorn",
            "Chips",
            "Ice Cream",
            "Waffles"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Walter White, who turns to cooking and selling methamphetamine?",
            "Breaking Bad",
            "The Sopranos",
            "The Wire",
            "Mad Men",
            "Breaking Bad"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the TV show 'Sherlock'?",
            "John Watson",
            "Mycroft Holmes",
            "Lestrade",
            "Sherlock Holmes",
            "Sherlock Holmes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Game of Thrones', what is the seat of House Lannister?",
            "Casterly Rock",
            "King's Landing",
            "Winterfell",
            "Highgarden",
            "Casterly Rock"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the lives of Jay Pritchett and his family?",
            "Modern Family",
            "The Simpsons",
            "Family Guy",
            "Brooklyn Nine-Nine",
            "Modern Family"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Office' (US), what is the name of the paper company where the characters work?",
            "Dunder Mifflin",
            "Wernham Hogg",
            "Schrute Farms",
            "Dwight and Jim Paper Co.",
            "Dunder Mifflin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Jack Bauer who works for the Counter Terrorist Unit?",
            "24",
            "Homeland",
            "Alias",
            "Prison Break",
            "24"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Big Bang Theory', what is Sheldon's last name?",
            "Hofstadter",
            "Cooper",
            "Wolowitz",
            "Koothrappali",
            "Cooper"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional continent in the TV show 'Game of Thrones'?",
            "Westeros",
            "Essos",
            "Sothoryos",
            "Ulthos",
            "Westeros"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a high school chemistry teacher turned methamphetamine producer?",
            "Breaking Bad",
            "The Sopranos",
            "Dexter",
            "Mad Men",
            "Breaking Bad"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Simpsons', what is the name of the bartender in Moe's Tavern?",
            "Barney",
            "Lenny",
            "Carl",
            "Moe",
            "Moe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the alternate dimension in 'Stranger Things'?",
            "The Other Side",
            "The Dark Zone",
            "The Underworld",
            "The Upside Down",
            "The Upside Down"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Friends', what song makes Ross and Rachel's daughter Emma laugh for the first time?",
            "Baby Got Back",
            "The Lion Sleeps Tonight",
            "Twinkle, Twinkle, Little Star",
            "I Will Always Love You",
            "Baby Got Back"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a group of kids who uncover supernatural mysteries in their small town?",
            "The X-Files",
            "Buffy the Vampire Slayer",
            "Stranger Things",
            "Supernatural",
            "Stranger Things"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Breaking Bad', what is the street name of Walter White's blue meth?",
            "Blue Sky",
            "Crystal Clear",
            "Heisenberg's Blue",
            "Blue Magic",
            "Blue Sky"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is known for its phrase 'Winter is coming'?",
            "Breaking Bad",
            "Game of Thrones",
            "The Sopranos",
            "The Walking Dead",
            "Game of Thrones"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional town in 'The Simpsons'?",
            "Quahog",
            "Springfield",
            "Arlen",
            "South Park",
            "Springfield"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Office' (US), who is the regional manager of the Scranton branch of Dunder Mifflin at the start of the series?",
            "Jim Halpert",
            "Michael Scott",
            "Dwight Schrute",
            "Pam Beesly",
            "Michael Scott"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the lives of a group of friends living in New York City?",
            "How I Met Your Mother",
            "Friends",
            "Seinfeld",
            "The Big Bang Theory",
            "Friends"
        )
    )


    questionsList.add(
        QuestionsModel(
            "In 'Breaking Bad', what is the alias used by Gustavo Fring in his drug empire?",
            "The Cook",
            "The Distributor",
            "The Chicken Man",
            "The Ice King",
            "The Chicken Man"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Tyrion Lannister, known for his wit and strategic thinking?",
            "The Sopranos",
            "Breaking Bad",
            "Game of Thrones",
            "The Wire",
            "Game of Thrones"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Sherlock', what is the name of Sherlock Holmes' brother?",
            "Mycroft Holmes",
            "John Watson",
            "Lestrade",
            "Moriarty",
            "Mycroft Holmes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Saul Goodman, a criminal lawyer with a colorful personality?",
            "Better Call Saul",
            "The Good Wife",
            "Suits",
            "Boston Legal",
            "Better Call Saul"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Black Mirror', what is the name of the simulated reality featured in the episode 'San Junipero'?",
            "San Junipero",
            "White Bear",
            "Nosedive",
            "USS Callister",
            "San Junipero"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a high school chemistry teacher who turns to cooking and selling blue crystal meth?",
            "Breaking Bad",
            "The Sopranos",
            "The Wire",
            "Mad Men",
            "Breaking Bad"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Westworld', what is the name of the futuristic theme park with lifelike android hosts?",
            "Futureland",
            "Dreamworld",
            "Fantasyland",
            "Westworld",
            "Westworld"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Ragnar Lothbrok, a legendary Norse hero?",
            "The Last Kingdom",
            "Vikings",
            "Game of Thrones",
            "Spartacus",
            "Vikings"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Wire', what is the nickname of drug kingpin Avon Barksdale's second-in-command?",
            "Slim Charles",
            "Bubbles",
            "Stringer Bell",
            "Poot",
            "Stringer Bell"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is a prequel to 'Breaking Bad' and focuses on the transformation of Jimmy McGill into Saul Goodman?",
            "Better Call Saul",
            "El Camino",
            "Breaking Bad: Origins",
            "Saul's Rise",
            "Better Call Saul"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Mr. Robot', what is the hacker alias of the main character, Elliot Alderson?",
            "Zero Cool",
            "Neo",
            "Dark Army",
            "fsociety",
            "fsociety"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Raymond Reddington, a former government agent turned high-profile criminal?",
            "The Blacklist",
            "Homeland",
            "Person of Interest",
            "White Collar",
            "The Blacklist"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Crown', who plays the role of Queen Elizabeth II in the first two seasons?",
            "Helen Mirren",
            "Claire Foy",
            "Olivia Colman",
            "Emma Corrin",
            "Claire Foy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is set in the fictional town of Twin Peaks and follows the investigation of the murder of Laura Palmer?",
            "True Detective",
            "Twin Peaks",
            "Fargo",
            "Mindhunter",
            "Twin Peaks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The West Wing', who serves as the White House Chief of Staff under President Josiah Bartlet?",
            "Leo McGarry",
            "C.J. Cregg",
            "Josh Lyman",
            "Toby Ziegler",
            "Leo McGarry"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows a group of individuals with extraordinary abilities who come together to save the world?",
            "Heroes",
            "The Umbrella Academy",
            "Altered Carbon",
            "The Boys",
            "Heroes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Fargo', which season features a character named Lorne Malvo, a hitman with a sinister and unpredictable nature?",
            "Season 1",
            "Season 2",
            "Season 3",
            "Season 4",
            "Season 1"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the complex lives of the employees at Sterling Cooper advertising agency in the 1960s?",
            "Mad Men",
            "The Marvelous Mrs. Maisel",
            "The Crown",
            "Boardwalk Empire",
            "Mad Men"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Black Sails', what is the name of the pirate captain who seeks to establish a pirate utopia in Nassau?",
            "Blackbeard",
            "Charles Vane",
            "James Flint",
            "Anne Bonny",
            "James Flint"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is a science fiction anthology series created by Charlie Brooker?",
            "The Twilight Zone",
            "Altered Carbon",
            "Black Mirror",
            "Electric Dreams",
            "Black Mirror"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Westworld', what is the name of the character played by Anthony Hopkins, who is the park's co-founder and director?",
            "Bernard Lowe",
            "William",
            "Teddy Flood",
            "Dr. Robert Ford",
            "Dr. Robert Ford"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the story of a high school chemistry teacher turned methamphetamine producer and is a prequel to 'Breaking Bad'?",
            "Ozark",
            "Better Call Saul",
            "Snowfall",
            "Narcos",
            "Better Call Saul"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Black Mirror', which episode features an interactive film where viewers make choices for the main character?",
            "Nosedive",
            "USS Callister",
            "Bandersnatch",
            "White Christmas",
            "Bandersnatch"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the lives of a group of magicians who discover that the magical fantasy world they read about as children is real?",
            "The Magicians",
            "Magnum, P.I.",
            "Merlin",
            "Charmed",
            "The Magicians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Sopranos', what is the name of Tony Soprano's psychiatrist?",
            "Dr. Jennifer Melfi",
            "Dr. Lorraine Bracco",
            "Dr. Carmela Soprano",
            "Dr. Elliot Kupferberg",
            "Dr. Jennifer Melfi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is set in a post-apocalyptic world and follows a group of survivors led by a former sheriff?",
            "The Walking Dead",
            "Fear the Walking Dead",
            "Z Nation",
            "World War Z",
            "The Walking Dead"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Fargo', which season features a character named V.M. Varga, a mysterious and cunning businessman?",
            "Season 1",
            "Season 2",
            "Season 3",
            "Season 4",
            "Season 3"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is based on a novel series by George R.R. Martin and features complex political intrigue and epic battles?",
            "The Witcher",
            "His Dark Materials",
            "Game of Thrones",
            "Outlander",
            "Game of Thrones"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Peaky Blinders', what is the name of the protagonist, who leads a gang in post-World War I Birmingham, England?",
            "Arthur Shelby",
            "John Shelby",
            "Alfie Solomons",
            "Tommy Shelby",
            "Tommy Shelby"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Jimmy McGill, who later becomes the morally challenged lawyer Saul Goodman?",
            "Better Call Saul",
            "The Good Wife",
            "Suits",
            "Breaking Bad",
            "Better Call Saul"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Expanse', what is the name of the detective who becomes involved in a vast conspiracy between Earth, Mars, and the Belt?",
            "James Holden",
            "Amos Burton",
            "Joe Miller",
            "Alex Kamal",
            "Joe Miller"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the lives of the Shelby crime family in post-World War I Birmingham, England?",
            "Taboo",
            "Boardwalk Empire",
            "Breaking Bad",
            "Peaky Blinders",
            "Peaky Blinders"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Crown', which historical event is depicted in the first season, focusing on the early reign of Queen Elizabeth II?",
            "The Apollo 11 Moon Landing",
            "The Cuban Missile Crisis",
            "The Suez Crisis",
            "The Aberfan Disaster",
            "The Suez Crisis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows a mysterious and powerful character known as 'The Mandalorian' in the Star Wars universe?",
            "Star Wars: Rebels",
            "The Clone Wars",
            "The Mandalorian",
            "Star Wars: Resistance",
            "The Mandalorian"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Dexter', what is Dexter Morgan's profession by day?",
            "Blood Splatter Analyst",
            "Forensic Psychologist",
            "Homicide Detective",
            "Medical Examiner",
            "Blood Splatter Analyst"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows a covert team of vigilantes with extraordinary abilities who fight against corruption?",
            "The Umbrella Academy",
            "Doom Patrol",
            "Titans",
            "The Boys",
            "The Boys"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Stranger Things', what is the name of the parallel dimension inhabited by the Mind Flayer?",
            "The Abyss",
            "The Netherworld",
            "The Void",
            "The Upside Down",
            "The Upside Down"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Nucky Thompson, who is involved in organized crime during the Prohibition era?",
            "Peaky Blinders",
            "The Sopranos",
            "Boardwalk Empire",
            "The Wire",
            "Boardwalk Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Witcher', what is the name of the monster hunter and protagonist, played by Henry Cavill?",
            "Geralt of Rivia",
            "Ezra of Gwent",
            "Dandelion",
            "Vesemir",
            "Geralt of Rivia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a group of individuals who possess unique abilities and work for an organization known as 'Division'?",
            "Nikita",
            "Alias",
            "Heroes",
            "Alphas",
            "Nikita"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'True Detective' Season 1, who plays the character Rust Cohle?",
            "Matthew McConaughey",
            "Woody Harrelson",
            "Colin Farrell",
            "Vince Vaughn",
            "Matthew McConaughey"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Elizabeth Jennings, who, along with her husband, works as a Soviet spy in the United States?",
            "Homeland",
            "The Americans",
            "The Bureau",
            "Spy City",
            "The Americans"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Breaking Bad', what is the street name for the high-quality blue meth produced by Walter White?",
            "Blue Sky",
            "Crystal Clear",
            "Heisenberg's Blue",
            "Blue Magic",
            "Blue Sky"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Ragnar Lothbrok, a legendary Viking chieftain?",
            "Vikings",
            "The Last Kingdom",
            "Northmen: A Viking Saga",
            "Norsemen",
            "Vikings"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Sopranos', what is the nickname of Tony Soprano's cousin, who becomes involved in organized crime?",
            "Bobby Baccalieri",
            "Richie Aprile",
            "Christopher Moltisanti",
            "Tony Blundetto",
            "Richie Aprile"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is set in the Marvel Cinematic Universe and follows a group of enhanced individuals known as Inhumans?",
            "Marvel's Agents of S.H.I.E.L.D.",
            "Marvel's The Punisher",
            "Marvel's Daredevil",
            "Marvel's Inhumans",
            "Marvel's Inhumans"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Westworld', what is the name of the park's narrative director who is responsible for creating the hosts' storylines?",
            "Robert Ford",
            "Bernard Lowe",
            "William",
            "Teddy Flood",
            "Robert Ford"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows a detective with a photographic memory who solves complex cases for the San Francisco Police Department?",
            "Elementary",
            "Sherlock",
            "Monk",
            "Psych",
            "Monk"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Witcher', what is the name of the organization that trains young girls to become monster hunters?",
            "The Mages' Guild",
            "The Witcher School",
            "The Lodge of Sorceresses",
            "The Brotherhood of Steel",
            "The Witcher School"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the lives of a group of individuals with diverse backgrounds and abilities who are connected by a mysterious force?",
            "Sense8",
            "Altered Carbon",
            "The OA",
            "Legion",
            "Sense8"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Crown', which historical event is depicted in the second season, focusing on the marriage of Prince Philip and Queen Elizabeth II?",
            "The Kennedy Assassination",
            "The Falklands War",
            "The Moon Landing",
            "The Profumo Affair",
            "The Profumo Affair"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows a criminal defense lawyer named Jimmy McGill as he transforms into the morally challenged lawyer Saul Goodman?",
            "Better Call Saul",
            "The Good Wife",
            "Suits",
            "Breaking Bad",
            "Better Call Saul"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Umbrella Academy', what is the name of the android mother who cares for the adopted siblings?",
            "Grace",
            "Alice",
            "Lila",
            "Pogo",
            "Grace"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is based on a series of novels by Diana Gabaldon and follows the story of a time-traveling nurse in 18th-century Scotland?",
            "The Tudors",
            "Outlander",
            "Poldark",
            "The White Queen",
            "Outlander"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Black Mirror', which episode explores the concept of a dating app that determines the length of a relationship?",
            "Hang the DJ",
            "Nosedive",
            "The Entire History of You",
            "White Christmas",
            "Hang the DJ"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show is set in a world where superheroes, known as 'The Seven', are managed by a powerful corporation?",
            "The Boys",
            "Doom Patrol",
            "Umbrella Academy",
            "Titans",
            "The Boys"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Expanse', what is the name of the spaceship crewed by James Holden and his team?",
            "Rocinante",
            "Donnager",
            "Protogen",
            "Anubis",
            "Rocinante"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show features a character named Frank Underwood, who rises to power through cunning political maneuvers?",
            "The West Wing",
            "House of Cards",
            "Scandal",
            "Veep",
            "House of Cards"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Mandalorian', what is the real name of the character referred to as 'The Child' or 'Baby Yoda'?",
            "Grogu",
            "Yaddle",
            "Yoda",
            "Yodito",
            "Grogu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TV show follows the investigations of a forensic anthropologist named Temperance Brennan?",
            "Criminal Minds",
            "Dexter",
            "Bones",
            "CSI: Crime Scene Investigation",
            "Bones"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageNine(){
        questionsList.clear()

        questionsList.add(
     QuestionsModel(
         "What social media platform popularized the concept of 'Stories' that disappear after 24 hours?",
         "Facebook",
         "Instagram",
         "Snapchat",
         "Twitter",
         "Instagram"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which cryptocurrency gained significant popularity and value, known for its meme-inspired mascot?",
         "Bitcoin",
         "Ethereum",
         "Dogecoin",
         "Ripple",
         "Dogecoin"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the name of the short video content platform that became widely popular, especially among younger users?",
         "TikTok",
         "Vine",
         "Snapchat",
         "Triller",
         "TikTok"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which streaming platform gained attention for its true crime documentaries, including 'Making a Murderer' and 'Tiger King'?",
         "Hulu",
         "Amazon Prime Video",
         "Netflix",
         "Disney+",
         "Netflix"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What term is used to describe the trend where people simplify their lives by getting rid of unnecessary belongings?",
         "Minimalism",
         "Sustainability",
         "Hygge",
         "Marie Kondo-ing",
         "Minimalism"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which fashion trend, characterized by oversized clothing and accessories, gained popularity in the 2020s?",
         "Normcore",
         "Athleisure",
         "Vaporwave",
         "Y2K Fashion",
         "Y2K Fashion"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the term for the trend of remote or flexible work arrangements, often facilitated by digital technology?",
         "Gig Economy",
         "Telecommuting",
         "Flextime",
         "Remote Work",
         "Remote Work"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which mobile app, known for short-form audio content, gained popularity for its 'Spaces' feature for live audio conversations?",
         "Clubhouse",
         "Twitter",
         "Discord",
         "LinkedIn",
         "Clubhouse"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the name of the trend where people intentionally take breaks from digital devices to reduce stress and improve well-being?",
         "Digital Detox",
         "Screen Cleanse",
         "Tech Timeout",
         "Phone Fast",
         "Digital Detox"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which meme format, featuring a woman yelling at a confused cat, became widely used to express arguments or debates?",
         "Distracted Boyfriend",
         "Woman Yelling at a Cat",
         "Mocking SpongeBob",
         "Expanding Brain",
         "Woman Yelling at a Cat"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the name of the trend where people create and share short, engaging videos set to music, often featuring dance routines?",
         "Lip Syncing",
         "Vine 2.0",
         "Dubsmash",
         "Dance Challenge",
         "Dance Challenge"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which fitness trend involves high-intensity workouts with short rest intervals, often incorporating functional movements?",
         "CrossFit",
         "Zumba",
         "Pilates",
         "HIIT (High-Intensity Interval Training)",
         "HIIT (High-Intensity Interval Training)"
     )
 )


 questionsList.add(
     QuestionsModel(
         "In the movie 'Inception,' what is the title of the fictional device that allows access to someone's dreams within a dream?",
         "Somnacin",
         "Oneirophrenia",
         "Cognitum",
         "Extramuros",
         "Oneirophrenia"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which film director is known for creating a dystopian world in 'Blade Runner' and the philosophical exploration in '2001: A Space Odyssey'?",
         "Stanley Kubrick",
         "Christopher Nolan",
         "Ridley Scott",
         "David Fincher",
         "Stanley Kubrick"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In the TV series 'Black Mirror,' what is the title of the episode that explores the concept of rating people in real life, affecting their social status?",
         "White Bear",
         "Nosedive",
         "San Junipero",
         "USS Callister",
         "Nosedive"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who composed the iconic music for the film 'The Good, the Bad and the Ugly'?",
         "Ennio Morricone",
         "Hans Zimmer",
         "John Williams",
         "Bernard Herrmann",
         "Ennio Morricone"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In the novel 'A Clockwork Orange' by Anthony Burgess, what fictional language is used by the protagonist Alex and his friends?",
         "Newspeak",
         "Nadsat",
         "Aurebesh",
         "Elvish",
         "Nadsat"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which actress won an Academy Award for her portrayal of Queen Elizabeth II in the film 'The Queen'?",
         "Cate Blanchett",
         "Helen Mirren",
         "Meryl Streep",
         "Judi Dench",
         "Helen Mirren"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of the fictional book series within the TV series 'Game of Thrones,' written by the character Samwell Tarly?",
         "A Song of Ice and Fire",
         "The Chronicles of Westeros",
         "The Tales of the Seven Kingdoms",
         "Histories and Lore",
         "A Song of Ice and Fire"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In the film 'Eternal Sunshine of the Spotless Mind,' what is the name of the fictional company that erases memories?",
         "Lacuna, Inc.",
         "MindWipe Solutions",
         "ForgetMeNot Corp.",
         "MemoryCleanse Ltd.",
         "Lacuna, Inc."
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which French film director is known for his surrealist works, including 'Un Chien Andalou' and 'The Discreet Charm of the Bourgeoisie'?",
         "Jean Renoir",
         "Francois Truffaut",
         "Jean Cocteau",
         "Luis Bunuel",
         "Luis Bunuel"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In the film 'Apocalypse Now,' what is the name of the character played by Marlon Brando, who is the renegade colonel leading a cult in Cambodia?",
         "Captain Willard",
         "Colonel Kilgore",
         "Captain Kurtz",
         "Sergeant Elias",
         "Captain Kurtz"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which Japanese animated film, directed by Hayao Miyazaki, is often considered a masterpiece and tells the story of Ashitaka and Princess Mononoke?",
         "My Neighbor Totoro",
         "Spirited Away",
         "Howl's Moving Castle",
         "Princess Mononoke",
         "Princess Mononoke"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In the TV series 'The Twilight Zone,' what is the name of the mysterious and otherworldly dimension that serves as the setting for many episodes?",
         "The Abyss",
         "The Netherworld",
         "The Void",
         "The Fifth Dimension",
         "The Fifth Dimension"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who directed the 1999 film 'Fight Club,' based on the novel by Chuck Palahniuk?",
         "Christopher Nolan",
         "Quentin Tarantino",
         "David Fincher",
         "Darren Aronofsky",
         "David Fincher"
     )
 )


 questionsList.add(
     QuestionsModel(
         "In Salman Rushdie's novel 'Midnight's Children,' what extraordinary ability do the children born at the exact moment of India's independence possess?",
         "Telekinesis",
         "Time Travel",
         "Telepathy",
         "Invisibility",
         "Telepathy"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the satirical novel 'Catch-22,' which explores the absurdities of war and bureaucracy?",
         "Joseph Heller",
         "Kurt Vonnegut",
         "George Orwell",
         "Ernest Hemingway",
         "Joseph Heller"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In the novel 'The Master and Margarita' by Mikhail Bulgakov, what supernatural character wreaks havoc in Moscow?",
         "The Devil",
         "The Angel",
         "The Vampire",
         "The Werewolf",
         "The Devil"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which dystopian novel by Aldous Huxley explores a futuristic society where people are controlled through pleasure and conditioning?",
         "Fahrenheit 451",
         "Brave New World",
         "1984",
         "A Clockwork Orange",
         "Brave New World"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of Gabriel Garcia Marquez's novel that tells the multi-generational story of the Buendía family in the fictional town of Macondo?",
         "One Hundred Years of Solitude",
         "Love in the Time of Cholera",
         "Chronicle of a Death Foretold",
         "The Autumn of the Patriarch",
         "One Hundred Years of Solitude"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Haruki Murakami's novel 'Kafka on the Shore,' what unusual ability does Kafka possess?",
         "Teleportation",
         "Talking to Cats",
         "Time Travel",
         "Mind Reading",
         "Talking to Cats"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Name of the Rose,' a historical mystery set in an Italian monastery in the 14th century?",
         "Umberto Eco",
         "Dan Brown",
         "Ken Follett",
         "A.S. Byatt",
         "Umberto Eco"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In David Mitchell's novel 'Cloud Atlas,' what connects the six different storylines that span across time and space?",
         "A Hidden Treasure",
         "A Birthmark",
         "A Rare Book",
         "A Comet Birthmark",
         "A Birthmark"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which Russian novel, written by Fyodor Dostoevsky, explores the psychological impact of a crime and punishment?",
         "War and Peace",
         "Anna Karenina",
         "The Brothers Karamazov",
         "Crime and Punishment",
         "Crime and Punishment"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of the first book in Philip Pullman's 'His Dark Materials' trilogy, where Lyra Belacqua embarks on a journey to the Arctic?",
         "The Subtle Knife",
         "The Golden Compass",
         "The Amber Spyglass",
         "The Northern Lights",
         "The Golden Compass"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In J.D. Salinger's novel 'The Catcher in the Rye,' what is the name of the protagonist who narrates his experiences in New York City?",
         "Holden Caulfield",
         "Charlie Gordon",
         "Jay Gatsby",
         "Atticus Finch",
         "Holden Caulfield"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Shadow of the Wind,' which follows a young boy named Daniel Sempere in post-war Barcelona as he discovers a mysterious author?",
         "Carlos Ruiz Zafón",
         "Isabel Allende",
         "Julio Cortázar",
         "Mario Vargas Llosa",
         "Carlos Ruiz Zafón"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of the novel by H.G. Wells that tells the story of an unnamed narrator's adventures during an alien invasion of Earth?",
         "The War of the Worlds",
         "The Time Machine",
         "The Invisible Man",
         "The Island of Doctor Moreau",
         "The War of the Worlds"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Toni Morrison's novel 'Beloved,' what is the name of the mysterious young woman who appears at Sethe's home and disrupts her life?",
         "Denver",
         "Beloved",
         "Paul D",
         "Baby Suggs",
         "Beloved"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which classic novel by Charlotte Brontë follows the life of an orphan named Jane Eyre and her love for the brooding Mr. Rochester?",
         "Wuthering Heights",
         "Jane Eyre",
         "Pride and Prejudice",
         "Emma",
         "Jane Eyre"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In the novel 'The Hitchhiker's Guide to the Galaxy' by Douglas Adams, what is the answer to the ultimate question of life, the universe, and everything?",
         "42",
         "The Meaning of Life",
         "Infinity",
         "Zero",
         "42"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Count of Monte Cristo,' a tale of betrayal, revenge, and redemption?",
         "Victor Hugo",
         "Alexandre Dumas",
         "Gustave Flaubert",
         "Albert Camus",
         "Alexandre Dumas"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Kurt Vonnegut's novel 'Slaughterhouse-Five,' what concept does the protagonist Billy Pilgrim experience, becoming 'unstuck in time'?",
         "Temporal Displacement",
         "Chrono-Synclastic Infundibulum",
         "Time Paradox",
         "Quantum Flux",
         "Chrono-Synclastic Infundibulum"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of the novel by David Foster Wallace that explores the lives of various characters at an elite tennis academy?",
         "Infinite Jest",
         "The Pale King",
         "A Supposedly Fun Thing I'll Never Do Again",
         "Brief Interviews with Hideous Men",
         "Infinite Jest"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which Russian novel, written by Leo Tolstoy, depicts the French invasion of Russia and the impact on five aristocratic families?",
         "War and Peace",
         "Anna Karenina",
         "The Brothers Karamazov",
         "Crime and Punishment",
         "War and Peace"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Gabriel Garcia Marquez's 'One Hundred Years of Solitude,' what is the name of the city founded by the Buendía family?",
         "Santa Maria",
         "Macondo",
         "San Isidro",
         "Aracataca",
         "Macondo"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the science fiction novel 'Neuromancer,' which popularized the cyberpunk genre?",
         "Isaac Asimov",
         "Philip K. Dick",
         "Arthur C. Clarke",
         "William Gibson",
         "William Gibson"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Ray Bradbury's 'Fahrenheit 451,' what is the significance of the temperature '451'?",
         "The Temperature of Human Emotions",
         "The Melting Point of Books",
         "The Temperature of Book Burning",
         "The Temperature at Which Book Paper Catches Fire",
         "The Temperature at Which Book Paper Catches Fire"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which novel by Aldous Huxley presents a dystopian world where individuals are controlled by pleasure, consumerism, and drugs?",
         "Brave New World",
         "Island",
         "Point Counter Point",
         "The Doors of Perception",
         "Brave New World"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Picture of Dorian Gray,' in which a young man's portrait ages while he remains youthful due to his immoral actions?",
         "Oscar Wilde",
         "D.H. Lawrence",
         "Henry James",
         "Evelyn Waugh",
         "Oscar Wilde"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Jane Austen's 'Pride and Prejudice,' what is the name of the estate owned by Mr. Darcy?",
         "Netherfield Park",
         "Pemberley",
         "Longbourn",
         "Rosings Park",
         "Pemberley"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which novel by Chinua Achebe explores the impact of British colonialism on Igbo society in Nigeria?",
         "Arrow of God",
         "Things Fall Apart",
         "No Longer at Ease",
         "Anthills of the Savannah",
         "Things Fall Apart"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote 'One Flew Over the Cuckoo's Nest,' a novel set in a psychiatric hospital and later adapted into a successful film?",
         "Ken Kesey",
         "J.D. Salinger",
         "John Steinbeck",
         "Kurt Vonnegut",
         "Ken Kesey"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Kazuo Ishiguro's novel 'Never Let Me Go,' what kind of institution is Hailsham, where the main characters are raised?",
         "Military Academy",
         "Boarding School",
         "Orphanage",
         "Cloning Facility",
         "Boarding School"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'To Kill a Mockingbird,' which addresses racial injustice in the American South?",
         "Harper Lee",
         "J.K. Rowling",
         "Maya Angelou",
         "John Grisham",
         "Harper Lee"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of the novel by Milan Kundera that explores themes of love, politics, and philosophy in post-war Czechoslovakia?",
         "The Unbearable Lightness of Being",
         "The Book of Laughter and Forgetting",
         "The Joke",
         "The Farewell Waltz",
         "The Unbearable Lightness of Being"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In George Orwell's '1984,' what is the name of the oppressive government led by Big Brother?",
         "The Party",
         "The Regime",
         "The Authority",
         "The Directorate",
         "The Party"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Grapes of Wrath,' which tells the story of the Joad family during the Great Depression?",
         "F. Scott Fitzgerald",
         "John Steinbeck",
         "Ernest Hemingway",
         "William Faulkner",
         "John Steinbeck"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Margaret Atwood's 'The Handmaid's Tale,' what is the name of the theocratic regime that controls the Republic of Gilead?",
         "The Authority",
         "Theocracy of Salvation",
         "The Sons of Jacob",
         "The Divine Order",
         "The Sons of Jacob"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Which novel by Gabriel Garcia Marquez follows the love story of Fermina Daza and Florentino Ariza over a span of fifty years?",
         "Love in the Time of Cholera",
         "One Hundred Years of Solitude",
         "Chronicle of a Death Foretold",
         "The Autumn of the Patriarch",
         "Love in the Time of Cholera"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Road,' which tells the post-apocalyptic journey of a father and son in a desolate world?",
         "Cormac McCarthy",
         "J.D. Salinger",
         "Don DeLillo",
         "Kazuo Ishiguro",
         "Cormac McCarthy"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Jules Verne's 'Twenty Thousand Leagues Under the Sea,' what is the name of Captain Nemo's submarine?",
         "Nautilus",
         "Atlantis",
         "Kraken",
         "Poseidon",
         "Nautilus"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of the novel by Kazuo Ishiguro that explores the themes of memory and identity through the character of Kathy H?",
         "Never Let Me Go",
         "The Remains of the Day",
         "When We Were Orphans",
         "The Buried Giant",
         "Never Let Me Go"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Great Gatsby,' which explores the decadence and moral decay of the American upper class in the 1920s?",
         "F. Scott Fitzgerald",
         "Ernest Hemingway",
         "John Steinbeck",
         "Sinclair Lewis",
         "F. Scott Fitzgerald"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In J.R.R. Tolkien's 'The Lord of the Rings,' what is the name of the wizard who leads the Fellowship of the Ring?",
         "Saruman",
         "Radagast",
         "Gandalf",
         "Merlin",
         "Gandalf"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Master and Margarita,' a satirical work that blends fantasy, religion, and political commentary?",
         "Fyodor Dostoevsky",
         "Vladimir Nabokov",
         "Boris Pasternak",
         "Mikhail Bulgakov",
         "Mikhail Bulgakov"
     )
 )

 questionsList.add(
     QuestionsModel(
         "What is the title of the novel by Albert Camus, in which the protagonist Meursault displays a detached and existential attitude?",
         "The Stranger",
         "The Fall",
         "The Plague",
         "The Outsider",
         "The Stranger"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Brothers Karamazov,' a complex exploration of morality, spirituality, and the human condition?",
         "Fyodor Dostoevsky",
         "Leo Tolstoy",
         "Anton Chekhov",
         "Ivan Turgenev",
         "Fyodor Dostoevsky"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Salman Rushdie's novel 'The Satanic Verses,' what miraculous event happens to the two main characters, Gibreel Farishta and Saladin Chamcha?",
         "They Gain Immortality",
         "They Switch Bodies",
         "They Develop Superpowers",
         "They Survive a Plane Crash",
         "They Switch Bodies"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Hitchhiker's Guide to the Galaxy,' a humorous science fiction series that follows Arthur Dent's adventures through space?",
         "Isaac Asimov",
         "Douglas Adams",
         "Philip K. Dick",
         "Ray Bradbury",
         "Douglas Adams"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Haruki Murakami's novel 'Norwegian Wood,' what Beatles song does the protagonist Toru Watanabe associate with a traumatic event?",
         "Let It Be",
         "A Day in the Life",
         "Yesterday",
         "Norwegian Wood",
         "Norwegian Wood"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Wind-Up Bird Chronicle,' a surreal and labyrinthine narrative that explores the nature of reality?",
         "Banana Yoshimoto",
         "Haruki Murakami",
         "Kazuo Ishiguro",
         "Ryu Murakami",
         "Haruki Murakami"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Kazuo Ishiguro's novel 'The Remains of the Day,' what is the name of the butler who serves at Darlington Hall?",
         "Stevens",
         "Jenkins",
         "Hobbs",
         "Wilson",
         "Stevens"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Bell Jar,' a semi-autobiographical work that explores the mental health struggles of its protagonist, Esther Greenwood?",
         "Sylvia Plath",
         "Virginia Woolf",
         "Daphne du Maurier",
         "Charlotte Perkins Gilman",
         "Sylvia Plath"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Milan Kundera's novel 'The Book of Laughter and Forgetting,' what is the recurring motif that symbolizes the erasure of history?",
         "A Black Rose",
         "A Broken Mirror",
         "A Missing Photograph",
         "A Forgotten Song",
         "A Broken Mirror"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'Blindness,' in which an entire city is struck by a sudden epidemic of blindness and its social implications are explored?",
         "Gabriel Garcia Marquez",
         "Isabel Allende",
         "Jose Saramago",
         "Julio Cortázar",
         "Jose Saramago"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Milan Kundera's novel 'The Unbearable Lightness of Being,' what philosophical concept does the protagonist, Tomas, grapple with?",
         "Eternal Recurrence",
         "Nihilism",
         "Absurdism",
         "Existentialism",
         "Eternal Recurrence"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'The Fountainhead,' which explores the life and philosophy of the individualistic architect Howard Roark?",
         "Ayn Rand",
         "Albert Camus",
         "F. Scott Fitzgerald",
         "Ernest Hemingway",
         "Ayn Rand"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In Michael Ende's 'The Neverending Story,' what is the name of the magical land that the young boy Bastian explores through a mysterious book?",
         "Fantasia",
         "Narnia",
         "Eldorado",
         "Neverland",
         "Fantasia"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who wrote the novel 'Catch-22,' a satirical work that explores the absurdities of war and bureaucracy?",
         "Joseph Heller",
         "Kurt Vonnegut",
         "George Orwell",
         "Ernest Hemingway",
         "Joseph Heller"
     )
 )

        questionsList.shuffle()

    }
    fun entertainmentStageTen(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Ken Kesey, set in a psychiatric hospital and later adapted into a successful film?",
            "One Flew Over the Cuckoo's Nest",
            "Girl, Interrupted",
            "Asylum",
            "The Bell Jar",
            "One Flew Over the Cuckoo's Nest"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'For Whom the Bell Tolls,' set during the Spanish Civil War and exploring themes of love and sacrifice?",
            "Ernest Hemingway",
            "F. Scott Fitzgerald",
            "John Steinbeck",
            "William Faulkner",
            "Ernest Hemingway"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Count of Monte Cristo,' which follows the story of Edmond Dantès seeking revenge against those who wronged him?",
            "Victor Hugo",
            "Alexandre Dumas",
            "Gustave Flaubert",
            "Albert Camus",
            "Alexandre Dumas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In George Orwell's 'Animal Farm,' what is the name of the pig who becomes the leader of the animal rebellion against the humans?",
            "Napoleon",
            "Snowball",
            "Boxer",
            "Squealer",
            "Napoleon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'To the Lighthouse,' a modernist work that explores the Ramsay family's relationships and perceptions?",
            "D.H. Lawrence",
            "Virginia Woolf",
            "E.M. Forster",
            "James Joyce",
            "Virginia Woolf"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In F. Scott Fitzgerald's 'Tender Is the Night,' what is the name of the psychiatrist who becomes romantically involved with the protagonist, Dick Diver?",
            "Dr. Dohmler",
            "Dr. Gregory",
            "Dr. Abe North",
            "Dr. Calvin Warren",
            "Dr. Dohmler"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Sound and the Fury,' known for its stream-of-consciousness narrative and exploration of Southern American life?",
            "William Faulkner",
            "Flannery O'Connor",
            "Carson McCullers",
            "Eudora Welty",
            "William Faulkner"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In J.D. Salinger's 'Franny and Zooey,' what is the name of the youngest Glass sibling who is a precocious and talented child?",
            "Franny",
            "Zooey",
            "Seymour",
            "Buddy",
            "Franny"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'White Teeth,' which follows the complex relationships of two families in London over three generations?",
            "Zadie Smith",
            "Salman Rushdie",
            "Arundhati Roy",
            "Chimamanda Ngozi Adichie",
            "Zadie Smith"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Gabriel Garcia Marquez's 'Chronicle of a Death Foretold,' what is the name of the twin brothers who seek revenge for their sister's honor?",
            "Pedro and Pablo Vicario",
            "Jaime and Juan Preciado",
            "Esteban and Jaime Trueba",
            "Fermina and Amaranta Buendía",
            "Pedro and Pablo Vicario"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Magic Mountain,' set in a Swiss sanatorium and exploring themes of time, illness, and societal change?",
            "Hermann Hesse",
            "Thomas Mann",
            "Franz Kafka",
            "Milan Kundera",
            "Thomas Mann"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Isabel Allende's 'The House of the Spirits,' what is the name of the patriarch who founds the Trueba family?",
            "Esteban Trueba",
            "Pedro Segundo",
            "Jaime Trueba",
            "Miguel Angel",
            "Esteban Trueba"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Catcher in the Rye,' where the protagonist, Holden Caulfield, reflects on his experiences in New York City?",
            "J.D. Salinger",
            "Sylvia Plath",
            "Ray Bradbury",
            "Kurt Vonnegut",
            "J.D. Salinger"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Milan Kundera's 'The Joke,' what political event becomes a turning point in the life of the protagonist, Ludvik Jahn?",
            "Prague Spring",
            "Velvet Revolution",
            "Hungarian Revolution",
            "Czechoslovak coup d'état",
            "Prague Spring"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Woman in the Dunes,' in which a man becomes trapped in a sand pit with a mysterious woman?",
            "Yasunari Kawabata",
            "Haruki Murakami",
            "Kobo Abe",
            "Junichiro Tanizaki",
            "Kobo Abe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Michael Chabon's 'The Amazing Adventures of Kavalier & Clay,' what art form does the protagonist, Joe Kavalier, excel in?",
            "Painting",
            "Sculpture",
            "Writing",
            "Comic Book Illustration",
            "Comic Book Illustration"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Plague,' which depicts an outbreak of bubonic plague in the Algerian town of Oran?",
            "Albert Camus",
            "Jean-Paul Sartre",
            "Franz Kafka",
            "Samuel Beckett",
            "Albert Camus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Milan Kundera's 'The Book of Laughter and Forgetting,' what political event serves as a backdrop for the interconnected stories?",
            "Prague Spring",
            "Velvet Revolution",
            "Czechoslovak coup d'état",
            "Hungarian Revolution",
            "Czechoslovak coup d'état"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'Slaughterhouse-Five,' which uses the protagonist Billy Pilgrim's experiences to explore the bombing of Dresden in World War II?",
            "Joseph Heller",
            "Kurt Vonnegut",
            "Ernest Hemingway",
            "Ray Bradbury",
            "Kurt Vonnegut"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Arundhati Roy that intertwines the lives of the twins Rahel and Estha with the socio-political landscape of Kerala?",
            "The God of Small Things",
            "The Ministry of Utmost Happiness",
            "The Shadow Lines",
            "The Inheritance of Loss",
            "The God of Small Things"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Haruki Murakami's '1Q84,' what parallel world does the protagonist, Aomame, find herself in?",
            "1984",
            "1Q84",
            "Brave New World",
            "Neverwhere",
            "1Q84"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'One Hundred Years of Solitude,' which chronicles the Buendía family's history in the fictional town of Macondo?",
            "Gabriel Garcia Marquez",
            "Isabel Allende",
            "Mario Vargas Llosa",
            "Julio Cortázar",
            "Gabriel Garcia Marquez"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Haruki Murakami's 'Kafka on the Shore,' what strange phenomenon occurs in the library where Kafka takes refuge?",
            "Books Come to Life",
            "Time Stops",
            "Talking Animals",
            "Teleportation",
            "Books Come to Life"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Kite Runner,' which follows the friendship between Amir and Hassan against the backdrop of Afghanistan's tumultuous history?",
            "Khaled Hosseini",
            "Mohsin Hamid",
            "Orhan Pamuk",
            "Hossein Mortezaeian Abkenar",
            "Khaled Hosseini"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Vladimir Nabokov's 'Lolita,' what is the name of the professor and narrator who becomes infatuated with a young girl?",
            "Humbert Humbert",
            "Dmitri Nabokov",
            "Vladimir Pnin",
            "John Ray Jr.",
            "Humbert Humbert"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'If on a winter's night a traveler,' a postmodern narrative that weaves multiple stories around the theme of reading?",
            "Italo Calvino",
            "Jorge Luis Borges",
            "Umberto Eco",
            "Milan Kundera",
            "Italo Calvino"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Toni Morrison's 'Song of Solomon,' what is the name of the protagonist who embarks on a journey to discover his family's history?",
            "Macon 'Milkman' Dead III",
            "Pilate Dead",
            "Macon Dead Jr.",
            "Ruth Foster Dead",
            "Macon 'Milkman' Dead III"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Satanic Verses,' a work that blends magical realism and religious allegory?",
            "Salman Rushdie",
            "Arundhati Roy",
            "Chinua Achebe",
            "V.S. Naipaul",
            "Salman Rushdie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Kazuo Ishiguro's 'The Buried Giant,' what mythical creature plays a central role in the story set in post-Arthurian Britain?",
            "Dragon",
            "Griffin",
            "Unicorn",
            "Banshee",
            "Dragon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Secret History,' which revolves around a group of elite students studying classical Greek at a Vermont college?",
            "Donna Tartt",
            "Jeffrey Eugenides",
            "Jonathan Franzen",
            "Zadie Smith",
            "Donna Tartt"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Milan Kundera's 'The Unbearable Lightness of Being,' what historical event serves as a backdrop for the characters' lives in Czechoslovakia?",
            "Prague Spring",
            "Velvet Revolution",
            "Czechoslovak coup d'état",
            "Hungarian Revolution",
            "Prague Spring"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'American Psycho,' a satirical work that critiques the excesses of consumer culture through the character Patrick Bateman?",
            "Bret Easton Ellis",
            "Chuck Palahniuk",
            "Jonathan Franzen",
            "Don DeLillo",
            "Bret Easton Ellis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In J.R.R. Tolkien's 'The Hobbit,' what is the name of the dragon who hoards the treasure in the Lonely Mountain?",
            "Smaug",
            "Saruman",
            "Gollum",
            "Balrog",
            "Smaug"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Road,' which tells the post-apocalyptic journey of a father and son in a desolate world?",
            "Cormac McCarthy",
            "J.D. Salinger",
            "Don DeLillo",
            "Kazuo Ishiguro",
            "Cormac McCarthy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Gabriel Garcia Marquez's 'Love in the Time of Cholera,' what flowers does Florentino Ariza send to Fermina Daza as a declaration of his love?",
            "Roses",
            "Orchids",
            "Lilies",
            "Daisies",
            "Roses"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Shadow of the Wind,' set in post-war Barcelona and centered around a mysterious book and its author?",
            "Carlos Ruiz Zafón",
            "Julian Barnes",
            "David Mitchell",
            "Colm Tóibín",
            "Carlos Ruiz Zafón"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Milan Kundera's 'The Book of Laughter and Forgetting,' what is the title of the banned Czech poet's poem that becomes a symbol of resistance?",
            "The Farewell Ode",
            "The Lost Sonnet",
            "The Disappeared Limerick",
            "The Forgotten Haiku",
            "The Farewell Ode"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Brief Wondrous Life of Oscar Wao,' which explores the life of a Dominican-American man and his family's curse?",
            "Junot Díaz",
            "Sandra Cisneros",
            "Jhumpa Lahiri",
            "Julia Alvarez",
            "Junot Díaz"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Michael Ende's 'Momo,' what supernatural beings steal people's time and contribute to the fast-paced modern world?",
            "Time Thieves",
            "Clock Gnomes",
            "Temporal Spirits",
            "Chrono Bandits",
            "Time Thieves"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Goldfinch,' which follows the life of Theo Decker after a terrorist attack at the Metropolitan Museum of Art?",
            "Donna Tartt",
            "Jonathan Franzen",
            "Zadie Smith",
            "Jeffrey Eugenides",
            "Donna Tartt"
        )
    )


    questionsList.add(
        QuestionsModel(
            "In the anime 'Naruto,' what is the name of Naruto Uzumaki's signature jutsu?",
            "Chidori",
            "Rasengan",
            "Shadow Clone Jutsu",
            "Fireball Jutsu",
            "Rasengan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'One Piece,' what is the name of Monkey D. Luffy's straw hat?",
            "Soul King",
            "Sun Hat",
            "Gomu Gomu Hat",
            "Three-Sword Hat",
            "Gomu Gomu Hat"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Avatar: The Last Airbender'?",
            "Zuko",
            "Aang",
            "Sokka",
            "Katara",
            "Aang"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Dragon Ball Z,' what is the name of Goku's powerful transformation that significantly increases his power level?",
            "Super Saiyan",
            "Great Ape",
            "Kaio-Ken",
            "Spirit Bomb",
            "Super Saiyan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a robot named Wall-E who cleans a desolate, trash-covered Earth?",
            "Toy Story",
            "Finding Nemo",
            "Up",
            "Wall-E",
            "Wall-E"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'Attack on Titan,' what is the name of the military organization that fights against the Titans?",
            "Survey Corps",
            "Military Police Brigade",
            "Garrison Regiment",
            "Scout Regiment",
            "Survey Corps"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'SpongeBob SquarePants'?",
            "Patrick Star",
            "Squidward Tentacles",
            "Mr. Krabs",
            "SpongeBob SquarePants",
            "SpongeBob SquarePants"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'My Hero Academia,' what is the superhero name of the protagonist, Izuku Midoriya?",
            "Deku",
            "All Might",
            "Endeavor",
            "Todoroki",
            "Deku"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series follows the adventures of a boy and his talking dog, who travel through different dimensions and encounter bizarre creatures?",
            "Adventure Time",
            "Regular Show",
            "Steven Universe",
            "Gravity Falls",
            "Adventure Time"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Pokémon,' who is the main character's first Pokémon and loyal companion?",
            "Bulbasaur",
            "Pikachu",
            "Charmander",
            "Squirtle",
            "Pikachu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a young robot named Hogarth Hughes who befriends a giant robot from outer space?",
            "The Iron Giant",
            "RoboCop",
            "Big Hero 6",
            "Astro Boy",
            "The Iron Giant"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'Fullmetal Alchemist,' what is the main goal of the Elric brothers, Edward and Alphonse?",
            "Collecting Dragon Balls",
            "Becoming Hokage",
            "Restoring their bodies",
            "Becoming Pirate King",
            "Restoring their bodies"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series follows the adventures of a boy with a magical hat and his trusty talking dog as they protect the Land of Ooo?",
            "Steven Universe",
            "Adventure Time",
            "Gravity Falls",
            "Regular Show",
            "Adventure Time"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Yu Yu Hakusho,' what is Yusuke Urameshi's initial position in the Spirit World after his death?",
            "Spirit Detective",
            "Demon King",
            "Reaper",
            "Spirit Beast",
            "Spirit Detective"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Rick and Morty'?",
            "Morty Smith",
            "Jerry Smith",
            "Rick Sanchez",
            "Beth Smith",
            "Rick Sanchez"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'Death Note,' what is the main character Light Yagami's alias as he tries to rid the world of criminals?",
            "Zero",
            "Kira",
            "L",
            "Near",
            "Kira"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film tells the story of a young Viking named Hiccup who befriends and trains dragons?",
            "Shrek",
            "How to Train Your Dragon",
            "Moana",
            "Frozen",
            "How to Train Your Dragon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Cowboy Bebop,' what is the name of the bounty hunter who leads the crew of the spaceship Bebop?",
            "Spike Spiegel",
            "Jet Black",
            "Faye Valentine",
            "Ed",
            "Spike Spiegel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the creator of the animated TV series 'The Simpsons'?",
            "Matt Groening",
            "Seth MacFarlane",
            "Mike Judge",
            "Trey Parker",
            "Matt Groening"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'Neon Genesis Evangelion,' what is the name of the organization that battles mysterious beings known as Angels?",
            "Nerv",
            "Gundam",
            "EvaCorp",
            "Wille",
            "Nerv"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the protagonist in the anime 'One Punch Man,' known for defeating opponents with a single punch?",
            "Saitama",
            "Genos",
            "Mumen Rider",
            "Boros",
            "Saitama"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Sailor Moon,' what is the civilian identity of the titular character Sailor Moon?",
            "Rei Hino",
            "Ami Mizuno",
            "Usagi Tsukino",
            "Makoto Kino",
            "Usagi Tsukino"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series features the adventures of a group of kids and their friendly monsters who are transported to a digital world?",
            "Pokémon",
            "Digimon",
            "Yu-Gi-Oh!",
            "Beyblade",
            "Digimon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Hunter x Hunter,' what is the name of Gon Freecss' best friend and fellow aspiring Hunter?",
            "Killua Zoldyck",
            "Leorio Paradinight",
            "Kurapika",
            "Hisoka",
            "Killua Zoldyck"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the anime 'Cowboy Bebop'?",
            "Jet Black",
            "Faye Valentine",
            "Spike Spiegel",
            "Edward",
            "Spike Spiegel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Dragon Ball,' what is the name of the magical dragon who grants wishes when all seven Dragon Balls are gathered?",
            "Shenron",
            "Porunga",
            "Eternal Dragon",
            "Smaug",
            "Shenron"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film tells the story of a young fish named Nemo who gets separated from his father and ends up in a fish tank?",
            "Finding Nemo",
            "Shark Tale",
            "The Little Mermaid",
            "The Incredibles",
            "Finding Nemo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'My Hero Academia,' what is the superhero name of Shoto Todoroki, who can control both ice and fire?",
            "Icy Hot",
            "Endeavor",
            "Dabi",
            "Shoto",
            "Shoto"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the creator of the animated TV series 'Adventure Time'?",
            "Rebecca Sugar",
            "J.G. Quintel",
            "Pendleton Ward",
            "Lauren Faust",
            "Pendleton Ward"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Fullmetal Alchemist: Brotherhood,' what is the primary source of alchemical power in the world?",
            "Philosopher's Stone",
            "Red Stone",
            "Sorcerer's Stone",
            "Elixir Stone",
            "Philosopher's Stone"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series follows the adventures of a boy with a magical staff and his friends as they defend their world from evil?",
            "The Powerpuff Girls",
            "Ben 10",
            "Danny Phantom",
            "The Fairly OddParents",
            "Ben 10"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'Demon Slayer,' what is the protagonist Tanjiro Kamado's ultimate goal?",
            "Become a Hashira",
            "Defeat Muzan Kibutsuji",
            "Find his missing sister",
            "Master Water Breathing",
            "Defeat Muzan Kibutsuji"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Archer'?",
            "Cyril Figgis",
            "Mallory Archer",
            "Lana Kane",
            "Sterling Archer",
            "Sterling Archer"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Code Geass: Lelouch of the Rebellion,' what supernatural power does Lelouch vi Britannia possess?",
            "Telekinesis",
            "Mind Control",
            "Invisibility",
            "Time Travel",
            "Mind Control"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a rat named Remy who dreams of becoming a great chef in Paris?",
            "Ratatouille",
            "Kung Fu Panda",
            "The Lion King",
            "Shrek",
            "Ratatouille"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Yu-Gi-Oh!,' what is the name of the ancient Egyptian Pharaoh spirit that resides within Yugi Moto?",
            "Ra",
            "Obelisk",
            "Slifer",
            "Atem",
            "Atem"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the anime 'One Piece,' known for his dream of becoming the Pirate King?",
            "Roronoa Zoro",
            "Monkey D. Luffy",
            "Nami",
            "Usopp",
            "Monkey D. Luffy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'The Simpsons,' what is the name of Homer Simpson's favorite beer?",
            "Duff Beer",
            "Buzz Cola",
            "Squishee",
            "Flaming Moe",
            "Duff Beer"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series follows the adventures of a group of kids and their magical talking dog as they solve mysteries?",
            "Scooby-Doo, Where Are You!",
            "Tom and Jerry",
            "The Flintstones",
            "The Jetsons",
            "Scooby-Doo, Where Are You!"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Tokyo Ghoul,' what is the name of the protagonist Kaneki's favorite food after turning into a half-ghoul?",
            "Pizza",
            "Ramen",
            "Human Flesh",
            "Chocolate",
            "Ramen"
        )
    )
    questionsList.add(
        QuestionsModel(
            "In 'Death Note,' what is the name of the Shinigami who drops his Death Note into the human world?",
            "Rem",
            "Ryuk",
            "Sidoh",
            "Jealous",
            "Ryuk"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series features a group of kids with special abilities who protect their town from supernatural threats?",
            "The Powerpuff Girls",
            "Teen Titans",
            "The X-Men",
            "The Winx Club",
            "Teen Titans"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'Fairy Tail,' what is the name of Natsu Dragneel's signature attack?",
            "Fire Fist",
            "Dragon Roar",
            "Sky Dragon Slayer",
            "Natsu Kick",
            "Dragon Roar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Dexter's Laboratory'?",
            "Dee Dee",
            "Dexter",
            "Mandark",
            "Mom",
            "Dexter"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Spirited Away,' what is the name of the witch who runs the bathhouse in the spirit world?",
            "Yubaba",
            "Zeniba",
            "Chihiro",
            "No-Face",
            "Yubaba"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a blue alien named Stitch who crash-lands in Hawaii and befriends a young girl named Lilo?",
            "Lilo & Stitch",
            "Finding Nemo",
            "The Little Mermaid",
            "Moana",
            "Lilo & Stitch"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'One Piece,' what is the name of Monkey D. Luffy's brother, who possesses the power of the Mera Mera no Mi?",
            "Ace",
            "Sabo",
            "Shanks",
            "Kaido",
            "Sabo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the anime 'Black Clover,' aiming to become the Wizard King?",
            "Asta",
            "Yuno",
            "Noelle",
            "Yami",
            "Asta"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series follows the adventures of a boy and his dog who have cosmic and surreal adventures in outer space?",
            "The Jetsons",
            "Dexter's Laboratory",
            "Courage the Cowardly Dog",
            "Rick and Morty",
            "Rick and Morty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Naruto,' what is the name of Sasuke Uchiha's older brother, who plays a significant role in the series?",
            "Itachi",
            "Madara",
            "Kakashi",
            "Orochimaru",
            "Itachi"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageEleven(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Futurama'?",
            "Leela",
            "Bender",
            "Fry",
            "Professor Farnsworth",
            "Fry"
        )
    )


    questionsList.add(
        QuestionsModel(
            "In the anime 'Demon Slayer,' what is the name of the Hashira known as the Water Hashira?",
            "Giyu Tomioka",
            "Kanao Tsuyuri",
            "Muichiro Tokito",
            "Shinobu Kocho",
            "Giyu Tomioka"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a young boy named Miguel who dreams of becoming a musician and finds himself in the Land of the Dead?",
            "Coco",
            "Brave",
            "Toy Story 3",
            "Moana",
            "Coco"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Dragon Ball Z,' who is the prince of the Saiyan race and Vegeta's eternal rival?",
            "Goku",
            "Piccolo",
            "Trunks",
            "Frieza",
            "Goku"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the anime 'Tokyo Ghoul,' who becomes a half-ghoul after a chance encounter with one?",
            "Kaneki Ken",
            "Touka Kirishima",
            "Hideyoshi Nagachika",
            "Rize Kamishiro",
            "Kaneki Ken"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series follows the adventures of a group of kids with elemental powers who protect the world from dark forces?",
            "W.I.T.C.H.",
            "Totally Spies!",
            "Captain Planet",
            "ThunderCats",
            "Captain Planet"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Neon Genesis Evangelion,' what is the name of the Eva pilot who pilots Unit 02?",
            "Asuka Langley Soryu",
            "Rei Ayanami",
            "Shinji Ikari",
            "Mari Illustrious Makinami",
            "Asuka Langley Soryu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Bob's Burgers'?",
            "Linda Belcher",
            "Tina Belcher",
            "Bob Belcher",
            "Louise Belcher",
            "Bob Belcher"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Hunter x Hunter,' what is the name of the card game that Gon and his friends play during the Greed Island arc?",
            "Duel Monsters",
            "Magic: The Gathering",
            "Gungi",
            "Heavens Arena",
            "Gungi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'My Hero Academia,' what is the superhero name of Shota Aizawa, the U.A. High School teacher with the ability to erase quirks?",
            "Present Mic",
            "Cementoss",
            "Eraser Head",
            "Midnight",
            "Eraser Head"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a young boy named Arthur who discovers that he is the rightful heir to the throne of the Minimoys?",
            "Arthur and the Invisibles",
            "The Secret of NIMH",
            "The Sword in the Stone",
            "The Black Cauldron",
            "Arthur and the Invisibles"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Dragon Ball,' what is the name of the fictional world where the majority of the series takes place?",
            "Earthland",
            "Middle-earth",
            "Konohagakure",
            "Dragon World",
            "Dragon World"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'The Flintstones'?",
            "Barney Rubble",
            "Fred Flintstone",
            "Wilma Flintstone",
            "Betty Rubble",
            "Fred Flintstone"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Tokyo Ghoul,' what is the name of the ghoul who wears a Jason mask and becomes one of Kaneki's most formidable opponents?",
            "Rize Kamishiro",
            "Touka Kirishima",
            "Yakumo Oomori",
            "Ayato Kirishima",
            "Yakumo Oomori"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series follows the adventures of a young boy with a magical cap that can transport him anywhere in the world?",
            "The Magic School Bus",
            "Chip 'n Dale: Rescue Rangers",
            "Wander Over Yonder",
            "Magi-Nation",
            "Wander Over Yonder"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'One Punch Man,' what is the name of the Hero Association's highest-ranked hero?",
            "Silver Fang",
            "Tornado of Terror",
            "Blast",
            "King",
            "Blast"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'South Park'?",
            "Stan Marsh",
            "Eric Cartman",
            "Kyle Broflovski",
            "Kenny McCormick",
            "Stan Marsh"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the anime 'Black Clover,' what is Asta's unique trait that distinguishes him in a world of magic users?",
            "Super Strength",
            "Anti-Magic",
            "Teleportation",
            "Shape-Shifting",
            "Anti-Magic"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a young lion named Simba who must reclaim his throne from his uncle Scar?",
            "The Lion King",
            "Madagascar",
            "The Jungle Book",
            "Ice Age",
            "The Lion King"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Attack on Titan,' what is the name of Eren Yeager's adoptive sister who can transform into a Titan?",
            "Mikasa Ackerman",
            "Armin Arlert",
            "Historia Reiss",
            "Annie Leonhart",
            "Historia Reiss"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Family Guy'?",
            "Peter Griffin",
            "Lois Griffin",
            "Stewie Griffin",
            "Brian Griffin",
            "Peter Griffin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Fullmetal Alchemist: Brotherhood,' what is the name of the homunculus who represents Greed?",
            "Envy",
            "Lust",
            "Sloth",
            "Gluttony",
            "Greed"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series features a group of kids with unique elemental powers who are chosen to defend the world from an evil force?",
            "Captain Planet",
            "Avatar: The Last Airbender",
            "W.I.T.C.H.",
            "Totally Spies!",
            "Avatar: The Last Airbender"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Cowboy Bebop,' what is the name of the mysterious woman who travels with the bounty hunter Spike Spiegel?",
            "Faye Valentine",
            "Ed",
            "Julia",
            "Vicious",
            "Faye Valentine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the anime 'Dr. Stone,' aiming to rebuild civilization after a mysterious event turns humanity to stone?",
            "Senku Ishigami",
            "Taiju Oki",
            "Yuzuriha Ogawa",
            "Tsukasa Shishio",
            "Senku Ishigami"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated film features a young girl named Chihiro who becomes trapped in a mysterious and magical world?",
            "Spirited Away",
            "Howl's Moving Castle",
            "Princess Mononoke",
            "My Neighbor Totoro",
            "Spirited Away"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'Hunter x Hunter,' what is the name of Gon's fishing rod, which he also uses as a weapon?",
            "Kurapika",
            "Leorio",
            "Hisoka",
            "Biscuit",
            "Hisoka"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the main character in the animated TV series 'Scooby-Doo, Where Are You!'?",
            "Shaggy Rogers",
            "Fred Jones",
            "Velma Dinkley",
            "Scooby-Doo",
            "Scooby-Doo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In 'One Piece,' what is the name of the legendary treasure said to grant immense power and wealth to its possessor?",
            "Grand Line",
            "Devil Fruit",
            "One Piece",
            "Poneglyph",
            "One Piece"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which animated series features a group of friends who embark on a quest to find a magical amulet and defend their town from dark forces?",
            "Magi-Nation",
            "The Owl House",
            "W.I.T.C.H.",
            "Trollhunters",
            "Trollhunters"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Which social media platform is known for its short-form videos, often featuring dance challenges and lip-syncing?",
            "Instagram",
            "YouTube",
            "Twitter",
            "TikTok",
            "TikTok"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what feature allows users to share multiple photos and videos in a single post?",
            "Stories",
            "IGTV",
            "Reels",
            "Carousel",
            "Carousel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the co-founder of YouTube, which has become a major platform for video content creators?",
            "Mark Zuckerberg",
            "Elon Musk",
            "Chad Hurley",
            "Jack Dorsey",
            "Chad Hurley"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what term is commonly used for the action of liking a video by tapping the heart icon?",
            "Double-tap",
            "Heartbeat",
            "Likequake",
            "Heartflip",
            "Double-tap"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which social media platform introduced the concept of 'IGTV,' a long-form video format for content creators?",
            "Facebook",
            "Snapchat",
            "Instagram",
            "Twitter",
            "Instagram"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for a video that is sponsored by a company or brand, typically featuring product placements?",
            "Advertorial",
            "Sponsored Content",
            "Product Video",
            "Branded Vlog",
            "Sponsored Content"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the world of TikTok, what does the acronym 'FYP' stand for?",
            "For Your Playlist",
            "Funky Yellow Pineapple",
            "For Your Pet",
            "For You Page",
            "For You Page"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which social media platform is known for its 'Explore' page, where users can discover trending content and interests?",
            "Facebook",
            "Instagram",
            "Twitter",
            "TikTok",
            "Instagram"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the highest level of recognition for channels with over 100 million subscribers?",
            "Diamond Play Button",
            "Golden Play Button",
            "Platinum Play Button",
            "Ruby Play Button",
            "Diamond Play Button"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the maximum duration for a single video on TikTok?",
            "15 seconds",
            "30 seconds",
            "60 seconds",
            "90 seconds",
            "60 seconds"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what type of content disappears after 24 hours and is often used for sharing daily updates?",
            "Reels",
            "IGTV",
            "Stories",
            "Highlights",
            "Stories"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which social media platform is famous for its 'YouTube Rewind' videos summarizing the most popular trends and creators of the year?",
            "Instagram",
            "Twitter",
            "YouTube",
            "TikTok",
            "YouTube"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for a popular dance or challenge that many users participate in and recreate?",
            "Trend",
            "Challenge",
            "DanceWave",
            "ViralMove",
            "Trend"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the most-followed person on Instagram as of 2023?",
            "Dwayne 'The Rock' Johnson",
            "Kylie Jenner",
            "Cristiano Ronaldo",
            "Selena Gomez",
            "Cristiano Ronaldo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the money earned by creators from ads and other revenue streams?",
            "Views Income",
            "Ad Revenue",
            "Content Cash",
            "Monetization Money",
            "Ad Revenue"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which social media platform was originally known for its 6-second looping videos before expanding to longer content?",
            "Vine",
            "Snapchat",
            "TikTok",
            "Twitter",
            "Vine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the name of the feature that allows users to duet with and react to other people's videos?",
            "ReactMode",
            "DuetView",
            "ReplyRap",
            "Duet",
            "Duet"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which social media platform uses the term 'YouTuber' to refer to individuals who create and share video content?",
            "Instagram",
            "YouTube",
            "TikTok",
            "Snapchat",
            "YouTube"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the feature that allows users to save and organize their favorite posts in collections?",
            "Saved Posts",
            "Collections",
            "Bookmarks",
            "Favorites",
            "Collections"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the youngest person to reach 100 million followers on TikTok as of 2023?",
            "Charli D'Amelio",
            "Addison Rae",
            "Loren Gray",
            "Bella Poarch",
            "Charli D'Amelio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What dance challenge went viral on TikTok, featuring a series of coordinated hand movements set to the song 'Lottery' by K CAMP?",
            "Renegade",
            "Savage Love",
            "Say So",
            "Lottery",
            "Renegade"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok trend involves users transforming from casual attire to more glamorous outfits, often set to the song 'Lottery' by K CAMP?",
            "Glow Up Challenge",
            "Outfit Transformation",
            "Style Shift",
            "Fashion Flip",
            "Glow Up Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for popularizing the 'Wipe It Down' challenge on TikTok, where users clean a mirror to reveal a different version of themselves?",
            "Addison Rae",
            "Charli D'Amelio",
            "Loren Gray",
            "Bella Poarch",
            "Bella Poarch"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok dance trend involves users performing a series of arm movements and body rolls to the song 'Say So' by Doja Cat?",
            "Renegade",
            "Savage Love",
            "Say So",
            "Lottery",
            "Say So"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the creator behind the 'Renegade' dance, one of the most popular TikTok dances that went viral in 2020?",
            "Charli D'Amelio",
            "Addison Rae",
            "Lil Huddy",
            "Jalaiah Harmon",
            "Jalaiah Harmon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the TikTok trend where users recreate famous movie scenes, often with unexpected twists or creative edits?",
            "Movie Magic Challenge",
            "Scene Stealer Challenge",
            "Film Flip Trend",
            "Cinema Sync Challenge",
            "Movie Magic Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok trend involves users transforming into different characters or personas, often using dramatic makeup and clothing changes?",
            "Character Challenge",
            "Persona Shift Trend",
            "Roleplay Revolution",
            "Character Switch Challenge",
            "Character Switch Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for popularizing the 'Savage Love' dance on TikTok, which features a catchy dance routine set to the song by Jawsh 685 and Jason Derulo?",
            "Addison Rae",
            "Charli D'Amelio",
            "Loren Gray",
            "Bella Poarch",
            "Addison Rae"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the TikTok trend where users showcase their artistic talents, often transforming ordinary objects into impressive creations?",
            "Artistic Expression Trend",
            "Crafty Creations Challenge",
            "Artistic Transformation",
            "Object Art Challenge",
            "Artistic Transformation"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their comedic lip-syncing and expressive face, often using popular sound bites in their videos?",
            "Spencer X",
            "Brittany Broski",
            "Larray",
            "Michael Le",
            "Brittany Broski"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What TikTok trend involves users showcasing their pet's reaction to various stimuli, often set to the song 'Pet Your Pets' by The Living Tombstone?",
            "Pet Reaction Challenge",
            "Animal Antics Trend",
            "Pet Play Challenge",
            "Pet Your Pets Challenge",
            "Pet Your Pets Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for popularizing the 'Say So' dance on TikTok, a choreographed routine set to the song by Doja Cat?",
            "Charli D'Amelio",
            "Addison Rae",
            "Loren Gray",
            "Bella Poarch",
            "Charli D'Amelio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the TikTok trend where users showcase their favorite makeup transformations, often accompanied by a transition effect?",
            "Glam Glow Challenge",
            "Makeup Magic Trend",
            "Cosmetic Conjuring Challenge",
            "Beauty Transition Challenge",
            "Beauty Transition Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for popularizing the 'Oh No' dance trend on TikTok, where users imitate a surprised expression and hand movement?",
            "Addison Rae",
            "Charli D'Amelio",
            "Loren Gray",
            "Bella Poarch",
            "Bella Poarch"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What TikTok trend involves users showcasing their favorite outfits or fashion styles, often set to the song 'Outfit Transition' by Talia Mar?",
            "Style Swap Challenge",
            "Fashion Forward Trend",
            "Outfit Transition Challenge",
            "Closet Chronicles Challenge",
            "Outfit Transition Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for popularizing the 'Savage' dance trend on TikTok, which features a sassy dance routine set to the song by Megan Thee Stallion?",
            "Charli D'Amelio",
            "Addison Rae",
            "Loren Gray",
            "Keke Palmer",
            "Keke Palmer"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the TikTok trend where users showcase their favorite cooking or baking recipes, often with a time-lapse effect?",
            "Food Fiesta Challenge",
            "Cooking Chronicles Trend",
            "Recipe Revival Challenge",
            "Cooking Time-lapse Challenge",
            "Cooking Time-lapse Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for popularizing the 'Laxed (Siren Beat)' dance trend on TikTok, a dance routine featuring a relaxed and laid-back style?",
            "Charli D'Amelio",
            "Addison Rae",
            "Loren Gray",
            "Jalaiah Harmon",
            "Jalaiah Harmon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What TikTok trend involves users showcasing their impressive DIY projects or creative crafts, often set to the song 'Crafting Vibes'?",
            "DIY Delight Challenge",
            "Crafty Creations Trend",
            "Artisan Showcase Challenge",
            "Crafting Vibes Challenge",
            "Crafting Vibes Challenge"
        )
    )


    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the maximum number of hashtags allowed in a single caption?",
            "20",
            "30",
            "40",
            "50",
            "30"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its intricate and mind-bending puzzle videos, challenging viewers to solve complex riddles?",
            "Vsauce",
            "Veritasium",
            "Numberphile",
            "Kurzgesagt",
            "Vsauce"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the name of the effect that allows users to clone themselves in a video?",
            "Clone Me",
            "Doppelganger",
            "Mirror Magic",
            "Multiplicity",
            "Multiplicity"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first YouTuber to reach 100 million subscribers?",
            "PewDiePie",
            "T-Series",
            "Cocomelon",
            "Dude Perfect",
            "PewDiePie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the minimum age requirement for creating an account?",
            "10",
            "12",
            "13",
            "16",
            "13"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their intricate and visually stunning stop-motion animation videos?",
            "@itsjojosiwa",
            "@hollyh",
            "@katybell",
            "@nyannyancosplay",
            "@hollyh"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the algorithm that recommends videos based on a user's previous watch history?",
            "WatchStream Algorithm",
            "Suggested Videos AI",
            "Video Discovery Engine",
            "Recommendation Algorithm",
            "Recommendation Algorithm"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to shop for products directly through the app?",
            "Shop Now",
            "Explore Marketplace",
            "Instagram Store",
            "Shopping in Style",
            "Shop Now"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the founder of TikTok's parent company, ByteDance?",
            "Zhang Yiming",
            "Mark Zuckerberg",
            "Evan Spiegel",
            "Jack Dorsey",
            "Zhang Yiming"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the name of the prestigious award given to channels that surpass 50 million subscribers?",
            "Diamond Play Button",
            "Titanium Play Button",
            "Emerald Play Button",
            "Crystal Play Button",
            "Emerald Play Button"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok trend involves users creating optical illusions and mind-bending visual effects?",
            "Optical Oddities Challenge",
            "Visual Vortex Trend",
            "Illusion Insanity Challenge",
            "Mind Warp Madness Trend",
            "Illusion Insanity Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the maximum duration for a video post on the main feed?",
            "45 seconds",
            "1 minute",
            "2 minutes",
            "3 minutes",
            "1 minute"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its complex and detailed explanations of various scientific phenomena, often featuring Michael Stevens?",
            "Veritasium",
            "Vsauce",
            "MinutePhysics",
            "In a Nutshell",
            "Vsauce"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to stitch together multiple clips into a longer video?",
            "Montage Mode",
            "Story Stitch",
            "Clip Connect",
            "Duet",
            "Duet"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who holds the record for the most-watched YouTube video of all time as of 2023?",
            "Baby Shark - Pinkfong",
            "Despacito - Luis Fonsi",
            "Gangnam Style - PSY",
            "See You Again - Wiz Khalifa ft. Charlie Puth",
            "Baby Shark - Pinkfong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to highlight and pin specific stories to their profile?",
            "Story Spotlight",
            "Highlight Hub",
            "Profile Pin",
            "Story Archive",
            "Story Archive"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their mind-bending and reality-bending visual effects, often featuring illusions and surreal scenarios?",
            "@lilmiquela",
            "@hollyh",
            "@nyannyancosplay",
            "@brittany_broski",
            "@hollyh"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the YouTube series where creators collaborate to solve complex puzzles and riddles, often involving hidden messages and codes?",
            "Solve It Together",
            "The Great Puzzle Quest",
            "The Enigma Collaboration",
            "Internet Mysteries",
            "Internet Mysteries"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the name of the effect that allows users to create a mirrored reflection of themselves, often used in dance challenges?",
            "Mirror Me",
            "Reflect Effect",
            "Dance Mirror",
            "Mirror Magic",
            "Mirror Magic"
        )
    )
    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the name of the effect that allows users to create a mirrored reflection of themselves, often used in dance challenges?",
            "Mirror Me",
            "Reflect Effect",
            "Dance Mirror",
            "Mirror Magic",
            "Mirror Magic"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first creator to reach 1 billion likes on TikTok?",
            "@charlidamelio",
            "@addisonre",
            "@bella.poarch",
            "@zachking",
            "@charlidamelio"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageTwelve(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the maximum number of characters allowed in a single caption?",
            "220",
            "240",
            "260",
            "280",
            "220"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its in-depth analysis and critique of various internet content, often featuring Lindsay Ellis?",
            "Nerdwriter1",
            "ContraPoints",
            "Pop Culture Detective",
            "YourMovieSucksDOTorg",
            "Nerdwriter1"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to make objects or people disappear using a virtual invisibility cloak?",
            "InvisoEffect",
            "DisappearDuet",
            "VanishVision",
            "StealthMode",
            "InvisoEffect"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first YouTube creator to reach 10 billion views on their channel?",
            "PewDiePie",
            "T-Series",
            "Cocomelon",
            "Dude Perfect",
            "Cocomelon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to follow specific hashtags, keeping up with content related to their interests?",
            "Hashtag Hubs",
            "Followable Tags",
            "Tag Tracks",
            "Following Hashtags",
            "Following Hashtags"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their avant-garde and abstract short films, often experimenting with surreal visuals and themes?",
            "@jojii",
            "@katybell",
            "@liascottprice",
            "@madmavenmedia",
            "@liascottprice"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the name of the algorithm that determines the order in which videos appear on the 'Trending' page?",
            "TrendRank",
            "PopularNow Algorithm",
            "TrendingTopics Engine",
            "Trending Algorithm",
            "Trending Algorithm"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to create and share collaborative photo albums with multiple contributors?",
            "Group Albums",
            "Collab Collections",
            "Shared Stories",
            "Community Captures",
            "Group Albums"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the CEO of TikTok's parent company, ByteDance, as of 2023?",
            "Zhang Yiming",
            "Kevin Mayer",
            "Mark Zuckerberg",
            "Evan Spiegel",
            "Zhang Yiming"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the highest level of membership in the YouTube Partner Program, offering exclusive perks to top creators?",
            "Diamond Tier",
            "Gold Membership",
            "YouTube Elite",
            "YouTube Red Status",
            "Diamond Tier"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok trend involves users creating intricate and visually appealing 3D animations using the app's effects and tools?",
            "DimensionalDance Challenge",
            "3D Animation Trend",
            "AugmentedReality Wave",
            "TikTok AR Challenge",
            "3D Animation Trend"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the maximum duration for a video post in a Story?",
            "15 seconds",
            "30 seconds",
            "45 seconds",
            "1 minute",
            "15 seconds"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its intricate and detailed exploration of online mysteries, often featuring Shane Madej and Ryan Bergara?",
            "Nexpo",
            "BuzzFeed Unsolved",
            "Barely Sociable",
            "Night Mind",
            "BuzzFeed Unsolved"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to create a cinematic black-and-white video with a color-highlighted element?",
            "Film Noir Effect",
            "Vintage Vibes Trend",
            "Monochrome Magic",
            "SpotColor Effect",
            "SpotColor Effect"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first Instagram user to reach 500 million followers?",
            "@cristiano",
            "@therock",
            "@selenagomez",
            "@kyliejenner",
            "@selenagomez"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to create and sell exclusive merchandise directly from their channel?",
            "YouTube Storefront",
            "Merchandise Showcase",
            "Channel Shop",
            "Merch Shelf",
            "Merch Shelf"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their avant-garde and surreal comedy sketches, often involving unexpected twists and unconventional humor?",
            "@daviddobrik",
            "@kingbach",
            "@lilmiquela",
            "@brittany_broski",
            "@kingbach"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the YouTube series where creators collaborate to produce high-quality short films within a limited timeframe?",
            "Film Fest Frenzy",
            "YouTube Cinematics",
            "Collab Film Challenge",
            "Short Film Showdown",
            "Short Film Showdown"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to create a trail of virtual footprints following their movements in a video?",
            "Footprint Filter",
            "TrailTrack Effect",
            "Motion Prints Trend",
            "Footstep Animation",
            "Motion Prints Trend"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first YouTube creator to receive the Diamond Play Button, awarded for surpassing 10 million subscribers?",
            "PewDiePie",
            "T-Series",
            "Cocomelon",
            "Dude Perfect",
            "PewDiePie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to create and share 3D photos using depth-sensing technology?",
            "DepthGram",
            "Insta3D",
            "PhotoPhantasm",
            "3D InstaVision",
            "DepthGram"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its experimental and avant-garde music videos, often featuring abstract visuals and unconventional storytelling?",
            "OK Go",
            "Radiohead",
            "Gorillaz",
            "Tool",
            "OK Go"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to create an animated, glowing aura around their body in videos?",
            "Aura Animation",
            "Glowing Halo Trend",
            "Radiant Aura Effect",
            "Luminous Glow Animation",
            "Radiant Aura Effect"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first YouTube creator to reach 40 billion views on their channel?",
            "PewDiePie",
            "T-Series",
            "Cocomelon",
            "Dude Perfect",
            "PewDiePie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to create and share interactive quizzes in their Stories?",
            "QuizMaster",
            "Interactive Q&A",
            "Quiz Stickers",
            "Trivia Time",
            "Quiz Stickers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their elaborate and mind-bending cosplay transformations, often featuring characters from various genres?",
            "@lararoscosplay",
            "@hendoart",
            "@ahegaohayden",
            "@taramossfit",
            "@ahegaohayden"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that automatically plays recommended videos while the user is watching a video in full-screen mode?",
            "AutoPlay",
            "ContinuousPlay",
            "Suggested Stream",
            "PlayOnLoop",
            "AutoPlay"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to create and share polls in their Stories, engaging with their audience?",
            "Interactive Polls",
            "Pollinator",
            "EngageSurveys",
            "Poll Stickers",
            "Poll Stickers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the CEO of TikTok's parent company, ByteDance, as of 2023?",
            "Zhang Yiming",
            "Kevin Mayer",
            "Mark Zuckerberg",
            "Evan Spiegel",
            "Zhang Yiming"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that highlights a creator's most dedicated fans, allowing them to interact more closely with the channel?",
            "Fan Connect",
            "Super Fans Club",
            "YouTube Supporters",
            "Memberships",
            "Memberships"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok trend involves users creating intricate and visually stunning stop-motion animations, often using everyday objects?",
            "StopAndStun Challenge",
            "ObjectMotion Trend",
            "Everyday Animation",
            "TikTok Stop-Motion",
            "StopAndStun Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the maximum number of characters allowed in a direct message?",
            "1000",
            "2000",
            "3000",
            "4000",
            "1000"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its investigative journalism and deep dives into internet mysteries, often featuring the host ReignBot?",
            "Night Docs",
            "Dark Web Chronicles",
            "Mysteries Unveiled",
            "Night Mind",
            "Night Mind"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to create a video that changes based on viewer interaction, creating multiple possible outcomes?",
            "Interactive Video",
            "Choose Your Adventure",
            "Branching Clips",
            "Alternate Endings",
            "Choose Your Adventure"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first Instagram user to reach 1 billion followers?",
            "@cristiano",
            "@therock",
            "@selenagomez",
            "@kyliejenner",
            "@selenagomez"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to share behind-the-scenes content, exclusive updates, and more with their subscribers?",
            "Backstage Pass",
            "Subscriber Exclusives",
            "Channel Extras",
            "Community Posts",
            "Community Posts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their avant-garde and surreal poetry performances, often using creative visual effects and spoken word?",
            "@rudyfrancisco",
            "@katybell",
            "@liascottprice",
            "@madmavenmedia",
            "@rudyfrancisco"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the YouTube series where creators compete in various challenges to win the coveted 'YouTube Cup'?",
            "Challenge Champs",
            "YouTube Rivals",
            "Content Clash",
            "Tube Wars",
            "YouTube Rivals"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to create a trail of virtual sparkles or stars following their movements in a video?",
            "Starry Night Effect",
            "Magic Trail Trend",
            "Sparkle Motion",
            "GlowTrail Animation",
            "GlowTrail Animation"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first YouTube creator to receive the Diamond Play Button, awarded for surpassing 10 million subscribers?",
            "PewDiePie",
            "T-Series",
            "Cocomelon",
            "Dude Perfect",
            "PewDiePie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to create and share augmented reality effects, such as face filters and animations?",
            "AR Studio",
            "Reality Renditions",
            "Filter Forge",
            "Augmented Artistry",
            "AR Studio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its immersive and interactive storytelling videos, often allowing viewers to choose the direction of the narrative?",
            "Choose Your Story",
            "Interactive Cinema",
            "StoryScape",
            "Narrative Nexus",
            "StoryScape"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to create videos with an augmented reality background, changing their environment?",
            "AR Backdrops",
            "EnviroEnhance",
            "Background Boost",
            "Immersive Scenes",
            "AR Backdrops"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first YouTube creator to reach 50 billion views on their channel?",
            "PewDiePie",
            "T-Series",
            "Cocomelon",
            "Dude Perfect",
            "PewDiePie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to schedule and organize their posts for optimal engagement?",
            "OptiPost",
            "ScheduStrategize",
            "PostPlanner Pro",
            "Strategic Scheduling",
            "Strategic Scheduling"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their mind-bending visual effects and illusions, often featuring impossible scenarios and magic tricks?",
            "@zachking",
            "@chrismagic",
            "@visual_vibes",
            "@illusionaryartist",
            "@zachking"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that recommends videos based on the user's facial expressions and emotional reactions?",
            "Emotion Explorer",
            "FaceReel Recommendations",
            "MoodMatch Suggestions",
            "EmoView Insights",
            "EmoView Insights"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to create and share 360-degree photos and videos, providing an immersive viewing experience?",
            "360 Vision",
            "ImmerseGram",
            "Panorama Plus",
            "360 Posts",
            "360 Posts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the CEO of TikTok's parent company, ByteDance, as of 2023?",
            "Zhang Yiming",
            "Kevin Mayer",
            "Mark Zuckerberg",
            "Evan Spiegel",
            "Zhang Yiming"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to invite viewers to join them in a live video, creating a collaborative streaming experience?",
            "Live Duo",
            "CollabCast",
            "StreamShare",
            "Live Collab",
            "StreamShare"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok trend involves users creating intricate and visually stunning 4D illusions, often using mirrors and creative camera angles?",
            "MirrorMystique Challenge",
            "4D Illusion Trend",
            "Reflective Reality",
            "Infinity Illusions",
            "MirrorMystique Challenge"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the maximum number of hashtags allowed in a single post?",
            "20",
            "30",
            "40",
            "50",
            "30"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its interactive mystery series, where viewers can participate in solving puzzles and determining the story's outcome?",
            "SolveIt Series",
            "Mystery Quest",
            "Interactive Enigma",
            "Clever Clues",
            "SolveIt Series"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to create a video with an animated, virtual version of themselves, known as a 'digital twin'?",
            "TwinTech Animation",
            "Digital Doppelganger",
            "CloneCraft Effect",
            "MirrorMe Animation",
            "Digital Doppelganger"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first Instagram user to reach 2 billion followers?",
            "@cristiano",
            "@therock",
            "@selenagomez",
            "@kyliejenner",
            "@cristiano"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to conduct live polls during their videos, engaging with the audience in real-time?",
            "Live Polls",
            "Interactive Voting",
            "Polls OnAir",
            "Audience Choice",
            "Live Polls"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which TikTok creator is known for their avant-garde and surreal virtual reality experiences, often featuring mind-bending landscapes and abstract concepts?",
            "@vr_visionary",
            "@mindmeltVR",
            "@virtualvoyager",
            "@neural_navigator",
            "@mindmeltVR"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the YouTube series where creators compete in various challenges using advanced technology, such as virtual reality and augmented reality?",
            "TechTrials",
            "Future Feats",
            "Digital Challenges",
            "Reality Rivals",
            "Reality Rivals"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the effect that allows users to create a video with a shifting, kaleidoscopic background, adding a mesmerizing visual element?",
            "KaleidoFlow Effect",
            "Mystic Mirage Trend",
            "PsychedelicShift Animation",
            "IllusionBlitz Effect",
            "KaleidoFlow Effect"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is the first YouTube creator to receive the Diamond Play Button, awarded for surpassing 10 million subscribers?",
            "PewDiePie",
            "T-Series",
            "Cocomelon",
            "Dude Perfect",
            "PewDiePie"
        )
    )


    questionsList.add(
        QuestionsModel(
            "In the game 'The Legend of Zelda: Ocarina of Time,' what is the name of Link's fairy companion?",
            "Navi",
            "Tatl",
            "Midna",
            "Fi",
            "Navi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which popular video game franchise features a protagonist named Master Chief?",
            "Halo",
            "Call of Duty",
            "Battlefield",
            "Destiny",
            "Halo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the main objective in the game 'Minecraft'?",
            "Survive and build structures",
            "Defeat the Ender Dragon",
            "Collect power stars",
            "Rescue Princess Peach",
            "Survive and build structures"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Final Fantasy VII,' what is the name of Cloud Strife's iconic sword?",
            "Excalibur",
            "Buster Sword",
            "Masamune",
            "Oblivion",
            "Buster Sword"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which popular game features a battle royale mode where 100 players compete to be the last one standing?",
            "Fortnite",
            "Apex Legends",
            "PlayerUnknown's Battlegrounds",
            "Call of Duty: Warzone",
            "Fortnite"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the protagonist in the game 'The Witcher 3: Wild Hunt'?",
            "Geralt of Rivia",
            "Ezio Auditore",
            "Aloy",
            "Joel",
            "Geralt of Rivia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which video game series is known for its elaborate space opera setting and features Commander Shepard as the main character?",
            "Mass Effect",
            "Star Wars: Knights of the Old Republic",
            "Dead Space",
            "Elite Dangerous",
            "Mass Effect"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Super Mario Bros.,' what item allows Mario to grow larger?",
            "Mushroom",
            "Fire Flower",
            "Starman",
            "1-Up Mushroom",
            "Mushroom"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the virtual reality headset developed by Valve Corporation in collaboration with HTC?",
            "PlayStation VR",
            "Oculus Rift",
            "Valve VR",
            "Vive",
            "Vive"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features the character Kratos, who seeks revenge against the gods of Olympus?",
            "God of War",
            "Assassin's Creed",
            "Dark Souls",
            "Shadow of the Colossus",
            "God of War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the iconic protagonist in the 'Metal Gear Solid' series created by Hideo Kojima?",
            "Solid Snake",
            "Big Boss",
            "Liquid Snake",
            "Venom Snake",
            "Solid Snake"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features a young explorer named Lara Croft searching for ancient artifacts in dangerous tombs?",
            "Uncharted",
            "Assassin's Creed",
            "Tomb Raider",
            "Prince of Persia",
            "Tomb Raider"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Overwatch,' what is the name of the intelligent gorilla character who is also a scientist?",
            "Winston",
            "Reinhardt",
            "Zenyatta",
            "Hanzo",
            "Winston"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game is often credited with popularizing the battle royale genre and features a shrinking play area?",
            "Apex Legends",
            "PlayerUnknown's Battlegrounds",
            "Fortnite",
            "H1Z1",
            "PlayerUnknown's Battlegrounds"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the main character in the game 'Half-Life' and its sequels?",
            "Gordon Freeman",
            "Alex Vance",
            "Barney Calhoun",
            "Eli Vance",
            "Gordon Freeman"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game franchise is known for its real-time strategy (RTS) gameplay and features factions like the Zerg, Protoss, and Terran?",
            "Age of Empires",
            "Civilization",
            "StarCraft",
            "Warcraft",
            "StarCraft"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Dark Souls,' what is the infamous tagline that warns players of the game's difficulty?",
            "Prepare to Live",
            "Suffer and Persevere",
            "Prepare to Die",
            "Fight or Fall",
            "Prepare to Die"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features a dystopian city named Rapture and involves genetic modifications known as 'plasmids'?",
            "Bioshock",
            "Deus Ex",
            "System Shock",
            "Dishonored",
            "Bioshock"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the main character in the game 'Assassin's Creed' who relives the memories of his ancestors through a device called the Animus?",
            "Altair",
            "Ezio Auditore",
            "Connor Kenway",
            "Desmond Miles",
            "Desmond Miles"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features a protagonist named Aloy who explores a post-apocalyptic world inhabited by robotic creatures?",
            "Horizon Zero Dawn",
            "Fallout 4",
            "The Last of Us",
            "Far Cry Primal",
            "Horizon Zero Dawn"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Dark Souls,' what is the name of the final boss in the Artorias of the Abyss DLC?",
            "Manus, Father of the Abyss",
            "Kalameet, the Black Dragon",
            "Knight Artorias",
            "Sanctuary Guardian",
            "Manus, Father of the Abyss"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the main character in the game 'Nier: Automata' who fights against machine lifeforms?",
            "2B",
            "9S",
            "A2",
            "Emil",
            "2B"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the 'Metal Gear Solid' series, what is the codename given to the genetically enhanced soldiers with enhanced abilities?",
            "Genome Soldiers",
            "Super Soldiers",
            "Foxhound Operatives",
            "Nano Soldiers",
            "Genome Soldiers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game in the 'Resident Evil' series introduced the character Albert Wesker as an antagonist?",
            "Resident Evil 2",
            "Resident Evil 3: Nemesis",
            "Resident Evil Code: Veronica",
            "Resident Evil 1",
            "Resident Evil Code: Veronica"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the mysterious being that guides the player in the game 'Journey' and communicates with musical chimes?",
            "Architect",
            "The Traveler",
            "Guardian of the Sands",
            "Ancient Guide",
            "The Traveler"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Bloodborne,' what is the name of the nightmare realm where the player encounters the Great One, Mergo?",
            "Nightmare of Mensis",
            "Hunter's Nightmare",
            "Nightmare Frontier",
            "Nightmare Slain",
            "Nightmare of Mensis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the main character in the game 'Spec Ops: The Line,' who experiences the psychological effects of war?",
            "Captain Martin Walker",
            "Lt. John Konrad",
            "Sergeant Lugo",
            "Colonel Conrad Cross",
            "Captain Martin Walker"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the 'Final Fantasy' series, what is the name of the powerful summon that often appears as a horse or unicorn?",
            "Bahamut",
            "Shiva",
            "Odin",
            "Ifrit",
            "Odin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features the character Yuri Hyuga, a Harmonixer who can transform into various demons?",
            "Shadow Hearts",
            "Vagrant Story",
            "Xenosaga",
            "Lost Odyssey",
            "Shadow Hearts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Chrono Trigger,' what is the name of the floating, time-traveling creature that aids the party?",
            "Time Gazer",
            "Temporal Guide",
            "Chrono Spirit",
            "Lavos Spawn",
            "Temporal Guide"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageThirteen(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "In the game 'Bloodborne,' what is the name of the eldritch Great One associated with the dream realm and nightmare rituals?",
            "Mergo",
            "Ebrietas",
            "Kos",
            "Rom",
            "Mergo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the antagonist in the game 'Final Fantasy IX,' who aims to assimilate the souls of Gaia and Terra?",
            "Kuja",
            "Garland",
            "Kefka",
            "Sephiroth",
            "Kuja"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the 'Dark Souls' series, what is the name of the firekeeper who tends to the bonfire in Firelink Shrine and assists the player?",
            "Anastacia of Astora",
            "Quelaag's Sister",
            "Chaos Servant",
            "Fair Lady",
            "Anastacia of Astora"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features the character Ethan Winters, who searches for his missing wife and becomes entangled in a biohazardous conspiracy?",
            "Resident Evil 7: Biohazard",
            "Resident Evil 5",
            "Resident Evil 6",
            "Resident Evil 4",
            "Resident Evil 7: Biohazard"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the protagonist in the game 'Alan Wake,' a writer who experiences supernatural events in the town of Bright Falls?",
            "Max Payne",
            "Sam Lake",
            "Jack Joyce",
            "Alan Wake",
            "Alan Wake"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the 'NieR' series, what is the name of the character who serves as a guardian for the protagonist and wears a distinctive Emil head?",
            "Kaine",
            "Devola",
            "Popola",
            "Emil",
            "Emil"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features the character Jack Joyce, who gains time-manipulating abilities in a narrative-driven action-adventure?",
            "Quantum Break",
            "Control",
            "Max Payne 3",
            "TimeShift",
            "Quantum Break"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the 'Final Fantasy' series, what is the name of the airship used by the main party in 'Final Fantasy VII'?",
            "Highwind",
            "Falcon",
            "Dreadnought",
            "Invincible",
            "Highwind"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the hostile alien race in the 'XCOM' series, known for their relentless invasion of Earth?",
            "The Elders",
            "The Outsiders",
            "The Sectoids",
            "The Ethereals",
            "The Ethereals"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game in the 'Dragon Age' series features the character Solas, an elven mage with a deep connection to the Fade and the Veil?",
            "Dragon Age: Origins",
            "Dragon Age II",
            "Dragon Age: Inquisition",
            "Dragon Age: Awakening",
            "Dragon Age: Inquisition"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Star Wars: Knights of the Old Republic,' what is the true identity of the character Darth Revan?",
            "Revan is a Jedi",
            "Revan is a Sith",
            "Revan is an Ancient",
            "Revan is a Droid",
            "Revan is a Jedi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the city in the game 'Bioshock' that is built at the bottom of the ocean and is ruled by the mysterious Andrew Ryan?",
            "Rapture",
            "Columbia",
            "Biosphere",
            "Undercity",
            "Rapture"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Demon's Souls,' what is the name of the region ruled by King Allant, who awakened the Old One and unleashed a soul-devouring fog?",
            "Boletaria",
            "Latria",
            "Stonefang",
            "Shrine of Storms",
            "Boletaria"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the AI construct in the 'Halo' series that becomes a central figure in the conflict between humanity and the Covenant?",
            "Cortana",
            "Durandal",
            "ADA",
            "GLaDOS",
            "Cortana"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the game 'Final Fantasy XV,' what is the name of the empire that serves as the primary antagonist, led by Emperor Aldercapt?",
            "Niflheim",
            "Insomnia",
            "Tenebrae",
            "Lucis",
            "Niflheim"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which game features the character Jill Valentine, a member of S.T.A.R.S. who battles against bioweapons created by the Umbrella Corporation?",
            "Resident Evil 2",
            "Resident Evil 3: Nemesis",
            "Resident Evil Code: Veronica",
            "Resident Evil",
            "Resident Evil 3: Nemesis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the mysterious figure in the game 'Death Stranding' who serves as a bridge between the world of the living and the dead?",
            "The Wanderer",
            "The Chiral King",
            "Higgs Monaghan",
            "Amelie",
            "Amelie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the 'Metal Gear Solid' series, what is the name of the organization that Naked Snake creates after the events of 'Metal Gear Solid 3: Snake Eater'?",
            "Outer Heaven",
            "Philanthropy",
            "Diamond Dogs",
            "Militaires Sans Frontières",
            "Militaires Sans Frontières"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the mysterious creature in the game 'Shadow of the Colossus' that the protagonist, Wander, seeks to revive?",
            "Agro",
            "Trico",
            "Phalanx",
            "Dormin",
            "Dormin"
        )
    )



    questionsList.add(
        QuestionsModel(
            "In George Orwell's '1984,' what is the name of the totalitarian regime that controls Oceania?",
            "The Party",
            "The Federation",
            "The Directorate",
            "The Order",
            "The Party"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the surrealist novel 'The Wind-Up Bird Chronicle,' known for its intricate narrative and dreamlike sequences?",
            "Haruki Murakami",
            "Kazuo Ishiguro",
            "Yukio Mishima",
            "Banana Yoshimoto",
            "Haruki Murakami"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the novel 'One Hundred Years of Solitude,' what is the name of the fictional town where the Buendía family experiences generations of magical realism?",
            "Macondo",
            "Gabriel",
            "San Cristobal",
            "Aureliano",
            "Macondo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which science fiction novel features the concept of 'psychohistory,' a mathematical way to predict the future of large populations?",
            "Dune by Frank Herbert",
            "Foundation by Isaac Asimov",
            "Neuromancer by William Gibson",
            "Snow Crash by Neal Stephenson",
            "Foundation by Isaac Asimov"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Salman Rushdie's 'Midnight's Children,' what supernatural ability do the children born at the exact moment of India's independence possess?",
            "Telepathy",
            "Time Travel",
            "Invisibility",
            "Shape-shifting",
            "Telepathy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Master and Margarita,' a satirical work featuring the Devil visiting Moscow with his retinue, including a giant cat named Behemoth?",
            "Fyodor Dostoevsky",
            "Vladimir Nabokov",
            "Mikhail Bulgakov",
            "Leo Tolstoy",
            "Mikhail Bulgakov"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Italo Calvino's 'Invisible Cities,' what is the name of the explorer who describes various fantastical cities to the emperor Kublai Khan?",
            "Marco Polo",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Amerigo Vespucci",
            "Marco Polo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which dystopian novel features a society divided into five factions based on personality traits, and the protagonist, Beatrice Prior, discovering her identity as 'Divergent'?",
            "The Maze Runner by James Dashner",
            "Divergent by Veronica Roth",
            "The Hunger Games by Suzanne Collins",
            "Delirium by Lauren Oliver",
            "Divergent by Veronica Roth"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the imaginary African country that serves as the setting for Chinua Achebe's novel 'Things Fall Apart'?",
            "Wakanda",
            "Zamunda",
            "Ujamaa",
            "Umuofia",
            "Umuofia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'One Flew Over the Cuckoo's Nest,' which explores the power dynamics in a mental institution?",
            "Ken Kesey",
            "Joseph Heller",
            "J.D. Salinger",
            "Kurt Vonnegut",
            "Ken Kesey"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In J.R.R. Tolkien's 'The Silmarillion,' what is the name of the dark lord who corrupts the Elves and seeks control over Middle-earth?",
            "Morgoth",
            "Sauron",
            "Saruman",
            "Gollum",
            "Morgoth"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Gabriel Garcia Marquez tells the story of Florentino Ariza's unrequited love for Fermina Daza and spans over 50 years?",
            "Love in the Time of Cholera",
            "Chronicle of a Death Foretold",
            "The Autumn of the Patriarch",
            "One Hundred Years of Solitude",
            "Love in the Time of Cholera"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional continent where the events of Philip K. Dick's 'The Man in the High Castle' unfold, depicting an alternate history where the Axis powers won World War II?",
            "Europa",
            "Pacifica",
            "Americana",
            "The Pacific States",
            "Americana"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Vladimir Nabokov's 'Lolita,' what is the pseudonym used by the protagonist, Humbert Humbert, to address his obsession and illicit relationship with Dolores Haze?",
            "Quilty",
            "Lo",
            "Haze",
            "Lola",
            "Quilty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'Blindness,' which explores the breakdown of society when a sudden epidemic of blindness strikes a city?",
            "José Saramago",
            "Julian Barnes",
            "Haruki Murakami",
            "Kazuo Ishiguro",
            "José Saramago"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Haruki Murakami's 'Kafka on the Shore,' what supernatural occurrence is associated with the character Nakata, who can talk to cats?",
            "Time Travel",
            "Telekinesis",
            "Precognition",
            "Levitation",
            "Time Travel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by David Foster Wallace features a complex narrative structure and explores themes of entertainment, addiction, and the pursuit of happiness?",
            "Infinite Jest",
            "The Pale King",
            "The Broom of the System",
            "Girl with Curious Hair",
            "Infinite Jest"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional African country in the novel 'Black Leopard, Red Wolf' by Marlon James, known for its rich mythology and fantastical creatures?",
            "Wakanda",
            "Numbani",
            "Zamunda",
            "Griotlands",
            "Griotlands"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the novel 'The Name of the Wind' by Patrick Rothfuss, what is the name of the protagonist, who recounts his life story to a Chronicler over three days?",
            "Kvothe",
            "Denna",
            "Bast",
            "Ambrose",
            "Kvothe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the novel 'House of Leaves' by Mark Z. Danielewski, what is the name of the documentary that the protagonist, Johnny Truant, discovers and becomes obsessed with?",
            "The Navidson Record",
            "The Hollow Film",
            "The Echo Project",
            "The Labyrinth Tapes",
            "The Navidson Record"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Sound and the Fury,' known for its innovative narrative techniques and the Compson family's tragic decline?",
            "F. Scott Fitzgerald",
            "William Faulkner",
            "Ernest Hemingway",
            "Virginia Woolf",
            "William Faulkner"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In H.P. Lovecraft's 'The Call of Cthulhu,' what is the name of the sunken city where the Great Old One, Cthulhu, lies dormant?",
            "R'lyeh",
            "Innsmouth",
            "Arkham",
            "Dunwich",
            "R'lyeh"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Don DeLillo explores the impact of a mysterious airborne toxic event and features characters like Jack and Babette?",
            "White Noise",
            "Libra",
            "Underworld",
            "Mao II",
            "White Noise"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the novel 'Cloud Atlas' by David Mitchell, what is the name of the Pacific island where the character Adam Ewing experiences a series of adventures in the 19th century?",
            "Maui",
            "Easter Island",
            "The Isle of Mann",
            "Chatham Islands",
            "Chatham Islands"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the surreal and experimental novel 'If on a winter's night a traveler,' which tells the story of the reader's journey through multiple unfinished novels?",
            "Jorge Luis Borges",
            "Italo Calvino",
            "Milan Kundera",
            "Gabriel Garcia Marquez",
            "Italo Calvino"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Michael Ende's 'The Neverending Story,' what is the name of the magical land that the young protagonist Bastian discovers through a mysterious book?",
            "Fantasia",
            "Narnia",
            "Eldorado",
            "Avalon",
            "Fantasia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Thomas Pynchon features a character named Tyrone Slothrop and explores conspiracies, paranoia, and the V-2 rocket in World War II?",
            "Gravity's Rainbow",
            "Mason & Dixon",
            "V.",
            "The Crying of Lot 49",
            "Gravity's Rainbow"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the book within a book in Jorge Luis Borges' 'Ficciones,' where the protagonist discovers an infinite library containing every possible book?",
            "The Garden of Forking Paths",
            "The Library of Babel",
            "Tlön, Uqbar, Orbis Tertius",
            "Funes the Memorious",
            "The Library of Babel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'Blood Meridian,' a brutal and existential Western that follows the journey of the Kid and Judge Holden in the American frontier?",
            "Cormac McCarthy",
            "Larry McMurtry",
            "Annie Proulx",
            "Philip Roth",
            "Cormac McCarthy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the novel 'The Shadow of the Wind' by Carlos Ruiz Zafón, what is the name of the secret Cemetery of Forgotten Books, where Daniel discovers a mysterious novel by Julián Carax?",
            "Cementerio de la Recoleta",
            "Cementerio de Montjuïc",
            "Cementerio de las Ánimas",
            "Cementerio de los Libros Olvidados",
            "Cementerio de los Libros Olvidados"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the post-apocalyptic novel by Cormac McCarthy, where a father and son journey through a desolate landscape in search of safety?",
            "The Road",
            "No Country for Old Men",
            "Blood Meridian",
            "All the Pretty Horses",
            "The Road"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Gabriel Garcia Marquez's 'One Hundred Years of Solitude,' what is the name of the magical object that the gypsy Melquíades brings to the town of Macondo?",
            "The Golden Compass",
            "The Philosopher's Stone",
            "The Alchemist's Amulet",
            "The Gypsy's Magnet",
            "The Philosopher's Stone"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by David Mitchell is a sprawling narrative that interweaves six different stories across various time periods and genres, connected by a comet-shaped birthmark?",
            "Ghostwritten",
            "Number9Dream",
            "The Bone Clocks",
            "Cloud Atlas",
            "Cloud Atlas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the postmodern novel 'Mason & Dixon,' which follows the exploits of the surveyors Charles Mason and Jeremiah Dixon in the 18th century?",
            "Thomas Pynchon",
            "David Foster Wallace",
            "Don DeLillo",
            "Jonathan Franzen",
            "Thomas Pynchon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Haruki Murakami's 'Norwegian Wood,' what is the name of the young woman who commits suicide, leaving a profound impact on the protagonist, Toru Okada?",
            "Naoko",
            "Midori",
            "Reiko",
            "Kizuki",
            "Naoko"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Kurt Vonnegut that explores the absurdity of war through the experiences of Billy Pilgrim, who becomes 'unstuck in time'?",
            "Slaughterhouse-Five",
            "Cat's Cradle",
            "Mother Night",
            "Breakfast of Champions",
            "Slaughterhouse-Five"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Jhumpa Lahiri's 'The Namesake,' what is the name given to the protagonist Gogol Ganguli by his parents, inspired by the Russian author Nikolai Gogol?",
            "Rahul",
            "Ashoke",
            "Siddhartha",
            "Nikhil",
            "Nikhil"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Book Thief,' which is narrated by Death and follows the life of Liesel Meminger in Nazi Germany during World War II?",
            "Markus Zusak",
            "Khaled Hosseini",
            "Anthony Doerr",
            "John Green",
            "Markus Zusak"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Salman Rushdie's 'Midnight's Children,' what is the significance of the protagonist Saleem Sinai's unique ability?",
            "Teleportation",
            "Telekinesis",
            "Time Travel",
            "Mind Reading",
            "Telepathy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by José Saramago explores a world where suddenly everyone can see only in black and white, except for one woman who can still perceive colors?",
            "Blindness",
            "Seeing",
            "The Double",
            "All the Names",
            "Seeing"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional African country in Chinua Achebe's 'Things Fall Apart'?",
            "Wakanda",
            "Zamunda",
            "Ujamaa",
            "Umuofia",
            "Umuofia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Name of the Wind,' which follows the life story of the gifted musician and wizard Kvothe?",
            "George R.R. Martin",
            "Patrick Rothfuss",
            "Brandon Sanderson",
            "Robin Hobb",
            "Patrick Rothfuss"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Gabriel Garcia Marquez's 'One Hundred Years of Solitude,' what is the name of the forbidden love interest of the character Aureliano Buendía?",
            "Fermina Daza",
            "Clara del Valle",
            "Renata Remedios",
            "Pilar Ternera",
            "Renata Remedios"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Haruki Murakami features a protagonist who embarks on a surreal journey to find a mysterious sheep with a star-shaped birthmark?",
            "Kafka on the Shore",
            "Norwegian Wood",
            "1Q84",
            "Hard-Boiled Wonderland and the End of the World",
            "Hard-Boiled Wonderland and the End of the World"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Yann Martel's 'Life of Pi,' what is the name of the Bengal tiger with whom the protagonist, Pi, is stranded on a lifeboat in the Pacific Ocean?",
            "Richard Parker",
            "King Richard",
            "Percy",
            "Rajah",
            "Richard Parker"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Milan Kundera that explores the intertwined lives and loves of four characters against the backdrop of Czechoslovakia?",
            "The Unbearable Lightness of Being",
            "The Joke",
            "Ignorance",
            "The Book of Laughter and Forgetting",
            "The Unbearable Lightness of Being"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the dystopian novel 'Brave New World,' which depicts a futuristic society controlled by technology, conditioning, and a caste system?",
            "George Orwell",
            "Aldous Huxley",
            "Ray Bradbury",
            "Philip K. Dick",
            "Aldous Huxley"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Haruki Murakami's 'Kafka on the Shore,' what is the name of the mysterious librarian who can communicate with cats?",
            "Hoshino",
            "Oshima",
            "Nakata",
            "Miss Saeki",
            "Miss Saeki"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Milan Kundera follows the interconnected lives of several characters in a small Czechoslovakian spa town?",
            "The Book of Laughter and Forgetting",
            "The Unbearable Lightness of Being",
            "The Joke",
            "Ignorance",
            "The Book of Laughter and Forgetting"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the imaginary city in Italo Calvino's 'Invisible Cities,' where each street is named after a different emotion?",
            "Zemrude",
            "Ersilia",
            "Eutropia",
            "Valdrada",
            "Valdrada"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Grapes of Wrath,' which follows the Joad family's journey during the Great Depression?",
            "John Steinbeck",
            "Ernest Hemingway",
            "F. Scott Fitzgerald",
            "Sinclair Lewis",
            "John Steinbeck"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Kazuo Ishiguro's 'Never Let Me Go,' what is the name of the institution where the characters Kathy, Ruth, and Tommy grow up?",
            "Hailsham",
            "Wellesley",
            "Halcyon",
            "Briarcliff",
            "Hailsham"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional African country in Chinua Achebe's 'Arrow of God'?",
            "Umuaro",
            "Wakanda",
            "Zamunda",
            "Ujamaa",
            "Umuaro"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Power of One,' which follows the life of a young English boy named Peekay growing up in South Africa during World War II?",
            "Alan Paton",
            "Bryce Courtenay",
            "J.M. Coetzee",
            "Nadine Gordimer",
            "Bryce Courtenay"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Jeffrey Eugenides' 'Middlesex,' what is the name of the protagonist who is born intersex and explores issues of identity, family, and genetics?",
            "Cal",
            "Alex",
            "Eugenio",
            "Calliope",
            "Cal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Arundhati Roy explores the lives of twins Rahel and Estha in the fictional town of Ayemenem, India?",
            "The Ministry of Utmost Happiness",
            "The God of Small Things",
            "An Atlas of the Difficult World",
            "The Hungry Tide",
            "The God of Small Things"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Margaret Atwood set in a dystopian future where the government controls women's reproduction?",
            "The Blind Assassin",
            "Alias Grace",
            "Cat's Eye",
            "The Handmaid's Tale",
            "The Handmaid's Tale"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Salman Rushdie's 'The Satanic Verses,' what is the name of the protagonist who survives a terrorist attack and undergoes a transformation?",
            "Salman",
            "Gibreel",
            "Akbar",
            "Shalimar",
            "Gibreel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Vladimir Nabokov's 'Pale Fire,' what is the name of the protagonist and poet whose work is the subject of the novel's commentary?",
            "Charles Kinbote",
            "John Shade",
            "Hazel Shade",
            "Sybil Shade",
            "John Shade"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel '2666,' a complex narrative that weaves together multiple storylines and explores themes of violence, academia, and the search for truth?",
            "Julio Cortázar",
            "Roberto Bolaño",
            "Gabriel García Márquez",
            "Mario Vargas Llosa",
            "Roberto Bolaño"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Paul Auster that follows the interconnected lives of four characters—Daniel Quinn, Max Work, Peter Stillman, and Virginia Stillman?",
            "Moon Palace",
            "City of Glass",
            "The Music of Chance",
            "The New York Trilogy",
            "The New York Trilogy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Milan Kundera's 'The Book of Laughter and Forgetting,' what is the name of the woman whose photograph is removed from all official records, erasing her from history?",
            "Tamina",
            "Sabina",
            "Tereza",
            "Franz",
            "Tamina"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Gabriel García Márquez follows the lives of seven generations of the Buendía family in the fictional town of Macondo?",
            "One Hundred Years of Solitude",
            "Love in the Time of Cholera",
            "Chronicle of a Death Foretold",
            "The Autumn of the Patriarch",
            "One Hundred Years of Solitude"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Kazuo Ishiguro's 'The Buried Giant,' what mystical creature is encountered by the elderly couple Axl and Beatrice as they journey through a post-Arthurian Britain?",
            "Dragon",
            "Griffin",
            "Wyrm",
            "Pixie",
            "Dragon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Quantum Thief,' which is set in a post-singularity solar system and follows master thief Jean le Flambeur?",
            "Hannu Rajaniemi",
            "Alastair Reynolds",
            "Neal Stephenson",
            "Charles Stross",
            "Hannu Rajaniemi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Arundhati Roy's 'The Ministry of Utmost Happiness,' what is the name of the transgender woman who becomes a central figure in the novel's diverse narrative?",
            "Tilo",
            "Anjum",
            "Amrik",
            "Musa",
            "Anjum"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by David Mitchell that explores the interconnected lives of characters in and around the Chalfens' home in England?",
            "Ghostwritten",
            "Black Swan Green",
            "Cloud Atlas",
            "The Bone Clocks",
            "Black Swan Green"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Brief Wondrous Life of Oscar Wao,' which combines elements of magic realism with the tragic story of a Dominican family?",
            "Junot Díaz",
            "Isabel Allende",
            "Julia de Burgos",
            "Sandra Cisneros",
            "Junot Díaz"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Haruki Murakami's '1Q84,' what is the name of the parallel world that Aomame and Tengo find themselves in?",
            "1Q84",
            "Parallelia",
            "The Other Side",
            "Cat Town",
            "1Q84"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Salman Rushdie tells the story of two Indian expatriates who change their identities and travel the world, encountering historical figures and events?",
            "Shalimar the Clown",
            "The Golden House",
            "The Enchantress of Florence",
            "The Satanic Verses",
            "The Enchantress of Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional African country in the novel 'Black Leopard, Red Wolf' by Marlon James, known for its rich mythology and fantastical creatures?",
            "Wakanda",
            "Numbani",
            "Zamunda",
            "Griotlands",
            "Griotlands"
        )
    )

        questionsList.shuffle()

    }
    fun entertainmentStageFourteen(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "In Haruki Murakami's 'Norwegian Wood,' what is the name of the protagonist who reflects on his relationships and experiences in 1960s Tokyo?",
            "Toru Okada",
            "Watanabe",
            "Kafka Tamura",
            "Tsukuru Tazaki",
            "Watanabe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by Zadie Smith explores the lives of two friends, Archie Jones and Samad Iqbal, and their families in London over several decades?",
            "On Beauty",
            "White Teeth",
            "Swing Time",
            "NW",
            "White Teeth"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Milan Kundera that delves into the philosophical and romantic entanglements of characters like Tomas, Tereza, and Sabina?",
            "The Unbearable Lightness of Being",
            "The Book of Laughter and Forgetting",
            "Ignorance",
            "Slowness",
            "The Unbearable Lightness of Being"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Arundhati Roy's 'The God of Small Things,' what is the name of the forbidden love interest of the protagonist Rahel?",
            "Amu",
            "Velutha",
            "Chacko",
            "Sophie Mol",
            "Velutha"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Shadow of the Wind,' which is set in post-World War II Barcelona and follows a young boy named Daniel Sempere?",
            "Carlos Ruiz Zafón",
            "Isabel Allende",
            "Gabriel García Márquez",
            "Julia de Burgos",
            "Carlos Ruiz Zafón"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the protagonist in Yann Martel's 'Life of Pi,' who survives a shipwreck and shares a lifeboat with a Bengal tiger named Richard Parker?",
            "Pi Patel",
            "Ravi Patel",
            "Adil Patel",
            "Suraj Patel",
            "Pi Patel"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Jeffrey Eugenides' 'The Virgin Suicides,' what is the name of the neighborhood in which the Lisbon sisters live?",
            "Grosse Pointe",
            "Eastwood",
            "Sherwood",
            "Northwood",
            "Grosse Pointe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Kite Runner,' which follows the life of Amir, a young boy from Kabul, and explores themes of guilt, redemption, and friendship?",
            "Khaled Hosseini",
            "Mohsin Hamid",
            "Azar Nafisi",
            "Hossein Makhmalbaf",
            "Khaled Hosseini"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Michael Chabon that revolves around the adventures of a group of comic book artists and writers in the 1930s?",
            "Wonder Boys",
            "The Yiddish Policemen's Union",
            "Telegraph Avenue",
            "The Amazing Adventures of Kavalier & Clay",
            "The Amazing Adventures of Kavalier & Clay"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Jhumpa Lahiri's 'The Namesake,' what is the name given to the protagonist Gogol Ganguli by his parents, inspired by the Russian author Nikolai Gogol?",
            "Rahul",
            "Ashoke",
            "Siddhartha",
            "Nikhil",
            "Nikhil"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Night Circus,' which tells the enchanting tale of a magical competition between two illusionists, Celia Bowen and Marco Alisdair?",
            "Erin Morgenstern",
            "Leigh Bardugo",
            "Alice Hoffman",
            "Maggie Stiefvater",
            "Erin Morgenstern"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the fictional African country in Chimamanda Ngozi Adichie's 'Half of a Yellow Sun,' which chronicles the Biafran War?",
            "Nigeria",
            "Biafra",
            "Lagos",
            "Cameroon",
            "Biafra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Philip Pullman's 'His Dark Materials' trilogy, what is the name of the armored polar bear who becomes a companion to the protagonist, Lyra Belacqua?",
            "Iorek Byrnison",
            "Ragnar Sturlusson",
            "Borat Sarmak",
            "Serafina Pekkala",
            "Iorek Byrnison"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Master and Margarita,' which blends satire, fantasy, and historical fiction in its portrayal of the Devil's visit to Moscow?",
            "Fyodor Dostoevsky",
            "Vladimir Nabokov",
            "Leo Tolstoy",
            "Mikhail Bulgakov",
            "Mikhail Bulgakov"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Arundhati Roy set in modern-day India, which explores themes of caste, politics, and social injustice?",
            "The Ministry of Utmost Happiness",
            "The God of Small Things",
            "An Atlas of the Difficult World",
            "The Hungry Tide",
            "The Ministry of Utmost Happiness"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Kazuo Ishiguro's 'Never Let Me Go,' what is the name of the institution where the characters Kathy, Ruth, and Tommy grow up?",
            "Hailsham",
            "Wellesley",
            "Halcyon",
            "Briarcliff",
            "Hailsham"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Power of One,' which follows the life of a young English boy named Peekay growing up in South Africa during World War II?",
            "Alan Paton",
            "Bryce Courtenay",
            "J.M. Coetzee",
            "Nadine Gordimer",
            "Bryce Courtenay"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Donna Tartt that follows the life of Theo Decker, who survives a terrorist attack at the Metropolitan Museum of Art?",
            "The Little Friend",
            "The Goldfinch",
            "The Secret History",
            "The Dutch House",
            "The Goldfinch"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Angela Carter's 'The Bloody Chamber,' what is the name of the young bride whose new husband reveals his predatory nature on their wedding night?",
            "Lizzie",
            "Puss-in-Boots",
            "Bluebeard",
            "Alice",
            "Bluebeard"
        )
    )
    questionsList.add(
        QuestionsModel(
            "In Kazuo Ishiguro's 'The Remains of the Day,' what is the name of the butler who reflects on his life and service at Darlington Hall?",
            "Stevens",
            "Hobson",
            "Jeeves",
            "Carson",
            "Stevens"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which novel by J.M. Coetzee explores the moral and psychological effects of apartheid in South Africa through the story of David Lurie?",
            "Disgrace",
            "Waiting for the Barbarians",
            "Life & Times of Michael K",
            "The Master of Petersburg",
            "Disgrace"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by David Mitchell that features six interconnected stories, each set in a different time and place, and explores the theme of reincarnation?",
            "Ghostwritten",
            "Number9Dream",
            "Cloud Atlas",
            "The Bone Clocks",
            "Cloud Atlas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Anthony Burgess's 'A Clockwork Orange,' what is the name of the delinquent and protagonist who undergoes the Ludovico Technique to reform his violent behavior?",
            "Alex",
            "Droog",
            "Dim",
            "Pete",
            "Alex"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Wind-Up Bird Chronicle,' which follows the surreal and mysterious experiences of Toru Okada in Tokyo?",
            "Kazuo Ishiguro",
            "Haruki Murakami",
            "Yukio Mishima",
            "Ryu Murakami",
            "Haruki Murakami"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Salman Rushdie that weaves together the stories of various characters, including Saleem Sinai, against the backdrop of India's independence?",
            "Midnight's Children",
            "The Satanic Verses",
            "Shame",
            "The Moor's Last Sigh",
            "Midnight's Children"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Milan Kundera's 'The Joke,' what is the name of the protagonist who is expelled from university and becomes the target of a political joke?",
            "Ludvik",
            "Jaroslav",
            "Tomáš",
            "Franz",
            "Ludvik"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Yiddish Policemen's Union,' which is set in an alternate history where a temporary Jewish settlement exists in Alaska and follows detective Meyer Landsman?",
            "Michael Chabon",
            "Jonathan Safran Foer",
            "Nicole Krauss",
            "Cynthia Ozick",
            "Michael Chabon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the name of the protagonist in Margaret Atwood's 'Alias Grace,' who is convicted of murder and seeks pardon through psychiatric evaluation?",
            "Grace Marks",
            "Mary Whitney",
            "Simon Jordan",
            "James McDermott",
            "Grace Marks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The White Tiger,' which tells the story of Balram Halwai, a chauffeur who rises from poverty in India to become a successful entrepreneur?",
            "Vikram Seth",
            "Aravind Adiga",
            "Jhumpa Lahiri",
            "Amitav Ghosh",
            "Aravind Adiga"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Donna Tartt's 'The Secret History,' what is the name of the professor who teaches a select group of students the classics and becomes involved in a murder?",
            "Julian Morrow",
            "Richard Papen",
            "Henry Winter",
            "Camilla Macaulay",
            "Julian Morrow"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Salman Rushdie that tells the story of a Bollywood star and a Bombay gangster against the backdrop of India's changing politics?",
            "The Satanic Verses",
            "Shame",
            "Midnight's Children",
            "The Moor's Last Sigh",
            "The Moor's Last Sigh"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Orphan Master's Son,' which follows the life of Pak Jun Do in North Korea, exploring themes of identity and propaganda?",
            "Adam Johnson",
            "David Mitchell",
            "Chang-rae Lee",
            "Han Kang",
            "Adam Johnson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Jeffrey Eugenides' 'Middlesex,' what is the name of the protagonist who is born intersex and navigates through issues of identity and family history?",
            "Cal",
            "Milton",
            "Eugenio",
            "Calliope",
            "Cal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Aravind Adiga that presents a series of letters written by the protagonist Balram Halwai to the Chinese Premier?",
            "Last Man in Tower",
            "Between the Assassinations",
            "Selection Day",
            "The White Tiger",
            "Between the Assassinations"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The God of Small Things,' which explores the tragic story of the twins Estha and Rahel in the state of Kerala, India?",
            "Arundhati Roy",
            "Kiran Desai",
            "Amitav Ghosh",
            "Rohinton Mistry",
            "Arundhati Roy"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Julian Barnes' 'The Sense of an Ending,' what is the name of the protagonist who reflects on his past and the consequences of his actions?",
            "Tony Webster",
            "Adrian Finn",
            "Veronica Ford",
            "Margaret Mary",
            "Tony Webster"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who wrote the novel 'The Sympathizer,' which follows a communist spy as he infiltrates the South Vietnamese army and later grapples with his identity in the United States?",
            "Viet Thanh Nguyen",
            "Ocean Vuong",
            "Thi Bui",
            "Bich Minh Nguyen",
            "Viet Thanh Nguyen"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the title of the novel by Kazuo Ishiguro that explores the lives of the clones Kathy, Ruth, and Tommy, who grow up in an English boarding school?",
            "Never Let Me Go",
            "The Remains of the Day",
            "The Buried Giant",
            "When We Were Orphans",
            "Never Let Me Go"
        )
    )
    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to create and sell exclusive memberships to their audience?",
            "Channel Sponsorship",
            "Fan Funding",
            "YouTube Memberships",
            "Exclusive Subscriptions",
            "YouTube Memberships"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Instagram stories, what is the term for the feature that allows users to create and share countdowns for upcoming events?",
            "Countdown Clock",
            "Event Timer",
            "Counting Calendar",
            "Time Ticker",
            "Countdown Clock"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the practice of purchasing fake engagement on Instagram, including likes, comments, and followers?",
            "Engagement Elevation",
            "Follower Fraud",
            "Like Laundering",
            "Social Currency Scam",
            "Like Laundering"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to showcase their favorite videos on their profile?",
            "Top Picks",
            "Featured Flicks",
            "Showcase Selections",
            "Favorite Features",
            "Top Picks"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to add clickable product tags to their posts, linking to shopping pages?",
            "Product Placer",
            "Shopping Showcase",
            "Click-to-Buy",
            "Shopping Tags",
            "Shopping Tags"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the system that automatically detects and demonetizes videos with inappropriate or controversial content?",
            "AdPurge System",
            "Monetization Monitor",
            "Content Cleanse",
            "YouTube's AdSense Policy",
            "Monetization Monitor"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In TikTok, what is the term for the feature that allows users to add voice effects and filters to their videos?",
            "Sound Spectrum",
            "Voice Vibe",
            "Audio Aura",
            "Voice Effects",
            "Voice Effects"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the process of optimizing YouTube videos to appear in the platform's suggested video recommendations?",
            "Suggestion SEO",
            "Recommendation Refinement",
            "Suggested Optimization",
            "Suggested Video SEO",
            "Suggested Video SEO"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to create and share collaborative posts with others?",
            "Collab Creations",
            "Partner Posts",
            "Joint Journals",
            "Collaborative Posts",
            "Collaborative Posts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its 'CinemaSins' series, where movies are humorously criticized and pointed out for sins?",
            "MovieMockers",
            "FilmFunnies",
            "ScreenSarcasm",
            "CinemaSins",
            "CinemaSins"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to create and participate in challenges with specific themes?",
            "Challenge Quests",
            "Trend Trials",
            "Hashtag Hunts",
            "Challenge Challenges",
            "Hashtag Hunts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the process of analyzing and adjusting a YouTube video's content to maximize its visibility in search results?",
            "Search Scrutiny",
            "Content Calibration",
            "Video Visibility",
            "Search Optimization",
            "Search Optimization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Instagram stories, what is the term for the feature that allows users to add clickable links to external websites?",
            "Swipe-Up Link",
            "Tap-To-Visit",
            "URL Share",
            "External Link Sticker",
            "Swipe-Up Link"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to add clickable links to other videos during playback?",
            "Link Cards",
            "Video Annotations",
            "Click Tags",
            "Interactive Links",
            "Video Annotations"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the maximum number of tags allowed for a single video on YouTube?",
            "10 tags",
            "15 tags",
            "20 tags",
            "25 tags",
            "15 tags"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to add interactive elements like polls and questions to their videos?",
            "Interactive Tags",
            "Engagement Widgets",
            "Creative Elements",
            "Interactive Stickers",
            "Interactive Stickers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to create and share interactive quizzes with their followers?",
            "Quiz Zone",
            "Trivia Time",
            "Questionnaire Quest",
            "Quiz Stickers",
            "Quiz Stickers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to trim and cut their videos before uploading?",
            "Clip Cut",
            "Trim Tool",
            "Edit Edge",
            "Snip & Snap",
            "Trim Tool"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the strategy of optimizing content on YouTube to appear in the platform's search results?",
            "Video SEO",
            "Search Optimization",
            "YouTube Ranking",
            "Algorithm Mastery",
            "Video SEO"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to archive their posts without deleting them?",
            "Save for Later",
            "Hide Post",
            "Archive Post",
            "Secret Stash",
            "Archive Post"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the algorithm that suggests videos based on the user's watch history and preferences?",
            "Suggested Algorithm",
            "Watch Next Engine",
            "Algorithmic Picks",
            "Video Recommender",
            "Watch Next Engine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Instagram stories, what is the term for the feature that allows users to create interactive quizzes with multiple-choice questions?",
            "Quiz Stamps",
            "Interactive Polls",
            "Trivia Tags",
            "Questionnaire Quizzes",
            "Interactive Polls"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the practice of using specific keywords to make a video more discoverable on YouTube?",
            "Tag Trickery",
            "Keyword Optimization",
            "Metadata Magic",
            "Search Tagging",
            "Keyword Optimization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to apply beauty filters and enhance their appearance?",
            "Glamour Glow",
            "Beauty Boost",
            "Cosmetic Capture",
            "Beauty Mode",
            "Beauty Mode"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to schedule posts for a specific date and time without using external apps?",
            "Post Planner",
            "Time Tracker",
            "Schedule Suite",
            "Creator Studio",
            "Creator Studio"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to live-stream content to their audience in real-time?",
            "Live Link",
            "Stream Studio",
            "Live Lounge",
            "YouTube Live",
            "YouTube Live"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In TikTok, what is the term for the feature that allows users to set a timer for their videos to stop recording automatically?",
            "Time Ticker",
            "Timer Toggle",
            "Stopwatch Snap",
            "Auto Stop",
            "Timer Toggle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the strategy of encouraging viewers to engage with a YouTube video through likes, comments, and shares?",
            "Engagement Boost",
            "Interaction Initiative",
            "Community Call",
            "Call-to-Action",
            "Call-to-Action"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to see insights and analytics for their posts and account?",
            "Stats Studio",
            "Insightful Hub",
            "Analytica",
            "Instagram Insights",
            "Instagram Insights"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its 'How It's Made' series, showcasing the manufacturing processes of various products?",
            "Factory Flow",
            "Manufacture Magic",
            "Industrial Insight",
            "How It's Made",
            "How It's Made"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to reverse their videos and create a backward playback effect?",
            "Rewind Riff",
            "Backtrack Effect",
            "Reverse Replay",
            "Time Twist",
            "Rewind Riff"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the practice of promoting a YouTube video through paid advertisements to increase its visibility?",
            "Video Boosting",
            "Promo Push",
            "Ad Amplification",
            "Video Advertising",
            "Video Advertising"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Instagram stories, what is the term for the feature that allows users to mention other accounts by adding a clickable handle?",
            "Tag Tags",
            "Mention Mode",
            "Handle Highlight",
            "User Tagging",
            "User Tagging"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that enables creators to add clickable links to external websites in their video descriptions?",
            "Link Locator",
            "External Embed",
            "URL Zone",
            "External Links",
            "External Links"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the maximum number of characters allowed in a YouTube video description?",
            "5000 characters",
            "7500 characters",
            "10000 characters",
            "15000 characters",
            "5000 characters"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to add animated stickers and emojis to their videos?",
            "Emoji Extras",
            "Sticker Stamp",
            "Animated Additions",
            "Sticker Effects",
            "Sticker Effects"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to create and share short-form looping videos similar to Vine?",
            "Insta Loops",
            "Vine Vibes",
            "Loop Legends",
            "Boomerang",
            "Boomerang"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to organize their videos into categorized playlists?",
            "Video Vaults",
            "Playlist Paradise",
            "Content Collections",
            "YouTube Playlists",
            "YouTube Playlists"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the term for the process of promoting and optimizing a social media profile to increase its visibility and reach?",
            "Profile Promotion",
            "Visibility Vamp",
            "Social Amplification",
            "Profile Optimization",
            "Social Amplification"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to create videos by combining multiple clips from their camera roll?",
            "Roll Remix",
            "Clip Collage",
            "Film Fusion",
            "Stitch",
            "Stitch"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that automatically generates subtitles and closed captions for videos?",
            "Auto-Subtitle Engine",
            "Caption Automation",
            "Automatic Captions",
            "Subtitle Synthesis",
            "Automatic Captions"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In Instagram stories, what is the term for the feature that allows users to create polls for their followers?",
            "Vote Stickers",
            "Polling Placards",
            "Opinion Overlays",
            "Survey Stamps",
            "Vote Stickers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the maximum number of characters allowed in a YouTube video title?",
            "70 characters",
            "100 characters",
            "120 characters",
            "150 characters",
            "100 characters"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to add slow-motion effects to specific parts of their videos?",
            "Time Warp",
            "SlowMo Magic",
            "Chrono Chill",
            "Time Stretch",
            "Time Warp"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Instagram feature allows users to create and share interactive quizzes with their followers?",
            "Quiz Zone",
            "Trivia Time",
            "Questionnaire Quest",
            "Quiz Stickers",
            "Quiz Stickers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On YouTube, what is the term for the feature that allows creators to add clickable links to other videos during playback?",
            "Link Cards",
            "Video Annotations",
            "Click Tags",
            "Interactive Links",
            "Video Annotations"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In TikTok, what is the term for the feature that allows users to react to other people's videos by sharing split-screen content?",
            "Side-by-Side Reaction",
            "Reaction Duet",
            "Mirror Response",
            "Split Reaction",
            "Reaction Duet"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What is the maximum number of tags allowed for a single video on YouTube?",
            "10 tags",
            "15 tags",
            "20 tags",
            "25 tags",
            "15 tags"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On Instagram, what is the term for the feature that allows users to see the posts they've liked in a dedicated section?",
            "Like Library",
            "Heart History",
            "Favorites Feed",
            "Activity Log",
            "Activity Log"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which YouTube channel is known for its 'Epic Rap Battles of History' series, featuring fictional and historical characters in rap battles?",
            "ERB",
            "Rhyme Time Showdown",
            "Verse Victory",
            "Battle Beats",
            "ERB"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to trim and cut their videos before uploading?",
            "Clip Cut",
            "Trim Tool",
            "Edit Edge",
            "Snip & Snap",
            "Trim Tool"
        )
    )

    questionsList.add(
        QuestionsModel(
            "On TikTok, what is the term for the feature that allows users to apply special effects to their videos, such as transitions and visual enhancements?",
            "Effect Enigma",
            "Magic Moments",
            "Visual Vibes",
            "Special Effects Studio",
            "Magic Moments"
        )
    )

        questionsList.shuffle()

    }



    fun historyStageOne(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Who was the first President of the United States?",
            "John Adams",
            "Thomas Jefferson",
            "George Washington",
            "James Madison",
            "George Washington"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which year did Christopher Columbus first reach the Americas?",
            "1492",
            "1501",
            "1607",
            "1776",
            "1492"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What ancient civilization built the pyramids of Giza?",
            "Greek",
            "Roman",
            "Egyptian",
            "Babylonian",
            "Egyptian"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous nurse during the Crimean War and is considered the founder of modern nursing?",
            "Florence Nightingale",
            "Clara Barton",
            "Mary Seacole",
            "Dorothea Dix",
            "Florence Nightingale"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which war did the Battle of Gettysburg take place?",
            "American Revolution",
            "Civil War",
            "World War I",
            "World War II",
            "Civil War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What event marked the beginning of World War I?",
            "Assassination of Archduke Franz Ferdinand",
            "Attack on Pearl Harbor",
            "Signing of the Treaty of Versailles",
            "Battle of Stalingrad",
            "Assassination of Archduke Franz Ferdinand"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Soviet Union during World War II?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Mikhail Gorbachev",
            "Nikita Khrushchev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What document declared the American colonies' independence from Great Britain?",
            "Magna Carta",
            "Emancipation Proclamation",
            "Declaration of Independence",
            "Constitution",
            "Declaration of Independence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the primary author of the Declaration of Independence?",
            "John Adams",
            "Thomas Jefferson",
            "Benjamin Franklin",
            "James Madison",
            "Thomas Jefferson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for its impressive city-state of Athens and the development of democracy?",
            "Roman Empire",
            "Persian Empire",
            "Greek Civilization",
            "Egyptian Empire",
            "Greek Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What was the main cause of the Black Death in Europe during the 14th century?",
            "Famine",
            "War",
            "Bubonic Plague",
            "Influenza",
            "Bubonic Plague"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first woman to win a Nobel Prize and remains the only person to win Nobel Prizes in two different scientific fields?",
            "Marie Curie",
            "Rosalind Franklin",
            "Dorothy Crowfoot Hodgkin",
            "Barbara McClintock",
            "Marie Curie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which year did the Titanic sink after hitting an iceberg?",
            "1905",
            "1912",
            "1923",
            "1931",
            "1912"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first emperor of China and is best known for the Terracotta Army?",
            "Confucius",
            "Mao Zedong",
            "Sun Yat-sen",
            "Qin Shi Huang",
            "Qin Shi Huang"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What historical event marked the end of the medieval period and the beginning of the Renaissance in Europe?",
            "Fall of Rome",
            "Great Schism",
            "Black Death",
            "Fall of Constantinople",
            "Fall of Constantinople"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the civil rights movement in the United States and is best known for his role in the advancement of civil rights using nonviolent civil disobedience?",
            "Malcolm X",
            "Jesse Jackson",
            "Rosa Parks",
            "Martin Luther King Jr.",
            "Martin Luther King Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "What event marked the beginning of the Great Depression in the United States?",
            "Stock Market Crash of 1929",
            "Dust Bowl",
            "Prohibition",
            "World War I",
            "Stock Market Crash of 1929"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first woman to fly solo across the Atlantic Ocean?",
            "Bessie Coleman",
            "Amelia Earhart",
            "Katherine Johnson",
            "Jacqueline Cochran",
            "Amelia Earhart"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What famous speech did Abraham Lincoln deliver during the American Civil War?",
            "Gettysburg Address",
            "I Have a Dream",
            "Emancipation Proclamation",
            "Four Score and Seven Years Ago",
            "Gettysburg Address"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who was the first Emperor of Rome?",
            "Julius Caesar",
            "Augustus",
            "Nero",
            "Caligula",
            "Augustus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for building the Great Wall of China?",
            "Persian Empire",
            "Roman Empire",
            "Mongol Empire",
            "Chinese Empire",
            "Chinese Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did World War I begin?",
            "1910",
            "1914",
            "1918",
            "1922",
            "1914"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known as the 'Father of India' and played a key role in India's struggle for independence?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Egyptian queen is famous for her relationship with Roman leaders Julius Caesar and Mark Antony?",
            "Nefertiti",
            "Cleopatra",
            "Hatshepsut",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first woman to win a Nobel Prize and the only person to win Nobel Prizes in two different fields?",
            "Marie Curie",
            "Rosalind Franklin",
            "Dorothy Crowfoot Hodgkin",
            "Barbara McClintock",
            "Marie Curie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which country was the first to circumnavigate the globe?",
            "Spain",
            "Portugal",
            "England",
            "Netherlands",
            "Spain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the legendary queen of ancient Egypt known for her beauty and relationships with Julius Caesar and Mark Antony?",
            "Nefertiti",
            "Hatshepsut",
            "Cleopatra",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which year did Christopher Columbus first reach the Americas?",
            "1492",
            "1501",
            "1607",
            "1776",
            "1492"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first President of the United States?",
            "John Adams",
            "Thomas Jefferson",
            "George Washington",
            "James Madison",
            "George Washington"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for its contributions to philosophy, democracy, and the Olympics?",
            "Roman Empire",
            "Greek Civilization",
            "Persian Empire",
            "Egyptian Empire",
            "Greek Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What event marked the beginning of the Renaissance in Europe?",
            "Black Death",
            "Fall of Rome",
            "Great Schism",
            "Fall of Constantinople",
            "Fall of Constantinople"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who is known for developing the theory of general relativity?",
            "Isaac Newton",
            "Galileo Galilei",
            "Albert Einstein",
            "Nikola Tesla",
            "Albert Einstein"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Titanic sink after hitting an iceberg?",
            "1905",
            "1912",
            "1923",
            "1931",
            "1912"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous nurse during the Crimean War and is considered the founder of modern nursing?",
            "Florence Nightingale",
            "Clara Barton",
            "Mary Seacole",
            "Dorothea Dix",
            "Florence Nightingale"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for building the pyramids of Giza?",
            "Greek",
            "Roman",
            "Egyptian",
            "Babylonian",
            "Egyptian"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Soviet Union during World War II?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Mikhail Gorbachev",
            "Nikita Khrushchev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "What document declared the American colonies' independence from Great Britain?",
            "Magna Carta",
            "Emancipation Proclamation",
            "Declaration of Independence",
            "Constitution",
            "Declaration of Independence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the primary author of the Declaration of Independence?",
            "John Adams",
            "Thomas Jefferson",
            "Benjamin Franklin",
            "James Madison",
            "Thomas Jefferson"
        )
    )
    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Indian independence movement against British rule and is often referred to as the 'Father of the Nation'?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which European explorer is credited with discovering the sea route to India in the late 15th century?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "John Cabot",
            "Vasco da Gama"
        )
    )


        questionsList.shuffle()

    }
    fun historyStageTwo(){
        questionsList.clear()

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for its ziggurats and the Code of Hammurabi?",
                    "Mesopotamian Civilization",
                    "Indus Valley Civilization",
                    "Mayan Civilization",
                    "Chinese Civilization",
                    "Mesopotamian Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the legendary queen of ancient Egypt known for her beauty and relationships with Julius Caesar and Mark Antony?",
                    "Nefertiti",
                    "Hatshepsut",
                    "Cleopatra",
                    "Isis",
                    "Cleopatra"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient wonder of the world was a massive temple dedicated to the goddess Artemis?",
                    "Great Pyramid of Giza",
                    "Hanging Gardens of Babylon",
                    "Statue of Zeus at Olympia",
                    "Temple of Artemis at Ephesus",
                    "Temple of Artemis at Ephesus"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "What ancient civilization is known for its impressive city-state of Athens and the development of democracy?",
                    "Roman Empire",
                    "Persian Empire",
                    "Greek Civilization",
                    "Egyptian Empire",
                    "Greek Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the first female pharaoh of ancient Egypt?",
                    "Nefertiti",
                    "Hatshepsut",
                    "Cleopatra",
                    "Isis",
                    "Hatshepsut"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which century did the Renaissance begin?",
                    "14th Century",
                    "15th Century",
                    "16th Century",
                    "17th Century",
                    "14th Century"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous queen of England known for her long reign from 1837 to 1901?",
                    "Queen Elizabeth I",
                    "Queen Victoria",
                    "Queen Anne",
                    "Queen Mary",
                    "Queen Victoria"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which European explorer is credited with opening a sea route to India by sailing around the Cape of Good Hope?",
                    "Christopher Columbus",
                    "Ferdinand Magellan",
                    "Vasco da Gama",
                    "John Cabot",
                    "Vasco da Gama"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In what year did the Berlin Wall fall, leading to the reunification of East and West Germany?",
                    "1985",
                    "1989",
                    "1991",
                    "1995",
                    "1989"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the first emperor of China and is best known for the Terracotta Army?",
                    "Confucius",
                    "Mao Zedong",
                    "Sun Yat-sen",
                    "Qin Shi Huang",
                    "Qin Shi Huang"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which famous explorer completed the first circumnavigation of the Earth?",
                    "Christopher Columbus",
                    "Ferdinand Magellan",
                    "Vasco da Gama",
                    "Marco Polo",
                    "Ferdinand Magellan"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the ancient Greek philosopher known for his teachings and dialogues recorded by his student Plato?",
                    "Socrates",
                    "Aristotle",
                    "Pythagoras",
                    "Hippocrates",
                    "Socrates"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which year did World War II end?",
                    "1942",
                    "1945",
                    "1950",
                    "1960",
                    "1945"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for its advanced knowledge of astronomy and the construction of pyramids?",
                    "Mayan Civilization",
                    "Inca Empire",
                    "Aztec Empire",
                    "Chinese Civilization",
                    "Mayan Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous nurse during the Crimean War and is considered the founder of modern nursing?",
                    "Florence Nightingale",
                    "Clara Barton",
                    "Mary Seacole",
                    "Dorothea Dix",
                    "Florence Nightingale"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for the creation of the first known system of writing called cuneiform?",
                    "Mesopotamian Civilization",
                    "Indus Valley Civilization",
                    "Egyptian Civilization",
                    "Chinese Civilization",
                    "Mesopotamian Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the ancient Egyptian pharaoh known for constructing the Great Pyramid of Giza?",
                    "Ramses II",
                    "Tutankhamun",
                    "Hatshepsut",
                    "Khufu",
                    "Khufu"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which century did the Industrial Revolution begin?",
                    "16th Century",
                    "17th Century",
                    "18th Century",
                    "19th Century",
                    "18th Century"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which medieval queen of England is known for her support of the arts and the founding of Westminster Abbey?",
                    "Queen Isabella I",
                    "Queen Eleanor of Aquitaine",
                    "Queen Elizabeth I",
                    "Queen Victoria",
                    "Queen Eleanor of Aquitaine"
                )
            )


            questionsList.add(
                QuestionsModel(
                    "Who was the ancient Greek philosopher known for his contributions to mathematics, especially geometry?",
                    "Aristotle",
                    "Pythagoras",
                    "Socrates",
                    "Hippocrates",
                    "Pythagoras"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which civilization is credited with the invention of the wheel?",
                    "Sumerians",
                    "Mayans",
                    "Greeks",
                    "Romans",
                    "Sumerians"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "What ancient empire is known for constructing the Inca Trail and the city of Machu Picchu?",
                    "Roman Empire",
                    "Mongol Empire",
                    "Inca Empire",
                    "Aztec Empire",
                    "Inca Empire"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous military leader who led the Carthaginian forces during the Second Punic War?",
                    "Julius Caesar",
                    "Alexander the Great",
                    "Hannibal Barca",
                    "Napoleon Bonaparte",
                    "Hannibal Barca"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for its contributions to literature, including the epic poems the Iliad and the Odyssey?",
                    "Greek Civilization",
                    "Roman Empire",
                    "Egyptian Civilization",
                    "Persian Empire",
                    "Greek Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which century did the Black Death, a devastating pandemic, occur in Europe?",
                    "12th Century",
                    "14th Century",
                    "16th Century",
                    "18th Century",
                    "14th Century"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous queen of ancient Egypt known for her efforts to restore traditional polytheistic religion?",
                    "Nefertiti",
                    "Hatshepsut",
                    "Cleopatra",
                    "Akhenaten",
                    "Hatshepsut"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which famous explorer is credited with discovering the Americas in 1492?",
                    "Ferdinand Magellan",
                    "Christopher Columbus",
                    "Marco Polo",
                    "John Cabot",
                    "Christopher Columbus"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the first woman to win a Nobel Prize and is known for her work in radioactivity?",
                    "Marie Curie",
                    "Rosalind Franklin",
                    "Dorothy Crowfoot Hodgkin",
                    "Barbara McClintock",
                    "Marie Curie"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for the construction of the Parthenon in Athens?",
                    "Roman Empire",
                    "Greek Civilization",
                    "Persian Empire",
                    "Egyptian Empire",
                    "Greek Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous English playwright and poet known for works like 'Romeo and Juliet' and 'Hamlet'?",
                    "William Wordsworth",
                    "Charles Dickens",
                    "Jane Austen",
                    "William Shakespeare",
                    "William Shakespeare"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In what year did the United States declare its independence from Great Britain?",
                    "1756",
                    "1776",
                    "1804",
                    "1820",
                    "1776"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for its terracotta army, buried with the first emperor of China?",
                    "Indus Valley Civilization",
                    "Roman Empire",
                    "Mayan Civilization",
                    "Chinese Civilization",
                    "Chinese Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the founder of the Maurya Empire in ancient India and a significant figure in Buddhist history?",
                    "Ashoka the Great",
                    "Chandragupta Maurya",
                    "Harsha",
                    "Akbar the Great",
                    "Chandragupta Maurya"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for the Hanging Gardens, one of the Seven Wonders of the Ancient World?",
                    "Greek Civilization",
                    "Roman Empire",
                    "Mesopotamian Civilization",
                    "Egyptian Empire",
                    "Mesopotamian Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous nurse who served during the Crimean War and is considered the founder of modern nursing?",
                    "Florence Nightingale",
                    "Clara Barton",
                    "Mary Seacole",
                    "Dorothea Dix",
                    "Florence Nightingale"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which year did the Russian Revolution take place, leading to the establishment of the Soviet Union?",
                    "1905",
                    "1917",
                    "1923",
                    "1931",
                    "1917"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the legendary king of Uruk in ancient Mesopotamia and the central figure of the Epic of Gilgamesh?",
                    "Hammurabi",
                    "Gilgamesh",
                    "Sargon",
                    "Nebuchadnezzar II",
                    "Gilgamesh"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for the construction of the Great Wall?",
                    "Roman Empire",
                    "Mongol Empire",
                    "Inca Empire",
                    "Chinese Civilization",
                    "Chinese Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the English queen known for her defeat of the Spanish Armada in 1588?",
                    "Queen Elizabeth I",
                    "Queen Mary I",
                    "Queen Anne",
                    "Queen Victoria",
                    "Queen Elizabeth I"
                )
            )


            questionsList.add(
                QuestionsModel(
                    "Who was the first president of the United States?",
                    "Thomas Jefferson",
                    "John Adams",
                    "George Washington",
                    "James Madison",
                    "George Washington"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for its pharaohs, pyramids, and the Sphinx?",
                    "Greek Civilization",
                    "Roman Empire",
                    "Egyptian Civilization",
                    "Persian Empire",
                    "Egyptian Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous military leader who conquered much of Western Europe in the early 19th century?",
                    "Napoleon Bonaparte",
                    "Alexander the Great",
                    "Julius Caesar",
                    "Genghis Khan",
                    "Napoleon Bonaparte"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which century did the Renaissance take place?",
                    "12th Century",
                    "14th Century",
                    "16th Century",
                    "18th Century",
                    "14th Century"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the leader of the American Civil Rights Movement and known for his 'I Have a Dream' speech?",
                    "Malcolm X",
                    "Martin Luther King Jr.",
                    "Rosa Parks",
                    "Harriet Tubman",
                    "Martin Luther King Jr."
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for the creation of the Rosetta Stone?",
                    "Mesopotamian Civilization",
                    "Indus Valley Civilization",
                    "Egyptian Civilization",
                    "Chinese Civilization",
                    "Egyptian Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous nurse who worked during the Crimean War and is considered a pioneer of modern nursing?",
                    "Florence Nightingale",
                    "Clara Barton",
                    "Mary Seacole",
                    "Dorothea Dix",
                    "Florence Nightingale"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for its philosophy, including the teachings of Confucius and Laozi?",
                    "Greek Civilization",
                    "Roman Empire",
                    "Chinese Civilization",
                    "Persian Empire",
                    "Chinese Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which century did the Protestant Reformation begin?",
                    "15th Century",
                    "16th Century",
                    "17th Century",
                    "18th Century",
                    "16th Century"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the first emperor of the Roman Empire, known for his military conquests and legal reforms?",
                    "Julius Caesar",
                    "Augustus",
                    "Nero",
                    "Caligula",
                    "Augustus"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for the construction of the Colosseum in Rome?",
                    "Greek Civilization",
                    "Roman Empire",
                    "Persian Empire",
                    "Egyptian Empire",
                    "Roman Empire"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous nurse who served in the British Army during the Crimean War and is known as the 'Lady with the Lamp'?",
                    "Florence Nightingale",
                    "Clara Barton",
                    "Mary Seacole",
                    "Dorothea Dix",
                    "Florence Nightingale"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which century did the Industrial Revolution transform manufacturing, transportation, and agriculture?",
                    "16th Century",
                    "17th Century",
                    "18th Century",
                    "19th Century",
                    "18th Century"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous queen of ancient Egypt known for her political and military accomplishments?",
                    "Nefertiti",
                    "Hatshepsut",
                    "Cleopatra",
                    "Isis",
                    "Hatshepsut"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which medieval queen of England is known for her role in the Hundred Years' War and later became a saint?",
                    "Joan of Arc",
                    "Isabella I of Castile",
                    "Eleanor of Aquitaine",
                    "Catherine the Great",
                    "Joan of Arc"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous artist and polymath known for paintings like the Mona Lisa and The Last Supper?",
                    "Vincent van Gogh",
                    "Pablo Picasso",
                    "Leonardo da Vinci",
                    "Michelangelo",
                    "Leonardo da Vinci"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "In which year did the Titanic sink after hitting an iceberg on its maiden voyage?",
                    "1905",
                    "1912",
                    "1920",
                    "1931",
                    "1912"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the famous Chinese philosopher known for his teachings on ethics, morality, and government?",
                    "Confucius",
                    "Laozi",
                    "Mencius",
                    "Sun Tzu",
                    "Confucius"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Which ancient civilization is known for the construction of the Great Wall of China?",
                    "Greek Civilization",
                    "Roman Empire",
                    "Inca Empire",
                    "Chinese Civilization",
                    "Chinese Civilization"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the first woman to fly solo across the Atlantic Ocean?",
                    "Amelia Earhart",
                    "Bessie Coleman",
                    "Harriet Quimby",
                    "Jacqueline Cochran",
                    "Amelia Earhart"
                )
            )

            questionsList.add(
                QuestionsModel(
                    "Who was the first emperor of the Maurya Empire in ancient India, known for his contributions to Buddhism?",
                    "Ashoka the Great",
                    "Chandragupta Maurya",
                    "Harsha",
                    "Akbar the Great",
                    "Ashoka the Great"
                )
            )

        questionsList.shuffle()

    }
    fun historyStageThree(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "During which war did the Battle of Gettysburg take place?",
            "American Revolutionary War",
            "Civil War",
            "World War I",
            "World War II",
            "Civil War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first emperor of the Roman Empire, known for his military campaigns and adopting the title 'Augustus'?",
            "Julius Caesar",
            "Nero",
            "Augustus",
            "Caligula",
            "Augustus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Berlin Wall fall, marking the end of the Cold War?",
            "1985",
            "1989",
            "1991",
            "1995",
            "1989"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which European explorer is credited with the first successful circumnavigation of the Earth?",
            "Ferdinand Magellan",
            "Christopher Columbus",
            "Marco Polo",
            "James Cook",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Egyptian queen known for her relationship with Julius Caesar and Mark Antony?",
            "Cleopatra",
            "Nefertiti",
            "Hatshepsut",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which battle, fought in 1314, is considered a significant event in the First War of Scottish Independence?",
            "Battle of Agincourt",
            "Battle of Bannockburn",
            "Battle of Hastings",
            "Battle of Cannae",
            "Battle of Bannockburn"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which year did the Russian Revolution occur, leading to the establishment of the Soviet Union?",
            "1905",
            "1917",
            "1923",
            "1931",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous African-American civil rights activist known for his leadership in the Montgomery Bus Boycott?",
            "Malcolm X",
            "Martin Luther King Jr.",
            "Rosa Parks",
            "Harriet Tubman",
            "Martin Luther King Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the creation of the Hanging Gardens, one of the Seven Wonders of the Ancient World?",
            "Greek Civilization",
            "Roman Empire",
            "Mesopotamian Civilization",
            "Egyptian Empire",
            "Mesopotamian Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous English playwright and poet known for works like 'Romeo and Juliet' and 'Hamlet'?",
            "William Wordsworth",
            "Charles Dickens",
            "Jane Austen",
            "William Shakespeare",
            "William Shakespeare"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the construction of the Parthenon in Athens?",
            "Roman Empire",
            "Greek Civilization",
            "Persian Empire",
            "Egyptian Empire",
            "Greek Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the legendary king of Uruk in ancient Mesopotamia and the central figure of the Epic of Gilgamesh?",
            "Hammurabi",
            "Gilgamesh",
            "Sargon",
            "Nebuchadnezzar II",
            "Gilgamesh"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which century did the Black Death, a devastating pandemic, occur in Europe?",
            "12th Century",
            "14th Century",
            "16th Century",
            "18th Century",
            "14th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous queen of ancient Egypt known for her efforts to restore traditional polytheistic religion?",
            "Nefertiti",
            "Hatshepsut",
            "Cleopatra",
            "Akhenaten",
            "Hatshepsut"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval queen of England is known for her role in the Hundred Years' War and later became a saint?",
            "Joan of Arc",
            "Isabella I of Castile",
            "Eleanor of Aquitaine",
            "Catherine the Great",
            "Joan of Arc"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the United States declare its independence from Great Britain?",
            "1756",
            "1776",
            "1804",
            "1820",
            "1776"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first woman to win a Nobel Prize and is known for her work in radioactivity?",
            "Marie Curie",
            "Rosalind Franklin",
            "Dorothy Crowfoot Hodgkin",
            "Barbara McClintock",
            "Marie Curie"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the construction of the Great Wall of China?",
            "Greek Civilization",
            "Roman Empire",
            "Inca Empire",
            "Chinese Civilization",
            "Chinese Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English queen known for her defeat of the Spanish Armada in 1588?",
            "Queen Elizabeth I",
            "Queen Mary I",
            "Queen Anne",
            "Queen Victoria",
            "Queen Elizabeth I"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who was the military leader and emperor of France who rose to prominence during the French Revolution?",
            "Napoleon Bonaparte",
            "Louis XIV",
            "Philip II",
            "Charles de Gaulle",
            "Napoleon Bonaparte"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval Islamic scholar is often referred to as the 'Father of Algebra'?",
            "Ibn Battuta",
            "Al-Razi",
            "Avicenna",
            "Al-Khwarizmi",
            "Al-Khwarizmi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Magna Carta, a foundational document in English constitutional history, come into effect?",
            "1215",
            "1302",
            "1429",
            "1558",
            "1215"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first emperor of the Qin Dynasty in ancient China, known for the construction of the Great Wall?",
            "Qin Shi Huang",
            "Han Wudi",
            "Confucius",
            "Sun Tzu",
            "Qin Shi Huang"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which century did the Renaissance primarily flourish in Europe?",
            "12th Century",
            "14th Century",
            "16th Century",
            "18th Century",
            "14th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the development of the first known system of writing called cuneiform?",
            "Sumerians",
            "Phoenicians",
            "Minoans",
            "Hittites",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous queen of ancient Egypt known for her relationships with Julius Caesar and Mark Antony?",
            "Cleopatra",
            "Nefertiti",
            "Hatshepsut",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which century did the French Revolution take place, leading to significant political and social changes in France?",
            "17th Century",
            "18th Century",
            "19th Century",
            "20th Century",
            "18th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian mystic and advisor to the Romanov family who played a significant role in Russian politics?",
            "Leon Trotsky",
            "Vladimir Lenin",
            "Grigori Rasputin",
            "Joseph Stalin",
            "Grigori Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which famous explorer led the first expedition that circumnavigated the Earth, proving that the Earth is round?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "James Cook",
            "John Cabot",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which war did the Battle of Thermopylae, famous for the stand of the Spartans, take place?",
            "Peloponnesian War",
            "Persian War",
            "Punic War",
            "Hundred Years' War",
            "Persian War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous English queen known for her support of the arts and the defeat of the Spanish Armada?",
            "Queen Anne",
            "Queen Elizabeth I",
            "Queen Victoria",
            "Queen Mary I",
            "Queen Elizabeth I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the United States formally annex the independent Republic of Texas?",
            "1836",
            "1845",
            "1850",
            "1861",
            "1845"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous military leader and strategist who led Carthage during the Second Punic War?",
            "Julius Caesar",
            "Alexander the Great",
            "Hannibal Barca",
            "Scipio Africanus",
            "Hannibal Barca"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the construction of the city of Machu Picchu in the Andes Mountains?",
            "Inca Civilization",
            "Mayan Civilization",
            "Aztec Civilization",
            "Olmec Civilization",
            "Inca Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese military strategist and philosopher known for 'The Art of War'?",
            "Confucius",
            "Laozi",
            "Sun Tzu",
            "Mencius",
            "Sun Tzu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Allied forces land on the beaches of Normandy, marking the beginning of the end of World War II in Europe?",
            "1940",
            "1942",
            "1944",
            "1946",
            "1944"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous queen of ancient Egypt known for her beauty and her relationship with Mark Antony?",
            "Cleopatra",
            "Nefertiti",
            "Hatshepsut",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which century did the Renaissance significantly impact art, culture, and science in Europe?",
            "14th Century",
            "16th Century",
            "18th Century",
            "20th Century",
            "16th Century"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher known for his contributions to ethics and his teachings on virtue?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Heraclitus",
            "Aristotle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval English king is known for his role in the Crusades and the signing of the Magna Carta?",
            "Richard the Lionheart",
            "Henry II",
            "Edward I",
            "John Lackland",
            "Richard the Lionheart"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Ottoman Empire capture Constantinople, leading to the end of the Byzantine Empire?",
            "1258",
            "1453",
            "1556",
            "1652",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian tsar known for his efforts to modernize Russia and his defeat in the Crimean War?",
            "Ivan the Terrible",
            "Peter the Great",
            "Catherine the Great",
            "Nicholas II",
            "Peter the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is credited with the invention of the wheel and the creation of the Code of Hammurabi?",
            "Sumerians",
            "Phoenicians",
            "Minoans",
            "Hittites",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Bolsheviks seize power in Russia, leading to the establishment of the Soviet Union?",
            "1917",
            "1923",
            "1931",
            "1945",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Mongol Empire, known for his military conquests and the creation of the largest contiguous empire in history?",
            "Genghis Khan",
            "Kublai Khan",
            "Attila the Hun",
            "Tamerlane",
            "Genghis Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the European Renaissance occur, marking a revival of interest in art, literature, and learning?",
            "Medieval Period",
            "Renaissance Period",
            "Baroque Period",
            "Enlightenment Period",
            "Renaissance Period"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous African-American abolitionist and former slave who became a prominent speaker and writer?",
            "Frederick Douglass",
            "Harriet Tubman",
            "Sojourner Truth",
            "Nat Turner",
            "Frederick Douglass"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Industrial Revolution begin in England, marking a period of significant economic and technological change?",
            "1700",
            "1750",
            "1800",
            "1850",
            "1750"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher known for his ethical teachings and the compilation of 'Analects'?",
            "Laozi",
            "Mencius",
            "Confucius",
            "Xunzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the construction of the city of Troy, as depicted in the 'Iliad'?",
            "Greek Civilization",
            "Roman Empire",
            "Persian Empire",
            "Hittite Civilization",
            "Hittite Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English scientist and mathematician credited with formulating the laws of motion and universal gravitation?",
            "Isaac Newton",
            "Galileo Galilei",
            "Johannes Kepler",
            "Copernicus",
            "Isaac Newton"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles officially end World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous medieval philosopher and theologian known for his 'Summa Theologica'?",
            "John Wycliffe",
            "Thomas Aquinas",
            "William of Ockham",
            "Roger Bacon",
            "Thomas Aquinas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which dynasty did the Ming-era Chinese explorer Zheng He undertake his voyages to Southeast Asia, South Asia, and Africa?",
            "Han Dynasty",
            "Tang Dynasty",
            "Ming Dynasty",
            "Qing Dynasty",
            "Ming Dynasty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous English nurse known for her work during the Crimean War and her contributions to modern nursing?",
            "Florence Nightingale",
            "Mary Seacole",
            "Clara Barton",
            "Dorothea Dix",
            "Florence Nightingale"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Declaration of Independence of the United States declare the thirteen American colonies as independent states?",
            "1765",
            "1776",
            "1789",
            "1799",
            "1776"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous German philosopher and economist known for his ideas on communism and his collaboration with Friedrich Engels?",
            "Karl Marx",
            "Friedrich Nietzsche",
            "Sigmund Freud",
            "Jean-Jacques Rousseau",
            "Karl Marx"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the construction of the Great Wall of China begin during the Ming Dynasty?",
            "221 BC",
            "206 BC",
            "1368 AD",
            "1369 AD",
            "1368 AD"
        )
    )



    questionsList.add(
        QuestionsModel(
            "Who was the famous American inventor and businessman known for his contributions to the development of the electric light bulb?",
            "Thomas Edison",
            "Nikola Tesla",
            "Alexander Graham Bell",
            "George Westinghouse",
            "Thomas Edison"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Renaissance significantly impact art, culture, and science in Europe?",
            "14th Century",
            "16th Century",
            "18th Century",
            "20th Century",
            "16th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English playwright and poet often regarded as the greatest writer in the English language?",
            "William Shakespeare",
            "Christopher Marlowe",
            "John Milton",
            "Geoffrey Chaucer",
            "William Shakespeare"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Greek city-state is known for its system of government where citizens participated directly in decision-making?",
            "Athens",
            "Sparta",
            "Corinth",
            "Thebes",
            "Athens"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Scottish king known for his victory over the English at the Battle of Bannockburn?",
            "Robert the Bruce",
            "William Wallace",
            "James I",
            "Malcolm III",
            "Robert the Bruce"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Russian Revolution lead to the establishment of the Soviet Union under communist rule?",
            "1917",
            "1923",
            "1931",
            "1945",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the construction of the city of Troy, as depicted in the 'Iliad'?",
            "Greek Civilization",
            "Roman Empire",
            "Persian Empire",
            "Hittite Civilization",
            "Hittite Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the French military and political leader who rose to prominence during the French Revolution and became Emperor of the French?",
            "Louis XIV",
            "Napoleon Bonaparte",
            "Charles de Gaulle",
            "Robespierre",
            "Napoleon Bonaparte"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Industrial Revolution begin in England, marking a period of significant economic and technological change?",
            "1700",
            "1750",
            "1800",
            "1850",
            "1750"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous queen of ancient Egypt known for her beauty and her relationship with Mark Antony?",
            "Cleopatra",
            "Nefertiti",
            "Hatshepsut",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the European Renaissance occur, marking a revival of interest in art, literature, and learning?",
            "Medieval Period",
            "Renaissance Period",
            "Baroque Period",
            "Enlightenment Period",
            "Renaissance Period"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous African-American abolitionist and former slave who became a prominent speaker and writer?",
            "Frederick Douglass",
            "Harriet Tubman",
            "Sojourner Truth",
            "Nat Turner",
            "Frederick Douglass"
        )
    )

        questionsList.shuffle()

    }
    fun historyStageFour(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is credited with the invention of the wheel and the creation of the Code of Hammurabi?",
            "Sumerians",
            "Phoenicians",
            "Minoans",
            "Hittites",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher known for his ethical teachings and the compilation of 'Analects'?",
            "Laozi",
            "Mencius",
            "Confucius",
            "Xunzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles officially end World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Mongol Empire, known for his military conquests and the creation of the largest contiguous empire in history?",
            "Genghis Khan",
            "Kublai Khan",
            "Attila the Hun",
            "Tamerlane",
            "Genghis Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English scientist and mathematician credited with formulating the laws of motion and universal gravitation?",
            "Isaac Newton",
            "Galileo Galilei",
            "Johannes Kepler",
            "Copernicus",
            "Isaac Newton"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian tsar known for his efforts to modernize Russia and his defeat in the Crimean War?",
            "Ivan the Terrible",
            "Peter the Great",
            "Catherine the Great",
            "Nicholas II",
            "Peter the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Ottoman Empire capture Constantinople, leading to the end of the Byzantine Empire?",
            "1258",
            "1453",
            "1556",
            "1652",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous African-American civil rights leader who played a key role in the American civil rights movement?",
            "Malcolm X",
            "Martin Luther King Jr.",
            "Rosa Parks",
            "W.E.B. Du Bois",
            "Martin Luther King Jr."
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the construction of the city of Carthage and its conflict with Rome in the Punic Wars?",
            "Greeks",
            "Persians",
            "Carthaginians",
            "Romans",
            "Carthaginians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English monarch who established the Church of England and had six marriages, leading to the English Reformation?",
            "Henry VIII",
            "Elizabeth I",
            "Mary I",
            "Edward VI",
            "Henry VIII"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Berlin Wall fall, leading to the reunification of East and West Germany?",
            "1985",
            "1989",
            "1991",
            "1995",
            "1989"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the founder of the Maurya Empire in ancient India and a key figure in the spread of Buddhism?",
            "Chandragupta Maurya",
            "Ashoka the Great",
            "Bindusara",
            "Kanishka",
            "Chandragupta Maurya"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which century did the Renaissance take place in Italy, marking a period of great cultural and artistic achievements?",
            "14th Century",
            "16th Century",
            "18th Century",
            "20th Century",
            "16th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the French military and political leader who rose to prominence during the French Revolution and became Emperor of the French?",
            "Louis XIV",
            "Napoleon Bonaparte",
            "Charles de Gaulle",
            "Robespierre",
            "Napoleon Bonaparte"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Allied forces land on the beaches of Normandy, marking the beginning of the end of World War II in Europe?",
            "1940",
            "1942",
            "1944",
            "1946",
            "1944"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Chinese military strategist and philosopher known for 'The Art of War'?",
            "Sun Tzu",
            "Confucius",
            "Laozi",
            "Mencius",
            "Sun Tzu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the construction of the city of Machu Picchu in the Andes Mountains?",
            "Maya Civilization",
            "Inca Empire",
            "Aztec Empire",
            "Olmec Civilization",
            "Inca Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher known for his contributions to geometry and the formulation of the Pythagorean theorem?",
            "Plato",
            "Socrates",
            "Aristotle",
            "Pythagoras",
            "Pythagoras"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which dynasty did the ancient Egyptian pharaoh Tutankhamun rule?",
            "Old Kingdom",
            "Middle Kingdom",
            "New Kingdom",
            "Ptolemaic Kingdom",
            "New Kingdom"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Roman statesman and military general who played a critical role in the events that led to the demise of the Roman Republic?",
            "Julius Caesar",
            "Augustus",
            "Cicero",
            "Pompey",
            "Julius Caesar"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and mathematician known for his contributions to geometry, including the discovery of the Pythagorean theorem?",
            "Aristotle",
            "Socrates",
            "Euclid",
            "Pythagoras",
            "Pythagoras"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In which ancient civilization did the Epic of Gilgamesh, one of the earliest known works of literature, originate?",
            "Egyptians",
            "Sumerians",
            "Mesoamericans",
            "Indus Valley Civilization",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the legendary queen of ancient Egypt known for her alliances, military campaigns, and romantic relationships with Mark Antony and Julius Caesar?",
            "Hatshepsut",
            "Cleopatra",
            "Nefertiti",
            "Hathor",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which dynasty did the ancient Chinese philosopher Confucius live and teach his ethical and moral principles?",
            "Qin Dynasty",
            "Han Dynasty",
            "Zhou Dynasty",
            "Shang Dynasty",
            "Zhou Dynasty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Indian emperor of the Maurya Dynasty known for his conversion to Buddhism and his spread of the religion throughout Asia?",
            "Ashoka the Great",
            "Chandragupta Maurya",
            "Bindusara",
            "Kanishka",
            "Ashoka the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Magna Carta, a foundational document for constitutional government, come into effect in medieval England?",
            "1215",
            "1300",
            "1348",
            "1400",
            "1215"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval European queen, known as Eleanor of Aquitaine, played a prominent role in the political and cultural life of the time?",
            "Eleanor of Provence",
            "Eleanor of Aquitaine",
            "Eleanor of Castile",
            "Eleanor of Aragon",
            "Eleanor of Aquitaine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Persian king who led the Achaemenid Empire during the Greco-Persian Wars, including the Battle of Thermopylae?",
            "Darius I",
            "Cyrus the Great",
            "Xerxes I",
            "Artaxerxes I",
            "Xerxes I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is known for the creation of the Rosetta Stone, a key to deciphering Egyptian hieroglyphs?",
            "Mesopotamians",
            "Minoans",
            "Hittites",
            "Ancient Egyptians",
            "Ancient Egyptians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the medieval Japanese military leader and founder of the first shogunate, known for his code of conduct for samurai?",
            "Oda Nobunaga",
            "Toyotomi Hideyoshi",
            "Minamoto no Yoritomo",
            "Takeda Shingen",
            "Minamoto no Yoritomo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what century did the Black Death, a devastating pandemic, sweep through Europe, Asia, and North Africa?",
            "12th Century",
            "14th Century",
            "16th Century",
            "18th Century",
            "14th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Mongol leader who founded the Yuan Dynasty in China and is known for his conquest of large parts of Asia?",
            "Kublai Khan",
            "Genghis Khan",
            "Ogedei Khan",
            "Mongke Khan",
            "Kublai Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is credited with the development of the first known system of writing, known as cuneiform?",
            "Harappans",
            "Sumerians",
            "Minoans",
            "Phoenicians",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English playwright and poet known for works such as 'Romeo and Juliet' and 'Hamlet' during the Renaissance?",
            "Christopher Marlowe",
            "Ben Jonson",
            "William Shakespeare",
            "John Milton",
            "William Shakespeare"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Ottoman Empire capture Constantinople, marking the end of the Byzantine Empire?",
            "1356",
            "1453",
            "1556",
            "1652",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek historian and author of 'Histories,' documenting the Greco-Persian Wars and the customs of various cultures?",
            "Herodotus",
            "Thucydides",
            "Xenophon",
            "Plutarch",
            "Herodotus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval European ruler, known as Charlemagne, became the first Holy Roman Emperor and promoted the Carolingian Renaissance?",
            "Louis the Pious",
            "Charles Martel",
            "Pepin the Short",
            "Charlemagne",
            "Charlemagne"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the 16th-century queen of England, known for her defeat of the Spanish Armada and her support of the arts and exploration?",
            "Elizabeth I",
            "Mary I",
            "Anne Boleyn",
            "Catherine Parr",
            "Elizabeth I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Renaissance in Europe occur, characterized by a renewed interest in art, literature, and humanism?",
            "Medieval Era",
            "Enlightenment Era",
            "Renaissance Era",
            "Industrial Era",
            "Renaissance Era"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential philosopher and author of 'The Prince,' offering advice on political leadership during the Renaissance in Italy?",
            "Machiavelli",
            "Dante Alighieri",
            "Thomas More",
            "Erasmus",
            "Machiavelli"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Persian king who led the Achaemenid Empire during the Greco-Persian Wars and was defeated at the Battle of Marathon?",
            "Darius I",
            "Cyrus the Great",
            "Xerxes I",
            "Artaxerxes I",
            "Darius I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Byzantine Empire fall to the Ottoman Turks, marking the end of the medieval Eastern Roman Empire?",
            "1261",
            "1453",
            "1588",
            "1624",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Italian explorer who, while sailing under the Spanish flag, reached the Americas in 1492?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Marco Polo",
            "Amerigo Vespucci",
            "Christopher Columbus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Industrial Revolution begin, bringing significant economic and technological changes to Europe and the world?",
            "18th Century",
            "19th Century",
            "20th Century",
            "21st Century",
            "18th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Egyptian queen, known for her relationship with Julius Caesar and Mark Antony, and her death by suicide?",
            "Nefertiti",
            "Cleopatra",
            "Hatshepsut",
            "Nefertari",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what century did the Hundred Years' War take place between England and France, lasting from 1337 to 1453?",
            "12th Century",
            "14th Century",
            "16th Century",
            "18th Century",
            "14th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous nurse known for her contributions during the Crimean War and the establishment of modern nursing practices?",
            "Florence Nightingale",
            "Clara Barton",
            "Mary Seacole",
            "Dorothea Dix",
            "Florence Nightingale"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the United States declare its independence from Great Britain with the adoption of the Declaration of Independence?",
            "1776",
            "1789",
            "1804",
            "1820",
            "1776"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the military leader and emperor of France who rose to power during the French Revolution and later faced defeat at Waterloo?",
            "Louis XVI",
            "Napoleon Bonaparte",
            "Robespierre",
            "Louis Philippe",
            "Napoleon Bonaparte"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Renaissance in Europe occur, marked by a revival of interest in art, literature, and classical learning?",
            "Medieval Era",
            "Renaissance Era",
            "Enlightenment Era",
            "Industrial Era",
            "Renaissance Era"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English monarch known for his six marriages and the separation of the Church of England from the Catholic Church?",
            "Henry VIII",
            "Elizabeth I",
            "Mary I",
            "Edward VI",
            "Henry VIII"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Bolsheviks, led by Vladimir Lenin, seize power in Russia, leading to the establishment of the Soviet Union?",
            "1905",
            "1917",
            "1923",
            "1936",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous military commander of ancient Carthage who crossed the Alps with elephants during the Second Punic War?",
            "Hannibal",
            "Scipio Africanus",
            "Hamilcar Barca",
            "Hasdrubal",
            "Hannibal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the United States drop atomic bombs on the Japanese cities of Hiroshima and Nagasaki, leading to Japan's surrender in World War II?",
            "1941",
            "1944",
            "1945",
            "1950",
            "1945"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first President of the United States, known for his leadership during the American Revolutionary War?",
            "Thomas Jefferson",
            "John Adams",
            "George Washington",
            "James Madison",
            "George Washington"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which dynasty did the Mongol Empire reach its height under the leadership of Kublai Khan?",
            "Yuan Dynasty",
            "Ming Dynasty",
            "Qing Dynasty",
            "Han Dynasty",
            "Yuan Dynasty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Roman general and statesman known for his role in the conspiracy to assassinate Julius Caesar?",
            "Brutus",
            "Cicero",
            "Cassius",
            "Mark Antony",
            "Brutus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what century did the Renaissance in Italy give rise to significant cultural and artistic developments?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Indian independence movement against British rule and a key figure in the development of nonviolent civil disobedience?",
            "Jawaharlal Nehru",
            "Mahatma Gandhi",
            "Subhas Chandra Bose",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Berlin Wall, a symbol of the Cold War division between East and West Germany, fall?",
            "1989",
            "1991",
            "1993",
            "1986",
            "1989"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who was the medieval English king who signed the Magna Carta in 1215, limiting the powers of the monarchy and laying the foundation for constitutional government?",
            "Henry II",
            "Richard the Lionheart",
            "John",
            "Edward I",
            "John"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Renaissance begin in Italy, marking a period of cultural and artistic rebirth?",
            "1300",
            "1400",
            "1500",
            "1600",
            "1400"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian monk and mystic who played a significant role in the Russian Revolution and the downfall of the Romanov dynasty?",
            "Rasputin",
            "Lenin",
            "Stalin",
            "Trotsky",
            "Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which century did the Ming Dynasty rule in China, known for its cultural achievements, naval expeditions, and the construction of the Forbidden City?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Protestant Reformation in the 16th century, challenging the practices of the Catholic Church?",
            "John Calvin",
            "Martin Luther",
            "John Wycliffe",
            "Huldrych Zwingli",
            "Martin Luther"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the United States enter World War I, joining the Allies in their fight against the Central Powers?",
            "1914",
            "1917",
            "1920",
            "1939",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese communist leader and founding father of the People's Republic of China?",
            "Mao Zedong",
            "Chiang Kai-shek",
            "Deng Xiaoping",
            "Sun Yat-sen",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Enlightenment take place, characterized by a focus on reason, science, and individual rights?",
            "Renaissance",
            "Enlightenment",
            "Industrial Revolution",
            "Victorian Era",
            "Enlightenment"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher known for his teachings on ethics and virtue, and was the teacher of Alexander the Great?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Diogenes",
            "Aristotle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles mark the official end of World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential Italian explorer and navigator who completed four voyages across the Atlantic Ocean, opening the way for widespread European exploration and the eventual conquest of the Americas?",
            "Vasco da Gama",
            "Ferdinand Magellan",
            "Christopher Columbus",
            "Amerigo Vespucci",
            "Christopher Columbus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the French Revolution begin, leading to significant political and social changes in France?",
            "1789",
            "1799",
            "1804",
            "1815",
            "1789"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Egyptian queen, known for her relationship with Julius Caesar and Mark Antony?",
            "Cleopatra",
            "Nefertiti",
            "Hatshepsut",
            "Nefertari",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which dynasty did the Han Empire flourish in ancient China, known for its contributions to art, science, and governance?",
            "Qin Dynasty",
            "Han Dynasty",
            "Tang Dynasty",
            "Song Dynasty",
            "Han Dynasty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian leader during World War II, known for his role in defeating Nazi Germany and the expansion of Soviet influence?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Nikita Khrushchev",
            "Mikhail Gorbachev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Industrial Revolution begin in England, transforming economic and social structures?",
            "1700",
            "1750",
            "1800",
            "1850",
            "1750"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Roman general and statesman who played a crucial role in the events that led to the demise of the Roman Republic?",
            "Julius Caesar",
            "Augustus",
            "Brutus",
            "Cicero",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Byzantine Empire reach its height, preserving and transmitting classical knowledge and contributing to the development of Christianity?",
            "Early Middle Ages",
            "High Middle Ages",
            "Late Middle Ages",
            "Golden Age",
            "Early Middle Ages"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Mongol leader and founder of the Yuan Dynasty in China, known for his military conquests and the establishment of the Mongol Empire?",
            "Genghis Khan",
            "Kublai Khan",
            "Timur",
            "Attila the Hun",
            "Kublai Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Tordesillas divide the newly discovered lands outside Europe between Portugal and Spain?",
            "1492",
            "1517",
            "1543",
            "1494",
            "1494"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who was the influential French political thinker and writer known for his work 'The Spirit of the Laws,' which advocated the separation of powers?",
            "Jean-Jacques Rousseau",
            "Montesquieu",
            "Voltaire",
            "John Locke",
            "Montesquieu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Pax Romana, a long period of relative peace and stability across the Roman Empire, occur?",
            "1st Century BCE",
            "1st Century CE",
            "2nd Century BCE",
            "2nd Century CE",
            "1st Century CE"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese military and political leader who played a key role in the founding of the People's Republic of China and the Chinese Communist Party?",
            "Deng Xiaoping",
            "Sun Yat-sen",
            "Mao Zedong",
            "Chiang Kai-shek",
            "Mao Zedong"
        )
    )

        questionsList.shuffle()

    }
    fun historyStageFive(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Who was the influential French political thinker and writer known for his work 'The Spirit of the Laws,' which advocated the separation of powers?",
            "Jean-Jacques Rousseau",
            "Montesquieu",
            "Voltaire",
            "John Locke",
            "Montesquieu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Pax Romana, a long period of relative peace and stability across the Roman Empire, occur?",
            "1st Century BCE",
            "1st Century CE",
            "2nd Century BCE",
            "2nd Century CE",
            "1st Century CE"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese military and political leader who played a key role in the founding of the People's Republic of China and the Chinese Communist Party?",
            "Deng Xiaoping",
            "Sun Yat-sen",
            "Mao Zedong",
            "Chiang Kai-shek",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the medieval English king who signed the Magna Carta in 1215, limiting the powers of the monarchy and laying the foundation for constitutional government?",
            "Henry II",
            "Richard the Lionheart",
            "John",
            "Edward I",
            "John"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Italian explorer who, while sailing under the Spanish flag, reached the Americas in 1492?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Marco Polo",
            "Amerigo Vespucci",
            "Christopher Columbus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Renaissance in Europe occur, characterized by a renewed interest in art, literature, and humanism?",
            "Medieval Era",
            "Enlightenment Era",
            "Renaissance Era",
            "Industrial Era",
            "Renaissance Era"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential philosopher and author of 'The Prince,' offering advice on political leadership during the Renaissance in Italy?",
            "Machiavelli",
            "Dante Alighieri",
            "Thomas More",
            "Erasmus",
            "Machiavelli"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Byzantine Empire fall to the Ottoman Turks, marking the end of the medieval Eastern Roman Empire?",
            "1261",
            "1453",
            "1588",
            "1624",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Industrial Revolution begin, bringing significant economic and technological changes to Europe and the world?",
            "18th Century",
            "19th Century",
            "20th Century",
            "21st Century",
            "18th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Egyptian queen, known for her relationship with Julius Caesar and Mark Antony, and her death by suicide?",
            "Nefertiti",
            "Cleopatra",
            "Hatshepsut",
            "Nefertari",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Hundred Years' War take place between England and France, lasting from 1337 to 1453?",
            "12th Century",
            "14th Century",
            "16th Century",
            "18th Century",
            "14th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous nurse known for her contributions during the Crimean War and the establishment of modern nursing practices?",
            "Florence Nightingale",
            "Clara Barton",
            "Mary Seacole",
            "Dorothea Dix",
            "Florence Nightingale"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the United States declare its independence from Great Britain with the adoption of the Declaration of Independence?",
            "1776",
            "1789",
            "1804",
            "1820",
            "1776"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the military leader and emperor of France who rose to power during the French Revolution and later faced defeat at Waterloo?",
            "Louis XVI",
            "Napoleon Bonaparte",
            "Robespierre",
            "Louis Philippe",
            "Napoleon Bonaparte"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Renaissance in Europe occur, marked by a revival of interest in art, literature, and classical learning?",
            "Medieval Era",
            "Renaissance Era",
            "Enlightenment Era",
            "Industrial Era",
            "Renaissance Era"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English monarch known for his six marriages and the separation of the Church of England from the Catholic Church?",
            "Henry VIII",
            "Elizabeth I",
            "Mary I",
            "Edward VI",
            "Henry VIII"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Bolsheviks, led by Vladimir Lenin, seize power in Russia, leading to the establishment of the Soviet Union?",
            "1905",
            "1917",
            "1922",
            "1930",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the founder of Buddhism, known as the Buddha, who achieved enlightenment under the Bodhi tree?",
            "Confucius",
            "Siddhartha Gautama",
            "Laozi",
            "Ashoka the Great",
            "Siddhartha Gautama"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which dynasty did the Islamic Golden Age occur, marked by advancements in science, philosophy, and the arts?",
            "Abbasid Dynasty",
            "Umayyad Dynasty",
            "Fatimid Dynasty",
            "Safavid Dynasty",
            "Abbasid Dynasty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and teacher of Alexander the Great, known for his contributions to ethics and virtue?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Diogenes",
            "Aristotle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what century did the Ming Dynasty rule in China, known for its cultural achievements, naval expeditions, and the construction of the Forbidden City?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Protestant Reformation in the 16th century, challenging the practices of the Catholic Church?",
            "John Calvin",
            "Martin Luther",
            "John Wycliffe",
            "Huldrych Zwingli",
            "Martin Luther"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles mark the official end of World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese communist leader and founding father of the People's Republic of China?",
            "Mao Zedong",
            "Chiang Kai-shek",
            "Deng Xiaoping",
            "Sun Yat-sen",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Enlightenment take place, characterized by a focus on reason, science, and individual rights?",
            "Renaissance",
            "Enlightenment",
            "Industrial Revolution",
            "Victorian Era",
            "Enlightenment"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher known for his teachings on ethics and virtue, and was the teacher of Alexander the Great?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Diogenes",
            "Aristotle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles mark the official end of World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential Italian explorer and navigator who completed four voyages across the Atlantic Ocean, opening the way for widespread European exploration and the eventual conquest of the Americas?",
            "Vasco da Gama",
            "Ferdinand Magellan",
            "Christopher Columbus",
            "Amerigo Vespucci",
            "Christopher Columbus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the French Revolution begin, leading to significant political and social changes in France?",
            "1789",
            "1799",
            "1804",
            "1815",
            "1789"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian leader during World War II, known for his role in defeating Nazi Germany and the expansion of Soviet influence?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Nikita Khrushchev",
            "Mikhail Gorbachev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Industrial Revolution begin in England, transforming economic and social structures?",
            "1700",
            "1750",
            "1800",
            "1850",
            "1750"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Roman general and statesman who played a crucial role in the events that led to the demise of the Roman Republic?",
            "Julius Caesar",
            "Augustus",
            "Brutus",
            "Cicero",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Roman general and statesman who played a crucial role in the events that led to the demise of the Roman Republic?",
            "Julius Caesar",
            "Augustus",
            "Brutus",
            "Cicero",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Byzantine Empire reach its height, with notable emperors like Justinian and achievements such as the Hagia Sophia?",
            "Golden Age",
            "Classical Period",
            "Medieval Era",
            "Byzantine Peak",
            "Golden Age"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian mystic and advisor to the Romanovs, influencing decisions at the court of Nicholas II, especially regarding Rasputin?",
            "Grigori Rasputin",
            "Vladimir Lenin",
            "Leon Trotsky",
            "Joseph Stalin",
            "Grigori Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Berlin Wall fall, marking the symbolic end of the Cold War and the reunification of East and West Germany?",
            "1985",
            "1989",
            "1991",
            "1995",
            "1989"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential leader of the Indian independence movement, known for his philosophy of nonviolent resistance?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Ming Dynasty rule in China, known for its cultural achievements, naval expeditions, and the construction of the Forbidden City?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Protestant Reformation in the 16th century, challenging the practices of the Catholic Church?",
            "John Calvin",
            "Martin Luther",
            "John Wycliffe",
            "Huldrych Zwingli",
            "Martin Luther"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles mark the official end of World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher whose ideas have profoundly influenced Chinese thought and culture?",
            "Confucius",
            "Laozi",
            "Mencius",
            "Zhuangzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Byzantine Empire reach its height, with Emperor Justinian overseeing significant achievements and expansions?",
            "Golden Age",
            "Classical Period",
            "Medieval Era",
            "Byzantine Peak",
            "Golden Age"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek historian and author of 'Histories,' chronicling the Greco-Persian Wars and providing insights into various cultures?",
            "Herodotus",
            "Thucydides",
            "Xenophon",
            "Plutarch",
            "Herodotus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Ottoman Empire capture Constantinople, marking the end of the Byzantine Empire?",
            "1204",
            "1299",
            "1453",
            "1526",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese military and political leader who played a key role in the founding of the People's Republic of China and the Chinese Communist Party?",
            "Deng Xiaoping",
            "Sun Yat-sen",
            "Mao Zedong",
            "Chiang Kai-shek",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the European powers sign the Treaty of Westphalia, marking the end of the Thirty Years' War and establishing principles of state sovereignty?",
            "1618",
            "1648",
            "1701",
            "1756",
            "1648"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous admiral and explorer known for his voyages across the Atlantic Ocean, opening the door to the Age of Exploration?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "Amerigo Vespucci",
            "Christopher Columbus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Renaissance in Europe occur, marked by a revival of interest in art, literature, and classical learning?",
            "Medieval Era",
            "Renaissance Era",
            "Enlightenment Era",
            "Industrial Era",
            "Renaissance Era"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential philosopher and author of 'The Prince,' offering advice on political leadership during the Renaissance in Italy?",
            "Machiavelli",
            "Dante Alighieri",
            "Thomas More",
            "Erasmus",
            "Machiavelli"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Byzantine Empire fall to the Ottoman Turks, marking the end of the medieval Eastern Roman Empire?",
            "1261",
            "1453",
            "1588",
            "1624",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Industrial Revolution begin, bringing significant economic and technological changes to Europe and the world?",
            "18th Century",
            "19th Century",
            "20th Century",
            "21st Century",
            "18th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient empire was known for its code of laws, including the principle of 'an eye for an eye'?",
            "Persian Empire",
            "Roman Empire",
            "Babylonian Empire",
            "Mongol Empire",
            "Babylonian Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen who ruled alongside several pharaohs, including Thutmose III?",
            "Hatshepsut",
            "Cleopatra",
            "Nefertiti",
            "Isis",
            "Hatshepsut"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Age of Enlightenment take place, emphasizing reason, science, and individual rights?",
            "Medieval Era",
            "Renaissance Era",
            "Enlightenment Era",
            "Industrial Era",
            "Enlightenment Era"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential leader of the Indian independence movement, advocating for nonviolent civil disobedience?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Russian Revolution lead to the overthrow of the Romanov dynasty and the establishment of a socialist government?",
            "1905",
            "1917",
            "1923",
            "1931",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher known for his contributions to mathematics and geometry?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Euclid",
            "Euclid"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Gupta Empire flourish in ancient India, known for its advancements in science, art, and literature?",
            "Maurya Period",
            "Gupta Period",
            "Chola Period",
            "Mughal Period",
            "Gupta Period"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Haitian Revolution, which resulted in the establishment of the first independent black republic?",
            "Toussaint Louverture",
            "Simon Bolivar",
            "Miguel Hidalgo",
            "Simón Bolívar",
            "Toussaint Louverture"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Magna Carta, a foundational document in the history of constitutional government, come into effect?",
            "1215",
            "1299",
            "1347",
            "1382",
            "1215"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous queen of ancient Egypt known for her relationships with Julius Caesar and Mark Antony?",
            "Hatshepsut",
            "Nefertiti",
            "Cleopatra",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Byzantine Empire reach its height, with notable emperors like Justinian and achievements such as the Hagia Sophia?",
            "Golden Age",
            "Classical Period",
            "Medieval Era",
            "Byzantine Peak",
            "Golden Age"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian mystic and advisor to the Romanovs, influencing decisions at the court of Nicholas II, especially regarding Rasputin?",
            "Grigori Rasputin",
            "Vladimir Lenin",
            "Leon Trotsky",
            "Joseph Stalin",
            "Grigori Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Berlin Wall fall, marking the symbolic end of the Cold War and the reunification of East and West Germany?",
            "1985",
            "1989",
            "1991",
            "1995",
            "1989"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential leader of the Indian independence movement, known for his philosophy of nonviolent resistance?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Ming Dynasty rule in China, known for its cultural achievements, naval expeditions, and the construction of the Forbidden City?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Protestant Reformation in the 16th century, challenging the practices of the Catholic Church?",
            "John Calvin",
            "Martin Luther",
            "John Wycliffe",
            "Huldrych Zwingli",
            "Martin Luther"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles mark the official end of World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher whose ideas have profoundly influenced Chinese thought and culture?",
            "Confucius",
            "Laozi",
            "Mencius",
            "Zhuangzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Byzantine Empire reach its height, with Emperor Justinian overseeing significant achievements and expansions?",
            "Golden Age",
            "Classical Period",
            "Medieval Era",
            "Byzantine Peak",
            "Golden Age"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek historian and author of 'Histories,' chronicling the Greco-Persian Wars and providing insights into various cultures?",
            "Herodotus",
            "Thucydides",
            "Xenophon",
            "Plutarch",
            "Herodotus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Ottoman Empire capture Constantinople, marking the end of the Byzantine Empire?",
            "1204",
            "1299",
            "1453",
            "1526",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese military and political leader who played a key role in the foundation of the People's Republic of China?",
            "Chiang Kai-shek",
            "Sun Yat-sen",
            "Mao Zedong",
            "Deng Xiaoping",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which century did the Renaissance take place in Europe, marking a period of cultural, artistic, and intellectual growth?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Which ancient empire was known for its code of laws, including the principle of 'an eye for an eye'?",
            "Persian Empire",
            "Roman Empire",
            "Babylonian Empire",
            "Mongol Empire",
            "Babylonian Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen who ruled alongside several pharaohs, including Thutmose III?",
            "Hatshepsut",
            "Cleopatra",
            "Nefertiti",
            "Isis",
            "Hatshepsut"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Age of Enlightenment take place, emphasizing reason, science, and individual rights?",
            "Medieval Era",
            "Renaissance Era",
            "Enlightenment Era",
            "Industrial Era",
            "Enlightenment Era"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential leader of the Indian independence movement, advocating for nonviolent civil disobedience?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Russian Revolution lead to the overthrow of the Romanov dynasty and the establishment of a socialist government?",
            "1905",
            "1917",
            "1923",
            "1931",
            "1917"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher known for his contributions to mathematics and geometry?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Euclid",
            "Euclid"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Gupta Empire flourish in ancient India, known for its advancements in science, art, and literature?",
            "Maurya Period",
            "Gupta Period",
            "Chola Period",
            "Mughal Period",
            "Gupta Period"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Haitian Revolution, which resulted in the establishment of the first independent black republic?",
            "Toussaint Louverture",
            "Simon Bolivar",
            "Miguel Hidalgo",
            "Simón Bolívar",
            "Toussaint Louverture"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Magna Carta, a foundational document in the history of constitutional government, come into effect?",
            "1215",
            "1299",
            "1347",
            "1382",
            "1215"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous queen of ancient Egypt known for her relationships with Julius Caesar and Mark Antony?",
            "Hatshepsut",
            "Nefertiti",
            "Cleopatra",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Byzantine Empire reach its height, with notable emperors like Justinian and achievements such as the Hagia Sophia?",
            "Golden Age",
            "Classical Period",
            "Medieval Era",
            "Byzantine Peak",
            "Golden Age"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian mystic and advisor to the Romanovs, influencing decisions at the court of Nicholas II, especially regarding Rasputin?",
            "Grigori Rasputin",
            "Vladimir Lenin",
            "Leon Trotsky",
            "Joseph Stalin",
            "Grigori Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Berlin Wall fall, marking the symbolic end of the Cold War and the reunification of East and West Germany?",
            "1985",
            "1989",
            "1991",
            "1995",
            "1989"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential leader of the Indian independence movement, known for his philosophy of nonviolent resistance?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Ming Dynasty rule in China, known for its cultural achievements, naval expeditions, and the construction of the Forbidden City?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Protestant Reformation in the 16th century, challenging the practices of the Catholic Church?",
            "John Calvin",
            "Martin Luther",
            "John Wycliffe",
            "Huldrych Zwingli",
            "Martin Luther"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles mark the official end of World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher whose ideas have profoundly influenced Chinese thought and culture?",
            "Confucius",
            "Laozi",
            "Mencius",
            "Zhuangzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Byzantine Empire reach its height, with Emperor Justinian overseeing significant achievements and expansions?",
            "Golden Age",
            "Classical Period",
            "Medieval Era",
            "Byzantine Peak",
            "Golden Age"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek historian and author of 'Histories,' chronicling the Greco-Persian Wars and providing insights into various cultures?",
            "Herodotus",
            "Thucydides",
            "Xenophon",
            "Plutarch",
            "Herodotus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Ottoman Empire capture Constantinople, marking the end of the Byzantine Empire?",
            "1204",
            "1299",
            "1453",
            "1526",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese military and political leader who played a key role in the foundation of the People's Republic of China?",
            "Chiang Kai-shek",
            "Sun Yat-sen",
            "Mao Zedong",
            "Deng Xiaoping",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which century did the Renaissance take place in Europe, marking a period of cultural, artistic, and intellectual growth?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

        questionsList.shuffle()

    }
    fun historyStageSix(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Who was the Byzantine emperor responsible for the construction of the Hagia Sophia and the codification of Roman law?",
            "Justinian I",
            "Constantine the Great",
            "Leo III",
            "Heraclius",
            "Justinian I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the European Renaissance, who wrote 'The Prince,' a political treatise exploring the acquisition and maintenance of political power?",
            "Niccolò Machiavelli",
            "Leonardo da Vinci",
            "Galileo Galilei",
            "Giorgio Vasari",
            "Niccolò Machiavelli"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Ottoman Turks capture Constantinople, leading to the end of the Byzantine Empire?",
            "1453",
            "1492",
            "1526",
            "1571",
            "1453"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek historian and author of 'The History of the Peloponnesian War,' chronicling the conflict between Athens and Sparta?",
            "Herodotus",
            "Thucydides",
            "Xenophon",
            "Plutarch",
            "Thucydides"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which European monarch was known as the 'Sun King' and ruled France for over 72 years, overseeing the construction of the Palace of Versailles?",
            "Louis XIII",
            "Louis XIV",
            "Louis XV",
            "Louis XVI",
            "Louis XIV"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Protestant Reformation, who was the Swiss theologian known for his doctrine of predestination and the development of Calvinism?",
            "John Calvin",
            "Martin Luther",
            "John Wycliffe",
            "Huldrych Zwingli",
            "John Calvin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Greek philosopher founded the Academy in Athens and was the teacher of Aristotle?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Diogenes",
            "Plato"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the French Revolution witness the Reign of Terror, characterized by mass executions and political upheaval?",
            "1769",
            "1789",
            "1793",
            "1804",
            "1793"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian emperor who implemented a series of major reforms known as the 'Great Reforms' during the 19th century?",
            "Nicholas II",
            "Alexander II",
            "Peter the Great",
            "Ivan the Terrible",
            "Alexander II"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, who sculpted the statue of David and painted the ceiling of the Sistine Chapel in Vatican City?",
            "Leonardo da Vinci",
            "Michelangelo",
            "Raphael",
            "Donatello",
            "Michelangelo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Tordesillas divide the newly discovered lands outside Europe between Portugal and Spain?",
            "1452",
            "1492",
            "1521",
            "1494",
            "1494"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Bolshevik Party and the architect of the October Revolution in Russia in 1917?",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Leon Trotsky",
            "Nikita Khrushchev",
            "Vladimir Lenin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Asian leader was the founder of the Mongol Empire, one of the largest empires in history?",
            "Genghis Khan",
            "Kublai Khan",
            "Timur",
            "Attila the Hun",
            "Genghis Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which period did the Scientific Revolution take place, with advancements in astronomy, physics, and biology?",
            "15th Century",
            "16th Century",
            "17th Century",
            "18th Century",
            "17th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher who emphasized ethical behavior, family values, and social harmony?",
            "Confucius",
            "Laozi",
            "Mencius",
            "Zhuangzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Versailles mark the official end of World War I?",
            "1917",
            "1919",
            "1921",
            "1923",
            "1919"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Roman general and statesman who played a key role in the transformation of the Roman Republic into the Roman Empire?",
            "Julius Caesar",
            "Augustus",
            "Cicero",
            "Spartacus",
            "Augustus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During which era did the Renaissance take place in Europe, marking a period of cultural, artistic, and intellectual growth?",
            "14th Century",
            "15th Century",
            "16th Century",
            "17th Century",
            "15th Century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential queen of ancient Persia who played a crucial role in the rescue of the Jewish people, as recounted in the Bible?",
            "Cleopatra",
            "Hatshepsut",
            "Esther",
            "Nefertiti",
            "Esther"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the founder of the Persian Empire, known for his military conquests and the establishment of a vast empire?",
            "Cyrus the Great",
            "Darius I",
            "Xerxes I",
            "Cambyses II",
            "Cyrus the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Middle Ages, who was the Viking explorer and Norse hero who reached North America around the year 1000 AD?",
            "Leif Erikson",
            "Erik the Red",
            "Olaf Tryggvason",
            "Harald Hardrada",
            "Leif Erikson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is credited with the creation of the first known system of writing, known as cuneiform?",
            "Egyptians",
            "Sumerians",
            "Indus Valley Civilization",
            "Chinese",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Chinese admiral and explorer who led several naval expeditions in the early 15th century, reaching as far as Africa?",
            "Zheng He",
            "Kublai Khan",
            "Yongle Emperor",
            "Qin Shi Huang",
            "Zheng He"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the European colonization of the Americas, which conquistador led the expedition that resulted in the fall of the Aztec Empire?",
            "Francisco Pizarro",
            "Hernán Cortés",
            "Juan Ponce de León",
            "Francisco Vásquez de Coronado",
            "Hernán Cortés"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and mathematician often referred to as the 'Father of Geometry'?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Euclid",
            "Euclid"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Industrial Revolution, which English inventor and engineer played a key role in the development of the spinning jenny and the water frame?",
            "James Watt",
            "George Stephenson",
            "Richard Arkwright",
            "Samuel Crompton",
            "Richard Arkwright"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Carthaginian general who famously led his army, including war elephants, across the Alps during the Second Punic War?",
            "Scipio Africanus",
            "Hannibal Barca",
            "Hamilcar Barca",
            "Hasdrubal Barca",
            "Hannibal Barca"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Byzantine Empire, which emperor is best known for his codification of Roman law into the Corpus Juris Civilis?",
            "Constantine the Great",
            "Justinian I",
            "Theodosius I",
            "Leo III",
            "Justinian I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Indian emperor and founder of the Maurya Empire, known for his promotion of Buddhism and the spread of its teachings?",
            "Ashoka the Great",
            "Chandragupta Maurya",
            "Bindusara",
            "Kanishka",
            "Ashoka the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Magna Carta, a foundational document for constitutional law, receive royal seal during the reign of King John of England?",
            "1215",
            "1264",
            "1298",
            "1342",
            "1215"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Aztec emperor at the time of the Spanish conquest, captured by Hernán Cortés during the siege of Tenochtitlan?",
            "Moctezuma II",
            "Montezuma I",
            "Cuitláhuac",
            "Cuauhtémoc",
            "Moctezuma II"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Exploration, which Portuguese explorer led the first expedition to circumnavigate the globe, though he died before completing the journey?",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "Christopher Columbus",
            "John Cabot",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Roman general and statesman who defeated Mark Antony and Cleopatra in the Battle of Actium, leading to the end of the Roman Republic?",
            "Julius Caesar",
            "Augustus",
            "Cicero",
            "Pompey",
            "Augustus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Black Death, one of the deadliest pandemics in human history, reach Europe and cause widespread devastation?",
            "1325",
            "1347",
            "1371",
            "1398",
            "1347"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Japanese shogun and military dictator who successfully unified Japan in the late 16th century?",
            "Oda Nobunaga",
            "Toyotomi Hideyoshi",
            "Tokugawa Ieyasu",
            "Date Masamune",
            "Tokugawa Ieyasu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Enlightenment, which French philosopher and writer advocated for the separation of powers and influenced the development of modern political thought?",
            "Voltaire",
            "Montesquieu",
            "Rousseau",
            "Diderot",
            "Montesquieu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen and pharaoh known for her ambitious building projects, including the construction of the Temple of Dendera?",
            "Hatshepsut",
            "Nefertiti",
            "Cleopatra",
            "Hathor",
            "Hatshepsut"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Nanjing end the First Opium War between China and the United Kingdom?",
            "1839",
            "1842",
            "1856",
            "1860",
            "1842"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the founder of the Persian Empire, known for his military conquests and the establishment of a vast empire?",
            "Cyrus the Great",
            "Darius I",
            "Xerxes I",
            "Cambyses II",
            "Cyrus the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Middle Ages, who was the Viking explorer and Norse hero who reached North America around the year 1000 AD?",
            "Leif Erikson",
            "Erik the Red",
            "Olaf Tryggvason",
            "Harald Hardrada",
            "Leif Erikson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization is credited with the creation of the first known system of writing, known as cuneiform?",
            "Egyptians",
            "Sumerians",
            "Indus Valley Civilization",
            "Chinese",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Chinese admiral and explorer who led several naval expeditions in the early 15th century, reaching as far as Africa?",
            "Zheng He",
            "Kublai Khan",
            "Yongle Emperor",
            "Qin Shi Huang",
            "Zheng He"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the European colonization of the Americas, which conquistador led the expedition that resulted in the fall of the Aztec Empire?",
            "Francisco Pizarro",
            "Hernán Cortés",
            "Juan Ponce de León",
            "Francisco Vásquez de Coronado",
            "Hernán Cortés"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and mathematician often referred to as the 'Father of Geometry'?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Euclid",
            "Euclid"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Industrial Revolution, which English inventor and engineer played a key role in the development of the spinning jenny and the water frame?",
            "James Watt",
            "George Stephenson",
            "Richard Arkwright",
            "Samuel Crompton",
            "Richard Arkwright"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Carthaginian general who famously led his army, including war elephants, across the Alps during the Second Punic War?",
            "Scipio Africanus",
            "Hannibal Barca",
            "Hamilcar Barca",
            "Hasdrubal Barca",
            "Hannibal Barca"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Byzantine Empire, which emperor is best known for his codification of Roman law into the Corpus Juris Civilis?",
            "Constantine the Great",
            "Justinian I",
            "Theodosius I",
            "Leo III",
            "Justinian I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Indian emperor and founder of the Maurya Empire, known for his promotion of Buddhism and the spread of its teachings?",
            "Ashoka the Great",
            "Chandragupta Maurya",
            "Bindusara",
            "Kanishka",
            "Ashoka the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Magna Carta, a foundational document for constitutional law, receive royal seal during the reign of King John of England?",
            "1215",
            "1264",
            "1298",
            "1342",
            "1215"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Aztec emperor at the time of the Spanish conquest, captured by Hernán Cortés during the siege of Tenochtitlan?",
            "Moctezuma II",
            "Montezuma I",
            "Cuitláhuac",
            "Cuauhtémoc",
            "Moctezuma II"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Exploration, which Portuguese explorer led the first expedition to circumnavigate the globe, though he died before completing the journey?",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "Christopher Columbus",
            "John Cabot",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Roman general and statesman who defeated Mark Antony and Cleopatra in the Battle of Actium, leading to the end of the Roman Republic?",
            "Julius Caesar",
            "Augustus",
            "Cicero",
            "Pompey",
            "Augustus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Black Death, one of the deadliest pandemics in human history, reach Europe and cause widespread devastation?",
            "1325",
            "1347",
            "1371",
            "1398",
            "1347"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Japanese shogun and military dictator who successfully unified Japan in the late 16th century?",
            "Oda Nobunaga",
            "Toyotomi Hideyoshi",
            "Tokugawa Ieyasu",
            "Date Masamune",
            "Tokugawa Ieyasu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Enlightenment, which French philosopher and writer advocated for the separation of powers and influenced the development of modern political thought?",
            "Voltaire",
            "Montesquieu",
            "Rousseau",
            "Diderot",
            "Montesquieu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen and pharaoh known for her ambitious building projects, including the construction of the Temple of Dendera?",
            "Hatshepsut",
            "Nefertiti",
            "Cleopatra",
            "Hathor",
            "Hatshepsut"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did the Treaty of Nanjing end the First Opium War between China and the United Kingdom?",
            "1839",
            "1842",
            "1856",
            "1860",
            "1842"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and mathematician known for his contributions to geometry and the discovery of the Pythagorean theorem?",
            "Euclid",
            "Archimedes",
            "Thales",
            "Pythagoras",
            "Pythagoras"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, who was the Italian artist and polymath known for paintings such as the Mona Lisa and The Last Supper?",
            "Raphael",
            "Leonardo da Vinci",
            "Michelangelo",
            "Titian",
            "Leonardo da Vinci"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Mesopotamian king is best known for the Code of Hammurabi, one of the earliest and most complete written legal codes?",
            "Sargon of Akkad",
            "Hammurabi",
            "Nebuchadnezzar II",
            "Gilgamesh",
            "Hammurabi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Roman Empire, who was the military general and statesman who crossed the Rubicon, leading to the downfall of the Roman Republic?",
            "Julius Caesar",
            "Augustus",
            "Cicero",
            "Mark Antony",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English monarch who presided over the defeat of the Spanish Armada in 1588 and is often referred to as the 'Virgin Queen'?",
            "Elizabeth I",
            "Mary I",
            "Anne Boleyn",
            "Victoria",
            "Elizabeth I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Middle Ages, which medieval scholar and theologian wrote 'Summa Theologica' and influenced Christian theology?",
            "Thomas Aquinas",
            "John Wycliffe",
            "Anselm of Canterbury",
            "Augustine of Hippo",
            "Thomas Aquinas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Japanese emperor during World War II and the post-war period, considered a symbol of unity for the Japanese people?",
            "Emperor Taisho",
            "Emperor Showa",
            "Emperor Meiji",
            "Emperor Heisei",
            "Emperor Showa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Rome, what was the name of the conflict between Rome and Carthage that lasted from 264 BC to 146 BC?",
            "Punic Wars",
            "Persian Wars",
            "Peloponnesian War",
            "Samnite Wars",
            "Punic Wars"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Exploration, which Portuguese explorer sailed around the Cape of Good Hope to reach India, opening a sea route to the East?",
            "Vasco da Gama",
            "Ferdinand Magellan",
            "Christopher Columbus",
            "John Cabot",
            "Vasco da Gama"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English scientist and mathematician known for his laws of motion and universal gravitation during the Scientific Revolution?",
            "Isaac Newton",
            "Galileo Galilei",
            "Johannes Kepler",
            "Blaise Pascal",
            "Isaac Newton"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Enlightenment, which philosopher and writer argued for freedom of speech and religious tolerance, influencing the U.S. Bill of Rights?",
            "John Locke",
            "Jean-Jacques Rousseau",
            "Voltaire",
            "Denis Diderot",
            "Voltaire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian czar responsible for modernizing Russia and implementing a series of social and economic reforms in the 18th century?",
            "Ivan the Terrible",
            "Peter the Great",
            "Catherine the Great",
            "Nicholas II",
            "Peter the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient China, who was the military strategist and philosopher known for 'The Art of War,' a classic work on strategy and warfare?",
            "Confucius",
            "Laozi",
            "Sun Tzu",
            "Mencius",
            "Sun Tzu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the French military and political leader who rose to prominence during the French Revolution and became Emperor of the French?",
            "Napoleon Bonaparte",
            "Louis XIV",
            "Robespierre",
            "Louis Philippe",
            "Napoleon Bonaparte"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, which city in Italy was a major center for art, culture, and intellectual pursuits, known as the birthplace of the Renaissance?",
            "Venice",
            "Florence",
            "Rome",
            "Milan",
            "Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Persian king who led the Achaemenid Empire during its height and is remembered for his support of the arts and construction projects?",
            "Darius I",
            "Cyrus the Great",
            "Xerxes I",
            "Artaxerxes II",
            "Darius I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the American Civil War, which battle fought in 1863 was a turning point favoring the Union forces and is often considered the bloodiest battle of the war?",
            "Antietam",
            "Gettysburg",
            "Chancellorsville",
            "Vicksburg",
            "Gettysburg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the military and political leader of the Haitian Revolution, leading the enslaved population to independence from French colonial rule?",
            "Toussaint Louverture",
            "Jean-Jacques Dessalines",
            "Henri Christophe",
            "Alexandre Pétion",
            "Toussaint Louverture"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the early 20th century, who was the Mexican revolutionary leader and president known for land reforms and social justice policies?",
            "Emiliano Zapata",
            "Pancho Villa",
            "Porfirio Díaz",
            "Venustiano Carranza",
            "Emiliano Zapata"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, which German inventor, printer, and publisher is credited with introducing the printing press to Europe?",
            "Johannes Gutenberg",
            "Leon Battista Alberti",
            "Desiderius Erasmus",
            "Niccolò Machiavelli",
            "Johannes Gutenberg"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Bolshevik Party and the first head of the Soviet Union, playing a key role in the Russian Revolution of 1917?",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Leon Trotsky",
            "Nikita Khrushchev",
            "Vladimir Lenin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Rome, who was the military general and statesman who famously crossed the Alps with his army during the Second Punic War?",
            "Scipio Africanus",
            "Gaius Marius",
            "Hannibal Barca",
            "Julius Caesar",
            "Hannibal Barca"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Discovery, which Portuguese explorer was the first to sail around the southern tip of Africa, opening a sea route to Asia?",
            "Vasco da Gama",
            "Ferdinand Magellan",
            "Christopher Columbus",
            "John Cabot",
            "Vasco da Gama"
        )
    )

        questionsList.shuffle()

    }
    fun historyStageSeven(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher whose teachings form the basis of Confucianism, emphasizing moral and ethical values?",
            "Laozi",
            "Confucius",
            "Mencius",
            "Xunzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, who was the Italian artist known for his sculptures such as 'David' and 'Pieta' and his paintings on the ceiling of the Sistine Chapel?",
            "Raphael",
            "Leonardo da Vinci",
            "Michelangelo",
            "Titian",
            "Michelangelo"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient empire, centered in the Andes of South America, was known for its advanced agricultural practices, road systems, and monumental architecture like Machu Picchu?",
            "Inca Empire",
            "Aztec Empire",
            "Maya Empire",
            "Olmec Civilization",
            "Inca Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In medieval Japan, what was the code of conduct for the samurai class, emphasizing loyalty, self-discipline, and honor?",
            "Bushido",
            "Zen",
            "Kabuki",
            "Haiku",
            "Bushido"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the French Revolution, who was the radical political leader and Jacobin responsible for the Reign of Terror?",
            "Marat",
            "Robespierre",
            "Danton",
            "Saint-Just",
            "Robespierre"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen and pharaoh, known for her alliance with Julius Caesar and Mark Antony?",
            "Nefertiti",
            "Cleopatra VII",
            "Hatshepsut",
            "Tiye",
            "Cleopatra VII"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Middle Ages, what was the system of economic and social relations where lords granted land to vassals in exchange for military service?",
            "Manorialism",
            "Feudalism",
            "Guild system",
            "Serfdom",
            "Feudalism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Roman statesman and general who played a key role in the transformation of the Roman Republic into the Roman Empire?",
            "Julius Caesar",
            "Cicero",
            "Sulla",
            "Pompey",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Cold War, which event in 1962 brought the United States and the Soviet Union to the brink of nuclear war over the placement of missiles in Cuba?",
            "Bay of Pigs Invasion",
            "Suez Crisis",
            "Cuban Missile Crisis",
            "Berlin Airlift",
            "Cuban Missile Crisis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Persian king who led the Achaemenid Empire during its height and is remembered for his support of the arts and construction projects?",
            "Darius I",
            "Cyrus the Great",
            "Xerxes I",
            "Artaxerxes II",
            "Darius I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient China, what was the period of political and social turmoil, often associated with the decline of the Han Dynasty and the emergence of the Three Kingdoms?",
            "Warring States Period",
            "Spring and Autumn Period",
            "Han Dynasty",
            "Three Kingdoms Period",
            "Three Kingdoms Period"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Mongol conqueror and founder of the Yuan Dynasty in China, known for his military campaigns and establishment of the Mongol Empire?",
            "Kublai Khan",
            "Genghis Khan",
            "Timur",
            "Hulagu Khan",
            "Kublai Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, which city in Italy was a major center for banking, trade, and the arts, home to the powerful Medici family?",
            "Venice",
            "Florence",
            "Rome",
            "Milan",
            "Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Persian king who expanded the Achaemenid Empire and is best known for his invasion of Greece, leading to the Battle of Marathon?",
            "Darius I",
            "Cyrus the Great",
            "Xerxes I",
            "Artaxerxes II",
            "Darius I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Rome, who was the military general and statesman who played a key role in the defeat of Spartacus's slave revolt?",
            "Julius Caesar",
            "Pompey",
            "Crassus",
            "Scipio Africanus",
            "Crassus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Protestant Reformation, who was the German monk and theologian who initiated the Ninety-Five Theses, challenging the practices of the Catholic Church?",
            "John Calvin",
            "Martin Luther",
            "John Knox",
            "Ulrich Zwingli",
            "Martin Luther"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Indian leader and advocate for nonviolent civil disobedience in the struggle for India's independence from British rule?",
            "Jawaharlal Nehru",
            "Subhas Chandra Bose",
            "Mahatma Gandhi",
            "Sardar Patel",
            "Mahatma Gandhi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Greece, what was the conflict between the city-states of Athens and Sparta, lasting from 431 to 404 BCE?",
            "Greco-Persian Wars",
            "Peloponnesian War",
            "Punic Wars",
            "Macedonian Wars",
            "Peloponnesian War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Soviet Union during the Cuban Missile Crisis and the early years of the Cold War?",
            "Nikita Khrushchev",
            "Joseph Stalin",
            "Leon Trotsky",
            "Vladimir Lenin",
            "Nikita Khrushchev"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the ancient Greek period, who was the philosopher and student of Socrates known for his work 'The Republic' and his theory of forms?",
            "Socrates",
            "Aristotle",
            "Plato",
            "Epicurus",
            "Plato"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which European monarch, also known as Charles the Great, was the King of the Franks and later became the first Holy Roman Emperor?",
            "Louis XIV",
            "Philip II",
            "Charlemagne",
            "Otto the Great",
            "Charlemagne"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In medieval Japan, what was the warrior code followed by the samurai class, emphasizing loyalty, courage, and honor?",
            "Ninjutsu",
            "Bushido",
            "Kendo",
            "Kyudo",
            "Bushido"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English monarch who led England during the Elizabethan Era, marked by cultural achievements and the defeat of the Spanish Armada?",
            "Henry VIII",
            "Mary I",
            "Elizabeth I",
            "James I",
            "Elizabeth I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Scientific Revolution, who was the Polish mathematician and astronomer known for proposing a heliocentric model of the solar system?",
            "Johannes Kepler",
            "Galileo Galilei",
            "Nicolaus Copernicus",
            "Isaac Newton",
            "Nicolaus Copernicus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Mesopotamia, which code of laws, attributed to the Babylonian king Hammurabi, is one of the earliest and most complete written legal systems?",
            "Code of Ur-Nammu",
            "Hittite Laws",
            "Laws of Eshnunna",
            "Code of Hammurabi",
            "Code of Hammurabi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the military and political leader of the Soviet Union during World War II, leading the country to victory over Nazi Germany?",
            "Vladimir Putin",
            "Leon Trotsky",
            "Joseph Stalin",
            "Mikhail Gorbachev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, who was the Italian polymath known for his paintings such as the 'Mona Lisa' and 'The Last Supper'?",
            "Michelangelo",
            "Leonardo da Vinci",
            "Raphael",
            "Titian",
            "Leonardo da Vinci"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Greek city-state was known for its military prowess, including the Battle of Thermopylae, and its emphasis on discipline and military training?",
            "Sparta",
            "Athens",
            "Thebes",
            "Corinth",
            "Sparta"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Mongol leader and founder of the Mongol Empire, known for his conquests across Asia and Europe?",
            "Kublai Khan",
            "Genghis Khan",
            "Timur",
            "Hulagu Khan",
            "Genghis Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Industrial Revolution, which country was the first to experience industrialization, with significant advancements in textile and steam engine technologies?",
            "United States",
            "Germany",
            "France",
            "United Kingdom",
            "United Kingdom"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen and pharaoh, known for her alliance with Julius Caesar and Mark Antony?",
            "Nefertiti",
            "Hatshepsut",
            "Cleopatra VII",
            "Tiye",
            "Cleopatra VII"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Rome, who was the military general and statesman who played a key role in the defeat of Spartacus's slave revolt?",
            "Julius Caesar",
            "Pompey",
            "Crassus",
            "Scipio Africanus",
            "Crassus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian mystic and advisor to the Romanov family, known as Rasputin, during the late Russian Empire?",
            "Grigori Rasputin",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Nicholas II",
            "Grigori Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Exploration, which Portuguese explorer is credited with being the first to circumnavigate the globe?",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "Christopher Columbus",
            "John Cabot",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Chinese philosopher and teacher who founded Daoism, emphasizing harmony with the Dao and simplicity in life?",
            "Confucius",
            "Laozi",
            "Mencius",
            "Xunzi",
            "Laozi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Cold War, which event in 1962 brought the United States and the Soviet Union to the brink of nuclear war over the placement of missiles in Cuba?",
            "Bay of Pigs Invasion",
            "Suez Crisis",
            "Cuban Missile Crisis",
            "Berlin Airlift",
            "Cuban Missile Crisis"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Japanese military dictator during the feudal period, holding de facto power over the country, and often associated with samurai culture?",
            "Oda Nobunaga",
            "Tokugawa Ieyasu",
            "Toyotomi Hideyoshi",
            "Minamoto Yoritomo",
            "Tokugawa Ieyasu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Rome, who was the military general and statesman who played a key role in the transformation of the Roman Republic into the Roman Empire?",
            "Julius Caesar",
            "Cicero",
            "Sulla",
            "Pompey",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese military strategist and philosopher known for his book 'The Art of War,' which has been widely studied in military strategy?",
            "Sun Tzu",
            "Confucius",
            "Laozi",
            "Mencius",
            "Sun Tzu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Ottoman Empire, who was the conqueror of Constantinople in 1453 and the founder of the Ottoman Empire?",
            "Suleiman the Magnificent",
            "Mehmed II",
            "Selim I",
            "Osman I",
            "Mehmed II"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Roman general and statesman known for his role in the downfall of the Roman Republic and the establishment of the Roman Empire?",
            "Julius Caesar",
            "Cicero",
            "Sulla",
            "Pompey",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Scientific Revolution, who was the Italian astronomer and physicist known for his observations of the planets and the development of the telescope?",
            "Galileo Galilei",
            "Johannes Kepler",
            "Nicolaus Copernicus",
            "Isaac Newton",
            "Galileo Galilei"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential ancient Indian emperor, known for spreading Buddhism and his commitment to nonviolence?",
            "Ashoka the Great",
            "Chandragupta Maurya",
            "Harsha",
            "Kanishka",
            "Ashoka the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In medieval Europe, what was the system of economic and social relations where peasants worked the land in exchange for protection and a share of the produce?",
            "Feudalism",
            "Manorialism",
            "Guild system",
            "Serfdom",
            "Manorialism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and teacher of Aristotle, known for his contributions to ethics and his philosophical dialogues?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Epicurus",
            "Plato"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Enlightenment, who was the French philosopher and writer known for his advocacy of civil liberties and separation of powers?",
            "Jean-Jacques Rousseau",
            "Voltaire",
            "Montesquieu",
            "Denis Diderot",
            "Montesquieu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the medieval Muslim scholar and polymath who made significant contributions to mathematics, astronomy, and medicine?",
            "Ibn Sina (Avicenna)",
            "Ibn Khaldun",
            "Al-Razi (Rhazes)",
            "Al-Kindi",
            "Ibn Sina (Avicenna)"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, who was the Flemish painter known for his detailed and realistic oil paintings, including 'The Arnolfini Portrait'?",
            "Hieronymus Bosch",
            "Jan van Eyck",
            "Pieter Bruegel the Elder",
            "Albrecht Dürer",
            "Jan van Eyck"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Byzantine empress and wife of Justinian I, known for her influential role in politics and her efforts to improve the status of women?",
            "Theodora",
            "Pulcheria",
            "Irene of Athens",
            "Eudokia Makrembolitissa",
            "Theodora"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient China, what was the system where the emperor granted land to nobles in exchange for loyalty, military service, and tribute?",
            "Feudalism",
            "Mandate of Heaven",
            "Dynastic Cycle",
            "Meritocracy",
            "Feudalism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek historian known as the 'Father of History,' credited with writing 'Histories' covering the Greco-Persian Wars?",
            "Herodotus",
            "Thucydides",
            "Xenophon",
            "Polybius",
            "Herodotus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the American Revolution, who was the French military officer and key ally of the American colonies, contributing to their victory over the British?",
            "Marquis de Lafayette",
            "Napoleon Bonaparte",
            "Charles de Gaulle",
            "Louis XVI",
            "Marquis de Lafayette"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian ruler and reformer who implemented modernization measures in the 18th century, including the Table of Ranks and territorial expansion?",
            "Ivan the Terrible",
            "Peter the Great",
            "Catherine the Great",
            "Nicholas II",
            "Peter the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the French Revolution, what radical political club played a key role in the events leading to the Reign of Terror and the rise of Maximilien Robespierre?",
            "Jacobins",
            "Girondins",
            "Sans-culottes",
            "Dantonists",
            "Jacobins"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Japanese shogun who implemented a policy of isolation, prohibiting foreign influences, during the Edo period?",
            "Oda Nobunaga",
            "Tokugawa Ieyasu",
            "Toyotomi Hideyoshi",
            "Minamoto Yoritomo",
            "Tokugawa Ieyasu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Rome, who was the military general and statesman who played a key role in the defeat of Hannibal during the Second Punic War?",
            "Scipio Africanus",
            "Julius Caesar",
            "Cicero",
            "Pompey",
            "Scipio Africanus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Industrial Revolution, who invented the spinning jenny, a key advancement in the textile industry?",
            "James Watt",
            "Richard Arkwright",
            "James Hargreaves",
            "Samuel Slater",
            "James Hargreaves"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the American Revolutionary War, who was the Prussian military officer and strategist who assisted the Continental Army, particularly at the Battle of Saratoga?",
            "Frederick the Great",
            "Helmuth von Moltke",
            "Erwin Rommel",
            "Friedrich Wilhelm von Steuben",
            "Friedrich Wilhelm von Steuben"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Indian emperor and founder of the Maurya Empire, known for his role in spreading Buddhism across Asia?",
            "Ashoka the Great",
            "Chandragupta Maurya",
            "Harsha",
            "Kanishka",
            "Ashoka the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Russian Revolution, who was the leader of the Red Army and a key figure in the Bolshevik government?",
            "Vladimir Lenin",
            "Leon Trotsky",
            "Joseph Stalin",
            "Nikolai Bukharin",
            "Leon Trotsky"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the medieval Japanese military dictator who unified Japan and implemented the 'sword hunt' to centralize power?",
            "Oda Nobunaga",
            "Tokugawa Ieyasu",
            "Toyotomi Hideyoshi",
            "Minamoto Yoritomo",
            "Toyotomi Hideyoshi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Greece, who was the philosopher and student of Socrates, known for his contributions to metaphysics and ethics?",
            "Socrates",
            "Plato",
            "Aristotle",
            "Epicurus",
            "Aristotle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the English king responsible for the establishment of the Church of England, leading to the English Reformation?",
            "Henry VII",
            "Edward VI",
            "Mary I",
            "Henry VIII",
            "Henry VIII"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Byzantine Empire, who was the empress known for her intelligence and political influence, especially during the reign of Justinian I?",
            "Pulcheria",
            "Theodora",
            "Irene of Athens",
            "Eudokia Makrembolitissa",
            "Theodora"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the medieval Persian poet, philosopher, and scholar, known for his work 'Rubaiyat' and contributions to Sufism?",
            "Rumi",
            "Ferdowsi",
            "Omar Khayyam",
            "Ibn Sina",
            "Omar Khayyam"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, who was the Italian explorer and cartographer who completed the first circumnavigation of the Earth?",
            "Christopher Columbus",
            "Amerigo Vespucci",
            "Ferdinand Magellan",
            "John Cabot",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Roman general and statesman who played a key role in the events leading to the end of the Roman Republic?",
            "Scipio Africanus",
            "Julius Caesar",
            "Cicero",
            "Pompey",
            "Julius Caesar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Ottoman Empire, who was the military and political leader known for his conquests and the expansion of the empire?",
            "Mehmed II",
            "Suleiman the Magnificent",
            "Osman I",
            "Selim I",
            "Suleiman the Magnificent"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Chinese philosopher and teacher, known for his teachings on ethics, family relationships, and good government?",
            "Confucius",
            "Laozi",
            "Mencius",
            "Xunzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Mesopotamia, what was the code of laws issued by King Hammurabi, one of the earliest and most complete written legal codes?",
            "Code of Ur-Nammu",
            "Code of Lipit-Ishtar",
            "Code of Hammurabi",
            "Hittite laws",
            "Code of Hammurabi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian mystic and advisor to the Romanov family, known for his influence over Alexandra, the last Russian Empress?",
            "Grigori Rasputin",
            "Vladimir Lenin",
            "Leon Trotsky",
            "Joseph Stalin",
            "Grigori Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the medieval Crusades, who was the Muslim military leader and founder of the Ayyubid dynasty, known for his recapture of Jerusalem?",
            "Saladin",
            "Alp Arslan",
            "Nur ad-Din",
            "Baibars",
            "Saladin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the French military and political leader who rose to prominence during the French Revolution and later became Emperor of the French?",
            "Robespierre",
            "Napoleon Bonaparte",
            "Louis XVI",
            "Marat",
            "Napoleon Bonaparte"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient China, what was the philosophical and ethical system based on the teachings of Laozi, emphasizing simplicity and harmony with nature?",
            "Confucianism",
            "Legalism",
            "Daoism",
            "Mohism",
            "Daoism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Exploration, who was the Portuguese explorer and the first European to reach India by sea?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "John Cabot",
            "Vasco da Gama"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and mathematician, known for his contributions to geometry and the discovery of the Pythagorean theorem?",
            "Euclid",
            "Pythagoras",
            "Archimedes",
            "Thales",
            "Pythagoras"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen and pharaoh, known for her alliances and military campaigns, including the Battle of Actium?",
            "Nefertiti",
            "Hatshepsut",
            "Tiye",
            "Cleopatra VII",
            "Cleopatra VII"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Byzantine Empire, who was the emperor known for his efforts to codify Roman law into the Corpus Juris Civilis?",
            "Constantine the Great",
            "Justinian I",
            "Theodosius I",
            "Heraclius",
            "Justinian I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Indian emperor who established the Maurya Empire and converted to Buddhism after the Battle of Kalinga?",
            "Ashoka the Great",
            "Chandragupta Maurya",
            "Harsha",
            "Kanishka",
            "Ashoka the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In medieval Japan, what was the code of conduct for samurai warriors, emphasizing honor, loyalty, and martial arts?",
            "Kabuki",
            "Haiku",
            "Bushido",
            "Zen",
            "Bushido"
        )
    )

        questionsList.shuffle()

    }
    fun historyStageEight(){
        questionsList.clear()

        questionsList.add(
              QuestionsModel(
                  "Who was the Mongol conqueror and founder of the Yuan Dynasty in China, known for his military campaigns and the Silk Road?",
                  "Genghis Khan",
                  "Kublai Khan",
                  "Timur",
                  "Hulagu Khan",
                  "Kublai Khan"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Renaissance, who was the Italian polymath known for his paintings, sculptures, and inventions, including the Mona Lisa?",
                  "Michelangelo",
                  "Raphael",
                  "Leonardo da Vinci",
                  "Donatello",
                  "Leonardo da Vinci"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the African queen and warrior of the Kingdom of Ndongo, known for resisting Portuguese colonization in the 17th century?",
                  "Nzinga Mbande",
                  "Cleopatra",
                  "Amina of Zazzau",
                  "Hatshepsut",
                  "Nzinga Mbande"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient Rome, who was the military general and statesman known for his role in the Third Punic War and the destruction of Carthage?",
                  "Julius Caesar",
                  "Scipio Africanus",
                  "Cincinnatus",
                  "Hannibal",
                  "Scipio Africanus"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Russian mystic and advisor to the Romanov family, known for his influence over Alexandra, the last Russian Empress?",
                  "Grigori Rasputin",
                  "Vladimir Lenin",
                  "Leon Trotsky",
                  "Joseph Stalin",
                  "Grigori Rasputin"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Middle Ages, who was the Persian physician and scholar, known for his medical encyclopedia 'Canon of Medicine'?",
                  "Avicenna",
                  "Al-Razi",
                  "Ibn Khaldun",
                  "Ibn Battuta",
                  "Avicenna"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the leader of the Haitian Revolution, the first successful slave revolt in the Americas, leading to the establishment of Haiti as an independent nation?",
                  "Toussaint Louverture",
                  "Jean-Jacques Dessalines",
                  "Henri Christophe",
                  "François-Dominique Toussaint",
                  "Toussaint Louverture"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Industrial Revolution, who was the English industrialist and founder of the cotton-spinning mill in Cromford, often considered the father of the factory system?",
                  "Richard Arkwright",
                  "James Watt",
                  "James Hargreaves",
                  "Samuel Slater",
                  "Richard Arkwright"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Greek philosopher and mathematician, known for his contributions to geometry and the discovery of the Pythagorean theorem?",
                  "Euclid",
                  "Pythagoras",
                  "Archimedes",
                  "Thales",
                  "Euclid"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In medieval Europe, what was the name of the system of economic and social relations where lords granted land to vassals in exchange for military service?",
                  "Feudalism",
                  "Manorialism",
                  "Guild system",
                  "Capitalism",
                  "Feudalism"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Chinese military strategist and philosopher, known for his work 'The Art of War'?",
                  "Sun Tzu",
                  "Confucius",
                  "Laozi",
                  "Mencius",
                  "Sun Tzu"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the European Renaissance, who was the German inventor, printer, and publisher known for introducing the printing press to Europe?",
                  "Gutenberg",
                  "Luther",
                  "Erasmus",
                  "Copernicus",
                  "Gutenberg"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Roman general and statesman who played a crucial role in the events leading to the downfall of the Roman Republic?",
                  "Julius Caesar",
                  "Augustus",
                  "Mark Antony",
                  "Cicero",
                  "Julius Caesar"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Byzantine Empire, who was the emperor known for his efforts to codify Roman law into the Corpus Juris Civilis?",
                  "Constantine the Great",
                  "Justinian I",
                  "Theodosius I",
                  "Heraclius",
                  "Justinian I"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval Persian poet, philosopher, and scholar, known for his work 'Rubaiyat' and contributions to Sufism?",
                  "Rumi",
                  "Ferdowsi",
                  "Omar Khayyam",
                  "Ibn Sina",
                  "Omar Khayyam"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Russian Revolution, who was the leader of the Red Army and a key figure in the Bolshevik government?",
                  "Vladimir Lenin",
                  "Leon Trotsky",
                  "Joseph Stalin",
                  "Nikolai Bukharin",
                  "Leon Trotsky"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Indian emperor and founder of the Maurya Empire, known for his role in spreading Buddhism across Asia?",
                  "Ashoka the Great",
                  "Chandragupta Maurya",
                  "Harsha",
                  "Kanishka",
                  "Ashoka the Great"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the American Revolutionary War, who was the Prussian military officer and strategist who assisted the Continental Army, particularly at the Battle of Saratoga?",
                  "Frederick the Great",
                  "Helmuth von Moltke",
                  "Erwin Rommel",
                  "Friedrich Wilhelm von Steuben",
                  "Friedrich Wilhelm von Steuben"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval English king known for signing the Magna Carta in 1215, limiting the power of the monarchy?",
                  "Henry II",
                  "Richard the Lionheart",
                  "John Lackland",
                  "Edward I",
                  "John Lackland"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Russian ruler and reformer, known for modernizing Russia and implementing the Table of Ranks?",
                  "Peter the Great",
                  "Catherine the Great",
                  "Ivan the Terrible",
                  "Nicholas II",
                  "Peter the Great"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the French Revolution, who was the radical leader of the Committee of Public Safety and a key figure in the Reign of Terror?",
                  "Marat",
                  "Robespierre",
                  "Danton",
                  "Napoleon Bonaparte",
                  "Robespierre"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Persian king known for his leadership during the Greco-Persian Wars, including the Battle of Thermopylae?",
                  "Xerxes I",
                  "Darius I",
                  "Cyrus the Great",
                  "Artaxerxes II",
                  "Xerxes I"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient Greece, who was the philosopher and student of Socrates, known for his contributions to ethics and his philosophical dialogues?",
                  "Plato",
                  "Aristotle",
                  "Diogenes",
                  "Thales",
                  "Aristotle"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the leader of the Ottoman Empire during its height, known for his military campaigns and the conquest of Constantinople?",
                  "Suleiman the Magnificent",
                  "Mehmed II",
                  "Selim I",
                  "Osman I",
                  "Mehmed II"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Renaissance, who was the English playwright and poet, often referred to as the Bard of Avon?",
                  "Christopher Marlowe",
                  "Ben Jonson",
                  "John Milton",
                  "William Shakespeare",
                  "William Shakespeare"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Indian emperor and founder of the Maurya Dynasty, known for his conversion to Buddhism and the spread of the Buddha's teachings?",
                  "Chandragupta Maurya",
                  "Bindusara",
                  "Ashoka the Great",
                  "Harsha",
                  "Ashoka the Great"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In medieval Europe, what was the movement that sought to reform the Catholic Church and led to the Protestant Reformation?",
                  "Counter-Reformation",
                  "Great Schism",
                  "Lollardy",
                  "Reformation",
                  "Reformation"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval Japanese military leader and founder of the Tokugawa shogunate, bringing an era of peace and stability to Japan?",
                  "Toyotomi Hideyoshi",
                  "Oda Nobunaga",
                  "Tokugawa Ieyasu",
                  "Takeda Shingen",
                  "Tokugawa Ieyasu"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Scientific Revolution, who was the Polish mathematician and astronomer, known for proposing a heliocentric model of the solar system?",
                  "Galileo Galilei",
                  "Johannes Kepler",
                  "Nicolaus Copernicus",
                  "Isaac Newton",
                  "Nicolaus Copernicus"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Byzantine empress and wife of Justinian I, known for her influence on imperial policy and her support of Christian monasticism?",
                  "Empress Pulcheria",
                  "Empress Theodora",
                  "Empress Irene",
                  "Empress Zoe",
                  "Empress Theodora"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient China, who was the philosopher and teacher, emphasizing the importance of relationships, filial piety, and moral integrity?",
                  "Confucius",
                  "Laozi",
                  "Mencius",
                  "Xunzi",
                  "Confucius"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Persian king known for his expansion of the Achaemenid Empire, including the conquest of Babylon?",
                  "Cyrus the Great",
                  "Darius I",
                  "Xerxes I",
                  "Artaxerxes II",
                  "Cyrus the Great"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Age of Exploration, who was the Portuguese explorer and the first European to reach the southern tip of Africa, paving the way for sea routes to Asia?",
                  "Ferdinand Magellan",
                  "Christopher Columbus",
                  "Vasco da Gama",
                  "John Cabot",
                  "Bartolomeu Dias"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval Arab scholar, known for his contributions to mathematics, astronomy, and medicine, and author of 'The Book of Healing'?",
                  "Ibn Battuta",
                  "Avicenna",
                  "Al-Razi",
                  "Ibn Khaldun",
                  "Avicenna"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the American Civil War, who was the Union general known for his 'March to the Sea' and his devastating military strategy against the Confederacy?",
                  "Ulysses S. Grant",
                  "Robert E. Lee",
                  "William Tecumseh Sherman",
                  "Stonewall Jackson",
                  "William Tecumseh Sherman"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Greek historian, often called the 'Father of History,' known for his account of the Greco-Persian Wars?",
                  "Herodotus",
                  "Thucydides",
                  "Xenophon",
                  "Plutarch",
                  "Herodotus"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In medieval England, what was the conflict between the supporters of the House of Lancaster and the House of York, fought for control of the English throne?",
                  "Wars of the Roses",
                  "Hundred Years' War",
                  "War of the Spanish Succession",
                  "The Anarchy",
                  "Wars of the Roses"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Italian explorer and navigator, sponsored by Spain, who completed four voyages across the Atlantic Ocean, opening the way for the widespread European exploration and the eventual conquest of the Americas?",
                  "Ferdinand Magellan",
                  "Christopher Columbus",
                  "John Cabot",
                  "Amerigo Vespucci",
                  "Christopher Columbus"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Roman Republic, who was the military commander and statesman known for his victories in the Second Punic War, including the Battle of Cannae?",
                  "Julius Caesar",
                  "Scipio Africanus",
                  "Hannibal",
                  "Cicero",
                  "Hannibal"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval Chinese explorer and diplomat, known for his seven voyages to the Indian Ocean and beyond during the Ming Dynasty?",
                  "Zheng He",
                  "Kublai Khan",
                  "Qin Shi Huang",
                  "Emperor Wu",
                  "Zheng He"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In medieval Japan, who were the military nobility and officer caste, known for their code of honor and loyalty, during the feudal period?",
                  "Samurai",
                  "Ninja",
                  "Ronin",
                  "Shogun",
                  "Samurai"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Egyptian queen, known for her political and romantic alliances, particularly with Julius Caesar and Mark Antony?",
                  "Cleopatra",
                  "Nefertiti",
                  "Hatshepsut",
                  "Isis",
                  "Cleopatra"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Middle Ages, who was the medieval scholar and theologian, known for his philosophical work 'Summa Theologica'?",
                  "St. Augustine",
                  "St. Anselm",
                  "St. Thomas Aquinas",
                  "St. Benedict",
                  "St. Thomas Aquinas"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Mughal emperor known for his architectural legacy, including the Taj Mahal, as a symbol of love for his wife Mumtaz Mahal?",
                  "Akbar the Great",
                  "Babur",
                  "Aurangzeb",
                  "Shah Jahan",
                  "Shah Jahan"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Cold War, who was the leader of the Soviet Union, known for his role in the Cuban Missile Crisis and the space race?",
                  "Leon Trotsky",
                  "Joseph Stalin",
                  "Nikita Khrushchev",
                  "Mikhail Gorbachev",
                  "Nikita Khrushchev"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Greek philosopher and student of Plato, known for his teachings on ethics and virtue, and his dialogue 'Nicomachean Ethics'?",
                  "Socrates",
                  "Plato",
                  "Aristotle",
                  "Diogenes",
                  "Aristotle"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In medieval Europe, what was the system of agricultural and economic relations where peasants worked the land in exchange for protection from the lord?",
                  "Feudalism",
                  "Manorialism",
                  "Guild system",
                  "Capitalism",
                  "Manorialism"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the French military and political leader, known for his role in the French Revolution and the Napoleonic Wars?",
                  "Louis XVI",
                  "Robespierre",
                  "Napoleon Bonaparte",
                  "Marat",
                  "Napoleon Bonaparte"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Protestant Reformation, who was the German monk and theologian, known for his Ninety-Five Theses and the beginning of the Reformation?",
                  "John Calvin",
                  "Martin Luther",
                  "John Wycliffe",
                  "Huldrych Zwingli",
                  "Martin Luther"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Roman statesman and general, known for his role in the transformation of the Roman Republic into the Roman Empire?",
                  "Julius Caesar",
                  "Cicero",
                  "Augustus",
                  "Mark Antony",
                  "Augustus"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient Mesopotamia, what was the system of writing that used wedge-shaped marks on clay tablets?",
                  "Cuneiform",
                  "Hieroglyphics",
                  "Alphabet",
                  "Kanji",
                  "Cuneiform"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the English scientist and mathematician, known for his laws of motion and universal gravitation, during the Scientific Revolution?",
                  "Galileo Galilei",
                  "Johannes Kepler",
                  "Nicolaus Copernicus",
                  "Isaac Newton",
                  "Isaac Newton"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Ottoman Empire, who was the military and political leader, known for his conquests and the expansion of the empire during the 16th century?",
                  "Suleiman the Magnificent",
                  "Mehmed II",
                  "Selim I",
                  "Osman I",
                  "Suleiman the Magnificent"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Chinese military strategist and philosopher, known for his book 'The Art of War' and his influence on military thought?",
                  "Confucius",
                  "Sun Tzu",
                  "Laozi",
                  "Mencius",
                  "Sun Tzu"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient Rome, who were the professional fighters who entertained the public in violent battles, often in amphitheaters like the Colosseum?",
                  "Gladiators",
                  "Legionaries",
                  "Centurions",
                  "Praetorians",
                  "Gladiators"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval English king, known for his role in the Crusades and the signing of the Magna Carta, limiting royal power?",
                  "Richard the Lionheart",
                  "Henry II",
                  "John I",
                  "Edward I",
                  "John I"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Age of Enlightenment, who was the French philosopher, known for his advocacy of individual freedoms and separation of powers?",
                  "Voltaire",
                  "Rousseau",
                  "Montesquieu",
                  "Diderot",
                  "Montesquieu"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Persian king, known for his defeat of the Spartans at the Battle of Thermopylae during the Greco-Persian Wars?",
                  "Darius I",
                  "Cyrus the Great",
                  "Xerxes I",
                  "Artaxerxes II",
                  "Xerxes I"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval English king, known for his role in the Hundred Years' War and his claims to the French throne?",
                  "Henry IV",
                  "Edward III",
                  "Richard II",
                  "Henry V",
                  "Edward III"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Renaissance, who was the Italian artist and polymath, known for paintings like the Mona Lisa and The Last Supper?",
                  "Michelangelo",
                  "Raphael",
                  "Leonardo da Vinci",
                  "Donatello",
                  "Leonardo da Vinci"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Incan emperor, known for his resistance against Spanish conquistadors during the Spanish conquest of the Inca Empire?",
                  "Huascar",
                  "Atahualpa",
                  "Pachacuti",
                  "Manco Inca",
                  "Atahualpa"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In medieval Europe, what was the economic and social system where peasants provided labor and military service to nobles in exchange for protection?",
                  "Manorialism",
                  "Feudalism",
                  "Guild system",
                  "Capitalism",
                  "Manorialism"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval Arab scholar, known for his work in astronomy, mathematics, and optics, often called the 'Prince of Mathematicians'?",
                  "Al-Razi",
                  "Ibn Khaldun",
                  "Al-Farabi",
                  "Al-Biruni",
                  "Al-Farabi"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Industrial Revolution, who was the Scottish engineer and inventor, known for improvements to the steam engine?",
                  "James Watt",
                  "George Stephenson",
                  "Eli Whitney",
                  "Robert Fulton",
                  "James Watt"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Russian mystic and advisor to the Romanov family, known for his influence on Tsarina Alexandra and his role in the downfall of the Romanovs?",
                  "Rasputin",
                  "Trotsky",
                  "Stolypin",
                  "Kerensky",
                  "Rasputin"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the American Revolution, who was the French military officer and key ally to the American colonies, known for his role at the Battle of Saratoga?",
                  "Marquis de Lafayette",
                  "Napoleon Bonaparte",
                  "Louis XVI",
                  "Robespierre",
                  "Marquis de Lafayette"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Greek philosopher, known for his teachings on skepticism and questioning, often associated with the Socratic method?",
                  "Plato",
                  "Aristotle",
                  "Socrates",
                  "Diogenes",
                  "Socrates"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient Rome, who were the Roman citizens elected to represent the interests of the plebeians, forming the Tribune of the Plebs?",
                  "Senators",
                  "Consuls",
                  "Tribunes",
                  "Praetors",
                  "Tribunes"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the medieval Arab scholar, known for his contributions to algebra and his book 'Al-Kitab al-Mukhtasar fi Hisab al-Jabr wal-Muqabala'?",
                  "Ibn Battuta",
                  "Al-Razi",
                  "Ibn Khaldun",
                  "Al-Khwarizmi",
                  "Al-Khwarizmi"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Age of Exploration, who was the Portuguese explorer, known for his first circumnavigation of the Earth and his expedition to the Philippines?",
                  "Ferdinand Magellan",
                  "Christopher Columbus",
                  "Vasco da Gama",
                  "John Cabot",
                  "Ferdinand Magellan"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Carthaginian general, known for his tactics in the Second Punic War, particularly the use of elephants in the Alps?",
                  "Hannibal",
                  "Scipio Africanus",
                  "Julius Caesar",
                  "Cicero",
                  "Hannibal"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient Mesopotamia, what was the system of writing that used wedge-shaped marks on clay tablets?",
                  "Cuneiform",
                  "Hieroglyphics",
                  "Alphabet",
                  "Kanji",
                  "Cuneiform"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Scottish king, known for his victory at the Battle of Bannockburn against the English during the First War of Scottish Independence?",
                  "Robert the Bruce",
                  "William Wallace",
                  "James IV",
                  "Macbeth",
                  "Robert the Bruce"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the French Revolution, who was the radical Jacobin leader, known for his role in the Reign of Terror and his execution by guillotine?",
                  "Marquis de Lafayette",
                  "Robespierre",
                  "Louis XVI",
                  "Napoleon Bonaparte",
                  "Robespierre"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the ancient Egyptian queen, known for her alliance with Julius Caesar and Mark Antony, leading to her suicide after their defeat?",
                  "Cleopatra",
                  "Nefertiti",
                  "Hatshepsut",
                  "Isis",
                  "Cleopatra"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Enlightenment, who was the Scottish philosopher and economist, known for his work 'The Wealth of Nations'?",
                  "Adam Smith",
                  "John Locke",
                  "Voltaire",
                  "Montesquieu",
                  "Adam Smith"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the leader of the Soviet Union during World War II, known for his role in the Battle of Stalingrad and the Allied victory on the Eastern Front?",
                  "Vladimir Lenin",
                  "Joseph Stalin",
                  "Leon Trotsky",
                  "Mikhail Gorbachev",
                  "Joseph Stalin"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "Who was the Mongol conqueror, known for creating one of the largest empires in history and his military campaigns across Asia and Europe?",
                  "Kublai Khan",
                  "Genghis Khan",
                  "Timur",
                  "Attila the Hun",
                  "Genghis Khan"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "During the Renaissance, who was the Italian author and statesman, known for his political treatise 'The Prince'?",
                  "Niccolò Machiavelli",
                  "Dante Alighieri",
                  "Petrarch",
                  "Leon Battista Alberti",
                  "Niccolò Machiavelli"
              )
          )

          questionsList.add(
              QuestionsModel(
                  "In ancient Greece, who was the military leader and statesman, known for his victory at the Battle of Marathon and his role in Athenian politics?",
                  "Pericles",
                  "Themistocles",
                  "Leonidas",
                  "Alcibiades",
                  "Themistocles"
              )
          )

        questionsList.shuffle()

    }
    fun historyStageNine(){
        questionsList.clear()

        questionsList.add(
      QuestionsModel(
          "During the Renaissance, who was the Dutch humanist and scholar, known for his critical edition of the New Testament and his advocacy for humanism?",
          "Desiderius Erasmus",
          "Thomas More",
          "Johannes Gutenberg",
          "John Calvin",
          "Desiderius Erasmus"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Chinese military strategist and philosopher, known for his book 'The Art of War' and his influence on military thought?",
          "Confucius",
          "Sun Tzu",
          "Laozi",
          "Mencius",
          "Sun Tzu"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient Rome, who were the professional fighters who entertained the public in violent battles, often in amphitheaters like the Colosseum?",
          "Gladiators",
          "Legionaries",
          "Centurions",
          "Praetorians",
          "Gladiators"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval English king, known for his role in the Crusades and the signing of the Magna Carta, limiting royal power?",
          "Richard the Lionheart",
          "Henry II",
          "John I",
          "Edward I",
          "John I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Age of Enlightenment, who was the French philosopher, known for his advocacy of individual freedoms and separation of powers?",
          "Voltaire",
          "Rousseau",
          "Montesquieu",
          "Diderot",
          "Montesquieu"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Persian king, known for his defeat of the Spartans at the Battle of Thermopylae during the Greco-Persian Wars?",
          "Darius I",
          "Cyrus the Great",
          "Xerxes I",
          "Artaxerxes II",
          "Xerxes I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Renaissance, who was the Italian artist and polymath, known for paintings like the Mona Lisa and The Last Supper?",
          "Michelangelo",
          "Raphael",
          "Leonardo da Vinci",
          "Donatello",
          "Leonardo da Vinci"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Incan emperor, known for his resistance against Spanish conquistadors during the Spanish conquest of the Inca Empire?",
          "Huascar",
          "Atahualpa",
          "Pachacuti",
          "Manco Inca",
          "Atahualpa"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In medieval Europe, what was the economic and social system where peasants provided labor and military service to nobles in exchange for protection?",
          "Manorialism",
          "Feudalism",
          "Guild system",
          "Capitalism",
          "Manorialism"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval Arab scholar, known for his work in astronomy, mathematics, and optics, often called the 'Prince of Mathematicians'?",
          "Al-Razi",
          "Ibn Khaldun",
          "Al-Farabi",
          "Al-Biruni",
          "Al-Farabi"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Industrial Revolution, who was the Scottish engineer and inventor, known for improvements to the steam engine?",
          "James Watt",
          "George Stephenson",
          "Eli Whitney",
          "Robert Fulton",
          "James Watt"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Russian mystic and advisor to the Romanov family, known for his influence on Tsarina Alexandra and his role in the downfall of the Romanovs?",
          "Rasputin",
          "Trotsky",
          "Stolypin",
          "Kerensky",
          "Rasputin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the American Revolution, who was the French military officer and key ally to the American colonies, known for his role at the Battle of Saratoga?",
          "Marquis de Lafayette",
          "Napoleon Bonaparte",
          "Louis XVI",
          "Robespierre",
          "Marquis de Lafayette"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Greek philosopher, known for his teachings on skepticism and questioning, often associated with the Socratic method?",
          "Plato",
          "Aristotle",
          "Socrates",
          "Diogenes",
          "Socrates"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient Rome, who were the Roman citizens elected to represent the interests of the plebeians, forming the Tribune of the Plebs?",
          "Senators",
          "Consuls",
          "Tribunes",
          "Praetors",
          "Tribunes"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval Arab scholar, known for his contributions to algebra and his book 'Al-Kitab al-Mukhtasar fi Hisab al-Jabr wal-Muqabala'?",
          "Ibn Battuta",
          "Al-Razi",
          "Ibn Khaldun",
          "Al-Khwarizmi",
          "Al-Khwarizmi"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Age of Exploration, who was the Portuguese explorer, known for his first circumnavigation of the Earth and his expedition to the Philippines?",
          "Ferdinand Magellan",
          "Christopher Columbus",
          "Vasco da Gama",
          "John Cabot",
          "Ferdinand Magellan"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Carthaginian general, known for his tactics in the Second Punic War, particularly the use of elephants in the Alps?",
          "Hannibal",
          "Scipio Africanus",
          "Julius Caesar",
          "Cicero",
          "Hannibal"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient Mesopotamia, what was the system of writing that used wedge-shaped marks on clay tablets?",
          "Cuneiform",
          "Hieroglyphics",
          "Alphabet",
          "Kanji",
          "Cuneiform"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Scottish king, known for his victory at the Battle of Bannockburn against the English during the First War of Scottish Independence?",
          "Robert the Bruce",
          "William Wallace",
          "James IV",
          "Macbeth",
          "Robert the Bruce"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the French Revolution, who was the radical Jacobin leader, known for his role in the Reign of Terror and his execution by guillotine?",
          "Marquis de Lafayette",
          "Robespierre",
          "Louis XVI",
          "Napoleon Bonaparte",
          "Robespierre"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Egyptian queen, known for her alliance with Julius Caesar and Mark Antony, leading to her suicide after their defeat?",
          "Cleopatra",
          "Nefertiti",
          "Hatshepsut",
          "Isis",
          "Cleopatra"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Enlightenment, who was the Scottish philosopher and economist, known for his work 'The Wealth of Nations'?",
          "Adam Smith",
          "John Locke",
          "Voltaire",
          "Montesquieu",
          "Adam Smith"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the leader of the Soviet Union during World War II, known for his role in the Battle of Stalingrad and the Allied victory on the Eastern Front?",
          "Vladimir Lenin",
          "Joseph Stalin",
          "Leon Trotsky",
          "Mikhail Gorbachev",
          "Joseph Stalin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval Chinese explorer, known for his extensive voyages and exploration of maritime routes to Africa, India, and the Middle East?",
          "Zhang He",
          "Marco Polo",
          "Ibn Battuta",
          "Zheng He",
          "Zheng He"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Roman Empire, who was the military general and statesman, known for his crossing of the Rubicon and eventual rise to dictator?",
          "Julius Caesar",
          "Augustus",
          "Cicero",
          "Mark Antony",
          "Julius Caesar"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In medieval Japan, who were the warrior nobility, known for their code of conduct and loyalty to their lords?",
          "Ronin",
          "Samurai",
          "Shogun",
          "Daimyo",
          "Samurai"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Indian leader, known for his role in the nonviolent resistance against British rule, leading to India's independence?",
          "Jawaharlal Nehru",
          "Subhas Chandra Bose",
          "Mohandas Gandhi",
          "Sardar Patel",
          "Mohandas Gandhi"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the American Civil War, who was the Union general, known for his 'March to the Sea' and his strategy of total war?",
          "Ulysses S. Grant",
          "Robert E. Lee",
          "William Tecumseh Sherman",
          "Stonewall Jackson",
          "William Tecumseh Sherman"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Persian king, known for his defeat of the Athenians at the Battle of Thermopylae and his role in the Greco-Persian Wars?",
          "Cyrus the Great",
          "Darius I",
          "Xerxes I",
          "Artaxerxes II",
          "Xerxes I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Ottoman Empire, who was the founder and first Sultan, known for his conquest of Constantinople in 1453?",
          "Suleiman the Magnificent",
          "Mehmed II",
          "Selim I",
          "Osman I",
          "Mehmed II"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the English monarch, known for his defeat of the Spanish Armada and his role in the Elizabethan era?",
          "Henry VIII",
          "Queen Mary I",
          "Elizabeth I",
          "James I",
          "Elizabeth I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient China, who was the philosopher and founder of Daoism, known for his teachings on living in harmony with the Dao?",
          "Confucius",
          "Laozi",
          "Mencius",
          "Xunzi",
          "Laozi"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the French military and political leader, known for his role in the French Revolution and his conquests in Europe?",
          "Napoleon Bonaparte",
          "Louis XVI",
          "Robespierre",
          "Marat",
          "Napoleon Bonaparte"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Industrial Revolution, who was the English textile industrialist and founder of the cotton-spinning mill?",
          "Richard Arkwright",
          "James Hargreaves",
          "Samuel Slater",
          "George Stephenson",
          "Richard Arkwright"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Greek mathematician, known for his contributions to geometry, especially the theorem named after him?",
          "Euclid",
          "Pythagoras",
          "Archimedes",
          "Thales",
          "Euclid"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient Rome, who was the military commander and statesman, known for his conquest of Gaul and crossing of the Rubicon?",
          "Julius Caesar",
          "Augustus",
          "Cicero",
          "Mark Antony",
          "Julius Caesar"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval Scottish queen, known for her involvement in the murder of her husband, Lord Darnley, and her subsequent imprisonment?",
          "Mary, Queen of Scots",
          "Elizabeth I",
          "Catherine de' Medici",
          "Isabella of Castile",
          "Mary, Queen of Scots"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Haitian Revolution, who was the leader of the slave rebellion and the first ruler of independent Haiti?",
          "Toussaint Louverture",
          "Jean-Jacques Dessalines",
          "Henri Christophe",
          "Pierre-Dominique Toussaint",
          "Jean-Jacques Dessalines"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Roman military commander, known for his conquest of Carthage during the Second Punic War?",
          "Scipio Africanus",
          "Julius Caesar",
          "Hannibal",
          "Cato the Elder",
          "Scipio Africanus"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient Mesopotamia, what was the code of laws, attributed to the Babylonian king Hammurabi?",
          "Code of Ur-Nammu",
          "Code of Hammurabi",
          "Hittite Laws",
          "Laws of Eshnunna",
          "Code of Hammurabi"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Japanese military dictator, known for his unification of Japan and his strict code of conduct for the samurai?",
          "Oda Nobunaga",
          "Toyotomi Hideyoshi",
          "Takeda Shingen",
          "Tokugawa Ieyasu",
          "Toyotomi Hideyoshi"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the French Revolution, who was the Haitian revolutionary leader, known for leading the slave rebellion and establishing the first independent black-led state?",
          "Toussaint Louverture",
          "Jean-Jacques Dessalines",
          "Henri Christophe",
          "Pierre-Dominique Toussaint",
          "Jean-Jacques Dessalines"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval Mongol conqueror, known for creating one of the largest empires in history?",
          "Genghis Khan",
          "Kublai Khan",
          "Timur",
          "Attila the Hun",
          "Genghis Khan"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient Greece, who was the philosopher and student of Socrates, known for his work on ethics and his philosophical dialogues?",
          "Plato",
          "Aristotle",
          "Diogenes",
          "Herodotus",
          "Plato"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the African queen, known for her military and political skills, who resisted European colonization in the late 19th century?",
          "Queen Nzinga",
          "Cleopatra",
          "Amina of Zazzau",
          "Empress Matilda",
          "Queen Nzinga"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the American Revolutionary War, who was the Prussian military officer who trained the Continental Army?",
          "Baron von Steuben",
          "Marquis de Lafayette",
          "Friedrich Wilhelm von Seydlitz",
          "Johann von Ewald",
          "Baron von Steuben"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval Norse explorer, known for his voyages to North America around the year 1000?",
          "Leif Erikson",
          "Erik the Red",
          "Bjarni Herjólfsson",
          "Thorfinn Karlsefni",
          "Leif Erikson"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient Rome, who was the military commander and statesman, known for his conquest of Gaul and his crossing of the Rubicon?",
          "Julius Caesar",
          "Augustus",
          "Cicero",
          "Mark Antony",
          "Julius Caesar"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Industrial Revolution, who was the British inventor and industrialist, known for his cotton gin and contributions to textile manufacturing?",
          "James Watt",
          "George Stephenson",
          "Eli Whitney",
          "Richard Arkwright",
          "Eli Whitney"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Persian emperor, known for his role in the Greco-Persian Wars and his defeat at the Battle of Marathon?",
          "Darius I",
          "Xerxes I",
          "Cyrus the Great",
          "Artaxerxes II",
          "Darius I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Middle Ages, who was the Islamic scholar, philosopher, and physician, known for his influential works in various fields?",
          "Ibn Sina (Avicenna)",
          "Ibn Rushd (Averroes)",
          "Al-Farabi",
          "Al-Razi (Rhazes)",
          "Ibn Sina (Avicenna)"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the leader of the Soviet Union during the Cuban Missile Crisis, known for his role in the de-Stalinization process?",
          "Nikita Khrushchev",
          "Joseph Stalin",
          "Leonid Brezhnev",
          "Mikhail Gorbachev",
          "Nikita Khrushchev"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In medieval Europe, who was the philosopher and theologian, known for his Summa Theologica and his influence on Christian theology?",
          "St. Augustine",
          "Thomas Aquinas",
          "Anselm of Canterbury",
          "John Wycliffe",
          "Thomas Aquinas"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Greek historian, known for his Histories covering the Greco-Persian Wars?",
          "Herodotus",
          "Thucydides",
          "Xenophon",
          "Polybius",
          "Herodotus"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Ottoman Empire, who was the longest-reigning Sultan, known for his military conquests and administrative reforms?",
          "Mehmed II",
          "Suleiman the Magnificent",
          "Selim I",
          "Osman I",
          "Suleiman the Magnificent"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval English queen, known for her victories in the Hundred Years' War and her nickname 'The Maid of Orleans'?",
          "Queen Elizabeth I",
          "Queen Mary I",
          "Queen Victoria",
          "Joan of Arc",
          "Joan of Arc"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Meiji Restoration, who was the Japanese emperor, known for his role in modernizing Japan and abolishing the samurai class?",
          "Emperor Meiji",
          "Emperor Taisho",
          "Emperor Hirohito",
          "Emperor Komei",
          "Emperor Meiji"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the African-American civil rights leader, known for his role in the Montgomery Bus Boycott and the March on Washington?",
          "Malcolm X",
          "Martin Luther King Jr.",
          "Rosa Parks",
          "Frederick Douglass",
          "Martin Luther King Jr."
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient China, who was the military strategist and author of 'The Art of War', known for his philosophy on warfare?",
          "Sun Tzu",
          "Confucius",
          "Laozi",
          "Mencius",
          "Sun Tzu"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Egyptian queen, known for her alliance with Julius Caesar and Mark Antony?",
          "Cleopatra",
          "Nefertiti",
          "Hatshepsut",
          "Isis",
          "Cleopatra"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Byzantine Empire, who was the emperor, known for codifying Roman law into the Corpus Juris Civilis?",
          "Constantine the Great",
          "Justinian I",
          "Heraclius",
          "Leo III",
          "Justinian I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In ancient India, who was the emperor, known for his patronage of Buddhism and the spread of the Mauryan Empire?",
          "Chandragupta Maurya",
          "Ashoka the Great",
          "Harsha",
          "Kanishka",
          "Ashoka the Great"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Russian mystic and advisor to the Romanov family, known for his influence over Tsarina Alexandra?",
          "Grigori Rasputin",
          "Vladimir Lenin",
          "Joseph Stalin",
          "Nicholas II",
          "Grigori Rasputin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Renaissance, who was the Italian artist, scientist, and polymath, known for his paintings and inventions?",
          "Leonardo da Vinci",
          "Michelangelo",
          "Raphael",
          "Donatello",
          "Leonardo da Vinci"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Persian king, known for his leadership during the Greco-Persian Wars, especially at the Battle of Thermopylae?",
          "Cyrus the Great",
          "Darius I",
          "Xerxes I",
          "Artaxerxes II",
          "Xerxes I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In medieval England, who was the king, known for signing the Magna Carta in 1215?",
          "King Richard the Lionheart",
          "King John",
          "King Edward I",
          "King Henry II",
          "King John"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the American Civil War, who was the Confederate general, known for his victories in the early stages of the war?",
          "Robert E. Lee",
          "Stonewall Jackson",
          "Ulysses S. Grant",
          "William T. Sherman",
          "Robert E. Lee"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Chinese philosopher, known for his teachings on ethics, morality, and the concept of 'rectification of names'?",
          "Confucius",
          "Laozi",
          "Mencius",
          "Xunzi",
          "Confucius"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the European colonization of Africa, who was the Belgian king, known for his brutal exploitation of the Congo Free State?",
          "King Leopold II",
          "Queen Victoria",
          "Kaiser Wilhelm II",
          "Napoleon III",
          "King Leopold II"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Roman general and statesman, known for his role in the transformation of the Roman Republic into the Roman Empire?",
          "Julius Caesar",
          "Augustus",
          "Cicero",
          "Mark Antony",
          "Augustus"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In medieval Japan, who were the military nobility, known for their code of conduct and loyalty to their lords?",
          "Samurai",
          "Ninja",
          "Ronin",
          "Daimyo",
          "Samurai"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval Scottish king, known for his victory over the English at the Battle of Bannockburn?",
          "William Wallace",
          "Robert the Bruce",
          "James I",
          "Macbeth",
          "Robert the Bruce"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Age of Exploration, who was the Portuguese explorer, known for his voyages around the southern tip of Africa?",
          "Christopher Columbus",
          "Ferdinand Magellan",
          "Vasco da Gama",
          "John Cabot",
          "Vasco da Gama"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Greek playwright, known for his tragedies such as 'Oedipus Rex' and 'Antigone'?",
          "Sophocles",
          "Euripides",
          "Aeschylus",
          "Aristophanes",
          "Sophocles"
      )
  )

  questionsList.add(
      QuestionsModel(
          "In medieval China, who was the explorer and diplomat, known for his travels along the Silk Road to the Middle East?",
          "Zheng He",
          "Marco Polo",
          "Ibn Battuta",
          "Xuanzang",
          "Marco Polo"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Russian revolutionary leader, known for his role in the October Revolution and the establishment of the Soviet state?",
          "Vladimir Lenin",
          "Joseph Stalin",
          "Leon Trotsky",
          "Mikhail Gorbachev",
          "Vladimir Lenin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the French Revolution, who was the radical political leader, known for his role in the Reign of Terror?",
          "Maximilien Robespierre",
          "Napoleon Bonaparte",
          "Jean-Paul Marat",
          "Georges Danton",
          "Maximilien Robespierre"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Roman poet, known for his epic poem 'The Aeneid'?",
          "Virgil",
          "Horace",
          "Ovid",
          "Cicero",
          "Virgil"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Russian Revolution, who was the last Tsar of Russia, abdicating in 1917?",
          "Nicholas II",
          "Alexander III",
          "Peter the Great",
          "Ivan the Terrible",
          "Nicholas II"
      )
  )

        questionsList.shuffle()

    }
    fun historyStageTen(){
        questionsList.clear()

        questionsList.add(
     QuestionsModel(
         "During the Peloponnesian War, who was the Athenian statesman and general, known for his leadership but eventually sentenced to death?",
         "Pericles",
         "Alcibiades",
         "Cleon",
         "Themistocles",
         "Alcibiades"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Rome, who was the military commander, consul, and dictator, known for his victories in the Roman Civil War?",
         "Pompey",
         "Crassus",
         "Cicero",
         "Sulla",
         "Julius Caesar"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Byzantine Empire, who was the emperor, known for his reconquests and the restoration of Constantinople?",
         "Justinian I",
         "Heraclius",
         "Basil II",
         "Leo III",
         "Basil II"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Persian king, known for his defeat of the Spartans at the Battle of Plataea during the Greco-Persian Wars?",
         "Darius I",
         "Xerxes I",
         "Cyrus the Great",
         "Artaxerxes II",
         "Mardonius"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Italian Renaissance, who was the Florentine political philosopher and author of 'The Prince'?",
         "Machiavelli",
         "Dante",
         "Petrarch",
         "Lorenzo de' Medici",
         "Machiavelli"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the ancient Chinese philosopher, known for his philosophy of Legalism and his influence on the Qin Dynasty?",
         "Confucius",
         "Laozi",
         "Xunzi",
         "Han Feizi",
         "Han Feizi"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient India, who was the Mauryan emperor, known for his conversion to Buddhism and promotion of the spread of Buddhism?",
         "Chandragupta Maurya",
         "Ashoka the Great",
         "Bindusara",
         "Kanishka",
         "Ashoka the Great"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the medieval Scottish king, known for his victory at the Battle of Stirling Bridge against the English?",
         "William Wallace",
         "Robert the Bruce",
         "James I",
         "Malcolm III",
         "William Wallace"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the French Revolution, who was the Haitian revolutionary leader, known for leading the successful slave revolt?",
         "Jean-Jacques Dessalines",
         "Toussaint Louverture",
         "Francois-Dominique Toussaint",
         "Haiti",
         "Toussaint Louverture"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the ancient Greek philosopher, known for his dialogues and the development of the Socratic method?",
         "Socrates",
         "Plato",
         "Aristotle",
         "Diogenes",
         "Socrates"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Industrial Revolution, who was the British industrialist and founder of the cooperative movement?",
         "Robert Owen",
         "James Watt",
         "Richard Arkwright",
         "George Stephenson",
         "Robert Owen"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the medieval Japanese military dictator, known for his unification of Japan and the establishment of the Tokugawa shogunate?",
         "Toyotomi Hideyoshi",
         "Oda Nobunaga",
         "Tokugawa Ieyasu",
         "Takeda Shingen",
         "Tokugawa Ieyasu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In medieval China, who was the military strategist and author of 'The Art of War', known for his philosophy on warfare?",
         "Sun Tzu",
         "Confucius",
         "Laozi",
         "Mencius",
         "Sun Tzu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Tang Dynasty in China, who was the female emperor, known for her effective governance and promotion of Buddhism?",
         "Empress Dowager Cixi",
         "Empress Wu Zetian",
         "Empress Jiang Qing",
         "Empress Liang Na",
         "Empress Wu Zetian"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Carthaginian military commander, known for his tactics during the Second Punic War, including the Battle of Cannae?",
         "Hannibal Barca",
         "Scipio Africanus",
         "Hasdrubal Barca",
         "Hamilcar Barca",
         "Hannibal Barca"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Russian Revolution, who was the Marxist revolutionary, known for his theory of imperialism and leadership in the Bolshevik Party?",
         "Vladimir Lenin",
         "Joseph Stalin",
         "Leon Trotsky",
         "Karl Marx",
         "Vladimir Lenin"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the ancient Mesopotamian king, known for his codification of laws, including the famous Code of Hammurabi?",
         "Sargon of Akkad",
         "Hammurabi",
         "Ashurbanipal",
         "Nebuchadnezzar II",
         "Hammurabi"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In medieval Europe, who was the Holy Roman Emperor, known for his conflicts with the papacy, including the Investiture Controversy?",
         "Charlemagne",
         "Frederick Barbarossa",
         "Otto the Great",
         "Charles V",
         "Frederick Barbarossa"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Chinese Cultural Revolution, who was the leader of the Red Guards and a close associate of Mao Zedong?",
         "Lin Biao",
         "Zhou Enlai",
         "Deng Xiaoping",
         "Liu Shaoqi",
         "Lin Biao"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Roman Empire, who was the philosopher and tutor to Nero, known for his works on ethics and Stoicism?",
         "Seneca the Younger",
         "Epictetus",
         "Marcus Aurelius",
         "Cicero",
         "Seneca the Younger"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Persia, who was the founder of the Achaemenid Empire, known for his tolerance of different cultures and religions?",
         "Cyrus the Great",
         "Darius I",
         "Xerxes I",
         "Artaxerxes II",
         "Cyrus the Great"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Egyptian queen, known for her naval battle against Octavian (later Emperor Augustus) at the Battle of Actium?",
         "Cleopatra",
         "Nefertiti",
         "Hatshepsut",
         "Isis",
         "Cleopatra"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Hundred Years' War, who was the French military leader and heroine, known for her role in the Siege of Orleans?",
         "Joan of Arc",
         "Eleanor of Aquitaine",
         "Isabella of France",
         "Catherine de' Medici",
         "Joan of Arc"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Greece, who was the philosopher and mathematician, known for his contributions to geometry and the discovery of pi?",
         "Euclid",
         "Pythagoras",
         "Archimedes",
         "Thales",
         "Archimedes"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Incan emperor, known for leading the defense against the Spanish conquistadors, particularly at the Battle of Cajamarca?",
         "Atahualpa",
         "Pachacuti",
         "Huayna Capac",
         "Manco Inca",
         "Atahualpa"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Middle Ages, who was the Arab scholar, known for his influential works in medicine, astronomy, and mathematics?",
         "Ibn Khaldun",
         "Ibn Sina (Avicenna)",
         "Al-Razi (Rhazes)",
         "Alhazen",
         "Ibn Sina (Avicenna)"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Roman general and statesman, known for his victories in the Second Punic War, particularly at the Battle of Cannae?",
         "Scipio Africanus",
         "Hannibal Barca",
         "Julius Caesar",
         "Publius Cornelius Scipio",
         "Hannibal Barca"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In medieval Japan, who was the samurai and military strategist, known for his book 'The Book of Five Rings'?",
         "Oda Nobunaga",
         "Tokugawa Ieyasu",
         "Takeda Shingen",
         "Miyamoto Musashi",
         "Miyamoto Musashi"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Renaissance, who was the Italian polymath, known for his inventions, drawings, and ideas ahead of his time?",
         "Leonardo da Vinci",
         "Galileo Galilei",
         "Niccolo Machiavelli",
         "Michelangelo",
         "Leonardo da Vinci"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Mongol conqueror, known for establishing the largest contiguous empire in history?",
         "Genghis Khan",
         "Kublai Khan",
         "Timur",
         "Ogedei Khan",
         "Genghis Khan"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Russian Revolution, who was the Bolshevik revolutionary and leader of the Red Army?",
         "Leon Trotsky",
         "Vladimir Lenin",
         "Joseph Stalin",
         "Grigory Zinoviev",
         "Leon Trotsky"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Carthaginian general, known for leading his forces, including war elephants, across the Alps during the Second Punic War?",
         "Hannibal Barca",
         "Scipio Africanus",
         "Hasdrubal Barca",
         "Hamilcar Barca",
         "Hannibal Barca"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Mesopotamia, who was the Sumerian king, known for the earliest known code of laws named after him?",
         "Gilgamesh",
         "Ur-Nammu",
         "Sargon of Akkad",
         "Nebuchadnezzar II",
         "Ur-Nammu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Byzantine empress, known for her intelligence and political acumen, particularly during the Nika Riots?",
         "Theodora",
         "Eudokia Makrembolitissa",
         "Irene of Athens",
         "Pulcheria",
         "Theodora"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Age of Exploration, who was the Portuguese explorer, known for his first circumnavigation of the Earth?",
         "Christopher Columbus",
         "Ferdinand Magellan",
         "John Cabot",
         "Vasco da Gama",
         "Ferdinand Magellan"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the ancient Egyptian pharaoh, known for his military campaigns and the construction of massive monuments, including Abu Simbel?",
         "Thutmose III",
         "Ramses II",
         "Hatshepsut",
         "Akhenaten",
         "Ramses II"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In medieval England, who was the archbishop, chancellor, and advisor to King Henry II, ultimately meeting a tragic end?",
         "Thomas Becket",
         "John Wycliffe",
         "William Tyndale",
         "Thomas More",
         "Thomas Becket"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the American Civil War, who was the Confederate general, known for his military tactics and leadership at the Battle of Chancellorsville?",
         "Robert E. Lee",
         "Stonewall Jackson",
         "Jefferson Davis",
         "Nathan Bedford Forrest",
         "Stonewall Jackson"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient China, who was the military strategist and philosopher, known for his work 'The Art of War'?",
         "Confucius",
         "Sun Tzu",
         "Laozi",
         "Mencius",
         "Sun Tzu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Byzantine Empire, who was the emperor, known for his efforts to codify Roman law into the Corpus Juris Civilis?",
         "Constantine the Great",
         "Justinian I",
         "Heraclius",
         "Basil II",
         "Justinian I"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Japanese military dictator, known for unifying Japan and establishing the Tokugawa shogunate?",
         "Toyotomi Hideyoshi",
         "Oda Nobunaga",
         "Tokugawa Ieyasu",
         "Takeda Shingen",
         "Tokugawa Ieyasu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Enlightenment, who was the French philosopher, known for his advocacy of separation of powers and his work 'The Spirit of the Laws'?",
         "Voltaire",
         "Montesquieu",
         "Rousseau",
         "Diderot",
         "Montesquieu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient India, who was the Mauryan emperor, known for his promotion of Buddhism and the spread of the Mauryan Empire?",
         "Ashoka the Great",
         "Chandragupta Maurya",
         "Bindusara",
         "Kanishka",
         "Ashoka the Great"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Italian explorer, known for his voyages to the Americas, opening the New World to exploration and colonization?",
         "Amerigo Vespucci",
         "Christopher Columbus",
         "John Cabot",
         "Ferdinand Magellan",
         "Christopher Columbus"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Crusades, who was the Muslim military leader, known for his opposition to Richard the Lionheart?",
         "Saladin",
         "Harun al-Rashid",
         "Suleiman the Magnificent",
         "Muhammad Ali",
         "Saladin"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Russian mystic and advisor to the Romanov family, influencing political decisions in the early 20th century?",
         "Grigori Rasputin",
         "Vladimir Lenin",
         "Nicholas II",
         "Leon Trotsky",
         "Grigori Rasputin"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the European Renaissance, who was the Dutch humanist and scholar, known for his 'In Praise of Folly'?",
         "Desiderius Erasmus",
         "Thomas More",
         "John Calvin",
         "Martin Luther",
         "Desiderius Erasmus"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Rome, who was the military general, known for his crossing of the Alps and victories in the Second Punic War?",
         "Julius Caesar",
         "Scipio Africanus",
         "Hannibal Barca",
         "Augustus",
         "Hannibal Barca"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Persian king, known for his defeat at the Battle of Marathon and the expansion of the Persian Empire?",
         "Darius I",
         "Cyrus the Great",
         "Xerxes I",
         "Artaxerxes II",
         "Darius I"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Protestant Reformation, who was the English queen, known for her support of the arts and defeat of the Spanish Armada?",
         "Elizabeth I",
         "Mary I",
         "Anne Boleyn",
         "Catherine of Aragon",
         "Elizabeth I"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the ancient Greek philosopher, known for his dialogues and teachings on ethics, executed for corrupting the youth of Athens?",
         "Socrates",
         "Plato",
         "Aristotle",
         "Heraclitus",
         "Socrates"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In medieval Scandinavia, who was the Viking explorer, known for his voyages to Greenland and North America?",
         "Leif Erikson",
         "Erik the Red",
         "Harald Hardrada",
         "Olaf Tryggvason",
         "Leif Erikson"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Indian emperor, known for his support of Buddhism and the spread of the Mauryan Empire?",
         "Chandragupta Maurya",
         "Ashoka the Great",
         "Bindusara",
         "Kanishka",
         "Ashoka the Great"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Meiji Restoration, who was the emperor of Japan, known for modernizing the country and ending feudalism?",
         "Emperor Meiji",
         "Emperor Taisho",
         "Emperor Showa",
         "Emperor Heisei",
         "Emperor Meiji"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Roman emperor, known for his military achievements, including the conquest of Gaul, and his crossing of the Rubicon?",
         "Julius Caesar",
         "Augustus",
         "Tiberius",
         "Caligula",
         "Julius Caesar"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Ottoman Empire, who was the sultan, known for his military campaigns, including the conquest of Constantinople?",
         "Suleiman the Magnificent",
         "Mehmed II",
         "Selim I",
         "Murad I",
         "Mehmed II"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Indian emperor, known for his support of Buddhism and the spread of the Mauryan Empire?",
         "Chandragupta Maurya",
         "Ashoka the Great",
         "Bindusara",
         "Kanishka",
         "Ashoka the Great"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Persia, who was the Achaemenid king, known for his construction projects, including Persepolis?",
         "Darius I",
         "Cyrus the Great",
         "Xerxes I",
         "Artaxerxes II",
         "Darius I"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the French Revolution, who was the radical political figure, associated with the Reign of Terror and the Committee of Public Safety?",
         "Maximilien Robespierre",
         "Louis XVI",
         "Napoleon Bonaparte",
         "Jean-Paul Marat",
         "Maximilien Robespierre"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Mongol emperor, known for his military conquests and establishment of the Yuan Dynasty in China?",
         "Genghis Khan",
         "Kublai Khan",
         "Ogedei Khan",
         "Möngke Khan",
         "Kublai Khan"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Hundred Years' War, who was the French military heroine, known for her role in the siege of Orleans?",
         "Joan of Arc",
         "Eleanor of Aquitaine",
         "Isabella of France",
         "Catherine de' Medici",
         "Joan of Arc"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Greece, who was the Athenian statesman, known for his leadership during the Golden Age and the Peloponnesian War?",
         "Pericles",
         "Solon",
         "Cleisthenes",
         "Themistocles",
         "Pericles"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Scottish queen, known for her tumultuous reign, marriages, and eventual imprisonment by Elizabeth I?",
         "Mary, Queen of Scots",
         "Elizabeth I",
         "Catherine de' Medici",
         "Anne Boleyn",
         "Mary, Queen of Scots"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Russian Revolution, who was the Bolshevik leader, instrumental in the October Revolution and the establishment of Soviet Russia?",
         "Joseph Stalin",
         "Leon Trotsky",
         "Vladimir Lenin",
         "Nikita Khrushchev",
         "Vladimir Lenin"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Carthaginian general, known for his military tactics and leading elephants across the Alps during the Second Punic War?",
         "Hannibal Barca",
         "Scipio Africanus",
         "Julius Caesar",
         "Cato the Elder",
         "Hannibal Barca"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Industrial Revolution, who was the English textile industrialist, known for inventing the spinning frame?",
         "James Watt",
         "Richard Arkwright",
         "George Stephenson",
         "Samuel Slater",
         "Richard Arkwright"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the ancient Egyptian queen, known for her relationships with Julius Caesar and Mark Antony?",
         "Cleopatra VII",
         "Nefertiti",
         "Hatshepsut",
         "Tiye",
         "Cleopatra VII"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Rome, who was the military commander, known for his conquest of Gaul and eventual crossing of the Rubicon?",
         "Julius Caesar",
         "Scipio Africanus",
         "Hannibal Barca",
         "Augustus",
         "Julius Caesar"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Tang Dynasty in China, who was the female emperor, known for her political and military accomplishments?",
         "Wu Zetian",
         "Cixi",
         "Yang Guifei",
         "Empress Dowager Hu",
         "Wu Zetian"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Ethiopian emperor, known for his victory over the Italians at the Battle of Adwa and his resistance to colonization?",
         "Haile Selassie",
         "Menelik II",
         "Tewodros II",
         "Yohannes IV",
         "Menelik II"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Reconquista, who was the Spanish queen, known for sponsoring Christopher Columbus's voyages to the Americas?",
         "Isabella I",
         "Ferdinand II",
         "Philip II",
         "Charles V",
         "Isabella I"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Chinese military strategist, known for his work 'The Art of War'?",
         "Confucius",
         "Sun Tzu",
         "Laozi",
         "Mencius",
         "Sun Tzu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In medieval Japan, who was the shogun, known for unifying the country and instituting the Ashikaga shogunate?",
         "Oda Nobunaga",
         "Toyotomi Hideyoshi",
         "Minamoto no Yoritomo",
         "Ashikaga Takauji",
         "Ashikaga Takauji"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Age of Enlightenment, who was the French philosopher, known for his work 'The Social Contract'?",
         "Voltaire",
         "Montesquieu",
         "Rousseau",
         "Diderot",
         "Rousseau"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Indian emperor, known for his support of Buddhism and the spread of the Mauryan Empire?",
         "Chandragupta Maurya",
         "Ashoka the Great",
         "Bindusara",
         "Kanishka",
         "Ashoka the Great"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Qing Dynasty in China, who was the empress dowager, known for her influence over the imperial court?",
         "Empress Dowager Cixi",
         "Empress Dowager Xiaozhuang",
         "Empress Dowager Ci'an",
         "Empress Dowager Dong",
         "Empress Dowager Cixi"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Byzantine Empire, who was the emperor, known for codifying Roman laws into the Corpus Juris Civilis?",
         "Justinian I",
         "Constantine the Great",
         "Theodosius I",
         "Heraclius",
         "Justinian I"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Mesopotamia, who was the Babylonian king, known for his code of laws?",
         "Hammurabi",
         "Ashurbanipal",
         "Nebuchadnezzar II",
         "Sargon of Akkad",
         "Hammurabi"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Roman general, known for his conquest of Gaul and later crossing the Rubicon, leading to the Roman Civil War?",
         "Julius Caesar",
         "Pompey",
         "Crassus",
         "Brutus",
         "Julius Caesar"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Ottoman Empire, who was the sultan, known for his expansionist policies and the Siege of Vienna in 1683?",
         "Suleiman the Magnificent",
         "Mehmed II",
         "Selim I",
         "Mahmud II",
         "Suleiman the Magnificent"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient India, who was the Mauryan emperor, known for his conversion to Buddhism and promotion of non-violence?",
         "Chandragupta Maurya",
         "Ashoka the Great",
         "Bindusara",
         "Kanishka",
         "Ashoka the Great"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Golden Age of Islam, who was the Persian polymath, known for his works in medicine, astronomy, and mathematics?",
         "Ibn Sina (Avicenna)",
         "Al-Razi (Rhazes)",
         "Al-Kindi",
         "Ibn Khaldun",
         "Ibn Sina (Avicenna)"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the French military leader, known for his role in the Hundred Years' War and the Battle of Castillon?",
         "Joan of Arc",
         "Louis XI",
         "Charles VII",
         "Philip the Good",
         "Joan of Arc"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient China, who was the military strategist and philosopher, known for his work 'The Art of War'?",
         "Confucius",
         "Laozi",
         "Zhuangzi",
         "Sun Tzu",
         "Sun Tzu"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Renaissance, who was the Italian artist, scientist, and polymath, known for his paintings such as the Mona Lisa?",
         "Leonardo da Vinci",
         "Michelangelo",
         "Raphael",
         "Donatello",
         "Leonardo da Vinci"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Mughal emperor, known for his architectural achievements, including the Taj Mahal?",
         "Akbar the Great",
         "Shah Jahan",
         "Aurangzeb",
         "Babur",
         "Shah Jahan"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the American Civil War, who was the Confederate general, known for his leadership at the Battle of Chancellorsville?",
         "Robert E. Lee",
         "Stonewall Jackson",
         "Ulysses S. Grant",
         "Jefferson Davis",
         "Stonewall Jackson"
     )
 )

 questionsList.add(
     QuestionsModel(
         "Who was the Japanese daimyo, known for his unification of Japan and the implementation of the Sword Hunt?",
         "Oda Nobunaga",
         "Toyotomi Hideyoshi",
         "Tokugawa Ieyasu",
         "Hojo Ujiyasu",
         "Toyotomi Hideyoshi"
     )
 )

 questionsList.add(
     QuestionsModel(
         "In ancient Rome, who was the military general, known for his conquests in Gaul and the crossing of the Rubicon?",
         "Julius Caesar",
         "Scipio Africanus",
         "Hannibal Barca",
         "Augustus",
         "Julius Caesar"
     )
 )

 questionsList.add(
     QuestionsModel(
         "During the Meiji Restoration in Japan, who was the emperor, known for his role in modernizing the country?",
         "Emperor Meiji",
         "Emperor Taisho",
         "Emperor Hirohito",
         "Emperor Showa",
         "Emperor Meiji"
     )
 )

        questionsList.shuffle()

    }
    fun historyStageEleven(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Who was the medieval English king, known for signing the Magna Carta in 1215?",
            "Henry II",
            "John Lackland",
            "Richard the Lionheart",
            "Edward I",
            "John Lackland"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Battle of Stalingrad, a turning point in World War II, was fought between Germany and which other country?",
            "France",
            "Soviet Union",
            "United Kingdom",
            "Italy",
            "Soviet Union"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Soviet Union during the Cuban Missile Crisis?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Nikita Khrushchev",
            "Mikhail Gorbachev",
            "Nikita Khrushchev"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Mayflower Compact' was signed by the Pilgrims aboard the Mayflower in 1620. In which present-day U.S. state did they land?",
            "Virginia",
            "Massachusetts",
            "New York",
            "Connecticut",
            "Massachusetts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Chinese philosopher and teacher whose ideas became the foundation for Confucianism?",
            "Laozi",
            "Confucius",
            "Mencius",
            "Xunzi",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Trianon, signed in 1920, led to the redrawing of borders and significant territorial losses for which country after World War I?",
            "Germany",
            "Austria",
            "Ottoman Empire",
            "Hungary",
            "Hungary"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Greek city-state was known for its military prowess and had a society governed by the 'Spartan Constitution'?",
            "Athens",
            "Corinth",
            "Thebes",
            "Sparta",
            "Sparta"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Great Schism of 1054 led to the split between the Western and Eastern Christian Churches. Which two branches emerged from this schism?",
            "Catholicism and Orthodoxy",
            "Catholicism and Protestantism",
            "Orthodoxy and Anglicanism",
            "Anglicanism and Protestantism",
            "Catholicism and Orthodoxy"
        )
    )



    questionsList.add(
        QuestionsModel(
            "During the Age of Exploration, who was the Portuguese explorer, known for his first circumnavigation of the Earth?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "John Cabot",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Persian king, known for his defeat of the Spartans at the Battle of Thermopylae?",
            "Xerxes I",
            "Cyrus the Great",
            "Darius I",
            "Artaxerxes II",
            "Xerxes I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Egypt, who was the pharaoh, known for constructing the Great Pyramid of Giza?",
            "Khufu",
            "Ramesses II",
            "Hatshepsut",
            "Akhenaten",
            "Khufu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Viking explorer, known for his expeditions to Greenland and North America?",
            "Leif Erikson",
            "Erik the Red",
            "Harald Hardrada",
            "Bjorn Ironside",
            "Leif Erikson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, located in present-day Mexico, is known for its large pyramids, complex calendar system, and hieroglyphic writing system?",
            "Olmec Civilization",
            "Aztec Civilization",
            "Maya Civilization",
            "Inca Civilization",
            "Maya Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, which Italian city-state was a major center of art, culture, and intellectual thought, home to figures like Leonardo da Vinci and Michelangelo?",
            "Venice",
            "Florence",
            "Rome",
            "Milan",
            "Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In the 14th century, the Black Death swept through Europe, causing widespread death and economic disruption. Which disease was responsible for the Black Death?",
            "Smallpox",
            "Bubonic Plague",
            "Cholera",
            "Influenza",
            "Bubonic Plague"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Soviet Union during the Cuban Missile Crisis in 1962, a tense Cold War standoff between the United States and the Soviet Union?",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Nikita Khrushchev",
            "Mikhail Gorbachev",
            "Nikita Khrushchev"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Opium Wars, fought in the mid-19th century, involved conflicts between China and which European colonial power over trade and the opium trade?",
            "Britain",
            "France",
            "Portugal",
            "Netherlands",
            "Britain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Age of Exploration, which Portuguese explorer was the first to circumnavigate the globe, completing the expedition after Magellan's death?",
            "Vasco da Gama",
            "Amerigo Vespucci",
            "Ferdinand Magellan",
            "Juan Sebastián Elcano",
            "Juan Sebastián Elcano"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Versailles, signed in 1919, officially ended which major conflict, imposing harsh conditions on Germany and contributing to the tensions that led to World War II?",
            "Crimean War",
            "Napoleonic Wars",
            "World War I",
            "Spanish-American War",
            "World War I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Chinese dynasty, known for its advances in art, philosophy, and technology, ruled from 1368 to 1644 and preceded the Qing Dynasty?",
            "Han Dynasty",
            "Tang Dynasty",
            "Song Dynasty",
            "Ming Dynasty",
            "Ming Dynasty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the 17th century, the Thirty Years' War involved many European powers and resulted in significant political and territorial changes. In which region did the war primarily take place?",
            "Scandinavia",
            "Balkans",
            "Central Europe",
            "Iberian Peninsula",
            "Central Europe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, located in present-day Iraq, is credited with the invention of writing (cuneiform) and the development of the first known legal code (the Code of Ur-Nammu)?",
            "Persian Empire",
            "Assyrian Empire",
            "Babylonian Empire",
            "Sumerian Civilization",
            "Sumerian Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Tordesillas, signed in 1494, divided newly discovered lands outside Europe between which two major maritime powers, setting the stage for their colonial empires?",
            "Spain and Portugal",
            "France and England",
            "Netherlands and Spain",
            "Portugal and England",
            "Spain and Portugal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, located in present-day Iran, played a crucial role in the development of the first human rights declaration, known as the Cyrus Cylinder?",
            "Assyrian Empire",
            "Persian Empire",
            "Babylonian Empire",
            "Parthian Empire",
            "Persian Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Boxer Rebellion, which took place in China in the late 19th century, was a violent uprising against foreign influence. What group led the rebellion?",
            "Boxers",
            "Red Guards",
            "Kuomintang",
            "Communists",
            "Boxers"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Brest-Litovsk, signed in 1918, marked the end of Russia's involvement in which major conflict, allowing the country to exit the war and leading to significant territorial losses?",
            "World War I",
            "Russian Civil War",
            "Crimean War",
            "Russo-Japanese War",
            "World War I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Roman Republic, the Gracchi brothers, Tiberius and Gaius, advocated for land reform and were eventually killed for their efforts. What political office did they both hold?",
            "Consul",
            "Tribune of the Plebs",
            "Censor",
            "Aedile",
            "Tribune of the Plebs"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Taiping Rebellion, which occurred in the mid-19th century, was a massive and devastating conflict in which country, involving a millenarian movement led by Hong Xiuquan?",
            "India",
            "China",
            "Japan",
            "Vietnam",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which military and political leader, known as the 'Maid of Orleans,' played a crucial role in the Hundred Years' War between England and France and was later canonized as a saint?",
            "Catherine de' Medici",
            "Joan of Arc",
            "Isabella I of Castile",
            "Eleanor of Aquitaine",
            "Joan of Arc"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the medieval period, the Hanseatic League was a commercial and defensive confederation of merchant guilds and market towns. In which region of Europe did the Hanseatic League primarily operate?",
            "Mediterranean",
            "Baltic Sea",
            "Black Sea",
            "North Sea",
            "Baltic Sea"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Nanking, signed in 1842, marked the end of which conflict between China and the British Empire, resulting in territorial concessions and the opening of Chinese ports to foreign trade?",
            "First Opium War",
            "Second Opium War",
            "Boxer Rebellion",
            "Taiping Rebellion",
            "First Opium War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, located in present-day Peru, is known for its impressive stone architecture, including the city of Machu Picchu?",
            "Inca Civilization",
            "Aztec Civilization",
            "Maya Civilization",
            "Olmec Civilization",
            "Inca Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Westphalia, signed in 1648, is often considered a key event in the development of modern international relations. What conflict did it help to end?",
            "Thirty Years' War",
            "Hundred Years' War",
            "Napoleonic Wars",
            "Crimean War",
            "Thirty Years' War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the founder and first leader of the Mongol Empire, which became the largest contiguous empire in history?",
            "Kublai Khan",
            "Genghis Khan",
            "Timur",
            "Attila the Hun",
            "Genghis Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Leap Forward' and the 'Cultural Revolution' were socio-political movements associated with the leadership of which Chinese communist leader?",
            "Deng Xiaoping",
            "Mao Zedong",
            "Chiang Kai-shek",
            "Zhou Enlai",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Battle of Saratoga, fought during the American Revolutionary War, is considered a turning point in the conflict. In which year did it take place?",
            "1775",
            "1776",
            "1777",
            "1781",
            "1777"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Berlin Conference, held in 1884-1885, led to the partitioning of Africa among European powers. Which principle guided the division of African territories?",
            "Balance of Power",
            "Doctrine of Discovery",
            "Sphere of Influence",
            "Scramble for Africa",
            "Scramble for Africa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Suez Crisis of 1956 involved military intervention by several nations over control of the Suez Canal. Which countries were the primary aggressors in this conflict?",
            "United States and Soviet Union",
            "United Kingdom and France",
            "Egypt and Israel",
            "India and Pakistan",
            "United Kingdom and France"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first woman to be elected as the head of government in a European country? She became the Prime Minister of the United Kingdom in 1979.",
            "Margaret Thatcher",
            "Angela Merkel",
            "Theresa May",
            "Golda Meir",
            "Margaret Thatcher"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Ghent, signed in 1814, ended a war between the United States and which other major power?",
            "France",
            "Spain",
            "Britain",
            "Russia",
            "Britain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The phrase 'Let them eat cake' is often attributed to a queen of France during the French Revolution. Who is believed to have uttered this phrase?",
            "Marie Antoinette",
            "Catherine de' Medici",
            "Eleanor of Aquitaine",
            "Anne Boleyn",
            "Marie Antoinette"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Cold War, the 'Bay of Pigs Invasion' was a failed attempt by the United States to overthrow the government of which country?",
            "Cuba",
            "Vietnam",
            "North Korea",
            "Iran",
            "Cuba"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first emperor of China, known for unifying the country and constructing the Great Wall of China?",
            "Emperor Qin Shi Huang",
            "Emperor Han Wudi",
            "Emperor Tang Taizong",
            "Emperor Yuan Shikai",
            "Emperor Qin Shi Huang"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Trianon, signed in 1920, resulted in significant territorial changes in Europe after which major conflict?",
            "World War I",
            "World War II",
            "Crimean War",
            "Napoleonic Wars",
            "World War I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Famine' of the mid-19th century, which caused widespread starvation in Ireland, was primarily a result of the failure of which crop?",
            "Potatoes",
            "Wheat",
            "Barley",
            "Rice",
            "Potatoes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The term 'Pax Romana' refers to a period of relative peace and stability in the Roman Empire. During which centuries did the Pax Romana occur?",
            "1st and 2nd centuries AD",
            "3rd and 4th centuries AD",
            "5th and 6th centuries AD",
            "7th and 8th centuries AD",
            "1st and 2nd centuries AD"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Brest-Litovsk, signed in 1918, marked the end of Russia's involvement in which major conflict, allowing the country to exit the war and leading to significant territorial losses?",
            "World War I",
            "Russian Civil War",
            "Crimean War",
            "Russo-Japanese War",
            "World War I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which famous explorer, sponsored by the Spanish Crown, completed the first circumnavigation of the Earth in 1522, though he died during the voyage?",
            "Ferdinand Magellan",
            "Christopher Columbus",
            "Amerigo Vespucci",
            "Hernán Cortés",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Cuban Missile Crisis' in 1962 was a tense standoff between the United States and which other major power, involving the presence of nuclear missiles in Cuba?",
            "Soviet Union",
            "China",
            "North Korea",
            "Cuba",
            "Soviet Union"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient city, often called the 'City of David,' is considered one of the oldest continuously inhabited cities in the world and a holy city in Judaism, Christianity, and Islam?",
            "Rome",
            "Jerusalem",
            "Athens",
            "Babylon",
            "Jerusalem"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In ancient Rome, what was the name given to the governing and military unit consisting of about 5,000 soldiers?",
            "Centurion",
            "Legion",
            "Praetorian Guard",
            "Tribune",
            "Legion"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, known for its city-states like Athens and Sparta, is considered the birthplace of democracy?",
            "Persian Empire",
            "Roman Empire",
            "Greek Civilization",
            "Egyptian Civilization",
            "Greek Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Code of Hammurabi is one of the earliest and most complete written legal codes, originating from which ancient civilization?",
            "Babylonian Civilization",
            "Sumerian Civilization",
            "Assyrian Civilization",
            "Akkadian Civilization",
            "Babylonian Civilization"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval queen, known for her role in the Hundred Years' War, was married to both Richard II of England and Henry V of England?",
            "Joan of Arc",
            "Isabella of Castile",
            "Eleanor of Aquitaine",
            "Margaret of Anjou",
            "Joan of Arc"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Renaissance, a period of cultural and intellectual flourishing, originated in which Italian city in the 14th century?",
            "Venice",
            "Rome",
            "Florence",
            "Milan",
            "Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous queen of ancient Egypt, known for her relationships with Julius Caesar and Mark Antony, and for her alliances with Rome?",
            "Hatshepsut",
            "Cleopatra",
            "Nefertiti",
            "Isis",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Magna Carta, signed in 1215, is considered a foundational document in the development of constitutional government. In which country was it signed?",
            "France",
            "England",
            "Spain",
            "Germany",
            "England"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first emperor of the Holy Roman Empire, crowned by the Pope in 800 AD, and known for his efforts to revive the Western Roman Empire?",
            "Charlemagne",
            "Otto the Great",
            "Frederick Barbarossa",
            "Constantine the Great",
            "Charlemagne"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Meiji Restoration in Japan, occurring in the late 19th century, led to the end of the samurai era and the modernization of the country. Who was the emperor during this period?",
            "Emperor Meiji",
            "Emperor Taisho",
            "Emperor Hirohito",
            "Emperor Showa",
            "Emperor Meiji"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Glorious Revolution' of 1688 in England resulted in the establishment of constitutional monarchy and the ascension of which Protestant monarchs to the throne?",
            "William and Mary",
            "James II",
            "Charles I",
            "Elizabeth I",
            "William and Mary"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Battle of Stalingrad, a turning point in World War II, took place between the Soviet Union and which Axis power?",
            "Germany",
            "Italy",
            "Japan",
            "Hungary",
            "Germany"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Opium Wars, fought in the mid-19th century, were a series of conflicts between China and which European country over trade imbalances and the opium trade?",
            "France",
            "United Kingdom",
            "Spain",
            "Portugal",
            "United Kingdom"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Versailles, signed in 1919, marked the end of World War I and imposed heavy penalties on which defeated Central Powers?",
            "Germany",
            "Austria-Hungary",
            "Ottoman Empire",
            "Bulgaria",
            "Germany"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Trail of Tears' refers to the forced relocation of Native American tribes, including the Cherokee, in the 1830s. Which country implemented this policy?",
            "Spain",
            "France",
            "United States",
            "Canada",
            "United States"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Soviet Union during the Cuban Missile Crisis in 1962?",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Nikita Khrushchev",
            "Leon Trotsky",
            "Nikita Khrushchev"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Lisbon, signed in 2007, aimed to reform and streamline the institutions of which political and economic union?",
            "European Union",
            "African Union",
            "United Nations",
            "ASEAN",
            "European Union"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The War of the Roses, a series of civil wars in England during the 15th century, was fought between two rival houses. Which houses were involved in this conflict?",
            "House of York and House of Tudor",
            "House of Lancaster and House of Plantagenet",
            "House of Stuart and House of Hanover",
            "House of Medici and House of Valois",
            "House of York and House of Tudor"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Panama Canal, completed in 1914, connects the Atlantic and Pacific Oceans. Which country initially began the construction of the canal?",
            "Colombia",
            "Costa Rica",
            "Panama",
            "Nicaragua",
            "Colombia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Guadalupe Hidalgo, signed in 1848, ended a war between the United States and which neighboring country, resulting in significant territorial changes?",
            "Canada",
            "Mexico",
            "Cuba",
            "Spain",
            "Mexico"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Khmer Rouge, a political group led by Pol Pot, was responsible for a genocide that occurred in which Southeast Asian country during the late 1970s?",
            "Vietnam",
            "Laos",
            "Cambodia",
            "Thailand",
            "Cambodia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "In what year did Christopher Columbus make his first voyage to the Americas?",
            "1492",
            "1510",
            "1456",
            "1525",
            "1492"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first emperor of China, known for unifying the country and constructing the Great Wall?",
            "Emperor Qin Shi Huang",
            "Emperor Han Wudi",
            "Emperor Tang Taizong",
            "Emperor Song Taizu",
            "Emperor Qin Shi Huang"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Era of Good Feelings' in the United States occurred during the presidency of which leader?",
            "James Madison",
            "Thomas Jefferson",
            "James Monroe",
            "John Adams",
            "James Monroe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous Egyptian queen and wife of Pharaoh Akhenaten, known for her beauty and the bust made in her likeness?",
            "Nefertiti",
            "Cleopatra",
            "Hatshepsut",
            "Tiye",
            "Nefertiti"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Marshall Plan, initiated after World War II, aimed to provide economic assistance to help rebuild the war-torn countries of which continent?",
            "Asia",
            "Africa",
            "North America",
            "Europe",
            "Europe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which European explorer is credited with circumnavigating the globe, completing the first known expedition to sail around the Earth?",
            "Ferdinand Magellan",
            "James Cook",
            "Christopher Columbus",
            "Vasco da Gama",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Cultural Revolution' in China, led by Mao Zedong, aimed to eliminate perceived bourgeois and traditional influences. In which decade did it take place?",
            "1950s",
            "1960s",
            "1970s",
            "1980s",
            "1960s"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, located in present-day Iraq, is credited with the development of the first known system of writing, known as cuneiform?",
            "Sumerians",
            "Akkadians",
            "Babylonians",
            "Assyrians",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Berlin Wall, a symbol of the Cold War division between East and West Germany, fell in which year, leading to the reunification of Germany?",
            "1985",
            "1989",
            "1991",
            "1995",
            "1989"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Mongol leader who founded the Yuan Dynasty in China and is known for his role in creating the largest contiguous empire in history?",
            "Kublai Khan",
            "Genghis Khan",
            "Timur",
            "Ogedei Khan",
            "Kublai Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Tordesillas, signed in 1494, divided newly discovered lands outside Europe between which two rival Catholic nations?",
            "Spain and Portugal",
            "France and England",
            "Netherlands and Spain",
            "Italy and Austria",
            "Spain and Portugal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first President of the United States and a key figure in the American Revolutionary War?",
            "John Adams",
            "Thomas Jefferson",
            "George Washington",
            "Benjamin Franklin",
            "George Washington"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Greek philosopher is known for his contributions to ethics, politics, and metaphysics, and was a student of Plato?",
            "Aristotle",
            "Socrates",
            "Pythagoras",
            "Thales",
            "Aristotle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Westphalia, signed in 1648, is often considered a turning point in international relations. Which conflict did it bring to an end?",
            "Napoleonic Wars",
            "Hundred Years' War",
            "Thirty Years' War",
            "Seven Years' War",
            "Thirty Years' War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Ming Dynasty, known for its cultural achievements and maritime explorations, was a ruling dynasty in which country?",
            "Japan",
            "India",
            "China",
            "Korea",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the famous military and political leader of Carthage during the Second Punic War, famously crossing the Alps with elephants?",
            "Hannibal",
            "Scipio Africanus",
            "Julius Caesar",
            "Alexander the Great",
            "Hannibal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Bolshevik Revolution in Russia, led by Vladimir Lenin, resulted in the establishment of which form of government?",
            "Constitutional Monarchy",
            "Communist State",
            "Fascist Regime",
            "Socialist Republic",
            "Communist State"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Battle of Hastings in 1066 resulted in the Norman conquest of England. Who was the Norman leader that emerged victorious in this battle?",
            "William the Conqueror",
            "Richard the Lionheart",
            "Harold Godwinson",
            "Edward the Confessor",
            "William the Conqueror"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian monk and mystic who played a significant role in the later days of the Romanov dynasty and was rumored to have influenced the Russian royal family?",
            "Rasputin",
            "Trotsky",
            "Lenin",
            "Stolypin",
            "Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Brest-Litovsk, signed in 1918, marked the end of hostilities between Soviet Russia and which Central Powers country during World War I?",
            "Germany",
            "Austria-Hungary",
            "Ottoman Empire",
            "Bulgaria",
            "Germany"
        )
    )

        questionsList.shuffle()

    }
    fun historyStageTwelve(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "Which medieval queen, known as 'Eleanor of Aquitaine,' was the mother of Richard the Lionheart and King John of England?",
            "Eleanor of Castile",
            "Eleanor of Aragon",
            "Eleanor of Navarre",
            "Eleanor of Aquitaine",
            "Eleanor of Aquitaine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Boxer Rebellion, which took place in the late 19th and early 20th centuries, targeted foreign influence in which country?",
            "India",
            "China",
            "Japan",
            "Korea",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the founder of the Mongol Empire, which became the largest contiguous empire in history?",
            "Genghis Khan",
            "Kublai Khan",
            "Ogedei Khan",
            "Mongke Khan",
            "Genghis Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization developed the first known system of writing known as cuneiform and is often associated with the Epic of Gilgamesh?",
            "Sumerians",
            "Akkadians",
            "Babylonians",
            "Assyrians",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, the Medici family played a significant role in the cultural and political life of which Italian city?",
            "Rome",
            "Venice",
            "Florence",
            "Milan",
            "Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Ghent, signed in 1814, marked the end of which conflict between the United States and Great Britain?",
            "American Revolutionary War",
            "War of 1812",
            "Mexican-American War",
            "Civil War",
            "War of 1812"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient city, located in present-day Iraq, is often considered one of the earliest urban centers in human history?",
            "Ur",
            "Babylon",
            "Nineveh",
            "Eridu",
            "Ur"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Meiji Restoration in Japan marked the end of the samurai era and the restoration of imperial rule. In which century did it take place?",
            "17th century",
            "18th century",
            "19th century",
            "20th century",
            "19th century"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian czar who implemented a series of modernization reforms known as the 'Great Reforms' during the 19th century?",
            "Peter the Great",
            "Ivan the Terrible",
            "Nicholas II",
            "Alexander II",
            "Alexander II"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Magna Carta, signed in 1215, is often regarded as an early step towards constitutional governance. In which country was it signed?",
            "France",
            "England",
            "Spain",
            "Germany",
            "England"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Battle of Cannae, fought in 216 BCE, was a major victory for which ancient military commander?",
            "Alexander the Great",
            "Hannibal",
            "Julius Caesar",
            "Scipio Africanus",
            "Hannibal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Dust Bowl' in the 1930s was a severe environmental disaster that primarily affected which region of the United States?",
            "Northeast",
            "Midwest",
            "Southwest",
            "Pacific Northwest",
            "Midwest"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The League of Nations, established after World War I, aimed to promote international cooperation and prevent future conflicts. In which city was its headquarters located?",
            "Geneva",
            "New York",
            "Paris",
            "Berlin",
            "Geneva"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Greek philosopher and mathematician credited with developing the principles of geometry?",
            "Socrates",
            "Aristotle",
            "Euclid",
            "Pythagoras",
            "Euclid"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Taiping Rebellion, one of the deadliest conflicts in history, occurred in which country during the mid-19th century?",
            "China",
            "India",
            "Japan",
            "Vietnam",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Battle of Gaugamela, fought in 331 BCE, was a decisive victory for which ancient conqueror against Persian King Darius III?",
            "Alexander the Great",
            "Hannibal",
            "Julius Caesar",
            "Cyrus the Great",
            "Alexander the Great"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which European explorer led the first expedition that successfully circumnavigated the globe?",
            "Ferdinand Magellan",
            "Christopher Columbus",
            "Marco Polo",
            "Vasco da Gama",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Opium Wars in the mid-19th century involved conflicts between China and which two Western powers?",
            "United Kingdom and France",
            "United States and Russia",
            "Germany and Italy",
            "Spain and Portugal",
            "United Kingdom and France"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Berlin Conference' of 1884-1885 led to the partitioning of Africa among European powers. Which river was established as a key point for determining territories?",
            "Nile River",
            "Congo River",
            "Zambezi River",
            "Niger River",
            "Congo River"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Byzantine Empire, which emperor is known for codifying Roman law into the 'Corpus Juris Civilis'?",
            "Justinian I",
            "Constantine the Great",
            "Heraclius",
            "Basil II",
            "Justinian I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Thirty Years' War,' which took place in the 17th century, primarily involved conflicts among which European powers?",
            "France, Spain, and England",
            "Austria, Prussia, and Russia",
            "Spain, Portugal, and Netherlands",
            "Holy Roman Empire, France, and Habsburgs",
            "Holy Roman Empire, France, and Habsburgs"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the military and political leader of the Soviet Union during World War II and the early Cold War era?",
            "Vladimir Putin",
            "Joseph Stalin",
            "Mikhail Gorbachev",
            "Nikita Khrushchev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Nanking, signed in 1842, marked the end of which conflict and resulted in territorial concessions to Western powers?",
            "Opium Wars",
            "Taiping Rebellion",
            "Boxer Rebellion",
            "Sino-Japanese War",
            "Opium Wars"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the ancient Egyptian queen who famously aligned herself with Julius Caesar and later Mark Antony?",
            "Hatshepsut",
            "Cleopatra",
            "Nefertiti",
            "Tiye",
            "Cleopatra"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, which Italian city-state was known for its maritime power, including the exploration led by Christopher Columbus?",
            "Venice",
            "Genoa",
            "Florence",
            "Milan",
            "Genoa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Cultural Revolution' in China, initiated by Mao Zedong, aimed to enforce communist ideology. In which decade did it take place?",
            "1950s",
            "1960s",
            "1970s",
            "1980s",
            "1960s"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Magna Carta' was signed in 1215, limiting the power of the English monarchy. What was the primary motivation behind its creation?",
            "Religious Reformation",
            "Peasants' Revolt",
            "Baronial opposition to King John",
            "War of the Roses",
            "Baronial opposition to King John"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, located in present-day Mexico, built the city of Teotihuacan and is known for its complex pyramids?",
            "Maya",
            "Aztec",
            "Olmec",
            "Zapotec",
            "Aztec"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Truman Doctrine,' announced in 1947, was a policy designed to contain the spread of which political ideology?",
            "Communism",
            "Fascism",
            "Capitalism",
            "Socialism",
            "Communism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Battle of Marathon in 490 BCE marked a significant victory for which ancient Greek city-state against the Persians?",
            "Sparta",
            "Athens",
            "Thebes",
            "Corinth",
            "Athens"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Congress of Vienna' in 1815 aimed to restore stability to Europe after the Napoleonic Wars. Which European power played a key role in the negotiations?",
            "France",
            "United Kingdom",
            "Austria",
            "Prussia",
            "Austria"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Cold War, the construction of the 'Berlin Wall' in 1961 was a physical manifestation of the division between which two ideological blocs?",
            "Western Bloc and Eastern Bloc",
            "NATO and Warsaw Pact",
            "Communism and Capitalism",
            "Axis Powers and Allies",
            "Communism and Capitalism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Black Death,' a devastating pandemic in the 14th century, is believed to have originated from which continent?",
            "Asia",
            "Africa",
            "Europe",
            "North America",
            "Asia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The construction of the 'Suez Canal' in the 19th century significantly impacted maritime trade by connecting which two bodies of water?",
            "Mediterranean Sea and Red Sea",
            "Black Sea and Caspian Sea",
            "North Sea and Baltic Sea",
            "Arctic Ocean and Atlantic Ocean",
            "Mediterranean Sea and Red Sea"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the leader of the Bolsheviks and the first head of the Soviet state after the Russian Revolution?",
            "Vladimir Lenin",
            "Leon Trotsky",
            "Joseph Stalin",
            "Nikita Khrushchev",
            "Vladimir Lenin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Scramble for Africa' in the late 19th century resulted in the colonization of the continent by European powers. Which river played a significant role in defining colonial borders?",
            "Nile River",
            "Congo River",
            "Zambezi River",
            "Niger River",
            "Nile River"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Purge' in the Soviet Union during the 1930s resulted in the mass persecution and execution of individuals accused of disloyalty. Who led this campaign?",
            "Vladimir Putin",
            "Mikhail Gorbachev",
            "Joseph Stalin",
            "Nikita Khrushchev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Spanish Inquisition,' established in the late 15th century, targeted individuals suspected of practicing which religion?",
            "Catholicism",
            "Protestantism",
            "Judaism",
            "Islam",
            "Judaism"
        )
    )


    questionsList.add(
        QuestionsModel(
            "Who was the legendary king of Uruk, considered one of the earliest known rulers in history, and the central character in the Epic of Gilgamesh?",
            "Hammurabi",
            "Nebuchadnezzar II",
            "Sargon of Akkad",
            "Gilgamesh",
            "Gilgamesh"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Thirty Years' War,' which lasted from 1618 to 1648, involved many European powers. What was the primary cause of this conflict?",
            "Religious disputes",
            "Colonial expansion",
            "Territorial disputes",
            "Economic rivalry",
            "Religious disputes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which Chinese philosopher and teacher emphasized ethics, morality, and proper conduct as key elements for a harmonious society?",
            "Confucius",
            "Laozi",
            "Mencius",
            "Sun Tzu",
            "Confucius"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Boxer Rebellion,' which took place in China from 1899 to 1901, was a movement against foreign influence. What was the primary motivation of the Boxers?",
            "Economic reforms",
            "Nationalism",
            "Religious freedom",
            "Colonial expansion",
            "Nationalism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, the Medici family played a crucial role in the cultural and artistic flourishing of which Italian city?",
            "Florence",
            "Venice",
            "Rome",
            "Milan",
            "Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Russian mystic and advisor to the Romanov family, known as the 'Mad Monk' and later executed during the Russian Revolution?",
            "Grigori Rasputin",
            "Nicholas II",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Grigori Rasputin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Meiji Restoration' in Japan during the 19th century aimed at modernizing the country. What were the key reforms introduced during this period?",
            "Industrialization and constitutional government",
            "Isolationism and feudalism",
            "Military expansion and dictatorship",
            "Religious revival and cultural preservation",
            "Industrialization and constitutional government"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Treaty of Versailles,' signed in 1919, officially ended which major conflict?",
            "World War I",
            "World War II",
            "Napoleonic Wars",
            "American Civil War",
            "World War I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval English king, known for his role in the Third Crusade, is often depicted in literature and folklore as a legendary hero?",
            "Richard the Lionheart",
            "Edward I",
            "Henry II",
            "John Lackland",
            "Richard the Lionheart"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Balfour Declaration' of 1917 expressed support for the establishment of a 'national home for the Jewish people' in which region?",
            "Palestine",
            "India",
            "South Africa",
            "Australia",
            "Palestine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the influential Italian philosopher and diplomat who wrote 'The Prince,' a treatise on political power and leadership?",
            "Machiavelli",
            "Dante Alighieri",
            "Petrarch",
            "Boccaccio",
            "Machiavelli"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Partition of India' in 1947 resulted in the creation of which two independent countries?",
            "India and Pakistan",
            "India and Bangladesh",
            "Pakistan and Afghanistan",
            "Bangladesh and Sri Lanka",
            "India and Pakistan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization, located in present-day Iraq, is credited with the development of the earliest known system of writing, known as cuneiform?",
            "Sumerians",
            "Akkadians",
            "Babylonians",
            "Assyrians",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Cuban Missile Crisis' in 1962 brought the United States and which other country to the brink of nuclear war?",
            "Soviet Union",
            "China",
            "Cuba",
            "North Korea",
            "Soviet Union"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Schism' of 1054 resulted in the split between the Eastern Orthodox Church and which other major branch of Christianity?",
            "Catholic Church",
            "Protestant Church",
            "Anglican Church",
            "Coptic Church",
            "Catholic Church"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Aztec emperor at the time of the Spanish conquest led by Hernán Cortés?",
            "Montezuma II",
            "Moctezuma I",
            "Ahuitzotl",
            "Cuauhtémoc",
            "Montezuma II"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Tiananmen Square protests' of 1989, primarily led by students, took place in which country?",
            "South Korea",
            "Japan",
            "China",
            "Vietnam",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient empire, located in the Andes Mountains of South America, is known for its advanced engineering, including Machu Picchu?",
            "Inca Empire",
            "Aztec Empire",
            "Maya Empire",
            "Olmec Empire",
            "Inca Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'War of the Roses,' a series of civil wars in 15th-century England, involved two rival houses. What were the names of these houses?",
            "House of York and House of Lancaster",
            "House of Tudor and House of Stuart",
            "House of Plantagenet and House of Hanover",
            "House of Bourbon and House of Habsburg",
            "House of York and House of Lancaster"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Mongol conqueror and founder of the Yuan Dynasty in China, known for his vast empire and military campaigns?",
            "Genghis Khan",
            "Kublai Khan",
            "Timur",
            "Attila the Hun",
            "Kublai Khan"
        )
    )
    questionsList.add(
        QuestionsModel(
            "Who was the influential medieval theologian and philosopher known for his 'Summa Theologica' and the concept of natural law?",
            "Thomas Aquinas",
            "Augustine of Hippo",
            "Anselm of Canterbury",
            "John Duns Scotus",
            "Thomas Aquinas"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Opium Wars' in the mid-19th century involved conflicts between China and which Western imperial power?",
            "Britain",
            "France",
            "Germany",
            "Russia",
            "Britain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Magna Carta,' signed in 1215, is considered a foundational document for constitutional governance. Which English king was forced to sign it?",
            "Richard the Lionheart",
            "John Lackland",
            "Edward I",
            "Henry II",
            "John Lackland"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Pharaoh of ancient Egypt known for constructing the Great Pyramid of Giza, one of the Seven Wonders of the Ancient World?",
            "Ramesses II",
            "Cleopatra",
            "Hatshepsut",
            "Khufu",
            "Khufu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Peace of Westphalia,' concluded in 1648, marked the end of the Thirty Years' War. What significant principle did it establish for international relations?",
            "Balance of power",
            "National sovereignty",
            "Collective security",
            "Imperialism",
            "National sovereignty"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Triangular Trade' between Europe, Africa, and the Americas in the 16th to 19th centuries involved the exchange of goods, including enslaved people. Which commodity was a major component of this trade?",
            "Spices",
            "Sugar",
            "Silk",
            "Salt",
            "Sugar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the first female pharaoh of ancient Egypt, known for her contributions to architecture and trade?",
            "Cleopatra",
            "Nefertiti",
            "Hatshepsut",
            "Meritaten",
            "Hatshepsut"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Taiping Rebellion' in 19th-century China was a massive uprising against the Qing Dynasty. What were the primary goals of the Taiping Heavenly Kingdom rebels?",
            "Land reform and social equality",
            "Religious freedom and tolerance",
            "Territorial expansion",
            "Monarchy restoration",
            "Land reform and social equality"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Persian king who led the Achaemenid Empire during the Greco-Persian Wars, including the Battle of Thermopylae?",
            "Darius I",
            "Cyrus the Great",
            "Xerxes I",
            "Artaxerxes I",
            "Xerxes I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Congress of Vienna' in 1815 aimed to restore stability in Europe after the Napoleonic Wars. Which European powers were the primary architects of the Congress?",
            "Britain, Austria, Prussia, and Russia",
            "France, Spain, Portugal, and Italy",
            "Germany, Denmark, Sweden, and Norway",
            "Turkey, Greece, Egypt, and Persia",
            "Britain, Austria, Prussia, and Russia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Khmer Rouge' regime, led by Pol Pot, ruled Cambodia from 1975 to 1979. What were the consequences of their radical policies?",
            "Economic prosperity and cultural revival",
            "Mass genocide and human rights abuses",
            "Political stability and global cooperation",
            "Technological advancement and innovation",
            "Mass genocide and human rights abuses"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Greek historian is often referred to as the 'Father of History' and wrote an account of the Persian Wars?",
            "Herodotus",
            "Thucydides",
            "Xenophon",
            "Plutarch",
            "Herodotus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Suez Crisis' of 1956 involved military actions by Israel, the United Kingdom, and France against which country's control of the Suez Canal?",
            "Egypt",
            "Saudi Arabia",
            "Iraq",
            "Syria",
            "Egypt"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the medieval Chinese explorer who embarked on seven voyages during the Ming Dynasty, reaching as far as Africa?",
            "Zheng He",
            "Kublai Khan",
            "Hongwu Emperor",
            "Wu Zetian",
            "Zheng He"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Irish Potato Famine' in the mid-19th century resulted in mass starvation and migration. What crop disease caused the failure of the potato crop, a staple food in Ireland?",
            "Late blight",
            "Rust",
            "Smuts",
            "Scab",
            "Late blight"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Zimmermann Telegram,' intercepted during World War I, revealed a secret alliance proposal between Germany and which country?",
            "Mexico",
            "Japan",
            "Italy",
            "Russia",
            "Mexico"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the military and political leader of the Soviet Union during World War II, leading the country to victory against Nazi Germany?",
            "Vladimir Lenin",
            "Joseph Stalin",
            "Nikita Khrushchev",
            "Mikhail Gorbachev",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Dust Bowl' in the 1930s affected agricultural regions in the United States. What environmental factors contributed to the severe soil erosion and dust storms?",
            "Overgrazing and deforestation",
            "Pesticide pollution",
            "Drought and poor land management",
            "Nuclear fallout",
            "Drought and poor land management"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient city, known for its Hanging Gardens, was the capital of the Neo-Babylonian Empire under King Nebuchadnezzar II?",
            "Nineveh",
            "Babylon",
            "Ur",
            "Ecbatana",
            "Babylon"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Mongol leader who founded the Yuan Dynasty in China after conquering the Song Dynasty?",
            "Genghis Khan",
            "Kublai Khan",
            "Timur",
            "Attila the Hun",
            "Kublai Khan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Balfour Declaration' in 1917 expressed support for the establishment of a 'national home for the Jewish people' in which region?",
            "Palestine",
            "India",
            "South Africa",
            "Australia",
            "Palestine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization developed the first known system of writing known as cuneiform on clay tablets?",
            "Egyptians",
            "Sumerians",
            "Mesoamericans",
            "Indus Valley Civilization",
            "Sumerians"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Renaissance, the Medici family played a significant role in the cultural and political life of which Italian city?",
            "Rome",
            "Venice",
            "Florence",
            "Milan",
            "Florence"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Boxer Rebellion' in China during the late 19th century targeted foreign influences and missionaries. What was the primary motivation behind the Boxer movement?",
            "Restoration of the imperial monarchy",
            "Opposition to opium trade",
            "Anti-foreign and anti-Christian sentiments",
            "Economic reforms",
            "Anti-foreign and anti-Christian sentiments"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the Carthaginian general who famously led elephants across the Alps during the Second Punic War against Rome?",
            "Hannibal",
            "Scipio Africanus",
            "Julius Caesar",
            "Xerxes",
            "Hannibal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Domesday Book,' commissioned by William the Conqueror in 1086, was a comprehensive survey of what?",
            "Population",
            "Taxation",
            "Landownership",
            "Religious practices",
            "Landownership"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'May Fourth Movement' in 1919 was a significant protest in China against the Treaty of Versailles. What were the main goals of the movement?",
            "Nationalism and anti-imperialism",
            "Communism and socialism",
            "Religious freedom",
            "Isolationism",
            "Nationalism and anti-imperialism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Roman Republic, who were the 'equites' in the social hierarchy?",
            "Slaves",
            "Senators",
            "Equestrians or knights",
            "Common citizens",
            "Equestrians or knights"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Truman Doctrine,' announced in 1947, was a U.S. policy aimed at containing the spread of which ideology during the Cold War?",
            "Fascism",
            "Communism",
            "Capitalism",
            "Nationalism",
            "Communism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval military order, founded during the Crusades, had its headquarters at the 'Krak des Chevaliers' and played a key role in the Holy Land?",
            "Teutonic Knights",
            "Knights Templar",
            "Hospitallers",
            "Order of the Dragon",
            "Knights Templar"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Thirty Years' War,' lasting from 1618 to 1648, primarily involved conflicts between Catholic and Protestant states in which region?",
            "Eastern Europe",
            "Western Europe",
            "Southern Europe",
            "Northern Europe",
            "Central Europe"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Mau Mau Uprising' in the 1950s was a rebellion against British colonial rule in which African country?",
            "Kenya",
            "Nigeria",
            "Ghana",
            "South Africa",
            "Kenya"
        )
    )

        questionsList.shuffle()

    }
    fun historyStageThirteen(){
        questionsList.clear()

        questionsList.add(
      QuestionsModel(
          "Who was the influential Chinese philosopher and teacher known for his philosophy emphasizing morality, filial piety, and social harmony?",
          "Laozi",
          "Confucius",
          "Sun Tzu",
          "Mencius",
          "Confucius"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Battle of Gaugamela' in 331 BCE was a decisive conflict between Alexander the Great and which Persian king?",
          "Darius III",
          "Cyrus the Great",
          "Xerxes I",
          "Artaxerxes II",
          "Darius III"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Treaty of Tordesillas' in 1494 aimed to divide newly discovered lands between Portugal and Spain. What was the key factor in determining the division?",
          "Longitude",
          "Latitude",
          "Military strength",
          "Natural resources",
          "Longitude"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the founder of the Mongol Empire, the largest contiguous empire in history, in the early 13th century?",
          "Kublai Khan",
          "Genghis Khan",
          "Timur",
          "Attila the Hun",
          "Genghis Khan"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Treaty of Brest-Litovsk' in 1918 marked the end of World War I for which country, allowing it to exit the conflict?",
          "Germany",
          "Austria-Hungary",
          "Ottoman Empire",
          "Soviet Russia",
          "Soviet Russia"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the 'Scramble for Africa' in the late 19th century, European powers competed for control of African territories. Which conference formalized the rules for this colonial division?",
          "Congress of Vienna",
          "Berlin Conference",
          "Treaty of Versailles",
          "Paris Peace Conference",
          "Berlin Conference"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Egyptian queen known for her relationships with Julius Caesar and Mark Antony?",
          "Cleopatra",
          "Nefertiti",
          "Hatshepsut",
          "Isis",
          "Cleopatra"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'War of the Roses' in the 15th century was a series of conflicts for control of the English throne between which two rival houses?",
          "House of Lancaster and House of York",
          "House of Tudor and House of Stuart",
          "House of Plantagenet and House of Habsburg",
          "House of Bourbon and House of Valois",
          "House of Lancaster and House of York"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Meiji Restoration' in Japan marked the end of the samurai era and the restoration of imperial rule. In which century did this event take place?",
          "17th century",
          "18th century",
          "19th century",
          "20th century",
          "19th century"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which ancient civilization is credited with developing the first known system of writing, known as cuneiform?",
          "Sumerians",
          "Egyptians",
          "Greeks",
          "Romans",
          "Sumerians"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Congress of Vienna' in 1814-1815 aimed to redraw the map of Europe after the defeat of which military leader?",
          "Napoleon Bonaparte",
          "Alexander the Great",
          "Genghis Khan",
          "Attila the Hun",
          "Napoleon Bonaparte"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the leader of the Soviet Union during the Cuban Missile Crisis?",
          "Vladimir Putin",
          "Joseph Stalin",
          "Nikita Khrushchev",
          "Mikhail Gorbachev",
          "Nikita Khrushchev"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which medieval queen is often associated with the phrase 'The She-Wolf of France' and was married to Edward II of England?",
          "Isabella of Aragon",
          "Eleanor of Aquitaine",
          "Margaret of Anjou",
          "Isabella of France",
          "Isabella of France"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Glorious Revolution' in 1688 resulted in the overthrow of James II and the ascension of which Protestant monarchs to the English throne?",
          "William III and Mary II",
          "Henry VIII and Elizabeth I",
          "Charles I and Charles II",
          "George I and George II",
          "William III and Mary II"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Boxer Rebellion' in China at the turn of the 20th century targeted foreigners and Chinese Christians. Which dynasty was ruling China at that time?",
          "Ming Dynasty",
          "Qing Dynasty",
          "Han Dynasty",
          "Tang Dynasty",
          "Qing Dynasty"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Treaty of Tordesillas' in 1494 divided newly discovered lands outside Europe between which two Catholic monarchies?",
          "Spain and Portugal",
          "France and England",
          "Austria and Hungary",
          "Italy and Greece",
          "Spain and Portugal"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the leader of the Bolsheviks during the October Revolution in Russia?",
          "Vladimir Lenin",
          "Leon Trotsky",
          "Joseph Stalin",
          "Nicholas II",
          "Vladimir Lenin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which European explorer is credited with the first circumnavigation of the Earth, completing the journey in 1522?",
          "Christopher Columbus",
          "Ferdinand Magellan",
          "John Cabot",
          "Vasco da Gama",
          "Ferdinand Magellan"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Great Purge' in the Soviet Union during the 1930s was a campaign of political repression led by which leader?",
          "Vladimir Putin",
          "Leon Trotsky",
          "Joseph Stalin",
          "Mikhail Gorbachev",
          "Joseph Stalin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Era of Good Feelings' in the United States, characterized by political unity, followed which major conflict?",
          "American Revolution",
          "War of 1812",
          "Civil War",
          "Mexican-American War",
          "War of 1812"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the military leader and founder of modern Turkey, leading the country through the transition from the Ottoman Empire to a republic?",
          "Suleiman the Magnificent",
          "Mustafa Kemal Atatürk",
          "Abdul Hamid II",
          "Mehmed II",
          "Mustafa Kemal Atatürk"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Battle of Cannae' in 216 BCE, known for its tactical brilliance, was a major confrontation in which ancient war?",
          "Peloponnesian War",
          "Punic Wars",
          "Persian Wars",
          "Hundred Years' War",
          "Punic Wars"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Partition of Africa' during the late 19th and early 20th centuries was a result of colonial competition among European powers. Which conference formalized this partition?",
          "Berlin Conference",
          "Vienna Congress",
          "Versailles Conference",
          "Yalta Conference",
          "Berlin Conference"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the medieval English king associated with the signing of the Magna Carta in 1215?",
          "Richard the Lionheart",
          "Henry II",
          "John Lackland",
          "Edward I",
          "John Lackland"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Era of Reconstruction' in the United States followed which major historical event?",
          "American Revolution",
          "Civil War",
          "Great Depression",
          "World War I",
          "Civil War"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the ancient Chinese philosopher and teacher whose ideas are the foundation of Confucianism?",
          "Laozi",
          "Sun Tzu",
          "Confucius",
          "Mencius",
          "Confucius"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Thirty Years' War' (1618-1648) was primarily fought in which region of Europe?",
          "Eastern Europe",
          "Southern Europe",
          "Western Europe",
          "Central Europe",
          "Central Europe"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which medieval queen played a significant role in the Hundred Years' War and was later canonized as a saint?",
          "Joan of Arc",
          "Isabella of Castile",
          "Eleanor of Aquitaine",
          "Matilda of Tuscany",
          "Joan of Arc"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Opium Wars' in the 19th century involved conflicts between China and which Western colonial power?",
          "Britain",
          "France",
          "Spain",
          "Portugal",
          "Britain"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the first Roman Emperor, transforming the Roman Republic into the Roman Empire?",
          "Julius Caesar",
          "Augustus",
          "Nero",
          "Caligula",
          "Augustus"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Suez Crisis' of 1956 involved military intervention by Western powers in response to the nationalization of the Suez Canal by which country?",
          "Egypt",
          "Iraq",
          "Iran",
          "Syria",
          "Egypt"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Schlieffen Plan' was a military strategy used by Germany during which major conflict?",
          "World War I",
          "World War II",
          "Napoleonic Wars",
          "Franco-Prussian War",
          "World War I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the famous African leader and anti-apartheid revolutionary who became South Africa's first black president?",
          "Nelson Mandela",
          "Desmond Tutu",
          "Thabo Mbeki",
          "Winnie Mandela",
          "Nelson Mandela"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Zimmermann Telegram' was a diplomatic incident during World War I involving a proposal from Germany to which country?",
          "United States",
          "United Kingdom",
          "France",
          "Russia",
          "United States"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Taiping Rebellion' in the mid-19th century was a massive upheaval against the ruling Qing Dynasty in which country?",
          "Japan",
          "China",
          "India",
          "Korea",
          "China"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Mongol conqueror who founded the Yuan Dynasty in China and later established one of the largest empires in history?",
          "Kublai Khan",
          "Genghis Khan",
          "Timur",
          "Hulagu Khan",
          "Kublai Khan"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Emancipation Proclamation' issued by President Abraham Lincoln during the American Civil War focused on the liberation of slaves in which region?",
          "Southern states",
          "Northern states",
          "Western states",
          "Eastern states",
          "Southern states"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Mau Mau Uprising' in the 1950s was a rebellion against colonial rule in which African country?",
          "Nigeria",
          "Kenya",
          "South Africa",
          "Ghana",
          "Kenya"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the Russian mystic and advisor to the Romanov family, believed by some to have influenced political decisions in early 20th-century Russia?",
          "Grigori Rasputin",
          "Ivan the Terrible",
          "Peter the Great",
          "Vladimir Lenin",
          "Grigori Rasputin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Cultural Revolution' in China, led by Mao Zedong, aimed to eliminate traditional and bourgeois elements from society. In which decade did it take place?",
          "1930s",
          "1940s",
          "1950s",
          "1960s",
          "1960s"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which European city was divided by the 'Iron Curtain' during the Cold War, becoming a symbol of the East-West ideological divide?",
          "Berlin",
          "Vienna",
          "Prague",
          "Budapest",
          "Berlin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Treaty of Versailles' in 1919 officially ended which major conflict?",
          "World War I",
          "World War II",
          "Napoleonic Wars",
          "Vietnam War",
          "World War I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the legendary queen of ancient Carthage, known for her role in the Punic Wars against Rome?",
          "Cleopatra",
          "Dido",
          "Hatshepsut",
          "Boudica",
          "Dido"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Cuban Revolution' led by Fidel Castro and Che Guevara resulted in the establishment of a socialist state in which country?",
          "Mexico",
          "Cuba",
          "Nicaragua",
          "Venezuela",
          "Cuba"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which Asian country was divided into North and South following World War II, leading to the Korean War in the 1950s?",
          "Vietnam",
          "Japan",
          "China",
          "Korea",
          "Korea"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Great Leap Forward' was a social and economic campaign initiated by which leader in mid-20th-century China?",
          "Deng Xiaoping",
          "Chiang Kai-shek",
          "Mao Zedong",
          "Sun Yat-sen",
          "Mao Zedong"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which famous explorer, commissioned by Spain, led the first expedition to circumnavigate the Earth in the early 16th century?",
          "Christopher Columbus",
          "Ferdinand Magellan",
          "Vasco da Gama",
          "John Cabot",
          "Ferdinand Magellan"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Meiji Restoration' in Japan during the 19th century marked the end of the samurai era and the beginning of rapid modernization. Who was the emperor during this period?",
          "Emperor Taisho",
          "Emperor Heisei",
          "Emperor Meiji",
          "Emperor Showa",
          "Emperor Meiji"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which ancient civilization built the city of Mohenjo-daro, known for its advanced urban planning and sewage systems?",
          "Mesopotamia",
          "Indus Valley",
          "Egypt",
          "China",
          "Indus Valley"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Dust Bowl' of the 1930s, causing severe agricultural damage, primarily affected which region of the United States?",
          "Midwest",
          "South",
          "West",
          "Northeast",
          "Midwest"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Red Terror' was a violent political repression carried out by which government in the early years of the Soviet Union?",
          "Lenin's government",
          "Stalin's government",
          "Kerensky's government",
          "Khrushchev's government",
          "Stalin's government"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which ancient Greek philosopher is known for his philosophical dialogues and contributions to the development of Western philosophy?",
          "Socrates",
          "Aristotle",
          "Plato",
          "Epicurus",
          "Plato"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Boxer Rebellion' in China at the turn of the 20th century was a violent uprising against foreign influence and imperialism. What group led the rebellion?",
          "Red Guards",
          "Boxers",
          "White Lotus Society",
          "Taiping rebels",
          "Boxers"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Doolittle Raid' during World War II involved the first air raid by the United States on the Japanese home islands. Who led this daring raid?",
          "Douglas MacArthur",
          "George Patton",
          "James Doolittle",
          "Dwight D. Eisenhower",
          "James Doolittle"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Paris Commune' of 1871 was a radical socialist and revolutionary government that briefly ruled which European capital?",
          "Berlin",
          "London",
          "Paris",
          "Vienna",
          "Paris"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Hundred Flowers Campaign' in 1950s China encouraged citizens to express their opinions openly. What followed this period of openness?",
          "Cultural Revolution",
          "Great Leap Forward",
          "Korean War",
          "Tiananmen Square protests",
          "Cultural Revolution"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Anschluss' in 1938 involved the annexation of which country by Nazi Germany?",
          "Poland",
          "Czechoslovakia",
          "Austria",
          "Hungary",
          "Austria"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the famous queen of ancient Egypt, known for her alliances and relationships with Julius Caesar and Mark Antony?",
          "Nefertiti",
          "Cleopatra",
          "Hatshepsut",
          "Nefertari",
          "Cleopatra"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Treaty of Tordesillas' in 1494 divided newly discovered lands between which two European powers, establishing spheres of influence in the Americas?",
          "Spain and Portugal",
          "England and France",
          "Netherlands and Spain",
          "Portugal and England",
          "Spain and Portugal"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which ancient civilization, located in present-day Iraq, is credited with the development of the earliest known system of writing known as cuneiform?",
          "Sumerians",
          "Assyrians",
          "Babylonians",
          "Hittites",
          "Sumerians"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Opium War' between China and Britain in the 19th century was largely a result of trade imbalances and the British desire for what product?",
          "Tea",
          "Silk",
          "Spices",
          "Opium",
          "Opium"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the military and political leader of the Soviet Union during World War II?",
          "Vladimir Putin",
          "Nikita Khrushchev",
          "Joseph Stalin",
          "Mikhail Gorbachev",
          "Joseph Stalin"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Balfour Declaration' of 1917 expressed support for the establishment of a 'national home for the Jewish people' in which region?",
          "Palestine",
          "India",
          "Australia",
          "South Africa",
          "Palestine"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which historical figure is often credited with sparking the Protestant Reformation in the 16th century by nailing the Ninety-Five Theses to a church door?",
          "John Calvin",
          "Martin Luther",
          "John Knox",
          "John Wycliffe",
          "Martin Luther"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'May Fourth Movement' in 1919 was a cultural and political movement in which country, protesting the terms of the Treaty of Versailles?",
          "China",
          "Japan",
          "India",
          "Korea",
          "China"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Opium Wars' between China and Britain led to the cession of Hong Kong to Britain. In which century did these wars take place?",
          "18th century",
          "19th century",
          "20th century",
          "17th century",
          "19th century"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The ancient city of Carthage, a major power in the Mediterranean, was located in present-day which country?",
          "Italy",
          "Greece",
          "Tunisia",
          "Egypt",
          "Tunisia"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which historical figure, known for his military conquests, is often referred to as 'The Great' and founded one of the largest empires in history?",
          "Alexander the Great",
          "Julius Caesar",
          "Genghis Khan",
          "Napoleon Bonaparte",
          "Alexander the Great"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Zimmermann Telegram,' a diplomatic communication intercepted during World War I, was sent between Germany and which country, encouraging war against the United States?",
          "Mexico",
          "Japan",
          "Russia",
          "France",
          "Mexico"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Mau Mau Uprising' was a revolt against British colonial rule in which African country during the 1950s?",
          "Nigeria",
          "Kenya",
          "South Africa",
          "Egypt",
          "Kenya"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Pax Romana' was a period of relative peace and stability in the Roman Empire. How long did this period approximately last?",
          "100 years",
          "200 years",
          "300 years",
          "400 years",
          "200 years"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Scramble for Africa' during the late 19th and early 20th centuries resulted in the colonization of nearly the entire continent. Which European power was the last to withdraw from colonial Africa?",
          "France",
          "Germany",
          "Italy",
          "Portugal",
          "Portugal"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Truman Doctrine' was a policy aimed at containing the spread of communism. In which year was it announced by President Harry S. Truman?",
          "1945",
          "1947",
          "1950",
          "1952",
          "1947"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Khmer Rouge' regime, responsible for the Cambodian genocide, was led by which political figure during the 1970s?",
          "Pol Pot",
          "Ho Chi Minh",
          "Mao Zedong",
          "Kim Il-sung",
          "Pol Pot"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Black Death' in the 14th century, which caused widespread death in Europe, is believed to have been caused by what?",
          "Bacterial infection",
          "Fungal infection",
          "Viral infection",
          "Parasitic infection",
          "Bacterial infection"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Zulu War' of 1879 involved the Battle of Isandlwana and the defense of Rorke's Drift. It took place in which modern-day country?",
          "South Africa",
          "Kenya",
          "Zimbabwe",
          "Namibia",
          "South Africa"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The ancient city of Persepolis, a significant center of the Persian Empire, is located in modern-day which country?",
          "Iraq",
          "Iran",
          "Afghanistan",
          "Syria",
          "Iran"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Trail of Tears' was a forced relocation of Native American tribes in the 1830s. Which president signed the Indian Removal Act leading to this event?",
          "James Monroe",
          "Andrew Jackson",
          "John Quincy Adams",
          "Martin Van Buren",
          "Andrew Jackson"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Berlin Airlift' in 1948-1949 was a response to the blockade of West Berlin by the Soviet Union. What was the primary objective of the airlift?",
          "Transporting military equipment",
          "Supplying food and essentials",
          "Evacuating civilians",
          "Aerial reconnaissance",
          "Supplying food and essentials"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Cuban Missile Crisis' of 1962 brought the United States and the Soviet Union to the brink of nuclear war. What event triggered the crisis?",
          "Bay of Pigs Invasion",
          "Sputnik launch",
          "U-2 spy plane incident",
          "Discovery of missile sites in Cuba",
          "Discovery of missile sites in Cuba"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Treaty of Versailles' signed in 1919 ended which major conflict?",
          "World War I",
          "World War II",
          "The Napoleonic Wars",
          "The American Civil War",
          "World War I"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Cultural Revolution' in China during the 1960s and 1970s was initiated by which political leader?",
          "Deng Xiaoping",
          "Chiang Kai-shek",
          "Mao Zedong",
          "Sun Yat-sen",
          "Mao Zedong"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which historical event is often considered the starting point of the Renaissance, a period of cultural and intellectual flourishing in Europe?",
          "The Black Death",
          "The Fall of Constantinople",
          "The Hundred Years' War",
          "The Italian Wars",
          "The Fall of Constantinople"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The 'Irish Potato Famine' in the mid-19th century led to a severe food crisis. What crop disease caused the failure of the potato crop?",
          "Late blight",
          "Powdery mildew",
          "Rust",
          "Bacterial wilt",
          "Late blight"
      )
  )

  questionsList.add(
      QuestionsModel(
          "During the Renaissance, the Medici family played a significant role in the cultural and artistic development of which Italian city?",
          "Florence",
          "Rome",
          "Venice",
          "Milan",
          "Florence"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The Treaty of Tordesillas, signed in 1494, divided the newly discovered lands outside Europe between which two countries?",
          "Spain and Portugal",
          "France and England",
          "Netherlands and Germany",
          "Italy and Austria",
          "Spain and Portugal"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Which ancient civilization is credited with the invention of the first known writing system, known as cuneiform?",
          "Egyptians",
          "Greeks",
          "Mesopotamians",
          "Romans",
          "Mesopotamians"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The Hundred Years' War, a series of conflicts between England and France, lasted from the 14th to the 15th century. What was the primary cause of this war?",
          "Territorial disputes",
          "Religious conflicts",
          "Economic competition",
          "Royal succession",
          "Territorial disputes"
      )
  )

  questionsList.add(
      QuestionsModel(
          "Who was the first female pharaoh of ancient Egypt, known for her strong and prosperous rule during the New Kingdom?",
          "Cleopatra",
          "Hatshepsut",
          "Nefertiti",
          "Isis",
          "Hatshepsut"
      )
  )

  questionsList.add(
      QuestionsModel(
          "The Byzantine Empire, which succeeded the Roman Empire in the East, had its capital in a city that is now known as:",
          "Athens",
          "Rome",
          "Constantinople",
          "Jerusalem",
          "Constantinople"
      )
  )

        questionsList.shuffle()

    }
    fun historyStageFourteen(){
        questionsList.clear()

    questionsList.add(
        QuestionsModel(
            "The Battle of Lepanto in 1571 was a significant naval engagement involving the Holy League and the Ottoman Empire. Where did this battle take place?",
            "Mediterranean Sea",
            "Black Sea",
            "Adriatic Sea",
            "North Sea",
            "Adriatic Sea"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which famous explorer, sponsored by Spain, completed the first circumnavigation of the Earth in the 16th century?",
            "Christopher Columbus",
            "Ferdinand Magellan",
            "Vasco da Gama",
            "John Cabot",
            "Ferdinand Magellan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Boxer Rebellion, an anti-foreigner and anti-Christian uprising, took place in the late 19th century in which country?",
            "China",
            "Japan",
            "India",
            "Korea",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Schism' of 1054 led to the permanent split between the Eastern Orthodox Church and which other major branch of Christianity?",
            "Roman Catholic Church",
            "Protestant Church",
            "Anglican Church",
            "Coptic Church",
            "Roman Catholic Church"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Dust Bowl' of the 1930s, characterized by severe dust storms and agricultural damage, primarily affected which region of the United States?",
            "Midwest",
            "Northeast",
            "South",
            "West",
            "Midwest"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Brest-Litovsk, signed in 1918, marked the end of the hostilities between Soviet Russia and which other country during World War I?",
            "Germany",
            "France",
            "United Kingdom",
            "Italy",
            "Germany"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Schlieffen Plan' was a strategic military plan developed by which country at the beginning of World War I?",
            "France",
            "Russia",
            "Germany",
            "United Kingdom",
            "Germany"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Cultural Revolution' in China during the 1960s and 1970s was initiated by which political leader?",
            "Deng Xiaoping",
            "Chiang Kai-shek",
            "Mao Zedong",
            "Sun Yat-sen",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "During the Cold War, the construction of the Berlin Wall in 1961 was a physical division between which two ideological blocs?",
            "Western Bloc and Eastern Bloc",
            "NATO and Warsaw Pact",
            "Allies and Axis",
            "First World and Third World",
            "Western Bloc and Eastern Bloc"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Meiji Restoration' in Japan in the 19th century led to significant modernization and industrialization. Which emperor played a central role in this period?",
            "Emperor Hirohito",
            "Emperor Akihito",
            "Emperor Meiji",
            "Emperor Taisho",
            "Emperor Meiji"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Dreyfus Affair' in late 19th and early 20th century France centered around false accusations against a military officer, highlighting issues of anti-Semitism. What was the officer's name?",
            "Louis Pasteur",
            "Alfred Dreyfus",
            "Émile Zola",
            "Marie Curie",
            "Alfred Dreyfus"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Tiananmen Square protests' of 1989 took place in which country, calling for political reform and democratic rights?",
            "South Korea",
            "China",
            "Japan",
            "Vietnam",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Berlin Airlift' in 1948-1949 was a response to the blockade of West Berlin by the Soviet Union. What was the primary objective of the airlift?",
            "Transporting military equipment",
            "Supplying food and essentials",
            "Evacuating civilians",
            "Aerial reconnaissance",
            "Supplying food and essentials"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Westphalia, signed in 1648, marked the end of which major European conflict and established the foundation for modern state sovereignty?",
            "The Hundred Years' War",
            "The Napoleonic Wars",
            "The Thirty Years' War",
            "The War of the Roses",
            "The Thirty Years' War"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Who was the military and political leader of Carthage during the Second Punic War, famously crossing the Alps to invade Italy?",
            "Hannibal Barca",
            "Scipio Africanus",
            "Julius Caesar",
            "Alexander the Great",
            "Hannibal Barca"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Opium Wars' in the 19th century involved conflicts between China and which Western colonial power?",
            "France",
            "United Kingdom",
            "Spain",
            "Portugal",
            "United Kingdom"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The Treaty of Versailles, signed in 1919, formally ended which major conflict and imposed heavy penalties on Germany?",
            "World War I",
            "World War II",
            "The Crimean War",
            "The Boer War",
            "World War I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Glorious Revolution' in 1688 resulted in the overthrow of James II and the ascension of which Protestant monarchs to the English throne?",
            "William and Mary",
            "Charles II",
            "Anne",
            "Elizabeth I",
            "William and Mary"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'May Fourth Movement' in 1919 was a cultural and intellectual movement in which Asian country, protesting the Treaty of Versailles and foreign influence?",
            "Japan",
            "China",
            "India",
            "Korea",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Zimmermann Telegram,' intercepted in 1917, played a role in the United States' decision to enter which major conflict?",
            "World War I",
            "World War II",
            "The Vietnam War",
            "The Korean War",
            "World War I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient Greek philosopher is known for his contributions to ethics, epistemology, and his student, Alexander the Great?",
            "Socrates",
            "Aristotle",
            "Plato",
            "Pythagoras",
            "Aristotle"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Bay of Pigs Invasion' in 1961 was a failed attempt by the United States to overthrow the government of which Caribbean country?",
            "Cuba",
            "Jamaica",
            "Haiti",
            "Dominican Republic",
            "Cuba"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Dolchstosslegende' or 'Stab-in-the-back myth' in post-World War I Germany claimed that the country's defeat was the result of betrayal by certain groups. Who was blamed?",
            "Communists",
            "Jews",
            "Socialists",
            "Pacifists",
            "Jews"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Partition of India' in 1947 led to the creation of two independent nations. What were these nations?",
            "India and Pakistan",
            "India and Bangladesh",
            "Pakistan and Nepal",
            "India and Sri Lanka",
            "India and Pakistan"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Red Terror' during the Russian Civil War was associated with which political ideology and group?",
            "Bolshevism",
            "Fascism",
            "Anarchism",
            "Social Democracy",
            "Bolshevism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which medieval European queen, known as 'Eleanor of Aquitaine,' was married to both the King of France and the King of England?",
            "Joan of Arc",
            "Isabella of Castile",
            "Eleanor of Aquitaine",
            "Catherine de' Medici",
            "Eleanor of Aquitaine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Irish Potato Famine' in the mid-19th century resulted in a severe population decline. What crop failed, leading to widespread famine?",
            "Wheat",
            "Barley",
            "Potatoes",
            "Corn",
            "Potatoes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Golden Age of Athens' in the 5th century BCE was marked by cultural achievements, including the works of playwrights like:",
            "Aristophanes",
            "Euripides",
            "Sophocles",
            "Herodotus",
            "Aristophanes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient civilization developed the concept of 'mandate of heaven' to justify the rule of its emperors?",
            "Mesopotamians",
            "Greeks",
            "Romans",
            "Chinese",
            "Chinese"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Irish War of Independence' against British rule took place in the early 20th century. What year did this war begin?",
            "1916",
            "1921",
            "1933",
            "1945",
            "1916"
        )
    )

    questionsList.add(
        QuestionsModel(
            "Which ancient empire, led by rulers like Hammurabi, flourished in the region known as Mesopotamia?",
            "Persian Empire",
            "Assyrian Empire",
            "Babylonian Empire",
            "Hittite Empire",
            "Babylonian Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Crusades' were a series of religious wars between the 11th and 13th centuries. Which city was the primary objective of the First Crusade?",
            "Jerusalem",
            "Mecca",
            "Constantinople",
            "Rome",
            "Jerusalem"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Ming Dynasty' ruled over which ancient and influential civilization?",
            "India",
            "China",
            "Egypt",
            "Greece",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Boxer Rebellion' in 1900 targeted foreigners and Chinese Christians. Which imperial power intervened to suppress the rebellion?",
            "France",
            "United Kingdom",
            "Russia",
            "United States",
            "Eight-Nation Alliance (including the United Kingdom)"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Babylonian Exile' was a significant event in the history of ancient Israel. Which empire conquered the Kingdom of Judah, leading to the exile?",
            "Persian Empire",
            "Babylonian Empire",
            "Assyrian Empire",
            "Roman Empire",
            "Babylonian Empire"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Treaty of Tordesillas' in 1494 divided newly discovered lands between two European powers. Which powers were involved in this treaty?",
            "Spain and Portugal",
            "France and England",
            "Netherlands and Denmark",
            "Italy and Austria",
            "Spain and Portugal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Reconquista' was a series of campaigns to reclaim the Iberian Peninsula from Muslim rule. In what year did it officially end with the capture of Granada?",
            "1265",
            "1492",
            "1337",
            "1415",
            "1492"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Khmer Empire' was a powerful Southeast Asian civilization. Which present-day country was the heart of the Khmer Empire?",
            "Vietnam",
            "Thailand",
            "Cambodia",
            "Malaysia",
            "Cambodia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Spanish Civil War' in the 1930s was a prelude to World War II. Which military leader led the Nationalist forces during the war?",
            "Francisco Franco",
            "Benito Mussolini",
            "Adolf Hitler",
            "Hideki Tojo",
            "Francisco Franco"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Schism' of 1054 led to the split between the Eastern Orthodox Church and the Roman Catholic Church. What was the primary cause of the schism?",
            "Theological differences",
            "Language barriers",
            "Political disputes",
            "Cultural conflicts",
            "Theological differences"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'An Lushan Rebellion' in the 8th century was a devastating conflict in which ancient civilization?",
            "Persian Empire",
            "Byzantine Empire",
            "Tang Dynasty China",
            "Roman Empire",
            "Tang Dynasty China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Mau Mau Uprising' in the 1950s was a struggle for independence in which African country against British colonial rule?",
            "Kenya",
            "Nigeria",
            "Ghana",
            "South Africa",
            "Kenya"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Sengoku period' in Japanese history was characterized by civil war and social upheaval. Which warlord famously unified Japan during this period?",
            "Oda Nobunaga",
            "Tokugawa Ieyasu",
            "Toyotomi Hideyoshi",
            "Date Masamune",
            "Toyotomi Hideyoshi"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Arab Spring' was a series of protests and uprisings that began in 2010. Which North African country experienced the 'Jasmine Revolution'?",
            "Egypt",
            "Tunisia",
            "Libya",
            "Algeria",
            "Tunisia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Peace of Augsburg' in 1555 was a significant treaty in Europe. What did it primarily address?",
            "Religious conflicts",
            "Territorial disputes",
            "Economic alliances",
            "Dynastic successions",
            "Religious conflicts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Battle of Lepanto' in 1571 was a naval conflict between the Holy League and the Ottoman Empire. Which country played a leading role in the Holy League?",
            "Spain",
            "France",
            "England",
            "Austria",
            "Spain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Truman Doctrine' was a Cold War policy. Which region did it primarily focus on, providing economic and military aid to prevent the spread of communism?",
            "Southeast Asia",
            "Eastern Europe",
            "Latin America",
            "Middle East",
            "Middle East"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Achaemenid Empire' was a significant ancient empire. Who was its founder and the ruler commonly known as 'Cyrus the Great'?",
            "Cyrus II",
            "Darius I",
            "Xerxes I",
            "Artaxerxes I",
            "Cyrus II"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Balfour Declaration' of 1917 expressed British support for the establishment of a 'national home for the Jewish people' in which region?",
            "Palestine",
            "India",
            "South Africa",
            "Australia",
            "Palestine"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Congress of Vienna' in 1814-1815 aimed to reshape Europe after the Napoleonic Wars. Which diplomat was a key figure in the Congress and a leader of Austria?",
            "Prince Klemens von Metternich",
            "Tsar Alexander I",
            "Lord Castlereagh",
            "Talleyrand",
            "Prince Klemens von Metternich"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Treaty of Nanking' in 1842 ended the First Opium War and ceded Hong Kong to which Western power?",
            "United Kingdom",
            "France",
            "Portugal",
            "Netherlands",
            "United Kingdom"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Taiping Rebellion' was a massive uprising in 19th-century China. What were the primary goals of the Taiping Heavenly Kingdom?",
            "Restore the Ming Dynasty",
            "Establish a utopian Christian society",
            "Overthrow the Qing Dynasty",
            "Promote Confucianism",
            "Establish a utopian Christian society"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Algerian War of Independence' was a significant conflict in the mid-20th century. Which colonial power did Algeria gain independence from?",
            "United Kingdom",
            "France",
            "Spain",
            "Italy",
            "France"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Meiji Restoration' in Japan marked a period of rapid modernization. Who was the emperor responsible for leading Japan through this transformative era?",
            "Emperor Hirohito",
            "Emperor Meiji",
            "Emperor Taisho",
            "Emperor Showa",
            "Emperor Meiji"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Berlin Conference' in 1884-1885 set the rules for the colonization of Africa. Which European powers were major participants in the conference?",
            "France, United Kingdom, and Germany",
            "Spain, Portugal, and Italy",
            "Netherlands, Belgium, and Austria",
            "Russia, Sweden, and Denmark",
            "France, United Kingdom, and Germany"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Punic Wars' were a series of conflicts between Rome and Carthage. Who was the Carthaginian military commander during the Second Punic War?",
            "Hannibal",
            "Scipio Africanus",
            "Julius Caesar",
            "Mark Antony",
            "Hannibal"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Opium Wars' in the mid-19th century involved China and a Western power. Which two treaties concluded the First Opium War?",
            "Treaty of Shimonoseki and Treaty of Kanagawa",
            "Treaty of Versailles and Treaty of Trianon",
            "Treaty of Nanking and Treaty of the Bogue",
            "Treaty of Portsmouth and Treaty of Rapallo",
            "Treaty of Nanking and Treaty of the Bogue"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Bolshevik Revolution' in 1917 led to the establishment of Soviet Russia. Who was the leader of the Bolsheviks during the revolution?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Leon Trotsky",
            "Nikita Khrushchev",
            "Vladimir Lenin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'War of the Spanish Succession' was fought in the early 18th century. Which treaty ended the war and reshaped the balance of power in Europe?",
            "Treaty of Utrecht",
            "Treaty of Westphalia",
            "Treaty of Paris",
            "Treaty of Versailles",
            "Treaty of Utrecht"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Suez Crisis' in 1956 involved military intervention by Western powers in response to nationalization. Which country's leader nationalized the Suez Canal?",
            "Egypt",
            "Iran",
            "Iraq",
            "Syria",
            "Egypt"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Dust Bowl' in the 1930s was a severe environmental disaster in the United States. Which region of the country was most affected by the Dust Bowl?",
            "Midwest",
            "South",
            "West",
            "Northeast",
            "Midwest"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Zimmermann Telegram' played a role in the United States entering World War I. Which country sent the Zimmermann Telegram?",
            "Germany",
            "Austria-Hungary",
            "Ottoman Empire",
            "Italy",
            "Germany"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Treaty of Trianon' in 1920 redrew the map of Europe after World War I. Which country was significantly reduced in size and power by this treaty?",
            "Germany",
            "Austria",
            "Hungary",
            "Poland",
            "Hungary"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Treaty of Guadalupe Hidalgo' in 1848 ended a war between the United States and which country, resulting in significant territorial changes?",
            "Mexico",
            "Spain",
            "France",
            "Canada",
            "Mexico"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Khilafat Movement' in the early 20th century sought to preserve the Ottoman Caliphate. In which country did the Khilafat Movement have a significant impact?",
            "Turkey",
            "India",
            "Egypt",
            "Saudi Arabia",
            "India"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Battle of Cannae' in 216 BCE was a significant military engagement during which ancient conflict?",
            "Peloponnesian War",
            "Punic Wars",
            "Persian Wars",
            "Samnite Wars",
            "Punic Wars"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Hundred Flowers Campaign' in 1956-1957 was an initiative in which country encouraging free expression of ideas. What country implemented this campaign?",
            "Soviet Union",
            "United States",
            "China",
            "Cuba",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'War of the Austrian Succession' involved several European powers. Which monarch's claim to the Austrian throne sparked the conflict?",
            "Maria Theresa",
            "Louis XIV",
            "Frederick the Great",
            "Charles VI",
            "Maria Theresa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Rwandan Genocide' in 1994 resulted in the mass killings of the Tutsi ethnic group. Which ethnic group was primarily responsible for the genocide?",
            "Hutu",
            "Twa",
            "Igbo",
            "Zulu",
            "Hutu"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Sykes-Picot Agreement' in 1916 was a secret understanding between two European powers regarding the division of which region after World War I?",
            "Balkans",
            "Middle East",
            "North Africa",
            "East Asia",
            "Middle East"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Codex Justinianus' was an important legal work in the Byzantine Empire. Who was the emperor responsible for compiling this legal code?",
            "Constantine the Great",
            "Justinian I",
            "Heraclius",
            "Basil II",
            "Justinian I"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Long March' was a significant event in the history of which country's communist movement?",
            "Soviet Union",
            "China",
            "Cuba",
            "Vietnam",
            "China"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Treaty of Nystad' in 1721 marked the end of a conflict between Sweden and which other European power?",
            "Russia",
            "Austria",
            "Prussia",
            "France",
            "Russia"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Boxer Rebellion' in China was a violent anti-foreign and anti-Christian uprising. In which year did the Boxer Rebellion take place?",
            "1899",
            "1905",
            "1911",
            "1900",
            "1900"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Truman Doctrine' was a key element of U.S. foreign policy during the Cold War. What was the primary goal of the Truman Doctrine?",
            "Containment of communism",
            "Expansion of democracy",
            "Military alliance with NATO",
            "Isolationism",
            "Containment of communism"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Cultural Revolution' in China was initiated by which political leader?",
            "Deng Xiaoping",
            "Mao Zedong",
            "Zhou Enlai",
            "Chiang Kai-shek",
            "Mao Zedong"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Congress of Vienna' in 1814-1815 aimed to restore stability in Europe after the Napoleonic Wars. Which diplomat played a key role in the Congress of Vienna?",
            "Klemens von Metternich",
            "Otto von Bismarck",
            "Giuseppe Garibaldi",
            "Louis XVIII",
            "Klemens von Metternich"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Balfour Declaration' of 1917 expressed support for the establishment of a national home for which people in Palestine?",
            "Palestinians",
            "Arabs",
            "Jews",
            "British",
            "Jews"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Brussels Conference' of 1890 set rules for the European colonization of which continent?",
            "Asia",
            "Africa",
            "North America",
            "South America",
            "Africa"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Battle of Lepanto' in 1571 was a naval engagement between Christian and Ottoman forces. Which European naval coalition won the battle?",
            "Spanish-French",
            "British-Dutch",
            "Portuguese-Italian",
            "Holy League",
            "Holy League"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Hundred Days' marked Napoleon Bonaparte's return to power after his exile. What was the outcome of the Battle of Waterloo during the Hundred Days?",
            "Napoleon's victory",
            "Inconclusive",
            "Duke of Wellington's victory",
            "Russian intervention",
            "Duke of Wellington's victory"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Spanish Armada' of 1588 was a naval fleet sent by which monarch to invade England?",
            "Philip II of Spain",
            "Louis XIV of France",
            "Elizabeth I of England",
            "Charles I of Spain",
            "Philip II of Spain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Congress of Berlin' in 1878 revised the Treaty of San Stefano. Which European powers were major participants in the Congress of Berlin?",
            "France, United Kingdom, and Austria",
            "Germany, Italy, and Russia",
            "Ottoman Empire, Greece, and Serbia",
            "Russia, Austria-Hungary, and Britain",
            "Russia, Austria-Hungary, and Britain"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Schism' in the Christian Church occurred in the 14th century. What was the primary cause of the Great Schism?",
            "Theological disagreements",
            "Papal authority",
            "Political conflicts",
            "Doctrinal disputes",
            "Political conflicts"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Iran-Iraq War' lasted for nearly a decade. What was the primary cause of the conflict?",
            "Territorial disputes",
            "Religious differences",
            "Oil resources",
            "Ethnic tensions",
            "Territorial disputes"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Fourteen Points' was a set of principles outlined by which world leader as a basis for peace after World War I?",
            "Woodrow Wilson",
            "Winston Churchill",
            "Georges Clemenceau",
            "David Lloyd George",
            "Woodrow Wilson"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Magna Carta' was signed in 1215, limiting the power of which English monarch?",
            "Edward I",
            "Henry V",
            "John",
            "Richard the Lionheart",
            "John"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Great Purge' in the Soviet Union targeted individuals deemed as enemies of the state. Who was the leader responsible for the Great Purge?",
            "Joseph Stalin",
            "Vladimir Lenin",
            "Nikita Khrushchev",
            "Leon Trotsky",
            "Joseph Stalin"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Cuban Missile Crisis' in 1962 brought the United States and which other country to the brink of nuclear war?",
            "China",
            "Soviet Union",
            "Cuba",
            "North Korea",
            "Soviet Union"
        )
    )

    questionsList.add(
        QuestionsModel(
            "The 'Berlin Wall' was erected in 1961 to divide East and West Berlin. Who was the leader of East Germany when the Berlin Wall was built?",
            "Erich Honecker",
            "Walter Ulbricht",
            "Egon Krenz",
            "Konrad Adenauer",
            "Walter Ulbricht"
        )
    )

        questionsList.shuffle()

    }


}