package com.example.drinkapplication.repository

import com.example.drinkapplication.network.CocktailApi
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val api: CocktailApi
) {
    suspend fun getAllCocktailList() = api.getCocktailList()

    suspend fun getAlcoholicDrinks () = api.getAlcoholicDrinks()

    suspend fun getNonAlcoholicDrinks()=api.getNonAlcoholicDrinks()

    suspend fun getDrinkInfo(idDrink: String)=api.getCocktailInfo(idDrink)

}