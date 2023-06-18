package com.example.drinkapplication.repository

import com.example.drinkapplication.db.FavoriteDrinkDao
import com.example.drinkapplication.model.DrinkDetailsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FavoriteDrinkRepository @Inject constructor (
    private val favoriteDrinkDao: FavoriteDrinkDao) {

    suspend fun addMyFavoriteDrinks(drink: DrinkDetailsEntity) {
        favoriteDrinkDao.addFavoriteDrink(drink)
    }

    suspend fun getAllFavoriteDrinks(): List<DrinkDetailsEntity> {
        return favoriteDrinkDao.getAllFavoriteDrinks()
    }

    suspend fun deleteFavoriteDrink(drink: DrinkDetailsEntity) {
        favoriteDrinkDao.deleteFavoriteDrink(drink)
    }

    suspend fun getFavoriteDrinkIds(): MutableList<String> {
        val favoriteDrinkList = favoriteDrinkDao.getAllFavoriteDrinks()
        val favoriteDrinkIds = mutableListOf <String>()
        for (favoriteDrink in favoriteDrinkList) {
            val favoriteId = favoriteDrink.idDrink
            favoriteDrinkIds.add(favoriteId)
        }
        return favoriteDrinkIds
    }
}

