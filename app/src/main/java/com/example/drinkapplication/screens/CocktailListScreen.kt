package com.example.drinkapplication.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.vm.CocktailListViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CocktailListScreen(viewModel: CocktailListViewModel, navController: NavHostController) {
    val list = viewModel.flow.collectAsLazyPagingItems()
    LazyColumn {
        items(list) {
            it?.let { drink ->
                DrinkItemCard(
                    drink, navController)
            }
        }
    }
}

@Composable
fun DrinkItemCard(drink: Drink = Drink(
    "no id",
    "no name",
    "https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg")
    , navController: NavHostController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .fillMaxHeight(0.3f)
            .clickable { "drinkInfo/{cocktailId}" }

    ) {
        Column() {

            Button(
                onClick = { /* Handle click on button 2 */ },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("My")
            }
            Button(
                onClick = { /* Handle click on button 2 */ },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Hero details",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Learn more")
            }
        }
        Text(
            text = drink.strDrink,
            modifier = Modifier
                .padding(start = 16.dp)
        )
        GlideImage(
            imageModel = drink.strDrinkThumb ?: "No photo available",
            contentScale = ContentScale.Inside,
            contentDescription = "My image",
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        )

    }

}

//@Preview(showBackground = true)
//@Composable
//fun DrinkItemCardPreview() {
//    DrinkItemCard(
//        drink = Drink(
//            "15346",
//            "155 Belmont",
//            "https://www.thecocktaildb.com/images/media/drink/yqvvqs1475667388.jpg"
//        )
//    )
//
//}