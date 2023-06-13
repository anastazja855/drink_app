package com.example.drinkapplication.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drinkapplication.model.Drink
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.vm.DrinkViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DrinkInfoScreen(
    navController: NavHostController,
    viewModel: DrinkViewModel = hiltViewModel(),
    idDrink: String
) {



    LaunchedEffect(idDrink) {
        val additionalData = viewModel.fetchAdditionalData(idDrink)
        additionalData?.let {
            viewModel.setDrinkInfo(it)
        }
    }

        val drinkInfo by viewModel.drinkInfo.observeAsState()

    drinkInfo?.let {
        ShowDrinkInfo(drink = it)
    }
}

@Composable
fun ShowDrinkInfo(drink: DrinkDetails) {

    drink?.strDrink?.let { Log.d("Show drink info screen", it) }
    Column(modifier = Modifier.clip(RoundedCornerShape(5.dp))) {

        Text(text = drink.strDrink?:"")
        DrinkIngredientTable(drink) }

        GlideImage(
            imageModel = drink?.strDrinkThumb ?: "No photo available",
            contentScale = ContentScale.Inside,
            contentDescription = "My image",
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f)
                .clip(RoundedCornerShape(5.dp))
        )

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
            Text(text = drink.strIngredient1?:"")
            Text(text = drink.strMeasure1?:"")
        }

        
    }
    
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
//            )
//        )
//    }
//}