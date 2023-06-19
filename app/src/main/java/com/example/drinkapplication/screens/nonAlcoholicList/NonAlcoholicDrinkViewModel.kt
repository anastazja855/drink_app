package com.example.drinkapplication.screens.nonAlcoholicList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.network.CocktailApi
import com.example.drinkapplication.repository.FavoriteDrinkRepository
import com.example.drinkapplication.repository.NonAlcoholicDrinkSource
import com.example.drinkapplication.utills.DrinkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NonAlcoholicDrinkViewModel @Inject constructor(
    datasource: NonAlcoholicDrinkSource,
    private val cocktailApi: CocktailApi,
    private val favoriteDrinkRepository: FavoriteDrinkRepository,
): ViewModel (){
    val flow= Pager(
        PagingConfig(pageSize = 100)
    ) {
        datasource
    }.flow.cachedIn(viewModelScope)

    private val drinkUtils: DrinkUtils = DrinkUtils(favoriteDrinkRepository, cocktailApi, viewModelScope)
    fun addDrinkToFavorites(drink: Drink) {
        drinkUtils.addFavoriteDrink(drink)
    }

}