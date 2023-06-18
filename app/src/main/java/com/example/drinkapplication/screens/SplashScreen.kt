package com.example.drinkapplication.screens


import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.drinkapplication.ui.theme.myTheme.MyHeadline_1
import com.example.drinkapplication.ui.theme.myTheme.MyHeadline_splashscreen
import com.example.tmsapp2.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    SplashScreenContent()
    LaunchedEffect(Unit) {
        delay(1500)
        navController.navigate("select_category_screen")
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreenContent() {

    Scaffold { tt ->
        tt
        var editable by remember { mutableStateOf(true) }


        Box(modifier = Modifier.fillMaxSize()) {
            Column() {

                AnimatedVisibility(
                    visible = editable,
                    enter = fadeIn(),
                    exit = slideOutVertically() + shrinkVertically() + fadeOut()
                ) {
                    Column() {
                        MyHeadline_1(R.string.its_time)
                        MyHeadline_splashscreen(textResId = R.string.drink)


                    Image(
                        painter = painterResource(id = R.drawable.glassphoto),
                        contentDescription = "splashscreenbackground",
                        modifier = Modifier.fillMaxWidth().fillMaxSize(0.6f),
                        contentScale = ContentScale.FillBounds
                    )
                    }
                }

            }

        }
    }
}