package com.example.alcotools.ui.drinksList

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.alcotools.R
import com.example.alcotools.controller.DrinkViewModel
import com.example.alcotools.model.Drink
import com.like.LikeButton

class AddNewDrinkActivity : AppCompatActivity() {
    private val drinkViewModel: DrinkViewModel by viewModels()
    private var id: Int = -1
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        println("AddNewDrinkActivity - onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_drink)

        findViewById<Button>(R.id.buttonExitAddDrink).setOnClickListener{finish()}
        findViewById<Button>(R.id.buttonAddNewDrink).setOnClickListener{finish()}

        val imgBtn: ImageView = findViewById(R.id.elementDrinkRecipeImageView)

        if (intent.extras != null) {
            val drink = intent.extras?.get("drink") as Drink
            findViewById<TextView>(R.id.elementDrinkRecipeTitle).text = drink.title
            findViewById<TextView>(R.id.elementDrinkRecipeAlcohol).text = drink.alcoholDose.toString()
            findViewById<TextView>(R.id.elementDrinkRecipeDescription).text = drink.description
            findViewById<TextView>(R.id.elementDrinkRecipePortionMl).text = drink.portionMl.toString()
            findViewById<TextView>(R.id.elementDrinkRecipeIngredientsList).text = drink.ingredientsList
            imageUri = Uri.parse(drink.imageUri)
            imgBtn.setImageURI(imageUri)
            findViewById<LikeButton>(R.id.elementDrinkPreviewHeartButton).isLiked = drink.liked
            id = drink.id
        } else {
            id = -1
        }
        findViewById<Button>(R.id.buttonAddNewDrink).setOnClickListener {
            saveDrink()
        }
        findViewById<Button>(R.id.buttonExitAddDrink).setOnClickListener {
            finish() // todo add are you sure you wanna exit MINOR
        }
        imgBtn.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE)
                }
                else { // permission already granted
                    pickImageFromGallery()
                }
            }
            else { // system OS is < Marshmallow
                pickImageFromGallery()
            }
        }
    }

    // todo add picture from camera MINOR
    private fun saveDrink() {
        println("AddNewDrinkActivity - saveDrink()")
        if (id == -1) {
            drinkViewModel.insert(
                Drink(
                    findViewById<TextView>(R.id.elementDrinkRecipeTitle).text.toString(),
                    null,
                    imageUri.toString(), // todo TEST resource address MAJOR
                    findViewById<TextView>(R.id.elementDrinkRecipeDescription).text.toString(),
                    findViewById<TextView>(R.id.elementDrinkRecipeIngredientsList).text.toString(),
                    findViewById<TextView>(R.id.elementDrinkRecipePortionMl).text.toString().toFloat(),
                    findViewById<TextView>(R.id.elementDrinkRecipeAlcohol).text.toString().toFloat(),
                    findViewById<LikeButton>(R.id.elementDrinkPreviewHeartButton).isLiked,
                    true
                )
            )
        } else {
            val drink = Drink(
                findViewById<TextView>(R.id.elementDrinkRecipeTitle).text.toString(),
                null,
                imageUri.toString(), // todo TEST resource address MAJOR
                findViewById<TextView>(R.id.elementDrinkRecipeDescription).text.toString(),
                findViewById<TextView>(R.id.elementDrinkRecipeIngredientsList).text.toString(),
                findViewById<TextView>(R.id.elementDrinkRecipePortionMl).text.toString().toFloat(),
                findViewById<TextView>(R.id.elementDrinkRecipeAlcohol).text.toString().toFloat(),
                findViewById<LikeButton>(R.id.elementDrinkPreviewHeartButton).isLiked,
                true
            )
            drink.id = id
            drinkViewModel.update(drink)
        }
        finish()
    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK) // ACTION_OPEN_DOCUMENT
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000;
        //Permission code
        private val PERMISSION_CODE = 1001;
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    //permission from popup granted
                    pickImageFromGallery()
                } else {
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            findViewById<ImageView>(R.id.elementDrinkRecipeImageView).setImageURI(data?.data)
            imageUri = data?.data
        }
    }
}