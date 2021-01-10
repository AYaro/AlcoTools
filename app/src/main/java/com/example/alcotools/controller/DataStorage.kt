package com.example.alcotools.controller

import com.example.alcotools.R
import com.example.alcotools.model.Drink

object DataStorage {

    fun getDrinksList(): List<Drink> {
        return listOf(
                Drink(
                        "Виски-кола",
                        R.drawable.ic_launcher_background,
                        "В равных пропорциях смешиваем виски с колой",
                        "Виски, кола",
                        300.toFloat(),
                        9.375.toFloat(),
                        true
                ),
                Drink(
                        "Водка",
                        R.drawable.ic_launcher_background,
                        "Просто водка, лучше из морозилки",
                        "Водка",
                        50.toFloat(),
                        1.56.toFloat(),
                        true
                )
        )
    }
}