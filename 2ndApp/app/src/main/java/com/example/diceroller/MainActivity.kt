package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

//    private fun rollDice() {
//        //Creates dice object with 6 sides, rolls it and then places in as a string in textview
//        val dice = Dice(6)
//        val diceRoll1 = dice.roll().toString()
//        val diceRoll2 = dice.roll().toString()
//        val stringFull = diceRoll1 + " " + diceRoll2
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = stringFull
//    }

    private fun rollDice() {
        //Creates dice object with 6 sides, rolls it and then places in as a string in textview
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

    }
}