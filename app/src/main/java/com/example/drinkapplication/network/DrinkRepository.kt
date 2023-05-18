package com.example.drinkapplication.network

import javax.inject.Inject

class DrinkRepository @Inject constructor(
    private val api: CocktailApi
) {
    suspend fun getDrinkInfo(idDrink: String) = api.getCocktailInfo(idDrink)
}