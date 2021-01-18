package com.example.alcotools.ui.drinksList

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
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
        findViewById<LikeButton>(R.id.elementDrinkPreviewHeartButton).isLiked = drink.liked

        val editBtn: Button = findViewById(R.id.editDrinkButton)
        if (drink.custom) {
            findViewById<ImageView>(R.id.elementDrinkRecipeImageView).setImageURI(Uri.parse(drink.imageUri))
            editBtn.setOnClickListener {
                val editIntent = Intent(this, AddNewDrinkActivity::class.java)
                editIntent.putExtra("drink", drink)
                this.startActivity(editIntent)
            }
            editBtn.visibility = View.VISIBLE
        } else {
            findViewById<ImageView>(R.id.elementDrinkRecipeImageView).setImageResource(drink.image!!)
            editBtn.visibility = View.GONE
        }
    }
}