package com.taknikiniga.canvaspractice.lession

import androidx.collection.intIntMapOf
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.drawText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun Lession4(modifier: Modifier = Modifier) {
    val colorBg = Color(0xFF2C3141)
    val colors =
        listOf(
            Color(0xFFFF595A),
            Color(0xFFFFC766),
            Color(0xFF35A07F),
            Color(0xFF35A07F),
            Color(0xFFFFC766),
            Color(0xFFFF595A)
        )

    val gradient = Brush.sweepGradient(colors = colors)

    val infiniteTransition = rememberInfiniteTransition(label = "InfiniteTransition")

//    val animatedColor by infiniteTransition.animateColor(
//        initialValue = colorBg,
//        targetValue = Color(0xFF35A07F),
//        animationSpec = infiniteRepeatable(
//            animation = tween(2000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )

    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = LinearEasing
            ), repeatMode = RepeatMode.Restart
        )
    )


    androidx.compose.foundation.Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp).padding(16.dp)
    ) {
        drawRoundRect(
            color = colorBg,
            size = Size(
                size.width - 2.dp.toPx(),
                size.height - 2.dp.toPx(),
            ), cornerRadius = CornerRadius(20f), style = Stroke(10f)
        )
        rotate(angle) {
            drawCircle(brush = gradient, radius = size.width, blendMode = BlendMode.SrcIn)
        }


//        drawRoundRect(
//            color = animatedColor,
//            size = Size(size.width - 2.dp.toPx(), size.height - 2.dp.toPx())
//        )


    }


}


@Preview
@Composable
fun PreviewLession4(modifier: Modifier = Modifier) {
    Lession4()
}