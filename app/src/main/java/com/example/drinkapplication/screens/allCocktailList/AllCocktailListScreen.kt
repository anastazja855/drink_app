package com.example.drinkapplication.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.uistate.ErrorUI
import com.example.drinkapplication.uistate.LoadingUI
import com.example.drinkapplication.screens.allCocktailList.AllCocktailListViewModel
import com.example.drinkapplication.ui.theme.myTheme.RedHatDisplay_16
import com.example.tmsapp2.R
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllCocktailListScreen(
    navController: NavHostController,
    viewModel: AllCocktailListViewModel = hiltViewModel(),
    //favoriteDrinkRepository:FavoriteDrinkRepository,
) {
    val list = viewModel.flow.collectAsLazyPagingItems()

    val isLoading = viewModel.isLoading.value
    val isError = viewModel.isError.value


    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading) {
            LoadingUI()
        } else if (isError) {
            ErrorUI()
        } else {
            LazyColumn() {
                item { Spacer(modifier = Modifier.height(8.dp)) }

                items(list) { drink ->
                    drink?.let { drinkItem ->
                        DrinkItemCard(
                            drinkItem,
                            viewModel,
                            navController,
                        )
                    }
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.isLoading.value = true
        try {
            viewModel.loadCocktailList()
            viewModel.isLoading.value = false
        } catch (e: Exception) {
            viewModel.isLoading.value = false
            viewModel.isError.value = true
        }
    }
}

@Composable
fun DrinkItemCard(
    drink: Drink,
    viewModel: AllCocktailListViewModel = hiltViewModel(),
    navController: NavHostController,
    //favoriteHelper: FavoriteHelper
    //favoriteDrinkRepository : FavoriteDrinkRepository,
    //onAddToFavorites: (DrinkDetailsEntity) -> Unit
) {
    val padding = 12.dp
    val coroutineScope = rememberCoroutineScope()
    val borderColor = colorResource(R.color.orange)
    //val isFavoriteState= remember { mutableStateOf<List<Boolean>>() }

//    LaunchedEffect(Unit) {
//        val _favorite = favoriteDrinkHelper.isFavorite(drink.idDrink)
//
//    }
//
//    val iconTint = if (isFavorite) {
//        Color.Blue // Set the color to blue if the drink is already a favorite
//    } else {
//        Color.White // Set the color to white if the drink is not a favorite
//    }
    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, borderColor, shape = RoundedCornerShape(30.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .background(Color.White)
                .fillMaxHeight(0.3f)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .clip(RoundedCornerShape(19.dp))
            ) {
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

            }

            Column(modifier = Modifier.clip(RoundedCornerShape(5.dp))) {
                RedHatDisplay_16(drink.strDrink ?: "")

                Button(
                    onClick = {
                        Log.d("Favorite button click", drink.strDrink ?: "")
                        viewModel.addFavoriteDrink(drink)
                    }, contentPadding = PaddingValues(
                        start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp
                    )
                ) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Add to Favorites",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                        tint = Color.White
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Add to Favorites")
                }

                Spacer(Modifier.size(padding))

                Button(
                    onClick = {
                        coroutineScope.launch {
                            //val drinkDetails = viewModel.fetchAdditionalData(idDrink)
                            Log.d(
                                "Learn more button click",
                                drink?.strDrink ?: "No thumbnail available"
                            )
                            navController.navigate("drinkInfo/${drink.idDrink}")
                        }
                    }, contentPadding = PaddingValues(
                        start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp
                    )
                ) {
                    Text("Learn more")
                }
            }
        }
    }
}


