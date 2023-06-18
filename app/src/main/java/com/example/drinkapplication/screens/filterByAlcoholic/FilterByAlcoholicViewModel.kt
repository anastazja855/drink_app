package com.example.drinkapplication.screens.filterByAlcoholic

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.drinkapplication.network.CocktailApi
import com.example.drinkapplication.repository.AlcoholicDrinkSource
import com.example.drinkapplication.repository.FavoriteDrinkRepository
import com.example.drinkapplication.controller.NetworkController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterByAlcoholicViewModel
@Inject constructor(
    private val datasource: AlcoholicDrinkSource,
    private val cocktailApi: CocktailApi,
    private val favoriteDrinkRepository: FavoriteDrinkRepository,
    private val networkController: NetworkController
) : ViewModel() {

//    val _internetState = MutableStateFlow(networkController)
//    val internetState = _internetState.asStateFlow()

    val isLoading = mutableStateOf<Boolean>(false)
    val isError = mutableStateOf<Boolean>(false)

    val flow = Pager(
        PagingConfig(pageSize = 100)
    ) {
        datasource
    }.flow.cachedIn(viewModelScope)

    private suspend fun fetchAlcoholicDrinks() {
        isLoading.value = true
        try {
            val response = cocktailApi.getAlcoholicDrinks()
            if (response.isSuccessful) {
                val cocktailList = response.body()
            } else {
                isError.value = true
            }
        } catch (e: Exception) {
            isError.value = true
        } finally {
            isLoading.value = false
        }
    }

    fun loadAlcoholicDrinks() {
        viewModelScope.launch {
            fetchAlcoholicDrinks()
        }
    }

}