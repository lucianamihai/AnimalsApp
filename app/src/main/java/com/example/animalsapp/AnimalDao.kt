package com.example.animalsapp.database

import androidx.room.*

@Dao
interface AnimalDao {
    @Query("SELECT * FROM animals")
    fun getAllAnimals(): List<Animal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(animal: Animal)

    @Delete
    fun delete(animal: Animal)
}
