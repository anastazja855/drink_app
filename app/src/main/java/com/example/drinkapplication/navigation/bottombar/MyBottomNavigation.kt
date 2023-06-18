package com.example.drinkapplication.navigation.bottombar


import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.drinkapplication.navigation.NavType


@Composable
fun MyBottomNavigation(navController: NavHostController, navItemState: MutableState<NavType>) {

    val items = listOf(
        BottomNavItem.Favorite,
        BottomNavItem.Home,
        BottomNavItem.Search
    )

    androidx.compose.material.BottomNavigation(
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination
        BottomNavigation {

        items.forEach { item ->
            BottomNavigationItem(icon = {
                Icon(
                    painterResource(id = item.icon),
                    contentDescription = item.title
                )
            },
                label = {
                    Text(
                        text = item.title, fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.5f),
                alwaysShowLabel = true,
                selected = currentRoute?.route == item.screen_route,
                onClick = {
                    when (item.screen_route) {
                        "select_category_screen" -> navController.navigate("select_category_screen")
                        "favorite" -> navController.navigate("favorite_drink")
                        "search" -> navController.navigate("search_screen")
                    }
                    Log.d("Screen_route", navItemState.value.toString())
                }
            )
        }
        }
    }
}


