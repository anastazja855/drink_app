package com.example.drinkapplication.utills

import com.example.drinkapplication.repository.FavoriteDrinkRepository


    suspend fun isFavorite(favoriteDrinkRepository: FavoriteDrinkRepository, drinkId: String): Boolean {
        val favoriteDrinkIds = favoriteDrinkRepository.getFavoriteDrinkIds()
        return drinkId in favoriteDrinkIds
    }