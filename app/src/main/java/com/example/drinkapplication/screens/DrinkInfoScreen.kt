package com.example.drinkapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.vm.DrinkViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DrinkInfoScreen(
    viewModel: DrinkViewModel, 
    navController: NavHostController
){
    val drinkInfo by viewModel.drinkInfo.observeAsState()
    
    drinkInfo?.let { 
        ShowDrinkInfo(drink = it)
    }
}

@Composable
fun ShowDrinkInfo(drink: Drink){
    GlideImage(
        imageModel = drink.strDrinkThumb ?: "No photo available",
        contentScale = ContentScale.Inside,
        contentDescription = "My image",
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    )
    
}