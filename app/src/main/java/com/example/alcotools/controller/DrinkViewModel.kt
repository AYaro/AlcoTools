package com.example.alcotools.controller

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.alcotools.model.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DrinkViewModel(application: Application): AndroidViewModel(application) {
    private var repository = DrinkRepository(application.applicationContext, viewModelScope)

    var allDrinks = repository.allDrinks

    fun insert(drink: Drink) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(drink)
    }

    fun update(drink: Drink) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(drink)
    }

    fun delete(drink: Drink) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(drink)
    }
}
