package com.example.drinkapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.drinkapplication.ui.theme.redHatDisplayFont
import com.example.tmsapp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {

//    Column() {
//    Text(
//        text = stringResource(R.string.search_headline),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(start = 19.dp, end = 19.dp),
//        fontFamily = redHatDisplayFont,
//        fontSize = 18.sp,
//    )
//    Spacer(modifier = Modifier.padding(12.dp))
    TopAppBar (
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        modifier = Modifier.background(color = colorResource(id = R.color.white)),
            )
    //}
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}