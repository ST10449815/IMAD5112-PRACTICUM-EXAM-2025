//ST10449815 - THASHNI MOODLEY
package com.example.imad5112_practicumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        val songTitle = mutableListOf<String>()
        val artistName = mutableListOf<String>()
        val rating = mutableListOf<Int>()
        val comments = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val songTitle = findViewById<EditText>(R.id.editTitle)
        val artistName = findViewById<EditText>(R.id.editName)
        val rating = findViewById<EditText>(R.id.editRating)
        val comments = findViewById<EditText>(R.id.editComment)

        val addButton = findViewById<Button>(R.id.btnAdd)
        val nextScreenButton = findViewById<Button>(R.id.btnNext)
        val exitButton = findViewById<Button>(R.id.btnExit)

        addButton.setOnClickListener {
            val songTitle = songTitle.text.toString().trim()
            val artistName = artistName.text.toString().trim()
            val ratingStr = rating.text.toString().trim()
            val comments = comments.text.toString().trim()

            if (songTitle.isEmpty() || artistName.isEmpty() || ratingStr.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val rating = ratingStr.toIntOrNull()
            if (rating == null || rating <= 1) {
                Toast.makeText(this, "Please enter a valid rating", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            songTitle.add()
            artistName.add()
            ratingStr.add()
            comments.add()

            Toast.makeText(this, "Item added", Toast.LENGTH_SHORT).show()

            nextScreenButton.setOnClickListener {
                startActivity(Intent(this, SecondActivity::class.java))
            }

            exitButton.setOnClickListener {
                finishAffinity()


            }
        }
    }
}

private fun String.add() {}

class SecondActivity
