package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// Activity ini memperbolehkan pengguna untuk roll sebuah dadu dan melihat hasilnya pada layar
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    // roll dadu dan update layar dengan hasilnya
    private fun rollDice() {
        // buat objek dadu baru dengan 6 sisi dan roll dadu
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // temukan ImageView di layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Tentukan ID sumber yg di dapat digambar mana yang akan digunakan berdasarkan roll dadu
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Uodate ImageView dengan ID sumber drawable yang benar
        diceImage.setImageResource(drawableResource)

        // Update deskripsi konten
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}