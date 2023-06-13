package com.example.drinkapplication.screens.topbar


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment.Companion.Rectangle
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmsapp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(value = state.value,
        onValueChange = {
            value ->
            state.value=value
        },
    modifier = Modifier.
    fillMaxWidth(),
    textStyle = TextStyle(color = Color.Black, fontSize = 18.sp),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "",
            modifier = Modifier
                .padding(15.dp)
                .size(24.dp))
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")){
                IconButton(onClick = {state.value = TextFieldValue("")
                }
                ) {
                    Icon(Icons.Default.Close, contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.text_color_black),
            cursorColor = colorResource(id = R.color.light_gray_color),
            focusedLeadingIconColor = colorResource(id = R.color.light_gray_color),
            unfocusedIndicatorColor = colorResource(id = R.color.light_gray_color),
            focusedTrailingIconColor = colorResource(id = R.color.light_gray_color),
            unfocusedLabelColor = colorResource(id = R.color.light_gray_color),
            containerColor = colorResource(id = R.color.white),
        )
    )
}

@Preview (showBackground = true)
@Composable
fun SearchViewPreview() {
    val textState = remember{ mutableStateOf(TextFieldValue("")) }
    SearchView(textState)

}
