package com.example.drinkapplication.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.screens.drinkInfo.DrinkInfoViewModel
import com.example.drinkapplication.ui.theme.myTheme.DrinkNameHeadLine
import com.example.drinkapplication.ui.theme.myTheme.RedHatDisplay_14_stringRes
import com.example.drinkapplication.ui.theme.myTheme.RedHatDisplay_14_text
import com.example.drinkapplication.ui.theme.myTheme.RedHatDisplay_24_stringRes
import com.example.tmsapp2.R
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkInfoScreen(
    navController: NavHostController,
    viewModel: DrinkInfoViewModel = hiltViewModel(),
    idDrink: String
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.drink_item_background),
            contentDescription = "background_image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        LaunchedEffect(idDrink) {
            val additionalData = viewModel.fetchAdditionalData(idDrink)
            additionalData?.let {
                viewModel.setDrinkInfo(it)
            }
        }

        val drinkInfo by viewModel.drinkInfo.observeAsState()

        drinkInfo?.let {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
            ) {
                item {
                    ShowDrinkInfo(drink = it)
                }
            }
        }
    }
}


@Composable
fun ShowDrinkInfo(
    drink: DrinkDetails,
    viewModel: DrinkInfoViewModel = hiltViewModel()
) {
    val ctx = LocalContext.current

    drink?.strDrink?.let { Log.d("Show drink info screen", it) }
    Column() {
        DrinkNameHeadLine(text = drink.strDrink ?: "")
        DrinkTags(drink)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp), contentAlignment = Alignment.Center
        ) {

            GlideImage(
                imageModel = drink?.strDrinkThumb ?: "No photo available",
                contentScale = ContentScale.Inside,
                contentDescription = "My image",
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.8f)
                    .clip(RoundedCornerShape(30.dp))
            )
        }
        RedHatDisplay_24_stringRes(textResId = R.string.ingredients)
        DrinkIngredientTable(drink)
        RedHatDisplay_24_stringRes(textResId = R.string.instructions)
        ShowInstruction(drink)
        Button(
            onClick = {
                val text = R.string.added_to_favorites
                Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()
                Log.d("Favorite button click", drink.strDrink ?: "")
                viewModel.addDrinkToFavorites(drink.toDrink(drink))
                //viewModel.addFavoriteDrink(drink)
            }, contentPadding = PaddingValues(
                start = 20.dp, top = 12.dp, end = 20.dp, bottom = 12.dp
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


    }

}


@Composable
fun DrinkIngredientTable(drink: DrinkDetails) {
    val padding = 8.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row() {
            Text(text = drink.strIngredient1 ?: "")
            Text(text = drink.strMeasure1 ?: "")
        }
        Row() {
            Text(text = drink.strIngredient2 ?: "")
            Text(text = drink.strMeasure2 ?: "")
        }
        Row() {
            Text(text = drink.strIngredient3 ?: "")
            Text(text = drink.strMeasure3 ?: "")
        }
        Row() {
            Text(text = drink.strIngredient4 ?: "")
            Text(text = drink.strMeasure4 ?: "")
        }
        Row() {
            Text(text = drink.strIngredient5 ?: "")
            Text(text = drink.strMeasure5 ?: "")
        }


    }

}

@Composable
fun DrinkTags(drink: DrinkDetails) {
    val padding = 8.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row() {
            RedHatDisplay_14_stringRes(textResId = R.string.serve)
            RedHatDisplay_14_text(text = drink.strGlass ?: "")
        }
        Row() {
            RedHatDisplay_14_stringRes(textResId = R.string.tag)
            RedHatDisplay_14_text(text = drink.strAlcoholic ?: "")
        }
    }

}

@Composable
fun ShowInstruction(drink: DrinkDetails) {
    Text(text = drink.strInstructions ?: "")
}

//@Preview(showBackground = true)
//@Composable
//fun ShowDrinkInfoPreview() {
//    Column() {
//
//        ShowDrinkInfo(
//            drink = Drink(
//                "11007",
//                "Margarita",
//                "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
//                "Tequila",
//                "Triple sec",
//                "Lime juice",
//                "Salt",
//                "1 1/2 oz",
//                "1/2 oz",
//                "1 oz",
//                "1/2 oz",
//                "1 oz",
//
//
//
//            )
//        )
//    }
//}