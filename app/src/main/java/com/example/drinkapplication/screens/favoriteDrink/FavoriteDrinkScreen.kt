package com.example.drinkapplication.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drinkapplication.model.DrinkDetailsEntity
import com.example.drinkapplication.screens.favoriteDrink.FavoriteDrinkViewModel

@Composable
fun FavoriteDrinkScreen(navController: NavHostController,
                        viewModel: FavoriteDrinkViewModel = hiltViewModel()
) {
    val isDrinkFavoriteState by viewModel.uiState.collectAsState()

    val favoriteDrinks by viewModel.favoriteDrinks.observeAsState(emptyList())
    Log.d("FavoriteDrinkScreen", "Favorite Drinks: $favoriteDrinks")
    Column(modifier = Modifier.fillMaxSize()) {
        favoriteDrinks.forEach { drink ->
           // val isFavorite = isDrinkInFavorites(drink)

            FavoriteDrinkItem(drink = drink, onDelete = { deletedDrink ->
                viewModel.deleteFavoriteDrink(deletedDrink)
            })
        }
    }
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed (favoriteDrinks) { index, drink ->
                FavoriteDrinkItem(drink){
                    viewModel.deleteFavoriteDrink(it)
                }
            }
        }
    }



@Composable
fun FavoriteDrinkItem(drink: DrinkDetailsEntity, onDelete: (DrinkDetailsEntity) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = drink.strDrink ?: "", style = TextStyle(fontSize = 18.sp))
            Button(
                onClick = { onDelete(drink) },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 8.dp)
            ) {
                Text(text = "Delete")
            }
        }
    }
}