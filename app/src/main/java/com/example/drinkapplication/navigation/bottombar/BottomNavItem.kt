package com.example.drinkapplication.navigation.bottombar

import com.example.tmsapp2.R

sealed class BottomNavItem(val title: String, val icon: Int, val screen_route: String) {
    object Favorite : BottomNavItem("My drinks", R.drawable.favorite_icon, "favorite")
    object Home: BottomNavItem("Home", R.drawable.shape, "select_category_screen")
    object Search: BottomNavItem("Search", R.drawable.search_icon_new, "search")
}