package com.slaviboy.features.homeScreen.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.buttonTextColor

@Composable
fun Button(
    backgroundColor: Color,
    @StringRes textResId: Int,
    onClickListener: () -> Unit = {}
) {
    Spacer(modifier = Modifier.height(0.05.dw))
    androidx.compose.material.Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.12.dw),
        onClick = onClickListener,
        shape = RoundedCornerShape(0.3.dw),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
    ) {
        Text(
            stringResource(id = textResId).uppercase(),
            fontFamily = NotoSansFont,
            fontSize = 0.035.sw,
            fontWeight = FontWeight.Normal,
            color = buttonTextColor
        )
    }
    Spacer(modifier = Modifier.height(0.05.dw))
}