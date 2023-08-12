package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Dice(private val numSides: Int) {


    fun roll(): Int {
        return (1..numSides).random()

    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //listener for the button click
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        //Creates dice object with 6 sides, rolls it and then places in as a string in textview
        val dice = Dice(6)
        val diceRoll1 = dice.roll().toString()
        val diceRoll2 = dice.roll().toString()
        val stringFull = diceRoll1 + " " + diceRoll2
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = stringFull
    }
}