package com.example.drinkapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.vm.CocktailListViewModel
import com.skydoves.landscapist.glide.GlideImage
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
fun CocktailListScreen(
    navController: NavHostController,
    viewModel: CocktailListViewModel = hiltViewModel(),
) {
    val list = viewModel.flow.collectAsLazyPagingItems()
    LazyColumn {
        items(list) {drink ->
            drink?.let { drinkItem ->
                DrinkItemCard(
                    drinkItem,
                    navController,
                onAddToFavorites = { viewModel.addFavoriteDrink(drinkItem) }
                )

            }
        }
    }
}

@Composable
fun DrinkItemCard(
    drink: Drink,
    navController: NavHostController,
    onAddToFavorites: suspend (Drink) -> Unit
) {
    val padding = 12.dp
    val coroutineScope = rememberCoroutineScope()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .fillMaxHeight(0.3f)
    ) {
        Row() {
            Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                GlideImage(
                    imageModel = drink.strDrinkThumb ?: "No photo available",
                    contentScale = ContentScale.Inside,
                    contentDescription = "My image",
                    modifier = Modifier
                        .clickable(onClick = {
                            navController.navigate("drinkInfo/${drink.idDrink}")
                        })
                        .padding(4.dp)
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.9f)
                )
                Text(
                    text = drink.strDrink,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Column(modifier = Modifier.clip(RoundedCornerShape(5.dp))) {
                val interactionSource = remember { MutableInteractionSource() }
                val isPressed by interactionSource.collectIsPressedAsState()

                Button(
                    onClick = { /* do something */ },
                    interactionSource = interactionSource
                ) {
                    Text(if (isPressed) "Pressed!" else "Not pressed")
                }

                Button(
                    onClick = {
                        coroutineScope.launch {
                            onAddToFavorites(drink)
                        }
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
                        contentDescription = "Add to Favorites",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.Blue
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Add to Favorites")
                }

                Spacer(Modifier.size(padding))

                Button(
                    onClick = {
                        navController.navigate("drinkInfo/${drink.idDrink}")
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
                        contentDescription = "Drink details",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Learn more")
                }
            }
        }
    }
}
