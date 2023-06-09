package com.example.drinkapplication.repository

import com.example.drinkapplication.db.FavoriteDrinkDao
import com.example.drinkapplication.model.Drink
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class FavoriteDrinkRepository @Inject constructor (private val favoriteDrinkDao: FavoriteDrinkDao) {

    suspend fun addMyFavoriteDrinks (drink: Drink){
        withContext(Dispatchers.IO){
            favoriteDrinkDao?.let {
                dao ->
                dao.addFavoriteDrink(drink)
            } ?: throw IllegalStateException("null")
        }
    }
}