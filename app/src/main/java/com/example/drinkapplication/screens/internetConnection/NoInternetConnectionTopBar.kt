package com.example.drinkapplication.screens.internetConnection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.drinkapplication.ui.theme.myTheme.RedHatDisplay_18
import com.example.tmsapp2.R


@Composable
fun NoInternetConnectionTopBar(visible: Boolean) {
    if (visible) {
        Box(
            modifier = Modifier
                .fillMaxWidth().background(color = Color.Red)
                .wrapContentSize(),
            contentAlignment = Alignment.Center
        ) {
            RedHatDisplay_18(R.string.no_internet_connection)
        }
    }
}