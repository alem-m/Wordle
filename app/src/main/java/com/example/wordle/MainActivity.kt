package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        val guessOne = findViewById<TextView>(R.id.userFirst)
        val guessTwo = findViewById<TextView>(R.id.userSecond)
        val guessThree = findViewById<TextView>(R.id.userThird)

        val mainWord = findViewById<TextView>(R.id.centerWord)
        mainWord.text = FourLetterWordList.getRandomFourLetterWord().toString().uppercase()
        mainWord.visibility = View.INVISIBLE

        val checkOne = findViewById<TextView>(R.id.userFirstCheck)
        val checkTwo = findViewById<TextView>(R.id.userSecondCheck)
        val checkThree = findViewById<TextView>(R.id.userThirdCheck)

        button.setOnClickListener {
            counter++
            if (counter == 1) {
                val userIn = findViewById<EditText>(R.id.userInput)
                val strVal : String = userIn.text.toString().uppercase()
                guessOne.text = userIn.text
                checkOne.text = checkGuess(strVal)
            } else if (counter == 2) {
                val userIn = findViewById<EditText>(R.id.userInput)
                val strVal : String = userIn.text.toString().uppercase()
                guessTwo.text = userIn.text
                checkTwo.text = checkGuess(strVal)
            } else if (counter == 3) {
                val userIn = findViewById<EditText>(R.id.userInput)
                val strVal : String = userIn.text.toString().uppercase()
                guessThree.text = userIn.text
                checkThree.text = checkGuess(strVal)
            } else if (counter >= 4){
                button.visibility = View.INVISIBLE
                mainWord.visibility = View.VISIBLE
            }

        }
    }
    var counter = 0

    private fun checkGuess(guess: String) : String {
        var result = ""
        val wordToGuess = FourLetterWordList.getRandomFourLetterWord().uppercase()
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     *
     * */


