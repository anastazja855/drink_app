package com.example.drinkapplication.screens.topbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drinkapplication.model.DrinkDetails
import com.example.drinkapplication.vm.CocktailSearchListViewModel
import java.util.Locale


@Composable
fun CocktailSearchList(navController: NavHostController,
                       viewModel: CocktailSearchListViewModel = hiltViewModel(),
                       state: MutableState<TextFieldValue>) {
    val contentPadding = 12.dp

var filteredCocktails: ArrayList<DrinkDetails>
    val searchResult by viewModel.searchResults.observeAsState()
    val searchedText = state.value.text

    LaunchedEffect(searchedText) {
        viewModel.searchCocktailByName(searchedText)
    }

filteredCocktails = if (searchedText.isEmpty()) ({
    searchResult
}) as ArrayList<DrinkDetails> else{
    var resultList = ArrayList<DrinkDetails>()
    for (cocktail in searchResult!!){
        cocktail.strDrink?.let {
            strDrink ->
            if (strDrink.lowercase(Locale.getDefault())
                    .contains(searchedText.lowercase(Locale.getDefault()))
            ){
                resultList.add(cocktail)
            }
        }
    }
resultList
}

    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .padding(contentPadding)){

        searchResult?.let {
           items (filteredCocktails){
                   filteredCocktail ->
               CocktailSearchResult(
                   strDrink = filteredCocktail.strDrink,
                   onItemClick = {selectedCocktail -> navController.navigate(
                       "selected_cocktail_search_result/{strDrink}")
                   {
                       popUpTo("cocktail_list") {
                           saveState = true
                       }
                       launchSingleTop = true
                       restoreState = true
                   }
                   }
               )
           }
        }
    }
}

@Composable
fun CocktailSearchResult(
    strDrink: String?,
    onItemClick: (String) -> Unit
) {
    val padding = 4.dp
    Row(modifier = Modifier
        .clickable(onClick = { strDrink?.let { onItemClick(it) } })
        .fillMaxWidth()
        .fillMaxHeight(0.1f)
        .padding(top = padding)
    ) {
//        com.skydoves.landscapist.glide.GlideImage(
//            imageModel = drink.strDrinkThumb ?: "No photo available",
//            contentScale = ContentScale.Inside,
//            contentDescription = "My image",
//            modifier = Modifier
//                .clickable(onClick = {
//                    navController.navigate("drinkInfo/${drink.idDrink}")
//                })
//                .padding(4.dp)
//                .fillMaxWidth(0.4f)
//                .fillMaxHeight()
//        )
        Text( text = strDrink ?: "",
            modifier = Modifier.
                padding(start = 16.dp))

    }
}

//@Preview(showBackground = true)
//@Composable
//fun CocktailSearchResultPreview() {
//    val navController = rememberNavController() // Replace with your NavHostController
//    val drinkDetails = DrinkDetails(
//        "2015-08-18 14:42:59",
//        "11007",
//        "Alcoholic",
//        "Ordinary Drink",
//        "Yes",
//        "Margarita",
//        "",
//        "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
//        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
//        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
//        "", "", "", "", "", "", "",
//    )
//
//    CocktailSearchResult(drinkDetails, navController)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CocktailSearchListPreview() {
//    val navController = NavHostController(LocalContext.current)
//    val viewModel = CocktailSearchListViewModel()
//    val state = remember { mutableStateOf(TextFieldValue("")) }
//
//    CocktailSearchList(navController, viewModel, state)
//}
