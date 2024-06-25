package com.example.animalsapp

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animalsapp.database.Animal
import com.example.animalsapp.database.AnimalDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var continentEditText: EditText
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimalAdapter

    private lateinit var database: AnimalDatabase

    private val continents = setOf("Africa", "Antarctica", "Asia", "Europe", "North America", "Australia", "South America")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        continentEditText = findViewById(R.id.continentEditText)
        addButton = findViewById(R.id.addButton)
        recyclerView = findViewById(R.id.recyclerView)

        database = AnimalDatabase.getDatabase(this)

        adapter = AnimalAdapter { animal -> deleteAnimal(animal) }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            addOrUpdateAnimal()
        }

        loadAnimals()
    }

    private fun addOrUpdateAnimal() {
        val name = nameEditText.text.toString().trim()
        val continent = continentEditText.text.toString().trim()

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(continent)) {
            showToast("Both fields are required.")
            return
        }

        if (!continents.contains(continent)) {
            showToast("Invalid continent name.")
            return
        }

        val animal = Animal(name, continent)
        CoroutineScope(Dispatchers.IO).launch {
            database.animalDao().insertOrUpdate(animal)
            loadAnimals()
        }
    }

    private fun loadAnimals() {
        CoroutineScope(Dispatchers.IO).launch {
            val animals = database.animalDao().getAllAnimals()
            withContext(Dispatchers.Main) {
                adapter.submitList(animals)
            }
        }
    }

    private fun deleteAnimal(animal: Animal) {
        CoroutineScope(Dispatchers.IO).launch {
            database.animalDao().delete(animal)
            loadAnimals()
        }
    }

    private fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}
