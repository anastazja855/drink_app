package com.example.drinkapplication.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.model.DrinkDetailsEntity
import com.example.drinkapplication.model.DrinkX
import com.example.drinkapplication.network.CocktailApi
import com.example.drinkapplication.repository.CocktailSource
import com.example.drinkapplication.repository.FavoriteDrinkRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailListViewModel @Inject constructor(
    private val dataSource: CocktailSource,
    private val cocktailApi: CocktailApi,
    private val favoriteDrinkRepository: FavoriteDrinkRepository
) : ViewModel() {
    val flow = Pager(
        PagingConfig(pageSize = 100)
    ) {
        dataSource
    }.flow.cachedIn(viewModelScope)



//    fun addFavoriteDrink(idDrink: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val additionalData = fetchAdditionalData(idDrink)
//            additionalData?.let { details ->
//                val drinkDetailsEntity = DrinkDetailsEntity(
//                    idDrink = details.idDrink,
//                    strDrink = details.strDrink,
//                    strDrinkThumb = details.strDrinkThumb,
//                    dateModified = details.dateModified,
//
//                strAlcoholic= details.strAlcoholic ,
//                strCategory= details.strCategory ,
//                strCreativeCommonsConfirmed= details.strCreativeCommonsConfirmed ,
//                strDrinkAlternate = details?.strDrinkAlternate,
//                strGlass= details.strGlass ,
//                strIBA= details.strIBA ,
//                strImageAttribution= details.strImageAttribution,
//                strImageSource= details.strImageSource,
//                strIngredient1= details.strIngredient1,
//                strIngredient2= details.strIngredient2,
//                strIngredient3= details.strIngredient3,
//                strIngredient4= details.strIngredient4,
//                strIngredient5= details.strIngredient5,
//                strIngredient6= details.strIngredient6,
//                strIngredient7= details.strIngredient7,
//                strIngredient8= details.strIngredient8,
//                strIngredient9= details.strIngredient9,
//                 strIngredient10= details.strIngredient10,
//                strIngredient11= details.strIngredient11,
//                strIngredient12= details.strIngredient12,
//                 strIngredient13= details.strIngredient13,
//                 strIngredient14= details.strIngredient14,
//                 strIngredient15= details.strIngredient15,
//                 strInstructions= details.strInstructions,
//                 strInstructionsDE= details.strInstructionsDE,
//                 strInstructionsES= details.strInstructionsES,
//                 strInstructionsFR= details.strInstructionsFR,
//                 strInstructionsIT= details.strInstructionsIT,
//                strInstructionsZH_HANS=details.strInstructionsZH_HANS,
//                strInstructionsZH_HANT=details.strInstructionsZH_HANT,
//                strMeasure1= details.strMeasure1,
//                strMeasure2= details.strMeasure2,
//                strMeasure3= details.strMeasure3,
//                 strMeasure4= details.strMeasure4,
//                 strMeasure5= details.strMeasure5,
//                 strMeasure6= details.strMeasure6,
//                 strMeasure7= details.strMeasure7,
//                 strMeasure8= details.strMeasure8,
//                 strMeasure9= details.strMeasure9,
//                 strMeasure10= details.strMeasure10,
//                 strMeasure11= details.strMeasure11,
//                 strMeasure12= details.strMeasure12,
//                 strMeasure13= details.strMeasure13,
//                 strMeasure14= details.strMeasure14,
//                strMeasure15= details.strMeasure15,
//                 strTags= details.strTags,
//                 strVideo=details.strVideo
//                )
//                favoriteDrinkRepository.addMyFavoriteDrinks(drinkDetailsEntity)
//            }
//        }
//    }
}
