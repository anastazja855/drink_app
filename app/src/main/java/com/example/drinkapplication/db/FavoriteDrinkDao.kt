package com.example.drinkapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.drinkapplication.model.DrinkDetailsEntity


@Dao
interface FavoriteDrinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteDrink(drink: DrinkDetailsEntity)

    @Delete
    suspend fun deleteFavoriteDrink(drink: DrinkDetailsEntity)

    @Query("SELECT * FROM drinkDetails")
    suspend fun getAllFavoriteDrinks(): List<DrinkDetailsEntity>
}