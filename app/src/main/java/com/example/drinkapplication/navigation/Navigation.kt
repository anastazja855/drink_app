package com.example.drinkapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.drinkapplication.screens.AlcoholicListScreen
import com.example.drinkapplication.screens.CocktailListScreen
import com.example.drinkapplication.screens.DrinkInfoScreen
import com.example.drinkapplication.screens.FilterByAlcoholic
import com.example.drinkapplication.screens.NonAlcoholicListScreen
import com.example.drinkapplication.screens.SelectedDrinkDetails
import com.example.drinkapplication.screens.SplashScreen

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
        composable("select_category_screen")
            { FilterByAlcoholic(navController)
                }


        composable("alcoholic_category"){
            AlcoholicListScreen(navController)

        }
        composable("non_alcoholic_category"){
            NonAlcoholicListScreen(navController)
        }
//        composable("test_drink_screen"){
//            ShowDrinkInfoPreview()
//        }

    }
}