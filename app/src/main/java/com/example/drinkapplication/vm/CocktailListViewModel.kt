package com.example.drinkapplication.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.network.CocktailSource
import com.example.drinkapplication.repository.FavoriteDrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CocktailListViewModel @Inject constructor(
    private val dataSource: CocktailSource,
    private val favoriteDrinkRepository: FavoriteDrinkRepository
):ViewModel() {
    val flow = Pager(
        PagingConfig(pageSize = 100)
    ){
        dataSource
    }.flow.cachedIn(viewModelScope)

    suspend fun addFavoriteDrink (drink: Drink){
        favoriteDrinkRepository.addMyFavoriteDrinks(drink)
    }

}