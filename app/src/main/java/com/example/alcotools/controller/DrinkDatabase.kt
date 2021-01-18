package com.example.alcotools.controller

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.alcotools.model.Drink
import com.example.alcotools.model.DrinkDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Drink::class], version = 1)
abstract class DrinkDatabase: RoomDatabase () {
    abstract fun itemDao(): DrinkDAO

    companion object {
        @Volatile
        private var INSTANCE : DrinkDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): DrinkDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance : DrinkDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    DrinkDatabase::class.java,
                    "drink_database"
                )
                    .addCallback(DrinkDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                println(instance.mCallbacks)
                instance
            }
        }

        fun populateDatabase(drinkDAO: DrinkDAO) {
            for (drink: Drink in DataStorage.getDrinksList()) {
                drinkDAO.insert(drink)
            }
        }

        private class DrinkDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                println("DrinkDatabaseCallback - onCreate")
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.itemDao())
                    }
                }
            }
        }
    }
}