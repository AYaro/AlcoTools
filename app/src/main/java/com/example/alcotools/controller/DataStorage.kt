package com.example.alcotools.controller

import com.example.alcotools.R
import com.example.alcotools.model.Drink

object DataStorage {

    fun getDrinksList(): List<Drink> {
        return listOf(
                Drink(
                        "Виски-кола",
                        R.drawable.whisky_cola,
                        null,
                        "В равных пропорциях смешиваем виски с колой",
                        "Виски, кола",
                        300.toFloat(),
                        9.375.toFloat(),
                        liked = true,
                        custom = false
                ),
                Drink(
                        "Водка",
                        R.drawable.vodka,
                        null,
                        "Просто водка, лучше из морозилки",
                        "Водка",
                        50.toFloat(),
                        1.56.toFloat(),
                        liked = true,
                        custom = false
                ),
                Drink(
                        "Джин-тоник",
                        R.drawable.tonik,
                        null,
                        "Классика, чистый джин и тоник, что может быть лучше",
                        "Джин",
                        250.toFloat(),
                        7.8125.toFloat(),
                        liked = true,
                        custom = false
                ),
                Drink(
                        "Гараж",
                        R.drawable.garage,
                        null,
                        "Просто гараж",
                        "Изучаются",
                        440.toFloat(),
                        9.375.toFloat(),
                        liked = true,
                        custom = false
                )
        )
    }
}