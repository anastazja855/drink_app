package com.example.drinkapplication.model

import com.google.gson.annotations.SerializedName

data class CocktailByID(
    @SerializedName("drinks")
    val drinks: ArrayList<DrinkDetails>
)