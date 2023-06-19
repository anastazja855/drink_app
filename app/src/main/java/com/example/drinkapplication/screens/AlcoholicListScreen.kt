package com.example.drinkapplication.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.uistate.ErrorUI
import com.example.drinkapplication.uistate.LoadingUI
import com.example.drinkapplication.screens.filterByAlcoholic.FilterByAlcoholicViewModel
import com.example.tmsapp2.R
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@Composable
fun AlcoholicListScreen(
    navController: NavHostController,
    viewModel: FilterByAlcoholicViewModel = hiltViewModel()
) {
    val list = viewModel.flow.collectAsLazyPagingItems()
    val isLoading = viewModel.isLoading.value
    val isError = viewModel.isError.value

    Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(id = R.drawable.drinklist_background),
            contentDescription = "background_image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        LaunchedEffect(Unit) {
            viewModel.isLoading.value = true
            try {
                viewModel.loadAlcoholicDrinks()
                viewModel.isLoading.value = false
            } catch (e: Exception) {
                viewModel.isLoading.value = false
                viewModel.isError.value = true
            }
        }

        if (isLoading) {
            LoadingUI()
        } else if (isError) {
            ErrorUI()
        } else {

            LazyColumn(modifier = Modifier.padding(12.dp)) {
                items(list) { drink ->
                    drink?.let { drinkItem ->
                        AlcoholicDrinkItemCard(
                            drinkItem,
                            navController,

                            )
                    }
                }
            }
        }
    }

}

@Composable
fun AlcoholicDrinkItemCard(
    drink: Drink,
    navController: NavHostController,

    ) {
    val padding = 12.dp
    val coroutineScope = rememberCoroutineScope()
    val ctx = LocalContext.current

    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .fillMaxHeight(0.3f)
    ) {
        Row() {
            Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                Text(
                    text = drink.strDrink ?: "",
                    modifier = Modifier.padding(start = 16.dp)
                )
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

                Button(
                    onClick = {
                        val text = R.string.added_to_favorites
                        Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()
                        Log.d("Favorite button click", drink.strDrink ?: "")
//                        viewModel.addFavoriteDrink(drink)
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
                        coroutineScope.launch {
                            //val drinkDetails = viewModel.fetchAdditionalData(idDrink)
                            Log.d(
                                "Learn more button click",
                                drink?.strDrink ?: "No thumbnail available"
                            )
                            navController.navigate("drinkInfo/${drink.idDrink}")
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

