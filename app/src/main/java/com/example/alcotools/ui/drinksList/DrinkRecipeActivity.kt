package com.example.alcotools.ui.drinksList

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.alcotools.R
import com.example.alcotools.model.Drink
import com.like.LikeButton

class DrinkRecipeActivity : AppCompatActivity() {

    private val dose: String = "Dose: "

    override fun onCreate(savedInstanceState: Bundle?) {
        println("DrinkRecipeActivity - onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drink_recipe)
        val drink = intent.extras?.get("drink") as Drink

        findViewById<TextView>(R.id.elementDrinkRecipeTitle).text = drink.title
        findViewById<TextView>(R.id.elementDrinkRecipeAlcohol).text = dose.plus(drink.alcoholDose.toString())
        findViewById<TextView>(R.id.elementDrinkRecipeDescription).text = drink.description
        findViewById<TextView>(R.id.elementDrinkRecipePortionMl).text = drink.portionMl.toString().plus(" ml")
        findViewById<TextView>(R.id.elementDrinkRecipeIngredientsList).text = drink.ingredientsList
        findViewById<ImageView>(R.id.elementDrinkRecipeImageView).setImageResource(drink.image)
        findViewById<LikeButton>(R.id.elementDrinkPreviewHeartButton).isLiked = drink.liked
    }
}