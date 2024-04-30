package com.example.animalsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backButton = findViewById<Button>(R.id.backButton)
        val closeButton = findViewById<Button>(R.id.closeButton)

        backButton.setOnClickListener {
            onBackPressed()
        }

        closeButton.setOnClickListener {
            finish()
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AnimalListFragment())
                .commit()
        }
    }
}
