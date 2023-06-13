package com.example.drinkapplication.repository

import com.example.drinkapplication.model.CocktailByID
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.network.CocktailApi
import retrofit2.Response
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val api: CocktailApi
) {
    suspend fun getAllCocktailList() = api.getCocktailList()

    suspend fun getAlcoholicDrinks () = api.getAlcoholicDrinks()

    suspend fun getNonAlcoholicDrinks()=api.getNonAlcoholicDrinks()

    suspend fun getDrinkInfo(idDrink: String): Response<CocktailByID> {
        return api.getCocktailInfo(idDrink)
    }

}