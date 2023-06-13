package com.example.drinkapplication.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drinkapplication.vm.AlcoholicDrinkViewModel

@Composable
fun FilterByAlcoholic(navController: NavHostController,
                      viewModel: AlcoholicDrinkViewModel = hiltViewModel(),) {
    val padding = 12.dp
    val strAlcoholic:String


        Column (modifier = Modifier.clip(RoundedCornerShape(5.dp))) {
            Button(
                onClick = {
                    Log.d("All cocktails", "")
                    navController.navigate("cocktail_list")
                },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = padding,
                    end = 20.dp,
                    bottom = padding
                )
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "All cocktails",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.Blue
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("All cocktails")
            }

            Spacer(Modifier.size(padding))

            Button(
                onClick = {
                    Log.d("Alcoholic button click", "")
                    navController.navigate("alcoholic_category")
                },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Alcoholic",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.Blue
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Alcoholic")
            }

            Spacer(Modifier.size(padding))

            Button(
                onClick = {
                    navController.navigate("non_alcoholic_category")
                },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Non-alcoholic",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Non-alcoholic")
            }
        }

    }

