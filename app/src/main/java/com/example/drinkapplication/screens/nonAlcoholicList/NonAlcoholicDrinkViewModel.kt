package com.example.drinkapplication.screens.nonAlcoholicList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.drinkapplication.repository.NonAlcoholicDrinkSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NonAlcoholicDrinkViewModel @Inject constructor(
    datasource: NonAlcoholicDrinkSource
): ViewModel (){
    val flow= Pager(
        PagingConfig(pageSize = 100)
    ) {
        datasource
    }.flow.cachedIn(viewModelScope)

}