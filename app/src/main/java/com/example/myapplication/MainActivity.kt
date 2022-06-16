package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var firstNum: EditText
    private lateinit var secondNum: EditText
    private lateinit var resultText: TextView
    private lateinit var sumButton: Button
    private lateinit var error: TextView
    private lateinit var clear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNum = findViewById(R.id.firstNumber_input_number)
        secondNum = findViewById(R.id.secondNumber_input_number)
        resultText = findViewById(R.id.result_text)
        sumButton = findViewById(R.id.sum_button)
        error = findViewById(R.id.error_text)
        clear = findViewById(R.id.clear_button)

        sumButton.setOnClickListener {
            sumNumbers()
        }

        clear.setOnClickListener {
            firstNum.setText("")
            secondNum.setText("")
            clear.visibility = View.INVISIBLE
        }

    }

    private fun sumNumbers() {
        try {
            val x = firstNum.text.toString().toDouble()
            val y = secondNum.text.toString().toDouble()
            val sum = x + y
            resultText.text = sum.toString()
            clear.visibility = View.VISIBLE
            error.visibility = View.INVISIBLE
        } catch (e: Exception) {
            error.visibility = View.VISIBLE
        }
    }
}