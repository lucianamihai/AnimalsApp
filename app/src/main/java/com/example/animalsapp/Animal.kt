package com.example.animalsapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animals")
data class Animal(
    @PrimaryKey val name: String,
    val continent: String
)
