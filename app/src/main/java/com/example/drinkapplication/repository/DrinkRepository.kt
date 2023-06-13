package com.example.drinkapplication.repository

import com.example.drinkapplication.network.CocktailApi
import javax.inject.Inject

class DrinkRepository @Inject constructor(
    private val api: CocktailApi
) {
    suspend fun getDrinkInfo(idDrink: String) = api.getCocktailInfo(idDrink)
}