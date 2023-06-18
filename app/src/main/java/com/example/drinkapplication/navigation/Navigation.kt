package com.example.drinkapplication.navigation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.drinkapplication.screens.AlcoholicListScreen
import com.example.drinkapplication.screens.AllCocktailListScreen
import com.example.drinkapplication.screens.DrinkInfoScreen
import com.example.drinkapplication.screens.FavoriteDrinkScreen
import com.example.drinkapplication.screens.FilterByAlcoholicScreen
import com.example.drinkapplication.screens.NonAlcoholicListScreen
import com.example.drinkapplication.screens.SearchScreen
import com.example.drinkapplication.screens.SplashScreen
import com.example.drinkapplication.navigation.bottombar.BottomNavItem
import com.example.drinkapplication.navigation.bottombar.MyBottomNavigation

enum class NavType{
    HOME,
    FAVORITES,
    SEARCH
}
@Composable
fun Navigation(
    navController: NavHostController,
) {
    val navItemState = rememberSaveable { mutableStateOf(NavType.HOME) }

    Scaffold(
        bottomBar = {
            if (navController.currentDestination?.route != "splash_screen") {
                MyBottomNavigation(navController = navController, navItemState = navItemState)
            }
        }
    )
    { padding ->
        NavHost(
            navController = navController,
            startDestination = "splash_screen"
        ) {
            composable(route = "splash_screen") {
                SplashScreen(navController = navController)
            }
//            composable(route = "main") {
//                MainScreen(navController)
//            }
            composable(route = "select_category_screen")
            {
                FilterByAlcoholicScreen(navController)
            }
            composable(route = "cocktail_list") {
                AllCocktailListScreen(navController)
            }
            composable("drinkInfo/{idDrink}") { backStackEntry ->
                val cocktailId = backStackEntry.arguments?.getString("idDrink")
                cocktailId?.let {
                    DrinkInfoScreen(navController = navController, idDrink = it)
                }
            }

            composable("alcoholic_category") {
                AlcoholicListScreen(navController)
            }
            composable("non_alcoholic_category") {
                NonAlcoholicListScreen(navController)
            }

            composable("favorite_drink") {
                FavoriteDrinkScreen(navController)
            }
            composable("search_screen"){
                SearchScreen()
            }
            composable(BottomNavItem.Home.screen_route)
            {
                when (navItemState.value) {
                    NavType.HOME -> FilterByAlcoholicScreen(navController = navController)
                    NavType.FAVORITES -> FavoriteDrinkScreen(navController = navController)
                    NavType.SEARCH -> SearchScreen()
                }
            }
            composable(BottomNavItem.Search.screen_route) {
                when (navItemState.value) {
                    NavType.HOME -> FilterByAlcoholicScreen(navController = navController)
                    NavType.FAVORITES -> FavoriteDrinkScreen(navController = navController)
                    NavType.SEARCH -> SearchScreen()
                }
            }
            composable("error") {
                when (navItemState.value) {
                    NavType.HOME -> FilterByAlcoholicScreen(navController = navController)
                    NavType.FAVORITES -> FavoriteDrinkScreen(navController = navController)
                    NavType.SEARCH -> SearchScreen()
                }
            }

        }
    }
}