package com.example.drinkapplication.network

import com.example.drinkapplication.model.CocktailList
import com.example.drinkapplication.model.Drink
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("filter.php?c=Cocktail")
    suspend fun getCocktailList():Response<CocktailList>

    @GET("lookup.php")
    suspend fun getCocktailInfo(@Query("i") idDrink: String):Response<CocktailList>

    companion object{
        const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
    }
}