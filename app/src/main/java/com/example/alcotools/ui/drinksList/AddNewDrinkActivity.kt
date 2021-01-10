package com.example.alcotools.ui.drinksList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.alcotools.R

class AddNewDrinkActivity : AppCompatActivity() {

//    private val id: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        println("AddItemActivity - onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_drink)

        findViewById<Button>(R.id.buttonExitAddDrink).setOnClickListener{finish()}
        findViewById<Button>(R.id.buttonAddNewDrink).setOnClickListener{finish()}

        //todo edit and add to database
//        if (intent.extras != null) {
//            val recycleElement = intent.extras?.get("drink") as Drink
//            findViewById<EditText>(R.id.titleEditText).setText(recycleElement.title)
//            findViewById<EditText>(R.id.descriptionEditText).setText(recycleElement.description)
//            findViewById<CheckBox>(R.id.priorityImportantCheckBox).isChecked = recycleElement.priority
//            id = recycleElement.id
//        } else {
//            id = -1
//        }
    }

//    private fun saveItem() {
//        println("AddItemActivity - saveItem()")
//        if (id == -1) {
//            itemViewModel.insert(Item(
//                findViewById<EditText>(R.id.titleEditText).text.toString(),
//                findViewById<EditText>(R.id.descriptionEditText).text.toString(),
//                findViewById<CheckBox>(R.id.priorityImportantCheckBox).isChecked
//            ))
//        } else {
//            val item = Item(findViewById<EditText>(R.id.titleEditText).text.toString(),
//                findViewById<EditText>(R.id.descriptionEditText).text.toString(),
//                findViewById<CheckBox>(R.id.priorityImportantCheckBox).isChecked)
//            item.id = id
//            itemViewModel.update(item)
//        }
//        finish()
//    }
}