package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btnFinish = findViewById<TextView>(R.id.btn_finish)
        val finishMessage = findViewById<TextView>(R.id.tv_congrats)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

       when(correctAnswers * 10 / totalQuestions) {
           0,1,2,3,4 -> finishMessage.text = "You need to study more"
           5,6 -> finishMessage.text = "That's okay"
           7,8 -> finishMessage.text = "That's good, Congratulations!"
           9 -> finishMessage.text = "That's great, Congratulations!"
           10 -> finishMessage.text = "That's perfect, Congratulations!"

           else -> finishMessage.text = "There is something wrong"
       }

        tvName.text = userName
        tvScore.text = "Your score is $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))

        }



    }
}