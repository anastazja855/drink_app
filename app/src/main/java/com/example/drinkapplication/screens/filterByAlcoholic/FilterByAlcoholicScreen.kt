package com.example.drinkapplication.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drinkapplication.ui.theme.myTheme.MyHeadline_1
import com.example.drinkapplication.ui.theme.myTheme.RedHatDisplay_18
import com.example.drinkapplication.ui.theme.myTheme.SquareButtonWithImageAndText
import com.example.drinkapplication.screens.filterByAlcoholic.FilterByAlcoholicViewModel
import com.example.tmsapp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterByAlcoholicScreen(
    navController: NavHostController,
    viewModel: FilterByAlcoholicViewModel = hiltViewModel(),
) {

//val internetState by viewModel.internetState.collectAsState()
//
//    val currentInternetState = IsInternetConnectedState(internetState)
//    Scaffold(topBar = {
//            NoInternetConnectionTopBar(visible = currentInternetState) }){padding ->

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.filter_by_alcoholic_background),
            contentDescription = "background_image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column() {

            val padding = 12.dp

            // MyHeadline_1(R.string.search_headline)
            MyHeadline_1(textResId = R.string.choose_category_headline)
            RedHatDisplay_18(R.string.categories_text)
            SquareButtonWithImageAndText(image = R.drawable.non_alcoholic_image,
                stringResource = R.string.all_cocktails,
                onClick = {
                    navController.navigate("cocktail_list")
                },
                backgroundColor = colorResource(id = R.color.orange_light))

            Spacer(Modifier.size(padding))

            SquareButtonWithImageAndText(R.drawable.alcoholic_image,
                stringResource = R.string.alcoholic_text,
                onClick = {
                    Log.d("Alcoholic button click", "")
                    navController.navigate("alcoholic_category")
                },
                backgroundColor = colorResource(id = R.color.orange_light))

            Spacer(Modifier.size(padding))

            SquareButtonWithImageAndText(image = R.drawable.non_alcoholic_image,
                stringResource = R.string.non_alcoholic,
                onClick = {
                    navController.navigate("non_alcoholic_category")
                },
                backgroundColor = colorResource(id = R.color.orange_light))


        }
    }
}

