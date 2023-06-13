package com.example.drinkapplication.network


import com.example.drinkapplication.model.CocktailByID
import com.example.drinkapplication.model.CocktailList
import com.example.drinkapplication.model.CocktailSearchListModel
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.model.DrinkX
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("filter.php?c=Cocktail")
    suspend fun getCocktailList():Response<CocktailList>

    @GET ("filter.php?a=Alcoholic")
    suspend fun getAlcoholicDrinks ():Response<CocktailList>

    @GET ("filter.php?a=Non_Alcoholic")
    suspend fun getNonAlcoholicDrinks():Response<CocktailList>

    @GET("lookup.php")
    suspend fun getCocktailInfo(@Query("i") idDrink: String): Response<CocktailByID>

    @GET("search.php")
    suspend fun searchCocktails (@Query("s") query: String): Response<CocktailSearchListModel>

    companion object{
        const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
    }
}