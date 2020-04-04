package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import org.jetbrains.anko.toast

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 전달받은 키와 몸무게
        val height = intent.getStringExtra("height").toInt() // 인텐트로부터 데이터 받아오기, 정수형으로 변환
        val weight = intent.getStringExtra("weight").toInt() // 인텐트로부터 데이터 받아오기, 정수형으로 변환

        // BMI 계산
        val bmi = weight/Math.pow(height/100.0, 2.0)   // Math.pow(밑, 지수) --> 제곱함수

        // 결과 표시
        when {
            bmi >= 27 -> resultTextView.text = "OBESE"
            bmi >= 23 -> resultTextView.text = "OVER WEIGHT"
            bmi >= 18.5 -> resultTextView.text = "HEALTHY RANGE"
            else -> resultTextView.text = "UNDERWEIGHT"
        }

        // 이미지 표시
        when {
            bmi >= 23 ->
                imageView.setImageResource(
                    R.drawable.ic_sentiment_very_dissatisfied_black_24dp)

            bmi >= 18.5 ->
            imageView.setImageResource(
                R.drawable.ic_sentiment_satisfied_black_24dp)

            else ->
            imageView.setImageResource(
                R.drawable.ic_sentiment_dissatisfied_black_24dp)
        }

        toast("$bmi")
    }
}
