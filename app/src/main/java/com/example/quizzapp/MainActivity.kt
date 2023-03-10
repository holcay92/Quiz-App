package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)
        var etName = findViewById<EditText>(R.id.et_text)
        btnStart.setOnClickListener {
            if (etName.text.isEmpty()) {
               Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                // from this to other activity we need to use intent
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                // this will finish the current activity and will not allow to go back
                finish()
            }
        }
    }
}