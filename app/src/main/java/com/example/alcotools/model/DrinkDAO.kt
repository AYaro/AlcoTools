package com.example.alcotools.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DrinkDAO {
    @Insert
    fun insert(drink: Drink)

    @Update
    fun update(drink: Drink)

    @Delete
    fun delete(drink: Drink)

    @Query("DELETE FROM drink_table")
    fun deleteAllDrinks()

    @Query("SELECT * FROM drink_table ORDER BY liked DESC, custom DESC,  title ASC")
    fun allDrinks(): LiveData<List<Drink>>
}