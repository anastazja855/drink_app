package com.example.drinkapplication.screens.drinkInfo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.network.CocktailApi
import com.example.drinkapplication.repository.CocktailRepository
import com.example.drinkapplication.repository.FavoriteDrinkRepository
import com.example.drinkapplication.utills.DrinkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DrinkInfoViewModel @Inject constructor(
    private val repository: CocktailRepository,
    private val cocktailApi: CocktailApi,
    private val favoriteDrinkRepository: FavoriteDrinkRepository,
) : ViewModel() {
    private val _drinkInfo = MutableLiveData<DrinkDetails>()
    val drinkInfo: LiveData<DrinkDetails> = _drinkInfo

    fun setDrinkInfo(drinkDetails: DrinkDetails) {
        _drinkInfo.value = drinkDetails
    }


//    fun getDrinkInfo(idDrink:String) {
//        viewModelScope.launch {
//            val response = repository.getDrinkInfo(idDrink)
//            if (response.isSuccessful) {
//                response.body()?.let {
//                    _drinkInfo.postValue(it)
//                }
//            }
//        }
//    }

    suspend fun fetchAdditionalData(idDrink: String): DrinkDetails? {
        val response = cocktailApi.getCocktailInfo(idDrink)
        return if (!response.isSuccessful) {
            Log.e("API Error", "Failed to fetch additional data")
            null
        } else {
            val cocktailByID = response.body()
            cocktailByID?.drinks?.firstOrNull()
        }
    }

    private val drinkUtils: DrinkUtils = DrinkUtils(favoriteDrinkRepository, cocktailApi, viewModelScope)
    fun addDrinkToFavorites(drink: Drink) {
        drinkUtils.addFavoriteDrink(drink)
    }
}