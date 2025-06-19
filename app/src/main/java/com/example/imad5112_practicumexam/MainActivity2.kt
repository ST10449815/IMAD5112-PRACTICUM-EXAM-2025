package com.example.imad5112_practicumexam

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val displayButton = findViewById<Button>(R.id.btnShowAll)
        val averageButton = findViewById<Button>(R.id.btnShowFiltered)
        val returnButton = findViewById<Button>(R.id.btnReturn)

        displayButton.setOnClickListener {
            displayItems(showAll = true)
        }
        averageButton.setOnClickListener {
            displayItems(showAll = false)
        }
        returnButton.setOnClickListener {
            finish()
        }
    }

    private fun displayItems(showAll: Boolean) {
        val builder = StringBuilder()

        for (i in MainActivity.songTitle.indices) {
            val rating = MainActivity.rating[i]
            if (showAll || rating >= 5) {
                builder.append("title:${MainActivity.songTitle[i]}\n")
                builder.append("name: ${MainActivity.artistName[i]}\n")
                builder.append("rating: $rating\n")
                builder.append("comments: ${MainActivity.comments[i]}\n\n")
            }
        }
    }
}


