package com.example.drinkapplication.screens.favoriteDrink

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinkapplication.db.FavoriteDrinkDao
import com.example.drinkapplication.model.DrinkDetailsEntity
import com.example.drinkapplication.repository.FavoriteDrinkRepository
import com.example.drinkapplication.uistate.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteDrinkViewModel @Inject constructor(
    private val favoriteDrinkRepository: FavoriteDrinkRepository
): ViewModel() {
    val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    var isDrinkFavorite: Boolean = false

    private val _favoriteDrinks: MutableLiveData<List<DrinkDetailsEntity>> = MutableLiveData()
    val favoriteDrinks: LiveData<List<DrinkDetailsEntity>> get() = _favoriteDrinks


    init {
        loadFavoriteDrinks()
    }

    private fun loadFavoriteDrinks(){
        viewModelScope.launch {
            val myDrinks = favoriteDrinkRepository.getAllFavoriteDrinks()
            _favoriteDrinks.value = myDrinks
        }
    }

    fun deleteFavoriteDrink(drink: DrinkDetailsEntity) {
        viewModelScope.launch {
            favoriteDrinkRepository.deleteFavoriteDrink(drink)
            loadFavoriteDrinks()
        }
    }

}