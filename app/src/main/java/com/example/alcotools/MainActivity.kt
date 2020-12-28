package com.example.alcotools

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.alcotools.ui.drinksList.Drink
import com.example.alcotools.ui.drinksList.DrinkRecipeActivity
import com.example.alcotools.ui.drinksList.OpenDrinkDetailsListener

class MainActivity : AppCompatActivity(), OpenDrinkDetailsListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)



        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_drinks_list))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



//        supportFragmentManager.beginTransaction()
//            .add(R.id.container, DetailsFragment.newInstance(drink))
//            .addToBackStack(null)
//            .commit()
    }

    override fun onOpenDrinkDetailsListenerClicked(drink: Drink) {
        println("MAIN ACTIVITY onOpenDrinkDetailsListenerClicked")
        val intent = Intent(this, DrinkRecipeActivity::class.java)
        intent.putExtra("drink", drink)
        this.startActivity(intent)
    }
}