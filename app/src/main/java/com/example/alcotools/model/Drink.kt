package com.example.alcotools.model

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "drink_table")
data class Drink (
    val title: String,
    @DrawableRes val image: Int?,
    val imageUri: String?,
    val description: String,
    val ingredientsList: String,
    val portionMl: Float,
    val alcoholDose: Float,
    val liked: Boolean,
    val custom: Boolean
) : Serializable{
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
