package com.example.drinkapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.example.drinkapplication.screens.topbar.SearchView
import com.example.drinkapplication.screens.topbar.TopSearchBar

@Composable
fun SearchScreen() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column() {
        SearchView(textState)
        Text(text = "In progress")

    }
}