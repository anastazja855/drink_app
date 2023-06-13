package com.example.drinkapplication.repository

import com.example.drinkapplication.db.FavoriteDrinkDao
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.model.DrinkDetailsEntity
import javax.inject.Inject


class FavoriteDrinkRepository @Inject constructor (private val favoriteDrinkDao: FavoriteDrinkDao) {

    suspend fun addMyFavoriteDrinks (drink: DrinkDetailsEntity){
            favoriteDrinkDao.addFavoriteDrink(drink)
    }
}