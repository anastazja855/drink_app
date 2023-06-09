package com.example.drinkapplication.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.drinkapplication.repository.FavoriteDrinkRepository
import com.example.drinkapplication.screens.CocktailListScreen
import com.example.drinkapplication.screens.DrinkInfoScreen
import com.example.drinkapplication.screens.ShowDrinkInfoPreview
import com.example.drinkapplication.screens.SplashScreen
import com.example.drinkapplication.vm.CocktailListViewModel
import com.example.drinkapplication.vm.DrinkViewModel

@Composable
fun Navigation(
    navController: NavHostController,

) {
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable(route = "splash_screen"){
            SplashScreen(navController = navController)
        }
        composable(route = "cocktail_list") {
            CocktailListScreen(navController)
        }
        composable("drinkInfo/{idDrink}") { backStackEntry ->
            val cocktailId = backStackEntry.arguments?.getString("idDrink")
            cocktailId?.let {
                DrinkInfoScreen(navController = navController, idDrink = it)
            }
        }
        composable("test_drink_screen"){
            ShowDrinkInfoPreview()
        }

    }
}