package com.example.alcotools.controller

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.alcotools.model.Drink
import com.example.alcotools.model.DrinkDAO
import kotlinx.coroutines.CoroutineScope

class DrinkRepository(context: Context, scope: CoroutineScope) {
    private val drinkDAO: DrinkDAO
    val allDrinks: LiveData<List<Drink>>

    init {
        println("DrinkRepository - init")
        val database: DrinkDatabase = DrinkDatabase.getDatabase(context, scope)
        drinkDAO = database.itemDao()
        allDrinks = drinkDAO.allDrinks()
    }

    fun insert(drink: Drink) {
        drinkDAO.insert(drink)
    }

    fun update(drink: Drink) {
        drinkDAO.update(drink)
    }

    fun delete(drink: Drink) {
        drinkDAO.delete(drink)
    }
}