package com.example.drinkapplication.screens.search

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.network.CocktailApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailSearchListViewModel
@Inject constructor(
    private val cocktailApi: CocktailApi,
) : ViewModel() {


    val searchResults = MutableLiveData<List<DrinkDetails>?>()

    fun searchCocktailByName(query: String): MutableLiveData<List<DrinkDetails>?> {
        viewModelScope.launch(Dispatchers.IO) {
            val response = cocktailApi.searchCocktails(query)
            if (response.isSuccessful) {
                val cocktailList = response.body()?.drinks
                searchResults.postValue(cocktailList)
            } else {
                searchResults.postValue(emptyList())
            }
        }
        return searchResults
    }
}