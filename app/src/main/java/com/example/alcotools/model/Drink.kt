package com.example.alcotools.model

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Drink (
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
    val ingredientsList: String,
    val portionMl: Float,
    val alcoholDose: Float,
    val liked: Boolean
) : Serializable