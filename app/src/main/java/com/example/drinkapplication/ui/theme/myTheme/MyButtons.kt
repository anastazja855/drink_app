package com.example.drinkapplication.ui.theme.myTheme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SquareButtonWithImageAndText(
    @DrawableRes
    image: Int,
    @StringRes stringResource: Int,
    onClick: () -> Unit,
    backgroundColor: Color
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(),
        contentAlignment = Alignment.Center) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .size(height = 150.dp, width = 200.dp)
            .clip(RoundedCornerShape(8.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            )
            RedHatDisplay_18 (stringResource)
        }
    }
    }
}
