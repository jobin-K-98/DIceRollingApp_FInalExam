package com.example.rollthedice

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var diceSpinner: Spinner
    private lateinit var rollButton: Button
    private lateinit var rollTwiceButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var result2TextView: TextView
    private lateinit var diceValues: MutableList<Int>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        diceValues = mutableListOf(4, 6, 8, 10, 12, 20)

        diceSpinner = findViewById(R.id.dice_spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, diceValues)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        diceSpinner.adapter = adapter

        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            val maxVal = diceSpinner.selectedItem as Int
            val randomVal = (Math.random() * maxVal + 1).toInt()
            resultTextView.text = randomVal.toString()
        }

        rollTwiceButton = findViewById(R.id.roll_twice_button)
        rollTwiceButton.setOnClickListener {
            val maxVal = diceSpinner.selectedItem as Int
            val randomVal1 = (Math.random() * maxVal + 1).toInt()
            val randomVal2 = (Math.random() * maxVal + 1).toInt()
            resultTextView.text = randomVal1.toString()
            result2TextView.text = randomVal2.toString()
            result2TextView.visibility = View.VISIBLE
        }

        resultTextView = findViewById(R.id.result_text_view)
        result2TextView = findViewById(R.id.result2_text_view)
        result2TextView.visibility = View.INVISIBLE
    }
}
