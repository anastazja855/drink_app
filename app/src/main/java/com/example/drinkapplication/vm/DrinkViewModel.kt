package com.example.drinkapplication.vm

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.network.DrinkRepository
import com.example.drinkapplication.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val repository: CocktailRepository
) : ViewModel() {
    private val _drinkInfo = MutableLiveData<Drink>()
    val drinkInfo: LiveData<Drink> = _drinkInfo



    fun getDrinkInfo(idDrink:String) {
        viewModelScope.launch {
            val response = repository.getDrinkInfo(idDrink)
            if (response.isSuccessful) {
                response.body()?.drinks?.firstOrNull()?.let {
                    _drinkInfo.postValue(it)
                }
            }
        }

    }
}