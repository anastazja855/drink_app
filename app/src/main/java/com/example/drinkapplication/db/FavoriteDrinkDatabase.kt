package com.example.drinkapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.drinkapplication.model.Drink

@Database(entities = [Drink::class], version = 1)
abstract class FavoriteDrinkDatabase: RoomDatabase() {
    abstract fun favoriteDrinkDao(): FavoriteDrinkDao
}