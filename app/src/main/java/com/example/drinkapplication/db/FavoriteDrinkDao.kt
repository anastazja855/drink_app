package com.example.drinkapplication.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.drinkapplication.model.Drink

@Dao
interface FavoriteDrinkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteDrink (drink: Drink)

    @Delete
    suspend fun deleteFavoriteDrink (drink: Drink)

    @Query("SELECT * FROM favoriteDrink")
    suspend fun getFavoriteDrinks(): List<Drink>
}