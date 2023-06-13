package com.example.drinkapplication.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarMain (val route: String, val title: String, val icon: ImageVector){
    object Home : BottomBarMain("home", "Home", Icons.Default.Home)
}