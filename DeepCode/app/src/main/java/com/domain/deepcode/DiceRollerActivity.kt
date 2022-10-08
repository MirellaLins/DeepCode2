package com.domain.deepcode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DiceRollerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val diceSides = listOf (
            R.drawable.face1,
            R.drawable.face2,
            R.drawable.face3,
            R.drawable.face4,
            R.drawable.face5,
            R.drawable.face6,
        )

        val diceFace: ImageView = findViewById(R.id.ivDice)
        val diceNumber: TextView = findViewById(R.id.tvDiceNumber)
        val btRoll: Button = findViewById(R.id.btRoll)

        btRoll.setOnClickListener {
            val face = roll(diceSides.size -1)

            diceFace.setImageResource(diceSides[face])
            diceNumber.text = (face+1).toString()
        }

    }

    fun roll(numSides: Int) : Int {
        return (0..numSides).random()
    }
}