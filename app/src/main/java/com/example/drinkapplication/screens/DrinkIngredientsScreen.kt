package com.example.drinkapplication.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.drinkapplication.ui.theme.myTheme.RedHatDisplay_24_stringRes
import com.example.tmsapp2.R
import com.skydoves.landscapist.glide.GlideImage
import kotlinx.coroutines.launch

@Composable
fun DrinkIngredientsScreen(
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
            ShowIngredientTable(drinkInfo, viewModel, navController)
            //DrinkIngredientTableLong(drinkInfo)
            //ShowDrinkInfo(drink = it, viewModel, navController)
        }
    }

}

@Composable
fun ShowIngredientTable(
    drink: DrinkDetails?,
    viewModel: DrinkInfoViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val coroutineScope = rememberCoroutineScope()
    val ctx = LocalContext.current

    drink?.strDrink?.let { Log.d("Show drink info screen", it) }
    Column() {
        DrinkNameHeadLine(text = drink?.strDrink ?: "")
        //DrinkTags(drink)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp), contentAlignment = Alignment.Center
        ) {
        }

        Row() {
            RedHatDisplay_24_stringRes(textResId = R.string.ingredients)
        }
        DrinkIngredientTableLong(drink)

        Button(
            onClick = {
                val text = R.string.added_to_favorites
                Toast.makeText(ctx, text, Toast.LENGTH_SHORT).show()
                Log.d("Favorite button click", drink?.strDrink ?: "")
                if (drink != null) {
                    viewModel.addDrinkToFavorites(drink.toDrink(drink))
                }
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
fun DrinkIngredientTableLong(drink: DrinkDetails?) {
    val padding = 8.dp
    Column(
        Modifier
            .padding(padding)
            .fillMaxWidth()
    ) {
        DrinkIngredientTableLine(drink?.strIngredient1, drink?.strMeasure1)
        DrinkIngredientTableLine(drink?.strIngredient2, drink?.strMeasure2)
        if (!drink?.strIngredient3.isNullOrBlank() && !drink?.strMeasure3.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient3, drink?.strMeasure3)
        }
        if (!drink?.strIngredient4.isNullOrBlank() && !drink?.strMeasure4.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient4, drink?.strMeasure4)
        }
        if (!drink?.strIngredient5.isNullOrBlank() && !drink?.strMeasure5.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient5, drink?.strMeasure5)
        }
        if (!drink?.strIngredient6.isNullOrBlank() && !drink?.strMeasure6.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient6, drink?.strMeasure6)
        }
        if (!drink?.strIngredient7.isNullOrBlank() && !drink?.strMeasure7.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient7, drink?.strMeasure7)
        }
        if (!drink?.strIngredient8.isNullOrBlank() && !drink?.strMeasure8.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient8, drink?.strMeasure8)
        }
        if (!drink?.strIngredient9.isNullOrBlank() && !drink?.strMeasure9.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient9, drink?.strMeasure9)
        }
        if (!drink?.strIngredient10.isNullOrBlank() && !drink?.strMeasure10.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient10, drink?.strMeasure10)
        }
        if (!drink?.strIngredient11.isNullOrBlank() && !drink?.strMeasure11.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient11, drink?.strMeasure11)
        }
        if (!drink?.strIngredient12.isNullOrBlank() && !drink?.strMeasure12.isNullOrBlank()) {
            DrinkIngredientTableLine(drink?.strIngredient12, drink?.strMeasure12)
        }

    }

}