package com.example.drinkapplication.screens.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun TopSearchBar(
navHostController: NavHostController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column() {
        SearchView(textState)
        CocktailSearchList(navHostController, state =textState )

    }
}

@Preview(showBackground = true)
@Composable
fun TopSearchBarPreview() {

    val navController: NavHostController = rememberNavController()
    TopSearchBar(navHostController = navController, )

}