package com.example.drinkapplication.ui.theme.myTheme

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.drinkapplication.ui.theme.redHatDisplayFont
import com.example.tmsapp2.R

@Composable
fun MyHeadline_1(@StringRes textResId:Int) {
    val text = stringResource(textResId)
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(),
        contentAlignment = Alignment.Center
    ){
        Text (text = text, fontSize = 34.sp, fontFamily = redHatDisplayFont,
            lineHeight = 34.sp,
            modifier = Modifier.padding(vertical = 16.dp))
    }
}

@Composable
fun RedHatDisplay_18 (@StringRes textResId:Int) {
    val text = stringResource(textResId)
    Box(modifier = Modifier
        .wrapContentSize(),
    ){
        Text (text = text, fontSize = 18.sp, fontFamily = redHatDisplayFont,
            fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun MyHeadline_splashscreen(@StringRes textResId:Int) {
    val text = stringResource(textResId)
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(),
        contentAlignment = Alignment.Center
    ){
        Text (text = text, fontSize = 70.sp, fontFamily = redHatDisplayFont,
            color = colorResource(id = R.color.orange),
            lineHeight = 44.sp,
            modifier = Modifier.padding(vertical = 16.dp))
    }
}

@Composable
fun RedHatDisplay_16 (text:String) {
    Box(modifier = Modifier
        .wrapContentSize(),
    ){
        Text (text = text,
            modifier = Modifier.padding(start = 16.dp),
            fontSize = 16.sp, fontFamily = redHatDisplayFont,
            color = colorResource(id = R.color.text_color_black),
            lineHeight = 27.sp,
            fontWeight = FontWeight.SemiBold)
    }
}

@Preview
@Composable
fun MyHeadline_1_Preview() {
    val textResId =R.string.choose_category_headline
    MyHeadline_1(textResId)
}