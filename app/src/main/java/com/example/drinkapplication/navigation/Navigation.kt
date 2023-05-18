package com.example.drinkapplication.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.drinkapplication.screens.CocktailListScreen
import com.example.drinkapplication.screens.DrinkInfoScreen
import com.example.drinkapplication.vm.CocktailListViewModel
import com.example.drinkapplication.vm.DrinkViewModel

@Composable
fun Navigation (navController: NavHostController,
viewModel: ViewModel
){
    NavHost(navController = navController,
        startDestination = "cocktail_list"){
        composable(route = "cocktail_list"){
            CocktailListScreen (viewModel as CocktailListViewModel, navController)
        }
        composable("drinkInfo/{cocktailId}") { backStackEntry ->
            val cocktailId = backStackEntry.arguments?.getString("cocktailId")
            DrinkInfoScreen(viewModel as DrinkViewModel, navController)
        }

    }
}