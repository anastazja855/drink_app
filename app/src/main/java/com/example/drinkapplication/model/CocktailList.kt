package com.example.drinkapplication.model

import com.google.gson.annotations.SerializedName

data class CocktailList(
    @SerializedName("drinks")
    val drinks: ArrayList<Drink>
)