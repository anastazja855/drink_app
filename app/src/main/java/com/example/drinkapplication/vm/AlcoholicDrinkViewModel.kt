package com.example.drinkapplication.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.drinkapplication.network.CocktailApi
import com.example.drinkapplication.repository.AlcoholicDrinkSource
import com.example.drinkapplication.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlcoholicDrinkViewModel
@Inject constructor(
    private val datasource: AlcoholicDrinkSource,
) : ViewModel() {

    val flow= Pager(
        PagingConfig(pageSize = 100)
    ) {
        datasource
    }.flow.cachedIn(viewModelScope)

}