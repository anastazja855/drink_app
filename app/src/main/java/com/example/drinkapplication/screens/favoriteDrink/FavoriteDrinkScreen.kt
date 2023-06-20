package com.example.drinkapplication.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drinkapplication.model.DrinkDetailsEntity
import com.example.drinkapplication.screens.favoriteDrink.FavoriteDrinkViewModel
import com.example.tmsapp2.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun FavoriteDrinkScreen(
    navController: NavHostController,
    viewModel: FavoriteDrinkViewModel = hiltViewModel()
) {
    val isDrinkFavoriteState by viewModel.uiState.collectAsState()

    val favoriteDrinks by viewModel.favoriteDrinks.observeAsState(emptyList())
    Log.d("FavoriteDrinkScreen", "Favorite Drinks: $favoriteDrinks")
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.drinklist_background),
            contentDescription = "background_image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(favoriteDrinks) { index, drink ->
                FavoriteDrinkItem(drink, navController) {
                    viewModel.deleteFavoriteDrink(it)
                }
            }
        }
    }
}


@Composable
fun FavoriteDrinkItem(drink: DrinkDetailsEntity,
                      navController: NavHostController,
                      onDelete: (DrinkDetailsEntity) -> Unit, ) {
    val ctx = LocalContext.current
    val paddind_8dp = 8.dp

    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = paddind_8dp)
            .clickable { navController.navigate("drinkInfo/${drink.idDrink}" )},
        colors = CardDefaults.outlinedCardColors(colorResource(id = R.color.orange_light).copy(0.6f)),
        border = BorderStroke(1.dp, colorResource(id = R.color.orange))
        //White.copy(alpha = 0.8f)

        ) {
        Row() {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(paddind_8dp)
                    .clip(RoundedCornerShape(19.dp))
            ) {
                GlideImage(
                    imageModel = drink.strDrinkThumb ?: "No photo available",
                    contentScale = ContentScale.Inside,
                    contentDescription = "My image",
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.9f)
                )
            }


            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = drink.strDrink ?: "", style = TextStyle(fontSize = 18.sp))
                Button(
                    onClick = {
                        val text = R.string.delete
                        Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()
                        onDelete(drink) },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 8.dp)
                ) {
                    Text(text = "Delete")
                }
            }
        }
    }
}
