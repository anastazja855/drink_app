package com.example.drinkapplication.vm

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.network.DrinkRepository
import com.example.drinkapplication.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val repository: CocktailRepository,
    private val idDrink: String
) : ViewModel() {
    private val _drinkInfo = MutableLiveData<Drink>()
    val drinkInfo: LiveData<Drink> = _drinkInfo

    init {
        viewModelScope.launch {
            val response = repository.getDrinkInfo(idDrink)
            if (response.isSuccessful) {
                response.body()?.drinks?.get(0)?.let {
                    _drinkInfo.postValue(it)
                }
            }
        }

    }
}