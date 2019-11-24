package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editHeight: EditText
    lateinit var editWeight: EditText
    lateinit var BMI: TextView
    lateinit var grading: TextView
    lateinit var clickButton: Button
    lateinit var cleanButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editHeight = findViewById(R.id.editHeight)
        editWeight = findViewById(R.id.editWeight)
        clickButton = findViewById(R.id.startButton)
        cleanButton = findViewById(R.id.cleanButton)
        BMI = findViewById(R.id.bmiValue)
        grading = findViewById(R.id.gradingValue)
        clickButton.setOnClickListener {
            var height: Float = editHeight.text.toString().toFloat()
            var weight: Float = editWeight.text.toString().toFloat()
            var bmi: Float = weight / ((height / 100) * (height / 100))
            var grade: String
            BMI.setText(bmi.toString())
            if (bmi > 24) grading.setText("過重")
            else if (bmi < 18.5) grading.setText("過輕")
            else grading.setText("正常")
        }
        cleanButton.setOnClickListener {
            editHeight.setText(" ")
            editWeight.setText(" ")
            BMI.setText(" ")
            grading.setText(" ")
        }
    }
}